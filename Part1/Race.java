import java.util.concurrent.TimeUnit;
import java.lang.Math;
import java.util.ArrayList;

/**
 * A three-horse race, each horse running in its own lane
 * for a given distance
 *
 * @author McRaceface
 * @version 1.0
 */
public class Race
{
    private int raceLength;
    private ArrayList<Horse> horses;

    /**
     * Constructor for objects of class Race
     * Initially there are no horses in the lanes
     *
     * @param distance the length of the racetrack (in metres/yards...)
     */
    public Race(int distance)
    {
        // initialise instance variables
        raceLength = distance;
        horses = new ArrayList<>();
    }

    /**
     * Sets the race length outside the constructor
     *
     * @param distance the length of the racetrack (in metres/yards...)
     */
    public void setRaceLength(int distance)
    {
        if (distance > 0)
        {
        this.raceLength = distance;
        }
        else
        {
            throw new IllegalArgumentException("Race length must be positive");
        }
    }

    /**
     * Adds a horse to the race in the next available lane
     *
     * @param theHorse the horse to be added to the race
     */
    public void addHorse(Horse theHorse)
    {
        horses.add(theHorse);
    }

    public int getHorseCount()
    {
        return horses.size();
    }

    /**
     * Removes the horse in a given lane
     * @param lane the lane to remove a horse from
     */
    public void removeHorseInLane(int lane)
    {
        if(lane < 0 || lane >= getHorseCount())
        {
            System.out.println("Invalid lane");
            return;
        }

        horses.remove(lane);
    }

    /**
     * Start the race
     * The horse are brought to the start and
     * then repeatedly moved forward until the 
     * race is finished
     */
    public void startRace()
    {
        //declare a local variable to tell us when the race is finished
        boolean finished = false;
        //declare a local variable to store the winner of the race
        Horse winner = null;

        //return all horses back to start
        for(Horse horse : horses)
        {
            if(horse != null)
            {
                horse.goBackToStart();
            }
        }

        while (!finished)
        {

            //move each horse
            for(Horse horse : horses)
            {
                moveHorse(horse);
            }


            //print the race positions
            printRace();

            //check if all the horses have fallen
            if(haveAllFallen())
            {
                finished = true;
                continue;
            }

            //if any of the three horses has won the race is finished
            for(Horse horse : horses)
            {
                if(raceWonBy(horse))
                {
                    winner = horse;
                    finished = true;
                }
            }

            //wait for 100 milliseconds
            try{
                TimeUnit.MILLISECONDS.sleep(100);
            }
            catch(Exception e){}

        }

        //check if there has been a winner declared
        if(winner != null)
        {
            System.out.println("And the winner is... " + winner.getName() + "!");
            //increment winner's confidence by 0.1 if they win
            try
            {
                winner.setConfidence(winner.getConfidence() + 0.1);
            }
            //catch if confidence is already at its highest
            catch(Exception e)
            {
                System.out.println(winner.getName() + "'s is already as confident as he can be!");
            }
        }
        else
        {
            System.out.println("All horses have fallen! There is no winner.");
        }
    }

    /**
     * Check if all horses have fallen
     *
     * @return true if all horses have fallen
     */
    private Boolean haveAllFallen()
    {
        for(Horse horse : horses)
        {
            //if one horse hasn't fallen return false
            if(!horse.hasFallen())
            {
                return false;
            }
        }
        //otherwise, return true
        return true;
    }

    /**
     * Randomly make a horse move forward or fall depending
     * on its confidence rating
     * A fallen horse cannot move
     *
     * @param theHorse the horse to be moved
     */
    private void moveHorse(Horse theHorse)
    {
        //if the horse has fallen it cannot move, 
        //so only run if it has not fallen
        if  (!theHorse.hasFallen())
        {
            //the probability that the horse will move forward depends on the confidence;
            if (Math.random() < theHorse.getConfidence())
            {
                theHorse.moveForward();
            }

            //the probability that the horse will fall is very small (max is 0.1)
            //but will also will depends exponentially on confidence 
            //so if you double the confidence, the probability that it will fall is *2
            if (Math.random() < (0.1*theHorse.getConfidence()*theHorse.getConfidence()))
            {
                theHorse.fall();
            }
        }
    }

    /**
     * Determines if a horse has won the race
     *
     * @param theHorse The horse we are testing
     * @return true if the horse has won, false otherwise.
     */
    private boolean raceWonBy(Horse theHorse)
    {
        return theHorse.getDistanceTravelled() == raceLength;
    }

    /***
     * Print the race on the terminal
     */
    private void printRace()
    {
        System.out.print('\u000C');  //clear the terminal window

        multiplePrint('=',raceLength+3); //top edge of track
        System.out.println();

        //print each horse's lane in order
        for(Horse horse : horses)
        {
            printLane(horse);
            System.out.println();
        }

        multiplePrint('=',raceLength+3); //bottom edge of track
        System.out.println();
    }

    /**
     * print a horse's lane during the race
     * for example
     * |           X                      |
     * to show how far the horse has run
     */
    private void printLane(Horse theHorse)
    {
        //calculate how many spaces are needed before
        //and after the horse
        int spacesBefore = theHorse.getDistanceTravelled();
        int spacesAfter = raceLength - theHorse.getDistanceTravelled();

        //print a | for the beginning of the lane
        System.out.print('|');

        //print the spaces before the horse
        multiplePrint(' ',spacesBefore);

        //if the horse has fallen then print dead
        //else print the horse's symbol
        if(theHorse.hasFallen())
        {
            System.out.print('❌');
        }
        else
        {
            System.out.print(theHorse.getSymbol());
        }

        //print the spaces after the horse
        multiplePrint(' ',spacesAfter);

        //print the | for the end of the track
        System.out.print('|');

        //print the horse's name and current confidence at the end of its displayed lane
        System.out.printf("   " + theHorse.getName() + "(Current confidence %.1f)", theHorse.getConfidence());
    }


    /**
     * print a character a given number of times.
     * e.g. printmany('x',5) will print: xxxxx
     *
     * @param aChar the character to Print
     */
    private void multiplePrint(char aChar, int times)
    {
        int i = 0;
        while (i < times)
        {
            System.out.print(aChar);
            i = i + 1;
        }
    }
}
