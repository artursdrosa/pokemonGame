
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Player theo = new Player();
		Path p = Path.getInstance();
		p.startOrResetGame(6, theo);
		System.out.println(p.toString());
	}

}
