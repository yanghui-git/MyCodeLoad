package com.yanghui.yml;

import com.alibaba.fastjson.JSON;
import lombok.Data;

import java.util.List;
import java.util.Objects;

/**
 * 导出报表的信息
 */
@Data
public class ExportYaml {

    /**
     * widget信息
     */
    List<WidgetVo> widgetVoList;


    /**
     * 自身图表信息
     */
    WindowVo windowVo;

}
