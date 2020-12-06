/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AtmSimulator;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;


/**
 *
 * @author Naman
 */
public class Login extends JFrame implements ActionListener{
    JLabel l1,l2,l3;
    JTextField tf1;
    JPasswordField pf2;
    JButton b1,b2,b3;
  
    Login(){
         
        
        //Move the text to the center
        
        setFont(new Font("System", Font.BOLD, 22));
        setTitle("                                                         AUTOMATED TELLER MACHINE");
        
       
       
        
        
        
        l1 = new JLabel("WELCOME TO ATM");
        l1.setFont(new Font("Dialog", Font.BOLD, 38));
        
        
        l2 = new JLabel("ATM ID:");
        l2.setFont(new Font("Dialog", Font.BOLD, 28));
        l2.setForeground(Color.DARK_GRAY);
        
        l3 = new JLabel("PIN:");
        l3.setFont(new Font("Dialog", Font.BOLD, 28));
        l3.setForeground(Color.DARK_GRAY);
        tf1 = new JTextField(15);
        pf2 = new JPasswordField(15);
        
        b1 = new JButton("SIGN IN");
        b1.setBackground(Color.DARK_GRAY);
        b1.setForeground(Color.WHITE);
        
        b2 = new JButton("CLEAR");
        b2.setBackground(Color.DARK_GRAY);
        b2.setForeground(Color.WHITE);
        
        b3 = new JButton("SIGN UP");
        b3.setBackground(Color.DARK_GRAY);
        b3.setForeground(Color.WHITE);
        
        setLayout(null);
        
        l1.setBounds(175,50,450,200);
        add(l1);
        
        l2.setBounds(125,150,375,200);
        add(l2);
        
        tf1.setBounds(300,235,230,30);
        add(tf1);
        
        l3.setBounds(125,225,375,200);
        add(l3);
        
        tf1.setFont(new Font("Arial", Font.BOLD, 14));
       
        
        pf2.setFont(new Font("Arial", Font.BOLD, 14));
        pf2.setBounds(300,310,230,30);
        add(pf2);
        
        b1.setFont(new Font("Arial", Font.BOLD, 14));
        b1.setBounds(300,400,100,30);
        add(b1);
        
        b2.setFont(new Font("Arial", Font.BOLD, 14));
        b2.setBounds(430,400,100,30);
        add(b2);
        
        b3.setFont(new Font("Arial", Font.BOLD, 14));
        b3.setBounds(300,450,230,30);
        add(b3);
        
        
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        
        getContentPane().setBackground(Color.LIGHT_GRAY);
        
        setSize(750,750);
        setLocation(500,200);
        setVisible(true);
        

        
    }
    public void actionPerformed(ActionEvent ae){
       
        try{        
            conn c1 = new conn();
            String l_atmid  = tf1.getText();
            String l_pin  = pf2.getText();
            String q  = "select * from credentials where atmid = '"+l_atmid+"' and pin = '"+l_pin+"'";
            
            ResultSet rs = c1.s.executeQuery(q);
            
            if(ae.getSource()==b1){
                if(rs.next()){
                    String h="insert into atm(pin) values('"+l_pin+"')";
                    c1.s.executeUpdate(h);
                    new Transactions().setVisible(true);
                    setVisible(false);
                
                }else{
                    JOptionPane.showMessageDialog(null, "Incorrect ATM ID or Password");
                    
                }
            }else if(ae.getSource()==b2){
                tf1.setText("");
                pf2.setText("");
            }else if(ae.getSource()==b3){
                new Register().setVisible(true);
                setVisible(false);
            }
        }catch(Exception e){
                    e.printStackTrace();
                    System.out.println("error: "+e);
        }
            
    }
    
    
    public static void main(String[] args){
        new Login().setVisible(true);
    }

    
}