
public abstract class Pokemon {
	private String name;
	private int healthPoints;
	private int atackPoints;
	private char level; // is incremented when the pokemon evolves
	private int xp;
	
	public abstract void power1(EnemyPokemon enemy);
	public abstract void power2(EnemyPokemon enemy);
	public abstract void tryToEvolve();
	
	public int getHealthPoints() {
		return healthPoints;
	}
	public int getAtackPoints() {
		return atackPoints;
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
	public void setAtackPoints(int atackPoints) {
		this.atackPoints = atackPoints;
	}

	public void setXp(int xp) {
		this.xp = xp;
	}

	public Pokemon(String name, int healthPoints, int atackPoints) {
		this.name = name;
		this.healthPoints = healthPoints;
		this.atackPoints = atackPoints;
		this.level = '1';
		this.xp = 0;
	}
	

	
}
