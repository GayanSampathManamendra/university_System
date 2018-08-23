

package uniapp.classes;

import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type.String;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class studentReg {
    
    public String regNo,name,nic,DOB,addres,gender,email,district;
    public int age,tel,curYear;
    Connection con;
    
    
    public studentReg(String regNo,String name,String nic,String DOB,String addres,int age,String gender,String email,int tel,String district,int curYear) throws SQLException{
        this.con=uniapp.dbConnection.createConenction.getConenction();
        this.regNo=regNo;
        this.name=name;
        this.nic=nic;
        this.DOB=DOB;
        this.age=age;
        this.addres=addres;
        this.gender=gender;
        this.email=email;
        this.tel=tel;
        this.district=district;
        this.curYear=curYear;
    }
    
    public String getRegNo(){
        return regNo;
    }
    
    public String getName(){
        return name;
    }
    public String getNic(){
        return nic=nic;
    }
    
    public String getDOB(){
        return DOB=DOB;
    }
    public int getAge(){
        return age;
    }
    public String getAddres(){
        return addres;
    }
    public String getGender(){
        return gender;
    }
    public String getEmail(){
        return email;
    }
    public int getTel(){
        return tel;
    }
    public String getDistrict(){
        return district;
    }
    public int getCurYear(){
        return curYear;
    }
    
    public void insert() throws SQLException{
    
        String query="INSERT INTO student(regNo,name,nic,DOB,age,addres,gender,email,tel,district,curYear) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement st1=con.prepareStatement(query);
        st1.setString(1,getRegNo());
        st1.setString(2,getName());
        st1.setString(3,getNic());
        st1.setString(4,getDOB());
        st1.setInt(5,getAge());
        st1.setString(6,getAddres());
        st1.setString(7,getGender());
        st1.setString(8,getEmail());
        st1.setInt(9,getTel());
        st1.setString(10,getDistrict());
        st1.setInt(11,getCurYear());
        
        st1.execute();
        
    }
    
}

