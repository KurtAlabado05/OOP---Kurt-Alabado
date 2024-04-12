/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package zoomanagementsystem;

/**
 *
 * @author (-_-)(-_-)
 */
public class Ape extends Primate implements Climber {
    // Constructor

    /**
     *
     * @param name
     * @param age
     * @param weight
     * @param habitat
     */
    public Ape(String name, int age, double weight, String habitat) {
        super(name, age, weight, habitat);
    }

    // Implement Climber interface method
    @Override
    public void climb() {
        System.out.println("Ape climbing");
    }
}
