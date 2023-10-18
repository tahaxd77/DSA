import java.io.*;
import java.util.Scanner;

public class Maze {
    private int m,n;
    private int [][] a;
    private static final int WALL = 1;
    private static final int OPEN = 0;
    private static final int TRIED = 2;
    private static final int PATH = 3;

    public Maze(String file) throws IOException {
        // read the maze from the file
        Scanner scanner = new Scanner(new File(file));
        m= 7;
        n= 12;
        a = new int[7][12];
        int row =0;
        BufferedReader reader = new BufferedReader(new FileReader("maze.txt"));

        String s;
        while((s=reader.readLine())!=null){
            char c= scanner.next().charAt(0);
            for(int col = 0; col<s.length();col++){
                char currentChar = s.charAt(col);
                if(currentChar == '0'){
                    a[row][col] = 0;
                }
                else{
                    a[row][col] = 1;
                }

            }
            row++;
        }
        reader.close();

        }

    public boolean isOpen(Location location){
        return a[location.getY()][location.getX()] == OPEN;
    }
    public void markTried(Location location){
        a[location.getY()][location.getX()] = TRIED;
    }
    public void markMoved(Location location){
        a[location.getY()][location.getX()] = PATH;
    }
    /*public boolean isOutside(Location location){
        return location.getX() == 0 || location.getX() == m-1 || location.getY() == 0 || location.getY() == n-1;
    }*/
    public int getWidth(){
        return n;
    }
    public int getHeight(){
        return m;
    }
    public void print(){
        char[] chars = {' ','+','?','o'};
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                System.out.print(chars[a[i][j]]);
            }
            System.out.println();
        }
    }
}
