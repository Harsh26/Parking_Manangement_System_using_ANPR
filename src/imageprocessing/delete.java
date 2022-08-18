/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imageprocessing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
//import static jdk.nashorn.internal.runtime.PropertyDescriptor.SET;
//import static org.hsqldb.Tokens.SQL;

/**
 *
 * @author Admin
 */
public class delete 
{
   delete()
   {
      JFrame f1=new JFrame();
        JButton b=new JButton("Delete");
        JLabel l1=new JLabel("Enter Vechile No.:");
       // String num;
        JTextField t1 =new JTextField(" ");
        
        l1.setBounds(150,60,100,30);
        t1.setBounds(300,60,100,30);
        b.setBounds(300,100,100,50);
        
        f1.add(l1);f1.add(t1);f1.add(b);
       
         f1.setTitle("Delete Vehicle");
        f1.setSize(400,400);  
        f1.setLayout(null);  
        f1.setVisible(true);
        f1.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
         
        b.addActionListener(new ActionListener(){  
        @Override
        public void actionPerformed(ActionEvent e)
        {
            int Charge=100;
         String num,token,dt;  
         
         DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
         LocalDateTime now = LocalDateTime.now();  
         String dt2 = dtf.format(now);
         
            num = t1.getText();
            try{
                     Connection con1=DriverManager.getConnection("jdbc:ucanaccess://Parking.accdb");

       PreparedStatement   pstmt = con1.prepareStatement(
  "SELECT Token_Number, DateTime FROM Parking WHERE License_Plate_Number=?"); 
          
       pstmt.setString(1,num);  
         
       
      ResultSet rs = pstmt.executeQuery();
      while (rs.next()) {
          token = rs.getString(1);
          dt=rs.getString(2);
          System.out.print(dt+ ""+token+""+num);
       Connection con2=DriverManager.getConnection("jdbc:ucanaccess://history.accdb");
       PreparedStatement ps=con2.prepareStatement("INSERT INTO history(Token_Number,Arrival_DateTime,Departure_DateTime,License_Plate_Number,Charges)"
                   + "VALUES(?,?,?,?,?)");
              //Setting values for Each Parameter
             ps.setString(1,token);
               ps.setString(2,dt);
               ps.setString(3,dt2);
               ps.setString(4,num);
               ps.setInt(5,Charge);
               
              //Executing Query
              ps.executeUpdate();
         }
            }   catch(Exception ex){
            }
        String SQL_DELETE = "DELETE FROM Parking WHERE License_Plate_Number=?";
         
        try{
        Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
       Connection con=DriverManager.getConnection("jdbc:ucanaccess://Parking.accdb");
       PreparedStatement preparedStatement = con.prepareStatement(SQL_DELETE);
        if(con!=null){
            Statement stm = con.createStatement();
      

            preparedStatement.setString(1, num);

           
            
            
            
            int row = preparedStatement.executeUpdate();

        
            JOptionPane.showMessageDialog(f1.getComponent(0), "data deleted successfully");
            
             
      
        
   }
   
} catch (Exception ex) {
ex.printStackTrace();
}
  }  
    });  
}   
   }

