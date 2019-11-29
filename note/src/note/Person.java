
package note;

import java.util.ArrayList;

/**
 *
 * @author elnopy
 */
public  class Person {
    private String FName;
    private String LName;
    private int id;
    private String userName;
    private String password;
    private  int role;
    private  filemanagement file=new filemanagement();
    ArrayList<Employee> emp=new ArrayList<>();
    private final String filePath="employee.bin";

    public String getFName() {
        return FName;
    }

    public void setFName(String FName) {
        this.FName = FName;
    }

    public String getLName() {
        return LName;
    }

    public void setLName(String LName) {
        this.LName = LName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }
    
      private void loadFromFile()
    {
        try{
            emp = (ArrayList < Employee >)(Object) file.read(filePath);

        }
        catch(Exception e)
        {
            System.out.println(e);
        }

    }
     private boolean commitFile()
    {
        return file.write(filePath, emp);
    }
    public  int login(String UserName ,String PassWord)
    {
        loadFromFile();
        for(Employee emp1:emp)
        {
            if(emp1.getUserName()==UserName && emp1.getPassword()==PassWord )
            {
                return emp1.getRole();
            }
        }
        return -1;
    }
      
}
