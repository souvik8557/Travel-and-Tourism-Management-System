package tavel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Dashboard extends JFrame implements ActionListener{
    String username;
    JButton addpersonaldetails,viewpersonaldetails,updatepersonaldetails,viewpackages,checkpackages,bookpackages,viewhotels;
    JButton destinations,bookhotels,viewbookedhotels,payment,calculator,notepad,about,deletepersonaldetails;
    Dashboard(String username){
        //setBounds(0,0,1600,1000);
        this.username=username;
        setExtendedState(JFrame.MAXIMIZED_BOTH);        // set full screen
        setLayout(null);
        
        JPanel p1=new JPanel();
        p1.setLayout(null);
        p1.setBackground(new Color(0,0,102));
        p1.setBounds(0,0,1600,65);
        add(p1);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/dashboard.png"));
        Image i2=i1.getImage().getScaledInstance(70, 70, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(5,0,70,70); 
        p1.add(image);
        
        JLabel heading=new JLabel("Dashboard");
        heading.setBounds(80,10,300,40);
        heading.setForeground(Color.WHITE);
        heading.setFont(new Font("Times New Roman",Font.BOLD,30));
        p1.add(heading);
        
        JPanel p2=new JPanel();
        p2.setLayout(null);
        p2.setBackground(new Color(0,0,102));
        p2.setBounds(0,65,300,900);
        add(p2);
        
        addpersonaldetails= new JButton("Add Personal Details");
        addpersonaldetails.setBackground(new Color(0,0,102));
        addpersonaldetails.setForeground(Color.WHITE);
        addpersonaldetails.setFont(new Font("Times New Roman",Font.PLAIN,20));
        addpersonaldetails.setBounds(0,0,300,50);
        addpersonaldetails.setMargin(new Insets(0,0,0,60));
        addpersonaldetails.addActionListener(this);
        p2.add(addpersonaldetails);
        
        updatepersonaldetails= new JButton("Update Personal Details");
        updatepersonaldetails.setBackground(new Color(0,0,102));
        updatepersonaldetails.setForeground(Color.WHITE);
        updatepersonaldetails.setFont(new Font("Times New Roman",Font.PLAIN,20));
        updatepersonaldetails.setBounds(0,50,300,50);
        updatepersonaldetails.setMargin(new Insets(0,0,0,35));
        updatepersonaldetails.addActionListener(this);
        p2.add(updatepersonaldetails);
        
        viewpersonaldetails= new JButton("View Details");
        viewpersonaldetails.setBackground(new Color(0,0,102));
        viewpersonaldetails.setForeground(Color.WHITE);
        viewpersonaldetails.setFont(new Font("Times New Roman",Font.PLAIN,20));
        viewpersonaldetails.setBounds(0,100,300,50);
        viewpersonaldetails.setMargin(new Insets(0,0,0,130));
        viewpersonaldetails.addActionListener(this);
        p2.add(viewpersonaldetails);
        
        deletepersonaldetails= new JButton("Delete Personal Details");
        deletepersonaldetails.setBackground(new Color(0,0,102));
        deletepersonaldetails.setForeground(Color.WHITE);
        deletepersonaldetails.setFont(new Font("Times New Roman",Font.PLAIN,20));
        deletepersonaldetails.setBounds(0,150,300,50);
        deletepersonaldetails.setMargin(new Insets(0,0,0,50));
        deletepersonaldetails.addActionListener(this);
        p2.add(deletepersonaldetails);
        
        checkpackages= new JButton("Check Packages");
        checkpackages.setBackground(new Color(0,0,102));
        checkpackages.setForeground(Color.WHITE);
        checkpackages.setFont(new Font("Times New Roman",Font.PLAIN,20));
        checkpackages.setBounds(0,200,300,50);
        checkpackages.setMargin(new Insets(0,0,0,108));
        checkpackages.addActionListener(this);
        p2.add(checkpackages);
        
        bookpackages= new JButton("Book Packages");
        bookpackages.setBackground(new Color(0,0,102));
        bookpackages.setForeground(Color.WHITE);
        bookpackages.setFont(new Font("Times New Roman",Font.PLAIN,20));
        bookpackages.setBounds(0,250,300,50);
        bookpackages.setMargin(new Insets(0,0,0,120));
        bookpackages.addActionListener(this);
        p2.add(bookpackages);
        
        viewpackages= new JButton("View Packages");
        viewpackages.setBackground(new Color(0,0,102));
        viewpackages.setForeground(Color.WHITE);
        viewpackages.setFont(new Font("Times New Roman",Font.PLAIN,20));
        viewpackages.setBounds(0,300,300,50);
        viewpackages.setMargin(new Insets(0,0,0,120));
        viewpackages.addActionListener(this);
        p2.add(viewpackages);
        
        viewhotels= new JButton("View Hotels");
        viewhotels.setBackground(new Color(0,0,102));
        viewhotels.setForeground(Color.WHITE);
        viewhotels.setFont(new Font("Times New Roman",Font.PLAIN,20));
        viewhotels.setBounds(0,350,300,50);
        viewhotels.setMargin(new Insets(0,0,0,140));
        viewhotels.addActionListener(this);
        p2.add(viewhotels);
        
        bookhotels= new JButton("Book Hotels");
        bookhotels.setBackground(new Color(0,0,102));
        bookhotels.setForeground(Color.WHITE);
        bookhotels.setFont(new Font("Times New Roman",Font.PLAIN,20));
        bookhotels.setBounds(0,400,300,50);
        bookhotels.setMargin(new Insets(0,0,0,135));
        bookhotels.addActionListener(this);
        p2.add(bookhotels);
        
        viewbookedhotels= new JButton("View Booked Hotels");
        viewbookedhotels.setBackground(new Color(0,0,102));
        viewbookedhotels.setForeground(Color.WHITE);
        viewbookedhotels.setFont(new Font("Times New Roman",Font.PLAIN,20));
        viewbookedhotels.setBounds(0,450,300,50);
        viewbookedhotels.setMargin(new Insets(0,0,0,80));
        viewbookedhotels.addActionListener(this);
        p2.add(viewbookedhotels);
        
        destinations= new JButton("Destinations");
        destinations.setBackground(new Color(0,0,102));
        destinations.setForeground(Color.WHITE);
        destinations.setFont(new Font("Times New Roman",Font.PLAIN,20));
        destinations.setBounds(0,500,300,50);
        destinations.setMargin(new Insets(0,0,0,125));
        destinations.addActionListener(this);
        p2.add(destinations);
        
        payment= new JButton("Payment");
        payment.setBackground(new Color(0,0,102));
        payment.setForeground(Color.WHITE);
        payment.setFont(new Font("Times New Roman",Font.PLAIN,20));
        payment.setBounds(0,550,300,50);
        payment.setMargin(new Insets(0,0,0,170));
        payment.addActionListener(this);
        p2.add(payment);
        
        calculator= new JButton("Calculator");
        calculator.setBackground(new Color(0,0,102));
        calculator.setForeground(Color.WHITE);
        calculator.setFont(new Font("Times New Roman",Font.PLAIN,20));
        calculator.setBounds(0,600,300,50);
        calculator.setMargin(new Insets(0,0,0,155));
        calculator.addActionListener(this);
        p2.add(calculator);
        
        notepad= new JButton("Notepad");
        notepad.setBackground(new Color(0,0,102));
        notepad.setForeground(Color.WHITE);
        notepad.setFont(new Font("Times New Roman",Font.PLAIN,20));
        notepad.setBounds(0,650,300,50);
        notepad.setMargin(new Insets(0,0,0,170));
        notepad.addActionListener(this);
        p2.add(notepad);
        
        about= new JButton("About");
        about.setBackground(new Color(0,0,102));
        about.setForeground(Color.WHITE);
        about.setFont(new Font("Times New Roman",Font.PLAIN,20));
        about.setBounds(0,700,300,50);
        about.setMargin(new Insets(0,0,0,200));
        about.addActionListener(this);
        p2.add(about);
        
       ImageIcon im1 =new ImageIcon(ClassLoader.getSystemResource("icons/home.jpg"));
       Image im2= im1.getImage().getScaledInstance(1550, 800 , Image.SCALE_DEFAULT);
       ImageIcon im3= new ImageIcon(im2);
       JLabel image1=new JLabel(im3);
       image1.setBounds(0,0,1550,800);
       add(image1);
       
       JLabel text=new JLabel("Travel And Tourism Management System");
       text.setBounds(400,70,1200,70);
       text.setForeground(Color.WHITE);
       text.setFont(new Font("Raleway",Font.BOLD,55));
       image1.add(text);
        
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==addpersonaldetails){
            new Addcustomer(username);
        }
        else if(ae.getSource()==viewpersonaldetails){
            new ViewCustomer(username);
        }
        else if(ae.getSource()==updatepersonaldetails){
            new UpdateCustomer(username);
        }
        else if(ae.getSource()==checkpackages){
            new CheckPackages();
        }
        else if(ae.getSource()==bookpackages){
            new BookPackage(username);
        }
        else if(ae.getSource()==viewpackages){
            new ViewPackage(username);
        }else if(ae.getSource()==viewhotels){
            new CheckHotels();
        }
        else if(ae.getSource()==destinations){
            new Destinations();
        }
        else if(ae.getSource()==bookhotels){
            new BookHotel(username);
        }
        else if(ae.getSource()==viewbookedhotels){
            new ViewBookedHotels(username);
        }
        else if(ae.getSource()==payment){
            new Payment();
        }
        else if(ae.getSource()==calculator){
            try{
                Runtime.getRuntime().exec("calc.exe");
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        else if(ae.getSource()==notepad){
            try{
                Runtime.getRuntime().exec("notepad.exe");
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        else if(ae.getSource()==about){
            new About();
        }
        else if(ae.getSource()==deletepersonaldetails){
            new DeleteDetails(username);
        }
    }
    
    public static void main(String[] args){
        new Dashboard("");
    }
}
