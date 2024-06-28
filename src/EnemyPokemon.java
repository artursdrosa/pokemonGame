public class EnemyPokemon extends Obstacle {
    private int heathPoints;
    private int attackPoints;
    
    public EnemyPokemon() {
		double aux = Math.random(); // 0 to 1

        if(aux <= 0.24) { //average enemy
            this.heathPoints = 100;
            this.attackPoints = 50;
        }else
            if(aux>=0.25 && aux<=0.49) { // strongest enemy
                this.heathPoints = 150;
                this.attackPoints = 300;
            }else
                if(aux>=0.5 && aux<=0.75) { //roughest enemy
                this.heathPoints = 500;
                this.attackPoints = 50;
                }else{
                    this.heathPoints = 400; //hardest enemy
                    this.attackPoints = 400;
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
   		return "EnemyPokemon hp = " + heathPoints + " | attackPoints=" + attackPoints + ",";
   	}

}
