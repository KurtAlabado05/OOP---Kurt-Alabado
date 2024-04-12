/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package zoomanagementsystem;

/**
 *
 * @author (-_-)(-_-)
 */
public class Monkey extends Primate implements Climber {
    // Constructor

    /**
     *
     * @param name
     * @param age
     * @param weight
     */
    public Monkey(String name, int age, double weight, String habitat) {
        super(name, age, weight, habitat);
    }

    // Implement Climber interface method
    @Override
    public void climb() {
        System.out.println("Monkey climbing");
    }
}
