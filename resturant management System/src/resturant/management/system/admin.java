/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package resturant.management.system;

import com.sun.org.apache.xml.internal.serializer.DOMSerializer;
import java.util.Scanner;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Serializable;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Properties;
import org.xml.sax.ContentHandler;

/**
 *
 * @author eslam
 */
public class admin extends persons implements Serializable, standard_operations{
    private final String File_Path = "DataBase/persons.bin";
    public ArrayList<persons> m = new ArrayList<persons>();
    private final filemanagement obj = new filemanagement();
    
    public admin(){};

    public admin(int id, String user_name, String name, int age, Integer pass, Double salary)
    {
        super(id, user_name, name, age, pass, salary, 1);
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
    
    public boolean add_employee(int id, String user_name, String name, int age, Integer pass, Double salary)
    {
        employees e = new employees(id, user_name, name, age, pass,  salary);
        return e.add();
    }
    
    public boolean aupdate_employee(int id, String user_name, String name, int age, Integer pass, Double salary)
    {
        employees e = new employees(id, user_name, name, age, pass,  salary);
        return e.update(id, e);
    }
    public boolean delete_employee(int id)
    {
        employees e = new employees();
        return e.delete(id);
    }
    
    public persons search_employee(int id)
    {
        employees e = new employees();
        return e.search(id);
    }
    public ArrayList<persons> listOfEmployee()
    {
        employees em = new employees();
        return em.listOfEmploees();
    }
    
    
    // Gifs control
    
    
    public boolean add_gifs(int id, String name, double gifs)
    {
        Gifs m = new Gifs(id, name, gifs);
        return m.add();
    }
    
    public boolean aupdate_gifs(int id, String name, double gifs)
    {
        Gifs m = new Gifs(id, name, gifs);
        return m.update(id, m);
    }
    public boolean delete_gifs(int id)
    {
        Gifs m = new Gifs();
        return m.delete(id);
    }
    
    public Gifs search_gifs(int id)
    {
        Gifs m = new Gifs();
        return m.search(id);
    }
    public ArrayList<Gifs> listOfGifs()
    {
        Gifs m = new Gifs();
        return m.List();
    }
    
    //11111111111111111111111111111111111111111111111111111111111111111111
    
    // meals control
    
    
    public boolean add_meals(int id, String product_name, double cost, double offer)
    {
        Meals m = new Meals(id, product_name, cost, offer);
        return m.add();
    }
    
    public boolean aupdate_meals(int id, String product_name, double cost, double offer)
    {
        Meals m = new Meals(id, product_name, cost, offer);
        return m.update(id, m);
    }
    public boolean delete_meals(int id)
    {
        Meals m = new Meals();
        return m.delete(id);
    }
    
    public Meals search_meals(int id)
    {
        Meals m = new Meals();
        return m.search(id);
    }
    public ArrayList<Meals> listOfmeals()
    {
        Meals m = new Meals();
        return m.List();
    }
    
    //11111111111111111111111111111111111111111111111111111111111111111111
//    @Override
//    public boolean login(String user_name, int password) {
//        Load_From_file();
//        int size = m.size(), i;
//        for(i =0 ; i < size; i++)
//        {
//            if(m.get(i).get_user_name().equals(user_name)) return (m.get(i).get_password() == password && m.get(i).getStatus() == 1);
//        }
//        return false;
//    }
    
    
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
    @Override
    public String toString() {
        Load_From_file();
        String d = "";
        int size = m.size();
        for(int i = 0; i < size; i++)
        {
            
            d += m.get(i).get_id()+ " " + m.get(i).get_user_name() + " " + m.get(i).get_name() + " " + m.get(i).get_age() + " " + m.get(i).get_salary() + " "+m.get(i).getStatus() + "\n";
        }
        return d;
    }
    
}
