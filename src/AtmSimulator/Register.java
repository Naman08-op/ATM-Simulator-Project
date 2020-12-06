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
public class Register extends JFrame implements ActionListener {
    
    JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12,l13,l14,l15,l16;
    JTextField t1,t2,t3;
    JRadioButton r1,r2,r3,r4,r5;
    JButton b;
    JComboBox c1,c2,c3,c4,c5,c6,c7,c8;
    
    Random ran= new Random();
    long first4 = (ran.nextLong() % 9000L)+1000L;
    long first=Math.abs(first4);
    
    String name;
    
    //name without spacing for atm id that'll be used further
        //String name_before = t1.getText();
        //String name = name_before.replaceAll("\\s","");
    
    Register(){
        
        //For moving the text to the center
        setFont(new Font("System", Font.BOLD,24));
        setTitle("                                                                            REGISTRATION FORM");
        
        l1 = new JLabel ("APPLICATION FORM NO. "+first);
        l1.setFont(new Font("Dialog", Font.BOLD,37));
        
        l2 = new JLabel ("Page 1: Personal Information");
        l2.setFont(new Font("Dialog", Font.BOLD,24));
        
        l3 = new JLabel ("Name:");
        l3.setFont(new Font("Dialog", Font.BOLD,20));
        
        l4 = new JLabel ("Father's Name:");
        l4.setFont(new Font("Dialog", Font.BOLD,20));
        
        l5 = new JLabel ("Date of Birth:");
        l5.setFont(new Font("Dialog", Font.BOLD,20));
        
        l6 = new JLabel ("Gender:");
        l6.setFont(new Font("Dialog", Font.BOLD,20));
        
        l7 = new JLabel ("Email Address:");
        l7.setFont(new Font("Dialog", Font.BOLD,20));
        
        l8 = new JLabel ("Marital Status:");
        l8.setFont(new Font("Dialog", Font.BOLD,20));
        
        l9 = new JLabel ("Religion:");
        l9.setFont(new Font("Dialog", Font.BOLD,20));
        
        l10= new JLabel ("Caste:");
        l10.setFont(new Font("Dialog", Font.BOLD,20));
        
        l11= new JLabel ("Education:");
        l11.setFont(new Font("Dialog", Font.BOLD,20));
        
        l12= new JLabel ("Occupation:");
        l12.setFont(new Font("Dialog", Font.BOLD,20));
        
        l13= new JLabel ("Income:");
        l13.setFont(new Font("Dialog", Font.BOLD,20));
        
        l14= new JLabel ("Date:");
        l14.setFont(new Font("Dialog", Font.BOLD,15));
        
        l15= new JLabel ("Month:");
        l15.setFont(new Font("Dialog", Font.BOLD,15));
        
        l16= new JLabel ("Year:");
        l16.setFont(new Font("Dialog", Font.BOLD,15));
        
        t1 = new JTextField();
        t1.setFont(new Font("Dialog", Font.BOLD, 14));
        
        t2 = new JTextField();
        t2.setFont(new Font("Dialog", Font.BOLD, 14));
        
        t3 = new JTextField();
        t3.setFont(new Font("Dialog", Font.BOLD, 14));
        
        
        b= new JButton("Next");
        b.setFont(new Font("Dialog", Font.BOLD, 14));
        b.setBackground(Color.BLACK);
        b.setForeground(Color.WHITE);
        
        r1 = new JRadioButton("Male");
        r1.setFont(new Font("Dialog", Font.BOLD, 14));
        
        
        r2 = new JRadioButton("Female");
        r2.setFont(new Font("Dialog", Font.BOLD, 14));
        
        r3 = new JRadioButton("Married");
        r3.setFont(new Font("Dialog", Font.BOLD, 14));
        
        r4 = new JRadioButton("Unmarried");
        r4.setFont(new Font("Dialog", Font.BOLD, 14));
        
        r5 = new JRadioButton("Other");
        r5.setFont(new Font("Dialog", Font.BOLD, 14));
        
        
        String date[]={"1","2","3","4","5","6","7","8","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};        
        c1=new JComboBox(date);
        c1.setBackground(Color.WHITE);
        c1.setFont(new Font("Dialog", Font.BOLD, 14));
        
        String month[]={"January","February","March","April","May","June","July","August","September","October","November","December"};
        c2 = new JComboBox(month);
        c2.setBackground(Color.WHITE);
        c2.setFont(new Font("Dialog", Font.BOLD, 14));
        
        String year[] = {"1970","1971","1972","1973","1974","1975","1976","1977","1978","1979","1980","1981","1982","1983","1984","1985","1986","1987","1988","1989","1990","1991","1992","1993","1994","1995","1996","1997","1998","1999","2000","2001","2002"};
        c3 = new JComboBox(year);
        c3.setBackground(Color.WHITE);
        c3.setFont(new Font("Dialog", Font.BOLD, 14));
        
        String religion[]={"Hindu","Muslim","Sikh","Christian","Jain","Other"};
        c4= new JComboBox(religion);
        c4.setBackground(Color.WHITE);
        c4.setFont(new Font("Dialog", Font.BOLD, 14));
        
        String category[] = {"General","OBC","SC","ST","Other"};
        c5 = new JComboBox(category);
        c5.setBackground(Color.WHITE);
        c5.setFont(new Font("Dialog", Font.BOLD, 14));
        
        String education[] = {"Non-Graduate","Graduate","Post-Graduate","Doctrate","Others"};
        c6 = new JComboBox(education);
        c6.setBackground(Color.WHITE);
        c6.setFont(new Font("Dialog", Font.BOLD, 14));
        
        String occupation[] = {"Salaried","Self-Employmed","Business","Student","Retired","Others"};
        c7 = new JComboBox(occupation);
        c7.setBackground(Color.WHITE);
        c7.setFont(new Font("Dialog", Font.BOLD, 14));
        
        String income[] = {"Null","<1,50,000","<2,50,000","<5,00,000","Upto 10,00,000","Above 10,00,000"};
        c8 = new JComboBox(income);
        c8.setBackground(Color.WHITE);
        c8.setFont(new Font("Dialog", Font.BOLD, 14));
        
        
        
        
        setLayout(null);
        l1.setBounds(140, 20, 600, 40);
        add(l1);
        
        l2.setBounds(290,70,600,30);
        add(l2);
        
        l3.setBounds(100,140,100,30);
        add(l3);
        
        t1.setBounds(300,140,400,30);
        add(t1);
        
        l4.setBounds(100,190,200,30);
        add(l4);
        
        t2.setBounds(300,190,400,30);
        add(t2);
        
        l5.setBounds(100,240,200,30);
        add(l5);
        
        l14.setBounds(300,240,40,30);
        add(l14);
        
        c1.setBounds(340,240,60,30);
        add(c1);
        
        l15.setBounds(410,240,50,30);
        add(l15);
        
        c2.setBounds(460,240,100,30);
        add(c2);
        
        l16.setBounds(570,240,40,30);
        add(l16);
        
        c3.setBounds(610,240,90,30);
        add(c3);
        
        l6.setBounds(100,290,200,30);
        add(l6);
        
        r1.setBounds(300,290,60,30);
        add(r1);
        
        r2.setBounds(450,290,90,30);
        add(r2);
        
        l7.setBounds(100,340,200,30);
        add(l7);
        
        t3.setBounds(300,340,400,30);
        add(t3);
        
        l8.setBounds(100,390,200,30);
        add(l8);
        
        r3.setBounds(300,390,100,30);
        add(r3);
        
        r4.setBounds(450,390,100,30);
        add(r4);
        
        r5.setBounds(635,390,100,30);
        add(r5);
        
        l9.setBounds(100,440,200,30);
        add(l9);
        
        c4.setBounds(300,440,400,30);
        add(c4);
        
        l10.setBounds(100,490,200,30);
        add(l10);
        
        c5.setBounds(300,490,400,30);
        add(c5);
        
        l11.setBounds(100,540,200,30);
        add(l11);
        
        c6.setBounds(300,540,400,30);
        add(c6);
        
        l12.setBounds(100,590,200,30);
        add(l12);
        
        c7.setBounds(300,590,400,30);
        add(c7);
        
        l13.setBounds(100,640,200,30);
        add(l13);
        
        c8.setBounds(300,640,400,30);
        add(c8);
        
        b.setBounds(620, 710, 80, 30);
        add(b);
        
        b.addActionListener(this);
        
        setSize(850,850);
        setLocation(500,90);
        setVisible(true);
        
        
           
    }
    
    public void actionPerformed(ActionEvent ae){
        
        String name= t1.getText();
        String b= t2.getText();
        
        
        
        String dob=(String)c1.getSelectedItem()+(String)c2.getSelectedItem()+(String)c3.getSelectedItem();
        
        String d= null;
        if(r1.isSelected()){
            d="Male";
        }
        else if(r2.isSelected()){
            d="Female";
        }
        
        String e=t3.getText();
        
        String f=null;
        if(r3.isSelected()){
            f="Married";
        }
        else if(r4.isSelected()){
            f="Unmarried";
        }
        else if(r5.isSelected()){
            f="Other";
        }
        
        String g=(String)c4.getSelectedItem();
        String h=(String)c5.getSelectedItem();
        String i=(String)c6.getSelectedItem();
        String j=(String)c7.getSelectedItem();
        String k=(String)c8.getSelectedItem();
        
        //contact with database
        
        try{
            if(t1.getText().equals("")){
                JOptionPane.showMessageDialog(null,"Please fill all the required fields");
            }
            else if(t2.getText().equals("")){
                JOptionPane.showMessageDialog(null,"Please fill all the required fields");
            } 
            else if(t3.getText().equals("")){
                JOptionPane.showMessageDialog(null,"Please fill all the required fields");
            }else{
                
                conn c1=new conn();
                String q1="insert into customer(name,fname,dob,gender,email,form_no) values('"+name+"','"+b+"','"+dob+"','"+d+"','"+e+"','"+first+"')";
                String q2="insert into personal_info(marital_status,religion,caste,education,occupation,income) values('"+f+"','"+g+"','"+h+"','"+i+"','"+j+"','"+k+"')";
                c1.s.executeUpdate(q1);
                c1.s.executeUpdate(q2);
                new Register2().setVisible(true);
                setVisible(false);
        
            }
            
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
    }
    
    public static void main(String[] args){
        new Register().setVisible(true);
    }
        
}
