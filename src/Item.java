public class Item extends Obstacle{
    boolean type;   //false = power, true = health
    int points;

    public void use(Pokemon pokemon, Boolean tipo){

    }

	@Override
	public String toString() {
		return type == true ? "Health item: +" + points + " hp" : "Strength item: +" + points + " atack"; 
	}
    
    
    
    
}
