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
public class Meals implements Serializable, standard_operations {

    private final String File_Path = "DataBase/Meals.bin";
    private int Id;
    private String Product_Name;
    private double Cost;
    private double Offer;
    public ArrayList<Meals> m = new ArrayList<Meals>();
    private filemanagement obj = new filemanagement();

    public Meals() {

    }

    public Meals(int id, String product_name, double cost, double offer) {
        Id = id;
        Product_Name = product_name;
        Cost = cost;
        Offer = offer;
    }

    public void Load_From_file() {
        try {
            m = (ArrayList<Meals>) (Object) obj.read(File_Path);
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public boolean Commite_File() {
        return obj.write(File_Path, m);
    }

    

    @Override
    public boolean update(int Id, Object s) {
        Load_From_file();
        int index = Get_Index(Id);
        if (index != -1) {
            m.set(index, (Meals)s);
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
            if (m.get(i).Id == Id) {
                return i;
            }
        }

        return -1;
    }

    public ArrayList<Meals> List() {
        Load_From_file();
        return m;
    }
    
    public Meals search(int id)
    {
        Load_From_file();
        int index = Get_Index(id);
        if(index != -1)
            return m.get(index);
        else return null;
    }
    
    @Override
    public String toString() {
        String Dedails = "";
        Load_From_file();
        int len = m.size();
        for (int i = 0; i < len; i++) {
            Dedails += m.get(i).getId() + " " + m.get(i).get_Product_Name() + " " + m.get(i).getCost() + " " + m.get(i).getOffer() + "\n";
        }
        return Dedails;
    }

    public int getId() {
        return this.Id;
    }

    public String get_Product_Name() {
        return this.Product_Name;
    }

    public double getCost() {
        return this.Cost;
    }

    public double getOffer() {
        return this.Offer;
    }
    
    public void setId(int id) {
        Id = id;
    }

    public void get_Product_Name(String product_name) {
        Product_Name = product_name;
    }

    public void setCost(double cost) {
        Cost = cost;
    }

    public void setOffer(double offer) {
        Offer = offer;
    }

}
