package tavel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class About extends JFrame implements ActionListener{
    JButton back;
    About(){
        setBounds(600,200,500,550);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        
        JLabel text=new JLabel ("ABOUT");
        text.setBounds(200,10,100,40);
        text.setFont(new Font("Tahoma",Font.BOLD,20));
        text.setForeground(Color.RED);
        add(text);
        
        String s="Introduction: The purpose is to develop a management system for the travel and tourism industry.\n" +
"\n" +
"Objectives: This project providing a user-friendly platform for travelers to book tours and activities, streamlining the booking and payment process, and providing real-time updates on availability and pricing.\n" +
"\n" +
"Features: Features of the management system, including the user interface, payment gateway integration, booking and reservation management, and customer relationship management.\n" +
"\n" +
"Methodology: Methodology used to develop the system, such as the programming languages and tools used, the design process, and any testing or quality assurance measures.\n" +
"\n" +
"Results: Results achieved, such as the number of bookings made through the system, customer feedback, and any improvements made to the system based on feedback.\n" +
"\n" +
"Benefits: Benefits of the system for travelers, tour operators, and other stakeholders in the travel and tourism industry. This could include improved efficiency, reduced costs, increased revenue, and enhanced customer satisfaction.\n" +
"\n" ;
        
        TextArea area=new TextArea(s,10,40,Scrollbar.VERTICAL);
        area.setEditable(false);
        area.setBounds(20,100,450,300);
        add(area);
        
        
        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setFont(new Font("Times New Roman",Font.BOLD,16));
        back.setBounds(200,420,100,25);
        back.addActionListener(this);
        add(back);
        
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
            setVisible(false);
    }
    
    public static void main(String[] args){
        new About();
    }
}
