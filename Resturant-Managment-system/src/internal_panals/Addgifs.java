/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package internal_panals;

import GUI.buttoncustom;
import GUI.labelcustom;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import resturantmanagement.Gifs;

/**
 *
 * @author nice
 */
public class Addgifs extends JPanel{
    labelcustom pay,gift;
    JTextField payment,giftTxt;
    buttoncustom enter;
    JLabel check;
    public Addgifs()
    {
        setLayout(null);
        setSize(1000, 700);
        initComponent();
        
    }
    public void initComponent()
    {
        pay=new labelcustom("Payment");
        gift =new labelcustom("gift");
        payment=new JTextField();
        giftTxt=new JTextField();
        enter=new buttoncustom("add gifit");
        check=new JLabel();
        pay.setBounds(100, 150, 100, 20);
        payment.setBounds(220, 150, 140, 20);
        gift.setBounds(100, 190, 100, 20);
        giftTxt.setBounds(220,190, 140, 20);
        enter.setBounds(220, 250, 80, 20); enter.setBounds(500, 250, 80, 20);
        add(pay);
        add(payment);
        add(gift);
        add(giftTxt);
        add(enter);
        add(check);
        enter.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if(!payment.getText().equals("")&&!giftTxt.getText().equals("")){
                    
               Gifs m=new Gifs(giftTxt.getText(),Integer.parseInt(payment.getText()));
               m.add();
                    JOptionPane.showMessageDialog(null,"added");
                  }
                else
                    JOptionPane.showMessageDialog(null,"error");
                {
                    check.setText("error");
               check.setForeground(Color.red);
                }
            }
        });
        
    }
}
