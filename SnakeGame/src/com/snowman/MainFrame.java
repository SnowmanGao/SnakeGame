package com.snowman;

import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;

public class MainFrame extends JFrame {

    private Snake snake;

    public MainFrame() throws HeadlessException {

        // 初始化窗口属性
        initFrame();

        // 初始化游戏棋盘
        initGamePanel();

        // 初始化蛇
        snake = new Snake();
    }

    private void initGamePanel() {
        JPanel jpanel = new JPanel() {
            @Override
            public void paint(Graphics g) {

                // 绘制网格线
                for (int i = 0; i <= 40 * 15; i += 15) {
                    g.drawLine(0, i, 600, i);
                    g.drawLine(i, 0, i, 600);
                }

                // 画蛇不添足
                LinkedList<Node> body = snake.getBody();
                for (Node node : body) {
                    g.fillRect(15 * node.getX(), 15 * node.getY(), 15, 15);

                }

                // 绘制食物

            }
        };

        // 将 panel 加入 frame 并显示
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