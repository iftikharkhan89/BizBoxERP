/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.act.module.engineering.partmaster;


import bb.common.Configure;
import bb.common.PartPK;
import bb.common.PartUnitPK;
import bb.common.PartUnitVO;
import bb.common.PartVO;
import com.act.util.BizboxAPIHelper;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Iftikhar.Khan
 */
@ManagedBean
@ViewScoped
public class AddPartMasterBean implements Serializable{

    private String partNumber;
    private String revision;
    private String type;
    private String uom;
    private String description;
    private String selectedPartType;
    private String selectedUOM;
    PartPK partPK;
    PartVO vo;
    private static String editMode;
    private static String action;
    
    /**
     * Creates a new instance of AddPartMasterBean
     */
    public AddPartMasterBean() {

    }

    public String getPartNumber() {
        return partNumber;
    }

    public void setPartNumber(String partNumber) {
        this.partNumber = partNumber;
    }

    public String getRevision() {
        return revision;
    }

    public void setRevision(String revision) {
        this.revision = revision;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUom() {
        return uom;
    }

    public void setUom(String uom) {
        this.uom = uom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    public void addPartMaster() {
        Map sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap(); 
        vo = new PartVO();
        
        PartPK ppk = new PartPK(partNumber,selectedPartType);
        PartUnitPK puPk = new PartUnitPK(ppk,selectedUOM);
        PartUnitVO puVo = new PartUnitVO();
        puVo.setPk(puPk);
        Set<PartUnitVO> partUnitsSet = new HashSet<PartUnitVO>();
        partUnitsSet.add(puVo);
        vo.setUnits(partUnitsSet);
        vo.setDescription(description);
        
        vo.setPk(ppk);
        vo.setRevision(revision);
            try {
                    Object [] param = new Object[1];
                    param[0] = vo ;                                
                    partPK = (PartPK) BizboxAPIHelper.invokeAPI(sessionMap, Configure.Module.ENGINEERING, "addPart", param);
                    if (partPK != null) {
                        FacesMessage msg2 = new FacesMessage("Part Master","A new Part is added");  
                        FacesContext.getCurrentInstance().addMessage(null, msg2);
                        param[0] = partPK;
                        vo = (PartVO) BizboxAPIHelper.invokeAPI(sessionMap, Configure.Module.ENGINEERING, "findPart", param);
                    }
                } 
            catch (Exception ex) {
                Logger.getLogger(AddPartMasterBean.class.getName()).log(Level.SEVERE, null, ex);
            }
    }

    public String getSelectedPartType() {
        return selectedPartType;
    }

    public void setSelectedPartType(String selectedPartType) {
        this.selectedPartType = selectedPartType;
    }

    public String getSelectedUOM() {
        return selectedUOM;
    }

    public void setSelectedUOM(String selectedUOM) {
        this.selectedUOM = selectedUOM;
    }
    
    public void reset () {
        
    }
    public void showPartMasterUpdateUI(){
       if (vo != null) {
            action = "update";
            editMode = "view";
       }
    }
    public void changeModeToEdit(){
        if (action.equals("update")) {
            editMode = "edit";
        }
    }
    public void savePartMaster() {
        action = "update";
        editMode = "view";
    }
    public void hideUpdatePartMasterUI(){
        action = "add";
        editMode = "view";
    }

    public String getEditMode() {
        return editMode;
    }

    public void setEditMode(String editMode) {
        editMode = editMode;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        action = action;
    }

    public PartPK getPartPK() {
        return partPK;
    }

    public void setPartPK(PartPK partPK) {
        this.partPK = partPK;
    }

    public PartVO getVo() {
        return vo;
    }

    public void setVo(PartVO vo) {
        this.vo = vo;
    }
    
    
}
