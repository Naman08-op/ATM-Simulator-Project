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
/**
 *
 * @author Naman
 */
public class Withdrawal extends JFrame implements ActionListener {

    JTextField t1,t2;
    JButton b1,b2,b3;
    JLabel l1,l2,l3,l4;
    
    Withdrawal(){
        
        setFont(new Font("Dialog", Font.BOLD, 22));
        setTitle("                                                                            WITHDRAWAL");
        
        l1 = new JLabel("MAXIMUM DAILY WITHDRAWAL");
        l1.setFont(new Font("Dialog", Font.BOLD, 40));
        
        l2 = new JLabel("IS RS.10,000");
        l2.setFont(new Font("Dialog", Font.BOLD, 40));
        
        l3 = new JLabel("PLEASE ENTER YOUR AMOUNT");
        l3.setFont(new Font("Dialog", Font.BOLD, 35));
        
//        l4 = new JLabel("Enter Pin");
//        l4.setFont(new Font("Dialog", Font.BOLD, 14));
        
        t1 = new JTextField();
        t1.setFont(new Font("Dialog", Font.BOLD, 22));
        
//        t2 = new JTextField();
//        t2.setFont(new Font("Dialog", Font.BOLD, 14));
        
        b1 = new JButton("WITHDRAW");
        b1.setFont(new Font("Dialog", Font.BOLD, 18));
        
    
        b2 = new JButton("BACK");
        b2.setFont(new Font("Dialog", Font.BOLD, 18));
        
        
        b3 = new JButton("EXIT");
        b3.setFont(new Font("Dialog", Font.BOLD, 18));
        
        
        
        setLayout(null);
        
//        l4.setBounds(620,10,80,30);
//        add(l4);
        
//        t2.setBounds(700,10,40,30);
//        add(t2);
        
        l1.setBounds(90,100,800,60);
        add(l1);
        
        l2.setBounds(270,160,800,60);
        add(l2);
        
        l3.setBounds(120,260,800,60);
        add(l3);
        
        t1.setBounds(210,340,360,50);
        add(t1);
        
        b1.setBounds(220,400,160,50);
        add(b1);
        
        b2.setBounds(400,400,160,50);
        add(b2);
        
        b3.setBounds(300,550,200,50);
        add(b3);
        
        
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
          
        setSize(800,800);
        setLocation(500,90);
        setVisible(true);
            
    }
    
    public void actionPerformed(ActionEvent ae){
       
        try{        
           
            String a = t1.getText();
    //            String b = t2.getText();
            
            
            
            
            if(ae.getSource()==b1){
                if(t1.getText().equals("")){
                    
                    JOptionPane.showMessageDialog(null, "Please enter the Amount to you want to Withdraw");
                
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
                        
                        if(d>10000){
                        JOptionPane.showMessageDialog(null, "Daily withdrawal limit is 10,000.");
                        
                        }
                        else if(d>balance){
                        JOptionPane.showMessageDialog(null, "Not sufficient funds in your account.");
                        
                        }
                        else if(balance>=d ){
                            balance=balance-d;
                        String q1= "insert into transactions(pin,deposit,withdraw,balance) values('"+pin+"',null,'"+d+"','"+balance+"')";
                    
                        c1.s.executeUpdate(q1);
                        JOptionPane.showMessageDialog(null, "Rs. "+a+" Debited Successfully");
                    }
                        
                    }
                    
                    
                    
                    
                    new Transactions().setVisible(true);
                    setVisible(false);
                    }
                    
                    
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
        new Withdrawal().setVisible(true);
    }
    
}
