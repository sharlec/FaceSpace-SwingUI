/**
 * Created by Administrator on 2017/3/29.
 */

import javax.swing.*;
import java.awt.*;

interface Callback2{
    void setName(String newName);
}
public class AccountCreation extends JPanel implements Callback2{
    private CreateBox createBox;
    private String createName;
    private createMessage message;

    public AccountCreation(JFrame root){
        // Always call the super constructor for Swing components
        super();

        this.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;

        // Add a label for plain text
        this.add(new JLabel("Create your new account here:"));

        this.createBox = new CreateBox(this); // Takes reference to 'this' for callback
        c.gridy = 1;
        c.fill = GridBagConstraints.VERTICAL;
        this.add(this.createBox, c);

        this.message = new createMessage(root);
        c.gridy = 2;
        this.add(this.message, c);
    }
    public void setName(String newName){
        this.createName = newName;
        this.message.updateMsg(this.createName);
    }
}

