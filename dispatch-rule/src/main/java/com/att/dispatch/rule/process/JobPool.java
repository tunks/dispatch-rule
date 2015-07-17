package com.att.dispatch.rule.process;

import com.att.dispatch.rule.model.Job;


/**
 *
 * @author ebrima 
 * Job pool - manages the jobs
 */
public class JobPool extends BasePool<Job>{
  
    public JobPool(IBaseStore store, String primaryKey) {
        super(store, Job.class, primaryKey);
    }

    @Override
    public Class<Job> getEntityClass() {
        return Job.class;
    }
   
    //insert and returns json string
    @Override
    public String save(Job object) throws DataStoreException{
         String key = getPrimaryKey();
         String field = object.getId().toString();
         return save(key,field,object);
    }
    
    public Job find(Job object){
    	String key = object.getTurfID().toString();
    	String field = object.getId().toString();
    	return find(key,field);
    }
}
