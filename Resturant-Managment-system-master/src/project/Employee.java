package project;

import java.io.Serializable;
import java.util.ArrayList;

public class Employee extends Person implements Serializable,SetData{
    
    private final String File_Path = "Employee.bin";
    public ArrayList<Employee> e = new ArrayList<Employee>();
    private filemanagement obj = new filemanagement();

    public Employee() {
    
    }

    
    @Override
    public void loadFromFile(){
        try {
             e = (ArrayList<Employee>) (Object) obj.read(File_Path);
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
    
    @Override
    public boolean commiteFile(){
        return obj.write(File_Path, e);
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
    
    @Override
    public boolean update( ){
       loadFromFile();
        int index = getIndex(this.getId());
        if (index != -1 ) {
            e.set(index, this);
            return commiteFile();
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

            return commiteFile();
        } else {
            return false;
        }
    }
    @Override
     public boolean add() {

        loadFromFile();
        e.add(this);
        return commiteFile();
    }
     
    @Override
     public int getIndex(int id) {
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