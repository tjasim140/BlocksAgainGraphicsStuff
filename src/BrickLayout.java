
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class BrickLayout {

    private ArrayList<Brick> bricks;
    private int[][] brickLayout;

    public int[][] getBrickLayout() {
        return brickLayout;
    }

    private int cols;

    public BrickLayout(String fileName, int cols, boolean dropAllBricks) {
        this.cols = cols;
        ArrayList<String> fileData = getFileData(fileName);
        bricks = new ArrayList<Brick>();
        for (String line : fileData) {
            String[] points = line.split(",");
            int start = Integer.parseInt(points[0]);
            int end = Integer.parseInt(points[1]);
            Brick b = new Brick(start, end);
            bricks.add(b);
        }
        brickLayout = new int[bricks.size()][cols];
        if (dropAllBricks) {
            while (!bricks.isEmpty()) {
                doOneBrick();
            }
        }else{
            doOneBrick();
        }
    }

    public void doOneBrick() {
       // int r=brickLayout.length-1;
        if (!bricks.isEmpty()) {
            Brick b = bricks.removeFirst();
            // put this brick into the 2D array
            for (int r=brickLayout.length-1;r>=0;r--){
            if (rowIsEmpty(brickLayout[r]) || hasSpace(brickLayout[r], b)) {
                for (int i = b.getStart(); i <= b.getEnd(); i++) {
                    brickLayout[r][i] = 1;
                }
                r=-1;
            }
            }
        }
    }

    public ArrayList<String> getFileData(String fileName) {
        File f = new File(fileName);
        Scanner s = null;
        try {
            s = new Scanner(f);
        }
        catch (FileNotFoundException e) {
            System.out.println("File not found.");
            System.exit(1);
        }
        ArrayList<String> fileData = new ArrayList<String>();
        while (s.hasNextLine())
            fileData.add(s.nextLine());

        return fileData;
    }

    public void printBrickLayout() {
        for (int r = 0; r < brickLayout.length; r++) {
            for (int c = 0; c < brickLayout[0].length; c++) {
                System.out.print(brickLayout[r][c] + " ");
            }
            System.out.println();
        }
    }

    public boolean checkBrickSpot(int r, int c) {
        if (brickLayout[r][c] == 1) {
            return true;
        }
        else {
            return false;
        }
    }
    public boolean rowIsEmpty (int[] row){
        for (int x : row){
            if (x==1){
                return false;
            }
        }
        return true;
    }

    public boolean hasSpace(int[]row,Brick b){
        int start = b.getStart();
        int end = b.getEnd();
        for(int i=start; i<=end; i++){
            if(row[i]==1){
                return false;
            }
        }
        return true;
    }
}

