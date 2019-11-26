/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package resturant.management.system;

import java.util.ArrayList;

/**
 *
 * @author amr
 */
public class ResturantManagementSystem {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//        Order k= new Order();
//       Order b= new Order(500,"lllll",201804);
//       b.updateOrder();
//       
//        ArrayList<Order >m=new ArrayList<Order >();
//        m=b.customerProfile(201804);
//        for(Order m1:m)
//        {
//            System.out.println(m1.getOrder());
//        }
        filemanagement n= new filemanagement();
        ArrayList<Order>o=(ArrayList < Order >)(Object)n.read("Order.bin");
        for(Order o1:o)
        {
            System.out.println(o1.getOrder());
        }
    }
    
}
