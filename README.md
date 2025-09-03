# androidCimponentProject
android 组件化+componentization


组件架构图如下


<img width="521" height="471" alt="Android组件化架构" src="https://github.com/user-attachments/assets/49bc48c6-05be-47a9-9664-32ff8277da07" />


效果图  数据都是来自聚合数据的免费接口，一天只能访问50次

https://github.com/user-attachments/assets/fa4f2127-44f6-4dfe-a948-007edb6577d2




目录结构如下


<img width="323" height="532" alt="57cb214b-9fc8-4ab7-804a-0e3ba62a785e" src="https://github.com/user-attachments/assets/2a258b7c-9345-403e-9675-37b8b9cacb6e" />


模块代码说明：


library-base 公共模块


主要是定义全局application接口，子业务模块集成，最后在主壳里面通过反射初始化子模块的application，这边还可以通过依赖注入，和自己写一个gradle插件，配置，后期有时间会实现一下


library-network 基础模块


此模块主要是通过Rxjava + refit +okhttp实现的网络请求api，对外提供baseUrl改变需要新的接口api，通过工厂模式对外提供


module-news 业务模块 --可独立运行调试


module-jokes 业务模块 --可独立运行调试


module-football 业务模块 --可独立运行调试



gradle 配置说明：


用的Groovy‌  本来用的DSL ，在用DSL时，他的插件配置价值时序严格了导致，plugins里面无法访问变量了，所以用Groovy

gradle主要就 三个，一个是全局配置版本，依赖的config.gradle,一个是library的一个是module 这些都是提出公共的达到复用，和解决版本冲突



总结：
组件化架构的几个基本需要解决的问题
首先对于组件化，要理解一个qpp的打包，合并方式：一个app只有一个application所以要解决模块application和主的合并，manifest的合并规则，
资源不能重名因为打包资源是不会通过包名区分的都打在一起；
1. 公共、基础、业务的划分要尽量解耦，高内聚 低耦合
2. gradle的配置，达到每个业务模块能快速动态切换moudle、和单独app调试开发
3. 在每个业务要做成组件的基本要素，模板化，新增模块就很快
4. 组件之间跳转传值，目前用的就是阿里的ARout，封装的挺好，也很全，就没自己写，其实原理就是注解，动态注入、自己有时间其实可以写个gradle插件更加自动化一点



代码基本说明：


<img width="521" height="549" alt="233c4460-054d-4890-90cf-d2c83515e066" src="https://github.com/user-attachments/assets/18122d56-a92f-49c2-8134-f28130b90b23" />


isModuleLibrary=true  全局变量来动态切换 当前是业务模块单独运行调试，还是整体
module gradle 里面如下判断
if (isModuleLibrary.toBoolean()) {
    apply plugin: 'com.android.library'
} else {
    apply plugin: 'com.android.application'
}


<img width="484" height="397" alt="122af9d0-6039-428f-b29b-1fc729189c05" src="https://github.com/user-attachments/assets/232a0409-eaa0-4e5d-82c1-4cd705a2ff42" />


每个业务模块要添加资源前缀检测，尽量以模块名为前缀


通过反射初始化每个模块的application
 public static String[] sInitApplicationPackage = {
            "com.example.basenetwork.NetWorkInit",
            "com.example.newsmodule.ApplicationInit",
            "com.example.modulejokes.ApplicationInit",
            "com.example.module_football.ApplicationInit"};

主application里的处理，这边可以将MyApplication所有方法映射初始化子模块的
public class MyApplication extends BaseApplication {


    @Override
    public void onCreate() {
        super.onCreate();
        /**
         *
         * 这边需要调用每个模块的application的一些初始化等操作
         * 这边通过反射、和依赖注入等方式  自己写个gradle插件
         *
         * 1.反射实现，就需要知道每个模块的初始化类的路径，所以这边需要维护一个每个组件的初始化路径
         * 2.通过依赖注入实现
         * 3.通过自定义注解来实现
         * 4.自己写个gradle插件来自动维护
         *
         *
         *
         * **/

        System.out.println("主模块");
        ReflectionInitApplication.getInstance(this).initOnCreate();

    }

    @Override
    public void onConfigurationChanged(@NonNull Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        ReflectionInitApplication.getInstance(this).initOnConfigurationChanged(newConfig);
    }
}



 application onCreate
    
    public void initOnCreate() {
        for (String item : sInitApplicationPackage) {
            if (classMap.containsKey(item)) classMap.get(item).onCreate(mApplication);
            else {
                IModuleApplicationInit init = getInitClass(item);
                if (!classMap.containsKey(item)) {
                    classMap.put(item, init);
                }
                init.onCreate(mApplication);
            }
        }
    }

    反射拿到模块的初始化application接口
      private IModuleApplicationInit getInitClass(String item) {
        Class<?> clazz = null;
        try {
            clazz = Class.forName(item);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        IModuleApplicationInit init = null;
        try {
            init = (IModuleApplicationInit) clazz.newInstance();
        } catch (IllegalAccessException | InstantiationException e) {
            throw new RuntimeException(e);
        }
        return init;
    }


其他的各位自己可以摸索了





