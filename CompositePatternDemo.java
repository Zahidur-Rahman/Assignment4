import java.util.ArrayList;
import java.util.List;

// Component interface
interface HousingStructure {
    void display();
}

// Leaf class
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

// Composite class
class Floor implements HousingStructure {
    private String name;
    private List<HousingStructure> structures = new ArrayList<>();

    public Floor(String name) {
        this.name = name;
    }

    public void addStructure(HousingStructure structure) {
        structures.add(structure);
    }

    @Override
    public void display() {
        System.out.println("Floor: " + name);
        System.out.println("Contains the following rooms:");
        for (HousingStructure structure : structures) {
            structure.display();
        }
        System.out.println();
    }
}

// Composite class (building)
class Building implements HousingStructure {
    private String name;
    private List<HousingStructure> structures = new ArrayList<>();

    public Building(String name) {
        this.name = name;
    }

    public void addStructure(HousingStructure structure) {
        structures.add(structure);
    }

    @Override
    public void display() {
        System.out.println("Building: " + name);
        System.out.println("Contains the following floors:");
        for (HousingStructure structure : structures) {
            structure.display();
        }
    }
}

public class CompositePatternDemo {
    public static void main(String[] args) {
        // Create rooms
        Room room1 = new Room("Bedroom");
        Room room2 = new Room("Living Room");
        Room room3 = new Room("Kitchen");

        // Create floors and add rooms to them
        Floor floor1 = new Floor("First Floor");
        floor1.addStructure(room1);
        floor1.addStructure(room2);

        Floor floor2 = new Floor("Second Floor");
        floor2.addStructure(room3);

        // Create a building and add floors to it
        Building building = new Building("My House");
        building.addStructure(floor1);
        building.addStructure(floor2);

        // Display the building structure
        building.display();
    }
}
