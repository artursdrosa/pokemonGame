public class Path {
	private int size;
	private Obstacle[][] slots;
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
		this.setPlayer(player);
		this.size = pathSize;
		this.slots = new Obstacle[pathSize][4];
		ObstacleFactory factory = new ObstacleFactory();
		for(int i = 0;i<this.size;i++) {
			for(Obstacle o: this.slots[i]) {
				o = factory.createObstacle();
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
		String result = "Path [size=" + size + "]";
		for(int i = 0;i<this.size;i++) {
			for(Obstacle o: this.slots[i]) {
				result += " | " + o.toString();
			}
		}
		return result;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}
}
