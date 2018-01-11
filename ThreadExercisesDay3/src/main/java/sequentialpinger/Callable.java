/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sequentialpinger;

/**
 *
 * @author Kornh
 */
import java.util.ArrayList;



public class Callable {
    
    private static ArrayList<String> pingList = new ArrayList<String>();
       
    public static void add(String str){
        pingList.add(str);
    }

    public static ArrayList<String> getList() {
        return pingList;
    }
    
    public static void printAll(){
        if(!pingList.isEmpty())
            pingList.forEach((str) -> {
                System.out.println(str);
        });
    }
    
}
