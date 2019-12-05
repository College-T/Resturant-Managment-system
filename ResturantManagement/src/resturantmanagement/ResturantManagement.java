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
       
       Employee p=new Employee("amr", "ssaleh",20180403, "amr@saleh","123456789",1000);p.add();
       
       ArrayList<Employee>l=(ArrayList<Employee>)(Object)p.list();
       for(Employee l1:l)
       {
           System.out.println(l1.getFName());
       }
//      int o= p.login( "amr@saleh","123456789");
//        System.out.println(o);
}
}
