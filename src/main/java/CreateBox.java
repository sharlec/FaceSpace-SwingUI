/**
 * Created by Administrator on 2017/3/29.
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class CreateBox extends JPanel{
    private JTextField textEntry;
    private JButton submitButton;

    public CreateBox (Callback2 callback){
        super();
        this.setLayout(new FlowLayout());
        this.textEntry = new JTextField(15);
        this.submitButton = new JButton("Create Account");

        // Defines button click action to call the callback method
        this.submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String text = textEntry.getText();
                callback.setName(text);
            }
        });
        // Defines key enter action to call the callback method
        this.textEntry.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String text = textEntry.getText();
                callback.setName(text);
            }
        });
        // Add subcomponents to this JPanel
        this.add(this.textEntry);
        this.add(this.submitButton);

    }
}
