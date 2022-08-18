/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imageprocessing;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class welcome extends JFrame implements ActionListener{
    
    JFrame f1 = new JFrame("Parking Management Using ANPR");  
    JTextField jt; 
  // JPanel p; 
    JLabel l1,l2,l3,l4,l5 ;
    JButton b1,b2;
    welcome() throws IOException{
   
    ImageIcon img = new ImageIcon("carpark1.jpg");
    JLabel bkg = new JLabel("",img,JLabel.CENTER);
    f1.add(bkg); 
        
        
        
     //this.p = new JPanel();
     l1=new JLabel("Vehicle Parking Management System");  
     l1.setBounds(50,20, 2000,100);
     l1.setFont(new Font("Lucida Sans", Font.PLAIN, 70));
     l1.setForeground(new Color(255,240,245));
     bkg.add(l1);
    
     l3=new JLabel("Welcome to Vehicle Parking System");  
     l3.setBounds(50,250, 1000,60);
     l3.setFont(new Font("Lucida Sans", Font.PLAIN, 45));
     l3.setForeground(new Color(255,240,245));
     bkg.add(l3);
     
     String text ="Advanced Vehicle Parking System is a project developed to provide an easy way in finding the parking space\n" +
"  for vechiles.";
    l2  = new JLabel(text);
    l2.setBounds(50,320, 10000,30);
    l2.setFont(new Font("Lucida Sans", Font.PLAIN, 25));
    l2.setForeground(new Color(176,196,222));
     bkg.add(l2);
     
     String text1 ="This project helps user by ananlyzing the areas where parking is available and details about how \n" +
"many vechiles are parked in that area.";
    l5 = new JLabel(text1);
    l5.setBounds(50,360, 10000,30);
    l5.setFont(new Font("Lucida Sans", Font.PLAIN, 25));
    l5.setForeground(new Color(176,196,222));
     bkg.add(l5);
     
     String text2 ="Advanced Vehicle Parking System helps in reducing load of the administrator \n" +
"as his reduces drastically.";
    l4 = new JLabel(text2);
    l4.setBounds(50,400, 10000,30);
    l4.setFont(new Font("Lucida Sans", Font.PLAIN, 25));
    l4.setForeground(new Color(176,196,222));
     bkg.add(l4);
     
     
    b1=new JButton("HOME");
    b1.setBounds(100, 150, 300, 45);
    b1.setFont(new Font("Lucida Sans", Font.PLAIN, 20));
    b1.setBackground(new Color(255,255,255));
    b1.addActionListener(new ActionListener(){  
@Override
public void actionPerformed(ActionEvent e){  
    
    try {
        welcome w = new welcome();
    } catch (IOException ex) {
        Logger.getLogger(welcome.class.getName()).log(Level.SEVERE, null, ex);
    }
    
        }  
    });  
    bkg.add(b1);
      
    b2=new JButton("ADMIN PORTAL"); 
    b2.setBounds(400,150,300,45); 
    b2.setFont(new Font("Lucida Sans", Font.PLAIN, 20));
   b2.setBackground(new Color(255,255,255));
    b2.addActionListener(new ActionListener(){  
@Override
public void actionPerformed(ActionEvent e){  
           
           login f = new login();  
        }  
    });  
     bkg.add(b2); 
     bkg.setLayout(null);
     f1.setSize(1000,500);
    //f1.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("C:\\Users\\Admin\\OneDrive\\Desktop\\carpark3.jpg")))));
   // f1.add(p); 
    f1.setVisible(true);
    f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    
    
    
    
    
    
    }
public static void main(String args[]) throws IOException  
{  
        welcome f = new welcome();
          
}
@Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
   
    

}
    

