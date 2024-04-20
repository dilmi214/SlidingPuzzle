/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package study.slidingpuzzle;

import java.util.List;

/**
 *
 * @author Dilmi
 */
public class TestGraphs {
     /**
 * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Create an instance of GraphAdjacencyList
        GraphAdjacencyList graph = new GraphAdjacencyList("Graph");

        // Read the graph from a file
        graph.createGraphFromFile("maze10_4.txt"); // Replace "your_input_file.txt" with the actual file path

        // Print the graph to check if it has been created properly
        graph.printGraph();
    }
}