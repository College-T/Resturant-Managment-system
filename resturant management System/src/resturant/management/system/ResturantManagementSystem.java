/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package resturant.management.system;

/**
 *
 * @author amr
 */
public class ResturantManagementSystem {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Order m= new Order(1000, "meat", 20180402);
        m.add();
        System.out.println(m.allPayments());
    }
    
}
