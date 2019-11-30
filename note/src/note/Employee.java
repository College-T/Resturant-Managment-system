package note;

import java.io.Serializable;
import java.util.ArrayList;

public class Employee extends Person implements Serializable,SetData{
    
    private final String File_Path = "Employee.bin";
    public ArrayList<Employee> e = new ArrayList<Employee>();
    private filemanagement obj = new filemanagement();

    public Employee() {
    
    }

    
    public void loadFromFile(){
        try {
             e = (ArrayList<Employee>) (Object) obj.read(File_Path);
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
    
    public boolean commiteFile(){
        return obj.write(File_Path, e);
    }
    
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
    
    public boolean update(int id ,Employee x ){
       loadFromFile();
        int index = getIndex(id);
        if (index != -1 && index == x.getId()) {
            e.set(index, x);
            return commiteFile();
        } else {
            return false;
        }
    }
    
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
     public boolean add() {

        loadFromFile();
        e.add(this);
        return commiteFile();
    }
     
     public int getIndex(int id) {
        int len = e.size();
        for (int i = 0; i < len; i++) {
            if (e.get(i).getId() == id) {
                return i;
            }
        }

        return -1;
    }

     public ArrayList<Employee> list(){
        loadFromFile();
        return e;
    }


}