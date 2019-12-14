
package GUI;

import internal_frames.editEmployee;

import internal_panals.listEmployee;
import internal_panals.updateEmployee;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import GUI.buttoncustom;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.WindowConstants;
import resturantmanagement.imagepanal;


public class AdminGui extends JFrame {
      buttoncustom Employee,Meal;
    
      mealsG p=new mealsG();
     editEmployee m=new editEmployee();
    public AdminGui() {
       
       setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Admin");
        setResizable(false);
        setLayout(null);
        setSize(1000, 700);
        inintComponent();
        BufferedImage myImage = null;
        try {
            myImage = ImageIO.read(new File("hello.jpg"));
        } catch (Exception e) {
        }
        imagepanal background = new imagepanal(myImage);
        this.add(background, BorderLayout.CENTER);
        background.setSize( 1000, 700);
       
    }
    public void inintComponent()
    {
        m.setOpaque(false);
        m.setVisible(true);
        p.setOpaque(false);
        p.setVisible(false);
        add(p);
        add(m);
        Employee =new buttoncustom("edit Employee");
        Meal=new buttoncustom("edit Meals");
        Employee.setBounds(350, 0, 130, 20);
        Meal.setBounds(550, 0, 100, 20);
         add(Employee);
         add(Meal);
         Employee.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                m.setVisible(true);
                p.setVisible(false);
                
            }
        });
         Meal.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
               p.setVisible(true);
               m.setVisible(false);
             
                
            }
        });
         
        
        
        
    }
    
}
