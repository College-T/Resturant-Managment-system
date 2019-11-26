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
public class Meals implements Serializable{
    
    private final String File_Path = "Meals.bin";
    private int Id;
    private String Product_Name;
    private double Cost;
    private double Offer;
    public ArrayList<Meals> m = new ArrayList<Meals>();
    private File_Managment obj = new File_Managment();
    
    public Meals()
    {
        
    }
    
    public Meals(int id, String product_name, double cost, double offer)
    {
        Id = id;
        Product_Name = product_name;
        Cost = cost;
        Offer = offer;
    }
    
    public void Load_From_file()
    {
        try{
            m = (ArrayList<Meals>) obj.Read(File_Path);
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        
    }
    
    public boolean Commite_File()
    {
        return obj.Write(File_Path, m);
    }
    
    public String Search(int Id)
    {
        if(obj.size(File_Path))
        {
            Load_From_file();
        }
        int index = Get_Index(Id);
        if(index != -1)
            return "Details: " + m.get(index).getId() + " " + m.get(index).get_Product_Name() + " " + m.get(index).getCost() + " " + m.get(index).getOffer() + "\n";
        else return "NO Details\n";
    }
    //Professors.set(index, x);
    public Boolean Update(int Id, Meals s)
    {
        if(obj.size(File_Path))
        {
            Load_From_file();
        }
        int index = Get_Index(Id);
        if(index != -1 && index == s.getId())
        {
            m.set(index, s);
            return Commite_File();
        }else return false;
        
    }
    
    public Boolean Delete(int Id)
    {
        if(obj.size(File_Path))
        {
            Load_From_file();
        }
        int index = Get_Index(Id);
        if(index != -1)
        {
            m.remove(index);
            
            return Commite_File();
        }else return false;
    }
    
    public Boolean Add()
    {
        
        if(obj.size(File_Path))
        {
            Load_From_file();
        }
        m.add(this);
        return Commite_File(); 
    }
    
    public int Get_Index(int Id)
    {
        int len = m.size();
        for(int i = 0; i < len; i++)
        {
            if(m.get(i).Id == Id) return i;
        }
        
        return -1;
    }
    
    public ArrayList<Meals> List()
    {
        Load_From_file();
        return m;
    }
    
    @Override
    public String toString()
    {
        String Dedails = "";
        if(obj.size(File_Path))
        {
            Load_From_file();
        }
        int len = m.size();
        for(int i = 0; i < len; i++)
        {
            Dedails += m.get(i).getId() + " " + m.get(i).get_Product_Name() + " " + m.get(i).getCost() + " " + m.get(i).getOffer() + "\n";
        }
        return Dedails;
    }
    public int getId()
    {
        return this.Id;
    }
    
    public String get_Product_Name()
    {
        return this.Product_Name;
    }
    
    public double getCost()
    {
        return this.Cost;
    }
    
    public double getOffer()
    {
        return this.Offer;
    }
}
