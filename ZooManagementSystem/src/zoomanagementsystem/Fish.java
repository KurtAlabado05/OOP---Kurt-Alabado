/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package zoomanagementsystem;

/**
 *
 * @author (-_-)(-_-)
 */

public class Fish extends Animal implements Swimmable {
    // Constructor

    /**
     *
     * @param name
     * @param age
     * @param weight
     * @param habitat
     */
    public Fish(String name, int age, double weight, String habitat) {
        super(name, age, weight, habitat);
    }
    
    public void feed() {
        // Implement feeding logic for mammals
        System.out.println("Feeding fishes...");
    }
    // Implement abstract methods
    @Override
    public void makeSound() {
        System.out.println("Fish sound");
    }

    @Override
    public void eat() {
        System.out.println("Fish eating");
    }

    @Override
    public void sleep() {
        System.out.println("Fish sleeping");
    }

    // Implement Swimmable interface method
    @Override
    public void swim() {
        System.out.println("Fish swimming");
    }
}
