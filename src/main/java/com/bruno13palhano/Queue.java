package com.bruno13palhano;

public class Queue {
    private final int SIZE = 20;
    private int[] array;
    private int front;
    private int rear;

    public Queue() {
        array = new int[SIZE];
        front = 0;
        rear = -1;
    }

    public void insert(int value) {
        if (rear == SIZE -1)
            rear = -1;

        array[++rear] = value;
    }

    public int remove() {
        int temp = array[front++];
        if (front == SIZE)
            front = 0;

        return temp;
    }

    public boolean isEmpty() {
        return (rear + 1 == front || front+SIZE-1 == rear);
    }
}
