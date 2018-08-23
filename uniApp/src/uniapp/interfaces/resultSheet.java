/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uniapp.interfaces;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import static uniapp.interfaces.OndStdDetail.regNumber;
import uniapp.interfaces.viweResult.*;


/**
 *
 * @author USER PC
 */
public class resultSheet extends javax.swing.JFrame {

    /**
     * Creates new form resultSheet
     * 
     * 
     */
    
        String indexNum;
        int count=0;
        double FinalMark;
        double tot1=0;double assOverall=0;double tot2=0;double reportOverall=0;double tot3=0;double practicalOverall=0;double overall=0;
        int assCounter=0;int reportCounter=0;int practicalCounter=0;
        int presentage;
        int A_presentage;
        
       
        
        Connection con;
    
    public resultSheet(String text) throws SQLException {
            initComponents();
            con=uniapp.dbConnection.createConenction.getConenction();
            System.out.print(text);
            indexNumLable.setText(text);
            indexNum=text;
            searchSubjects();
           // System.out.print(indexNum);
          
           
           
           
           
    }
    
  //  viweResult.searchSubj();
    
    
    public void searchSubjects() throws SQLException{
    
     String quary1="SELECT subject.subjectName, subject.subCode FROM payments INNER JOIN subject ON payments.subCode=subject.subCode WHERE payments.regNo=? ";
     PreparedStatement state=con.prepareStatement(quary1);
     state.setString(1,indexNum);
     ResultSet result=state.executeQuery();
     
     while(result.next()){
         count++;
         if(count==1){
             String subject1 = result.getString("subject.subCode");
             sub1Code.setText(result.getString("subCode"));
             sub1.setText(result.getString("subjectName"));
           //  String sub1Grade=getFinalResult(subject1);
           //  long x=Long.parseLong(sub1Grade);
             sub1res.setText(getFinalResult(subject1));
         }
         if(count==2){
             String subject2 = result.getString("subCode");
             sub2Code.setText(result.getString("subCode"));
             sub2.setText(result.getString("subjectName"));
             sub2res.setText(getFinalResult(subject2));
         }
         if(count==3){
             String subject3 = result.getString("subCode");
             sub3Code.setText(result.getString("subCode"));
             sub3.setText(result.getString("subjectName"));
             sub3res.setText(getFinalResult(subject3));
         }
         if(count==4){
             String subject4 = result.getString("subCode");
             sub4Code.setText(result.getString("subCode"));
             sub4.setText(result.getString("subjectName"));
             sub4res.setText(getFinalResult(subject4));
         }
         if(count==5){
             String subject5 = result.getString("subCode");
             sub5Code.setText(result.getString("subCode"));
             sub5.setText(result.getString("subjectName"));
             sub5res.setText(getFinalResult(subject5));
         }
         if(count==6){
             String subject6 = result.getString("subCode");
             sub6Code.setText(result.getString("subCode"));
             sub6.setText(result.getString("subjectName"));
             sub6res.setText(getFinalResult(subject6));
         }
         if(count==7){
             String subject7 = result.getString("subCode");
             sub6Code.setText(result.getString("subCode"));
             sub6.setText(result.getString("subjectName"));
            sub7res.setText(getFinalResult(subject7));
         }
         if(count==8){
             String subject8 = result.getString("subCode");
             sub8Code.setText(result.getString("subCode"));
             sub7.setText(result.getString("subjectName"));
             sub8res.setText(getFinalResult(subject8));
         }
         
         
     }
    
    }
    
    public double searchSubjectmark(String subject) throws SQLException{
        String query6="SELECT marks FROM exam WHERE subject=?";
        PreparedStatement state1=con.prepareStatement(query6);
        state1.setString(1,subject);
        ResultSet result=state1.executeQuery();
        
        while(result.next()){
            FinalMark=(double)(result.getInt("marks"));
        }
        return FinalMark;
        
    
    }
    

  /*  
    public void searchStd()throws SQLException{
       
        String quary2;
        quary2="SELECT marks FROM exam WHERE regNo=? AND subject=?";
        
        PreparedStatement st2=con.prepareStatement(quary2);
        st2.setString(1,indexNum);
        st2.setString(2,subject.getSelectedItem().toString());
        
        ResultSet result=st2.executeQuery();

        while(result.next()){
             String y=" ";
             mark=result.getInt("marks");
              y=y+mark;
            if(y.equalsIgnoreCase("null")){
                examResult.setText("Not Given !");
                mark=0.0;
            }
            else{
                 //  mark=result.getInt("marks");
                //  String y=" ";
                 // y=y+mark;
                   examResult.setText(y); 
            }
            
         
           
        }
    }
     */
    
   
    
