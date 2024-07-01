
public abstract class Pokemon {
	private String name;
	private int healthPoints;
	private int attackPoints;
	private char level; // is incremented when the pokemon evolves
	private int xp;
	
	public abstract void power1(EnemyPokemon enemy);
	public abstract void power2(EnemyPokemon enemy);
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
	public void setHealthPoints(int healthPoints) {
		this.healthPoints = healthPoints;
	}
	public void setAtackPoints(int attackPoints) {
		this.attackPoints = attackPoints;
	}

	public void setXp(int xp) {
		this.xp = xp;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAttackPoints(int attackPoints) {
		this.attackPoints = attackPoints;
	}

	public void setLevel(char level) {
		this.level = level;
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
		return "| "+ name + " => health: " + healthPoints + " atack: " + attackPoints + " level: " + level + " | ";
	}


	
}
