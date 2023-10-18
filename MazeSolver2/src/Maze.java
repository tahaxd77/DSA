
import java.io.*;
import java.io.FileReader;
import  java.io.BufferedReader;
import java.io.File;

public class Maze {
    private  int numRows,numCols;
    private  int m,n;
    public int [][] arr;
    public  static  final int OPEN=0,WALL=1,TRIED=2,PATH=3;

    public  Maze(String file) throws IOException {
        File file1 = new File(file);
        file1.createNewFile();
        FileWriter writer=new FileWriter(file1);
        //BufferedWriter bufferedWriter=new BufferedWriter(writer);
        writer.write("11\n" +
                "111111111111\n" +
                "000100100001\n" +
                "101101101101\n" +
                "100000100101\n" +
                "111101111101\n" +
                "100000000000\n" +
                "111111111111");
        writer.close();
        //file1.createNewFile();
        FileReader fileReader = new FileReader(file1);
        BufferedReader reader = new BufferedReader(fileReader);
        n = 0;
        m = 0;

        String line;
        //determining number of rows and columns for the array while reading data from file
        while ((line = reader.readLine()) != null) {
            n++;
            if (line.length() > m) {
                m = line.length();
            }
        }
        reader.close();
        System.out.println(n);
        System.out.println(m);
        //initialize
        arr = new int[n][m];
        reader = new BufferedReader(new FileReader(file1));
        int row = 0;
        //fill the array with data from file
        while ((line = reader.readLine()) != null) {
            for (int col = 0; col < line.length(); col++) {
                char currentChar = line.charAt(col);

                if (currentChar == '0') {
                    arr[row][col] = 0;
                } else {
                    arr[row][col] = 1;
                }
            }
            row++;
        }
        reader.close();

    }
    public void printMaze() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }
    }
    public  boolean isOpen(Location location)
    {
        return arr[location.getY()][location.getX()]==OPEN;
    }
    public  boolean isClosed(Location location)
    {
        return arr[location.getY()][location.getX()]==WALL;
    }

    public void markMoved(Location location)
    {
        arr[location.getY()][location.getX()]=PATH;
    }
    public void markTried(Location location)
    {
        arr[location.getY()][location.getX()]=TRIED;
    }

    public  int getWidth()
    {
        return n;
    }
    public  int getHeight()
    {
        return m;
    }
    public  void print()
    {
        char[] chars={' ','+','?','o'};
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                System.out.print(chars[arr[i][j]]);

            }
            System.out.println();
        }
    }





}
