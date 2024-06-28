
public class Squirtle extends Pokemon{
	
	public Squirtle() {
		super("Squirtle", 1200, 400);
	}

	@Override
	public void power1(EnemyPokemon enemy) {
		enemy.setHeathPoints(enemy.getHeathPoints()-this.getAttackPoints());
	}

	@Override
	public void power2(EnemyPokemon enemy) {
		enemy.setHeathPoints(enemy.getHeathPoints()-(this.getAttackPoints()-30));
		setXp(getXp()+30);
	}

	@Override
	public void tryToEvolve() {
		// TODO Auto-generated method stub
		
	}

}
