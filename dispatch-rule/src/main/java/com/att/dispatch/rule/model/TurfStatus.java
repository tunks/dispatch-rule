/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.att.dispatch.rule.model;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author ebrima
 */
public class TurfStatus implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long id;
    private Long turfID;
    private String timestamp; 
    private int numberOfJobs;
    //private Flag flag;

    public TurfStatus(){
      timestamp = new SimpleDateFormat("MM-dd-yyyy HH:mm").format(new Date());
    }
   
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTurfID() {
        return turfID;
    }

    public void setTurfID(Long turfID) {
        this.turfID = turfID;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public int getNumberOfJobs() {
        return numberOfJobs;
    }

    public void setNumberOfJobs(int numberOfJobs) {
        this.numberOfJobs = numberOfJobs;
    }

//    public Flag getFlag() {
//        return flag;
//    }
//
//    public void setFlag(Flag flag) {
//        this.flag = flag;
//    }
}
