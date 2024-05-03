import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


//GadgetShop class initialises and manages a GUI application for managing gadgets like mobiles and MP3 players.
public class GadgetShop {
    private ArrayList<Gadget> gadgets;  // Stores a list of gadgets
    private JTextField modelField, priceField, weightField, sizeField, creditField, memoryField,
            phoneNumberField, durationField, downloadSizeField, displayNumberField;
    private JFrame frame;  // Main window of the aplication

    
   //Constructor sets up the GUI layout and initializes interactions.
    public GadgetShop() {
        gadgets = new ArrayList<>();

        // Setup main application window
        frame = new JFrame("Gadget Shop");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(0, 2, 5, 5));  // Grid layout for structured arrangement
        frame.getContentPane().setBackground(Color.GREEN);  // Set the background colour to green 

        // Initialise input fields for data entry
        modelField = new JTextField();
        priceField = new JTextField();
        weightField = new JTextField();
        sizeField = new JTextField();
        creditField = new JTextField();
        memoryField = new JTextField();
        phoneNumberField = new JTextField();
        durationField = new JTextField();
        downloadSizeField = new JTextField();
        displayNumberField = new JTextField();

        // Setup labels and corresponding text fields in the frame
        setupLabelsAndFields();

        // Setup control buttons and their functionalities
        setupButtons();

