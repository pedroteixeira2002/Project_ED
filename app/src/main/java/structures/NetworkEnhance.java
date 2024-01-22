package structures;

import collections.graphs.Network;
import game.Location;


public class NetworkEnhance<T> extends Network<T> {

<<<<<<< HEAD
    private Object[][] adjMatrix;
=======

    private double[][] adjMatrix;
>>>>>>> 79a7d39c8050dff34ebdcb365900bb7519bfc011

    public NetworkEnhance() {

        super();
    }

    /**
     * Get the index of a vertex
     * @param index
     * @return
     */
    public T getVertex(int index) {
        if (index >= 0 && index < numVertices) {
            return vertices[index];
        } else {
            return null;
        }
    }

<<<<<<< HEAD
    public void expandVertexList() {
        T[] largerVertices = (T[]) new Object[this.vertices.length * 2];

        for (int i = 0; i < numVertices; i++) {
            largerVertices[i] = vertices[i];
        }

        vertices = largerVertices;
    }


    public Location[] getNeighbors(T from) {
        int fromIndex = getIndex(from);
        if (fromIndex == -1) {
            return null;
        }

        
        Location[] neighbors = new Location[adjMatrix[fromIndex].length];
        int numNeighbors = 0;
        for (int i = 0; i < adjMatrix[fromIndex].length; i++) {
            if (adjMatrix[fromIndex][i] != null) {
                neighbors[numNeighbors++] = (Location) vertices[i];
            }
        }

        Location[] neighbors2 = new Location[numNeighbors];
        System.arraycopy(neighbors, 0, neighbors2, 0, numNeighbors);

        return neighbors2;
    }

    public T getEdgeWeight(T from, T to) {
        int fromIndex = getIndex(from);
        int toIndex = getIndex(to);
        if (fromIndex == -1 || toIndex == -1) {
            return null;
        }

        return (T) adjMatrix[fromIndex][toIndex];
    }

    public T[] getVertices(){
        return this.vertices;
    }



}
=======
}
>>>>>>> 79a7d39c8050dff34ebdcb365900bb7519bfc011
