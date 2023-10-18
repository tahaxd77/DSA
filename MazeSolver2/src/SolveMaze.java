import javax.imageio.ImageReader;
import javax.naming.spi.DirObjectFactory;
import javax.swing.*;
import java.io.IOException;
import java.util.Currency;
import java.util.Stack;

public class SolveMaze {
    Maze maze;
    Rat rat;
    Stack<Location> stack;

    public SolveMaze(String file) throws IOException {
        maze = new Maze(file);
        stack = new Stack<>();
        rat=new Rat(maze);



        while (!rat.isOut()) {
            Location currentLocation = rat.getLocation();
            if (currentLocation.getY() > 0 && rat.CanMove(Direction.NORTH)) {
                rat.move(Direction.NORTH);
                stack.push(currentLocation);
            }
            else if (currentLocation.getX() < maze.getWidth() - 1 && rat.CanMove(Direction.EAST)) {
                rat.move(Direction.EAST);
                stack.push(currentLocation);
            }
            else if (currentLocation.getY() < maze.getHeight() - 1 && rat.CanMove(Direction.SOUTH)) {
                rat.move(Direction.SOUTH);
                stack.push(currentLocation);
            }
            else if (currentLocation.getX() > 0 && rat.CanMove(Direction.WEST)) {
                rat.move(Direction.WEST);
                stack.push(currentLocation);
            } else {

                if (stack.isEmpty()) {
                    System.out.println("Rat is stuck!!!");
                    maze.print();
                    break;
                }
                rat.setLocation(stack.pop());
                maze.markTried(currentLocation);
            }

            if (rat.isOut()) {
                System.out.println("RAT IS OUT!!!");
                maze.print();
                System.out.println(currentLocation.getX());
                System.out.println(currentLocation.getY());
                System.out.println(rat.getLocation().getX());
                System.out.println(rat.getLocation().getY());
                break;
            }
        }
    }
}