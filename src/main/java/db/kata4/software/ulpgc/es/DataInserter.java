package db.kata4.software.ulpgc.es;

import model.kata4.software.ulpgc.es.F1DriverRegister;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class DataInserter {

    public void insertDirverRegisters(List<F1DriverRegister> registers, Connection conn){
        String sql = "INSERT INTO f1championship(id, position, name, team, country, points, year, acronym) VALUES(?, ?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement pstmt = conn.prepareStatement(sql)){
            int count = 1;
            for(F1DriverRegister reg: registers){
                pstmt.setString(1, reg.getId());
                pstmt.setInt(2, reg.getPosition());
                pstmt.setString(3, reg.getName());
                pstmt.setString(4, reg.getNacionality());
                pstmt.setString(5, reg.getTeam());
                pstmt.setFloat(6, reg.getPoints());
                pstmt.setInt(7, reg.getYear());
                pstmt.setString(8, reg.getAcronym());
                System.out.println("Registro " + count);
                count++;
            }
        } catch (SQLException e){
            e.printStackTrace();
            System.out.println("Error inserting data: " + e.getMessage());
        }
    }

}
