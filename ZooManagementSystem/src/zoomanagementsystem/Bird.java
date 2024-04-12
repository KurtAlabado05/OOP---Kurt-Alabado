/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package zoomanagementsystem;

/**
 *
 * @author (-_-)(-_-)
 */
public class Bird extends Animal implements Flyable {
    // Constructor

    /**
     *
     * @param name
     * @param age
     * @param weight
     * @param habitat
     */
    public Bird(String name, int age, double weight, String habitat) {
        super(name, age, weight, habitat);
    }
    
    public void feed() {
        // Implement feeding logic for mammals
        System.out.println("Feeding birds...");
    }
    // Implement abstract methods
    @Override
    public void makeSound() {
        System.out.println("Bird sound");
    }

    @Override
    public void eat() {
        System.out.println("Bird eating");
    }

    @Override
    public void sleep() {
        System.out.println("Bird sleeping");
    }

    // Implement Flyable interface method
    @Override
    public void fly() {
        System.out.println("Bird flying");
    }
}