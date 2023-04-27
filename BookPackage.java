package tavel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class BookPackage extends JFrame implements ActionListener{
    Choice cpackage;
    JTextField tfpersons;
    JLabel labelusername,labelnumber,labelid,labelphone,labelprice;
    String username;
    JButton checkprice, BookPackage,Back;
    BookPackage(String username){
        this.username=username;
        
        setBounds(350,200,1100,500);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        
        JLabel text=new JLabel("Book Packages");
        text.setBounds(100,10,200,30);
        text.setFont(new Font("Tahoma",Font.BOLD,20));
        text.setForeground(Color.RED);
        add(text);
        
        JLabel lblusername=new JLabel("Username");
        lblusername.setFont(new Font("Tahoma",Font.PLAIN,16));
        lblusername.setBounds(40,70,100,20);
        add(lblusername);
        
        labelusername=new JLabel();
        labelusername.setFont(new Font("Tahoma",Font.PLAIN,16));
        labelusername.setBounds(250,70,200,20);
        add(labelusername);
        
        JLabel lbpackage=new JLabel("Select Package");
        lbpackage.setFont(new Font("Tahoma",Font.PLAIN,16));
        lbpackage.setBounds(40,110,150,20);
        add(lbpackage);
        
        cpackage=new Choice();
        cpackage.add("Gold Package");
        cpackage.add("Silver Package");
        cpackage.add("Bronze Package");
        cpackage.setBounds(250,110,200,20);
        add(cpackage);
        
        
        JLabel lblpersons=new JLabel("Total Persons");
        lblpersons.setBounds(40,150,150,25);
        lblpersons.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lblpersons);
        
        tfpersons =new JTextField("2");
        tfpersons.setBounds(250,150,200,25);
        add(tfpersons);
        
        JLabel lblid=new JLabel("ID");
        lblid.setBounds(40,190,150,20);
        lblid.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lblid);
        
        labelid=new JLabel();
        labelid.setBounds(250,190,200,25);
        add(labelid);
        
        JLabel lblnumber=new JLabel("Number");
        lblnumber.setBounds(40,220,150,25);
        lblnumber.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lblnumber);
        
        labelnumber=new JLabel();
        labelnumber.setBounds(250,230,150,25);
        add(labelnumber);
        
        JLabel lblphone=new JLabel("Phone");
        lblphone.setBounds(40,270,150,20);
        lblphone.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lblphone);
        
        labelphone=new JLabel();
        labelphone.setBounds(250,270,200,25);
        add(labelphone);
        
        JLabel lbltotal=new JLabel("Total Price");
        lbltotal.setBounds(40,310,150,25);
        lbltotal.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lbltotal);
        
        labelprice=new JLabel();
        labelprice.setBounds(250,310,150,25);
        add(labelprice);
        
        try{
            conn c=new conn();
            String query="select * from customer where username='"+username+"'";
            ResultSet rs= c.s.executeQuery(query);
            while(rs.next()){
                labelusername.setText(rs.getString("username"));
                labelid.setText(rs.getString("id"));
                labelnumber.setText(rs.getString("number"));
                labelphone.setText(rs.getString("phone"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        
        checkprice = new JButton("Check Package");
        checkprice.setBackground(Color.BLACK);
        checkprice.setForeground(Color.WHITE);
        checkprice.setFont(new Font("Times New Roman",Font.BOLD,16));
        checkprice.setBounds(60,380,120,25);
        checkprice.addActionListener(this);
        add(checkprice);
        
        BookPackage = new JButton("Book Package");
        BookPackage.setBackground(Color.BLACK);
        BookPackage.setForeground(Color.WHITE);
        BookPackage.setFont(new Font("Times New Roman",Font.BOLD,16));
        BookPackage.setBounds(200,380,120,25);
        BookPackage.addActionListener(this);
        add(BookPackage);
        
        Back = new JButton("Back");
        Back.setBackground(Color.BLACK);
        Back.setForeground(Color.WHITE);
        Back.setFont(new Font("Times New Roman",Font.BOLD,16));
        Back.setBounds(340,380,120,25);
        Back.addActionListener(this);
        add(Back);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/bookpackage.jpg"));
        Image i2=i1.getImage().getScaledInstance(500, 300, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(550,50,500,300); 
        add(image);
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==checkprice){
            String pack=cpackage.getSelectedItem();
            int cost=0;
            if(pack.equals("Gold Package")){
                cost+=12000;
            }else if(pack.equals("Silver Package")){
                cost+=25000;
            }else{
                cost+=32000;
            }
            int persons=Integer.parseInt(tfpersons.getText());
            cost*=persons;
            labelprice.setText("Rs. "+cost);
        }
        else if(ae.getSource()==BookPackage){
            try{
                conn c= new conn();
                c.s.executeUpdate("Insert into bookpackage values('"+labelusername.getText()+"','"+cpackage.getSelectedItem()+"','"+tfpersons.getText()+"','"+labelid.getText()+"','"+labelnumber.getText()+"','"+labelphone.getText()+"','"+labelprice.getText()+"')");
                JOptionPane.showMessageDialog(null,"Package Booked Successfully");
                setVisible(false);
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        else if(ae.getSource()==Back){
            new UpdateCustomer(username);
        }
    }
    
    public static void main(String[] args){
        new BookPackage("souvik");
    }
}
