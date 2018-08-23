
package uniapp.classes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class undergraduate {
    
    Connection con;
    public String regNo,ALresult;
    public int rank;
    public double zcore;
    
    
    public undergraduate(String regNo,int rank,double zcore,String ALresult) throws SQLException{
        con=uniapp.dbConnection.createConenction.getConenction();
        this.regNo=regNo;
        this.rank=rank;
        this.zcore=zcore;
        this.ALresult=ALresult;
    }
    
    public String getRegNo(){
        return regNo;
    }
    public int getRank(){
        return rank;
    }
    public double getzcore(){
        return zcore;
    }

    public String getALresult(){
        return ALresult;
    }
    
    public void insert2() throws SQLException{
        String query2="INSERT INTO  undergraduate (regNo,rank,zcore,ALresult) VALUES (?,?,?,?)";
        PreparedStatement st2=con.prepareStatement(query2);
        st2.setString(1,getRegNo());
        st2.setInt(2,getRank());
        st2.setDouble(3, getzcore());
        st2.setString(4,getALresult());
        
        st2.execute();
    }     

    
    
}
