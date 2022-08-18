/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imageprocessing;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Arrays;
import javafx.application.Application;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel; 
import org.jfree.chart.JFreeChart; 
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset; 
import org.jfree.data.category.DefaultCategoryDataset; 
import org.jfree.ui.ApplicationFrame; 
import org.jfree.ui.RefineryUtilities; 
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JFrame;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;


public class Report 
{
   String args;
   static int records;
    Report(){
        try{
        Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
       Connection con=DriverManager.getConnection("jdbc:ucanaccess://Parking.accdb");
       if(con != null)
       {
           Statement stm = con.createStatement();
        String sql = "SELECT COUNT(*) FROM Parking" ;
    PreparedStatement prest = con.prepareStatement(sql);
    ResultSet rs = prest.executeQuery();
    while (rs.next()) {
      records = rs.getInt(1);
    }
   // System.out.println("Number of records: " + records);
       }  
        }catch(Exception e)
        {
        }
        thisCall chart = new thisCall("Parking Usage Statistics", 
         "Currently Parked Users:");
      chart.pack();        
      RefineryUtilities.centerFrameOnScreen( chart );        
      chart.setVisible( true ); 
         
    }
         
   

public static class thisCall extends JFrame
{   
    public thisCall( String applicationTitle , String chartTitle ) {
      super( applicationTitle );        
      JFreeChart barChart = ChartFactory.createBarChart(
         chartTitle,           
         "",            
         "Score",            
         createDataset(),          
         PlotOrientation.VERTICAL,           
         true, true, false);
         
      ChartPanel chartPanel = new ChartPanel( barChart );        
      chartPanel.setPreferredSize(new java.awt.Dimension( 560 , 367 ) );        
      setContentPane( chartPanel ); 
     setDefaultCloseOperation(ApplicationFrame.DISPOSE_ON_CLOSE);
   }
   
   private CategoryDataset createDataset( ) {
      //final String fiat = "";        
      final String audi = "User";        
      final String ford = "";        
      final String ____ = "____";        
      final String ___ = "___";        
      final String users = "Users";        
      final String __ = "__";        
      final DefaultCategoryDataset dataset = 
      new DefaultCategoryDataset( );  

               

      dataset.addValue( 0.0 , audi , ____ );        
      dataset.addValue( records , audi , users );       
      dataset.addValue( 0.0 , audi , ___);        
      dataset.addValue( 0.0 , audi , __);

                    

      return dataset; 
}

}

}