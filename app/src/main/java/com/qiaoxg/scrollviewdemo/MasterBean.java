package com.qiaoxg.scrollviewdemo;

/**
 * Created by Qiaoxg on 2018/5/10.
 */

public class MasterBean {

    private String userName;
    private String mobile;
    private String shopGrade;
    private String IconUrl;
    private String joinTime;
    private String money;
    private String count;
    private String id;
    private String peopleCount;//人气

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getIconUrl() {
        return IconUrl;
    }

    public void setIconUrl(String iconUrl) {
        IconUrl = iconUrl;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getShopGrade() {
        return shopGrade;
    }

    public void setShopGrade(String shopGrade) {
        this.shopGrade = shopGrade;
    }

    public String getJoinTime() {
        return joinTime;
    }

    public void setJoinTime(String joinTime) {
        this.joinTime = joinTime;
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPeopleCount() {
        return peopleCount;
    }

    public void setPeopleCount(String peopleCount) {
        this.peopleCount = peopleCount;
    }
}
