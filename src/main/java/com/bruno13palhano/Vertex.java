package com.bruno13palhano;

public class Vertex {
    public char label;
    public Item item;
    public boolean wasVisited;

    public Vertex(char label, Item item) {
        this.label = label;
        this.item = item;
        wasVisited = false;
    }
}
