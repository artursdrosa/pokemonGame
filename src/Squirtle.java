
public class Squirtle extends Pokemon{
	
	public Squirtle() {
		super("Squirtle", 1200, 400);
	}
	
	@Override
	public void showPowers() {
		System.out.println("1. Water Splash: Performs an averege attack doing " + this.getAttackPoints() +" damage");
		System.out.println("2. Deep Dive: Attacks for 10 less damage, but earns 10 extra xp \n");
	}

	@Override
	public void power1(EnemyPokemon enemy) {
		enemy.setHeathPoints(enemy.getHeathPoints()-this.getAttackPoints());
		System.out.println(this.getName()+" attacks for " + this.getAttackPoints() + " damage");

	}

	@Override
	public void power2(EnemyPokemon enemy) {
		enemy.setHeathPoints(enemy.getHeathPoints()-(this.getAttackPoints()-30));
		setXp(getXp()+10);
		System.out.println(this.getName()+" attacks for " + (this.getAttackPoints()-30) + " damage and gains 10 extra xp");

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
