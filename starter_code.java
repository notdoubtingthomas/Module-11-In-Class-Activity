import javax.swing.*;
import java.awt.event.*;

public class starter_code extends JFrame implements ActionListener {

    private JLabel titleLabel, nameLabel, serviceLabel, planLabel, outputLabel;
    private JTextField nameField;
    private JRadioButton tutoringBtn, advisingBtn, labBtn;
    private ButtonGroup serviceGroup;
    private JComboBox<String> planBox;
    private JCheckBox materialsBox, followupBox;
    private JButton submitButton, resetButton;
    private JTextArea outputArea;

    public starter_code() {
        setTitle("Student Service Selector");
        setSize(500, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        titleLabel = new JLabel("Student Service Selector");
        titleLabel.setBounds(150, 20, 250, 25);
        add(titleLabel);

        nameLabel = new JLabel("Student Name:");
        nameLabel.setBounds(30, 70, 120, 25);
        add(nameLabel);

        nameField = new JTextField();
        nameField.setBounds(150, 70, 200, 25);
        add(nameField);

        serviceLabel = new JLabel("Choose Service:");
        serviceLabel.setBounds(30, 110, 120, 25);
        add(serviceLabel);

        tutoringBtn = new JRadioButton("Tutoring");
        tutoringBtn.setBounds(150, 110, 100, 25);
        add(tutoringBtn);

        advisingBtn = new JRadioButton("Advising");
        advisingBtn.setBounds(250, 110, 100, 25);
        add(advisingBtn);

        labBtn = new JRadioButton("Lab Support");
        labBtn.setBounds(350, 110, 110, 25);
        add(labBtn);

        serviceGroup = new ButtonGroup();
        serviceGroup.add(tutoringBtn);
        serviceGroup.add(advisingBtn);
        serviceGroup.add(labBtn);

        planLabel = new JLabel("Select Plan:");
        planLabel.setBounds(30, 150, 120, 25);
        add(planLabel);

        String[] plans = {"Basic", "Standard", "Premium"};
        planBox = new JComboBox<>(plans);
        planBox.setBounds(150, 150, 150, 25);
        add(planBox);

        materialsBox = new JCheckBox("Include Materials (+$20)");
        materialsBox.setBounds(150, 190, 200, 25);
        add(materialsBox);

        followupBox = new JCheckBox("Include Follow-Up (+$15)");
        followupBox.setBounds(150, 220, 200, 25);
        add(followupBox);

        submitButton = new JButton("Submit");
        submitButton.setBounds(120, 270, 100, 30);
        submitButton.addActionListener(this);
        add(submitButton);

        resetButton = new JButton("Reset");
        resetButton.setBounds(250, 270, 100, 30);
        resetButton.addActionListener(this);
        add(resetButton);

        outputLabel = new JLabel("Output:");
        outputLabel.setBounds(30, 320, 100, 25);
        add(outputLabel);

        outputArea = new JTextArea();
        outputArea.setBounds(150, 320, 280, 70);
        outputArea.setEditable(false);
        add(outputArea);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submitButton) {

            // TODO 1: Read student name from the text field
            String name = nameField.getText().trim();
            // TODO 2: Validate that the student name is not blank
            // If blank, display an error message in the output area and stop
            if (name.isEmpty()) {
                outputArea.setText("Error: Please enter a student name. ");
                return;
            }
            // TODO 3: Determine which service radio button is selected
            String service = " ";
            if (tutoringBtn.isSelected()) {
                service = "Tutoring";
            } else if (advisingBtn.isSelected()) {
                service = "Advising";
            } else if (labBtn.isSelected()) {
                service = "Lab Support";
            } else {
                outputArea.setText("Error: Please select a service.");
                return;
            }
            // TODO 4: Validate that a service is selected
            // If none is selected, display an error message and stop
            String plan = (String) planBox.getSelectedItem();
            int total = 0;
            // TODO 5: Read the selected plan from the combo box
            // TODO 6: Assign a base price based on the plan
            // Basic = 50, Standard = 75, Premium = 100
            if ("Basic".equals(plan)) {
                total = 50;
            } else if ("Standard".equals(plan)) {
                total = 75;
            } else if ("Premium".equals(plan)) {
                total = 100;
            }
            // TODO 7: Add 20 if materialsBox is selected
            String extras = "None";
            StringBuilder extrasBuilder = new StringBuilder();

            if (materialsBox.isSelected()) {
                total += 20;
                extrasBuilder.append("Materials");
            }

            // TODO 8: Add 15 if followupBox is selected

            if (followupBox.isSelected()) {
                total += 15;
                if (extrasBuilder.length() > 0) {
                    extrasBuilder.append(" , ");
                }
                extrasBuilder.append("Follow - Up");
            }
            if (extrasBuilder.length() > 0) {
                extras = extrasBuilder.toString();
            }
            // TODO 9: Build a string that includes:
            // - Student name
            // - Selected service
            // - Selected plan
            // - Selected extras
            // - Total cost

            String result = "Student Name: " + name + "\nService: " + service + "\nPlan: " + plan + "\nExtras: " + extras + "\nTotal Costs: " + total;


            // TODO 10: Display the final result in the output area
            outputArea.setText(result);

        } else if (e.getSource() == resetButton) {

            // TODO 11: Clear the name text field
            // TODO 12: Clear all selected radio buttons
            // TODO 13: Reset the combo box to the first option
            // TODO 14: Uncheck both checkboxes
            // TODO 15: Clear the output area
            nameField.setText("");
            serviceGroup.clearSelection();
            planBox.setSelectedIndex(0);
            materialsBox.setSelected(false);
            followupBox.setSelected(false);
            outputArea.setText(" ");

        }
    }

    public static void main(String[] args) {
        new starter_code();

    }
}
