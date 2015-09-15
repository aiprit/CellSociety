package cellsociety_team10;

public class SimulationTester {
	public static void main (String[] args) {
		Simulation segregation = new Segregation("Segregation");
		segregation.simulationName();
		
		Simulation fire = new Fire("Fire");
		fire.simulationName();
		
		Simulation predPrey = new PredatorPrey("Predator-Prey");
		predPrey.simulationName();
		
		Simulation gameOfLife = new GameOfLife("Game of Life");
		gameOfLife.simulationName();
	}
}
