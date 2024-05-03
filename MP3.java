
//The MP3 class extends Gadget, adding MP3-specific functionality such as managing music downloads and deletions. 
public class MP3 extends Gadget {
    // Private field to store the amount of available memory in megabytes on the MP3 device.
    private int availableMemory;

    
    //Constructor for the MP3 class
    public MP3(String model, double price, int weight, String size, int availableMemory) {
        super(model, price, weight, size);  // Calls the superclass (Gadget) constructor to set model, price, weight, and size.
        this.availableMemory = availableMemory;  // Initializes the availableMemory field with the provided value.
    }

    
    // Retrieves the current amount of available memory on the MP3 player
    public int getAvailableMemory() {
        return availableMemory;
    }

    // Downloads music onto the MP3 player, reducing the available memory. 
    public void downloadMusic(int memory) {
        if (availableMemory >= memory) {  // Checks if there is enough available memory to download the music.
            availableMemory -= memory;  // Deducts the memory used by the music from the available memory.
            System.out.println("Downloaded " + memory + "MB of music.");  // Confirmation message for successful download.
        } else {
            System.out.println("Insufficient available memory to download music.");  // Error message if memory is insufficient.
        }
    }

    //Deletes music from the MP3 player, freeing up the used memory. 
    public void deleteMusic(int memory) {
        availableMemory += memory;  // Adds back the memory from the deleted music to the available memory.
        System.out.println("Deleted " + memory + "MB of music.");  // Confirmation message for successful deletion.
    }

    // Displays information about the MP3 player, including the available memory. 
    @Override
    public void display() {
        super.display();  // Calls the display method of the superclass to show basic gadget details.
        System.out.println("Available memory: " + availableMemory + "MB");  // Shows the current available memory on the device.
    }
}
