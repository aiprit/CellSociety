package cellsociety_team10;

public class Tester {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        WrappedBoundedGrid world = new WrappedBoundedGrid(3, 3);
        Location loc = new Location(0,2);
        System.out.println(world.getValidAdjacentLocations(loc));
    }

}
