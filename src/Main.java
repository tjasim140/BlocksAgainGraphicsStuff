public class Main {
    public static void main(String[] args) {
        MainFrame frame = new MainFrame("Not Tetris");
        BrickLayout b = new BrickLayout("src/bricks", 40, false);
        b.printBrickLayout();

    }
}