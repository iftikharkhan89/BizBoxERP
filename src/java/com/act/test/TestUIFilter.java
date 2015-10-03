/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.act.test;

import com.act.util.BizBoxClientUtil;

/**
 *
 * @author iftikhar
 */
public class TestUIFilter {
    
    public static void main(String args[]) {
        String roleIds []= {"WAREHOUSE","SALES MANAGER","SALES"};
        BizBoxClientUtil.getUIRoleBasedMapping(roleIds);
    }
}
