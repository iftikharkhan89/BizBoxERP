/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.act.util;

import bb.common.BizboxUserListResult;
import bb.common.BizboxUserVO;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author iftikhar
 */
public class UserConverterUtil {
    
    public static List<BizboxUserVO> convertUserResultListToUserVOList(List<BizboxUserListResult> results) {
        List<BizboxUserVO> userVOList = new ArrayList<BizboxUserVO>();
        Iterator iterator = results.iterator();
        while (iterator.hasNext()) {
            BizboxUserListResult current = (BizboxUserListResult) iterator.next();
            BizboxUserVO vo = new BizboxUserVO();
            vo.setCanUpdateAnything(current.getCanUpdateAnything());
            vo.setClientProperties(current.getClientProperties());
            vo.setComment(current.getComment());
            vo.setCreateTime(current.getCreateTime());
            vo.setCustomProperties(current.getCustomProperties());
            vo.setExpireDate(current.getExpireDate());
            vo.setIp(current.getIp());
            //vo.setLanIp(null);
            //vo.setLastChangePassword(null);
            vo.setLastLogin(current.getLastLogin());
            vo.setLastLogout(current.getLastLogout());
            vo.setLocked(current.isLocked());
            vo.setMacAddress(null);
            //vo.setPassword();
             vo.setRefId(current.getRefId());
            vo.setStatus(current.getStatus());
            vo.setType(current.getType());
            vo.setUserName(current.getUserName());
            
            userVOList.add(vo);
        }
        return userVOList;
    }
}
