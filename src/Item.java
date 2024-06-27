public class Item extends Obstacle{
    boolean type;   //false = power, true = health
    int points;
    
    public Item() {
		this.type = Math.random() > 0.5; // using math to make 50% chance
		if (this.type == true) {
			this.points = Math.random() > 0.7 ? 75 : 30; // 30 percent chance of gaining a special item
		}else {
			this.points = Math.random() > 0.7 ? 250 : 100; // same thing as the power item, but in terms of health
		}
	}

	public void use(Pokemon pokemon, Boolean tipo){

    }

	@Override
	public String toString() {
		return type == true ? "Health item: +" + points + " hp" : "Strength item: +" + points + " atack"; 
	}
    
    
    
    
}
