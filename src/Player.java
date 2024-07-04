import java.util.ArrayList;

public class Player {
	private ArrayList<Pokemon> pokemons; // can have 2 pokemons
	private String name;
	private int[] position; // position[0] = line, position[1] = column
	private ArrayList<Item> items;
	
	public void walk(int nextPos) {
		this.position[0] = this.position[0]+1;
		this.position[1] = nextPos-1; // passando para posição fisíca
	}
	
	public Player(String name) {
		this.name = name;
		this.position = new int[2];
		this.position[0] = -1;
		this.position[1] = -1;
		this.items = new ArrayList<Item>();
		this.pokemons = new ArrayList<Pokemon>();
	}
	
	public void backToStart() {
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
	
	public void showPokemons() {
		int i = 0;
		for(Pokemon p:pokemons) {
			i++;
			System.out.println(i+ ". " + p.toString() + "\n");
		}
	}
	
	public Pokemon getPokemon(int i) {
		return this.pokemons.get(i);
	}
	
	public int getPosition(int pos) {
		if(pos <= 1 && pos >=0) {
			return this.position[pos];
		}
		else {return -2;} // -2 por que é uma posição que não existe
	}
	public void addPokemon(String name) {
		if (pokemons.size()<2) { // player can have up to 2 pokemon, so he can select which one he wants to use in battle
			if (name.equals("charmander")) { // the pokemon only exists inside the player
				pokemons.add(new Charmander());
			}else if (name.equals("squirtle")) {
				pokemons.add(new Squirtle());
			}else if (name.equals("bulbasaur")) {
				pokemons.add(new Bulbasaur());
			}
		}else {
			throw new ArrayIndexOutOfBoundsException(); // using specific exception 
		}
	}
	
}
