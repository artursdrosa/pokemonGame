
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
		if(this.getXp()>=20 && this.getLevel()=='1'){
			this.setName("Watertortle");
			this.setHealthPoints(1600);
			this.setAttackPoints(600);
			this.setLevel('2');
		}else
			if(this.getXp()>=35 && this.getLevel()=='2'){
				this.setName("Blastoise");
				this.setHealthPoints(2100);
				this.setAttackPoints(1000);
				this.setLevel('3');
			}else
				System.out.println("Você não tem XP suficiente para evoluir!");


	}

}
