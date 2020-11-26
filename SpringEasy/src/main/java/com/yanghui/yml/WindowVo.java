package com.yanghui.yml;

import com.alibaba.fastjson.JSONObject;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class WindowVo implements Serializable {
    private String id;
    private String title;
    private String data;
    private JSONObject timeField;
    private List<JSONObject> measureFields;
    private String describe;
    private String type;
    private String template;
    private String createUser;
    private String createTime;
    private String created;
    private String updated;
    private String screenshot;
    private String group;
    private boolean isInner;
    private boolean isTemp;
    private boolean used;
    private List<NodeTempParameter> parameter;
}
