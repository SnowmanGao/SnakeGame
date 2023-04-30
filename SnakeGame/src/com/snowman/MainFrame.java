package com.snowman;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    public MainFrame() throws HeadlessException {
        initFrame();
        initGamePanel();
    }

    private void initGamePanel() {
        JPanel jpanel = new JPanel() {
            @Override
            public void paint(Graphics g) {
                // paint cross lines
                for (int i = 0; i <= 40 * 15; i += 15) {
                    g.drawLine(0, i, 600, i);
                    g.drawLine(i, 0, i, 600);
                }

                // paint snake


                // paint food
            }
        };

        // put the panel into the frame
        add(jpanel);
    }

    private void initFrame() {
        setSize(615, 638);
        setLocation(400, 400);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
    }

    public static void main(String[] args) {
        new MainFrame().setVisible(true);
    }
}