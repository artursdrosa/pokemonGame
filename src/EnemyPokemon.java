public class EnemyPokemon extends Obstacle {
    int heathPoints;
    int attackPoints;
    
    public EnemyPokemon() {
		this.heathPoints = 1;
		this.attackPoints = 1;
	}

	public int getHeathPoints() {
        return heathPoints;
    }

    public int getAttackPoints() {
        return attackPoints;
    }
    public void setHeathPoints(int heathPoints) {
        this.heathPoints = heathPoints;
    }

    public void setAttackPoints(int attackPoints) {
        this.attackPoints = attackPoints;
    }

    public void attack(Pokemon pokemon){
        //player.pokemon.vida -= attackPoints
    }
    
    

}
