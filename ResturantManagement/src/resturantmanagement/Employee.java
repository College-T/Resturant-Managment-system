/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package resturantmanagement;


import java.io.Serializable;
import java.util.ArrayList;

public class Employee extends Person implements Serializable,SetData{
    
    private final String File_Path = "Employee.bin";
    private ArrayList<Employee> e = new ArrayList<>();
   filemanagement obj = new filemanagement();
   private int salary;
  private String userName;
    private String password;
    private int role;
    public Employee() {
    
    }

    public Employee(String FName, String LName, int id, String userName, String password,int salary) {
        super(FName, LName, id);
        this.salary=salary;
        this.userName=userName;
        this.password=password;
        this.role=1;
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

    
    @Override
    public Employee search(int id){
        Employee temp = new Employee();
        loadFromFile ();
        int index = getIndex(id);
        if (index != -1){
            return e.get(index);
        }else {
           return temp;
        }
    }
    private void loadFromFile()
    {
        try{
            e= (ArrayList < Employee >)(Object) obj.read(File_Path);
              
        }
        catch(Exception e)
        {
            System.out.println(e);
        }

    }
    private boolean commitFile()
    {
        return obj.write(File_Path, e);
    }
    @Override
    public boolean update( ){
       loadFromFile();
        int index = getIndex(this.getId());
        if (index != -1 ) {
            e.set(index, this);
            return commitFile();
        } else {
            return false;
        }
    }
    
    @Override
     public boolean delete(int id) {
        loadFromFile();
        int index = getIndex(id);
        if (index != -1) {
            e.remove(index);

            return commitFile();
        } else {
            return false;
        }
    }
    @Override
     public boolean add() {

        loadFromFile();
        e.add(this);
        return commitFile();
    }
     
     private int getIndex(int id) {
        int len = e.size();
        for (int i = 0; i < len; i++) {
            if (e.get(i).getId() == id) {
                return i;
            }
        }

        return -1;
    }

    @Override
     public ArrayList<Object> list(){
        loadFromFile();
        return (ArrayList<Object>)(Object)e;
    }
     public int login(String userName ,String passWord)
     {
         loadFromFile();
         for(Employee m:e)
         {
             if(m.userName.equals(userName)&&m.password.equals(passWord))
             {
                 return role;
             }
         }
       return 0;
     }

   

}