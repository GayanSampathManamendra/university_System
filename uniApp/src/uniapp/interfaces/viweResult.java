/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uniapp.interfaces;

import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type.String;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author USER PC
 */
public class viweResult extends javax.swing.JFrame {
    
    Connection con;
    
     public String facutyName=home.getFac();
    public int getAccYear=chooseAccYear.getYear();
    public int getSemesterNum=chooseAccYear.getSemesterNo();
    String regNo,subj;
    double tot1=0;double tot2=0; double tot3=0 ;
    double assOverall,practicalOverall,reportOverall,overall,x;
    int assCounter=0;int reportCounter=0;int practicalCounter=0;
    String overallStringNumber;
    int k;
    double mark;
    int presentage;
    
   

    /**
     * Creates new form viweResult
     */
    public viweResult(String indexNum) throws SQLException {
        initComponents();
        con=uniapp.dbConnection.createConenction.getConenction();
        regNumLable.setText(indexNum);
        regNo=indexNum;
        searchSubj();
    }

    
     public void searchSubj() throws SQLException{
        String query1;
        query1 = "SELECT DISTINCT subCode FROM subject WHERE   acadumicYear=? AND semester=? AND faculty= ?";
        PreparedStatement st1=con.prepareStatement(query1);
     //   st.setString(1,RegNum.getText());
        st1.setInt(1,getAccYear);
        st1.setInt(2,getSemesterNum);
        st1.setString(3,facutyName);
        ResultSet res=st1.executeQuery();
        
        while(res.next()){
            subject.addItem(res.getString("subCode"));
        }
    }
     
     
    public void searchStd()throws SQLException{
       
        String quary2;
        quary2="SELECT marks FROM exam WHERE regNo=? AND subject=?";
        
        PreparedStatement st2=con.prepareStatement(quary2);
        st2.setString(1,regNo);
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
     
    
   
    
    public double returnOverallMark() throws SQLException{
        
        String query1="SELECT marks FROM assignmentmarks WHERE regNo=? AND subCode=?";
        PreparedStatement st1=con.prepareStatement(query1);
        st1.setString(1,getRegNo());
        st1.setString(2,getSubject());
        ResultSet res1=st1.executeQuery();
        
        while(res1.next()){
            tot1=((Double.parseDouble(res1.getString("marks")))+tot1);
            assCounter++;
        }
        
        if(tot1==0 && assCounter==0){
            assignments.setText("Not Given");
            
        }
        else if(tot1 != 0 && assCounter !=0){
            assOverall=((tot1)/(assCounter));
            assignments.setText(Double.toString(assOverall));
        }
        
        String query2="SELECT marks FROM  reportmarks WHERE regNo=? AND subCode=?";
        PreparedStatement st2=con.prepareStatement(query2);
        st2.setString(1,getRegNo());
        st2.setString(2,getSubject());
        ResultSet res2=st2.executeQuery();
        
        while(res2.next()){
            tot2=((Double.parseDouble(res2.getString("marks")))+tot2);
            reportCounter++;
        }
        if(tot2==0 && reportCounter==0){
            reports.setText("Not Given");
        }
        else if(tot2 != 0 && reportCounter !=0){
            reportOverall=((tot2)/(reportCounter));
            reports.setText(Double.toString(reportOverall));
        }
        
        
        String query3="SELECT marks FROM practicals WHERE regNo=? AND subCode=?";
        PreparedStatement st3=con.prepareStatement(query3);
        st3.setString(1,getRegNo());
        st3.setString(2,getSubject());
        ResultSet res3=st3.executeQuery();
        
        while(res3.next()){
            tot3=((Double.parseDouble(res3.getString("marks")))+tot3);
            practicalCounter++;
        }
        if(tot3==0 && practicalCounter==0){
            practicals.setText("Not Given");
        }
        else if(tot3 != 0 && practicalCounter !=0){
            practicalOverall=((tot3)/(practicalCounter));
            practicals.setText(Double.toString(practicalOverall));
        }
        
        if(assOverall==0 && reportOverall==0 && practicalOverall==0){
            System.out.println("");
        }
        else{
            overall=Math.round(((assOverall+reportOverall+practicalOverall)/3));
        }
        
    
        return overall;
    }
    
    public void getPresentage() throws SQLException{
    
        String query5="SELECT presantage FROM subject WHERE subCode=?";
        
        PreparedStatement statement=con.prepareStatement(query5);
        statement.setString(1, (java.lang.String) subject.getSelectedItem());
        
        ResultSet result=statement.executeQuery();
        
        while(result.next()){
            presentage=(result.getInt("presantage"));
        }
    
    }
    
   public void getFinalResult() throws SQLException{
       //System.out.println((presentage));
     double overallAsment=returnOverallMark();
     if(mark !=0.0){
       if(overallAsment==0.0){
          // System.out.println("hello");
            long p=(java.lang.Math.round((mark/100)*(100-(presentage))));
            String q=" ";
            q=q+p;
            finalResult.setText(q);
       }
       else{
           double finalMark=(((overallAsment/100)*(presentage))+((mark/100)*(100-(presentage))));
           
           long r=(java.lang.Math.round(finalMark));
           String s=" ";
           s=s+r;
           finalResult.setText(s);
           
       }
     }
     else{
         examResult.setText("Not Given !");
         if(overallAsment==0.0){
             finalResult.setText("Zero Mark!");
          }
         else{
             double fMark=((overallAsment/100)*(presentage));
             long i=(java.lang.Math.round(fMark));
             String v=" ";
             v=v+i;
             finalResult.setText(v);
         }
     
     }
       
       
   }
    
    
  /*   public void insert() throws SQLException{
        String query_insert="INSERT INTO overallmarks (regNo,subCode,overallEssMarks) VALUES (?,?,?)";
        PreparedStatement s=con.prepareStatement(query_insert);
        s.setString(1,getRegNo());
        s.setString(2,getSubject());
        s.setInt(3,(int) overall);
        s.execute();
    }
    */
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        regNumLable = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        subject = new javax.swing.JComboBox<>();
        ok = new javax.swing.JButton();
        showResult = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        finalResult = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        examResult = new javax.swing.JLabel();
        result = new javax.swing.JLabel();
        reports = new javax.swing.JLabel();
        practicals = new javax.swing.JLabel();
        assignments = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(204, 255, 255));

