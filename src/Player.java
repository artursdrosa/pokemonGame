import java.util.ArrayList;

public class Player {
	private ArrayList<Pokemon> pokemons; // can have 2 pokemons
	private String name;
	private int[] position; // x and y coordinates
	private ArrayList<Item> items;
	
	
	
	public void moveForward() {
		this.position[0] = this.position[0]+1;
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
		if (pokemons.size()>2) { // player can have up to 2 pokemon, so he can select which one he wants to use in battle
			if (name.toLowerCase() == "charmander") { // the pokemon only exists inside the player
				pokemons.add(new Charmander());
			}
		}else {
			throw new ArrayIndexOutOfBoundsException(); // using specific exception 
		}
	}
	
}
