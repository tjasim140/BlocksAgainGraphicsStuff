import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class DrawPanel extends JPanel implements MouseListener {

    private int [][] brickLayout;
    private BrickLayout layout;
    public DrawPanel() {
        this.addMouseListener(this);
        long time = System.currentTimeMillis();
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        for(int i=0;i<40;i++){
            for(int j=0; j<30;j++) {
                g.drawRect(10 + (i * 25), 10+(j*25), 20, 20);
                if(brickLayout[j][i]==1) {
                    g2.setColor(Color.pink);
                    g2.fillRect(10 + (i * 25), 10 + (j * 25), 20, 20);
                    g2.setColor(Color.BLACK);
                }
            }
        }

    }

//    public void thirty(){
//        grid = new boolean[30][40];
//        for(int r=0; r<grid.length;r++){
//            for(int c=0; c<grid[0].length;c++){
//                int chance = (int)(Math.random()*10);
//                if (chance<3){
//                    grid[r][c]=true;
//                }
//            }
//        }
//    }

//    public random(){
//        brickLayout = new int [30][40];
//        for(int r=0; r<brickLayout.length;r++){
//            for(int c=0; c<brickLayout[0].length;c++){
//                int chance = (int)(Math.random()*10);
//                if (chance<3){
//                    brickLayout[r][c]=1;
//                }
//            }
//        }
//        return color;
//    }

    @Override
    public void mouseClicked(MouseEvent e) {
        layout.doOneBrick();
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}