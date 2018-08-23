
package uniapp.classes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class facAndYear {
    
    Connection con;
    String regNo,faculty;
    int acadumicYear,semester;
    
    public facAndYear(String regNo,String faculty,int acadumicYear,int semester) throws SQLException{
        con=uniapp.dbConnection.createConenction.getConenction();
        this.regNo=regNo;
        this.faculty=faculty;
        this.acadumicYear=acadumicYear;
        this.semester=semester;    
    }
    
    public String getRegNo(){
        return regNo;
    }
    
    public String getFaculty(){
        return faculty;
    }
    
    public int getAccYear(){
        return acadumicYear;
    }
    public int getSemester(){
        return semester;
    }
    
    public void insert() throws SQLException{
        String query = "INSERT INTO facandyear(regNo,faculty,acadumicYear,semester) VALUES (?,?,?,?)";
        PreparedStatement stat=con.prepareStatement(query);
        stat.setString(1, getRegNo());
        stat.setString(2, getFaculty());
        stat.setInt(3,getAccYear());
        stat.setInt(4,getSemester());
        
        stat.execute();
    }
    
}
