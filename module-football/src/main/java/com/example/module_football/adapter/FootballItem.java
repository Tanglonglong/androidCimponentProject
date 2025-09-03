package com.example.module_football.adapter;

import com.example.module_football.bean.FootballMatchBean;

public class FootballItem {

    private int type =1; //0:父列表 1 子列表
    private String date;
    private String week;
    private FootballMatchBean cItem;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

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

    public FootballMatchBean getcItem() {
        return cItem;
    }

    public void setcItem(FootballMatchBean cItem) {
        this.cItem = cItem;
    }

    @Override
    public String toString() {
        return "FootballItem{" +
                "type=" + type +
                ", date='" + date + '\'' +
                ", week='" + week + '\'' +
                ", cItem=" + cItem +
                '}';
    }
}
