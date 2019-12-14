package internal_panals;

import java.awt.Dimension;
import java.util.ArrayList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import resturantmanagement.Employee;

public class listEmployee extends JPanel {

    JTable Employees;
    JScrollPane sc;
    String data[][];
    String header[] = {"Id","first name", "last name", "user name", "password"};
    ArrayList<Employee> l = (ArrayList<Employee>) (Object) new Employee().list();

    public listEmployee() {
        super(null);
         this.setOpaque(false);
        showTable();
    }

    private void showTable() {
        

        data = new String[l.size()][5];
        for (int i = 0; i < l.size(); i++) {
           data[i][0]=String.valueOf(l.get(i).getId());
           data[i][1]=l.get(i).getFName();
           data[i][2]=l.get(i).getLName();
           data[i][3]=l.get(i).getPassword();
           data[i][4]=l.get(i).getUserName();
        }
       Employees = new JTable(data,header);
        sc = new JScrollPane(Employees);
        sc.setBounds(210, 180, 300, 300);
        add(sc);
        
    }
    @Override
     public Dimension getPreferredSize()
     {
         return new Dimension(602, 550);
     }
}
