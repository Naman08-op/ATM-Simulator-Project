/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AtmSimulator;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
/**
 *
 * @author Naman
 */
public class MiniStatement extends JFrame implements ActionListener{
    
    JTable t1;
    JButton b1;
    String x[] = {"Date & Time","Deposit","Withdraw","Balance"};
    String y[][] = new String[35][4];
    int i=0, j=0;
    
    MiniStatement(){
        super("Mini Statement");
        setSize(1200,650);
        setLocation(200,200);
     		 //String pinn = JOptionPane.showInputDialog("Enter PIN");

        
        try{
            conn c1  = new conn();
             String q7=("SELECT * FROM hold ORDER BY Id DESC LIMIT 1;");
                    ResultSet rs1= c1.s.executeQuery(q7);
                    
                    
                    if(rs1.next()){
                        String pin = rs1.getString("pin");
            ResultSet rs;
                rs = c1.s.executeQuery("SELECT time,deposit,withdraw,balance FROM bank where pin = '" + pin + "'ORDER BY Id DESC LIMIT 33");
          
            while(rs.next()){
                //y[i][j++]=rs.getString("customer_name");
                y[i][j++]=rs.getString("time");
                y[i][j++]=rs.getString("deposit");
                y[i][j++]=rs.getString("withdraw");
                y[i][j++]=rs.getString("balance");
                i++;
                j=0;
            }
            t1 = new JTable(y,x);
        } 
        }catch(Exception e){
            e.printStackTrace();
        }
        
        
        b1 = new JButton("Print");
        add(b1,"South");
        JScrollPane sp = new JScrollPane(t1);
        add(sp);
        b1.addActionListener(this);
    }
    public void actionPerformed(ActionEvent ae){
        try{
            t1.print();
        }catch(Exception e){}
    }
    
    public static void main(String[] args){
        new MiniStatement().setVisible(true);
    }
    
}
    
    

