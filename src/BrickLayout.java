
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class BrickLayout {

    private ArrayList<Brick> bricks;
    private int[][] brickLayout;
    private int height;
    private int cols;

    public BrickLayout(String fileName, int cols, boolean dropAllBricks) {
        this.cols = cols;
        height = 1;
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
//        int x = bricks.size();
//        for (int i = 0; i<x;i++){
//            placeBrick();
//            moveBrick();
//        }
        if (dropAllBricks) {
            while (!bricks.isEmpty()) {
                placeBrick();
            }
        }

    }

    public int[][] getBrickLayout() {
        return brickLayout;
    }

    public void doOneBrick() {
        if (!bricks.isEmpty()) {
            Brick b = bricks.removeFirst();
            // put this brick into the 2D array
            for (int r = 0; r < brickLayout.length; r++){
                if (!hasSpace(r+1, b) && hasSpace(r, b)) {
                    for (int i = b.getStart(); i <= b.getEnd(); i++) {
                        brickLayout[r][i] = 1;
                    }
                    r=brickLayout.length;
                }
            }
        }
    }

    public void placeBrick() {
        if (!bricks.isEmpty()) {
            Brick b = bricks.removeFirst();
            // put this brick into the 2D array
            for (int i = b.getStart(); i <= b.getEnd(); i++) {
                brickLayout[0][i] = 1;
            }
        }
    }

    public void moveBrick() {
        for (int r = brickLayout.length-1; r >=0; r--) {
            for (int c = 0; c < brickLayout[0].length; c++) {
                if (brickLayout[r][c] == 1 && canMoveBrick(r,c)) {
                    brickLayout[r][c]=0;
                    brickLayout[r+1][c]=1;
                }
            }
        }
    }

    public boolean canMoveBrick(int r, int c){
        if (r!=brickLayout.length-1 && brickLayout[r+1][c]!=1){
            return true;
        }
        return false;
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
        System.out.println();
    }

    public boolean checkBrickSpot(int r, int c) {
        if (brickLayout[r][c] == 1) {
            return true;
        }
        else {
            return false;
        }
    }

    public boolean hasSpace(int row,Brick b){
        int start = b.getStart();
        int end = b.getEnd();
        if (row>= brickLayout.length||row<0){
            return false;
        }
        for(int i=start; i<=end; i++){
            if(brickLayout[row][i]==1){
                return false;
            }
        }
        return true;
    }

}

