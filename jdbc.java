import java.sql.*;
import java.sql.Connection;
import java.util.Scanner;
public class mysql {
       public static void main(String[] args) {
 try{ 
String name=null;
String pname=null;
int quantity;
Scanner sc=new Scanner(System.in);
System.out.print("Enter the Customer name,product name and quentity");
name=sc.next();
pname=sc.next();
quantity=sc.nextInt();
Class.forName("com.mysql.cj.jdbc.Driver"); 
Connection   con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","leovaldez"); 
Statement stmt=con.createStatement();
PreparedStatement ps=con.prepareStatement("insert into inventory values(?,?,?)"); 

ps.setString(1,name); 
ps.setString(2,pname); 
ps.setInt(3,quantity);
ps.executeUpdate();
System.out.println("Successfully");
ResultSet rs=stmt.executeQuery("select * from inventory"); 
while(rs.next()) 
System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getInt(3));
System.out.println("Successfully");
con.close(); 
}catch(Exception e){ System.out.println(e);} 
} 
}