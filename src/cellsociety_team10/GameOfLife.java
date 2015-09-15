package cellsociety_team10;

class GameOfLife extends Simulation {

	public GameOfLife (String s) {
		mySimulation = s;
	}
	@Override
	public String simulationName() {
		System.out.println(mySimulation);
		return mySimulation;
	}
	@Override
	public void rules() {
		/*
		 * Cells can be alive (1) or dead (0)
		 * Can interact with all 8 neighbors.
		 * 1. Any live cell (1) with fewer than 2 live neighbors dies (under-population)
		 * 2. Any live cell (1) with 2 or 3 neighbors lives on to the next step
		 * 3. Any live cell (1) with more than 3 live neighbors dies (over-population)
		 * 4. Any dead cell (0) with exactly 3 live neighbors becomes live (1) (reproduction)
		 */
		
	}
	
}