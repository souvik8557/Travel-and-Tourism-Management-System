package tavel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Signup extends JFrame implements ActionListener {
    JButton create,back;
    JTextField tfusername,tfname,tfpassword,tfsecans;
    Choice securityQ;
    
    Signup(){
        setBounds(350,200,900,360);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JPanel p1=new JPanel();
        p1.setBackground(new Color(133,193,233));
        p1.setBounds(0,0,500,400);
        add(p1);
        p1.setLayout(null);
        
        JLabel username=new JLabel("UserName");
        username.setBounds(50,20,120,25);
        username.setFont(new Font("Times New Roman",Font.BOLD,20));
        p1.add(username);
        
        tfusername=new JTextField();
        tfusername.setBounds(190,20,180,25);
        tfusername.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfusername);
        
        JLabel name=new JLabel("Name");
        name.setBounds(50,60,125,25);
        name.setFont(new Font("Times New Roman",Font.BOLD,20));
        p1.add(name);
        
        tfname=new JTextField();
        tfname.setBounds(190,60,180,25);
        tfname.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfname);
        
        JLabel password=new JLabel("password");
        password.setBounds(50,100,125,25);
        password.setFont(new Font("Times New Roman",Font.BOLD,20));
        p1.add(password);
        
        tfpassword=new JTextField();
        tfpassword.setBounds(190,100,180,25);
        tfpassword.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfpassword);
        
        JLabel security=new JLabel("Security Question");
        security.setBounds(50,140,125,25);
        security.setFont(new Font("Times New Roman",Font.BOLD,20));
        p1.add(security);
        
        securityQ = new Choice();
        securityQ.add("Fav character from Criminal Justice");
        securityQ.add("Your BirthDay");
        securityQ.add("Favourite color");
        securityQ.add("Favourite food");
        securityQ.setBounds(190,140,180,25);
        p1.add(securityQ);
        
        JLabel securityans = new JLabel("Security Answer");
        securityans.setBounds(50,180,125,25);
        securityans.setFont(new Font("Times New Roman",Font.BOLD,20));
        p1.add(securityans);
        
        tfsecans=new JTextField();
        tfsecans.setBounds(190,180,180,25);
        tfsecans.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfsecans);
        
        create = new JButton("Create");
        create.setBackground(Color.white);
        create.setForeground(new Color(133,193,233));
        create.setFont(new Font("Times New Roman",Font.BOLD,16));
        create.setBounds(80,250,100,30);
        create.addActionListener(this);
        p1.add(create);
        
        back = new JButton("Back");
        back.setBackground(Color.WHITE);
        back.setForeground(new Color(133,193,233));
        back.setFont(new Font("Times New Roman",Font.BOLD,16));
        back.setBounds(250,250,100,30);
        back.addActionListener(this);
        p1.add(back);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/signup.png"));
        Image i2=i1.getImage().getScaledInstance(250, 250, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(580,50,250,250); 
        add(image);
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()== create){
            String username=tfusername.getText();
            String name=tfname.getText();
            String password=tfpassword.getText();
            String question=securityQ.getSelectedItem();
            String ans=tfsecans.getText();
            
            String query="insert into account values('"+username+"', '"+name+"','"+password+"','"+question+"','"+ans+"')";
            try{
                conn c=new conn();
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Account Created Successfully");
                setVisible(false);
                new Login();
            }catch(Exception e){
                e.printStackTrace();
            }
        }else if(ae.getSource()== back){
            setVisible(false);
            new Login();
        }
    }
    
    public static void main(String[] args){
        new Signup();
    }
}
