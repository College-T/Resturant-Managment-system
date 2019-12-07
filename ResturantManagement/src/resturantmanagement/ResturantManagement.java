/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */




package resturantmanagement;

import java.util.ArrayList;

/**
 *
 * @author elnopy
 */
public class ResturantManagement {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//        customers p=new customers("amr", "saleh");p.add();
        //System.out.println(p.search(1).getFname());
        
        Meals n =new Meals("meat", 10000);
       n.add();
     // n.makeOffer("chicken", 0.1);
      
        ArrayList<String>o=new ArrayList<>();
       
        o.add("chicken");
        o.add("meat");
        
         Order m=new Order(o, 1);
         System.out.println(m.getPrice());
    }    
  
}

