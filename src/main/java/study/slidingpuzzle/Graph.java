/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package study.slidingpuzzle;

/**
 *
 * @author Dilmi
 */
public interface Graph {
    
    public String graphName() ; 

    public int numberOfVertices() ; 

    public void addEdge( int srcVertex, int destVertex ) ;

    public void removeEdge( int srcVertex, int destVertex ) ;

    public boolean isAdjacent(int srcVertex, int destVertex ) ;

    public void createGraphFromFile( String filename ) ;

    public void printGraph() ;
}
