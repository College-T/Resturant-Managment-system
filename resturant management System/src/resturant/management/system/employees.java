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
public class employees extends persons implements Serializable, standard_operations{

    private final String File_Path = "DataBase/persons.bin";
    public ArrayList<persons> m = new ArrayList<persons>();
    private final filemanagement obj = new filemanagement();
    
    public employees() {
    }

    public employees(int id, String user_name, String name, int age, Integer pass, Double salary) {
        super(id, user_name, name, age, pass, salary, 2);
    }
    
    
    public boolean add_customer(int id, String user_name, String name, int age)
    {
        customers c = new customers(id, user_name, name, age);
        return c.add();
    }
    
    public boolean aupdate_customer(int id, String user_name, String name, int age)
    {
        customers c = new customers( id,  user_name,  name,  age);
        return c.update(id, c);
    }
    public boolean delete_customer(int id)
    {
        customers c = new customers();
        return c.delete(id);
    }
    
    public persons search_customer(int id)
    {
        customers c = new customers();
        return c.search(id);
    }
    public ArrayList<persons> listOfCustomer()
    {
        customers c = new customers();
        return c.listOfCustomers();
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
//        Load_From_file();
//        int size = m.size(), i;
//        for(i =0 ; i < size; i++)
//        {
//            if(m.get(i).get_user_name().equals(user_name)) return (m.get(i).get_password() == password && m.get(i).getStatus() == 2);
//        }
//        return false;
//    }
    
    public persons search(int id)
    {
        Load_From_file();
        int index = Get_Index(id);
        if(index != -1)
            return m.get(index);
        else return null;
    }
    
    public ArrayList<persons> listOfEmploees()
    {
        ArrayList<persons> em = new ArrayList<persons>();
        Load_From_file();
        int size = m.size();
        for(int i =0 ; i < size; i++)
        {
            if(m.get(i).getStatus() == 2) em.add(m.get(i));
        }
        return em;
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
