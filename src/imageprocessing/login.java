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
import javax.swing.JPanel;

public final class login extends JFrame implements ActionListener{
     JLabel l1;
    JLabel userLabel = new JLabel("USERNAME:");
    JLabel passwordLabel = new JLabel("PASSWORD:");
    JTextField userTextField = new JTextField();
    JPasswordField passwordField = new JPasswordField();
    JButton loginButton = new JButton("LOGIN");
    JButton resetButton = new JButton("RESET");
    JCheckBox showPassword = new JCheckBox("Show Password");
    
    public login() {
        JFrame f1 = new JFrame();
        f1.setTitle("Login Form");
        f1.setVisible(true);
        f1.setBounds(100, 100, 1700, 1000);
        f1.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
        ImageIcon img = new ImageIcon("carpark2.png");
        JLabel bkg = new JLabel("",img,JLabel.CENTER);
        f1.add(bkg); 
        bkg.setLayout(null);  
        
       /* l1=new JLabel("Vehicle Parking Management System");  
        l1.setBounds(200,70, 2000,100);
        l1.setFont(new Font("Verdana", Font.PLAIN, 50));
        l1.setForeground(new Color(0,255,51));
        bkg.add(l1);*/
        
        
        
        userLabel.setBounds(410, 280, 200, 40);
        userLabel.setFont(new Font("Lucida Sans", Font.PLAIN, 22));
        userLabel.setForeground(new Color(0,0,0));
        //userLabel.setOpaque(true);
       // userLabel.setForeground(Color.black);  //HERE
       // userLabel.setBackground(Color.lightGray);  //HERE

        bkg.add(userLabel);
        
        passwordLabel.setBounds(410, 350, 200, 40);
        passwordLabel.setFont(new Font("Lucida Sans", Font.PLAIN, 22));
        passwordLabel.setForeground(new Color(0,0,0));
       // passwordLabel.setOpaque(true);
       // passwordLabel.setForeground(Color.black);  //HERE
       // passwordLabel.setBackground(Color.lightGray);  //HERE

        bkg.add(passwordLabel);
        
        userTextField.setBounds(550, 290, 300, 30);
        userTextField.setFont(new Font("Lucida Sans", Font.PLAIN, 25));
        userTextField.setBackground(new Color(255,255,255));
        bkg.add(userTextField);
        
        passwordField.setBounds(550, 360, 300, 30);
        passwordField.setFont(new Font("Lucida Sans", Font.PLAIN, 25));
        passwordField.setBackground(new Color(255,255,255));
        bkg.add(passwordField);
        
        showPassword.setBounds(650, 400, 120, 30);
        showPassword.setBackground(new Color(255,255,255));
        bkg.add(showPassword);
        showPassword.addActionListener(new ActionListener(){  
        @Override
        public void actionPerformed(ActionEvent e){  
        if (e.getSource() == showPassword) {
            if (showPassword.isSelected()) {
                passwordField.setEchoChar((char) 0);
            } else {
                passwordField.setEchoChar('*');
            }
          }  
    }});  
        
        
        
        loginButton.setBounds(440, 520, 150, 40);
        loginButton.setFont(new Font("Lucida Sans", Font.PLAIN, 20));
        loginButton.setBackground(new Color(255,255,255));
        bkg.add(loginButton);
        loginButton.addActionListener(new ActionListener(){  
          @Override
          public void actionPerformed(ActionEvent e){  
          if (e.getSource() == loginButton) {
            String userText;
            String pwdText;
            userText = userTextField.getText();
            pwdText = passwordField.getText();
            if (userText.equalsIgnoreCase("admin") && pwdText.equalsIgnoreCase("12345")) {
                JOptionPane.showMessageDialog( f1,"Login Successful");
                ImageProcessing obj=new ImageProcessing();
            } else {
                JOptionPane.showMessageDialog(f1, "Invalid Username or Password");
            }  
           
        }  
    }});  
     
        resetButton.setBounds(670, 520, 150, 40);
        resetButton.setFont(new Font("Lucida Sans", Font.PLAIN, 20));
        resetButton.setBackground(new Color(255,255,255));
        bkg.add(resetButton);
        resetButton.addActionListener(new ActionListener(){  
        @Override
        public void actionPerformed(ActionEvent e){  
         if (e.getSource() == resetButton) {
            userTextField.setText("");
            passwordField.setText("");  
           
        }  
    }}); 
        
        
    }  
     @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}    
    























/*

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

 public final class login extends JFrame implements ActionListener{

    Container container = getContentPane();
    JLabel userLabel = new JLabel("USERNAME");
    JLabel passwordLabel = new JLabel("PASSWORD");
    JTextField userTextField = new JTextField();
    JPasswordField passwordField = new JPasswordField();
    JButton loginButton = new JButton("LOGIN");
    JButton resetButton = new JButton("RESET");
    JCheckBox showPassword = new JCheckBox("Show Password");

     public login() {
        setLayoutManager();
        setLocationAndSize();
        addComponentsToContainer();
        addActionEvent();
        JFrame frame = new JFrame();
        frame.setTitle("Admin Portal");
        frame.setVisible(true);
        frame.setBounds(100, 100, 1700, 1000);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(container);
       }

    public void setLayoutManager() {
        container.setLayout(null);
        setVisible(true);
    }

    public void setLocationAndSize() {
        userLabel.setBounds(680, 150, 100, 30);
        passwordLabel.setBounds(680, 220, 200, 30);
        userTextField.setBounds(900, 150, 150, 30);
        passwordField.setBounds(900, 220, 150, 30);
        showPassword.setBounds(900, 250, 150, 30);
        loginButton.setBounds(800, 300, 100, 30);
        resetButton.setBounds(1000, 300, 100, 30);
        userLabel.setFont(new Font("Verdana", Font.PLAIN, 18));
        passwordLabel.setFont(new Font("Verdana", Font.PLAIN, 18));
        setVisible(true);
    }

    public void addComponentsToContainer() {
        container.add(userLabel);
        container.add(passwordLabel);
        container.add(userTextField);
        container.add(passwordField);
        container.add(showPassword);
        container.add(loginButton);
        container.add(resetButton);
        setVisible(true);
    }

    public void addActionEvent() {
        loginButton.addActionListener(this);
        resetButton.addActionListener(this);
        showPassword.addActionListener(this);
        setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == loginButton) {
            String userText;
            String pwdText;
            userText = userTextField.getText();
            pwdText = passwordField.getText();
            if (userText.equalsIgnoreCase("admin") && pwdText.equalsIgnoreCase("12345")) {
                JOptionPane.showMessageDialog(this, "Login Successful");
                ImageProcessing obj=new ImageProcessing();
            } else {
                JOptionPane.showMessageDialog(this, "Invalid Username or Password");
            }

        }
        if (e.getSource() == resetButton) {
            userTextField.setText("");
            passwordField.setText("");
        }
        if (e.getSource() == showPassword) {
            if (showPassword.isSelected()) {
                passwordField.setEchoChar((char) 0);
            } else {
                passwordField.setEchoChar('*');
            }


        }
    }

}
*/

