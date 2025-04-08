import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class DrawPanel extends JPanel implements MouseListener {

    private BrickLayout layout;
    public DrawPanel() {
        this.addMouseListener(this);
        long start = System.currentTimeMillis();
        layout = new BrickLayout("src/bricks", 40, false);
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        for(int i=0;i<40;i++){
            for(int j=0; j<30;j++) {
                g.drawRect(10 + (i * 25), 10+(j*25), 20, 20);
                if (layout.getBrickLayout()[j][i]==1){
                    g2.setColor(Color.PINK);
                    g2.fillRect(10 + (i * 25), 10+(j*25), 20, 20);
                    g2.setColor(Color.BLACK);
                }
            }
        }
    }


    @Override
    public void mouseClicked(MouseEvent e) {
        layout.placeBrick();
        layout.printBrickLayout();
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