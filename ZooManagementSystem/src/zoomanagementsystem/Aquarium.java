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

public class Aquarium {
    private List<Fish> fishes;

    public Aquarium() {
        fishes = new ArrayList<>();
    }

    public void addFish(Fish fish) {
        fishes.add(fish);
    }

    // Other methods for managing fishes in the aquarium
}
