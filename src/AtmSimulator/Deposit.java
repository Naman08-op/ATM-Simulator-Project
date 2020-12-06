/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AtmSimulator;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.*;
/**
 *
 * @author Naman
 */
public class Deposit extends JFrame implements ActionListener {
    
    JTextField t1,t2;
    JButton b1,b2,b3;
    JLabel l1,l2,l3,l4;
    JPasswordField p1;
    
    Deposit(){
        
        setFont(new Font("System", Font.BOLD, 22));
        setTitle("                                                                            DEPOSIT");
        
        
        l1 = new JLabel("ENTER AMOUNT YOU WANT");
        l1.setFont(new Font("Dialog", Font.BOLD, 35));
        
        l2 = new JLabel("TO DEPOSIT");
        l2.setFont(new Font("Dialog", Font.BOLD, 35));
        
//        l3 = new JLabel("Enter Pin");
//        l3.setFont(new Font("Dialog", Font.BOLD, 23));
        
        l4 = new JLabel("Enter Amount");
        l4.setFont(new Font("Dialog", Font.BOLD, 23));
        
        t1 = new JTextField();
        t1.setFont(new Font("Dialog", Font.BOLD, 22));
        
//        p1 = new JPasswordField();
//        p1.setFont(new Font("Dialog", Font.BOLD, 22));
        
        b1 = new JButton("DEPOSIT");
        b1.setFont(new Font("Dialog", Font.BOLD, 18));
      
    
        b2 = new JButton("BACK");
        b2.setFont(new Font("Dialog", Font.BOLD, 18));
 
        
        b3 = new JButton("EXIT");
        b3.setFont(new Font("Dialog", Font.BOLD, 18));
   
        
        
        setLayout(null);
        
//        l3.setBounds(93,390,200,60);
//        add(l3);
        
        l4.setBounds(93,290,200,60);
        add(l4);
        
//        p1.setBounds(250,400,300,50);
//        add(p1);
        
        l1.setBounds(150,150,800,60);
        add(l1);
        
        l2.setBounds(290,210,800,60);
        add(l2);
        
        t1.setBounds(250,300,300,50);
        add(t1);
        
        b1.setBounds(260,480,125,50);
        add(b1);
        
        b2.setBounds(415,480,125,50);
        add(b2);
        
        b3.setBounds(300,550,200,50);
        add(b3);
        
        
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        
        
        setSize(770,770);
        setLocation(500,90);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
       
        try{        
           
            String a = t1.getText();
//            String b = p1.getText();
            
            
            
            
            if(ae.getSource()==b1){
                if(t1.getText().equals("")){
                    
                    JOptionPane.showMessageDialog(null, "Please enter the Amount to you want to Deposit");
                
                }else{
                    
                    conn c1 = new conn();
                    
                    
                    
                    
                    String q7=("SELECT * FROM atm ORDER BY Id DESC LIMIT 1;");
                    ResultSet rs1= c1.s.executeQuery(q7);
                    
                    if(rs1.next()){
                        String pin = rs1.getString("pin");
 			
                        ResultSet rs = c1.s.executeQuery(" select * from transactions where pin = '"+pin+"' ORDER BY Id DESC LIMIT 1");
                        if(rs.next()){
                        Double balance = rs.getDouble("balance");
                        
                        
                        double d = Double.parseDouble(a);
                        balance=balance+d;
                        String q1= "insert into transactions(pin,deposit,withdraw,balance) values('"+pin+"','"+d+"',null,'"+balance+"')";
                    
                        c1.s.executeUpdate(q1);
                    }
                    
                    }
                    
                    JOptionPane.showMessageDialog(null, "Rs. "+a+" Deposited Successfully");
                    
                    new Transactions().setVisible(true);
                    setVisible(false);
                    
                    
                    
                }
                
            }else if(ae.getSource()==b2){
                
                new Transactions().setVisible(true);
                setVisible(false);
                
            }else if(ae.getSource()==b3){
                
                System.exit(0);
                
            }
        }catch(Exception e){
                e.printStackTrace();
                System.out.println("error: "+e);
        }
            
    }
    
    public static void main(String[] args){
        new Deposit().setVisible(true);
    }

    
}