        // Finalise setup and display the frame
        frame.pack();
        frame.setVisible(true);
    }

    
    //Methods to add labels and text fields to the frame. 
    private void setupLabelsAndFields() {
        frame.add(new JLabel("Model:"));
        frame.add(modelField);
        frame.add(new JLabel("Price:"));
        frame.add(priceField);
        frame.add(new JLabel("Weight:"));
        frame.add(weightField);
        frame.add(new JLabel("Size:"));
        frame.add(sizeField);
        frame.add(new JLabel("Initial Credit:"));
        frame.add(creditField);
        frame.add(new JLabel("Initial Memory:"));
        frame.add(memoryField);
        frame.add(new JLabel("Phone Number:"));
        frame.add(phoneNumberField);
        frame.add(new JLabel("Duration:"));
        frame.add(durationField);
        frame.add(new JLabel("Download Size:"));
        frame.add(downloadSizeField);
        frame.add(new JLabel("Display Number:"));
        frame.add(displayNumberField);

    }
    
    
     // Method to setup buttons and their action listeners.
     
    private void setupButtons() {
        JButton addMobileButton = new JButton("Add Mobile");
        JButton addMP3Button = new JButton("Add MP3");
        JButton clearButton = new JButton("Clear");
        JButton displayAllButton = new JButton("Display All");
        JButton makeACallButton = new JButton("Make A Call");
        JButton downloadMusicButton = new JButton("Download Music");
        
        frame.add(addMobileButton);
        frame.add(addMP3Button);
        frame.add(clearButton);
        frame.add(displayAllButton);
        frame.add(makeACallButton);
        frame.add(downloadMusicButton);
        
        
        addMobileButton.addActionListener(e -> addMobile());
        addMP3Button.addActionListener(e -> addMP3());
        clearButton.addActionListener(e -> clearFields());
        displayAllButton.addActionListener(e -> displayAll());
        makeACallButton.addActionListener(e -> makeACall());
        downloadMusicButton.addActionListener(e -> downloadMusic());
    
    
    }

    // Utility methods to fetch data from text field
    private String getModel(){
        return modelField.getText();
    }
    
    private String getSize() {
        return sizeField.getText();
    }

    private String getPhoneNumber() {
        return phoneNumberField.getText();
    }
    
    
    private double getPrice() {
    try {
        return Double.parseDouble(priceField.getText());
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(frame, "Invalid input for price. Please enter a valid number.", "Input Error", JOptionPane.ERROR_MESSAGE);
        return -1; // Return an invalid price
    }
    }
    
    private int getWeight() {
    try {
        return Integer.parseInt(weightField.getText());
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(frame, "Invalid input for weight. Please enter a valid integer.", "Input Error", JOptionPane.ERROR_MESSAGE);
        return -1; // Return an invalid weight
    }
    }

    private int getInitialCredit() {
    try {
        return Integer.parseInt(creditField.getText());
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(frame, "Invalid input for initial credit. Please enter a valid integer.", "Input Error", JOptionPane.ERROR_MESSAGE);
        return -1; // Return an invalid credit value
    }
    }
   
   private int getInitialMemory() {
    try {
        return Integer.parseInt(memoryField.getText());
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(frame, "Invalid input for initial memory. Please enter a valid integer.", "Input Error", JOptionPane.ERROR_MESSAGE);
        return -1; // Return an invalid memory value
    }
   }
   
   private int getDuration() {
    try {
        return Integer.parseInt(durationField.getText());
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(frame, "Invalid input for duration. Please enter a valid integer.", "Input Error", JOptionPane.ERROR_MESSAGE);
        return -1; // Return an invalid duration
    }
   }
   
   
   private int getDownloadSize() {
    try {
        return Integer.parseInt(downloadSizeField.getText());
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(frame, "Invalid input for download size. Please enter a valid integer.", "Input Error", JOptionPane.ERROR_MESSAGE);
        return -1; // Return an invalid download size
    }
   }
   

   private void downloadMusic() {
    try {
        int displayNumber = getDisplayNumber();
        if (displayNumber != -1) {
            if (gadgets.get(displayNumber) instanceof MP3) {
                MP3 mp3 = (MP3) gadgets.get(displayNumber);
                int downloadSize = getDownloadSize();
                mp3.downloadMusic(downloadSize);
                JOptionPane.showMessageDialog(frame,"Downloaded music   succesfully." ,"Success",JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(frame, "Selected gadget is not an MP3 player.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    } catch (NumberFormatException | ClassCastException | IndexOutOfBoundsException ex) {
        JOptionPane.showMessageDialog(frame, "Please check your input and try again: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
   }
    
    private void makeACall() {
    try {
        int displayNumber = getDisplayNumber();  // This might throw or return -1 on error
        if (displayNumber != -1) {  // Check if the display number is valid
            Gadget gadget = gadgets.get(displayNumber);  // Get the gadget
            if (gadget instanceof Mobile) {  // Check if the gadget is indeed a Mobile
                Mobile mobile = (Mobile) gadget;  // Safe to cast here
                String phoneNumber = getPhoneNumber();  // Get the phone number
                int duration = getDuration();  // Attempt to get the duration, can handle number format exception within getDuration if necessary
                mobile.makePhoneCall(phoneNumber, duration);  // Make the call
                JOptionPane.showMessageDialog(frame,"Call made  succesfully." ,"Success",JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(frame, "The selected gadget is not a mobile phone.", "Operation Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    } catch (ClassCastException e) {
        JOptionPane.showMessageDialog(frame, "Error casting gadget to Mobile. " + e.getMessage(), "Cast Error", JOptionPane.ERROR_MESSAGE);
    } catch (IndexOutOfBoundsException e) {
        JOptionPane.showMessageDialog(frame, "Invalid index for gadgets list. " + e.getMessage(), "Index Error", JOptionPane.ERROR_MESSAGE);
    } catch (NumberFormatException e) {
        // This catch might be unnecessary if getDuration() already handles NumberFormatException
        JOptionPane.showMessageDialog(frame, "Invalid input for duration. Please enter a valid integer.", "Input Error", JOptionPane.ERROR_MESSAGE);
    } catch (Exception e) {
        // A general exception handler for unexpected exceptions.
        JOptionPane.showMessageDialog(frame, "An unexpected error occurred: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
    }
   
        private int getDisplayNumber() {
            try{
                int displayNumber = Integer.parseInt(displayNumberField.getText());
            if (displayNumber < 0 || displayNumber >= gadgets.size()) {
            
                JOptionPane.showMessageDialog(frame, "Invalid display number.");
                return -1;
            }  
            return displayNumber;
         }catch (NumberFormatException ex){
           JOptionPane.showMessageDialog(frame,"Mobile is added succesfully." , "Success",JOptionPane.INFORMATION_MESSAGE);
           return -1;
         }
        
        
        
    }
    

    // Methods to handle button actions
    private void addMobile() {
        String model = getModel();
        double price = getPrice();
        int weight = getWeight();
        String size = getSize();
        int credit = getInitialCredit();

        Mobile mobile = new Mobile(model, price, weight, size, credit);
        gadgets.add(mobile);
        JOptionPane.showMessageDialog(frame,"Mobile is added succesfully." ,"Success",JOptionPane.INFORMATION_MESSAGE);
    }

    private void addMP3() {
        String model = getModel();
        double price = getPrice();
        int weight = getWeight();
        String size = getSize();
        int memory = getInitialMemory();

        MP3 mp3 = new MP3(model, price, weight, size, memory);
        gadgets.add(mp3);
        JOptionPane.showMessageDialog(frame,"MP3 is added succesfully." ,"Success",JOptionPane.INFORMATION_MESSAGE);
    }
    
    private void clearFields() {
        modelField.setText("");
        priceField.setText("");
        weightField.setText("");
        sizeField.setText("");
        creditField.setText("");
        memoryField.setText("");
        phoneNumberField.setText("");
        durationField.setText("");
        downloadSizeField.setText("");
        displayNumberField.setText("");
        JOptionPane.showMessageDialog(frame,"Cleared all text fields succesfully." ,"Success",JOptionPane.INFORMATION_MESSAGE);
                                                
    }

    private void displayAll() {
        gadgets.forEach(Gadget::display);
        JOptionPane.showMessageDialog(frame,"All item displayed succesfully." ,"Success",JOptionPane.INFORMATION_MESSAGE);
    }

    
    public static void main(String[] args) {
        GadgetShop GadgetShop = new GadgetShop(); // Instantiate the GadgetShop to start the application
    }
}