package cellsociety_team10;

class Segregation extends Simulation {

	public Segregation (String s) {
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
		 * The rules of the segregation model are as follows.
		 * A cell will be determined "happy" if t% of its neighbors are the same type of cell.
		 * If a cell is determined "happy", it will stay in its location.
		 * If a cell is determined "unhappy", it will be relocated to either:
		 * 1. The closest possible "happy" grid square
		 * 2. Removed from the board if no grid square satisfies the "happy" principle
		 * 3. Moved to a random location on the grid
		 */
	}
	
}
