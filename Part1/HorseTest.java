public class HorseTest
{

    public static void main(String[] args)
    {
        // Testing Constructor with valid confidence
        Horse horse1 = new Horse('A', "Alpha", 0.75);

        System.out.println("Test 1: Constructor with valid confidence");
        System.out.println("Name: " + horse1.getName()); // Expected: Lightning
        System.out.println("Symbol: " + horse1.getSymbol()); // Expected: A
        System.out.println("Confidence: " + horse1.getConfidence()); // Expected: 0.75
        System.out.println("Distance Travelled: " + horse1.getDistanceTravelled()); // Expected: 0
        System.out.println("Has Fallen: " + horse1.hasFallen()); // Expected: false
        System.out.println();

        // Testing Constructor with invalid confidence (should default to 0.5)
        Horse horse2 = new Horse('B', "Beta", 1.2);

        System.out.println("Test 2: Constructor with invalid confidence");
        System.out.println("Confidence (should be 0.5): " + horse2.getConfidence());
        System.out.println();

        // Testing setConfidence with valid and invalid input
        System.out.println("Test 3: setConfidence()");
        horse1.setConfidence(0.3);
        System.out.println("Updated Confidence: " + horse1.getConfidence()); // Expected: 0.3

        try {
            horse1.setConfidence(-0.1); // Should throw an exception
        } catch (IllegalArgumentException e) {
            System.out.println("Caught exception for invalid confidence: " + e.getMessage());
        }
        System.out.println();

        // Testing moveForward()
        System.out.println("Test 4: moveForward()");
        horse1.moveForward();
        horse1.moveForward();
        System.out.println("Distance Travelled after 2 moves: " + horse1.getDistanceTravelled()); // Expected: 2
        System.out.println();

        // Testing fall() and hasFallen()
        System.out.println("Test 5: fall() and hasFallen()");
        horse1.fall();
        System.out.println("Has Fallen: " + horse1.hasFallen()); // Expected: true
        System.out.println();

        // Testing goBackToStart()
        System.out.println("Test 6: goBackToStart()");
        horse1.goBackToStart();
        System.out.println("Distance Travelled: " + horse1.getDistanceTravelled()); // Expected: 0
        System.out.println("Has Fallen: " + horse1.hasFallen()); // Expected: false
        System.out.println();

        // Testing setSymbol()
        System.out.println("Test 7: setSymbol()");
        horse1.setSymbol('Z');
        System.out.println("Updated Symbol: " + horse1.getSymbol()); // Expected: Z
    }
}
