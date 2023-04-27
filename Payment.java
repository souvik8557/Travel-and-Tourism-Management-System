package tavel.management.system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Payment extends JFrame implements ActionListener{
    JButton pay,back;
    Payment(){
        setBounds(500,200,800,600);
        setLayout(null);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/paytm.jpeg"));
        Image i2=i1.getImage().getScaledInstance(800, 600, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0,0,800,600); 
        add(image);
        
        pay = new JButton("Pay >>");
        pay.setBackground(Color.BLUE);
        pay.setForeground(Color.WHITE);
        pay.setFont(new Font("Times New Roman",Font.BOLD,16));
        pay.setBounds(670,490,80,40);
        pay.addActionListener(this);
        image.add(pay);
        
        back = new JButton("Back");
        back.setBackground(Color.BLUE);
        back.setForeground(Color.WHITE);
        back.setFont(new Font("Times New Roman",Font.BOLD,16));
        back.setBounds(20,490,80,40);
        back.addActionListener(this);
        image.add(back);
        
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==pay){
            setVisible(false);
            new Paytm();
        }
        else if(ae.getSource()==back){
            setVisible(false);
        }
    }
    
    public static void main(String[]args){
        new Payment();
    }
}
