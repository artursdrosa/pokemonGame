import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		boolean continueGame = true;
		Player player1 = null;
		while (continueGame) {
			System.out.println("\n============You started a new Pokemon Journey!============\n");
			Scanner sc = new Scanner(System.in);
			System.out.print("Chose a name for your character: ");
			player1 = new Player(sc.nextLine());
			int qtdPokemon = 0;
			System.out.println("You can chose 2 pokemon! This are going to be your mates for the rest of your journey! \n");
			while (qtdPokemon != 2) { // Forces the player to have 2 pokemons
				String optPokemon = "";
				while(!optPokemon.equals("charmander") && !optPokemon.equals("squirtle") && !optPokemon.equals("bulbasaur")) {
					System.out.print(qtdPokemon == 0 ? "Write the name of the first pokemon you want to choose:\n":"Write the name of the second pokemon you want to choose:\n");
					System.out.println(
						"Charmander: 1110 HealthPoints, 450 AttackPoints\n"+
						"Squirtle: 1200 HealthPoints, 400 AttackPoints\n"+
						"Bulbasaur: 1500 HealthPoints, 250 AttackPoints"
					);
					optPokemon=sc.nextLine().toLowerCase();
				}
				player1.addPokemon(optPokemon);
				System.out.println("\nYou chose "+player1.getPokemon(qtdPokemon).getName()+", well done!\n");
				qtdPokemon++;
			}
			System.out.println("Your pokemons are: ");
			player1.showPokemons();
			System.out.println("How many lines do you want your path to have (The minimum is 4): ");
	        int lines = 0;
	        Path path = null;

	        while (lines < 4) {
	            try {
	                lines = sc.nextInt();
	                if (lines < 4) {
	                    System.out.println("Please enter a number greater than or equal to 4.");
	                } else {
	                    path = Path.getInstance();
	                    path.startOrResetGame(lines, player1);
	                }
	            } catch (InputMismatchException e) {
	                System.out.println("Invalid input. Please enter a valid integer.");
	                sc.next(); // clear the invalid input
	            } catch (Exception e) {
	                System.out.println("An error occurred: " + e.getMessage());
	            }
	        }

	        System.out.println("Let's start your journey! 'A journey of a thousand miles starts with one footstep...'");
	        while (player1.getPosition(0) < lines) {
	        	System.out.println("Which position do you want to explore? (1 to 4)");
	            path.showPath(player1); 
	            int pos = 0;
	            boolean validPosition = false;
	            while (!validPosition) {
	                try {
	                	if (player1.getPosition(0)!=lines) {
	                		pos = sc.nextInt();
		                    if (pos >= 1 && pos <= 4) {
		                        path.getPlayer().walk(pos);
		                        digSlot(path, sc);
		                        validPosition = true;
		                    } else {
		                        System.out.println("Must be a number between 1 and 4!");
		                    }
	                	}
	                	else {
	                		System.out.println("Congratulations! You completed the path!");
	                		break;
	                	}
	                } catch (InputMismatchException e) {
	                    System.out.println("Invalid input. Must be a number between 1 and 4!");
	                    sc.next(); // clear the invalid input
	                }
	            }
	            System.out.println(player1.getPosition(0));
	            if (player1.getPosition(0) == lines-1) {
	            	path.showPath(player1);
	            	break;
	            }
	        }
			String optContinue = "";
			while(!optContinue.equals("y") && !optContinue.equals("n")) {
				System.out.println("Wanna play more? Y/N");
				optContinue=sc.nextLine().toLowerCase();
			}

			if(optContinue.equals("n"))
				continueGame = false;
		}
	}
	
	public static boolean isEnemy(Path p) { // function to use internally in battles
		int x = p.getPlayer().getPosition(0);
		int y = p.getPlayer().getPosition(1);
		if (p.slots[x][y] instanceof EnemyPokemon) {
			return true;
		}
		return false;
	}
	
	public static void digSlot(Path p, Scanner sc) {
		if(isEnemy(p)) {
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
			while(p.getPlayer().getPokemon(pokeIndex).getHealthPoints()>0 && enemy.getHeathPoints()>0) {
				System.out.println("Which power are you using? \n");
				p.getPlayer().getPokemon(pokeIndex).showPowers();
				int powerIndex = 1;
				while(powerIndex != 2 || powerIndex != 1) {
					powerIndex = -1;
					try {
						powerIndex = sc.nextInt();
					} catch (Exception e) {
						System.out.println("Chose a number between 1 and 2 to chose the power!");
					}
				}
				if (powerIndex == 1)
					p.getPlayer().getPokemon(pokeIndex).power1(enemy);
				else
					p.getPlayer().getPokemon(pokeIndex).power2(enemy);
				if (enemy.getHeathPoints()>0) {
					enemy.attack(p.getPlayer().getPokemon(pokeIndex));
				}
			}
        }
		else { // if is item
			Item item = (Item) p.getObstacle(p.getPlayer().getPosition(0), p.getPlayer().getPosition(1));
			System.out.println("You just found an item!");
			System.out.println(item.toString());
		}
		
	}

}
