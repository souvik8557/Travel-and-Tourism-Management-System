package tavel.management.system;


import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;

public class Paytm extends JFrame implements ActionListener{
    JButton back;
    Paytm(){
        setBounds(500,200,800,600);;
        
        JEditorPane pane=new JEditorPane();
        pane.setEditable(false);
        
        try{
            pane.setPage("https://paytm.com/rent-payment");
        }catch(Exception e){
            pane.setContentType("text/html");
            pane.setText("<html>Could not load, Error 404<html>");
        }
        
        JScrollPane sp=new JScrollPane(pane);
        getContentPane().add(sp);
        
        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setFont(new Font("Times New Roman",Font.BOLD,16));
        back.setBounds(610,20,80,40);
        back.addActionListener(this);
        pane.add(back);
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        setVisible(false);
        new Payment();
    }
    
    public static void main(String[] args){
        new Paytm();
    }
}
