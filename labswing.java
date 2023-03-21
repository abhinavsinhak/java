import java.util.*;
import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;

public class labswing extends JFrame implements ActionListener{
    JFrame j = new JFrame();

    JLabel label;
    JRadioButton op1,op2,op3,op4;
    JButton nbt,rbt;
    ButtonGroup bg;

    labswing(){
        j.setTitle("MCQ");
        j.setLayout(null);
        j.setSize(700,500);

        JLabel agelabel = new JLabel("Enter the age");
        agelabel.setBounds(100,100,100,100);
        j.add(agelabel);
        JTextField agefield = new JTextField();
        agefield.setBounds(100, 100, 100, 100);
        j.add(agefield);
        JButton agecheck = new JButton("Check");
        agecheck.setBounds(100,100,100,100);
        j.add(agecheck);
        agecheck.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                String agestring = agefield.getText();
                int age = Integer.parseInt(agestring);
                if(age>=18){
                    JOptionPane.showMessageDialog(null, "You are eligible to take the test.");
                        agefield.setVisible(false);
                        agelabel.setVisible(false);
                        agecheck.setVisible(false);
                }
                else{
                    JOptionPane.showMessageDialog(null, "You are not eligible to take the test.");
                }
            }
        });

    }

    void showSubject(){
        JLabel label1 = new JLabel("choose the subject");
        label1.setBounds(100,100,100,100);
        j.add(label1);
        bg = new ButtonGroup();
        op1 = new JRadioButton();
        op1.setBounds(50,50,50,50);
        op1.setText("math");
        j.add(op1);
        op2 = new JRadioButton();
        op2.setBounds(50,50,50,50);
        op2.setText("oopl");
        j.add(op2);
        op1 = new JRadioButton();
        op1.setBounds(50,50,50,50);
        op1.setText("chemistry");
        j.add(op1);

    }
    
   
}
