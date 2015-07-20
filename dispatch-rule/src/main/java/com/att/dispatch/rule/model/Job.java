/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.att.dispatch.rule.model;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author ebrima
 */
public class Job implements Serializable
{
   private Long id;
   private String status;
   private Long ticketID;
   private Long turfID;
   private String turfName;
   private Long dispatchID;
   private String startTime;
   private String endTime;
   private Long duration;
   private int zipCode;

   private String message;
   private String updatedOn;

   private com.att.dispatch.rule.model.Flag flag;

   private java.lang.Boolean active;

  public Job(){
   active = false;
  }
  public String getStatus()
   {
      return status;
   }

   public void setStatus(String status)
   {
      this.status = status;
   }

   public String getStartTime()
   {
      return startTime;
   }

   public void setStartTime(String startTime)
   {
      this.startTime = startTime;
   }

   public String getEndTime()
   {
      return endTime;
   }

   public void setEndTime(String endTime)
   {
      this.endTime = endTime;
   }

   public Long getId()
   {
      return id;
   }

   public void setId(Long id)
   {
      this.id = id;
   }

   public Long getTicketID()
   {
      return ticketID;
   }

   public void setTicketID(Long ticketID)
   {
      this.ticketID = ticketID;
   }

   public Long getDispatchID()
   {
      return dispatchID;
   }

   public void setDispatchID(Long dispatchID)
   {
      this.dispatchID = dispatchID;
   }

   public Long getDuration()
   {
      return duration;
   }

   public void setDuration(Long duration)
   {
      this.duration = duration;
   }

   public Long getTurfID()
   {
      return turfID;
   }

   public void setTurfID(Long turfID)
   {
      this.turfID = turfID;
   }

   public String getMessage()
   {
      return message;
   }

   public void setMessage(String message)
   {
      this.message = message;
   }

   public String getUpdatedOn()
   {
      return updatedOn;
   }

   public void setUpdatedOn(String updatedOn)
   {
      this.updatedOn = updatedOn;
   }

   public int getZipCode()
   {
      return zipCode;
   }

   public void setZipCode(int zipCode)
   {
      this.zipCode = zipCode;
   }

   public String getTurfName()
   {
      return turfName;
   }

   public void setTurfName(String turfName)
   {
      this.turfName = turfName;
   }

   @Override
   public String toString()
   {
      return "{job: {" +
            "id:" + id +
            ",ticketID: " + ticketID +
            ",status:" + status +
            ",zipCode:" + zipCode +
            ",turfID: " + turfID +
            ",startTime: " + startTime +
            ",endTime:" + endTime
            + "}"
            + "}";
   }

   public com.att.dispatch.rule.model.Flag getFlag()
   {
      return this.flag;
   }

   public void setFlag(com.att.dispatch.rule.model.Flag flag)
   {
      this.flag = flag;
   }

   public java.lang.Boolean getActive()
   {
      return this.active;
   }

   public void setActive(java.lang.Boolean active)
   {
      this.active = active;
   }

   public Job(java.lang.Long id, java.lang.String status, java.lang.Long ticketID,
         java.lang.Long turfID, java.lang.String turfName,
         java.lang.Long dispatchID, java.lang.String startTime,
         java.lang.String endTime, java.lang.Long duration, int zipCode,
         java.lang.String message, java.lang.String updatedOn,
         com.att.dispatch.rule.model.Flag flag, java.lang.Boolean active)
   {
      this.id = id;
      this.status = status;
      this.ticketID = ticketID;
      this.turfID = turfID;
      this.turfName = turfName;
      this.dispatchID = dispatchID;
      this.startTime = startTime;
      this.endTime = endTime;
      this.duration = duration;
      this.zipCode = zipCode;
      this.message = message;
      this.updatedOn = updatedOn;
      this.flag = flag;
      this.active = active;
   }
}
