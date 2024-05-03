
 // The Mobile class extends Gadget, adding mobile-specific functionality such as managing calling credits.
public class Mobile extends Gadget {
    // Private field to store the minutes of calling credit available on the mobile phone.
    private int minutesOfCredit;

    
    //Constructor for the Mobile class. 
    public Mobile(String model, double price, int weight, String size, int minutesOfCredit) {
        super(model, price, weight, size);  // Calls the superclass (Gadget) constructor to set model, price, weight, and size.
        this.minutesOfCredit = minutesOfCredit;  // Initializes the minutesOfCredit field with the provided value.
    }

    
    // Retrieves the current amount of minutes of credit left on the mobile. 
    public int getMinutesOfCredit() {
        return minutesOfCredit;
    }

    
    // Adds more calling credit to the mobile. 
    public void addCallingCredit(int credit) {
        if (credit > 0) {  // Checks if the input value is positive.
            minutesOfCredit += credit;  // Adds the credit to the existing minutes of credit.
            System.out.println("Added " + credit + " minutes of calling credit.");  // Confirmation message.
        } else {
            System.out.println("Please enter a positive amount of calling credit.");  // Error message for non-positive values.
        }
    }

    //Simulates making a phone call, deducting minutes from the credit balance. 
    public void makePhoneCall(String phoneNumber, int duration) {
        if (minutesOfCredit >= duration) {  // Checks if there is enough credit to cover the duration of the call.
            minutesOfCredit -= duration;  // Deducts the duration of the call from the credit.
            System.out.println("Made a phone call to " + phoneNumber + " for " + duration + " minutes.");  // Confirmation of successful call.
        } else {
            System.out.println("Insufficient credit to make the call.");  // Error message if credit is insufficient.
        }
    }

    
    // Displays information about the mobile device, including the remaining calling credit.
    @Override
    public void display() {
        super.display();  // Calls the display method of the superclass to show basic gadget details.
        System.out.println("Minutes of calling credit remaining: " + minutesOfCredit);  // Additional detail specific to Mobile class.
    }
}
