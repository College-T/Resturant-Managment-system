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
public  class Person {
    private String FName;
    private String LName;
    private int id;
    private String userName;
    private String password;
    private  int role;
     protected final String File_Path = "Employee.bin";
    protected ArrayList<Employee> e = new ArrayList<Employee>();
    protected filemanagement obj = new filemanagement();

    public Person() {
    }

    public Person(String FName, String LName, int id, String userName, String password, int role) {
        this.FName = FName;
        this.LName = LName;
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.role = role;
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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }
    
      
     
    
      
}
