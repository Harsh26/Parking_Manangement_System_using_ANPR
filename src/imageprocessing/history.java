/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imageprocessing;

/**
 *
 * @author Admin
 */
 import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.sql.*;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.Dimension;
import java.io.IOException;
import java.util.Date.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import net.proteanit.sql.DbUtils;
public class history  
{
    JFrame f=new JFrame("History");
    history(){
    String[] columnNames = {"Tok",
                              "At",
                               "Dt",
                               "Lic","chg"
                               };
  Object[] row =new Object[1000];
 // JLabel lbl=new JLabel("Add New Property");
  //lbl.setBounds(100,200,200,100);
  //lbl.setVisible(true);
 // f.add(lbl);
  //invntryfrm.setVisible(true);
  JPanel panel=new JPanel();
  panel.setBounds(20,200,680,100);
  panel.setBackground(Color.WHITE);
  f.add(panel);
  DefaultTableModel model=new DefaultTableModel();
  model.setColumnIdentifiers(columnNames);
  JTable tabel=new JTable();
 

  tabel.setBounds(200,300,1000,800);
  tabel.setBackground(Color.DARK_GRAY);
  tabel.setForeground(Color.WHITE);
  tabel.setRowHeight(30);
  
  tabel.setModel(model);
  tabel.setPreferredScrollableViewportSize(new Dimension(1500,1000));
  tabel.setFillsViewportHeight(true);
  JScrollPane pane=new JScrollPane(tabel);
  panel.add(pane);
  try{
      Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
       Connection con=DriverManager.getConnection("jdbc:ucanaccess://history.accdb");
 // Connection conn=DriverManager.getConnection("jdbc:ucanaccess.accdb");
 
                               String sql="select * from history";
                               PreparedStatement pst=con.prepareStatement(sql);
                               ResultSet rs=pst.executeQuery();
                               tabel.setModel(DbUtils.resultSetToTableModel(rs)); 
   }
   catch(Exception ex)
   {
       JOptionPane.showMessageDialog(null, ex);
   }
     f.setSize(200, 300);  
        f.setLocationRelativeTo(null);  
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        f.setVisible(true);  
        f.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
    }
    
}

