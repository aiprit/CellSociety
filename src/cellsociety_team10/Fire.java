package cellsociety_team10;

class Fire extends Simulation {

	public Fire (String s) {
		mySimulation = s;
	}
	@Override
	public String simulationName() {
		System.out.println(mySimulation);
		return "mySimulation";
	}
	@Override
	public void rules() {
		/*
		 * Three different values for the trees.
		 * 0. empty cell or burnt tree
		 * 1. non-burning tree
		 * 2. tree that is on fire
		 * Assume surrounding cells (outside of boundary) are empty (0)
		 * Only looking up, down, left, and right
		 * Empty cells remain empty.
		 * If a tree grows, it may or may not burn in the next step
		 * A tree on fire burns down in one step, leaving an empty cell
		 * probCatch = probability that a neighboring tree will go on fire if neighbor is burning
		 */
	}
	
}