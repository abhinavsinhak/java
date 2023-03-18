import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class QuizProgram extends JFrame implements ActionListener {
    
    private JLabel ageLabel;
    private JTextField ageField;
    private JButton submitButton;
    private JLabel subjectLabel;
    private JComboBox<String> subjectComboBox;
    private JLabel questionLabel;
    private JRadioButton[] answerButtons;
    private JButton submitAnswerButton;
    private int questionIndex;
    private int score;
    private String[] subjects = {"Math", "Science", "History"};
    private String[][] questions = {
        {"What is 2 + 2?", "3", "4", "5", "4"},
        {"What is the chemical symbol for oxygen?", "O", "H", "N", "O"},
        {"Who was the first president of the United States?", "Thomas Jefferson", "George Washington", "John Adams", "George Washington"}
    };
    
    public QuizProgram() {
        setTitle("Quiz Program");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLayout(new GridLayout(0, 1));
        
        ageLabel = new JLabel("Enter your age:");
        add(ageLabel);
        ageField = new JTextField();
        add(ageField);
        submitButton = new JButton("Submit");
        submitButton.addActionListener(this);
        add(submitButton);
        
        subjectLabel = new JLabel("Choose a subject:");
        subjectLabel.setVisible(false);
        add(subjectLabel);
        subjectComboBox = new JComboBox<String>(subjects);
        subjectComboBox.setVisible(false);
        add(subjectComboBox);
        
        questionLabel = new JLabel();
        questionLabel.setVisible(false);
        add(questionLabel);
        answerButtons = new JRadioButton[3];
        ButtonGroup answerGroup = new ButtonGroup();
        for (int i = 0; i < 3; i++) {
            answerButtons[i] = new JRadioButton();
            answerGroup.add(answerButtons[i]);
            add(answerButtons[i]);
        }
        submitAnswerButton = new JButton("Submit Answer");
        submitAnswerButton.addActionListener(this);
        submitAnswerButton.setVisible(false);
        add(submitAnswerButton);
        
        questionIndex = 0;
        score = 0;
    }
    
    
    public void actionPerformed(ActionEvent event) {
        Object source = event.getSource();
        if (source == submitButton) {
            try {
                int age = Integer.parseInt(ageField.getText());
                if (age >= 18) {
                    ageLabel.setVisible(false);
                    ageField.setVisible(false);
                    submitButton.setVisible(false);
                    subjectLabel.setVisible(true);
                    subjectComboBox.setVisible(true);
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Please enter a valid age.");
            }
        } else if (source == submitAnswerButton) {
            if (answerButtons[0].isSelected() || answerButtons[1].isSelected() || answerButtons[2].isSelected()) {
                String answer = "";
                if (answerButtons[0].isSelected()) {
                    answer = "1";
                } else if (answerButtons[1].isSelected()) {
                    answer = "2";
                } else {
                    answer = "3";
                }
                if (answer.equals(questions[questionIndex][4])) {
                    score++;
                }
                questionIndex++;
                if (questionIndex < 3) {
                    updateQuestion();
                } else {
                    JOptionPane.showMessageDialog(this, "Quiz completed.\nYour score is: " + score);
                    System.exit(0);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Please select an answer.");
            }
        } else if (source == subjectComboBox) {
            int selectedIndex = subjectComboBox.getSelectedIndex();
            if (selectedIndex >= 0) {
                subjectLabel.setVisible(false);
                subjectComboBox.setVisible(false);
                questionLabel.setText(questions[0][0]);
                for (int i = 0; i < 3; i++) {
                    answerButtons[i].setText(questions[0][i+1]);
                }
                submitAnswerButton.setVisible(true);
                questionLabel.setVisible(true);
                for (int i = 0; i < 3; i++) {
                    answerButtons[i].setVisible(true);
                }
            }
        }
    }
    
    public void updateQuestion() {
        questionLabel.setText(questions[questionIndex][0]);
        for (int i = 0; i < 3; i++) {
            answerButtons[i].setText(questions[questionIndex][i+1]);
            answerButtons[i].setSelected(false);
        }
    }
    