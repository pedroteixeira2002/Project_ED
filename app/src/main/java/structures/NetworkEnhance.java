package structures;

import collections.graphs.Network;

public class NetworkEnhance<T> extends Network<T> {

    public NetworkEnhance() {
        super();
    }

    public T getVertex(int index) {
        if (index >= 0 && index < numVertices) {
            return vertices[index];
        } else {
            return null;
        }
    }

}
