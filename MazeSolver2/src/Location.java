public class Location implements Cloneable{

    private int x,y;
    public Location(int x,int y)
    {
        this.x=x;
        this.y=y;
    }
    public  int getX()
    {
        return x;
    }
    public  int getY()
    {
        return y;
    }
    public  void move(int direction)
    {
        switch (direction) {
            case Direction.NORTH -> --y;
            case Direction.EAST -> ++x;
            case Direction.SOUTH -> ++y;
            case Direction.WEST -> --x;
        }
    }
    public  Location Adjacent(int direction)
    {
        return switch (direction) {
            case Direction.NORTH -> new Location(x, y - 1);
            case Direction.EAST -> new Location(x + 1, y);
            case Direction.WEST -> new Location(x - 1, y);
            case Direction.SOUTH -> new Location(x, y + 1);
            default -> null;
        };
    }

    @Override
    public Location clone() {
        try {
            return (Location) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }

    @Override
    public String toString() {
        return "Location{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
