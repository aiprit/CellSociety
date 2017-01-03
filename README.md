# Cell Society

By Parit Burintrathikul, Rob Martorano, Nick Groszewski

This project is a build of Cellular Automata, using JavaFX. It was done as part of a course in Software Design (CS 308) at Duke University taught by Robert Duvall during Spring 2015.

Cellular Automata are simulations based on a model that consists of a regular grid of cells, each in one of a finite number of states (such as on and off). Simulations start with all cells in an initial state and are run by updating each cell based on a set of fixed rules described in terms of the cell's current state and the states of its immediate neighbors. Though this model is simply described, it can be used to simulate a wide variety of complex phenomena, such as ant foraging and economic theory. In fact, after 20 years of study, Stephen Wolfram declared CA were a universal mechanism for moving scientific study forward in his 1280 page book A New Kind of Science that contains hundreds of example models. (taken from https://www.cs.duke.edu/courses/compsci308/fall16/assign/02_cellsociety/)

The program is fully built with its own GUI and users can free choose and select each simulation and its parameters.

Implemented Simulations include:
 - PredatorPrey: Simulation of predator and prey in an area, the cycle of population between prey and predator
 - ForagingAnts: Simulation of ants foraging, ants would eventually learn where food are and move accordingly
 - SpreadingFire: Simulation of Fire spreading over flammable/nonflammables
 - Segregation: Simulation of self-segregation betweeen two different groups of units
 - GameofLife: Recreation of John Conway's Game of Life

Further extensions to the core program includes:
 - Adding graphs