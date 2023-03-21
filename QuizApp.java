import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class QuizApp extends JFrame implements ActionListener {

    private JLabel ageLabel, subjectLabel, questionLabel;
    private JTextField ageField;
    private JComboBox<String> subjectComboBox;
    private JRadioButton[] answerButtons;
    private JButton submitButton, submitAnswerButton;
    private String[][] questions;
    public int questionIndex = 0;
    private int score = 0;

    public QuizApp() {
        setTitle("Quiz App");
        setSize(500, 400);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(null);

        ageLabel = new JLabel("Enter your age:");
        ageLabel.setBounds(50, 50, 100, 30);
        panel.add(ageLabel);

        ageField = new JTextField();
        ageField.setBounds(150, 50, 100, 30);
        panel.add(ageField);

        submitButton = new JButton("Submit");
        submitButton.setBounds(270, 50, 80, 30);
        submitButton.addActionListener(this);
        panel.add(submitButton);

        subjectLabel = new JLabel("Select a subject:");
        subjectLabel.setBounds(50, 100, 100, 30);
        subjectLabel.setVisible(false);
        panel.add(subjectLabel);

        String[] subjects = { "JAVA", "Science", "Maths" };
        subjectComboBox = new JComboBox<>(subjects);
        subjectComboBox.setBounds(150, 100, 100, 30);
        subjectComboBox.addActionListener(this);
        subjectComboBox.setVisible(false);
        panel.add(subjectComboBox);

        questionLabel = new JLabel("");
        questionLabel.setBounds(50, 150, 400, 30);
        questionLabel.setVisible(true);
        panel.add(questionLabel);

        answerButtons = new JRadioButton[3];
        ButtonGroup answerGroup = new ButtonGroup();
        answerGroup.clearSelection();
        for (int i = 0; i < 3; i++) {
            answerGroup.clearSelection();
            answerButtons[i] = new JRadioButton();
            answerButtons[i].setBounds(50, 190 + i * 30, 400, 30);
            answerButtons[i].setVisible(false);
            answerGroup.add(answerButtons[i]);
            panel.add(answerButtons[i]);
        }

        submitAnswerButton = new JButton("Submit Answer");
        submitAnswerButton.setBounds(180, 280, 140, 30);
        submitAnswerButton.addActionListener(this);
        submitAnswerButton.setVisible(false);
        panel.add(submitAnswerButton);

        add(panel);
        setVisible(true);
    }

    public static void main(String[] args) {
        QuizApp app = new QuizApp();
    }

    public void actionPerformed(ActionEvent event) {
        Object source = event.getSource();

        if (source == submitButton) {

            int age = Integer.parseInt(ageField.getText());
            if (age >= 18) {
                JOptionPane.showMessageDialog(null, "you are eligible");
                ageLabel.setVisible(false);
                ageField.setVisible(false);
                submitButton.setVisible(false);
                subjectLabel.setVisible(true);
                subjectComboBox.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(null, "you are not eligible");
            }

        } else if (source == submitAnswerButton) {
            if (answerButtons[0].isSelected() || answerButtons[1].isSelected()
                    || answerButtons[2].isSelected()) {
                String selectedAnswer = "";
                for (int i = 0; i < 3; i++) {
                    if (answerButtons[i].isSelected()) {
                        selectedAnswer = String.valueOf(i + 1);
                        break;
                    }
                }
                if (selectedAnswer.equals(questions[questionIndex][4])) {
                    score++;
                }
                questionIndex++;
                if (questionIndex < questions.length) {

                    showQuestion();
                } else {
                    JOptionPane.showMessageDialog(this,
                            "Quiz complete! Your score is " + score + " out of " + questions.length + ".");
                    System.exit(0);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Please select an answer.");
            }
        } else if (source == subjectComboBox) {
            String selectedSubject = subjectComboBox.getSelectedItem().toString();
            if (selectedSubject.equals("JAVA")) {
                questions = new String[][] {
                        { "Number of primitive data types in Java are?", "6", "7", "8", "3" },
                        { "What is the size of float and double in java?", "32 and 64", "32 and 32", "64 and 64", "1" },
                        { "Arrays in java are-", "Object Reference", "Objects", "Primitive data type", "2" }
                };
            } else if (selectedSubject.equals("Biology")) {
                questions = new String[][] {
                        { "What is the powerhouse of the cell?", "Mitochondria", "Ribosome", "Nucleus", "1" },
                        { "What is the smallest unit of matter?", "Atom", "Molecule", "Cell", "1" },
                        { "What is the largest organ in the human body?", "Liver", "Skin", "Heart", "2" }
                };
            } else if (selectedSubject.equals("Maths")) {
                questions = new String[][] {
                        { "what is the sum of 5+5?", "10", "13", "5", "1" },
                        { "what is formula for distance?", "speed * time", "speed*acceleration", "velocity* time",
                                "1" },
                        { "what is the value of 2^4?", "16", "32", "8", "1" }
                };
            }
            subjectLabel.setVisible(false);
            subjectComboBox.setVisible(false);
            showQuestion();
        }
    }

    private void showQuestion() {
        questionLabel.setText(questions[questionIndex][0]);
        for (int i = 0; i < 3; i++) {

            answerButtons[i].setText(questions[questionIndex][i + 1]);
            answerButtons[i].setSelected(false);
            answerButtons[i].setVisible(true);
        }
        submitAnswerButton.setVisible(true);
    }
}
