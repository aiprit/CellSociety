package cellsociety_team10;

class PredatorPrey extends Simulation {

	public PredatorPrey (String s) {
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
		 * Only four locations (up, down, left, right)
		 * Only fish and sharks
		 * Every turn, a fish will move to a random adjacent cell unless all four are occupied.
		 * If a fish survives a set amount of turns and there is an empty adjacent cell, a new fish will be put there
		 * Sharks will eat any adjacent fish.  If there are more than 1, it will choose randomly.
		 * If no fish are adjacent, the shark moves to a random adjacent cell.
		 * If shark survives a set amount of turns and there is an empty adjacent cell, a new shark will be put there
		 */
		
		// as a fish
		
	}
	
}