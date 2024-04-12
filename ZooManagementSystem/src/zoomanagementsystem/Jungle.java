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
public class Jungle {
    private List<Reptile> reptiles;
    private List<Mammal> mammals;

    public Jungle() {
        reptiles = new ArrayList<>();
        mammals = new ArrayList<>();
    }

    public void addReptile(Reptile reptile) {
        reptiles.add(reptile);
    }

    public void addMammal(Mammal mammal) {
        mammals.add(mammal);
    }

    // Other methods for managing reptiles and mammals in the jungle
}

