package com.snowman;

import java.util.LinkedList;

public class Snake {

    private LinkedList<Node> body;
    private Direction direction = Direction.LEFT;
    private boolean isLiving = true;


    public Snake() {
        initSnake();
    }

    private void initSnake() {

        // create a list as snake
        body = new LinkedList<Node>();

        // create 6 nodes into the list
        body.add(new Node(16, 20));
        body.add(new Node(17, 20));
        body.add(new Node(18, 20));
        body.add(new Node(19, 20));
        body.add(new Node(20, 20));
        body.add(new Node(21, 20));

    }

    public void move() {

        // 判断是否存活
        if (!isLiving) return;

        // 移动蛇蛇
        Node head = body.getFirst();
        switch (direction) {
            /* 注意！linkedlist.add()是追加在尾部的！*/

            case UP -> body.addFirst(new Node(head.getX(), head.getY() - 1));

            case DOWN -> body.addFirst(new Node(head.getX(), head.getY() + 1));

            case LEFT -> body.addFirst(new Node(head.getX() - 1, head.getY()));

            case RIGHT -> body.addFirst(new Node(head.getX() + 1, head.getY()));
        }
        body.removeLast();

        // 判断是否撞墙
        head = body.getFirst();
        final int headX = head.getX();
        final int headY = head.getY();
        if (headX < 0 || headY < 0 || headX >= 40 || headY >= 40) {
            isLiving = false;
        }

        // 判断是否撞到自己
        for (int i = 1; i < body.size(); i++) {
            /* i 从 1 开始，是为了排除自己 */
            Node node = body.get(i);
            if (headX == node.getX() && headY == node.getY()) {
                isLiving = false;
                break;
            }
        }

    }

    public LinkedList<Node> getBody() {
        return body;
    }

    public void setBody(LinkedList<Node> body) {
        this.body = body;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public Direction getDirection() {
        return direction;
    }

    public void eat(Node food) {
        body.addLast(food.copy());
        food.random();
    }
}
