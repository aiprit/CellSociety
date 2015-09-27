Net IDs: nrg12, cds33

We chose to refactor my (nrg12 team 10) render function in the gridPanel class so that it would be easier to change the shape within the grid.
As it was written at the start, it was very inflexible and needed hardcoded values to change the shape.  We need to make different grid classes to
handle the different kinds of shapes, and then have the render function call whatever grid type we are using.  We have not actually implemented these changes, but I now have an idea of how to fix this problem.

Also, we refactored any duplicated code that was simply overlooked in the simulation and block classes.