import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Date;
import com.google.gson.*;

// StatusFeed is implemented as an extension of JTextArea.
// Instead of using a separate Status class, individual statuses
// are represented using Strings.
public class createMessage extends JLabel {

    // The JSON API we are using (GSON) requires model classes for any
    // object type we expect to receive. This way, GSON can return an
    // easily usable Java class instance after a successful REST API call.
    //
    // IMPORTANT: Instance variable names much match EXACTLY with the JSON
    // object names/keys.
    //
    // We can use a private class here because this type will not be used elsewhere.
    private class StatusJSON{
        String creation;

        public String toString(){
            return creation;
        }
    }


    static final String defaultText = "\n";


    JFrame root;

    // Basic initialization
    public createMessage(JFrame root){
        super();
        this.setLayout(new GridLayout(0,1));
        this.root = root;
        this.setText(defaultText);
    }


    public void updateMsg(String username){
        this.setText(defaultText);
        this.setText(callAPI(username));
        this.root.pack();
        this.setVisible(false);
        this.setVisible(true);
    }


    public String callAPI(String name){
        try {
            // Initialize GSON
            Gson gson = new GsonBuilder().create();
            // Initialize result String

            // Call the API
            URL myURL = new URL("http://localhost:8080/AccountCreation/createAccount?userName=" + name);
            URLConnection api = myURL.openConnection();
            // Call the API (ASYNCHRONOUS)
            HttpURLConnection http = (HttpURLConnection)api;
            http.setRequestMethod("POST"); // PUT is another valid option
            http.setDoOutput(true);
            api.connect();
            BufferedReader in = new BufferedReader(new InputStreamReader(api.getInputStream()));

            // Read from input steam
            StringBuilder b=new StringBuilder();
            b.append(name);
            in.close();
            return  name + " is created successfully!";
        }
        catch (MalformedURLException e) {
            // new URL() failed
            System.out.println("Bad URL...");
        }
        catch (IOException e) {
            // Catches refusals such as 'not found' or 'unauthorized'
            // When the username is already taken, this error will be catched
            return(name + " is already taken" );
        }
        // Default return value
        return "";
    }
}