import java.util.Arrays;

public class Path {
	private int size;
	private Obstacle[][] slots;
	
	public void startOrResetGame(int pathSize) {
		this.size = pathSize;
		this.slots = new Obstacle[pathSize][4];
		for(int i = 0;i<this.size;i++) {
			for(Obstacle o: this.slots[i]) {
				o = null;
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
	
	
}
