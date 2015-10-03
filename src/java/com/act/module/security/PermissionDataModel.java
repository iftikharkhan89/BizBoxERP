/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.act.module.security;

import bb.common.PermissionVO;
import java.io.Serializable;
import java.util.List;
import javax.faces.model.ListDataModel;
import org.primefaces.model.SelectableDataModel;

/**
 *
 * @author iftikhar
 */
public class PermissionDataModel extends ListDataModel<PermissionVO> implements SelectableDataModel<PermissionVO>,Serializable {

    public PermissionDataModel(List<PermissionVO> list) {
        super(list);
    }

    @Override
    public Object getRowKey(PermissionVO t) {
        return t.getPermissionId();
    }

    @Override
    public PermissionVO getRowData(String rowKey) {
        List<PermissionVO> permissions = (List<PermissionVO>) getWrappedData();           
        for(PermissionVO permission : permissions) {  
            if(permission.getPermissionId().equals(rowKey)) {
                return permission;
            }  
        }           
        return null;
    }
    
}
