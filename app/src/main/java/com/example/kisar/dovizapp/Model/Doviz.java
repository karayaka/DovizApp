package com.example.kisar.dovizapp.Model;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

/**
 * Created by kisar on 24.06.2019.
 */

public class Doviz implements Serializable {
    private String name;
    private String code;
    private double todayLowestBuyPrice;
    private double todayHighestBuyPrice;
    private double todayLowestSellPrice;
    private double todayHighestSellPrice;
    private double yesterdayClosingBuyPrice;
    private double yesterdayClosingSellPrice;
    private double buyPrice;
    private double sellPrice;
    private double dailyChange;
    private double dailyChangePercentage;
    private String lastUpdateDate;

    public Doviz() {
    }

    public Doviz(String name, String code, double todayLowestBuyPrice, double todayHighestBuyPrice,
                 double todayLowestSellPrice, double todayHighestSellPrice, double yesterdayClosingBuyPrice,
                 double yesterdayClosingSellPrice, double buyPrice, double sellPrice, double dailyChange,
                 double dailyChangePercentage, String lastUpdateDate) {
        this.setName(name);
        this.setCode(code);
        this.setTodayLowestBuyPrice(todayLowestBuyPrice);
        this.setTodayHighestBuyPrice(todayHighestBuyPrice);
        this.setTodayLowestSellPrice(todayLowestSellPrice);
        this.setTodayHighestSellPrice(todayHighestSellPrice);
        this.setYesterdayClosingBuyPrice(yesterdayClosingBuyPrice);
        this.setYesterdayClosingSellPrice(yesterdayClosingSellPrice);
        this.setBuyPrice(buyPrice);
        this.setSellPrice(sellPrice);
        this.setDailyChange(dailyChange);
        this.setDailyChangePercentage(dailyChangePercentage);
        this.setLastUpdateDate(lastUpdateDate);
    }





    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public double getTodayLowestBuyPrice() {
        return todayLowestBuyPrice;
    }

    public void setTodayLowestBuyPrice(double todayLowestBuyPrice) {
        this.todayLowestBuyPrice = todayLowestBuyPrice;
    }

    public double getTodayHighestBuyPrice() {
        return todayHighestBuyPrice;
    }

    public void setTodayHighestBuyPrice(double todayHighestBuyPrice) {
        this.todayHighestBuyPrice = todayHighestBuyPrice;
    }

    public double getTodayLowestSellPrice() {
        return todayLowestSellPrice;
    }

    public void setTodayLowestSellPrice(double todayLowestSellPrice) {
        this.todayLowestSellPrice = todayLowestSellPrice;
    }

    public double getTodayHighestSellPrice() {
        return todayHighestSellPrice;
    }

    public void setTodayHighestSellPrice(double todayHighestSellPrice) {
        this.todayHighestSellPrice = todayHighestSellPrice;
    }

    public double getYesterdayClosingBuyPrice() {
        return yesterdayClosingBuyPrice;
    }

    public void setYesterdayClosingBuyPrice(double yesterdayClosingBuyPrice) {
        this.yesterdayClosingBuyPrice = yesterdayClosingBuyPrice;
    }

    public double getYesterdayClosingSellPrice() {
        return yesterdayClosingSellPrice;
    }

    public void setYesterdayClosingSellPrice(double yesterdayClosingSellPrice) {
        this.yesterdayClosingSellPrice = yesterdayClosingSellPrice;
    }

    public double getBuyPrice() {
        return buyPrice;
    }

    public void setBuyPrice(double buyPrice) {
        this.buyPrice = buyPrice;
    }

    public double getSellPrice() {
        return sellPrice;
    }

    public void setSellPrice(double sellPrice) {
        this.sellPrice = sellPrice;
    }

    public double getDailyChange() {
        return dailyChange;
    }

    public void setDailyChange(double dailyChange) {
        this.dailyChange = dailyChange;
    }

    public double getDailyChangePercentage() {
        return dailyChangePercentage;
    }

    public void setDailyChangePercentage(double dailyChangePercentage) {
        this.dailyChangePercentage = dailyChangePercentage;
    }

    public String getLastUpdateDate() {
        return lastUpdateDate;
    }

    public void setLastUpdateDate(String lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }


}
