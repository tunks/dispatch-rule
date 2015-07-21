/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.att.dispatch.rule.process;

import com.att.dispatch.rule.model.Turf;

import java.util.Iterator;
/**
 *
 * @author ebrima
 * Data pool that stores the different fact information on the data store
 */
public class TurfPool extends BasePool <Turf>  {
	
    public TurfPool(IBaseStore store, String primaryKey) {
        super(store, Turf.class, primaryKey);
    }
    
    @Override
    public Class<Turf> getEntityClass() {
          return Turf.class;
    }
  
    //notify all groups about changes
    public void notifyObservers(Turf  object){
        Iterator<String> keys = object.getGroups().keySet().iterator();
        while(keys.hasNext()){
           String key = keys.next();
           object.getGroups().get(key).update(null, object.getTotalNumberOfJobs());
        }
    }
    //save the turf and notification the turf observers 
	@Override
	public String save(Turf object) throws DataStoreException {
	 String key = getPrimaryKey();
         String field = object.getId().toString();
         //notify all groups and update observer groups
         notifyObservers(object);
         return save(key,field,object);
	}
    
      @Override
       public boolean exists(String field){
         String key = getPrimaryKey();
         boolean exists = exists(key,field);
         System.out.println("Turf exist "+exists);
         return exists;
      }      
}