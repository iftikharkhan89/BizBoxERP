/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.act.module.security;

import bb.common.RoleListResult;
import java.io.Serializable;
import java.util.List;
import javax.faces.model.ListDataModel;
import org.primefaces.model.SelectableDataModel;

/**
 *
 * @author iftikhar
 */
public class RoleDataModel extends ListDataModel<RoleListResult> implements SelectableDataModel<RoleListResult>,Serializable {

    public RoleDataModel(List<RoleListResult> data) {  
        super(data);  
    }
    @Override
    public Object getRowKey(RoleListResult t) {
        return t.RoleId;
    }

    @Override
    public RoleListResult getRowData(String rowKey) {
        List<RoleListResult> roles = (List<RoleListResult>) getWrappedData();           
        for(RoleListResult role : roles) {  
            if(role.getRoleId().equals(rowKey)) {
                return role;
            }  
        }           
        return null;
    }
    
}
