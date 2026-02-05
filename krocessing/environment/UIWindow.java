package krocessing.environment;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.time.LocalDateTime;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;

public class UIWindow extends JFrame {
      private JSplitPane idePane;
        private JPanel editor;
          private JTextArea codeArea;
            private JScrollPane codeScrollPane;
        private JButton runButton;
      private JPanel output;
        private JScrollPane outputScrollPane;
          private JLabel outputLabel;
          private JTextArea outputArea;

    public UIWindow() { super(); }
    public UIWindow(String title, int width, int height) {
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(width, height);
        this.setVisible(true);
        makeIDE();
        this.revalidate();
    }
    public UIWindow(String title, int width, int height, boolean takeSnapshot) {
        this(title, width, height);
        if (takeSnapshot) {
            BufferedImage img = new BufferedImage(this.getWidth(), this.getHeight(), BufferedImage.TYPE_INT_RGB);
            this.printAll(img.getGraphics());
            try { ImageIO.write(img, "png", new File("assets/krocessing_ui_snapshot.png")); }
            catch (Exception e) { e.printStackTrace(); }
            System.out.println("UI snapshot saved to assets/krocessing_ui_snapshot.png.");
            System.out.println("Exiting Krocessing...\n");
            System.exit(0);
        }
    }

    static { try { UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName()); }
        catch (Exception e) {
            System.err.println("Failed to set system look and feel: " + e.getMessage());
            e.printStackTrace(); }
    }

    public void makeIDE() {
        editor = new JPanel(new BorderLayout(10, 10));
        editor.add(new JLabel("Your Code: "), BorderLayout.PAGE_START);
          codeArea = new JTextArea(10,10); // rows, columns
            codeArea.setLineWrap(false);
            codeArea.setBackground(Color.LIGHT_GRAY);
            codeArea.setFont(new Font("Monospaced", Font.PLAIN, 12));
          codeScrollPane = new JScrollPane(codeArea);
        editor.add(codeScrollPane, BorderLayout.CENTER);
          runButton = new JButton("Run Code");
            runButton.addActionListener(new ActionListener() { public void actionPerformed(ActionEvent e) {
                System.out.printf("Running code:\n%s\n", codeArea.getText());
                String timeNow = LocalDateTime.now().toString();
                outputArea.append("Output:\n" + timeNow.substring(0,10) + "\nCode executed successfully.\n");
            } } );
        editor.add(runButton, BorderLayout.PAGE_END);

        output = new JPanel(new BorderLayout());
          output.setBackground(Color.WHITE);
          outputLabel = new JLabel("Output:");
            outputLabel.setOpaque(true);
            outputLabel.setForeground(Color.BLACK);
            outputLabel.setBackground(Color.WHITE);
          output.add(outputLabel, BorderLayout.PAGE_START);
          outputArea = new JTextArea();
            outputArea.setEditable(false);
            outputArea.setLineWrap(true);
            outputArea.setWrapStyleWord(true);
            outputArea.setFocusable(false);
            outputArea.setBackground(Color.DARK_GRAY);
            outputArea.setForeground(Color.LIGHT_GRAY);
          outputScrollPane = new JScrollPane(outputArea);
          output.add(outputScrollPane, BorderLayout.CENTER);

        idePane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, editor, output);
        this.getContentPane().add(idePane);
    }

}
