/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sequentialpinger;

import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Kornh
 */
public class Pinger implements Runnable{

    private String responseResult;
    private String url;
    
    public Pinger(String url) {
        this.url = url;
    }

    @Override
    public void run() {
        
        
        try {
            URL theSiteUrl = new URL(url);
            HttpURLConnection conn = (HttpURLConnection) theSiteUrl.openConnection();
            conn.setRequestMethod("GET");
            conn.connect();
            
            int responseCode = conn.getResponseCode();
            if(responseCode == 200){
                responseResult = "green";
            }
            if(responseCode == 301){
                responseResult = "redirect";
            }
            else{
                responseResult = "other statuscode";
            }
            
        } catch (Exception ex) {
            responseResult = "->Red<-";
            Logger.getLogger(Pinger.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        Callable.add(url + " StatusCode: " + responseResult);
        }  
    
       
        
    }
    
    
    

