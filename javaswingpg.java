import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionListener;
import java.lang.*;
import java.util.*;

public class javaswingpg extends JFrame implements ActionListener {

    JLabel label;
    JRadioButton option1, option2, option3, option4;
    JButton next, result;
    ButtonGroup bg;
    int count = 0, current = 0, x = 1, y = 1;
    int[] answer = new int[10];
    String questions[][] = new String[5][5];
    String options[][] = new String[5][5];
    int[] correctAnswers = { 2, 3, 1 };
    int score = 0;

    javaswingpg(String subject, int age) {
        this.setTitle("MCQ Test");
        this.setLayout(null);
        this.setSize(700, 500);
        this.setVisible(true);

        JLabel agelabel = new JLabel("Enter your age: ");
        agelabel.setBounds(200, 50, 100, 30);
        this.add(agelabel);

        JTextField agefield = new JTextField();
        agefield.setBounds(310, 50, 100, 30);
        this.add(agefield);

        JButton agebutton = new JButton("Check Age");
        agebutton.setBounds(400, 100, 150, 39);
        agebutton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == agebutton) {
                    String s1 = agefield.getText();
                    int age = Integer.parseInt(s1);

                    if (age >= 18) {
                        JOptionPane.showMessageDialog(null, "you are eligible");
                        agefield.setVisible(false);
                        agelabel.setVisible(false);
                        agebutton.setVisible(false);
                        showquestion();
                    }
                }
            }
        });

        this.add(agebutton);

        questions[0][0] = "What is the capital of India?";
        options[0][0] = "New Delhi";
        options[0][1] = "Mumbai";
        options[0][2] = "Kolkata";
        options[0][3] = "Chennai";

        questions[1][0] = "What is the largest country in the world by area?";
        options[1][0] = "USA";
        options[1][1] = "China";
        options[1][2] = "Russia";
        options[1][3] = "India";

        questions[2][0] = "Which planet in our solar system is known as the 'Red Planet'?";
        options[2][0] = "Venus";
        options[2][1] = "Mars";
        options[2][2] = "Jupiter";
        options[2][3] = "Saturn";

        this.setVisible(true);
    }

    void showquestion() {
        label = new JLabel();
        label.setBounds(50, 50, 500, 30);
        this.add(label);

        bg = new ButtonGroup();

        option1 = new JRadioButton();
        option1.setBounds(50, 100, 200, 30);
        this.add(option1);

        option2 = new JRadioButton();
        option2.setBounds(50, 150, 200, 30);
        this.add(option2);

        option3 = new JRadioButton();
        option3.setBounds(50, 200, 200, 30);
        this.add(option3);

        option4 = new JRadioButton();
        option4.setBounds(50, 250, 200, 30);
        this.add(option4);

        bg.add(option1);
        bg.add(option2);
        bg.add(option3);
        bg.add(option4);

        next = new JButton("Next");
        next.setBounds(400, 400, 100, 30);
        next.addActionListener(this);
        this.add(next);

        result = new JButton("Result");
        result.setBounds(550, 400, 100, 30);
        result.addActionListener(this);
        this.add(result);

        setQuestion();
    }

    void setQuestion() {
        bg.clearSelection();
        label.setText("Question " + (current + 1) + ": " + questions[count][0]);
        option1.setText(options[count][0]);
        option2.setText(options[count][1]);
        option3.setText(options[count][2]);
        option4.setText(options[count][3]);
    }

    boolean checkAnswer() {
        if (bg.getSelection() == null) {
            return false;
        }
        int selectedOption = 0;
        if (option1.isSelected()) {
            selectedOption = 1;
        } else if (option2.isSelected()) {
            selectedOption = 2;
        } else if (option3.isSelected()) {
            selectedOption = 3;
        } else if (option4.isSelected()) {
            selectedOption = 4;
        }
        return (selectedOption == correctAnswers[count]);
    }

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == next) {
            if (checkAnswer()) {
                score++;
            }
            current++;
            count++;
            setQuestion();
        }
        if (current == 3) {

            next.setEnabled(false);
            result.setEnabled(true);

        }

    }

    public static void main(String[] args) {
        javaswingpg mcqTest = new javaswingpg("General Knowledge", 0);
        mcqTest.setVisible(true);
    }

}
