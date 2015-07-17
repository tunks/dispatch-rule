/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.att.dispatch.rule.model;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Observable;

/**
 *
 * @author ebrima
 */
//TODO observable
public class Turf implements Serializable  {
    /**
	 * 
	 */
	//private static final long serialVersionUID = 1L;
	Long id;
    List<Integer> zipCodes; //zip codes that belong to a particular pool
    TurfStatus currentStatus;
    String name;
    String region;
    int techMin;
    int totalNumberOfJobs;
    //statistic groupings
    Map<String,Group> groups;
   
    //extra field for the rule
    private boolean active;
    
    public Turf(){
     groups = new HashMap<String, Group>();
     //set default value for active to false 
     active = false;
    }
    
    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Integer> getZipCodes() {
        return zipCodes;
    }

    public void setZipCodes(List<Integer> zipCodes) {
        this.zipCodes = zipCodes;
    }
    
    
    public void addZipCode(int zipcode){
       zipCodes.add(zipcode);
    }
    
    public void removeZipCode(int zipcode){
       zipCodes.remove(zipcode);
    }

    public int getTechMin() {
        return techMin;
    }

    public void setTechMin(int techMin) {
        this.techMin = techMin;
    }
    //logical grouping
    public Map<String, Group> getGroups() {
        return groups;
    }

    public void setGroups(Map<String, Group> groups) {
        this.groups = groups;
    }
    
    public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	@Override
    public int hashCode() {
        int hash = 3;
        hash = 13 * hash + Objects.hashCode(this.id);
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
        final Turf other = (Turf) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
     
        return Objects.equals(this.zipCodes, other.zipCodes);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TurfStatus getCurrentStatus() {
        return currentStatus;
    }

    public void setCurrentStatus(TurfStatus currentStatus) {
        this.currentStatus = currentStatus;
    }

    public int getTotalNumberOfJobs() {
        return totalNumberOfJobs;
    }

    public void setTotalNumberOfJobs(int totalNumberOfJobs) {
        this.totalNumberOfJobs = totalNumberOfJobs;
    }
    
    @Override
    public String toString(){
      return "{id="+id
             +",name="+name
             +",region="+region
             + "}";
  }
       
}
