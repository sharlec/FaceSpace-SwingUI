/**
 * Created by Administrator on 2017/3/29.
 */
import javax.swing.*;
import java.awt.*;

public class test extends JFrame{
    // Subcomponents
    private StatusSearch statusSearch;

    public test(){
        super("AccountCreation");

        // Create and add the main component
        this.statusSearch = new StatusSearch(this);
        this.add(statusSearch);
        this.getContentPane().add(this.statusSearch);

        // Set size parameters, 'pack' everything tightly together, and set visible.
        this.setMinimumSize(new Dimension(340, 400));
        this.pack();
        this.setVisible(true);
    }
}
