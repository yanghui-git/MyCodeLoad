package com.yanghui.jackson;

import lombok.Data;

import javax.websocket.Session;
import java.util.List;
import java.util.Map;

@Data
public class WSParmas {
    /**
     * 组件绑定的数据集id,如果是模具则是数据源id
     */
    private String id;
    /**
     * 组件绑定的数据通道
     */
    private String sequence;
    /**
     * 组件大类型：chart、mold、gis、childAlert、Databank、group
     */
    private String widgetType;
    /**
     * 组件类型
     */
    private String chartType;
    /**
     * 数据的展示方式：实时数据（realtime）、全量数据（full）
     */
    private String dataType;
    /**
     * 数据集的过滤条件
     */
    private Object filterStr;
    /**
     * 视图展示模式：编辑（edit）、预览（preview）
     */
    private String mode;
    /**
     * websocket监听时间：新增（add）、移除（remove）...
     */
    private String listener;
    /**
     * group 多个组件规则
     */
    private List<WSParmas> group;
    /**
     * 视图id
     */
    private String windowId;
    /**
     * 视图名称
     */
    private String windowName;
    /**
     * 多屏控制传输内容
     */
    private String content;

    private Session session;
    private String sessionId;
    private DataSetFilter filter;
    private Map config;
    private String apiKey;
    private String tenantId;
    private String refreshTime;
    //DataBank 查询Url
    private String url;
    /**
     * 时间间格
     */
    private String timer;
    //redis数据订阅
}
