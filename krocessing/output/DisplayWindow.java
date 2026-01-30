package krocessing.output;

import javax.swing.*;
// import java.awt.*;

public class DisplayWindow {
    private JFrame frame;
    private String title;
    private int width;
    private int height;

    
    // Constructors
    public DisplayWindow(String title, int width, int height, boolean visible) {
        this.title = title;
        this.width = width;
        this.height = height;
        frame = new JFrame(title);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(width, height);
        frame.setVisible(visible);
    }
    public DisplayWindow(String title, int width, int height) { this(title, width, height, true); }
    public DisplayWindow(String title) { this(title, 0, 0, false); }

    public void setup(String title, int width, int height) {
        frame = new JFrame(title);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(width, height);
        frame.setVisible(true);
    }

    // Getters
    public JFrame frame() { return frame; }
    public String title() { return title; }
    public int width() { return width; }
    public int height() { return height; }
    public int[] dimensions() { return new int[] { width, height }; }

    // Setters
    public void setTitle(String title) { this.title = title; }
    public void setWidth(int width) { this.width = width; }
    public void setHeight(int height) { this.height = height; }
    public void setDimensions(int width, int height) { this.width = width; this.height = height; }
    public void setDimensions(int[] dimensions) { this.width = dimensions[0]; this.height = dimensions[1]; }
    public void showDisplayWindow() { frame.setVisible(true); }
    public void hideDisplayWindow() { frame.setVisible(false); }
}