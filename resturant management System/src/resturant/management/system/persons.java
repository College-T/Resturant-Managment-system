/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package resturant.management.system;

import java.io.Serializable;

/**
 *
 * @author eslam
 * 
 */
public abstract class persons implements Serializable{
    private int id;
    private String user_name;
    private String name;
    private int status;
    int age;
    private Integer password;
    private Double salary;
    
    public persons(){};
    
    public persons(int id, String user_name, String name, int age, Integer pass, Double salary, int status)
    {
        
        this.id = id;
        this.user_name = user_name;
        this.name = name;
        this.age = age;
        this.password = pass;
        this.salary = salary;
        this.status = status;
    }
    
    
    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
    
    public void set_id(int id)
    {
        this.id = id;
    }
    
    public void set_user_name(String user_name)
    {
        this.user_name = user_name;
    }
    
    public void set_name(String name)
    {
        this.name = name;
    }
    
    public void set_age(int age)
    {
        this.age = age;
    }
    
    public void set_password(int pass)
    {
        this.password = pass;
    }
    
    public void set_salary(double salary)
    {
        this.salary = salary;
    }
    
    public int get_id()
    {
        return id;
    }
    
    public String get_user_name()
    {
        return user_name;
    }
    
    public String get_name()
    {
        return name;
    }
    
    public int get_age()
    {
        return age;
    }
    
    public int get_password()
    {
        return password;
    }
    
    public Double get_salary()
    {
        return salary;
    }
    
    //public abstract boolean login(String user_name, int password);
}
