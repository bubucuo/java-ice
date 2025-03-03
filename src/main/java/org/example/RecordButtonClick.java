import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RecordButtonClick {
    private int counter = 0;  // record how many times clicked

    public RecordButtonClick() {
        JFrame myFrame = new JFrame("Click the Button");
        myFrame.setSize(500, 500);
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myFrame.setLayout(null);

        // Create a Button
        JButton myButton = new JButton("Click me!");
        myButton.setBounds(150, 220, 200, 60);
        myFrame.add(myButton);

        myButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                counter++;
                myButton.setText("You have clicked " + counter + " times");
            }
        });

        myFrame.setVisible(true);
    }

    public static void main(String[] args) {
        new RecordButtonClick();
    }
}


