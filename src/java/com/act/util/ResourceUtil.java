/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.act.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.context.FacesContext;

/**
 *
 * @author Iftikhar.Khan
 */
public class ResourceUtil {
 
    public static Properties getApplicationProperties(){
       
        InputStream input = FacesContext.getCurrentInstance().getExternalContext().getResourceAsStream("/application.properties");
        Properties properties = new Properties();
        try {
            properties.load(input);
            return properties;
        } catch (IOException ex) {
            Logger.getLogger(ResourceUtil.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    public static Properties getDBProperties() {
        InputStream input = FacesContext.getCurrentInstance().getExternalContext().getResourceAsStream("/db.properties");
        Properties properties = new Properties();
        try {
            properties.load(input);
            return properties;
        } catch (IOException ex) {
            Logger.getLogger(ResourceUtil.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } 
    }
}
