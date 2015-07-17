/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.att.dispatch.rule.process;

import com.att.dispatch.rule.model.Dispatch;

/**
 * dispatch pool
 * @author ebrima
 */
public class DispatchPool extends BasePool<Dispatch>{
    public DispatchPool(IBaseStore store,String primaryKey) {
        super(store,Dispatch.class, primaryKey);
    }

    @Override
    public Class<Dispatch> getEntityClass() {
       return Dispatch.class;
    }
    //insert and return json string
    @Override
    public String save(Dispatch object) throws DataStoreException{
           String key = getPrimaryKey();
           String field = object.getId().toString();
           return save(key,field,object);
    }
}
