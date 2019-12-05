/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package resturantmanagement;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;



public class admin extends Person implements Serializable{
   private final String filePath="Employee.bin";
   private ArrayList <admin> admins=new ArrayList<>();
   filemanagement obj=new filemanagement();
   private String userName;
   private String passWord;
  private int salary;
   private int role;
    public admin(){};
    
    public admin(String FName, String LName, int id,String userName,String PassWord) {
        super(FName, LName, id);
        this.role=2;
        this.passWord=PassWord;
        this.userName=userName;
    }
    private void loadFromFile()
    {
        try{
            admins= (ArrayList < admin >)(Object) obj.read(filePath);
              
        }
        catch(Exception e)
        {
            System.out.println(e);
        }

    }
    private boolean commitFile()
    {
        return obj.write(filePath, admins);
    }
   private int getIndex(int id) {
        int len = admins.size();
        for (int i = 0; i < len; i++) {
            if (admins.get(i).getId() == id) {
                return i;
            }
        }

        return -1;
    }
    public boolean update( ){
       loadFromFile();
        int index = getIndex(this.getId());
        if (index != -1 ) {
            admins.set(index, this);
            return commitFile();
        } else {
            return false;
        }
    }
 
     public boolean add() {

        loadFromFile();
        admins.add(this);
        return commitFile();
    }
     public int login(String userName ,String passWord)
     {
         loadFromFile();
         for(admin m:admins)
         {
             if(m.userName.equals(userName)&&m.passWord.equals(passWord))
             {
                 return role;
             }
         }
        
         return 0;
         
       
     }

    
    
}
