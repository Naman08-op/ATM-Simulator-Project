/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AtmSimulator;
import java.sql.*;
/**
 *
 * @author Naman
 */
public class conn {
    Connection c;
    Statement s;
    public conn(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            c=DriverManager.getConnection("jdbc:mysql://localhost:3306/atm","root","1111");
            s=c.createStatement();
        }
        catch(Exception e){
            System.out.println(e);
                    
            
        }
    }
    
}
