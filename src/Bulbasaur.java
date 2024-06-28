public class Bulbasaur extends Pokemon{
	public Bulbasaur() {
		super("Bulbasaur", 1500, 250);
	}

	@Override
	public void power1(EnemyPokemon enemy) {
		enemy.setHeathPoints(enemy.getHeathPoints()-this.getAttackPoints());
	}

	@Override
	public void power2(EnemyPokemon enemy) {
		enemy.setHeathPoints(enemy.getHeathPoints()-(this.getAttackPoints()-30));
		setHealthPoints(getHealthPoints()+30);
	}

	@Override
	public void tryToEvolve() {
		// TODO Auto-generated method stub
		
	}


	

}
