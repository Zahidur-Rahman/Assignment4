import java.util.ArrayList;
import java.util.List;

// Component
interface HousingStructure {
    void display();
}

// Leaf
class Room implements HousingStructure {
    private String name;

    public Room(String name) {
        this.name = name;
    }

    @Override
    public void display() {
        System.out.println("Room: " + name);
    }
}

// Composite
class Building implements HousingStructure {
    private String name;
    private List<HousingStructure> structures = new ArrayList<>();

    public Building(String name) {
        this.name = name;
    }

    public void addStructure(HousingStructure structure) {
        structures.add(structure);
    }

    public void removeStructure(HousingStructure structure) {
        structures.remove(structure);
    }

    @Overridehh
    public void display() {
        System.out.println("Building: " + name);
        for (HousingStructure structure : structures) {
            structure.display();
        }
    }
}

public class CompositePatternDemo {
    public static void main(String[] args) {
        // Create individual rooms
        HousingStructure room1 = new Room("Living Room");
        HousingStructure room2 = new Room("Kitchen");
        HousingStructure room3 = new Room("Bedroom");
        HousingStructure room4 = new Room("Bathroom");

        // Create a building and add rooms to it
        Building house = new Building("My House");
        house.addStructure(room1);
        house.addStructure(room2);
        house.addStructure(room3);

        // Create another building
        Building apartment = new Building("Apartment");
        apartment.addStructure(room4);

        // Add the apartment to the house
        house.addStructure(apartment);

        // Display the entire building hierarchy
        house.display();
    }
}
