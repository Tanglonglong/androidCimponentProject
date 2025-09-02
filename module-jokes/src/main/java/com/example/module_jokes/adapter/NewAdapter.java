package com.example.module_jokes.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.example.module_jokes.R;
import com.example.module_jokes.bean.JokesBean;
import com.example.module_jokes.bean.JokesResponse;

import java.util.List;

public class NewAdapter extends RecyclerView.Adapter<NewAdapter.ViewHolder> {

    private Context mContext;

    private OnItemClickListener mListener;
    private List<JokesBean> mData;

    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    public NewAdapter(Context context, @Nullable List<JokesBean> data) {
        this.mContext = context;
        this.mData = data;
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.mListener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.jokes_m_news_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        JokesBean newBean = mData.get(position);
        holder.tv_jokes.setText(newBean.getContent());
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView tv_jokes;

        public ViewHolder(View view) {
            super(view);
            tv_jokes = view.findViewById(R.id.tv_jokes);
        }
    }
}
