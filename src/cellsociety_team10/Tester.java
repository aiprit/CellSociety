package cellsociety_team10;

public class Tester {

    public static void main(String[] args) {
        WrappedBoundedGrid<Location> world = new WrappedBoundedGrid<Location>(3,3);
        Location loc = new Location(0,1);
        System.out.println(world.getValidAdjacentLocations(loc));
    }

}