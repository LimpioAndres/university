package com.solvd.tasks.linkedList;

class Node<T> {
    private Node<T> prevNode;
    private T value;
    private Node<T> nextNode;

    Node() {}
    Node(T value) {
        this.value = value;
    }

    Node<T> getPrevNode() {
        return prevNode;
    }
    void setPrevNode(Node<T> prevNode) {
        this.prevNode = prevNode;
    }

    T getValue() {
        return value;
    }
    void setValue(T value) {
        this.value = value;
    }

    Node<T> getNextNode() {
        return nextNode;
    }
    void setNextNode(Node<T> nextNode) {
        this.nextNode = nextNode;
    }
}
