/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AtmSimulator;
import javax.swing.*;


/**
 *
 * @author Naman
 */
public class Map extends JFrame{
    
    JButton b1;
    
    Map(){
        
         JFrame frame = new JFrame();
        frame.setTitle("Map");

        frame.setLocation(500,90);
  ImageIcon icon = new ImageIcon("C:\\Users\\Naman\\Documents\\NetBeansProjects\\AtmSimulator\\src\\Images\\map.jpeg");
  JLabel label = new JLabel(icon);
  
  frame.add(label);
      
  frame.setDefaultCloseOperation
         (JFrame.EXIT_ON_CLOSE);
  frame.pack();
  frame.setVisible(true);
  
    
   
        }
    public static void main(String args[]) {
        new Map();
  
 }


    
}
