package com.yanghui.jackson;

import lombok.Data;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Data
public class DataSetFilter {
    private List<String> resource;
    private List<String> resourceClass;
    private List<String> target;
    private List<String> requiredFields;
  //  private List<Condition> condition;
   // private TimeParmar time;
    private String[] childWindowIds;
    private String filterType;
  //  private MoldFilter mold;
   // private GisFilter gis;
  //  private BlockFilter block;
   // private DatabankFilter databank;
    private String apiKey;


}