    public double returnOverallMark(String subject) throws SQLException{
        
        String query1="SELECT marks FROM assignmentmarks WHERE  subCode=?";
        PreparedStatement st1=con.prepareStatement(query1);
    //    st1.setString(1,indexNumber);
        st1.setString(1,subject);
        ResultSet res1=st1.executeQuery();
        
        while(res1.next()){
            tot1=((Double.parseDouble(res1.getString("marks")))+tot1);
            assCounter++;
        }
        
        if(tot1==0 && assCounter==0){
            tot1=0;
            
        }
        else if(tot1 != 0 && assCounter !=0){
            assOverall=((tot1)/(assCounter));
           // assignments.setText(Double.toString(assOverall));
        }
        
        String query2="SELECT marks FROM  reportmarks WHERE  subCode=?";
        PreparedStatement st2=con.prepareStatement(query2);
     //   st2.setString(1,getRegNo());
        st2.setString(1,subject);
        ResultSet res2=st2.executeQuery();
        
        while(res2.next()){
            tot2=((Double.parseDouble(res2.getString("marks")))+tot2);
            reportCounter++;
        }
        if(tot2==0 && reportCounter==0){
            tot2=0;
          //  reports.setText("Not Given");
        }
        else if(tot2 != 0 && reportCounter !=0){
            reportOverall=((tot2)/(reportCounter));
           // reports.setText(Double.toString(reportOverall));
        }
        
        
        String query3="SELECT marks FROM practicals WHERE  subCode=?";
        PreparedStatement st3=con.prepareStatement(query3);
       // st3.setString(1,getRegNo());
        st3.setString(1,subject);
        ResultSet res3=st3.executeQuery();
        
        while(res3.next()){
            tot3=((Double.parseDouble(res3.getString("marks")))+tot3);
            practicalCounter++;
        }
        if(tot3==0 && practicalCounter==0){
            tot3=0;
            //practicals.setText("Not Given");
        }
        else if(tot3 != 0 && practicalCounter !=0){
            practicalOverall=((tot3)/(practicalCounter));
          //  practicals.setText(Double.toString(practicalOverall));
        }
        
        if(assOverall==0 && reportOverall==0 && practicalOverall==0){
            System.out.println("");
        }
        else{
            overall=Math.round(((assOverall+reportOverall+practicalOverall)/3));
        }
        
    
        return overall;
    }
    
    public int getPresentage(String subject) throws SQLException{
    
        String query5="SELECT presantage FROM subject WHERE subCode=?";
        
        PreparedStatement statement=con.prepareStatement(query5);
        statement.setString(1, subject);
        
        ResultSet result=statement.executeQuery();
        
        while(result.next()){
            A_presentage=(result.getInt("presantage"));
        }
        return A_presentage;
    
    }
    
   public String getFinalResult(String subject) throws SQLException{
       //System.out.println((presentage));
     double overallAsment=returnOverallMark(subject);
     double mark=searchSubjectmark(subject);
     int presentage =getPresentage(subject);
     if(mark !=0.0){
       if(overallAsment==0.0){
          // System.out.println("hello");
            long p=(java.lang.Math.round((mark/100)*(100-(presentage))));
            String q=" ";
            q=q+p;
          //  finalResult.setText(q);
          return q;
       }
       else{
           double finalMark=(((overallAsment/100)*(presentage))+((mark/100)*(100-(presentage))));
           
           long r=(java.lang.Math.round(finalMark));
           String s=" ";
           s=s+r;
        //   finalResult.setText(s);
           return s;
           
       }
     }
     else{
        // examResult.setText("Not Given !");
       // return "NOt Given !";
         if(overallAsment==0.0){
           //  finalResult.setText("Zero Mark!");
           return "Zero marks";
          }
         else{
             double fMark=((overallAsment/100)*(presentage));
             long i=(java.lang.Math.round(fMark));
             String v=" ";
             v=v+i;
          //   finalResult.setText(v);
             return v;
         }
     
     }
       
       
   }
   
