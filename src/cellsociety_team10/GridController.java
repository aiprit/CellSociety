package cellsociety_team10;

import java.util.ArrayList;
import java.util.List;

import application.Block;

public class GridController {
	private int sizeX;
	private int sizeY;
	private List<Block> blockList = new ArrayList<>();
	
	public GridController(int x, int y){
		sizeX = x;
		sizeY = y;
	}
	
	public void initAllBlocks(int x , int y, int[][] ar){
		for(int i =0;i<x;i++){
			for(int j = 0 ;j<y;j++){
				createBlock(i,j, ar[i][j]);

			}
		}
				addneighbors();
		
	}
	public void createBlock(int x, int y, int state){
		Block square = new Block(x,y,state);
		blockList.add(square);
	}
	
	public void addneighbors(){
		Block[] array = new Block[8];
		int i = 0;
		for(Block a:blockList){
			for(Block b:blockList){
				if(Math.abs(a.getX()-b.getX()) <=1){
					if(Math.abs(a.getY()-b.getY()) <=1){
						if(!a.equals(b)){
							array[i] = b;
							i++;
						}
					}
				}
			}
			a.setneighbors(array);
			array = new Block[8];
			i = 0;
		}
	}
	
	public void runstepBlock(){
		for(Block a:blockList){
			
		}
	}
	
}
