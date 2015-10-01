# Simulation API

### Block
    Constructor Block()
    Color getColor()- get colors of block
    setColor()-
    int getDirection()-
    setDriection(int newDirection)-
    Grid<Block> getGrid()-
    Location getLocation()-
    pubSelfInGrid(Grid<Block>grid , Location loc)
    removeSelfFromGrid()-
    moveTo(Location)-
    act()-
    String toString()
    char getChar()
    tryMove()

### Location
    Constructor Location(int row, int column)
    int getRow
    int getColumn
    Location getAdjacentLocation(int direction)
    int getDirectionToward(Location target)
    int equals(Object other)
    int hashCode
    int compareTo
    String toString()
### AbstractGrid
    List<E> getNeighbors(Location loc)
    List<Location> getValidAdjacentLocations(Location loc)
    List<Location> getEmptyAdjacentLocations(Location loc)
    List<Location> getValidCompassLocations(Location loc)
    List<Location> getEmptyAdjacentLocations(Location loc)
    List<Location> getOccupiedAdjacentLocations(Location loc)
    String toString()
    List<Location> getAllEmptyLocations()
    boolean isValid(Location loc)
    List<Location> getOccupiedLocations()
    E get(Location loc)
    E put(Location loc, E obj)
    E remove(Location loc)

### AbstractSimulation
    Constructor AbstractSimulation(Parameters parameter)
    List<String> get_param_list()
    void loopToPlace(int num, boolean place)
    Block chooseBlock(boolean placeBlock);
    populateDefinite(int num1, int num2);
    populateIndefinite(int num1, int num2)
    populateWorld(double fraction1, double fraction2)
    step()
    Color getColor(int row, int col)
    Color getEmptyColor()
    int getNumSpots()
    int getNumRows
    int getNumCols()
    String toString()





Configuration API

### Parameters
    Constructor Parameters()
    List<String> get_param_list()
    Map<String, Double>  get_param_map()
    String get_grid_type()
    set_grid_type(String s)
    set_blue_line(String blue_line)
    String get_blue_line()
    set_orange_line(String blue_line)
    String get_orange_line()
    public AbstractSimulation get_sim()

### Parser
    Constructor Parser()
    Constructor Parser(String file_name)
    List<Parameters> get_param_list()
    void document_reader_setup(File xml_file)
    AbstractSimulation parse()
    String get_blue()
    String get_orange()









Visualization API


### Graphic_Handler
    set_up_scene()
    step(double delay)
    change_rate(double dub)
    Scene scene_creation()

### User_Interface
    Constructor User_Interface()
    set_up_base_scene(Group basic)
    outer_border_set_up()
    control_panel_set_up()
    add_elements_to_pane()
    GridPanel get_panel()
    ChartPanel get_chart_panel()
    boolean get_status()
    double change_rate()


### ChartPanel
    ChartPanel(int row)
    Canvas get_canvas()
    void chart_handler(double sum1, double sum2)
