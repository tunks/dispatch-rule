package com.att.dispatch.rule.process;

import com.att.dispatch.rule.process.Compute;

/**
 * This class was automatically generated by the data modeler tool.
 */

public class ComputeFactory implements java.io.Serializable {

    public static Compute newAnalysisSeries(String type){
           if(type == "TURF_SERIES" || type == "TURF_REGION_SERIES"){
              return new TurfSeries();
            }else{
              return new GroupSeries();
            }
     }
}