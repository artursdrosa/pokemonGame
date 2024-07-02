public class Path {
	private int size;
	public Obstacle[][] slots;
	private Player player;
	private static Path instance; // part of the singleton implementation
	
	private Path() {}
	
	public static Path getInstance() { // implementing singleton
		if (instance == null) {
			instance = new Path();
		}
		return instance;
	}
	
	public void startOrResetGame(int pathSize, Player player) {
		this.player = player;
		this.size = pathSize;
		this.slots = new Obstacle[pathSize][4];
		ObstacleFactory factory = new ObstacleFactory();
		for(int i = 0;i<this.size;i++) {
			for (int j = 0; j < 4; j++) {
				slots[i][j] = factory.createObstacle();
			}
		}
	}
	
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	@Override
	public String toString() {
		String result = "Path [size=" + size + "] \n";
		int cont = 0;
		for(int i = 0;i<this.size;i++) {
			result += "\n";
			for(Obstacle o: this.slots[i]) {
				cont++;
				result += " | " + o.toString();
			}
		}
		System.out.println(cont);
		return result;
	}
	
	public void showPath(Player p) {
		for(int i = 0;i<this.size;i++) {
			for (int j = 0; j < 4; j++) {
				if (j%4==0 && i!=0) {
					System.out.println("");
				}
				if (p.getPosition(0) == i && p.getPosition(1) == j) {
					System.out.print("[X]");
				}else {
					System.out.print("|^|");
				}
				
			}
		}
		System.out.println("\n");
	}

	public Player getPlayer() {
		return player;
	}

	public Obstacle getObstacle(int x, int y){
		return this.slots[x][y];
	}
	
}
