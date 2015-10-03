/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.act.menu.beans.security;

import bb.common.BizboxUserListResult;
import java.util.List;
import javax.faces.model.ListDataModel;
import org.primefaces.model.SelectableDataModel;

/**
 *
 * @author iftikhar
 */
public class UserDataModel extends ListDataModel<BizboxUserListResult> implements SelectableDataModel<BizboxUserListResult> {
     public UserDataModel() {  
     }  
  
    public UserDataModel(List<BizboxUserListResult> data) {  
        super(data);  
    }  
      
    @Override  
    public BizboxUserListResult getRowData(String rowKey) {  
        //In a real app, a more efficient way like a query by rowKey should be implemented to deal with huge data  
          
        List<BizboxUserListResult> users = (List<BizboxUserListResult>) getWrappedData();  
          
        for(BizboxUserListResult user : users) {  
            if(user.getUserName().equals(rowKey)) {
                return user;
            }  
        }  
          
        return null;  
    }  
  
    @Override  
    public String getRowKey(BizboxUserListResult user) {  
        return user.getUserName();  
    }  
}
