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
    private String[][] questions = {
            {"What is the capital of France?", "Madrid", "Paris", "Berlin", "2"},
            {"What is the highest mountain in the world?", "K2", "Mount Everest", "Makalu", "2"},
            {"What is the largest country in the world by land area?", "Russia", "Canada", "China", "1"}
    };
    private int questionIndex = 0;
    private int score = 0;

    public QuizApp() {
        setTitle("Quiz App");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
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

        String[] subjects = {"Geography", "Science", "History"};
        subjectComboBox = new JComboBox<>(subjects);
        subjectComboBox.setBounds(150, 100, 100, 30);
        subjectComboBox.addActionListener(this);
        subjectComboBox.setVisible(false);
        panel.add(subjectComboBox);

        questionLabel = new JLabel("");
        questionLabel.setBounds(50, 150, 400, 30);
        questionLabel.setVisible(false);
        panel.add(questionLabel);

        answerButtons = new JRadioButton[3];
        ButtonGroup answerGroup = new ButtonGroup();
        for (int i = 0; i < 3; i++) {
            answerButtons[i] = new JRadioButton();
            answerButtons[i].setBounds(50, 190+i*30, 400, 30);
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
            if (answerButtons[0].isSelected() || answerButtons[

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
            String selectedAnswer = "";
            for (int i = 0; i < 3; i++) {
                if (answerButtons[i].isSelected()) {
                    selectedAnswer = String.valueOf(i+1);
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
                JOptionPane.showMessageDialog(this, "Quiz complete! Your score is " + score + " out of " + questions.length + ".");
                System.exit(0);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Please select an answer.");
        }
    } else if (source == subjectComboBox) {
        String selectedSubject = subjectComboBox.getSelectedItem().toString();
        if (selectedSubject.equals("Geography")) {
            questions = new String[][]{
                    {"What is the capital of France?", "Madrid", "Paris", "Berlin", "2"},
                    {"What is the highest mountain in the world?", "K2", "Mount Everest", "Makalu", "2"},
                    {"What is the largest country in the world by land area?", "Russia", "Canada", "China", "1"}
            };
        } else if (selectedSubject.equals("Science")) {
            questions = new String[][]{
                    {"What is the powerhouse of the cell?", "Mitochondria", "Ribosome", "Nucleus", "1"},
                    {"What is the smallest unit of matter?", "Atom", "Molecule", "Cell", "1"},
                    {"What is the largest organ in the human body?", "Liver", "Skin", "Heart", "2"}
            };
        } else if (selectedSubject.equals("History")) {
            questions = new String[][]{
                    {"Which ancient civilization built the Machu Picchu?", "Maya", "Aztec", "Inca", "3"},
                    {"Who was the first US President?", "George Washington", "Thomas Jefferson", "Abraham Lincoln", "1"},
                    {"Which country did Germany invade to start World War II?", "Poland", "Russia", "France", "1"}
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
        answerButtons[i].setText(questions[questionIndex][i+1]);
        answerButtons[i].setSelected(false);
        answerButtons[i].setVisible(true);
    }
    submitAnswerButton.setVisible(true);
}
