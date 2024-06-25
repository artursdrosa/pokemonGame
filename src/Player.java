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

	public void addPokemon(Pokemon newPokemon) {
		if (pokemons.size()>2) {
			pokemons.add(newPokemon);
		}else {
			throw new ArrayIndexOutOfBoundsException(); // using specific exception 
		}
	}
	
}
