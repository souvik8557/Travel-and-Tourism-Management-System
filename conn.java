package tavel.management.system;
import java.sql.*;

public class conn {
    Connection c;
    Statement s;
    conn (){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            c=DriverManager.getConnection("jdbc:mysql:///travelmanagementsystem","root","Souvik@2002");
            s=c.createStatement();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
