/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.att.dispatch.rule.model;

/**
 *
 * @author ebrima
 * class that keep all analytic
 */
public  class Analytic {
    String name;
    String results;
    String createdOn;
    
    public Analytic(){
    
    }

    public Analytic(String name) {
        this.name = name;
    }
    
    public String getResults() {
        return results;
    }

    public void setResults(String result) {
        this.results = results;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(String createdOn) {
        this.createdOn = createdOn;
    }
    
    
}
