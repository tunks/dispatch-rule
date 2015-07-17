/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.att.dispatch.rule.model;

import java.io.Serializable;
import java.util.Objects;
import java.util.Observable;
import java.util.Observer;

/**
 *
 * @author ebrima
 */
public class Group implements Observer,Serializable{
    Long id;
    String name;
    int value;
    double percentage;

    public Group(String name){
      this.name = name;
    }

    public Group(String name, int value) {
        this.name = name;
        this.value = value;
    }
     
    public Group(String name, int value, double percentage) {
        this.name = name;
        this.value = value;
        this.percentage = percentage;
    }
     
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public double getPercentage() {
        return percentage;
    }

    public void setPercentage(double percentage) {
        this.percentage = percentage;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 43 * hash + Objects.hashCode(this.id);
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
        final Group other = (Group) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        return true;
    }
    
    //update changes on the turf
    @Override
    public void update(Observable o, Object arg) {
       int totalNumberOfJobs = (Integer) arg;
       double percent= ((double)value/totalNumberOfJobs)  * 100;   
       this.percentage = Math.round(percent * 100.0) /100.0;
    }       
}
