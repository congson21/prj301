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
import model.Room;

/**
 *
 * @author Asus
 */
public class RoomDBContext extends DBContext {

    public ArrayList<Room> getRooms() {
        ArrayList<Room> rooms = new ArrayList<>();
        try {
            String sql = "SELECT [rid]\n"
                    + "      ,[name]\n"
                    + "  FROM [Room]";
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Room r = new Room();
                r.setId(rs.getInt("rid"));
                r.setName(rs.getString("name"));
                rooms.add(r);
            }
        } catch (SQLException ex) {
            Logger.getLogger(RoomDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rooms;
    }
}
