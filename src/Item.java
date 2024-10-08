public class Item extends Obstacle{
    private boolean type;   //false = power, true = health
    private int points;
    
    public Item() {
		this.type = Math.random() > 0.5; // using math to make 50% chance
		if (this.type == true) {
			this.points = Math.random() > 0.7 ? 75 : 30; // 30 percent chance of gaining a special item
		}else {
			this.points = Math.random() > 0.7 ? 250 : 100; // same thing as the power item, but in terms of health
		}
	}
    
	@Override
	public String toString() {
		return type == true ? "Health item: +" + points + " hp" : "Strength item: +" + points + " atack"; 
	}


	public boolean isType() {
		return type;
	}


	public int getPoints() {
		return points;
	}
    
    
    
    
}
