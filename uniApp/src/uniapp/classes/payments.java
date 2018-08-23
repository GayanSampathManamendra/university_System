
package uniapp.classes;

import static com.sun.javafx.animation.TickCalculation.sub;
import java.awt.Color;
import java.awt.GridLayout;
import static java.awt.PageAttributes.ColorType.COLOR;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import uniapp.interfaces.studentRegistation;
import uniapp.classes.*;




public class payments {
    
    Connection con;
    String faculty,regNo,subCode,pay;
    int acadumicYear;
    int semester;
    
    String subject1,subject2,subject3,subject4,subject5;
    
    public payments(String faculty,int acadumicYear,int semester) throws SQLException{
        con=uniapp.dbConnection.createConenction.getConenction();
        this.faculty=faculty;
        this.acadumicYear=acadumicYear;
        this.semester=semester;
        
    }
    
    public String getFaculty(){
        return faculty;
    }
    public int getAcadumicYear(){
        return acadumicYear;
    }
    public int getSemester(){
        return semester;
    }
   
    
    public void search() throws SQLException{
        String query="SELECT subCode,subjectName FROM subject WHERE faculty=? and acadumicYear=? and semester=?";
        PreparedStatement st=con.prepareStatement(query);
        st.setString(1,getFaculty());
        st.setInt(2,getAcadumicYear());
        st.setInt(3,getSemester());
        ResultSet res=st.executeQuery();
        
        int i=0;
        
        JFrame sub=new JFrame();
        sub.setSize(600,300);
        sub.setLayout(new GridLayout(5,5));
      //  panel.setBackground(Color.RED);
       // sub.add("Center",panel);
        sub.setVisible(true);
        
        
        JLabel subjName1=new JLabel("");
        JLabel subjName2=new JLabel("");
        JLabel subjName3=new JLabel("");
        JLabel subjName4=new JLabel("");
        JLabel subjName5=new JLabel("");
        
        JCheckBox subCode1=new JCheckBox();
        JCheckBox subCode2=new JCheckBox();
        JCheckBox subCode3=new JCheckBox();
        JCheckBox subCode4=new JCheckBox();
        JCheckBox subCode5=new JCheckBox();
        
        JRadioButton sub1Payed=new JRadioButton("Payed");
        JRadioButton sub1NotPayed=new JRadioButton("Not Payed");
        
        JRadioButton sub2Payed=new JRadioButton("Payed");
        JRadioButton sub2NotPayed=new JRadioButton("Not Payed");
        
        JRadioButton sub3Payed=new JRadioButton("Payed");
        JRadioButton sub3NotPayed=new JRadioButton("Not Payed");
        
        JRadioButton sub4Payed=new JRadioButton("Payed");
        JRadioButton sub4NotPayed=new JRadioButton("Not Payed");
        
        JRadioButton sub5Payed=new JRadioButton("Payed");
        JRadioButton sub5NotPayed=new JRadioButton("Not Payed");
     
        JButton sub1Info=new JButton("Info");
        JButton sub2Info=new JButton("Info");
        JButton sub3Info=new JButton("Info");
        JButton sub4Info=new JButton("Info");
        JButton sub5Info=new JButton("Info");
        
    }
}
        
        
    /*
        while(res.next()){
           i++;
    /*       
         switch(i){
               case 1:
                   subCode1.setText(res.getString("subCode"));
                   subCode1.addActionListener(new ActionListener(){
                       public String subCode;
                       @Override
                       public void actionPerformed(ActionEvent e){
                           try {
                               this.subCode=res.getString("subCode");
                           } catch (SQLException ex) {
                               Logger.getLogger(payments.class.getName()).log(Level.SEVERE, null, ex);
                           }
                       }
                   });*
                   subjName1.setText(res.getString("subjectName"));
                   break;
                   
                //   sub.add(sub1Info);
               case 2:
                   subCode2.setText(res.getString("subCode"));
                   subjName2.setText(res.getString("subjectName"));
                   break;
                  
               case 3:   
                   subCode3.setText(res.getString("subCode"));
                   subjName3.setText(res.getString("subjectName"));
                   break;
                   
               case 4:   
                   subCode4.setText(res.getString("subCode"));
                   subjName4.setText(res.getString("subjectName"));
                   break;
                   
               case 5:    
                   subCode5.setText(res.getString("subCode"));
                   subjName5.setText(res.getString("subjectName"));
                   break;
                   
           }       
           sub.add(subCode1);
           sub.add(subjName1);
           sub.add(sub1Payed);
           sub.add(sub1NotPayed);
           sub.add(sub1Info);
           
           sub.add(subCode2);
           sub.add(subjName2);
           sub.add(sub2Payed);
           sub.add(sub2NotPayed);
           sub.add(sub2Info);
           
           sub.add(subCode3);
           sub.add(subjName3);
           sub.add(sub3Payed);
           sub.add(sub3NotPayed);
           sub.add(sub3Info);
           
           sub.add(subCode4);
           sub.add(subjName4);
           sub.add(sub4Payed);
           sub.add(sub4NotPayed);
           sub.add(sub4Info);
           
           sub.add(subCode5);
           sub.add(subjName5);
           sub.add(sub5Payed);
           sub.add(sub5NotPayed);
           sub.add(sub5Info);
           
          
           
            
        }
        
    }
    
    
    public void insert1(String regNo,String subCode,String pay) throws SQLException{
        String query1="INSERT INTO payments (regNo,subCode,pay) VALUES (?,?,?)";
        PreparedStatement st1=con.prepareStatement(query1);
        st1.setString(1,getRegNo());
        st1.setString(2,getSubCode());
        st1.setString(3,getPay());
        
    }
    
    public void setValues(String regNo,String subCode,String pay){
        this.regNo=regNo;
        this.subCode=subCode;
        this.pay=pay;
    }

    private String getRegNo() {
        return regNo;
    }

    private String getSubCode() {
       return subCode;
    }

    private String getPay() {
         return pay;
    }
}
*/
        

