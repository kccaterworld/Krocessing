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

    public void makeIDE() {
        JPanel editor = new JPanel(new BorderLayout(10, 10));
        editor.add(new JLabel("Your Code: "), BorderLayout.PAGE_START);
          JTextArea codeArea = new JTextArea(10,10); // rows, columns
          codeArea.setLineWrap(false);
          codeArea.setBackground(Color.LIGHT_GRAY);
          codeArea.setFont(new Font("Monospaced", Font.PLAIN, 12));
            JScrollPane codeScrollPane = new JScrollPane(codeArea);
        editor.add(codeScrollPane, BorderLayout.CENTER);
        editor.add(new JButton("Run Code"), BorderLayout.PAGE_END);

        JPanel output = new JPanel(new BorderLayout(10, 10));
        output.setLayout(new BorderLayout());
        output.setBackground(Color.DARK_GRAY);
        JLabel outputLabel = new JLabel("Output:");
        outputLabel.setForeground(Color.WHITE);
        output.add(outputLabel, BorderLayout.PAGE_START);

        JSplitPane idePane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, editor, output);
        frame.getContentPane().add(idePane);
    }

    public void setup(String title, int width, int height) {
        frame = new JFrame(title);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(width, height);
        frame.setVisible(true);
        frame.add(this);
        makeIDE();
        frame.revalidate();
    }
}
