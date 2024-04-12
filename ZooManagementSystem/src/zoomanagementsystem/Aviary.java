/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package zoomanagementsystem;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author (-_-)(-_-)
 */

public class Aviary {
    private List<Bird> birds;

    public Aviary() {
        birds = new ArrayList<>();
    }

    public void addBird(Bird bird) {
        birds.add(bird);
    }

    // Other methods for managing birds in the aviary
}
