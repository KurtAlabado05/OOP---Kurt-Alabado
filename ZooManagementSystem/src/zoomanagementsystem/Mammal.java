/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package zoomanagementsystem;

/**
 *
 * @author (-_-)(-_-)
 */
public class Mammal extends Animal {
    // Constructor

    /**
     *
     * @param name
     * @param age
     * @param weight
     * @param habitat
     */
    // Constructor
    public Mammal(String name, int age, double weight, String habitat) {
        super(name, age, weight, habitat);
    }
    
    public void feed() {
        // Implement feeding logic for mammals
        System.out.println("Feeding mammals...");
    }
    // Implement abstract methods
    @Override
    public void makeSound() {
        System.out.println("Mammal sound");
    }

    @Override
    public void eat() {
        System.out.println("Mammal eating");
    }

    @Override
    public void sleep() {
        System.out.println("Mammal sleeping");
    }
}
