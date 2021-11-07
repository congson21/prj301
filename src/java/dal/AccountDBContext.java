/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Account;
import model.Feature;

/**
 *
 * @author Asus
 */
public class AccountDBContext extends DBContext {

    public Account getAccount(String username, String password) {
        try {
            String sql = "SELECT a.username,a.password,f.fid,f.url FROM Account a \n"
                    + "LEFT JOIN GroupAccount ga ON ga.username = a.username\n"
                    + "LEFT JOIN [Group] g ON g.gid = ga.gid\n"
                    + "LEFT JOIN GroupFeature gf ON gf.gid = g.gid\n"
                    + "LEFT JOIN Feature f ON f.fid = gf.fid\n"
                    + "WHERE a.username = ? AND a.password = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, username);
            stm.setString(2, password);
            ResultSet rs = stm.executeQuery();
            Account account = null;
            while (rs.next()) {
                if (account == null) {
                    account = new Account();
                    account.setUsername(username);
                    account.setPassword(password);                  
                }
                int fid = rs.getInt("fid");
                if(fid !=0)
                {
                    Feature f = new Feature();
                    f.setId(fid);
                    f.setUrl(rs.getString("url"));
                    account.getFeatures().add(f);
                }
            }
            return account;
        } catch (SQLException ex) {
            Logger.getLogger(AccountDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
