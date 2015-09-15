Group 10
============   
Parit Burintrathikul (pb111), Nick Groszewski (nrg12), Rob Martorano (rfm21)
----------

###Introduction
The problem that this team is attempting to solve by writing this program is creating a grid of cells that can interact with each other according to a well-defined set of rules.  Our primary design goals are to make an extremely flexible GUI, which will allow for many different types of scroll bars and parameter changing.  Also, we want to be able to run tons of different simulations, so we need to make sure the code to do so is flexible.  In order to do this, we need subclasses for each simulation type and user interface.  This means that there will be superclasses that are closed for modification, but open for extension.  Abstraction will be key in making our program as flexible as possible.  We will be trying to make our superclasses rigid, but capable of taking in many different subclasses that are fluid in nature.  

###Overview  
In order to understand the overview of our program, we need to take a top-down approach.  There are some higher level classes that we are expecting to need.  These are a grid controller class, a simulation class, a block class, and user interface classes.  Each of these classes should work together cohesively, despite dealing with completely different aspects of the program (e.g. front-end, back-end).  
The first class of the program that I will delve into is the simulation class.  Since we are trying to keep our program as flexible as possible, we are going to need to make this an abstract class, only including the bare bones that will be included in every simulation.  Each new modulation can be inserted by simply creating a new subclass that contains whatever rules and parameters are necessary for that particular simulation.  This class is more of a back-end developer's job.  
The next class I will explain is the grid controller class.  This class will be responsible for updating the grid depending on the stipulation put into the simulation.  
The block class will hold the state of each individual block within the grid, as well as the state of its nearest neighbors.  The next state of each block will need to be supplied by the simulation classes, since they contain the rules of how to change the blocks.  
The user interface will have to be abstract since it also needs to be flexible.  There will need to be a class to actually make the GUI, and another class to deal with the functionality of the user interface.  
The way that all of these classes interact in order to make a cohesive program is as follows.  The user interface classes will be at the front end, letting the user play around with whatever options are made available for that specific simulation (e.g. more scroll bars, different number of blocks, etc.).  The GUI will be taking in information provided by the grid controller class, which will be updating the simulation at whatever rate the user has supplied.  The grid controller will be updating the GUI based on information provided to each and every block (from the block class), which depends on the rules supplied in the simulation classes.  

###User Interface
The user interface will be fairly straightforward.  The top portion of the interface will contain the grid, which will be updated at whatever rate the user specifies.  The bottom portion of the interface will contain all of the specified parameters that can be changed.  For example, it will have rate of simulation, size of grid, scroll bars for whatever parameters a specific simulation might need, and buttons to stop, start, step through, and change the program.  
In the case that erroneous situations come up, a JOptionPane warning message will pop up to warn the user.

###Design Details
(Explain user interface classes in detail here)

Our block class will contain the current state of the block, as well as the states of its neighbor blocks.  The states of these blocks will be used in the simulation class to determine what the next states of the blocks should be.  This class will pass its information to the grid controller so that the grid can be updated accordingly.  Since this class deals with only the states of the blocks, there is not much which could be changed due to additional requirements.  I would refer to this class as an information holder which passes its information to other classes, which do whatever they must do to the blocks before updating.  

Our grid controller class will control what the grid should look like in the GUI.  This is where we can control how fast/slow we move through the simulations, as well as changing the size of the grid and changing any other parameters that the grid may need.  This class will take the information provided to it from our block class and update accordingly.

The simulation subclasses will contain the rules of each particular simulation.  The super simulation class will simply be choosing between whichever specific simulation is chosen.  The simulation class will be determining the next state of the block in the block class, depending on whatever rules are being used.

Our design can be further explained by showing how to complete the Use Cases:  
* To apply rules to the middle cell according to the Game of Life, we must be using the Game of Life simulation subclass (so that the correct rules are being used).  The block class will determine that the cell is not an edge cell, since it has eight neighbors.  Using the simulation subclass, and the information concerning the state of the cell's nearest neighbors, the cell will be determined dead if it doesn't have 2 or 3 live neighbors.  Update the next state of the cell to dead in the block class so the next state can be passed to the grid controller class.
* To apply rules to an edge cell according to the Game of Life, we will follow the same steps as before, but making sure that the block class accounts for the fact that there are only five neighbors.
* To move on to the next generation, we need to use the grid controller class.  The grid controller should already have the entire grid based off of the current state of all of the blocks.  Once these blocks have been updated from the simulation class, we can pass the next states to the grid controller, which can update accordingly.
* To set a simulation parameter, we simply take the value given by the XML file and send it to the fire simulation subclass, which can do whatever it needs to do with it.
* To switch simulations, we need to use the user interface class to change which simulation subclass we are using.

###Design Consideration
The main design consideration that we had was how much information we were going to include in the abstract classes.  We don't want to assume that every simulation will have the same of one thing, and then have to go back and add that parameter to each subclass and remove it from the abstract class just because one simulation doesn't need that parameter.  We are trying to assume as little as possible, so that our code will be as flexible as possible if need be.  

###Team Responsibilities
Our front-end work (user interface) will be done by Rob.  The back-end work (simulation, block) will be done by Nick.  The crossover work (grid controller) will be done by Parit.  We will all help as much as possible with each other's work (especially the middle ground so we can ensure that everything fits together nicely).  