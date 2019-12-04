/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package resturantmanagement;



import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author elnopy
 */
public  class Person implements Serializable{
    protected String FName;
    protected String LName;
    protected int id;
    public Person() {
    }

    public Person(String FName, String LName, int id) {
        this.FName = FName;
        this.LName = LName;
        this.id = id;
       
    }
    
    public String getFName() {
        return FName;
    }

    public void setFName(String FName) {
        this.FName = FName;
    }

    public String getLName() {
        return LName;
    }

    public void setLName(String LName) {
        this.LName = LName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    
    
      
     
    
      
}
