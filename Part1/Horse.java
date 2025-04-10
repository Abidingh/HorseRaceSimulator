/**
 * The horse class is a blueprint for a horse that participates in the race.
 * Each object tracks the horse's name, the symbol that appears in the race, the distance travelled by the horse in the race,
 * the horse's confidence level i.e. how fast it will travel, and a flag that indicates if a horse has fallen or not.
 * The class includes methods for moving the horse forward, checking if it has fallen, and resetting its position.
 * The horse's confidence and symbol can also be changed with their respective mutator methods.
 * 
 * 
 * @author Rusel R Segmenov
 * @version 1
 */
public class Horse
{
    //Fields of class Horse
    private String name;
    private char symbol;
    private double confidence;
    private int distanceTravelled = 0;

    private boolean fallFlag = false;

    
      
    //Constructor of class Horse
    /**
    public Horse(char horseSymbol, String horseName, double horseConfidence)
    {
        this.name = horseName;
        this.symbol = horseSymbol;
		
		try{
			setConfidence(horseConfidence);
		}
		catch(IllegalArgumentException e){
			System.out.println("Error in constructor: " + e.getMessage());
			this.confidence = 0.5; //sets confidence to a default value of 0.5
		}
    }
    
    
    
    //Other methods of class Horse
	

	//sets the fall flag to true
    public void fall()
    {
        this.fallFlag = true;

    }
    

    public double getConfidence()
    {
        return this.confidence;
    }
    
    public int getDistanceTravelled()
    {
        return this.distanceTravelled;
    }
    
    public String getName()
    {
        return this.name;
    }
    
    public char getSymbol()
    {
        return this.symbol;
    }
    
	//sets distance travelled to 0 and fall flag to false
    public void goBackToStart()
    {
        this.distanceTravelled = 0;
        this.fallFlag = false;
    }
    

    public boolean hasFallen()
    {
        return this.fallFlag;
    }

	//increments distance travelled by 1
    public void moveForward()
    {
        this.distanceTravelled++;
    }

	//validates if the new confidence is between 0 and 1.
    public void setConfidence(double newConfidence)
    {
        if(newConfidence>0 && newConfidence<1)
        {
            this.confidence = newConfidence;
        }
        else
        {
			throw new IllegalArgumentException("Confidence must be between 0 and 1.");
        }
    }
    
    public void setSymbol(char newSymbol)
    {
        this.symbol = newSymbol;
    }
    
}
