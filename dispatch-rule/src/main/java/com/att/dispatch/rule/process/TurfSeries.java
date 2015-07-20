/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.att.dispatch.rule.process;

import com.att.dispatch.rule.model.Group;
import com.att.dispatch.rule.model.Turf;
import com.att.dispatch.rule.process.TurfSeries.Value;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * class to compute and generate turf series for analytics
 * 
 * @author ebrima
 */
public class TurfSeries implements Compute<List, String> {

   List<Series> results;

    public TurfSeries() {
        results = new ArrayList();
    }
    
    /* performs the computation*/
    @Override
    public void compute(List object) {
        List<Turf> list = object;
        List<String> keys = new ArrayList();
        Iterator<Turf> turfs = list.iterator();
        
        //generate keys
        while (turfs.hasNext()) {
            Turf turf = turfs.next();
            keys.addAll(generateKeys(keys, turf));
        }
        
        //generate series
        for(String key : keys){
            Series item = new Series();
             item.key = key;
             for(Turf turf: list){
                 Group group = turf.getGroups().get(key);
                if(turf.getTotalNumberOfJobs() > 0){
                    if(group != null){
                      item.values.add(new Value(turf.getName(),group.getValue())); 
                    }else{
                      item.values.add(new Value(turf.getName(),0)); 
                    }
                 }
             }
             results.add(item);
        }    
    }

  private List<String> generateKeys(List<String> keys, Turf turf){ 
         List<String> list = new ArrayList();
         Iterator<String> iter = turf.getGroups().keySet().iterator();
         while(iter.hasNext()){
              String key = iter.next();
              if(!keys.contains(key)){
                  list.add(key);
              }          
         }
        return list;
    }

    /* returns the computation results */
    @Override
    public String getResults() {
        int size = results.size();
        for(int i =0 ; i< size; i++){
          Collections.sort(results.get(i).values);
        }
        return RuleHelper.objectToJson(results);
    }
   

    private int valueFoundIndex(List<Value> values, String xValue) {
        for (int i = 0; i < values.size(); i++) {
            if (values.get(i).x.equals(xValue)) {
                return i;
            }
        }
        return -1;
    }

    //private classes for the series
    class Series implements Serializable {

        public String key;
        public List<Value> values;

        public Series() {
            values = new ArrayList();
        }

        @Override
        public int hashCode() {
            int hash = 3;
            return hash;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == null) {
                return false;
            }
            if (getClass() != obj.getClass()) {
                return false;
            }
            final Series other = (Series) obj;
            if (!Objects.equals(this.key, other.key)) {
                return false;
            }
            return true;
        }
    }

    class Value implements Serializable,Comparable<Value>{

        public String x;
        public int y;

        public Value() {
        }

        public Value(String x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Value o) {
            return x.compareTo(o.x);
        }
    }
}
