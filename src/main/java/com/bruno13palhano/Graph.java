package com.bruno13palhano;

public class Graph {
    private final int MAX_VERTICES = 20;
    private Vertex vertexList[];
    private int adjMat[][];
    private int nVertices;
    private Stack stack;
    private Queue queue;

    public Graph() {
        vertexList = new Vertex[MAX_VERTICES];
        adjMat = new int[MAX_VERTICES][MAX_VERTICES];
        nVertices = 0;

        for (int i = 0; i < MAX_VERTICES; i++) {
            for (int j = 0; j < MAX_VERTICES; j++)
                adjMat[i][j] = 0;
        }

        stack = new Stack();
        queue = new Queue();
    }

    public void addVertex(char label, Item item) {
        vertexList[nVertices++] = new Vertex(label, item);

        item.successorsIndices.forEach(id -> {
            if (id != -1) addEdge(item.index, id);
        });
    }

    public void addEdge(int start, int end) {
        adjMat[start][end] = 1;
        adjMat[end][start] = 1;
    }

    public void displayVertex(int v) {
        System.out.print(vertexList[v].label);
    }

    //depth-first search
    public void dfs() {
        vertexList[0].wasVisited = true;
        displayVertex(0);
        stack.push(0);

        while (!stack.isEmpty()) {
            int vertex = getAjdUnvisitedVertex(stack.peek());

            if (vertex == -1) {
                stack.pop();
            } else {
                vertexList[vertex].wasVisited = true;
                displayVertex(vertex);
                stack.push(vertex);
            }
        }

        for (int i = 0; i < nVertices; i++) {
            vertexList[i].wasVisited = false;
        }
    }

    //breadth-first search
    public void bfs() {
        vertexList[0].wasVisited = true;
        displayVertex(0);
        queue.insert(0);

        int vertex2;

        while (!queue.isEmpty()) {
            int vertex1 = queue.remove();

            while ((vertex2 = getAjdUnvisitedVertex(vertex1)) != -1) {
                vertexList[vertex2].wasVisited = true;
                displayVertex(vertex2);
                queue.insert(vertex2);
            }
        }

        for (int i = 0; i < nVertices; i++) {
            vertexList[i].wasVisited = false;
        }
    }

    //minimum spanning tree
    public void mst() {
        vertexList[0].wasVisited = true;
        stack.push(0);

        while (!stack.isEmpty()) {
            int currentVertex = stack.peek();
            int vertex = getAjdUnvisitedVertex(currentVertex);

            if (vertex == -1) {
                stack.pop();
            } else {
                vertexList[vertex].wasVisited = true;
                stack.push(vertex);

                displayVertex(currentVertex);
                displayVertex(vertex);
                System.out.print(" ");
            }
        }

        for (int i = 0; i < nVertices; i++) {
            vertexList[i].wasVisited = false;
        }
    }

    public int getAjdUnvisitedVertex(int vertex) {
        for (int i = 0; i < nVertices; i++)
            if (adjMat[vertex][i] == 1 && !vertexList[i].wasVisited)
                return i;

        return -1;
    }

    public Vertex getVertex(int index) {
        return vertexList[index];
    }
}
