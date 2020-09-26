//package Graph;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class Main
{
    static void addEdge(ArrayList<ArrayList<Integer>>graph, int edge1, int edge2)
    {
        graph.get(edge1).add(edge2);
        graph.get(edge2).add(edge1);
    }

    static void DFS_Recursive(ArrayList<ArrayList<Integer>>graph, int source, boolean[] visited)
    {
        visited[source] = true;

        for (int i : graph.get(source)) if (!visited[i]) DFS_Recursive(graph,i,visited);
    }

    static int DFS(ArrayList<ArrayList<Integer>>graph, int vertices)
    {
        boolean[] visited = new boolean[vertices+1];
        int count = 0;

        for (int i=1;i<=vertices;i++)
        {
            if (!visited[i])
            {
                count++;
                DFS_Recursive(graph,i,visited);
            }
        }

        return count;
    }

    public static void main(String[] args)
    {
        Scanner fr = new Scanner(System.in);

        int vertices = fr.nextInt();
        int edges = fr.nextInt();

        ArrayList<ArrayList<Integer>>graph = new ArrayList<>();
        for (int i=0;i<vertices+1;i++) graph.add(new ArrayList<>());

//        addEdge(graph,0,1);
//
//        addEdge(graph,2,4);
//        addEdge(graph,2,3);
//
//        addEdge(graph,5,5);

        for(int i=1;i<=edges;i++) addEdge(graph,fr.nextInt(),fr.nextInt());

        System.out.print(DFS(graph,vertices)-1);
    }
}
