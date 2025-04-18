public class RaceTest {
    public static void main(String[] args) {
        // Create a race of length 30
        Race myRace = new Race(30);

        // Create horses
        Horse horse1 = new Horse('♞', "PIPPI LONGSTOCKING", 0.6); // ♞
        Horse horse2 = new Horse('♞', "KOKOMO", 0.6);
        Horse horse3 = new Horse('♞', "EL JEFE", 0.4);

        // Add horses to the race
        myRace.addHorse(horse1);
        myRace.addHorse(horse2);
        myRace.addHorse(horse3);

        // Start the race
        myRace.startRace();
    }
}
