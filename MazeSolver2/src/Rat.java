import java.util.Objects;
import java.util.Stack;

public class Rat {
    private  Maze maze;
    private Location location;

    public Rat(Maze maze)
    {
        this.maze=maze;
        location=new Location(0,1);
    }
    public Location getLocation()
    {
        return location.clone();
    }
    public void setLocation(Location location)
    {
        this.location=location;
    }

    public boolean CanMove(int direction)
    {
        Location neighbor=location.Adjacent(direction);
        return maze.isOpen(neighbor);
    }
    public boolean OnlyValid(Location location)
    {
        int x=location.getX();
        int y=location.getY();
        return x!=-1 && y!=-1;
    }

    public  void move(int direction)
    {
        location.move(direction);
        maze.markMoved(location);
    }

    public void tried(int direction)
    {
        if(!maze.isOpen(location)){
            maze.markTried(location);}
    }


    public  boolean isOut()
    {

        return this.location.getX()==7&& this.location.getY()==6;
    }

}
