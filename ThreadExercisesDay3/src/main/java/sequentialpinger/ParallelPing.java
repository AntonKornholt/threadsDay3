/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sequentialpinger;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Kornh
 */
public class ParallelPing {
    public static void main(String[] args) {
        String[] hostList = { 
                "http://crunchify.com", "http://yahoo.com",
                "http://www.ebay.com", "http://google.com",
                "http://www.example.co", "https://paypal.com",
                "http://bing.com/", "http://techcrunch.com/",
                "http://mashable.com/", "http://thenextweb.com/",
                "http://wordpress.com/", "http://cphbusiness.dk/",
                "http://example.com/", "http://sjsu.edu/",
                "http://ebay.co.uk/", "http://google.co.uk/",
                "http://www.wikipedia.org/",
                "http://dr.dk","http://pol.dk","https://www.google.dk",
                "http://phoronix.com" ,"http://www.webupd8.org/",
                "https://studypoint-plaul.rhcloud.com/", "http://stackoverflow.com",
                "http://docs.oracle.com","https://fronter.com",
                "http://imgur.com/", "http://www.imagemagick.org"
                };
                
            ExecutorService ex = Executors.newFixedThreadPool(hostList.length);
            
            for(String url : hostList){
                Runnable pinger = (Runnable) new Pinger(url);
                ex.execute(pinger);
            }
            ex.shutdown();
            
        try {
            ex.awaitTermination(3, TimeUnit.SECONDS);
                    } catch (InterruptedException ex1) {
            Logger.getLogger(ParallelPing.class.getName()).log(Level.SEVERE, null, ex1);
        }
            Callable.printAll();
    }
}
