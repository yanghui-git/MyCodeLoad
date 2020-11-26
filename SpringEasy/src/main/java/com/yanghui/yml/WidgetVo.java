package com.yanghui.yml;

import com.alibaba.fastjson.JSONObject;

import java.io.Serializable;

public class WidgetVo implements Serializable {

    private String id;
    private String blockId;
    private String buuid;
    private String dataId;
    private String groupId;

    private JSONObject chart;
    private JSONObject dataSetting;
    private JSONObject setting;
    private JSONObject styleSetting;
    private JSONObject mobileLayout;
    private JSONObject extraSetting;

    private double col;
    private double row;
    private String sizex;
    private String sizey;
    private double x;
    private double y;
    private double width;
    private double height;

    private int isInner;

    public JSONObject getMobileLayout() {
        return mobileLayout;
    }

    public void setMobileLayout(JSONObject mobileLayout) {
        this.mobileLayout = mobileLayout;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBlockId() {
        return blockId;
    }

    public void setBlockId(String blockId) {
        this.blockId = blockId;
    }

    public String getBuuid() {
        return buuid;
    }

    public void setBuuid(String buuid) {
        this.buuid = buuid;
    }

    public String getDataId() {
        return dataId;
    }

    public void setDataId(String dataId) {
        this.dataId = dataId;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public JSONObject getChart() {
        return chart;
    }

    public void setChart(JSONObject chart) {
        this.chart = chart;
    }

    public JSONObject getDataSetting() {
        return dataSetting;
    }

    public void setDataSetting(JSONObject dataSetting) {
        this.dataSetting = dataSetting;
    }

    public JSONObject getSetting() {
        return setting;
    }

    public void setSetting(JSONObject setting) {
        this.setting = setting;
    }

    public JSONObject getStyleSetting() {
        return styleSetting;
    }

    public void setStyleSetting(JSONObject styleSetting) {
        this.styleSetting = styleSetting;
    }

    public double getCol() {
        return col;
    }

    public void setCol(double col) {
        this.col = col;
    }

    public double getRow() {
        return row;
    }

    public void setRow(double row) {
        this.row = row;
    }

    public String getSizex() {
        return sizex;
    }

    public void setSizex(String sizex) {
        this.sizex = sizex;
    }

    public String getSizey() {
        return sizey;
    }

    public void setSizey(String sizey) {
        this.sizey = sizey;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public int getIsInner() {
        return isInner;
    }

    public void setIsInner(int isInner) {
        this.isInner = isInner;
    }

    public JSONObject getExtraSetting() {
        return extraSetting;
    }

    public void setExtraSetting(JSONObject extraSetting) {
        this.extraSetting = extraSetting;
    }
}
