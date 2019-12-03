/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package resturant.management.system;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author eslam
 */
public class customers extends persons implements Serializable, standard_operations{

    private final String File_Path = "DataBase/persons.bin";
    public ArrayList<persons> m = new ArrayList<persons>();
    private final filemanagement obj = new filemanagement();
    
    public customers() {
    }

    public customers(int id, String user_name, String name, int age) {
        super(id, user_name, name, age, null, null, 3);
    }

    public boolean Commite_File() {
        return obj.write(File_Path, m);
    }
    
    public void Load_From_file() {
        try {
            m = (ArrayList<persons>) (Object) obj.read(File_Path);
        } catch (Exception e) {
            System.out.println(e);
        }

    }
    
//    @Override
//    public boolean login(String user_name, int password) {
//        return false;
//    }
    
    public ArrayList<persons> listOfCustomers()
    {
        ArrayList<persons> em = new ArrayList<>();
        Load_From_file();
        int size = m.size();
        for(int i =0 ; i < size; i++)
        {
            if(m.get(i).getStatus() == 3) em.add(m.get(i));
        }
        return em;
    }
    
    public ArrayList<Order> getProfile(int id)
    {
        Order o = new Order();
        return o.customerProfile(id);
    }
    public persons search(int id)
    {
        Load_From_file();
        int index = Get_Index(id);
        if(index != -1)
            return m.get(index);
        else return null;
    }
    
    @Override
    public boolean update(int Id, Object s) {
        Load_From_file();
        int index = Get_Index(Id);
        if (index != -1) {
            m.set(index, (persons)s);
            return Commite_File();
        } else {
            return false;
        }

    }
    @Override
    public boolean delete(int Id) {
        Load_From_file();
        int index = Get_Index(Id);
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

    public int Get_Index(int Id) {
        int len = m.size();
        for (int i = 0; i < len; i++) {
            if (m.get(i).get_id() == Id) {
                return i;
            }
        }

        return -1;
    }
}
