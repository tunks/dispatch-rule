
package com.att.dispatch.rule.process;

import com.att.dispatch.rule.model.Group;
import com.att.dispatch.rule.model.Turf;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 *
 * @author ebrima 
 * class to compute the group statistics
 */
public class GroupSeries implements Compute<List,String>{
    List statistics;
    public GroupSeries(){
      statistics = new ArrayList();
    }
     //compute all groups 
    @Override
    public void compute(List object) {
        int totalJobs = 0;
        List<Group> list =  getAllTurfGroups(object);
        Iterator<Group> groupIterator  = list.iterator();
        Map<String,Group> groups = new HashMap();
        //aggregate all group values
        while(groupIterator.hasNext()){
          Group group = groupIterator.next();
          int value;
          if (groups.containsKey(group.getName())){
              value = groups.get(group.getName()).getValue() + group.getValue();
              groups.get(group.getName()).setValue(value);
          }
          else{
             value = group.getValue();
             groups.put(group.getName(), new Group(group.getName(),value));
          }
          
          totalJobs+= group.getValue();
        }
        
        //generate into  list
        groupIterator = groups.values().iterator();
        while(groupIterator.hasNext()){
           Group group = groupIterator.next();
           double percent = group.getValue()*100 / totalJobs;
           group.setPercentage(percent);
           statistics.add(group);
        }
    }
     
  // get all turfs groups
    public static List getAllTurfGroups(List<Turf> turfs){
     List groups = new ArrayList();
     for(Turf turf: turfs){
         List<Group> list = new ArrayList(turf.getGroups().values());
         groups.addAll(list);
     }
     return groups;
      }

    //return the results in json */
    @Override
    public String getResults() {
        return  RuleHelper.objectToJson(statistics);// 
    }
}
