/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */




package resturantmanagement;

import GUI.AdminGui;
import GUI.employeeG;
import GUI.login;
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
//        admin a = new admin("fd", "gfd", "gf", "hfg");
//        a.add();
//        Meals m = new Meals("tea", 40);
//        m.add();
//        employeeG e = new employeeG(1);
//        e.setVisible(true);
//        AdminGui m=new AdminGui();m.setVisible(true);
//        customers p=new customers("amr", "saleh");p.add();
        //System.out.println(p.search(1).getFname());
        admin n=new admin("Amr", "Saleh", "admin", "12345678");n.add();
        login m=new login();
        m.setVisible(true);
//        Meals n =new Meals("meat", 10000);
//       n.add();
//     // n.makeOffer("chicken", 0.1);
//      
//        ArrayList<String>o=new ArrayList<>();
//       
//        o.add("chicken");
//        o.add("meat");
        
//        Employee e = new Employee("eslam", "mohamed", "e123", "12345678");
//        e.add();
//        ArrayList<Employee> a = (ArrayList<Employee>) (Object)e.list();
//        for(int i = 0; i < a.size(); i++) System.out.println(a.get(i).getUserName() + " " + a.get(i).getPassword());
    }    
  
}

