package com.snowman;

import java.util.LinkedList;

public class Snake {

    private LinkedList<Node> body;
    private Direction direction = Direction.LEFT;


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

        Node head = body.getFirst();

        // 注意！linkedlist.add()是追加在尾部的！
        switch (direction) {
            case UP -> body.addFirst(new Node(head.getX(), head.getY() - 1));
            case DOWN -> body.addFirst(new Node(head.getX(), head.getY() + 1));
            case LEFT -> body.addFirst(new Node(head.getX() - 1, head.getY()));
            case RIGHT -> body.addFirst(new Node(head.getX() + 1, head.getY()));
        }

        body.removeLast();

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
}
