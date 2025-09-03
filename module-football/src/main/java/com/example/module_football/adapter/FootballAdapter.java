package com.example.module_football.adapter;

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
import com.example.module_football.R;
import java.util.List;

public class FootballAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final int TYPE_HEADER = 0;
    private static final int TYPE_ITEM = 1;

    private Context mContext;

    private OnItemClickListener mListener;
    private List<FootballItem> mData;

    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    public FootballAdapter(Context context, @Nullable List<FootballItem> data) {
        this.mContext = context;
        this.mData = data;
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.mListener = listener;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == TYPE_HEADER) {
            return new HeaderViewHolder(LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.football_m_header, parent, false));
        } else {
            return new ItemViewHolder(LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.football_m_child, parent, false));
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        FootballItem fBean = mData.get(position);
        if (holder instanceof HeaderViewHolder) {
            ((HeaderViewHolder) holder).match_time_tv.setText(fBean.getDate()
                    + " " + fBean.getWeek());
        } else {
            ItemViewHolder itemViewHolder = ((ItemViewHolder) holder);
            itemViewHolder.time_tv.setText(fBean.getcItem().getTime_start());
            itemViewHolder.stage_tv.setText(fBean.getcItem().getMatch_stage());
            itemViewHolder.team1_tv.setText(fBean.getcItem().getTeam1());
            itemViewHolder.team2_tv.setText(fBean.getcItem().getTeam2());
            itemViewHolder.score_tv.setText(fBean.getcItem().getTeam1_score() + " - " +
                    fBean.getcItem().getTeam2_score());
            itemViewHolder.state_tv.setText(fBean.getcItem().getStatus_text());

            Glide.with(mContext)
                    .load(fBean.getcItem().getTeam1_logo())
                    .placeholder(R.mipmap.football_m_ic_launcher_round)
                    .error(R.mipmap.football_m_ic_launcher_round)
                    .into(itemViewHolder.team1_iv);
            Glide.with(mContext)
                    .load(fBean.getcItem().getTeam2_logo())
                    .placeholder(R.mipmap.football_m_ic_launcher_round)
                    .error(R.mipmap.football_m_ic_launcher_round)
                    .into(itemViewHolder.team2_iv);

        }
    }

    @Override
    public int getItemViewType(int position) {

        return mData.get(position).getType();

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class HeaderViewHolder extends RecyclerView.ViewHolder {

        public TextView match_time_tv;

        public HeaderViewHolder(View view) {
            super(view);
            match_time_tv = view.findViewById(R.id.match_time_tv);
        }
    }

    public static class ItemViewHolder extends RecyclerView.ViewHolder {
        public TextView time_tv, mach_name_tv, stage_tv, score_tv, team1_tv, team2_tv,state_tv;
        public ImageView team1_iv, team2_iv;

        public ItemViewHolder(View view) {
            super(view);
            time_tv = view.findViewById(R.id.time_tv);
            mach_name_tv = view.findViewById(R.id.mach_name_tv);
            stage_tv = view.findViewById(R.id.stage_tv);
            score_tv = view.findViewById(R.id.score_tv);
            team1_tv = view.findViewById(R.id.team1_tv);
            team2_tv = view.findViewById(R.id.team2_tv);
            team1_iv = view.findViewById(R.id.team1_iv);
            team2_iv = view.findViewById(R.id.team2_iv);
            state_tv = view.findViewById(R.id.state_tv);
        }
    }
}
