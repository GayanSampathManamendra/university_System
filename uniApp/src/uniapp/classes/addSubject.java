
package uniapp.classes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class addSubject {
    
    Connection con;
    String subCode,subjectName,faculty;
    int acadumicYear,semester,numOfCredit,amount;
    
    public addSubject(String subCode,String subjectName,String faculty,int acadumicYear,int semester,int numOfCredit,int amount) throws SQLException{
        con=uniapp.dbConnection.createConenction.getConenction();
        this.subCode=subCode;
        this.subjectName=subjectName;
        this.faculty=faculty;
        this.acadumicYear=acadumicYear;
        this.semester=semester;
        this.numOfCredit=numOfCredit;
        this.amount=amount;
    }
    
    public int getAcadumicYear(){
        return acadumicYear;
    }
    public int getSemester(){
        return semester;
    }
    public String getFaculty(){
        return faculty;
    }
    
    public void insert() throws SQLException{
        String query="INSERT INTO subject (subCode,subjectName,faculty,acadumicYear,semester,numOfCredit,amount) VALUES (?,?,?,?,?,?,?)";
        PreparedStatement state=con.prepareStatement(query);
        state.setString(1,subCode);
        state.setString(2,subjectName);
        state.setString(3,faculty);
        state.setInt(4,acadumicYear);
        state.setInt(5,semester);
        state.setInt(6,numOfCredit);
        state.setInt(7,amount);
        
        state.execute();
    }
    
}
