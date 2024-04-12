/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package zoomanagementsystem;

/**
 *
 * @author (-_-)(-_-)
 */
public abstract class Animal {
    // Attributes
  
    protected String name;
    protected int age;
    protected double weight;
    protected String habitat;
    

    // Constructor
    public Animal(String name, int age, double weight, String habitat) {
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.habitat = habitat;
    }

    // Abstract methods
    public abstract void makeSound();
    public abstract void eat();
    public abstract void sleep();
    public abstract void feed();

    Object getName() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    Object getAge() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    Object getWeight() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
