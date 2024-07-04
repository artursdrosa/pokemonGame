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
	        	if (player1.getPosition(0)>=0) {
	        		checkAction(path,sc);
	        	}
	        	System.out.println("Which position do you want to explore? (1 to 4)");
	            path.showPath(player1); 
	            int pos = 0;
	            boolean validPosition = false;
	            while (!validPosition) {
	                try {
	                	if (player1.getPosition(0)!=lines) {
	                		pos = sc.nextInt();
		                    if (pos >= 1 && pos <= 4) {
		                    	path.getPlayer().showItems();
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
	            if (player1.getPosition(0) == lines-1) {
	            	path.showPath(player1);
	            	digSlot(path, sc);
	            	break;
	            }
	        }
			String optContinue = "";
			while(!optContinue.equals("y") && !optContinue.equals("n")) {
				System.out.println("Wanna play more? Y/N");
				optContinue=sc.nextLine().toLowerCase();
			}

			if(optContinue.equals("n"))
				System.out.println("Thanks for playing!");
				continueGame = false;
		}
	}
	
	private static void checkAction(Path p,Scanner sc) {
		boolean stop = false;
		int opt = 0;
		while(!stop) {
			System.out.println("Do you want to: ");
			System.out.println(
					"1. Check pokemons current stats \n"
					+ "2. Use item \n"
					+ "3. Try to evolve pokemon \n"
					+ "0. Keep walking \n");
			opt = sc.nextInt();
			if (opt==1) {
				p.getPlayer().showPokemons();
			}else if(opt==2) {
				if (p.getPlayer().hasItems()) {
				System.out.println("Here are your items: \n");
				p.getPlayer().showItems();
				System.out.println("Which item do you want to use? ");
				int itemPick = sc.nextInt();
				System.out.println("In which pokemon?");
				p.getPlayer().showPokemons();
				int pokePick = sc.nextInt();
				p.getPlayer().useItem(pokePick-1, itemPick-1);
				}else {
					System.out.println("You currently do not have items to use!");
				}
			}else if(opt == 3) {
				System.out.println("Which pokemon do you want to try to evolve?");
				p.getPlayer().showPokemons();
				int pokePick = sc.nextInt();
				p.getPlayer().getPokemon(pokePick-1).tryToEvolve();
			}else if (opt == 0) {
				stop = true;
			}
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
		if (isEnemy(p)) {
	        EnemyPokemon enemy = (EnemyPokemon) p.getObstacle(p.getPlayer().getPosition(0), p.getPlayer().getPosition(1));
	        System.out.println("===An enemy appeared!=== \n" + enemy.toString() + "\n");
	        System.out.println("Choose your pokemon for this battle: \n");
	        p.getPlayer().showPokemons();
	        
	        int pokeIndex = -1;
	        while (pokeIndex != 1 && pokeIndex != 2) {
	            System.out.println("Enter 1 or 2 to choose your pokemon:");
	            try {
	                pokeIndex = sc.nextInt();
	                if (pokeIndex != 1 && pokeIndex != 2) {
	                    System.out.println("Invalid input. Please choose a number between 1 and 2.");
	                }
	            } catch (InputMismatchException e) {
	                System.out.println("Invalid input. Please enter a valid integer between 1 and 2.");
	                sc.nextLine(); // clear the invalid input
	            }
	        }
	        
	        while (p.getPlayer().getPokemon(pokeIndex - 1).getHealthPoints() > 0 && enemy.getHeathPoints() > 0) {
	            System.out.println("Which power are you using? \n");
	            p.getPlayer().getPokemon(pokeIndex - 1).showPowers();
	            
	            int powerIndex = -1;
	            while (powerIndex != 1 && powerIndex != 2) {
	                System.out.println("Enter 1 or 2 to choose the power:");
	                try {
	                    powerIndex = sc.nextInt();
	                    if (powerIndex != 1 && powerIndex != 2) {
	                        System.out.println("Invalid input. Please choose a number between 1 and 2.");
	                    }
	                } catch (InputMismatchException e) {
	                    System.out.println("Invalid input. Please enter a valid integer between 1 and 2.");
	                    sc.nextLine(); // clear the invalid input 
	                }
	            }

	            if (powerIndex == 1) {
	                p.getPlayer().getPokemon(pokeIndex - 1).power1(enemy);
	            } else {
	                p.getPlayer().getPokemon(pokeIndex - 1).power2(enemy);
	            }

	            if (enemy.getHeathPoints() > 0) {
	                enemy.attack(p.getPlayer().getPokemon(pokeIndex - 1));
	                System.out.println("Enemy attacked for " + enemy.getAttackPoints() + " damage!");
	            }
	        }
	        p.getPlayer().getPokemon(pokeIndex-1).incrementXp();
	    }
		else { // if is item
			Item item = (Item) p.getObstacle(p.getPlayer().getPosition(0), p.getPlayer().getPosition(1));
			System.out.println("===You just found an item!===");
			System.out.println(item.toString());
			p.getPlayer().collectItem(item);
			System.out.println("This item was added to your item bag, you are able to use it on yout next movemnt.");
		}
		
	}

}
