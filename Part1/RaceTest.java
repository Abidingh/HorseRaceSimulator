public class RaceTest {
    public static void main(String[] args) {
        // Create a race of length 30
        Race myRace = new Race(30);

        // Create horses
        Horse horse1 = new Horse('\u265E', "PIPPI LONGSTOCKING", 0.6); // ♞
        Horse horse2 = new Horse('\u265E', "KOKOMO", 0.6);
        Horse horse3 = new Horse('\u265E', "EL JEFE", 0.4);

        // Add horses to the race
        myRace.addHorse(horse1, 1);
        myRace.addHorse(horse2, 2);
        myRace.addHorse(horse3, 3);

        // Start the race
        myRace.startRace();
    }
}
