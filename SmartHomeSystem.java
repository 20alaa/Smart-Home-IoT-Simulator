import java.util.ArrayList;
import java.util.List;

/**
 * --- Task 1: Class and Object ---
 * Represents a generic smart device.
 */
class Device {
    // Private data members
    private String deviceName;
    private String status;

    // Parameterized constructor
    public Device(String deviceName, String status) {
        this.deviceName = deviceName;
        this.status = status;
    }

    // Public method to display info
    public void displayInfo() {
        System.out.println("Device: " + this.deviceName + "   Status: " + this.status);
    }

    // --- Task 2: Encapsulation and Getters/Setters ---
    
    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

/**
 * --- Task 3: Inheritance ---
 * Represents a smart light, which is a specific type of Device.
 */
class SmartLight extends Device {
    // Private field for the subclass
    private int brightnessLevel;

    // Constructor that calls the parent constructor
    public SmartLight(String deviceName, String status, int brightnessLevel) {
        super(deviceName, status); // Call to parent constructor
        this.brightnessLevel = brightnessLevel;
    }

    // Method specific to SmartLight
    public void displayLightInfo() {
        // Uses getters from parent class because fields are private
        System.out.println("Device: " + getDeviceName() + "   Status: " + getStatus() + "   Brightness: " + this.brightnessLevel + "%");
    }

    /**
     * --- Task 4: Polymorphism and Overriding ---
     * Overrides the displayInfo() method from the parent Device class.
     */
    @Override
    public void displayInfo() {
        // Provides a specific implementation for SmartLight
        System.out.println("Device: " + getDeviceName() + "   Status: " + getStatus() + "   Brightness: " + this.brightnessLevel + "%");
    }
}

/**
 * --- Task 5: Aggregation and Interaction ---
 * Manages a collection of Device objects.
 */
class SmartHome {
    // Aggregation: SmartHome "has-a" list of devices
    private List<Device> devices;

    public SmartHome() {
        this.devices = new ArrayList<>();
    }

    // Method to add a device
    public void addDevice(Device d) {
        this.devices.add(d);
    }

    // Method to show all devices (demonstrates polymorphism)
    public void showAllDevices() {
        System.out.println("All devices in the Smart Home:");
        for (Device d : devices) {
            // Polymorphism: Calls the correct displayInfo()
            // (either from Device or SmartLight)
            d.displayInfo();
        }
    }

    // Method to turn off all devices
    public void turnOffAll() {
        System.out.println("Turning all devices OFF...");
        for (Device d : devices) {
            d.setStatus("OFF"); // Uses the public setter
        }
    }
}

/**
 * Main class to demonstrate the entire system.
 */
public class SmartHomeSystem {
    public static void main(String[] args) {

        // --- Task 1 & 2 Demonstration ---
        System.out.println("--- Task 1 & 2 Demo ---");
        Device demoAC = new Device("Air Conditioner", "ON");
        demoAC.displayInfo(); // Task 1
        
        // Task 2: Update and retrieve values
        demoAC.setStatus("OFF");
        System.out.println("Updated Status: " + demoAC.getStatus());
        demoAC.setStatus("ON"); // Set back for main demo
        System.out.println("-------------------------------------");

        
        // --- Task 3 Demonstration ---
        System.out.println("--- Task 3 Demo ---");
        SmartLight demoLight = new SmartLight("Smart Light", "ON", 80);
        demoLight.displayLightInfo(); // Task 3 specific method
        System.out.println("-------------------------------------");

        
        // --- Task 4 Demonstration (Polymorphism) ---
        System.out.println("--- Task 4 Demo ---");
        // Device reference to a SmartLight object
        Device polyLight = new SmartLight("Smart Light", "ON", 80);
        polyLight.displayInfo(); // Calls the *overridden* method in SmartLight
        System.out.println("-------------------------------------");

        
        // --- Task 5 Demonstration (Aggregation) ---
        // This part generates the final expected output
        System.out.println("\n--- Task 5: Smart Home Full Demo ---");
        
        // 1. Create devices
        Device ac = new Device("Air Conditioner", "ON");
        Device light = new SmartLight("Smart Light", "ON", 80); // Using polymorphic reference

        // 2. Create SmartHome and add devices
        SmartHome myHome = new SmartHome();
        myHome.addDevice(ac);
        myHome.addDevice(light);

        // 3. Show all devices (matches first part of Task 5 output)
        myHome.showAllDevices();

        System.out.println(); // Add spacing

        // 4. Turn all devices off
        myHome.turnOffAll();
        
        System.out.println(); // Add spacing

        // 5. Show all devices again (matches second part of Task 5 output)
        myHome.showAllDevices();
    }
}