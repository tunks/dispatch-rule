package com.att.dispatch.rule.model;

/**
 * This class was automatically generated by the data modeler tool.
 */

public class Flag implements java.io.Serializable
{

   static final long serialVersionUID = 1L;

   private java.lang.Long id;
   private java.lang.String color;

   public Flag()
   {
   }

   public Flag(String color){
    this.color = color;
   }
   public java.lang.Long getId()
   {
      return this.id;
   }

   public void setId(java.lang.Long id)
   {
      this.id = id;
   }

   public java.lang.String getColor()
   {
      return this.color;
   }

   public void setColor(java.lang.String color)
   {
      this.color = color;
   }

   public Flag(java.lang.Long id, java.lang.String color)
   {
      this.id = id;
      this.color = color;
   }

}