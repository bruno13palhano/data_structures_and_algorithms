package com.bruno13palhano;

public class Stack {
    private final int SIZE = 20;
    private int[] elements;
    private int top;

    public Stack() {
        elements = new int[SIZE];
        top = -1;
    }

    public void push(int item) {
        elements[++top]  = item;
    }

    public int pop() {
        return elements[top--];
    }

    public int peek() {
        return elements[top];
    }

    public boolean isEmpty() {
        return top == -1;
    }
}
