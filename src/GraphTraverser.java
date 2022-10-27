import java.util.ArrayList;
import java.util.Queue;

public class GraphTraverser {

    public static void depthFirstTraversal(Vertex start, ArrayList<Vertex> visitedVertices) {
        System.out.println(start.getData());

        for (Edge e : start.getEdges()) {
            Vertex neighbor = e.getEnd();

            if (!visitedVertices.contains(neighbor)) {
                visitedVertices.add(neighbor);
                GraphTraverser.depthFirstTraversal(neighbor, visitedVertices);
            }
        }
    }

    public static void breadthFirstSearch(Vertex start, ArrayList<Vertex> visitedVertices) {
        myQueue visitQueue = new myQueue() {};
        visitQueue.enqueue(start);
        while (!visitQueue.isEmpty()) {
            Vertex current  = visitQueue.dequeue();
            System.out.println(current.getData());

            for (Edge e : current.getEdges()) {
                Vertex neighbor = e.getEnd();
                if (!visitedVertices.contains(neighbor)) {
                    visitedVertices.add(neighbor);
                    visitQueue.enqueue(neighbor);
                }
            }
        }

    }

    public static void main(String[] args) {
        TestGraph test = new TestGraph();
        Vertex startingVertex = test.getStartingVertex();
        ArrayList<Vertex> visitedVertices = new ArrayList<>();
        visitedVertices.add(startingVertex);

        GraphTraverser.breadthFirstSearch(startingVertex, visitedVertices);


    }

}
