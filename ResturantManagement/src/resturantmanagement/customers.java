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
 * @author eslam
 */
public class customers extends Person implements Serializable, SetData{

    private final String File_Path = "Customer.bin";
    public ArrayList<customers> m = new ArrayList<customers>();
    private  filemanagement obj = new filemanagement();
    
    public customers() {
    }

    public customers(String FName, String LName, int id) {
        super(FName, LName, id);
    }

    

    public boolean Commite_File() {
        return obj.write(File_Path, m);
    }
    
    public void Load_From_file() {
        try {
            m = (ArrayList<customers>) (Object) obj.read(File_Path);
        } catch (Exception e) {
            System.out.println(e);
        }

    }
    
//    @Override
//    public boolean login(String user_name, int password) {
//        return false;
//    }
    
    @Override
    public ArrayList<Object> list()
    {
       
        Load_From_file();
        
        return (ArrayList<Object>)(Object) m;
    }
    
    public ArrayList<Order> getProfile(int id)
    {
        Order o = new Order();
        return o.customerProfile(id);
    }
    @Override
    public customers search(int id)
    {
        customers l=new customers();
        Load_From_file();
        int index = getIndex(id);
        if(index != -1)
            return m.get(index);
        else return l;
    }
    
    @Override
    public boolean update() {
        Load_From_file();
        int index = getIndex(this.id);
        if (index != -1) {
            m.set(index, this);
            return Commite_File();
        } else {
            return false;
        }

    }
    @Override
    public boolean delete(int Id) {
        Load_From_file();
        int index = getIndex(Id);
        if (index != -1) {
            m.remove(index);

            return Commite_File();
        } else {
            return false;
        }
    }
    @Override
    public boolean add() {

        Load_From_file();
        m.add(this);
        return Commite_File();
    }

    public int getIndex(int Id) {
        int len = m.size();
        for (int i = 0; i < len; i++) {
            if (m.get(i).getId() == Id) {
                return i;
            }
        }

        return -1;
    }
}
