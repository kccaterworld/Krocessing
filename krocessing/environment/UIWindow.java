package krocessing.environment;

import javax.swing.*;
import java.awt.*;

public class UIWindow extends JPanel {
    public Graphics2D g2d;
    private JFrame frame;

    public UIWindow() { super(); }
    static {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            System.err.println("Failed to set system look and feel: " + e.getMessage());
            e.printStackTrace();
        }
    }

    /* protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g2d = (Graphics2D) g;
        g2d.setColor(Color.BLUE);
        g2d.fillRect(50, 50, 100, 70);
    } */

    public JPanel makeIDE() {
        JPanel codePanel = new JPanel();
        codePanel.setLayout(new BorderLayout());
        JTextArea codeArea = new JTextArea();
        codeArea.setLineWrap(false);
        JScrollPane codeScrollPane = new JScrollPane(codeArea);
        codePanel.add(codeScrollPane, BorderLayout.CENTER);
        frame.getContentPane().add(codePanel);
        return codePanel;
    }

    public void setup(String title, int width, int height) {
        frame = new JFrame(title);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(width, height);
        frame.setVisible(true);
        frame.add(this);
        makeIDE();
        frame.revalidate();
        // paintComponent(getGraphics());
    }
}
