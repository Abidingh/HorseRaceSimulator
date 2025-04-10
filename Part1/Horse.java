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
        this.confidence = horseConfidence;
    }
    
    
    
    //Other methods of class Horse
    public void fall()
    {
        
    }
    
    public double getConfidence()
    {
        
    }
    
    public int getDistanceTravelled()
    {
        
    }
    
    public String getName()
    {
        
    }
    
    public char getSymbol()
    {
        
    }
    
    public void goBackToStart()
    {
        
    }
    
    public boolean hasFallen()
    {
        
    }

    public void moveForward()
    {
        
    }

    public void setConfidence(double newConfidence)
    {
        
    }
    
    public void setSymbol(char newSymbol)
    {
        
    }
    
}
