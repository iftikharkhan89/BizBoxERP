/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.act.module.engineering.partmaster;

import bb.common.Configure;
import bb.common.PartPictureVO;
import com.act.core.classes.ApplicationConstants;
import com.act.util.BizboxAPIHelper;
import com.act.util.ServerJDBCHelperBean;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import javax.swing.ImageIcon;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

/**
 *
 * @author Iftikhar.Khan
 */
@ManagedBean
@RequestScoped
public class PartMasterUploadBean {
private static final long serialVersionUID = 6529685098267757690L;
    String partNumber;
    String singleImagePath;
    String csvPath;
    String imagesPath;
    boolean singleImage;
    String startDate;
    int selectedOperationType;
    String directoryPath;
    static int maxCount;
    static {
     
    }
    /**
     * Creates a new instance of PartMasterUploadBean
     */
    public PartMasterUploadBean() {
        selectedOperationType = 2;   
        ServletContext ctx = (ServletContext) FacesContext.getCurrentInstance()
            .getExternalContext().getContext();
        directoryPath = ctx.getRealPath("/"); 
        imagesPath = createDirectoryOnServer();
    }

    public String getPartNumber() {
        return partNumber;
    }

    public void setPartNumber(String partNumber) {
        this.partNumber = partNumber;
    }

    public String getSingleImagePath() {
        return singleImagePath;
    }

    public void setSingleImagePath(String singleImagePath) {
        this.singleImagePath = singleImagePath;
    }

    public String getCsvPath() {
        return csvPath;
    }

    public void setCsvPath(String csvPath) {
        this.csvPath = csvPath;
    }

    public String getImagesPath() {
        return imagesPath;
    }

    public void setImagesPath(String imagesPath) {
        this.imagesPath = imagesPath;
    }

    public boolean isSingleImage() {
        return singleImage;
    }

    public void setSingleImage(boolean singleImage) {
        this.singleImage = singleImage;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public int getSelectedOperationType() {
        return selectedOperationType;
    }

    public void setSelectedOperationType(int selectedOperationType) {
        this.selectedOperationType = selectedOperationType;
    }
    
    public void handleSingleUpload(FileUploadEvent event){
  
            handleMultipleUpload(event);
       
    }
    
    public void handleMultipleUpload(FileUploadEvent event){
      
        if(isValidFileName(event.getFile().getFileName())) {
        try {
            createDirectoryOnServer();
            UploadedFile file = event.getFile();
            byte [] fileContent = file.getContents();
            String partNum = file.getFileName().split("_")[1];
            File fileToSave = new File("C:/ERP/"+partNum+"_"+maxCount+".png");
            if (!fileToSave.exists())
                fileToSave.createNewFile();
            System.out.println(fileToSave.getAbsolutePath());
            FileOutputStream fos = new FileOutputStream(fileToSave);
            fos.write(fileContent);
            fos.close();
               Image image = Toolkit.getDefaultToolkit().getImage("C:/ERP/"+partNum+"_"+maxCount+".png");
               ImageIcon icon = new ImageIcon(image);
               int height = icon.getIconHeight();
               int width = icon.getIconWidth();
               saveImagesForPartsInDataBase(file.getFileName(),height,width,fileContent);
            
        } catch (IOException ex) {
            Logger.getLogger(PartMasterUploadBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
        else {
                FacesMessage msg = new FacesMessage(event.getFile().getFileName()+" is not a valid name.");  
                FacesContext.getCurrentInstance().addMessage(null, msg); 
        }
        maxCount++;
    }
    public void stop() {
        FacesMessage msg = new FacesMessage("Succesful");  
        FacesContext.getCurrentInstance().addMessage(null, msg);  
    }
    public void cancel() {
        
    }
    private void saveImagesForPartsInDataBase(String fileName,int height,int width, byte [] fileContents) {
        
        
        
        String partNum = fileName.split("_")[1];
        if (maxCount == 0) {
            initializeMaxCount(partNum);
        }
       // System.out.println("Part Number: "+partNum);
        String extension = "png";
        PartPictureVO vo = new PartPictureVO(extension);
        vo.setPartNumber(partNum);
        vo.setPartType("P/A");
        vo.setWidth((short)width);
        vo.setHeight((short)height);
        vo.setPicture(fileContents);
        vo.setMainPicture(true);      
        Map sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap(); 
        try {
              Object [] param = {vo};
              BizboxAPIHelper.invokeAPI(sessionMap, Configure.Module.ENGINEERING, "addPartPicture", param);
              System.out.println("Picture is uploaded...size: "+fileContents.length);
            }
             catch (Exception ex) {
                Logger.getLogger(PartMasterUploadBean.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    private String createDirectoryOnServer() {
        File imageDirectory = new File(directoryPath+"/"+ApplicationConstants.PARTS_IMAGES_DIRECTORY);
         if (!imageDirectory.exists())
             imageDirectory.mkdir();   
         return imageDirectory.getAbsolutePath();
    }
    
    private boolean isValidFileName(String fileName) {
        
        String [] fileNameParts = fileName.split("_");
        if (fileNameParts.length == 3)
            return true;
        else 
            return false;
    }
    
    private static void initializeMaxCount(String partNumber){
         try {
           ServerJDBCHelperBean helper = new ServerJDBCHelperBean();
           String query = "select max(control_no) from bb2_default.log_misc_doc where pn = "+partNumber;
           ResultSet result =  helper.executeSelectQuery(query);
          while (result.next()) {
              maxCount = Integer.parseInt(result.getString("max(control_no)"));
              maxCount++;
          }          
       } catch (SQLException ex) {
           Logger.getLogger(ServerJDBCHelperBean.class.getName()).log(Level.SEVERE, null, ex);
       }
    }
    
}
