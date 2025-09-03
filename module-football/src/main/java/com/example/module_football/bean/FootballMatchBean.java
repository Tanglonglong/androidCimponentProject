package com.example.module_football.bean;


public class FootballMatchBean {

    private String time_start;
    private String status;
    private String status_text;
    private String team1;
    private String team2;
    private String team1_score;
    private String team2_score;
    private String team1_logo;
    private String team2_logo;
    private String match_stage;

    public String getTime_start() {
        return time_start;
    }

    public void setTime_start(String time_start) {
        this.time_start = time_start;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus_text() {
        return status_text;
    }

    public void setStatus_text(String status_text) {
        this.status_text = status_text;
    }

    public String getTeam1() {
        return team1;
    }

    public void setTeam1(String team1) {
        this.team1 = team1;
    }

    public String getTeam2() {
        return team2;
    }

    public void setTeam2(String team2) {
        this.team2 = team2;
    }

    public String getTeam1_score() {
        return team1_score;
    }

    public void setTeam1_score(String team1_score) {
        this.team1_score = team1_score;
    }

    public String getTeam2_score() {
        return team2_score;
    }

    public void setTeam2_score(String team2_score) {
        this.team2_score = team2_score;
    }

    public String getTeam1_logo() {
        return team1_logo;
    }

    public void setTeam1_logo(String team1_logo) {
        this.team1_logo = team1_logo;
    }

    public String getTeam2_logo() {
        return team2_logo;
    }

    public void setTeam2_logo(String team2_logo) {
        this.team2_logo = team2_logo;
    }

    public String getMatch_stage() {
        return match_stage;
    }

    public void setMatch_stage(String match_stage) {
        this.match_stage = match_stage;
    }

    @Override
    public String toString() {
        return "FootballMatchBean{" +
                "time_start='" + time_start + '\'' +
                ", status='" + status + '\'' +
                ", status_text='" + status_text + '\'' +
                ", team1='" + team1 + '\'' +
                ", team2='" + team2 + '\'' +
                ", team1_score='" + team1_score + '\'' +
                ", team2_score='" + team2_score + '\'' +
                ", team1_logo='" + team1_logo + '\'' +
                ", team2_logo='" + team2_logo + '\'' +
                ", match_stage='" + match_stage + '\'' +
                '}';
    }
}

