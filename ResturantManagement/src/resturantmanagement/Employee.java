/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package resturantmanagement;


import java.io.Serializable;
import java.util.ArrayList;

public class Employee extends Person implements Serializable,SetData{
    
   
    public Employee() {
    
    }

    public Employee(String FName, String LName, int id, String userName, String password, int role) {
        super(FName, LName, id, userName, password, role);
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

}