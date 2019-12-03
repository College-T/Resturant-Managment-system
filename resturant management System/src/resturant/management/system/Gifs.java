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
public class Gifs implements standard_operations, Serializable {
    private final String File_Path = "DataBase/Gifs.bin";
    private int id;
    private String name;
    private double gifs;
    private boolean status;
    public ArrayList<Gifs> G = new ArrayList<Gifs>();
    private filemanagement obj = new filemanagement();

    public Gifs() {

    }

    public Gifs(int id, String name, double gifs) {
        this.id = id;
        this.name = name;
        this.gifs = gifs;
        this.status = true;
    }

    public void set_name(String name) {
        this.name = name;
    }

    public void set_id(int id)
    {
        this.id = id;
    }
    
    public void set_gifs(double gifs) {
        this.gifs = gifs;
    }

    public void set_status(boolean status) {
        this.status = status;
    }

    public String get_name() {
        return name;
    }

    public double get_gifs() {
        return gifs;
    }

    public boolean get_status() {
        return status;
    }
    
    public int get_id()
    {
        return id;
    }

    public int Get_Index(int id) {
        int len = G.size();
        for (int i = 0; i < len; i++) {
            if (G.get(i).get_id() == id) {
                return i;
            }
        }

        return -1;
    }
    
    public Gifs search(int id)
    {
        Load_From_file();
        int index = Get_Index(id);
        if(index != -1)
            return G.get(index);
        else return null;
    }
    
    public ArrayList<Gifs> List() {
        Load_From_file();
        return G;
    }
    
    public void Load_From_file() {
        try {
            G = (ArrayList<Gifs>) (Object) obj.read(File_Path);
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public boolean Commite_File() {
        return obj.write(File_Path, G);
    }
    @Override
    public String toString() {
        String Dedails = "";
        Load_From_file();
        int len = G.size();
        for (int i = 0; i < len; i++) {
            Dedails += G.get(i).get_id()+ " " + G.get(i).get_name() + " " + G.get(i).get_gifs() + " " + G.get(i).get_status() + "\n";
        }
        return Dedails;
    }
    
    public String toNotification() {
        String Dedails = "";
        Load_From_file();
        int len = G.size();
        for (int i = 0; i < len; i++) {
            if(G.get(i).get_status())
            {
                Dedails += G.get(i).get_id() + " " + G.get(i).get_name() + " " + G.get(i).get_gifs() + " " + G.get(i).get_status() + "\n";
                G.get(i).set_status(false);
            }
        }
        Commite_File();
        return Dedails;
    }

    @Override
    public boolean add() {
        Load_From_file();
        G.add(this);
        return Commite_File();
    }

    @Override
    public boolean delete(int id) {
        Load_From_file();
        int index = Get_Index(id);
        if (index != -1) {
            G.remove(index);

            return Commite_File();
        } else {
            return false;
        }
    }

    @Override
    public boolean update(int id, Object s) {
        
        Load_From_file();
        int index = Get_Index(id);
        if (index != -1) {
            G.set(index, (Gifs)s);
            return Commite_File();
        } else {
            return false;
        }
        
    }
}
