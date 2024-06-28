
public abstract class Pokemon {
	private String name;
	private int healthPoints;
	private int attackPoints;
	private char level; // is incremented when the pokemon evolves
	private int xp;
	
	public abstract void power1();
	public abstract void power2();
	public abstract void tryToEvolve();
	
	public void useItem(Item item) { // tem que pegar o pokemon do player e o item do player no main
	    if (item.isType()) {
	        this.healthPoints += item.getPoints();
	    } else {
	        this.attackPoints += item.getPoints();
	    }
	}
		
	public int getHealthPoints() {
		return healthPoints;
	}
	public int getAttackPoints() {
		return attackPoints;
	}
	public int getLevel() {
		return level;
	}
	public int getXp() {
		return xp;
	}
	public String getName() {
		return name;
	}
	public Pokemon(String name, int healthPoints, int atackPoints) {
		this.name = name;
		this.healthPoints = healthPoints;
		this.attackPoints = atackPoints;
		this.level = '1';
		this.xp = 0;
	}
	
	@Override
	public String toString() {
		return name + " => health: " + healthPoints + " atack: " + attackPoints + " | ";
	}

	
}
