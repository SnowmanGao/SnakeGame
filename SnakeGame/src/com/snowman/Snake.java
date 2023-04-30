package com.snowman;

import java.util.LinkedList;

public class Snake {
    private LinkedList<Node> body;

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

    public LinkedList<Node> getBody() {
        return body;
    }

    public void setBody(LinkedList<Node> body) {
        this.body = body;
    }
}
