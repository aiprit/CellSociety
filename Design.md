Group 10
============
Parit Burintrathikul (pb111), Nick Groszewski (nrg12), Rob Martorano (rfm21)
----------

### Introduction
The problem that this team is attempting to solve by writing this program is creating a grid of cells that can interact with each other according to a well-defined set of rules.  Our primary design goals are to make an extremely flexible GUI, which will allow for many different types of scroll bars and parameter changing.  Also, we want to be able to run numerous types of different simulations, so we need to make sure the code to do so is flexible.  In order to do this, we need  an individual subclass for the backend implementation of each simulation as well as a subclass for the user interface for each simulation. This means that there will be superclasses that are closed for modification, but open for extension.  Abstraction will be key in making our program as flexible as possible.  We will be trying to make our superclasses rigid, but capable of taking in many different subclasses that are fluid in nature.  We want to make adding a new simulation as easy as possible, by having separate classes of design elements for the UI it will minimalize the amount of time it takes to create a new UI subclass.

### Overview
In order to understand the overview of our program, we need to take a top-down approach.  There are some higher level classes that we are expecting to need.  These are a grid/block controller class, a simulation superclass, a block class, and a user interface superclass.  Each of these classes should work together cohesively, despite dealing with completely different aspects of the program (e.g. front-end, back-end).  In addition to these classes, both the simulation class as well as the UI class will have subclasses specific to the simulation type.
The first class of the program that we will delve into is the simulation class.  Since we are trying to keep our program as flexible as possible, we are going to need to make this an abstract class, only including the bare bones that will be included in every simulation.  Each new modulation can be inserted by simply creating a new subclass that contains whatever rules and parameters are necessary for that particular simulation. This class is more of a back-end developer's job.  The simulation class will provide the rules of each simulation to the block class, so that the next state of each block can be determined before updating the grid in the grid/block controller class.
The next class I will explain is the grid/block controller class.  This class will be responsible for updating the grid depending on the stipulation put into the simulation. It will take in information from the block class (e.g. next state, current state).  It will also be responsible for maintaining the grid information, i.e. its boundaries/edges, numbers of blocks, etc, and call on the blocks to update their status.
The block class will hold the state of each individual block within the grid, its updated state and the state of its nearest neighbors.  The next state of each block will need to be supplied by the simulation classes, since they contain the rules of how to change the blocks. The user interface will have to be abstract since it also needs to be flexible.  The super class will create the basic GUI and simulation view. The subclasses will handle displaying the appropriate options as well as handling user input.
This will allow all of these classes to interact in order to make a cohesive program..  The user interface classes will be at the front end, letting the user play around with whatever options are made available for that specific simulation (e.g. more scroll bars, different number of blocks, etc.).  The different UI elements will have their own classes that control their functionality.  The GUI will be taking in information provided by the grid controller class, which will be updating the simulation at whatever rate the user has supplied.  The grid controller will be updating the GUI based on information provided to each and every block (from the block class), which depends on the rules supplied in the simulation classes.
We also plan to create our own custom button/sliders classes to be called and used in the user interfaces, as they would be easier to access and more tailored to our design than the premade libraries.
![UML Diagram]
(Images/UML.png)




### User Interface
The user interface will be fairly straightforward.  The left portion of the interface will contain the grid, which will be updated at whatever rate the user specifies.  The right portion of the interface will contain all of the specified parameters that can be changed.  For example, it will have rate of simulation, size of grid, scroll bars for whatever parameters a specific simulation might need, and buttons to stop, start, step through, and change the program.
In the case that erroneous situations come up, a JOptionPane warning message will pop up to warn the user.

![UML Diagram]
(Images/Mockup_GUI.png)


### Design Details
Our user interface class will have a dropdown menu to choose between the simulations.  It will also contain any sliders, buttons, and other dropdown menus as made necessary by the simulation being run.  The grid will be shown on this interface.

Our block class will contain the current state of the block, as well as the states of its neighbor blocks.  The states of these blocks will be used in the simulation class to determine what the next states of the blocks should be.  This class will pass its information to the grid controller so that the grid can be updated accordingly.  Since this class deals with only the states of the blocks, there is not much which could be changed due to additional requirements.  I would refer to this class as an information holder which passes its information to other classes, which do whatever they must do to the blocks before updating.

Our grid controller class will control what the grid should look like in the GUI.  This is where we can control how fast/slow we move through the simulations, as well as changing the size of the grid and changing any other parameters that the grid may need.  This class will take the information provided to it from our block class and update accordingly.

The simulation subclasses will contain the rules of each particular simulation.  The super simulation class will simply be choosing between whichever specific simulation is chosen.  The simulation class will be determining the next state of the block in the block class, depending on whatever rules are being used.

Our design can be further explained by showing how to complete the Use Cases:
* To apply rules to the middle cell according to the Game of Life, we must be using the Game of Life simulation subclass (so that the correct rules are being used).  The block class will determine that the cell is not an edge cell, since it has eight neighbors.  Using the simulation subclass, and the information concerning the state of the cell's nearest neighbors, the cell will be determined dead if it doesn't have 2 or 3 live neighbors.  Update the next state of the cell to dead in the block class so the next state can be passed to the grid controller class.
* To apply rules to an edge cell according to the Game of Life, we will follow the same steps as before, but making sure that the block class accounts for the fact that there are only five neighbors.
* To move on to the next generation, we need to use the grid controller class.  The grid controller should already have the entire grid based off of the current state of all of the blocks.  Once these blocks have been updated from the simulation class, we can pass the next states to the grid controller, which can update accordingly.
* To set a simulation parameter, we simply take the value given by the XML file and send it to the fire simulation subclass, which can do whatever it needs to do with it.
* To switch simulations, we need to use the user interface class to change which simulation subclass we are using.

### Design Consideration
The main design consideration that we had was how much information we were going to include in the abstract classes.  We don't want to assume that every simulation will have the same of one thing, and then have to go back and add that parameter to each subclass and remove it from the abstract class just because one simulation doesn't need that parameter.  We are trying to assume as little as possible, so that our code will be as flexible as possible if need be.

### Team Responsibilities
Our front-end work (user interface) will be done by Rob.  The back-end work (simulation, block) will be done by Nick.  The crossover work (grid controller) will be done by Parit.  We will all help as much as possible with each other's work (especially the middle ground so we can ensure that everything fits together nicely).
