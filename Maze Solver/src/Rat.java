

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
    public Location getLocation() throws CloneNotSupportedException {
        try {
            return location.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }
    public void setLocation(Location location)
    {
        this.location=location;
    }

    public boolean canMove(int direction)
    {
        Location neighbor=location.adjacent(direction);
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


    public  boolean isOutside()
    {

        return this.location.getX()== maze.getWidth()-1&& this.location.getY()== maze.getHeight()-2;
    }

}
