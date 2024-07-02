import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		System.out.println("You started your Pokemon Journey!\n");
		Player theo = new Player("theo");
		Scanner sc = new Scanner(System.in);
		int qtdPokemon = 0;
		while (qtdPokemon != 2) { // Forces the player to have 2 pokemons
			int optPokemon = 0;
			while(optPokemon !=3 || optPokemon!=2 || optPokemon!=1) {
				System.out.println("Choose your pokemon:\n"+);
				//tem que fazer uma forma com que eu consiga acessar as infos dos pokemons aqui cpa, ou talvez só digite o nome e as stats dele na mao mesmo fdc
			}

		}
		Path p = Path.getInstance();
		p.startOrResetGame(6, theo);
		//System.out.println(p.toString());
		theo.walk(2);
		p.showPath(theo);
		theo.walk(1);
		p.showPath(theo);
		theo.walk(4);
		p.showPath(theo);

	}
	
	public static void battleEnemy(Path p, Scanner sc) {
		EnemyPokemon enemy = (EnemyPokemon) p.getObstacle(p.getPlayer().getPosition(0), p.getPlayer().getPosition(1));
		System.out.println("An enemy apeared! \n" + enemy.toString() + "\n");
		System.out.println("Chose your pokemon for this battle: \n");
		p.getPlayer().showPokemons();
		int pokeIndex = 1;
		while(pokeIndex != 2 || pokeIndex != 1) {
			pokeIndex = -1;
			try {
				pokeIndex = sc.nextInt();
			} catch (Exception e) {
				System.out.println("Chose a number between 1 and 2 to chose your pokemon!");
			}
		}
		System.out.println("Which power are you using? \n");
		int powerIndex = 1;
		while(pokeIndex != 2 || powerIndex != 1) {
			powerIndex = -1;
			try {
				powerIndex = sc.nextInt();
			} catch (Exception e) {
				System.out.println("Informe um número de 1 a 2 para escolher seu pokemon!");
			}
		}
		if (powerIndex == 1)
			p.getPlayer().getPokemon(pokeIndex).power1(enemy);
		else
			p.getPlayer().getPokemon(pokeIndex).power2(enemy);
		
		
		
	}

}
