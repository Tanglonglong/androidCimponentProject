package com.example.module_football.bean;

import java.util.List;

public class TimeMatchBean {

    private String date;
    private String week;

    private List<FootballMatchBean> list;


    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getWeek() {
        return week;
    }

    public void setWeek(String week) {
        this.week = week;
    }

    public List<FootballMatchBean> getList() {
        return list;
    }

    public void setList(List<FootballMatchBean> list) {
        this.list = list;
    }
}