        regNumLable.setFont(new java.awt.Font("Tahoma", 2, 18)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Tahoma", 2, 18)); // NOI18N
        jLabel3.setText("Reg Number :");

        subject.setFont(new java.awt.Font("Tahoma", 2, 18)); // NOI18N

        ok.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        ok.setText("ok");
        ok.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okActionPerformed(evt);
            }
        });

        showResult.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        showResult.setText("Show Result");
        showResult.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showResultActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Tahoma", 2, 18)); // NOI18N
        jLabel12.setText("Subject :");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(showResult)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(ok, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(regNumLable, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(subject, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(regNumLable, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(70, 70, 70)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(subject, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ok)
                    .addComponent(showResult))
                .addGap(42, 42, 42))
        );

        jPanel3.setBackground(new java.awt.Color(204, 255, 255));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        jLabel4.setFont(new java.awt.Font("Tahoma", 2, 18)); // NOI18N
        jLabel4.setText("Practicals      :");

        jLabel5.setFont(new java.awt.Font("Tahoma", 2, 18)); // NOI18N
        jLabel5.setText("Reports        :");

        jLabel6.setFont(new java.awt.Font("Tahoma", 2, 18)); // NOI18N
        jLabel6.setText("Examination  :");

        jLabel7.setFont(new java.awt.Font("Tahoma", 2, 18)); // NOI18N
        jLabel7.setText("Final Result   :");

        jLabel8.setFont(new java.awt.Font("Tahoma", 2, 18)); // NOI18N
        jLabel8.setText("Inclass Assignments  :");

        finalResult.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        finalResult.setForeground(new java.awt.Color(255, 51, 51));

        jLabel10.setFont(new java.awt.Font("Tahoma", 2, 18)); // NOI18N
        jLabel10.setText(" Overall Assignments  :");

        examResult.setFont(new java.awt.Font("Tahoma", 2, 18)); // NOI18N
        examResult.setForeground(new java.awt.Color(0, 0, 255));

        result.setFont(new java.awt.Font("Tahoma", 2, 18)); // NOI18N
        result.setForeground(new java.awt.Color(0, 51, 204));

        reports.setFont(new java.awt.Font("Tahoma", 2, 18)); // NOI18N

        practicals.setFont(new java.awt.Font("Tahoma", 2, 18)); // NOI18N

        assignments.setFont(new java.awt.Font("Tahoma", 2, 18)); // NOI18N

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(finalResult, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(examResult, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(practicals, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                                .addComponent(assignments, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(reports, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(result, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(assignments, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(practicals, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                        .addComponent(reports, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(result, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(examResult, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(finalResult, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );

        jLabel1.setFont(new java.awt.Font("Tahoma", 3, 24)); // NOI18N
        jLabel1.setText("More Results");

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nsbmLogo.JPG"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(273, 273, 273)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
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

    private void showResultActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showResultActionPerformed
        try {
            getPresentage();
        } catch (SQLException ex) {
            Logger.getLogger(viweResult.class.getName()).log(Level.SEVERE, null, ex);
        }
       //  regNo=regNo.getText();
         subj=(String) subject.getSelectedItem();
        
        try {
            /*  try {
            // overallStringNumber=Double.toString(returnOverallMark());
            } catch (SQLException ex) {
            Logger.getLogger(overall.class.getName()).log(Level.SEVERE, null, ex);
            }
            //  overallMark.setText(overallStringNumber);*/
            x=returnOverallMark();
            result.setText(Double.toString(x));
            searchStd();
            getFinalResult();
          //  getFinalResult()
         /*   addResult OverallResult=new addResult(regNum,subj,x);
            OverallResult.setVisible(true);*/
         
       /*     String query3="INSERT INTO  overallmarks(regNo,subCode,overallEssMarks) VALUES (?,?,?)";
            
           
            PreparedStatement sta=con.prepareStatement(query3);
            sta.setString(1,regNo);
            sta.setString(2, (String) subject.getSelectedItem());
            sta.setInt(3, (int) x);
            sta.execute();
            
          //  JOptionPane.showMessageDialog(null, "Succsessfully Submitted !");
           // this.dispose();
        */
            
            
            
            
        } catch (SQLException ex) {
            Logger.getLogger(overall.class.getName()).log(Level.SEVERE, null, ex);
        }
        
       /* try {
           // insert();
        } catch (SQLException ex) {
           // Logger.getLogger(overall.class.getName()).log(Level.SEVERE, null, ex);
        }*/
        
    }//GEN-LAST:event_showResultActionPerformed

    private void okActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okActionPerformed
        this.dispose();
       // viweResult(String regNo);
    }//GEN-LAST:event_okActionPerformed

    
     public String getRegNo(){
        return regNo;
    }
    
    public String getSubject(){
        return subj;
    }
    
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
            java.util.logging.Logger.getLogger(viweResult.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(viweResult.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(viweResult.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(viweResult.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
         //       new viweResult().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel assignments;
    private javax.swing.JLabel examResult;
    private javax.swing.JLabel finalResult;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JButton ok;
    private javax.swing.JLabel practicals;
    private javax.swing.JLabel regNumLable;
    private javax.swing.JLabel reports;
    private javax.swing.JLabel result;
    private javax.swing.JButton showResult;
    private javax.swing.JComboBox<String> subject;
    // End of variables declaration//GEN-END:variables

 /*   static class searchSubj {

        public searchSubj() {
        }
    }
*/
 
}
