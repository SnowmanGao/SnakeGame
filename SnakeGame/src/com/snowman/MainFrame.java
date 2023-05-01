package com.snowman;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Timer;
import java.util.LinkedList;
import java.util.TimerTask;

public class MainFrame extends JFrame {

    private Snake snake;
    private JPanel jpanel;
    private Timer timer;
    private Node food;

    public MainFrame() throws HeadlessException {

        // 初始化窗口属性
        initFrame();

        // 初始化游戏棋盘，设置绘图回调
        initGamePanel();

        // 初始化蛇
        initSnake();

        // 初始化食物
        initFood();

        // 初始化定时器
        initTimer();

        // 设置键盘监听
        setKeyListener();
    }

    private void initFood() {
        food = new Node();
        food.random();
    }

    private void setKeyListener() {
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {

                switch (e.getKeyCode()) {
                    case KeyEvent.VK_UP, KeyEvent.VK_W -> snake.setDirection(Direction.UP);

                    case KeyEvent.VK_DOWN, KeyEvent.VK_S -> snake.setDirection(Direction.DOWN);

                    case KeyEvent.VK_LEFT, KeyEvent.VK_A -> snake.setDirection(Direction.LEFT);

                    case KeyEvent.VK_RIGHT, KeyEvent.VK_D -> snake.setDirection(Direction.RIGHT);
                }

            }
        });
    }


    private void initTimer() {

        timer = new Timer();

        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                snake.move();

                // 判断蛇头是否和食物重合
                final Node head = snake.getBody().getFirst();
                if (head.getX() == food.getX() && head.getY() == food.getY()) {
                    snake.eat(food);
                }

                jpanel.repaint();
            }
        };

        timer.scheduleAtFixedRate(timerTask, 0, 100);
    }


    private void initGamePanel() {

        // 绘图回调函数，在此定义！

        jpanel = new JPanel() {
            @Override
            public void paint(Graphics g) {

                // 清空画面
                g.clearRect(0, 0, 600, 600);

                // 绘制网格线
                for (int i = 0; i <= 40 * 15; i += 15) {
                    g.drawLine(0, i, 600, i);
                    g.drawLine(i, 0, i, 600);
                }

                // 画蛇不添足
                LinkedList<Node> body = snake.getBody();
                int idx = 0, len = body.size();
                for (Node node : body) {
                    g.setColor(Color.BLACK);
                    g.fillRect(15 * node.getX(), 15 * node.getY(), 15, 15);
                    g.setColor(Color.WHITE);
                    g.drawString(String.valueOf(idx), 15 * node.getX(), 15 * node.getY() + 15);
                    idx++;
                }
                {
                    // 绘制蛇蛇调试画面（红蓝和数字）
                    final Node first = body.getFirst();
                    final Node last = body.getLast();
                    g.setColor(Color.RED);
                    g.fillRect(15 * first.getX(), 15 * first.getY(), 15, 15);
                    g.setColor(Color.BLUE);
                    g.fillRect(15 * last.getX(), 15 * last.getY(), 15, 15);
                    g.setColor(Color.WHITE);
                    g.drawString(String.valueOf(0), 15 * first.getX(), 15 * first.getY() + 15);
                    g.drawString(String.valueOf(len), 15 * last.getX(), 15 * last.getY() + 15);
                }

                // 绘制食物
                g.setColor(Color.ORANGE);
                g.fillRect(15 * food.getX(), 15 * food.getY(), 15, 15);
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


    private void initSnake() {
        snake = new Snake();
    }


    public static void main(String[] args) {
        new MainFrame().setVisible(true);
    }
}