
public class Charmander extends Pokemon{
	public Charmander() {
		super("Charmander", 1100, 450);
	}
	
	@Override
	public void showPowers() {
		System.out.println("1. Flamethrower: Performs an avarege attack doing " + this.getAttackPoints() +" damage");
		System.out.println("2. Fire blast: Attacks for 50 extra damage, but loses 20 hp \n");
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
		if(this.getXp()>=20 && this.getLevel()=='1'){
			this.setName("Charmeleon");
			this.setHealthPoints(1400);
			this.setAttackPoints(700);
			this.setLevel('2');
		}else
		if(this.getXp()>=35 && this.getLevel()=='2'){
			this.setName("Charizard");
			this.setHealthPoints(2000);
			this.setAttackPoints(1250);
			this.setLevel('3');
		}else
			System.out.println("Você não tem XP suficiente para evoluir!");
		
	}
}
