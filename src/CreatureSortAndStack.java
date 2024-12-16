import java.util.Stack;

public class CreatureSortAndStack {

    // Creature class to hold the name and power level
    static class Creature {
        String name;
        int powerLevel;

        // Constructor to initialize name and power level
        public Creature(String name, int powerLevel) {
            this.name = name;
            this.powerLevel = powerLevel;
        }

        // Method to display the creature's details in the desired format
        public void display() {
            System.out.printf("                      %-20s %-3d \n", name, powerLevel);
        }
    }

    // Method to perform Bubble Sort in descending order of power level
    public static void bubbleSort(Creature[] creatures) {
        int n = creatures.length;
        // Bubble Sort in descending order
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (creatures[j].powerLevel < creatures[j + 1].powerLevel) {
                    // Swap the creatures
                    Creature temp = creatures[j];
                    creatures[j] = creatures[j + 1];
                    creatures[j + 1] = temp;
                }
            }
        }
    }

    // Method to perform Selection Sort in ascending order of power level
    public static void selectionSort(Creature[] creatures) {
        int n = creatures.length;
        // Selection Sort in ascending order
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (creatures[j].powerLevel < creatures[minIndex].powerLevel) {
                    minIndex = j;
                }
            }
            // Swap the creatures
            Creature temp = creatures[minIndex];
            creatures[minIndex] = creatures[i];
            creatures[i] = temp;
        }
    }

    // Method to display the header for the boxes
    public static void printBoxHeader(String title) {
        System.out.println("******************************************************************");
        System.out.println("                                                                ");
        System.out.printf("    %-50s \n", title);
        System.out.println("                                                                ");
    }

    // Method to display the footer for the boxes
    public static void printBoxFooter() {
        System.out.println("                                                                ");
        System.out.println("******************************************************************");
    }

    // Main method to run the program
    public static void main(String[] args) {
        // Create an array of creatures
        Creature[] creatures = {
            new Creature("Dragon", 95),
            new Creature("Griffin", 88),
            new Creature("Unicorn", 78),
            new Creature("Phoenix", 92),
            new Creature("Centaur", 85)
        };

        // *** Bubble Sort: Descending Order by Power Level ***
        printBoxHeader("      Bubble Sort: Descending Order by Power Level");
        bubbleSort(creatures);
        for (Creature creature : creatures) {
            creature.display();
        }
        printBoxFooter();

        System.out.println(); // Empty line for separation

        // *** Selection Sort: Ascending Order by Power Level ***
        printBoxHeader("      Selection Sort: Ascending Order by Power Level");
        selectionSort(creatures);
        for (Creature creature : creatures) {
            creature.display();
        }
        printBoxFooter();

        System.out.println(); // Empty line for separation

        // *** Stack Implementation: Popping Creatures ***
        printBoxHeader("           Stack Implementation: Popping Creatures");

        // Create a stack
        Stack<Creature> stack = new Stack<>();

        // Push all creatures onto the stack using the bubble sorted array (descending order)
        for (Creature creature : creatures) {
            stack.push(creature);
        }

        // Pop all creatures from the stack and display them
        while (!stack.isEmpty()) {
            Creature poppedCreature = stack.pop();
            System.out.printf("                  Popped: %-20s %-3d \n", poppedCreature.name, poppedCreature.powerLevel);
        }

        printBoxFooter();
    }
}