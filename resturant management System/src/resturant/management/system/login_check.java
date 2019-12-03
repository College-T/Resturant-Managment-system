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
public class login_check implements Serializable{
    
    private static final String File_Path = "DataBase/persons.bin";
    public static ArrayList<persons> m = new ArrayList<persons>();
    private static final filemanagement obj = new filemanagement();
    private static int size, i;
    
    private static void Load_From_file() {
        try {
            m = (ArrayList<persons>) (Object) obj.read(File_Path);
        } catch (Exception e) {
            System.out.println(e);
        }

    }
    
    public static int login(String user_name, int password) {
        Load_From_file();
        size = m.size();
        for(i =0 ; i < size; i++)
        {
            if(m.get(i).get_user_name().equals(user_name) && m.get(i).get_password() == password) return ( m.get(i).getStatus());
        }
        return -1;
    }
    
}
