import java.util.ArrayList;

public class Player {
	private ArrayList<Pokemon> pokemons; // can have 2 pokemons
	private String name;
	private int[] position; // position[0] = line, position[1] = column
	private ArrayList<Item> items;
	
	public void walk(int nextPos) {
		this.position[0] = this.position[0]+1;
		this.position[1] = nextPos;
	}
	
	public Player(String name) {
		this.name = name;
		this.position = new int[2];
		this.position[0] = -1;
		this.position[1] = -1;
	}

	public void showItems() {
		for(Item i: items) {
			System.out.println(i.toString());
		}
	}
	
	public void collectItem(Item item){
		items.add(item);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<Pokemon> getPokemons() {
		return pokemons;
	}

	public void addPokemon(String name) {
		if (pokemons.size()<2) { // player can have up to 2 pokemon, so he can select which one he wants to use in battle
			if (name.toLowerCase() == "charmander") { // the pokemon only exists inside the player
				pokemons.add(new Charmander());
			}else if (name.toLowerCase() == "squirtle") {
				pokemons.add(new Squirtle());
			}else if (name.toLowerCase() == "bulbasaur") {
				pokemons.add(new Bulbasaur());
			}else {
				System.out.println("POKEMON DOES NOT EXIST"); // REMOVER ISSO, EXCESSAO DEVE SER TRATADA NO MAIN
			}
		}else {
			throw new ArrayIndexOutOfBoundsException(); // using specific exception 
		}
	}
	
}
