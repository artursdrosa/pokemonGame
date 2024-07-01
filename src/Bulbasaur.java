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
		if(this.getXp()>=20 && this.getLevel()=='1'){
			this.setName("Ivysaur");
			this.setHealthPoints(1800);
			this.setAttackPoints(400);
			this.setLevel('2');
		}else
		if(this.getXp()>=35 && this.getLevel()=='2'){
			this.setName("Venusaur");
			this.setHealthPoints(2400);
			this.setAttackPoints(750);
			this.setLevel('3');
		}else
			System.out.println("Você não tem XP suficiente para evoluir!");
		
	}


	

}
