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
       Meals m=new Meals(20180402, "chicken", 150, 0);
       m.update();
     ArrayList<Meals>l=(ArrayList<Meals>)(Object)m.list();
     for(Meals l1:l)
     {
         System.out.println(l1.getId()+" "+l1.getCost()+" "+l1.getOffer());
     }
}
}
