package pers.sl.shoppingsenter.entity;

public class User {
    int user_id;
    String user_name;
    String user_password;
    int user_score;
    int user_power;

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_password() {
        return user_password;
    }

    public void setUser_password(String user_password) {
        this.user_password = user_password;
    }

    public int getUser_score() {
        return user_score;
    }

    public void setUser_score(int user_score) {
        this.user_score = user_score;
    }

    public int getUser_power() {
        return user_power;
    }

    public void setUser_power(int user_power) {
        this.user_power = user_power;
    }

    @Override
    public String toString() {
        return "user [user_id=" + user_id + ", user_name=" + user_name
                + ", user_password=" + user_password + ", user_score="
                + user_score + ", user_power=" + user_power + "]";
    }

}
