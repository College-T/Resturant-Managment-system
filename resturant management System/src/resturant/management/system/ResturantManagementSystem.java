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
        //Order m= new Order(1000, "checken", 20180111);
        Meals m = new Meals(1, "meals", 100, 20);
        //m.Add();
        m.Delete(1);
        System.out.println(m.toString());
    }
    
}
