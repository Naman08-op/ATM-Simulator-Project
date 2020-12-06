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
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Naman
 */
public class Register2 extends JFrame implements ActionListener {
    
    JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12,l13,l14,l15,l16,l17,l18,l19,l20,l21,l22;
    JTextField t1,t2,t3,t4,t5;
    JRadioButton r1,r2,r3,r4,r5,r6;
    JComboBox c1;
    JButton b1,b2;
    JCheckBox cb1;
    String q7;
    ResultSet rs=null;
    String form,name,name1,final_name;
    
//    Register get=new Register();
//    long form=get.first;
//   
//    String nameid=get.name;
//    String nameid1 = nameid.replaceAll("\\s","");
//    String final_nameid=nameid1.toLowerCase();

    Register2() throws SQLException{
        
        try{
                conn c2=new conn();
                q7=("SELECT * FROM customer ORDER BY Id DESC LIMIT 1;");
              rs= c2.s.executeQuery(q7);
              if(rs.next()){
                  form =rs.getString("form_no");
                  name=rs.getString("name");
                  name1=name.replaceAll("\\s","");
                  final_name=name1.toLowerCase();
              }
              
        }catch (Exception e) {
         e.printStackTrace();
      }    
        
        setFont(new Font("System", Font.BOLD,24));
        setTitle("                                                                            REGISTRATION FORM");
        
        l1=new JLabel("Page 2: Account Details");
        l1.setFont(new Font("Dialog",Font.BOLD,24));
        
        
        //l2=new JLabel("Form no. "+ form);
        l2=new JLabel("Form no. "+form);

        l2.setFont(new Font("Dialog",Font.BOLD,20));
        
        l3=new JLabel("Address");
        l3.setFont(new Font("Dialog",Font.BOLD,20));
        
        l4=new JLabel("City");
        l4.setFont(new Font("Dialog",Font.BOLD,20));
        
        l5=new JLabel("Pin Code");
        l5.setFont(new Font("Dialog",Font.BOLD,20));
        
        l6=new JLabel("State");
        l6.setFont(new Font("Dialog",Font.BOLD,20));
        
        l7=new JLabel("Pan Card No.");
        l7.setFont(new Font("Dialog",Font.BOLD,20));
        
        l8=new JLabel("Aadhar Card No.");
        l8.setFont(new Font("Dialog",Font.BOLD,20));
        
        l9=new JLabel("Senior Citizen?");
        l9.setFont(new Font("Dialog",Font.BOLD,20));
        
        l10=new JLabel("Existing Account?");
        l10.setFont(new Font("Dialog",Font.BOLD,20));
        
        l11=new JLabel("Account Type");
        l11.setFont(new Font("Dialog",Font.BOLD,20));
        
        l12=new JLabel("Card Number");
        l12.setFont(new Font("Dialog",Font.BOLD,20));
        
        l13=new JLabel("XXXX-XXXX-XXXX-");
        l13.setFont(new Font("Dialog",Font.BOLD,20));
        
        l14=new JLabel("(Your 16-digit Card number)");
        l14.setFont(new Font("Dialog",Font.BOLD,12));
        
        l15=new JLabel("It would appear on ATM Card/Cheque Book and Statements");
        l15.setFont(new Font("Dialog",Font.BOLD,12));
        
        
        l16=new JLabel("ATM ID");
        l16.setFont(new Font("Dialog",Font.BOLD,20));
        
        l17=new JLabel("@smartbank.dy.in");
        //l17=new JLabel(final_nameid+form+"@smartbank.rbi.dy.in");
        l17.setFont(new Font("Dialog",Font.BOLD,20));
        
        l18=new JLabel("(Your ATM ID )");
        l18.setFont(new Font("Dialog",Font.BOLD,12));
        
        l19=new JLabel("It will be used for Transaction at Smart ATMs if you don't have your card");
        l19.setFont(new Font("Dialog",Font.BOLD,12));
        
        l20=new JLabel("PIN");
        l20.setFont(new Font("Dialog",Font.BOLD,20));
        
        l21=new JLabel("XXXX");
        l21.setFont(new Font("Dialog",Font.BOLD,20));
        
        l22=new JLabel("(4-digit password)");
        l22.setFont(new Font("Dialog",Font.BOLD,12));
        
        b1=new JButton("Submit");
        b1.setFont(new Font("Dialog",Font.BOLD,15));
        b1.setBackground(Color.BLACK);
        b1.setBackground(Color.WHITE);
        
        b2=new JButton("Cancel");
        b2.setFont(new Font("Dialog",Font.BOLD,15));
        b2.setBackground(Color.BLACK);
        b2.setBackground(Color.WHITE);
        
        cb1=new JCheckBox("I agree to the Terms and Conditions provided by the Bank, and declare all the information I provided is correct.");
        cb1.setFont(new Font("Dialog",Font.BOLD,12));
        
        r1=new JRadioButton("Yes");
        r1.setFont(new Font("Dialog",Font.BOLD,15));
        
        r2=new JRadioButton("No");
        r2.setFont(new Font("Dialog",Font.BOLD,15));
        
        r3=new JRadioButton("Yes");
        r3.setFont(new Font("Dialog",Font.BOLD,15));
        
        r4=new JRadioButton("No");
        r4.setFont(new Font("Dialog",Font.BOLD,15));
        
        r5=new JRadioButton("Savings Account");
        r5.setFont(new Font("Dialog",Font.BOLD,15));
        
        r6=new JRadioButton("Current Account");
        r6.setFont(new Font("Dialog",Font.BOLD,15));
        
        String states[]={"Andaman and Nicobar Islands","Andhra Pradesh","Arunachal Pradesh","Assam","Bihar","Chandigarh","Chhattisgarh","Daman&Diu","Delhi","Goa","Gujarat","Haryana","Himachal Pradesh","Jammu and Kashmir","Jharkhand","Karnataka","Kerala","Ladakh","Lakshadweep","Madhya Pradesh","Maharashtra","Manipur","Meghalaya","Mizoram","Nagaland","Odisha","Punjab","Rajasthan","Sikkim","Tamil Nadu","Telangana","Tripura","Uttar Pradesh","Uttarakhand","West Bengal"};
        c1=new JComboBox(states);
        c1.setBackground(Color.WHITE);
        c1.setFont(new Font("Dialog", Font.BOLD, 14));
        
        t1 = new JTextField();
        t1.setFont(new Font("Dialog", Font.BOLD, 14));
        
        t2 = new JTextField();
        t2.setFont(new Font("Dialog", Font.BOLD, 14));
        
        t3 = new JTextField();
        t3.setFont(new Font("Dialog", Font.BOLD, 14));
        
        t4 = new JTextField();
        t4.setFont(new Font("Dialog", Font.BOLD, 14));
        
        t5 = new JTextField();
        t5.setFont(new Font("Dialog", Font.BOLD, 14));
        
        setLayout(null);
        
        l2.setBounds(580,40,200,30);
        add(l2);
        
        l1.setBounds(290,20,600,30);
        add(l1);
        
        l3.setBounds(100,100,200,30); 
        add(l3);
        
        t1.setBounds(300,100,400,30);
        add(t1);
        
        l4.setBounds(100,150,200,30);
        add(l4);
        
        t2.setBounds(300,150,400,30);
        add(t2);
        
        l5.setBounds(100,200,200,30);
        add(l5);
        
        t3.setBounds(300,200,400,30);
        add(t3);
        
        l6.setBounds(100,250,200,30);
        add(l6);
        
        c1.setBounds(300,250,400,30);
        add(c1);
        
        l7.setBounds(100,300,200,30);
        add(l7);
        
        t4.setBounds(300,300,400,30);
        add(t4);
        
        l8.setBounds(100,350,200,30);
        add(l8);
        
        t5.setBounds(300,350,400,30);
        add(t5);
        
        l9.setBounds(100,400,200,30);
        add(l9);
        
        r1.setBounds(300,400,60,30);
        add(r1);
        
        r2.setBounds(450,400,90,30);
        add(r2);
        
        l10.setBounds(100,450,200,30);
        add(l10);
        
        r3.setBounds(300,450,60,30);
        add(r3);
        
        r4.setBounds(450,450,90,30);
        add(r4);
        
        l11.setBounds(100,500,200,30);
        add(l11);
        
        r5.setBounds(300,500,150,30);
        add(r5);
        
        r6.setBounds(450,500,150,30);
        add(r6);
        
        l12.setBounds(100,550,200,30);
        add(l12);
        
        l13.setBounds(330,550,250,30);
        add(l13);
        
        l14.setBounds(100,573,200,20);
        add(l14);
        
        l15.setBounds(310,573,500,20);
        add(l15);
        
        l16.setBounds(100,610,200,30);
        add(l16);
        
        l17.setBounds(330,610,400,30);
        add(l17);
        
        l18.setBounds(100,635,200,20);
        add(l18);
        
        l19.setBounds(330,635,500,30);
        add(l19);
        
        l20.setBounds(100,670,200,30);
        add(l20);
        
        l21.setBounds(330,675,200,20);
        add(l21);
        
        l22.setBounds(100,700,200,20);
        add(l22);
        
        cb1.setBounds(100,750,600,20);
        add(cb1);
        
        b1.setBounds(300,790,100,30);
        add(b1);
        
        b2.setBounds(420,790,100,30);
        add(b2);
        
        setSize(850,920);
        setLocation(500,90);
        setVisible(true);
        
        b1.addActionListener(this);
        b2.addActionListener(this);
    
    }
    
