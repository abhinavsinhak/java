import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionListener;

public class MCQTest extends JFrame implements ActionListener {
    JLabel label, label1;
    JRadioButton option1, option2, option3, option4, op1, op2, op3;
    JButton nextBtn, resultBtn;
    JButton next;
    ButtonGroup bg, bg1;
    int count = 0, current = 0, x = 1, y = 1;
    int score = 0;
    int[] answers = new int[10];
    int[] choice = new int[10];
    String[][] gkquestions = new String[5][5];
    String[][] mquestions = new String[5][5];
    String[][] ooquestions = new String[5][5];
    String[][] options = new String[4][5];
    String[][] moptions = new String[4][5];
    String[][] ooptions = new String[4][5];
    int[] correctAnswers = { 2, 3, 1, 3, 2 };
    int[] correctAnswers1 = {};
    int[] correctAnswers2 = {};

    MCQTest(String subject, int age) {
        this.setTitle("MCQ Test - " + subject);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setSize(700, 500);
        this.setLocationRelativeTo(null);

        JLabel ageLabel = new JLabel("Enter your age:");
        ageLabel.setBounds(200, 50, 100, 30);
        this.add(ageLabel);

        JTextField ageField = new JTextField();
        ageField.setBounds(310, 50, 100, 30);
        this.add(ageField);

        JButton ageButton = new JButton("Check Age");
        ageButton.setBounds(200, 100, 150, 30);
        ageButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String ageString = ageField.getText();
                if (ageString.matches("[0-9]+")) {
                    int age = Integer.parseInt(ageString);
                    if (age >= 18) {
                        JOptionPane.showMessageDialog(null, "You are eligible to take the test.");
                        ageField.setVisible(false);
                        ageLabel.setVisible(false);
                        ageButton.setVisible(false);
                        showSubject();

                    } else {
                        JOptionPane.showMessageDialog(null, "You are not eligible to take the test.");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Please enter a valid age.");
                }
            }

        });
        this.add(ageButton);

        // Initialize questions and options arrays
        gkquestions[0][0] = "What is the capital of India?";
        options[0][0] = "New Delhi";
        options[0][1] = "Mumbai";
        options[0][2] = "Kolkata";
        options[0][3] = "Chennai";

        gkquestions[1][0] = "What is the largest country in the world by area?";
        options[1][0] = "USA";
        options[1][1] = "China";
        options[1][2] = "Russia";
        options[1][3] = "India";

        gkquestions[2][0] = "Which planet in our solar system is known as the 'Red Planet'?";
        options[2][0] = "Venus";
        options[2][1] = "Mars";
        options[2][2] = "Jupiter";
        options[2][3] = "Saturn";

        mquestions[0][0] = "What is the result of 2+5+10";
        moptions[0][0] = "10";
        moptions[0][1] = "5";
        moptions[0][2] = "17";
        moptions[0][3] = "18";

        mquestions[1][0] = "What is the formula for area of square of side length 10cm?";
        moptions[1][0] = "100";
        moptions[1][1] = "20";
        moptions[1][2] = "40";
        moptions[1][3] = "50";

        mquestions[2][0] = "what is perimeter of square of side 10 cm?";
        moptions[2][0] = "40";
        moptions[2][1] = "50";
        moptions[2][2] = "60";
        moptions[2][3] = "70";

        ooquestions[0][0] = " When is the object created with a new keyword?";
        ooptions[0][0] = "AT run time";
        ooptions[0][1] = "At compile time";
        ooptions[0][2] = "depends on the code";
        ooptions[0][3] = "none";

        ooquestions[1][0] = "choose the option below which is not a member of the class";
        ooptions[1][0] = "friend function";
        ooptions[1][1] = "static function";
        ooptions[1][2] = "virtual function";
        ooptions[1][3] = "const function";

        ooquestions[2][0] = "Total type of constructor in c++ are";
        ooptions[2][0] = "1";
        ooptions[2][1] = "2";
        ooptions[2][2] = "3";
        ooptions[2][3] = "4";

    }

    void showSubject() {
        label1 = new JLabel();
        label1.setBounds(50, 50, 500, 30);
        this.add(label1);
        bg1 = new ButtonGroup();

        JRadioButton op1 = new JRadioButton();
        op1.setBounds(50, 100, 200, 30);
        this.add(op1);

        JRadioButton op2 = new JRadioButton();
        op2.setBounds(50, 150, 200, 30);
        this.add(op2);

        JRadioButton op3 = new JRadioButton();
        op3.setBounds(50, 200, 200, 30);
        this.add(op3);
        bg1.add(op1);
        bg1.add(op2);
        bg1.add(op3);

        bg1.clearSelection();
        label1.setText("choose the subject to take test");
        op1.setText("math");
        op2.setText("oops");
        op3.setText("gk");

        next = new JButton("Next");
        next.setBounds(400, 400, 100, 30);
        next.addActionListener(this);
        this.add(next);

    }

    void showQuestions(String[][] questions, String[][] options, String[] correctAnswers) {
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

        nextBtn = new JButton("Next");
        nextBtn.setBounds(400, 400, 100, 30);
        nextBtn.addActionListener(this);
        this.add(nextBtn);

        resultBtn = new JButton("Result");
        resultBtn.setBounds(550, 400, 100, 30);
        resultBtn.addActionListener(this);
        this.add(resultBtn);

        setQuestion(gkquestions, gkquestions, null);
    }

    void setQuestion(String[][] questions, String[][] options, String[] correctAnswers) {
        bg.clearSelection();
        label.setText("Question " + (current + 1) + ": " + gkquestions[count][0]);
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

        choice[current] = selectedOption;
        return (selectedOption == correctAnswers[count]);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == next) {
            if (op1.isSelected()) {
               
            }
        }
        if (e.getSource() == nextBtn) {
            if (checkAnswer()) {
                answers[current] = 1;
                score++;
            }

            current++;
            count++;

            if (current == 5) {
                nextBtn.setEnabled(false);
                resultBtn.setEnabled(true);
            }

            setQuestion();
        }

        if (e.getSource() == resultBtn) {
            if (checkAnswer()) {
                answers[current] = 1;
            }

            int correct = 0;
            for (int i = 0; i < answers.length; i++) {
                if (answers[i] == 1) {
                    correct++;
                }
            }

            JOptionPane.showMessageDialog(this, "Total Questions: 10\nCorrect Answers: " + correct);

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < choice.length; i++) {
                sb.append("Question ").append(i + 1).append(": ");
                sb.append("Selected Option ").append(choice[i]).append("  ");
                sb.append("Correct Option ").append(correctAnswers[i]).append("\n");
            }
            JOptionPane.showMessageDialog(this, sb.toString());
        }
    }

    public static void main(String[] args) {
        MCQTest mcqTest = new MCQTest("General Knowledge", 0);
        mcqTest.setVisible(true);
    }
}
