/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package zoomanagementsystem;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.Scanner;
/**
 *
 * @author (-_-)(-_-)
 */
public class ZooManagementSystem {

  
    private static List<Animal> animals = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Welcome to the Zoo Management System!");
        System.out.println("Enter 'done' to finish adding animals.");

        // Animal adding loop
        while (true) {
            System.out.println("Enter animal type (Mammal, Bird, Fish, Reptile): ");
            String type = scanner.nextLine();
            if (type.equalsIgnoreCase("done")) {
                break;
            }
            System.out.println("Enter name: ");
            String name = scanner.nextLine();
            System.out.println("Enter age: ");
            int age = scanner.nextInt();
            System.out.println("Enter weight: ");
            double weight = scanner.nextDouble();
            scanner.nextLine(); // Consume newline
            System.out.println("Enter Habitat(Aviary, Aquarium,Jungle, Savannah): ");
            String habitat = scanner.nextLine();
            Animal animal = createAnimal(type, name, age, weight, habitat);
            if (animal != null) {
                animals.add(animal);
                System.out.println("Added " + animal.getClass().getSimpleName() + " named " + animal.name);
            } else {
                System.out.println("Invalid animal type!");
            }
        }

        // Menu loop
        while (true) {
            System.out.println("Zoo Management System Menu:");
            System.out.println("1. View all animals in the zoo");
            System.out.println("2. View animals in a specific habitat");
            System.out.println("3. Feed animals");
            System.out.println("4. Simulate animal behavior");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    displayAnimals();
                    break;
                case 2:
                    viewAnimalsInHabitat();
                    break;
                case 3:
                    feedAnimals();
                    break;
                case 4:
                    simulateAnimalBehavior();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 5.");
            }
        }
    }

    // Factory method to create animal instances based on user input
    

    // Method to display all animals in the zoo
    private static void displayAnimals() {
        System.out.println("Animals in the zoo:");
    for (Animal animal : animals) {
        System.out.println("Name: " + animal.name);
        System.out.println("Age: " + animal.age);
        System.out.println("Weight: " + animal.weight);
        System.out.println("Habitat: " + animal.habitat);
        System.out.println("Type: " + animal.getClass().getSimpleName());
        System.out.println(); // Add a newline for readability
    }
}
private static void viewAnimalsInHabitat() {
    Map<String, List<Animal>> animalsByHabitat = new HashMap<>();

    // Group animals by habitat
    for (Animal animal : animals) {
        String habitat = animal.habitat;
        if (!animalsByHabitat.containsKey(habitat)) {
            animalsByHabitat.put(habitat, new ArrayList<>());
        }
        animalsByHabitat.get(habitat).add(animal);
    }

    // Display animals by habitat
    for (Map.Entry<String, List<Animal>> entry : animalsByHabitat.entrySet()) {
        String habitat = entry.getKey();
        List<Animal> habitatAnimals = entry.getValue();
        
        System.out.println("Animals in " + habitat + " habitat:");
        for (Animal animal : habitatAnimals) {
            System.out.println(animal.name + " - " + animal.getClass().getSimpleName());
        }
    }
}
private static void feedAnimals() {
    // Iterate over the list of animals and feed each one
    for (Animal animal : animals) {
        animal.feed();
    }
}

private static Animal createAnimal(String type, String name, int age, double weight, String habitat) {
    switch (type.toUpperCase()) { // Convert type to uppercase
        case "MAMMAL": // Change to uppercase cases
            return new Mammal(name, age, weight, habitat);
        case "BIRD":
            return new Bird(name, age, weight,habitat);
        case "FISH":
            return new Fish(name, age, weight,habitat);
        case "REPTILE":
            return new Reptile(name, age, weight,habitat);
        default:
            return null;
    }
}

// Method to simulate behavior for all animals in the zoo
private static void simulateAnimalBehavior() {
    for (Animal animal : animals) {
        animal.sleep();
        animal.makeSound();
        // You can add more behaviors specific to each animal type if needed
    }
}
}