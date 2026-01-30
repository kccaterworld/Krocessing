package krocessing.environment;

import javax.swing.*;
import java.awt.*;

public class UIWindow extends JPanel {
    public Graphics2D g2d;
    public static void main(String[] args) {
        System.out.println("Krocessing started");
        UIWindow engine = new UIWindow();
        engine.setup("Krocessing", 400, 300);
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g2d = (Graphics2D) g;
        g2d.setColor(Color.BLUE);
        g2d.fillRect(50, 50, 100, 70);
    }

    public void update() {
        g2d.setColor(Color.RED);
    }

    public void setup(String title, int width, int height) {
        JFrame frame = new JFrame(title);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(width, height);
        frame.setVisible(true);
        frame.add(this);
        paintComponent(getGraphics());
    }
}
