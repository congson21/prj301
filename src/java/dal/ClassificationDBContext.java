/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Classification;

/**
 *
 * @author Asus
 */
public class ClassificationDBContext extends DBContext{
    public ArrayList<Classification> getClassifications()
    {
        ArrayList<Classification> classifications = new ArrayList<>();
        try {
            String sql = "SELECT cid, cname FROM Classification";
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while(rs.next())
            {
                Classification c = new Classification();
                c.setId(rs.getInt("cid"));
                c.setName(rs.getString("cname"));
                classifications.add(c);
            }           
        } catch (SQLException ex) {
            Logger.getLogger(ClassificationDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return classifications;
    }
}
