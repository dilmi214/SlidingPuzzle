package study.slidingpuzzle;


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Dilmi
 */
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class GraphAdjacencyList implements Graph {

    private String graphName = "Unknown";
    private int numberOfVertices = 0;

    private List<List<Integer>> adjacencyList;

    public GraphAdjacencyList(String graphName) {
        this.graphName = graphName;
    }

    @Override
    public String graphName() {
        return graphName;
    }

    @Override
    public int numberOfVertices() {
        return numberOfVertices;
    }

    @Override
    public void addEdge(int sourceVertex, int destinationVertex) {
        adjacencyList.get(sourceVertex).add(destinationVertex);
    }

    @Override
    public void removeEdge(int sourceVertex, int destinationVertex) {
        adjacencyList.get(sourceVertex).remove(Integer.valueOf(destinationVertex));
    }

    @Override
    public void createGraphFromFile(String filename) {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            adjacencyList = new ArrayList<>();
            String line;
            while ((line = br.readLine()) != null) {
                numberOfVertices++;
                adjacencyList.add(new LinkedList<>());
                for (int col = 0; col < line.length(); col++) {
                    if (line.charAt(col) == '0') {
                        addEdge(numberOfVertices - 1, col);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean isAdjacent(int sourceVertex, int destinationVertex) {
        return adjacencyList.get(sourceVertex).contains(destinationVertex);
    }

    @Override
    public void printGraph() {
        System.out.println("Graph: " + graphName + " edges: ");
        for (int srcVertex = 0; srcVertex < numberOfVertices; srcVertex++) {
            for (int destVertex : adjacencyList.get(srcVertex)) {
                System.out.println(srcVertex + " --> " + destVertex);
            }
        }
        System.out.println();
    }

    public void printGraphAsGrid() {
        System.out.println("Graph: " + graphName + " as a grid:");

        for (int i = 0; i < numberOfVertices; i++) {
            for (int j = 0; j < numberOfVertices; j++) {
                if (adjacencyList.get(i).contains(j)) {
                    System.out.print("0 ");
                } else {
                    System.out.print(". ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }

}