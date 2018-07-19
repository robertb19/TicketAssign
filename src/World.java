public class World {

    static int[][] world;

    public World(int worldsize){
        world = new int[worldsize][worldsize];
    }

    public static int[][] getWorld() {
        return world;
    }

    public void setWorld(int[][] world) {
        this.world = world;
    }
}
