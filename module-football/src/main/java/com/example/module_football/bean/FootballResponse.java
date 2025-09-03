package com.example.module_football.bean;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class FootballResponse extends BaseResponse {
    @SerializedName("result")
    private ResBean result;

    public static class ResBean {
        private String title;
        private List<TimeMatchBean> matchs;
        private String duration;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public List<TimeMatchBean> getMatchs() {
            return matchs;
        }

        public void setMatchs(List<TimeMatchBean> matchs) {
            this.matchs = matchs;
        }

        public String getDuration() {
            return duration;
        }

        public void setDuration(String duration) {
            this.duration = duration;
        }
    }

    public ResBean getResult() {
        return result;
    }

    public void setResult(ResBean result) {
        this.result = result;
    }
}
