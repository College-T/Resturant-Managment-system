/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author eslam
 */
public class Meals implements Serializable,SetData {

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

    @Override
    public void loadFromFile() {
        try {
            m = (ArrayList<Meals>) (Object) obj.read(File_Path);
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    @Override
    public boolean commiteFile() {
        return obj.write(File_Path, m);
    }

    @Override
    public Object search(int id) {
        loadFromFile();
        Meals temp =new Meals();
        int index = getIndex(id);
        if (index != -1) {
            return m.get(index);
        } else {
            return temp;
        }
    }

    //Professors.set(index, x);
    @Override
    public boolean update() {
        loadFromFile();
        int index = getIndex(this.getId());
        if (index != -1 && index == this.getId()) {
            m.set(index, this);
            return commiteFile();
        } else {
            return false;
        }

    }

    @Override
    public boolean delete(int Id) {
        loadFromFile();
        int index = getIndex(Id);
        if (index != -1) {
            m.remove(index);

            return commiteFile();
        } else {
            return false;
        }
    }

    @Override
    public boolean add() {

        loadFromFile();
        m.add(this);
        return commiteFile();
    }

    public int getIndex(int Id) {
        int len = m.size();
        for (int i = 0; i < len; i++) {
            if (m.get(i).Id == Id) {
                return i;
            }
        }

        return -1;
    }

    

    @Override
    public String toString() {
        String Dedails = "";
        loadFromFile();
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
    @Override
    public ArrayList<Object>list()
    {
        loadFromFile();
        return (ArrayList<Object>)(Object)m;
    }

}
