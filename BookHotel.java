package tavel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class BookHotel extends JFrame implements ActionListener{
    Choice chotel,cac,cfood;
    JTextField tfpersons,tfdayes;
    JLabel labelusername,labelnumber,labelid,labelphone,labelprice;
    String username;
    JButton checkprice, BookPackage,Back;
    BookHotel(String username){
        this.username=username;
        
        setBounds(350,200,1100,600);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        
        JLabel text=new JLabel("BOOK HOTEL");
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
        
        JLabel lbpackage=new JLabel("Select Hotel");
        lbpackage.setFont(new Font("Tahoma",Font.PLAIN,16));
        lbpackage.setBounds(40,110,150,20);
        add(lbpackage);
        
        chotel=new Choice();
        chotel.setBounds(250,110,200,20);
        add(chotel);
        
        try{
            conn c=new conn();
            ResultSet rs=c.s.executeQuery("select * from hotel");
            while(rs.next()){
                chotel.add(rs.getString("name"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
            
        JLabel lblpersons=new JLabel("Total Persons");
        lblpersons.setBounds(40,150,150,25);
        lblpersons.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lblpersons);
        
        tfpersons =new JTextField("2");
        tfpersons.setBounds(250,150,200,25);
        add(tfpersons);
        
        JLabel lbldayes=new JLabel("No of Dayes");
        lbldayes.setBounds(40,190,150,25);
        lbldayes.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lbldayes);
        
        tfdayes =new JTextField("1");
        tfdayes.setBounds(250,190,200,25);
        add(tfdayes);
        
        JLabel lblac=new JLabel("AC/NON-AC");
        lblac.setBounds(40,230,150,25);
        lblac.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lblac);
        
        cac=new Choice();
        cac.add("AC");
        cac.add("Non-AC");
        cac.setBounds(250,230,200,20);
        add(cac);
        
        JLabel lblfood=new JLabel("Food Included");
        lblfood.setBounds(40,270,150,25);
        lblfood.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lblfood);
        
        cfood=new Choice();
        cfood.add("YES");
        cfood.add("NO");
        cfood.setBounds(250,270,200,20);
        add(cfood);
        
        JLabel lblid=new JLabel("ID");
        lblid.setBounds(40,310,150,20);
        lblid.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lblid);
        
        labelid=new JLabel();
        labelid.setBounds(250,310,200,25);
        add(labelid);
        
        JLabel lblnumber=new JLabel("Number");
        lblnumber.setBounds(40,350,150,25);
        lblnumber.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lblnumber);
        
        labelnumber=new JLabel();
        labelnumber.setBounds(250,350,150,25);
        add(labelnumber);
        
        JLabel lblphone=new JLabel("Phone");
        lblphone.setBounds(40,390,150,20);
        lblphone.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lblphone);
        
        labelphone=new JLabel();
        labelphone.setBounds(250,390,200,25);
        add(labelphone);
        
        JLabel lbltotal=new JLabel("Total Price");
        lbltotal.setBounds(40,430,150,25);
        lbltotal.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lbltotal);
        
        labelprice=new JLabel();
        labelprice.setBounds(250,430,150,25);
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
        
        checkprice = new JButton("Check Price");
        checkprice.setBackground(Color.BLACK);
        checkprice.setForeground(Color.WHITE);
        checkprice.setFont(new Font("Times New Roman",Font.BOLD,16));
        checkprice.setBounds(60,490,120,25);
        checkprice.addActionListener(this);
        add(checkprice);
        
        BookPackage = new JButton("Book Hotel");
        BookPackage.setBackground(Color.BLACK);
        BookPackage.setForeground(Color.WHITE);
        BookPackage.setFont(new Font("Times New Roman",Font.BOLD,16));
        BookPackage.setBounds(200,490,120,25);
        BookPackage.addActionListener(this);
        add(BookPackage);
        
        Back = new JButton("Back");
        Back.setBackground(Color.BLACK);
        Back.setForeground(Color.WHITE);
        Back.setFont(new Font("Times New Roman",Font.BOLD,16));
        Back.setBounds(340,490,120,25);
        Back.addActionListener(this);
        add(Back);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/book.jpg"));
        Image i2=i1.getImage().getScaledInstance(550, 400, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(500,50,550,400); 
        add(image);
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==checkprice){
            try{
                conn c=new conn();
                ResultSet rs=c.s.executeQuery("select * from hotel where name ='"+chotel.getSelectedItem()+"'");
                while(rs.next()){
                    int cost=Integer.parseInt(rs.getString("costperperson"));
                    int food=Integer.parseInt(rs.getString("foodincluded"));
                    int ac=Integer.parseInt(rs.getString("acroom"));
                    
                    int persons=Integer.parseInt(tfpersons.getText());
                    int days=Integer.parseInt(tfdayes.getText());
                    
                    String acprice=cac.getSelectedItem();
                    String foodselected=cfood.getSelectedItem();
                    
                    if(persons*days>0){
                        int total=0;
                        total+=acprice.equals("AC")? ac:0;
                        total+=foodselected.equals("YES")? food:0;
                        total+=cost;
                        total=total*persons*days;
                        labelprice.setText("Rs: "+total);
                    }else{
                        JOptionPane.showMessageDialog(null,"Please Enter a valid Number");
                    }    
                }
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        else if(ae.getSource()==BookPackage){
            try{
                conn c= new conn();
                c.s.executeUpdate("Insert into bookhotel values('"+labelusername.getText()+"','"+chotel.getSelectedItem()+"','"+tfpersons.getText()+"','"+tfdayes.getText()+"','"+cac.getSelectedItem()+"','"+cfood.getSelectedItem()+"','"+labelid.getText()+"','"+labelnumber.getText()+"','"+labelphone.getText()+"','"+labelprice.getText()+"')");
                JOptionPane.showMessageDialog(null,"Hotel Booked Successfully");
                setVisible(false);
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        else if(ae.getSource()==Back){
            setVisible(false);
        }
    }
    
    public static void main(String[] args){
        new BookHotel("souvik");
    }
}
