import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainFrame extends JFrame {

    private int[] frameSize = {900, 700};

    private Font plainFont = new Font("Arial", Font.PLAIN, 20); // Plain font used for the program
    private Font boldFont = new Font("Arial", Font.BOLD, 20); // Bold font used for the program

    private boolean enableDisplay = true;

    private boolean isValidInput(String userInput)
    {
        boolean valid = false;
        String regex = "^[0-9]"; // Format of user input
        Pattern pat = Pattern.compile(regex); // Compile regular expression to pattern
        Matcher mat = pat.matcher(userInput); // Check if pattern matches the user input
        if(mat.matches()) // If so, check if the number comes into the range between 3 and 20
        {
            if(Integer.parseInt(userInput) >= 3 && Integer.parseInt(userInput) <= 20)
            {
                valid = true; // If so, set valid to true
            }
        }
        return valid;
    }

    public MainFrame()
    {
        JTextArea screen = new JTextArea(); // Text area that shows fibonacci sequence
        JScrollPane scrollPane = new JScrollPane(screen); // Add scroll bar to screen
        screen.setFont(plainFont); // Set font of the screen
        screen.setMargin( new Insets(10,10,10,10) );
        screen.setEditable(false);
        // Set bounds for the text area with respect to frame size
        screen.setBounds(
                0,
                frameSize[1] / 12,
                frameSize[0] / 1,
                frameSize[1] * 9 / 12
        );
        add(screen);

        JLabel numLabel = new JLabel("Number of row in Fibonacci series: "); // Store label for inputting number instruction
        numLabel.setFont(boldFont); // Set font of the num label
        // Set bounds for number label with respect to screen size
        numLabel.setBounds(
                0,
                0,
                frameSize[0] * 2 / 5,
                frameSize[1] / 12
        );
        numLabel.setVerticalAlignment(JLabel.CENTER); // Set vertical alignment to center
        numLabel.setHorizontalAlignment(JLabel.RIGHT); // Set horizontal alignment to right
        add(numLabel);

        JTextField userInputField = new JTextField(); // Set text field where the user will input a number
        userInputField.setFont(plainFont); // Set font for user input
        // Set bounds for text field with respect to frame size
        userInputField.setBounds(
                frameSize[0] * 2 / 5,
                frameSize[1] / 48,
                frameSize[0] / 12,
                frameSize[1] / 24
        );
        add(userInputField);

        JButton cancelButton = new JButton("Cancel"); // Create button for getting sum of fibonacci sequences
        cancelButton.setFont(new Font("Arial", Font.BOLD, 17)); // Set font of sum button
        cancelButton.setEnabled(false);
        // Set bounds for sum button with respect to frame size
        cancelButton.setBounds(
                (frameSize[0] * 11 / 14) + 10,
                frameSize[1] / 65,
                frameSize[0] / 9,
                frameSize[1] / 18
        );
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                enableDisplay = false;
            }
        });
        add(cancelButton);

        JProgressBar progressBar = new JProgressBar(0, 100); // Create progress bar showing how much of the fibonacci sequence have been displayed
        progressBar.setStringPainted(true); // Show percentage as string
        progressBar.setFont(boldFont);
        // Set bounds for progress bar with respect to frame size
        progressBar.setBounds(
                2,
                (frameSize[1] * 10 / 12) + 2,
                frameSize[0] * 2 / 3,
                frameSize[1] / 12
        );
        add(progressBar);

        JLabel sumLabel = new JLabel("Sum = "); // Create label that shows sum of fibonacci numbers
        sumLabel.setFont(boldFont); // Set font of sum label
        sumLabel.setVerticalAlignment(JLabel.CENTER); // Set vertical alignment to center
        // Set bounds for sum label with respect to frame size
        sumLabel.setBounds(
                frameSize[0] * 25 / 36,
                frameSize[1] * 10 / 12 + 5,
                frameSize[0] * 2 / 7,
                frameSize[1] / 12
        );
        add(sumLabel);

        JButton sumButton = new JButton("Get Sum of Fibonacci series"); // Create button for getting sum of fibonacci sequences
        sumButton.setFont(new Font("Arial", Font.BOLD, 17)); // Set font of sum button
        // Set bounds for sum button with respect to frame size
        sumButton.setBounds(
                frameSize[0] / 2,
                frameSize[1] / 65,
                frameSize[0] * 2 / 7,
                frameSize[1] / 18
        );
        sumButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cancelButton.setEnabled(true); // Enable cancel button when sum button has been pressed
                String userInput = userInputField.getText(); // Get user input from userInputField
                if(isValidInput(userInput)) // If the user input is valid
                {

                }
                else
                {
                    userInputField.setText("");
                    JOptionPane.showMessageDialog(null, "Enter valid input!", "Warning", JOptionPane.INFORMATION_MESSAGE); // Show error messages
                }
            }
        });

        add(sumButton);

        // Settings for frame
        setTitle("Finding Fibonacci series num");
        setSize(frameSize[0], frameSize[1]);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        new MainFrame();
    }
}
