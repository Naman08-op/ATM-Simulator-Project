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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Naman
 */
public class Transactions extends JFrame implements ActionListener {
    
    JLabel l1;
    JButton b1,b2,b3,b4,b5,b6,b7;
    
    Transactions(){
        
    setFont(new Font("System", Font.BOLD, 22));
    setTitle("                                                                            TRANSACTION");
    
    l1=new JLabel("Please Select Your Transaction");
    l1.setFont(new Font("Dialog",Font.BOLD,34));
    
    b1=new JButton("Deposit");
    b1.setFont(new Font("Dialog",Font.BOLD,25));
    
    b2=new JButton("Change Pin");
    b2.setFont(new Font("Dialog",Font.BOLD,25));
    
    b3=new JButton("Balance Enquiry");
    b3.setFont(new Font("Dialog",Font.BOLD,25));
    
    b4=new JButton("Cash Withdrawal");
    b4.setFont(new Font("Dialog",Font.BOLD,25));
    
    b5=new JButton("Fast Cash");
    b5.setFont(new Font("Dialog",Font.BOLD,25));
    
    b6=new JButton("Mini Statement");
    b6.setFont(new Font("Dialog",Font.BOLD,25));
    
    b7=new JButton("Exit");
    b7.setFont(new Font("Dialog",Font.BOLD,25));
    
    setLayout(null);
    
    l1.setBounds(100,100,700,40);
    add(l1);
    
    b1.setBounds(40,250,300,60);
    add(b1);
    
    b2.setBounds(40,360,300,60);
    add(b2);
    
    b3.setBounds(40,470,300,60);
    add(b3);
    
    b4.setBounds(440,250,300,60);
    add(b4);
    
    b5.setBounds(440,360,300,60);
    add(b5);
    
    b6.setBounds(440,470,300,60);
    add(b6);
    
    b7.setBounds(240,600,300,60);
    add(b7);
    
    b1.addActionListener(this);
    b2.addActionListener(this);
    b3.addActionListener(this);
    b4.addActionListener(this);
    b5.addActionListener(this);
    b6.addActionListener(this);
    b7.addActionListener(this);
    
    setSize(800,800);
    setLocation(500,90);
    setVisible(true);
    
    
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==b1){
            new Deposit().setVisible(true);
            setVisible(false);
        }
        else if(ae.getSource()==b2){
            new Pin().setVisible(true);
            setVisible(false);
        }
        else if(ae.getSource()==b6){
            new MiniStatement().setVisible(true);
            setVisible(false);
        }
        else if(ae.getSource()==b4){
            new Withdrawal().setVisible(true);
            setVisible(false);
        }
        else if(ae.getSource()==b5){
            new FastCash().setVisible(true);
            setVisible(false);
        }
        else if(ae.getSource()==b3){
           
            
            String pinn=JOptionPane.showInputDialog("Enter PIN");
            conn c1=new conn();
            
            try{
                
                ResultSet rs=c1.s.executeQuery("SELECT balance FROM bank ORDER BY pin ='"+pinn+"' DESC LIMIT 1");
                if(rs.next()){
                    String balance=rs.getString("balance");
                    JOptionPane.showMessageDialog(null, "Your Account Balance is "+balance);
                }
            } catch(Exception e){
                e.printStackTrace();
            }            
            
        }else if(ae.getSource()==b7){
            System.exit(0);
        }
    }
        public static void main(String[] args){
            new Transactions().setVisible(true);
        }
    
    
}
