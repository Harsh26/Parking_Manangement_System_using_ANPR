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
import java.io.IOException;

class ImageProcessing extends JFrame implements ActionListener 
{ 
    // frame 
     final JFrame f = new JFrame("Admin Portal");
     JPanel panel = new JPanel();
     JLabel label,label2,label3,label4,label5;
     JButton b1,b,b2,b3,b4,b5,b6,b7,btest; 
     JMenuBar mb;    
     JMenu file,edit,format,view,help;    
     JMenuItem cut,copy,paste,selectAll; 
     JTextField t,t1,t2,t3;  
     
    // default constructor 
    ImageProcessing() 
    {
    ImageIcon img = new ImageIcon("carpark3.png");
    JLabel bkg = new JLabel("",img,JLabel.CENTER);
    f.add(bkg); 
       cut=new JMenuItem("cut");    
       copy=new JMenuItem("copy");    
       paste=new JMenuItem("paste");
       t=new JTextField(); 
       t.setBounds(500,50,600,35);
       bkg.add(t);
       
       t1=new JTextField("17 x 5"); 
       t1.setBounds(500,100,600,35);
       bkg.add(t1);
       
       t2=new JTextField();
       t2.setBounds(400,100,600,35);
       
       t3=new JTextField();
       t3.setBounds(400,140, 600, 35);
       
       // f.add(t2);
       //f.add(t3);
       
       selectAll=new JMenuItem("selectAll");
       mb=new JMenuBar();    
       file=new JMenu("File");    
       edit=new JMenu("Edit");   
       format=new JMenu("Format");
       view=new JMenu("View");
       help=new JMenu("Help");     
       edit.add(cut);edit.add(copy);edit.add(paste);edit.add(selectAll);    
       mb.add(file);mb.add(edit); mb.add(format);mb.add(view); mb.add(help);     
        bkg.add(mb);
        f.setJMenuBar(mb);         
        // set the size of frame 
        f.setSize(1300,500);        
        f.show(); 
          bkg.setLayout(null);
          //f.getContentPane().setBackground(new java.awt.Color(255,255,204));
          bkg.add(panel);
          
          label = new JLabel("ENTER Directory LINK:");
          label.setBounds(250, 50, 300, 30);
          label.setFont(new Font("Verdana", Font.PLAIN, 18));
          bkg.add(label);
          
          label2 = new JLabel("ENTER Size:");
          label2.setBounds(250, 100, 300, 30);
          label2.setFont(new Font("Verdana", Font.PLAIN, 18));
          bkg.add(label2);
          
          /*label4 = new JLabel("ENTER Date:");
          label4.setBounds(150, 100, 300, 30);
          label4.setFont(new Font("Verdana", Font.PLAIN, 18));
          f.add(label4);
          
          label5 = new JLabel("ENTER Time:");
          label5.setBounds(150, 140, 300, 30);
          label5.setFont(new Font("Verdana", Font.PLAIN, 18));
          f.add(label5);
          */
          
          Image icon = Toolkit.getDefaultToolkit().getImage("images/icon.png");  
          f.setIconImage(icon);  
          
         
   /*      
        b=new JButton("Calender");  
        b.setBounds(650,200,200,30);  
        b.addActionListener(new ActionListener(){  
        @Override
        public void actionPerformed(ActionEvent e)
        {  
         
                 
        }  
    });  */
        
        btest=new JButton("Recognise Number Plate");  
        btest.setBounds(450,200,200,30);
        btest.addActionListener(new ActionListener(){  
        @Override
        public void actionPerformed(ActionEvent e)
        {  
         String input=t.getText();    
         JOptionPane.showMessageDialog(f.getComponent(0), "Success in Recognition!!");        
         Recognising r=new Recognising(input);        
       // Print random integers 
       //System.out.println("Random Integers: "+rand_int1); 
       //System.out.println("Random Integers: "+rand_int2); 
        }  
    });  
        bkg.add(btest);
        
        b1=new JButton("Add Vehicle");  
        b1.setBounds(5,150,180,30);  
        b1.addActionListener(new ActionListener(){  
        @Override
        public void actionPerformed(ActionEvent e)
        {  
            insert i=new insert();       
        }  
    });  
        bkg.add(b1);
        
        b2=new JButton("Show");  
        b2.setBounds(5,210,180,30);  
        b2.addActionListener(new ActionListener(){  
        @Override
        public void actionPerformed(ActionEvent e)
        {  
         //Show s=new Show();
        }  
    });  
        bkg.add(b2);
        
        b3=new JButton("Delete");  
        b3.setBounds(5,270,180,30);  
        b3.addActionListener(new ActionListener(){  
        @Override
        public void actionPerformed(ActionEvent e)
        {  
           delete d=new delete();  
        }  
    });  
        bkg.add(b3);
        
        b4=new JButton("History");  
        b4.setBounds(5,330,180,30);  
        b4.addActionListener(new ActionListener(){  
        @Override
        public void actionPerformed(ActionEvent e)
        {  
           history h=new history();  
        }  
    });  
        bkg.add(b4);
        
        b5=new JButton("Search");  
        b5.setBounds(5,390,180,30);  
        b5.addActionListener(new ActionListener(){  
        @Override
        public void actionPerformed(ActionEvent e)
        {  
          search s=new search();          
        }  
    });  
        bkg.add(b5);
        
        b6=new JButton("Statistics");  
        b6.setBounds(5,450,180,30);  
        b6.addActionListener(new ActionListener(){  
        @Override
        public void actionPerformed(ActionEvent e)
        {  
         Report r=new Report();
        }  
    });  
        bkg.add(b6);
        
        
         b7=new JButton("View Calender");  
        b7.setBounds(700,200,200,30);  
        b7.addActionListener(new ActionListener(){  
        @Override
        public void actionPerformed(ActionEvent e)
        {  
         Cal c=new Cal();
        }  
    });  
        bkg.add(b7);
        
        //not used in this project
        /*b1=new JButton("Download");
        b1.setBounds(10,250,95,30);  
        b1.addActionListener(new ActionListener(){  
        @Override
        public void actionPerformed(ActionEvent e)
        {  
         JOptionPane.showMessageDialog(f.getComponent(0), "Success in download, Check your Directory!!");
         DownUp m=new DownUp();
         try
         {
         m.mymethod();
         }
         catch( IOException ioe)
         {
           System.out.println(ioe);
         }  catch (Exception ex) {             
                Logger.getLogger(test.class.getName()).log(Level.SEVERE, null, ex);
            }             
                 
        }  
    });  
    
        b2=new JButton("GrayScale");  
        b2.setBounds(10,300,95,30);  
        b2.addActionListener(new ActionListener(){  
        @Override
        public void actionPerformed(ActionEvent e)
        {  
         JOptionPane.showMessageDialog(f.getComponent(0), "Success in GrayScl, Check your Directory!!");
         
         GrayScl g=new GrayScl();
                 
        }  
    });  
        
        b3=new JButton("Mirror");  
        b3.setBounds(10,350,95,30);
        b3.addActionListener(new ActionListener(){  
        @Override
        public void actionPerformed(ActionEvent e)
        {  
         JOptionPane.showMessageDialog(f.getComponent(0), "Success in Mirroring, Check your Directory!!");
         
         Mirror mi=new Mirror();
                 
        }  
    });  
        f.add(b3);
        
        b4=new JButton("WaterMark");  
        b4.setBounds(10,400,95,30);
        b4.addActionListener(new ActionListener(){  
        @Override
        public void actionPerformed(ActionEvent e)
        {  
         JOptionPane.showMessageDialog(f.getComponent(0), "Success in WaterMarking, Check your Directory!!");
         
         WaterMark w=new WaterMark();
                 
        }  
    });  
        f.add(b4);
        
        b5=new JButton("Bright");  
        b5.setBounds(10,450,95,30); 
        b5.addActionListener(new ActionListener(){  
        @Override
        public void actionPerformed(ActionEvent e)
        {  
          Bright b=new Bright();  
         JOptionPane.showMessageDialog(f.getComponent(0), " Brightning Complete check your directory!!");
                   
        }  
    });  
        f.add(b5);
        
        b6=new JButton("Contrast");  
        b6.setBounds(10,500,95,30);
        b6.addActionListener(new ActionListener(){  
        @Override
        public void actionPerformed(ActionEvent e)
        {  
            JOptionPane.showMessageDialog(f.getComponent(0), "Success in Contrasting, Check your Directory!!");
            try {
                    
                Contrast c=new Contrast();
            } catch (Exception ex) {
                Logger.getLogger(test.class.getName()).log(Level.SEVERE, null, ex);
            }
                 
        }  
    });  
        f.add(b6);
        
        b7=new JButton("Sharp");  
        b7.setBounds(130,200,95,30); 
        b7.addActionListener(new ActionListener(){  
        @Override
        public void actionPerformed(ActionEvent e)
        {  
          Sharpness s=new Sharpness();  
         JOptionPane.showMessageDialog(f.getComponent(0), " Sharpening Complete check your directory!!");
                   
        }  
    });  
        f.add(b);
        f.add(b1);
        f.add(b2);
        f.add(b7);*/
        
        // create a panel 
         JPanel p = new JPanel(); 
        // add label to panel 
        //p.add(l); 
        //add(label2,BorderLayout.CENTER);
        // add panel to frame 
        bkg.add(p); 
        //f.add(b);
    }

    private ImageIcon createImageIcon(String imagesmiddlegif) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   
}