   public String getGrade(long x){
       String grd;
       if(x<=100 && x>= 90 );{
            grd= "A+";
        }
       if(x<90 && x>=80){
            grd="A";
        }
       if(x<80 && x<=75){
            grd="A-";
        }
        if(x<75 && x<=70){
            grd="B+";
        }
        if(x<70 && x>=65){
            grd="B";
        }
        if(x<=60 && x<65){
            grd="B-";
        }
        if(x<60 && x>=55){
            grd="C+";
        }
        if(x<55 && x<=50){
            grd="C";
        }
        if(x<50 && x>=45){
            grd="C-";
        }
        if(x<45 && x>=40){
            grd="D+";
        }
        if(x<40 && x>=35){
            grd="D";
        }
        if(x<35 && x>= 30){
            grd="D-";
        }
        else {
            grd="E";
        }
                       
       return grd;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        indexNumLable = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        moreResult = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        sub4Code = new javax.swing.JTextField();
        sub2Code = new javax.swing.JTextField();
        sub6Code = new javax.swing.JTextField();
        sub7Code = new javax.swing.JTextField();
        sub8Code = new javax.swing.JTextField();
        sub3Code = new javax.swing.JTextField();
        sub5Code = new javax.swing.JTextField();
        sub1Code = new javax.swing.JTextField();
        jPanel13 = new javax.swing.JPanel();
        sub4 = new javax.swing.JTextField();
        sub1 = new javax.swing.JTextField();
        sub2 = new javax.swing.JTextField();
        sub6 = new javax.swing.JTextField();
        sub7 = new javax.swing.JTextField();
        sub8 = new javax.swing.JTextField();
        sub3 = new javax.swing.JTextField();
        sub5 = new javax.swing.JTextField();
        jPanel14 = new javax.swing.JPanel();
        sub4res = new javax.swing.JTextField();
        sub1res = new javax.swing.JTextField();
        sub2res = new javax.swing.JTextField();
        sub6res = new javax.swing.JTextField();
        sub7res = new javax.swing.JTextField();
        sub8res = new javax.swing.JTextField();
        sub3res = new javax.swing.JTextField();
        sub5res = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();

        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 3, 24)); // NOI18N
        jLabel1.setText("Resut Sheet");

        jPanel3.setBackground(new java.awt.Color(204, 255, 255));

        indexNumLable.setFont(new java.awt.Font("Tahoma", 2, 18)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Tahoma", 2, 18)); // NOI18N
        jLabel2.setText("Index Number   :");

        jButton2.setFont(new java.awt.Font("Tahoma", 2, 18)); // NOI18N
        jButton2.setText("Cancel");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        moreResult.setFont(new java.awt.Font("Tahoma", 2, 18)); // NOI18N
        moreResult.setText("More details");
        moreResult.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                moreResultActionPerformed(evt);
            }
        });

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        jLabel3.setFont(new java.awt.Font("Tahoma", 2, 18)); // NOI18N
        jLabel3.setText("Subject Code");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel3)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        jLabel5.setFont(new java.awt.Font("Tahoma", 2, 18)); // NOI18N
        jLabel5.setText("Subject Name");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(117, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel5)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        jLabel6.setFont(new java.awt.Font("Tahoma", 2, 18)); // NOI18N
        jLabel6.setText("Final Grade");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel6)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        sub4Code.setFont(new java.awt.Font("Tahoma", 2, 14)); // NOI18N

        sub2Code.setFont(new java.awt.Font("Tahoma", 2, 14)); // NOI18N

        sub6Code.setFont(new java.awt.Font("Tahoma", 2, 14)); // NOI18N

        sub7Code.setFont(new java.awt.Font("Tahoma", 2, 14)); // NOI18N

        sub8Code.setFont(new java.awt.Font("Tahoma", 2, 14)); // NOI18N

        sub3Code.setFont(new java.awt.Font("Tahoma", 2, 14)); // NOI18N

        sub5Code.setFont(new java.awt.Font("Tahoma", 2, 14)); // NOI18N

        sub1Code.setFont(new java.awt.Font("Tahoma", 2, 14)); // NOI18N

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(sub1Code, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                    .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(sub2Code, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                        .addComponent(sub8Code)
                        .addComponent(sub4Code)
                        .addComponent(sub3Code)
                        .addComponent(sub5Code)
                        .addComponent(sub6Code)
                        .addComponent(sub7Code)))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(sub1Code, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(sub2Code, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sub3Code, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(sub4Code, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(sub5Code, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(sub6Code, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(sub7Code, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(sub8Code, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );

        sub4.setFont(new java.awt.Font("Tahoma", 2, 14)); // NOI18N

        sub1.setFont(new java.awt.Font("Tahoma", 2, 14)); // NOI18N

        sub2.setFont(new java.awt.Font("Tahoma", 2, 14)); // NOI18N

        sub6.setFont(new java.awt.Font("Tahoma", 2, 14)); // NOI18N

        sub7.setFont(new java.awt.Font("Tahoma", 2, 14)); // NOI18N

        sub8.setFont(new java.awt.Font("Tahoma", 2, 14)); // NOI18N

        sub3.setFont(new java.awt.Font("Tahoma", 2, 14)); // NOI18N

        sub5.setFont(new java.awt.Font("Tahoma", 2, 14)); // NOI18N

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(sub1, javax.swing.GroupLayout.DEFAULT_SIZE, 237, Short.MAX_VALUE)
                    .addComponent(sub2)
                    .addComponent(sub3)
                    .addComponent(sub4)
                    .addComponent(sub5)
                    .addComponent(sub6)
                    .addComponent(sub7)
                    .addComponent(sub8))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(sub1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sub2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(sub3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(sub4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(sub5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(sub6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(sub7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(sub8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        sub4res.setFont(new java.awt.Font("Tahoma", 2, 14)); // NOI18N

        sub1res.setFont(new java.awt.Font("Tahoma", 2, 14)); // NOI18N

        sub2res.setFont(new java.awt.Font("Tahoma", 2, 14)); // NOI18N

        sub6res.setFont(new java.awt.Font("Tahoma", 2, 14)); // NOI18N

        sub7res.setFont(new java.awt.Font("Tahoma", 2, 14)); // NOI18N

        sub8res.setFont(new java.awt.Font("Tahoma", 2, 14)); // NOI18N

        sub3res.setFont(new java.awt.Font("Tahoma", 2, 14)); // NOI18N

        sub5res.setFont(new java.awt.Font("Tahoma", 2, 14)); // NOI18N

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(sub1res, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sub2res, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sub8res, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sub4res, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sub3res, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sub5res, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sub6res, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sub7res, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(sub1res, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sub2res, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(sub3res, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(sub4res, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(sub5res, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(sub6res, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(sub7res, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(sub8res, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(21, 21, 21))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 6, Short.MAX_VALUE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(moreResult)
                .addGap(18, 18, 18)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(204, 204, 204))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addComponent(indexNumLable, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(indexNumLable, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(moreResult))
                .addGap(11, 11, 11))
        );

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nsbmLogo.JPG"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(297, 297, 297)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void moreResultActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_moreResultActionPerformed
       viweResult moreResult;
            try {
                moreResult = new viweResult(indexNum);
                moreResult.setVisible(true);
            } catch (SQLException ex) {
                Logger.getLogger(resultSheet.class.getName()).log(Level.SEVERE, null, ex);
            }
        
    }//GEN-LAST:event_moreResultActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(resultSheet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(resultSheet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(resultSheet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(resultSheet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
              //  new resultSheet().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel indexNumLable;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JButton moreResult;
    private javax.swing.JTextField sub1;
    private javax.swing.JTextField sub1Code;
    private javax.swing.JTextField sub1res;
    private javax.swing.JTextField sub2;
    private javax.swing.JTextField sub2Code;
    private javax.swing.JTextField sub2res;
    private javax.swing.JTextField sub3;
    private javax.swing.JTextField sub3Code;
    private javax.swing.JTextField sub3res;
    private javax.swing.JTextField sub4;
    private javax.swing.JTextField sub4Code;
    private javax.swing.JTextField sub4res;
    private javax.swing.JTextField sub5;
    private javax.swing.JTextField sub5Code;
    private javax.swing.JTextField sub5res;
    private javax.swing.JTextField sub6;
    private javax.swing.JTextField sub6Code;
    private javax.swing.JTextField sub6res;
    private javax.swing.JTextField sub7;
    private javax.swing.JTextField sub7Code;
    private javax.swing.JTextField sub7res;
    private javax.swing.JTextField sub8;
    private javax.swing.JTextField sub8Code;
    private javax.swing.JTextField sub8res;
    // End of variables declaration//GEN-END:variables
}
