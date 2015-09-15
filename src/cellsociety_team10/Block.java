package cellsociety_team10;

public class Block {
	private int blockx;
	private int blocky;
	private int currentstate;
	private int nextstate;
	private Block[] neighbors;
	
	
	public Block(int x , int y, int state){
		blockx = x;
		blocky = y;
		currentstate = state;
	}
	public void setneighbors(Block[] array){
		neighbors = array;
	}
	
	
	public int getState(){
		return currentstate;
	}
	public int getX(){
		return blockx;
	}
	public int getY(){
		return blocky;
	}
}
