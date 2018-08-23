
package uniapp.classes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class postgraduate {
    
    Connection con;
    public String regNo,qulificationType,institute;
    public int outYear;
    public double curGPA;
    
    
    public postgraduate(String regNo,String qulificationType,String institute,double curGPA,int outYear) throws SQLException{
        con=uniapp.dbConnection.createConenction.getConenction();
        this.regNo=regNo;
        this.qulificationType = qulificationType;
        this.institute=institute;
        this.curGPA=curGPA;
        this.outYear=outYear;
    }
    
    public String getRegNo(){
        return regNo;
    }
    public String getQlificationType(){
        return qulificationType;
    }
    public String getInstitute(){
        return institute;
    }

    public double getCurGPA(){
        return curGPA;
    }
    public int getOutYear(){
        return outYear;
    }
    
    
    public void insert3() throws SQLException{
        String query3="INSERT INTO  postgraduate (regNo,qulificationType,institute,curGPA,outYear) VALUES (?,?,?,?,?)";
        PreparedStatement st3=con.prepareStatement(query3);
        st3.setString(1,getRegNo());
        st3.setString(2,getQlificationType());
        st3.setString(3,getInstitute());
        st3.setDouble(4,getCurGPA());
        st3.setInt(5,getOutYear());
        
        st3.execute();
    }    
}

    

