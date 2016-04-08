/*
Clone an undirected graph. Each node in the graph contains a label and a list of its neighbors.
*/

public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {

    if(node == null)
        return null;

    HashSet<UndirectedGraphNode> visited = new HashSet<UndirectedGraphNode>();
    HashMap<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();

    UndirectedGraphNode copyNode = new UndirectedGraphNode(node.label);
    map.put(node, copyNode);
    clone(node, visited, map);
    return copyNode;
}

private void clone(UndirectedGraphNode node, HashSet<UndirectedGraphNode> visited, HashMap<UndirectedGraphNode, UndirectedGraphNode> map) {

    List<UndirectedGraphNode> neighbors = node.neighbors;
    UndirectedGraphNode curNode = map.get(node);
    visited.add(node);
    for(int i = 0; i < neighbors.size(); i++) {
        UndirectedGraphNode neighborNode = neighbors.get(i);
        if(!map.containsKey(neighborNode)) {
            UndirectedGraphNode newNode = new UndirectedGraphNode(neighborNode.label);
            map.put(neighborNode, newNode);
        }
        curNode.neighbors.add(map.get(neighborNode));
        if(!visited.contains(neighborNode))
            clone(neighborNode, visited, map);
    }
}
