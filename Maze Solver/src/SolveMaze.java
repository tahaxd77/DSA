import java.io.IOException;
import java.util.Stack;
import java.io.FileNotFoundException;

public class SolveMaze {
    Maze maze;
    Rat rat;
    Stack stack;

    public SolveMaze(String file) throws IOException, CloneNotSupportedException {
        maze = new Maze(file);
        rat = new Rat(maze);
        stack = new Stack();

        while (!rat.isOutside()) {
            Location currentLocation = rat.getLocation();
            if (currentLocation.getY() > 0 && rat.canMove(Direction.NORTH)) {
                rat.move(Direction.NORTH);
                stack.push(currentLocation);

            } else if (currentLocation.getX() < maze.getWidth() - 1 && rat.canMove(Direction.EAST)) {
                rat.move(Direction.EAST);
                stack.push(currentLocation);

            } else if (currentLocation.getY() < maze.getHeight() - 1 && rat.canMove(Direction.SOUTH)) {
                rat.move(Direction.SOUTH);
                stack.push(currentLocation);

            } else if (currentLocation.getX() > 0 && rat.canMove(Direction.WEST)) {
                rat.move(Direction.WEST);
                stack.push(currentLocation);
            } else {


                    if (stack.isEmpty()) {
                        System.out.println("RAT IS STUCK!!!");
                        maze.print();
                        break;
                   }
                maze.markTried(currentLocation);
                rat.setLocation((Location) stack.pop());
                }
                if (rat.isOutside()) {
                    System.out.println("RAT IS OUT!!!");
                    maze.print();
                    //System.out.println(currentLocation.getX());
                    //System.out.println(currentLocation.getY());
                    break;
                }
            }
        }




}
