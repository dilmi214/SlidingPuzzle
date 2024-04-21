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
    private int startRow = -1;
    private int startCol = -1;
    private int finishRow = -1;
    private int finishCol = -1;

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
            int expectedColumns = -1; // Initialize to a negative value
            int startCount = 0;
            int finishCount = 0;

            while ((line = br.readLine()) != null) {
                numberOfVertices++;
                adjacencyList.add(new LinkedList<>());

                // Check if expectedColumns is initialized
                if (expectedColumns == -1) {
                    expectedColumns = line.length(); // Initialize expectedColumns on the first line
                } else {
                    // Validate that the current line has the same number of columns as previous lines
                    if (line.length() != expectedColumns) {
                        throw new IllegalArgumentException("Inconsistent number of columns in the input file");
                    }
                }

                for (int col = 0; col < line.length(); col++) {
                    char c = line.charAt(col);
                    if (c == 'S') {
                        startRow = numberOfVertices - 1;
                        startCol = col;
                        startCount++;
                    } else if (c == 'F') {
                        finishRow = numberOfVertices - 1;
                        finishCol = col;
                        finishCount++;
                    } else if (c != '.' && c != '0') {
                        throw new IllegalArgumentException("Invalid character '" + c + "' in the input file");
                    }
                    if (c == '0') {
                        addEdge(numberOfVertices - 1, col);
                    }
                }
            }
            
                                
            // Validate presence of start and finish symbols
            if (startRow == -1 || startCol == -1) {
                throw new IllegalArgumentException("Start symbol ('S') is missing in the input file");
            }
            if (finishRow == -1 || finishCol == -1) {
                throw new IllegalArgumentException("Finish symbol ('F') is missing in the input file");
            }

            // Validate presence of start and finish symbols
            if (startCount != 1) {
                throw new IllegalArgumentException("Exactly one start symbol ('S') must be present in the input file");
            }
            if (finishCount != 1) {
                throw new IllegalArgumentException("Exactly one finish symbol ('F') must be present in the input file");
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
                if (i == startRow && j == startCol) {
                    System.out.print("S ");
                } else if (i == finishRow && j == finishCol) {
                    System.out.print("F ");
                } else if (adjacencyList.get(i).contains(j)) {
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