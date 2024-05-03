
//The Gadget class represents a generic gadget with basic properties such as model, price, weight, and size
public class Gadget {
    
    // Attributes defining the characteristics of the gadget.
    private String model; // The model name of the gadget.
    private double price; // The price of the gadget in pounds.
    private int weight; // The weight of the gadget in grams.
    private String size; // The dimensions of the gadget (e.g., "71mm x 137mm x 9mm").

    // Constructor to initialize a Gadget object with specified attributes. 
    public Gadget(String model, double price, int weight, String size) {
        // Initialize instance variables with provided values.
        this.model = model;
        this.price = price;
        this.weight = weight;
        this.size = size;
    }

    //Retrieves the model name of the gadget. 
    public String getModel() {
        return this.model; // Return the model attribute.
    }

    //Sets the model name of the gadget.
    public void setModel(String newModel) {
        this.model = newModel; // Update the model attribute.
    }

    //Retrieves the price of the gadget. 
    public double getPrice() {
        return this.price; // Return the price attribute.
    }

    
    //Sets the price of the gadget.
    public void setPrice(double newPrice) {
        this.price = newPrice; // Update the price attribute.
    }

    
    //Retrieves the weight of the gadget.
    public int getWeight() {
        return this.weight; // Return the weight attribute.
    }

    
    //Sets the weight of the gadget.
    public void setWeight(int newWeight) {
        this.weight = newWeight; // Update the weight attribute.
    }

    //Retrieves the size dimensions of the gadget.
    public String getSize() {
        return this.size; // Return the size attribute.
    }

    //Sets the size dimensions of the gadget. 
    public void setSize(String newSize) {
        this.size = newSize; // Update the size attribute.
    }

    //Displays the details of the gadget. 
    public void display() {
        System.out.println("Model: " + this.model); // Display the model.
        System.out.println("Price: £" + this.price); // Display the price.
        System.out.println("Weight: " + this.weight + " grams"); // Display the weight.
        System.out.println("Size: " + this.size); // Display the size.
    }
}


