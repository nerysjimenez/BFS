package bfs;

import graph.Edge;
import graph.Graph;
import graph.Vertex;
import java.util.*;

/**
 *  Nerys Jimenez 
 *  The College of Saint Rose
 *  Algorithms, Spring 2017
 *  Implementation of Breadth First Search
 */
public class BFS {
    
    public static void main(String[] args) {
        Graph g = new Graph("nerys.txt");
        int end = 0;
        Vertex s = g.get(1392);
        breadth_first_search(g, s, end);
    }
    /**
     *@param g Graph to be searched
     * @param s Start vertex
     * @param d Destination vertex
    */
    public static void breadth_first_search(Graph g, Vertex s, int d)
    {
        Queue <Vertex> q = new LinkedList <Vertex> ();
        HashMap <Vertex, String> colors = new HashMap <Vertex, String> ();
        HashMap <Vertex, Integer> distances = new HashMap <Vertex, Integer> ();
        HashMap <Vertex, Vertex> parents = new HashMap <Vertex, Vertex> ();
  
        //initializes all the verteces color to white "not visited", distance to infinity and parents to null
        for(Vertex v : g.values())
        {
            colors.put(v, "white");
            distances.put(v, -1);
            parents.put(v, null);
            
        }
        
        //adds the start vertex to the queue, colors it gray, and assigns a distance of 0
        q.add(s);
        colors.put(s, "gray");
        distances.put(s, 0);
        
         /* while the queue is not empty:
            a)get vertex from queue
            b)check if it is white "not visited"
            c)if not visited then add to the queue, update distance, parent and color to gray "visited"
            d)if the edge is the destination vertex then break out of the loop and print path
            e)color dequeued vertex black */
     
        while(!q.isEmpty())
        {
            Vertex x = q.remove();
            
            for(Edge e : x.outEdges())
            {   
                if(colors.get(e.destination()).equals("white"))
                {
                    q.add(e.destination());
                    distances.put(e.destination(), distances.get(x)+1);
                    parents.put(e.destination(), x);
                    colors.put(e.destination(), "gray");
                }
            }
            colors.put(x, "black");
        }
        
        for(Vertex v : g.values()){
            if(v.hashCode() == d){
                System.out.println(v.hashCode() +": "+ distances.get(v));
                break;
            }
        }
            
    }
}
