
package uniapp.interfaces;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class unStudentInfo {
    
    JLabel label1,label2,label3,label4,label5,firstYear,label7,secondYear,label8,thirdYear,label9,label10,label11,label12;
    JButton result,stdInfo;
    
    public unStudentInfo(){
        JFrame info =new JFrame();
        info.setLayout(new GridLayout(8,2,1,1));
     //   info.setVisible(true);
    //    info.setLocationRelativeTo(null);
        info.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        info.setSize(500,600);
        
        label1.setText("Student Information");
        info.add(label1);
        info.add(label2);
        info.add(label3);
        info.add(label4);
        label5.setText("First Year  : ");
        info.add(label5);
        firstYear.setText(" ");
        info.add(firstYear);
        label7.setText("Second Year  : ");
        info.add(label7);
        secondYear.setText(" ");
        info.add(secondYear);
        label8.setText("Thired Year  : ");
        info.add(label8);
        thirdYear.setText(" ");
        info.add(thirdYear);
        info.add(label9);
        info.add(label10);
        result.setText("Results Center ");
        info.add(result);
        stdInfo.setText("Student Info ");
        info.add(stdInfo);
        info.add(label11);
        info.add(label12);
        
    }

    void setVisible(boolean b) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
 
