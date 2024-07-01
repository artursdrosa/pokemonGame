public class EnemyPokemon extends Obstacle {
    private int heathPoints;
    private int attackPoints;
    
    public EnemyPokemon() {
		double aux = Math.random(); // 0 to 1

        if(aux <= 0.29) { //average enemy
            this.heathPoints = 200;
            this.attackPoints = 100;
        }else
            if(aux>=0.30 && aux<=0.59) { // strongest enemy
                this.heathPoints = 200;
                this.attackPoints = 400;
            }else
                if(aux>=0.60 && aux<=0.89) { //roughest enemy
                this.heathPoints = 800;
                this.attackPoints = 250;
                }else{
                    this.heathPoints = 1000; //hardest enemy
                    this.attackPoints = 500;
                }

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
        pokemon.setHealthPoints(pokemon.getHealthPoints()-this.attackPoints); // pega a vida do pokemon, subtrai o attack do enemy, e seta o resultado como a vida do pokemon
    }

    
    @Override
   	public String toString() {
   		return "EnemyPokemon hp = " + heathPoints + " , attackPoints=" + attackPoints + ",";
   	}

}
