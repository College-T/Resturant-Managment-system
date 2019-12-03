/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package resturant.management.system;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import static java.awt.Font.BOLD;
import java.awt.HeadlessException;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import static java.awt.image.ImageObserver.HEIGHT;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author eslam
 */
public class Login extends JFrame{
    
    private JLabel lwelcome = new JLabel("Welcome");
    private JLabel lusername = new JLabel("username");
    private JLabel lpass = new JLabel("password");
    private JTextField tusername = new JTextField();
    private JPasswordField  tpass = new JPasswordField ();
    private JPanel panal = new JPanel();
    private JButton log = new JButton("login");
    public Login() throws HeadlessException {
        setSize(600, 600);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Login Form");
        Container cp = getContentPane();
        panal.setSize(600, 600);
        panal.setBackground(Color.GRAY);
        panal.setLayout(null);
        cp.add(panal);
        panal.add(lwelcome);
        lwelcome.setBounds(250, 100, 300, 50);
        
        panal.add(lusername);
        lusername.setBounds(180, 150, 300, 50);
        
        panal.add(lpass);
        lpass.setBounds(180, 180, 300, 50);
        
        panal.add(tusername);
        tusername.setBounds(250, 165, 150, 20);
        
        panal.add(tpass);
        tpass.setBounds(250, 195, 150, 20);
        
        panal.add(log);
        log.setBounds(240, 250, 100, 20);
        
        log.addMouseListener(new check());
    }
    
    private class check extends MouseAdapter
    {

        @Override
        public void mouseClicked(MouseEvent e) {
            
            int i = login_check.login(tusername.getText().toString(), Integer.parseInt(tpass.getText()));
            if(i != -1)
            {
                if(i == 1) JOptionPane.showMessageDialog(null, "welcome admin", "login", HEIGHT);
                else JOptionPane.showMessageDialog(null, "welcome employee", "login", HEIGHT);
            }else JOptionPane.showMessageDialog(null, "kos omak", "login", HEIGHT);
        }
        
    }
}
