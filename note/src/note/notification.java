/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package note;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author elnopy
 */
public class notification implements Serializable{
    private String notification;
    private boolean flag;
    private  final String filepath="notification.bin";
    public filemanagement m=new filemanagement();
    private  ArrayList<notification>notifications=new ArrayList<notification>();

    public notification(String notification) {
        this.notification = notification;
        this.flag = false;
    }

    public String getNotification() {
        return notification;
    }

    public void setNotification(String notification) {
        this.notification = notification;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

   
   public void loadFromFile()//This fun get all Data  from file and put it in ArrayList
    {
        try{
           notifications = (ArrayList <notification >)(Object) m.read(filepath);          
        }
        catch(Exception e)
        {
            System.out.println(e);
        }

    }

    public boolean commitFile()//This fun get all data in ArrayList and set it in File
    {
        return m.write(filepath, m);
    }
    public boolean add()//This fun use loadFromFile and add naw date in array thin use commitFile to save changes
    {
        loadFromFile();
       notifications.add(this);
       return  commitFile();
    }
     public ArrayList<notification> read()//This fun use loadFromFile and check if notification readed or not if not set flag =1 and return array have date that have not readed yet
    {
        ArrayList<notification>l=new ArrayList<>();
        loadFromFile();
       for(notification m:notifications)
       {
           if(m.flag==false)
           {
               l.add(m);
               m.setFlag(true);
           }
       }
       return l;
       
    }
}
