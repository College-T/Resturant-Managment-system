/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import java.util.ArrayList;

/**
 *
 * @author eslam
 */
public class Project {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Meals meals = new Meals();
        System.out.print(meals.Search(0));
        //System.out.print(meals.Delete(1));
        //meals.Update(1, meals);
        //System.out.print(meals.toString());
    }
    
}
