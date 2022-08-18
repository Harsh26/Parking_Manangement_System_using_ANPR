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
import java.sql.Statement;
import javax.swing.*;
import java.util.UUID;
import java.time.format.DateTimeFormatter;  
import java.time.LocalDateTime;    

/**
 *
 * @author Admin
 */
public class insert 
{
     static int i;
    insert(){
        
        JFrame f1=new JFrame();
        JButton b=new JButton("Insert");
        JLabel l1=new JLabel("Enter Vechile No.:");
       // String num;
        JTextField t1 =new JTextField(" ");
        
        l1.setBounds(150,60,100,30);
        t1.setBounds(300,60,100,30);
        b.setBounds(300,100,100,50);
        
        f1.add(l1);f1.add(t1);f1.add(b);
        
         f1.setTitle("Add Vehicle");
        f1.setSize(400,400);  
        f1.setLayout(null);  
        f1.setVisible(true);
        f1.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
         
        b.addActionListener(new ActionListener(){  
        @Override
        public void actionPerformed(ActionEvent e)
        {
            String num;
         num=t1.getText();    
         UUID t = UUID.randomUUID();
         DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
         LocalDateTime now = LocalDateTime.now();  
         String dt = dtf.format(now);
         int Charge=100;
         String token=t.toString();
        try{
        Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
       Connection con=DriverManager.getConnection("jdbc:ucanaccess://Parking.accdb");
        if(con!=null){
            Statement stm = con.createStatement();
          
            PreparedStatement ps=con.prepareStatement("INSERT INTO Parking(Token_Number,DateTime,License_Plate_Number,Charges)"
                   + "VALUES(?,?,?,?)");
              //Setting values for Each Parameter
             ps.setString(1,token);
               ps.setString(2,dt);
               ps.setString(3,num);
               ps.setInt(4,Charge);
              //Executing Query
              ps.executeUpdate();
              //System.out.println("data inserted successfully");
            JOptionPane.showMessageDialog(f1.getComponent(0), "data inserted successfully");
          
        
   }
   
} catch (Exception ex) {
ex.printStackTrace();
}
  }  
    });  
}
   
}