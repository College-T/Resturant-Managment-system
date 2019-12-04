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
       Employee m=new Employee("mohame4d ", "saleh", 20180403, "amrsaleh", "123456789", 1000);m.add();
      ArrayList<Employee> l=(ArrayList< Employee>)(Object)m.list();
      for(Employee l1:l)
      {
          System.out.println(l1.getId()+" "+l1.getFName());
      }
       
}
}
