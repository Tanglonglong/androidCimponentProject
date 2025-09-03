package com.example.modulejokes.bean;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class JokesResponse extends BaseResponse {
    @SerializedName("result")
    private ResBean result;

    public static class ResBean {
        private List<JokesBean> data;

        public List<JokesBean> getData() {
            return data;
        }

        public void setData(List<JokesBean> data) {
            this.data = data;
        }
    }

    public ResBean getResult() {
        return result;
    }

    public void setResult(ResBean result) {
        this.result = result;
    }
}
