public class Direction {
    public static final int NORTH = 0;
    public static final int SOUTH = 1;
    public static final int EAST  = 2;
    public static final int WEST  = 3;

    private int direction;
    public Direction(int d){
        if(d<0 || d>3){
            throw new IllegalArgumentException();
        }
        direction = d;
    }
    public int getDirection(){
        return direction;
    }

}
