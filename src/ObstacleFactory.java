public class ObstacleFactory {
	
    public Obstacle createObstacle() { // true = enemy, false = item
    	boolean type = Math.random() > 0.5;
    	if(type == true) {
    		return new EnemyPokemon();
    	}
    	else {
    		 return new Item();
    	}
    }
    
}