    public void actionPerformed(ActionEvent ae){
        
        String a=(String)t1.getText();
        String b=(String)t2.getText();
        String c=(String)t3.getText();
        String d=(String)c1.getSelectedItem();
        String e=(String)t4.getText();
        String f=(String)t5.getText();
        
        String g=null;
        if(r1.isSelected()){
            g="Yes";
        }
        else if(r2.isSelected()){
            g="No";
        }
        
        String h=null;
        if(r3.isSelected()){
            h="Yes";
        }
        else if(r4.isSelected()){
            h="No";
        }
        
        String i=null;
        if(r5.isSelected()){
            i="Savings Account";
        }
        else if(r6.isSelected()){
            i="Current Account";
        }
        
        //to generate random card number
        Random ran=new Random();
        long first7=(ran.nextLong()%90000000L)+ 5830178000000000L;
        long card_no=Math.abs(first7);
        
        //to generate random pin
        long first3=(ran.nextLong()%9000L)+1000L;
        long pin=Math.abs(first3);
        
        //to generate an atm id for eg if name=namanchhajed and
        //form number generated in Register.java class is 7979
        //so the ATMid should be namanchhajed7979@smartbank.rbi.dy.in
        
        //String first5=final_nameid+form+"@smartbank.dy.in";
        
        String atmid=final_name+form+"@smartbank.dy.in";
        
        
        //end of atm id func
        
        try{
            if(ae.getSource()==b1){
                if(a.equals("")){
                    JOptionPane.showMessageDialog(null, "Fill all the required fields.");
                    
                }
                else if(b.equals("")){
                    JOptionPane.showMessageDialog(null, "Fill all the required fields.");
                    
                }
                else if(c.equals("")){
                    JOptionPane.showMessageDialog(null, "Fill all the required fields.");
                    
                }
                else if(d.equals("")){
                    JOptionPane.showMessageDialog(null, "Fill all the required fields.");
                    
                }
                else if(e.equals("")){
                    JOptionPane.showMessageDialog(null, "Fill all the required fields.");
                    
                }
                else if(f.equals("")){
                    JOptionPane.showMessageDialog(null, "Fill all the required fields.");
                    
                }
                else if(g.equals("")){
                    JOptionPane.showMessageDialog(null, "Fill all the required fields.");
                    
                    
                }
               
            else{
                conn c1=new conn();
                //String q1="insert into personal_info(address,city,pincode,state,pan_no,aadhar_no,senior_citizen,existing_acc) values('"+a+"','"+b+"','"+c+"','"+d+"','"+e+"','"+f+"','"+g+"','"+h+"')";
                String q1="UPDATE personal_info SET address='"+a+"',city='"+b+"',pincode='"+c+"',state='"+d+"',pan_no='"+e+"',aadhar_no='"+f+"',senior_citizen='"+g+"',existing_acc='"+h+"' ORDER BY id DESC LIMIT 1";
                String q2="UPDATE customer SET account_type ='"+i+"' ORDER BY id DESC LIMIT 1";
                String q3="insert into credentials(card_no,atmid,pin) values ('"+card_no+"','"+atmid+"','"+pin+"')";
                c1.s.executeUpdate(q1);
                c1.s.executeUpdate(q2);
                c1.s.executeUpdate(q3);
                
                JOptionPane.showMessageDialog(null, "Card Number: " + card_no + "\n ATM ID:"+atmid+ "\n Pin:"+ pin );
                
                new Deposit1().setVisible(true);
                setVisible(false);
                
            }
        }else if(ae.getSource()==b2){
            System.exit(0);
        }
        }       catch (SQLException ex) {
            Logger.getLogger(Register2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


public static void main(String[] args) throws SQLException{
    new Register2().setVisible(true);
}
}
      

