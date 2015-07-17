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
        Iterator<Turf> turfs = list.iterator();
        while (turfs.hasNext()) {
            Turf turf = turfs.next();
            List<Series> series = generateSeries(turf);
            insertSeries(series);
        }
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
   
    private List<Series> generateSeries(Turf turf) {
        List<Series> list = new ArrayList();
        Map<String, Group> groups = turf.getGroups();
        Iterator<Group> itr = groups.values().iterator();
        while (itr.hasNext()) {
            Series series = new Series();
            Group group = itr.next();
            series.key = group.getName();
            //values
            Value value = new Value(turf.getName(), group.getValue());
            series.values.add(value);
            list.add(series);
        }

        return list;
    }

    private void insertSeries(List<Series> series) {
        for (int index = 0; index < series.size(); index++) {
            Series item = series.get(index);
            boolean found = false;
            for (int k = 0; k < results.size(); k++) {
                List<Value> itemValue = item.values;
                List<Value> resultValue = results.get(k).values;
                String xxValue = itemValue.get(0).x;
                int yValue = itemValue.get(0).y;
                if (item.key.equals(results.get(k).key)) {
                    int vIndex = valueFoundIndex(resultValue, xxValue);
                    int vSize = resultValue.size();
                    if (vIndex >= 0 && vIndex < vSize-1) {
                        results.get(k).values.get(index).y = yValue;
                    } else {
                        results.get(k).values.add(new Value(xxValue, yValue));
                    }
                    found = true;
                } else {
                    //if value type is not found, then add series to zero
                    if (valueFoundIndex(resultValue, xxValue) == -1) {
                        int yyyValue = 0;
                        results.get(k).values.add(new Value(xxValue, yyyValue));
                    }
                }
            }
            
          if (results.size() > 0 && !found) {
              for(int i = 0; i< results.size(); i++){
                List<Value> values = results.get(i).values;
                String rKey = results.get(i).key;
                for (int j = 0; j < values.size(); j++) {
                    String xVal = values.get(j).x;
                    if (!item.key.equals(rKey) && (valueFoundIndex(item.values, xVal) == -1) ) {
                        int yVal = 0;
                        item.values.add(new Value(xVal, yVal));
                    }
                }
              }
            }
          
            if ( !found) {
                results.add(0,item);
            }
        }
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
