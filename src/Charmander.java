
public class Charmander extends Pokemon{
	public Charmander() {
		super("Charmander", 1100, 450);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void power1(EnemyPokemon enemy) {
		enemy.setHeathPoints(enemy.getHeathPoints()-this.getAttackPoints());
	}

	@Override
	public void power2(EnemyPokemon enemy) {
		setHealthPoints(getHealthPoints()-20);
		enemy.setHeathPoints(enemy.getHeathPoints()-(this.getAttackPoints()+50));
	}

	@Override
	public void tryToEvolve() {
		// TODO Auto-generated method stub
		
	}
}
