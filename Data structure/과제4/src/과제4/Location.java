package °úÁ¦4;

public class Location {
	private int x;
	private int y;

	public Location() {
		x = 0;
		y = 0;
	}

	public Location(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getRow() {
		return this.x;
	}

	public int getCol() {
		return this.y;
	}
	
	public String toString(){
		StringBuilder s = new StringBuilder("("+(x+1)+","+(y+1)+")");
		return s.toString();
	}
}
