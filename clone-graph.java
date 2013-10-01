/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     ArrayList<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        if(node==null) return null;
        HashMap<UndirectedGraphNode,Integer> h=new HashMap<UndirectedGraphNode,Integer>();
        UndirectedGraphNode cp=new UndirectedGraphNode(node.label);
        Queue<UndirectedGraphNode> q1=new LinkedList<UndirectedGraphNode>();
        Queue<UndirectedGraphNode> q2=new LinkedList<UndirectedGraphNode>();
        ArrayList<UndirectedGraphNode> pre=new ArrayList<UndirectedGraphNode>();
        q1.add(node);q2.add(cp);
        int i=0;
        h.put(node,i++);
        pre.add(cp);
        while(!q1.isEmpty()) {
            UndirectedGraphNode n1=q1.remove(),n2=q2.remove();
            //h.put(n1);
            for(UndirectedGraphNode n:n1.neighbors) {
                if(h.containsKey(n)) {
                    n2.neighbors.add(pre.get(h.get(n)));
                    continue;
                }
                q1.add(n);
                UndirectedGraphNode child=new UndirectedGraphNode(n.label);
                n2.neighbors.add(child);
                //child.neighbors.add(n2);
                q2.add(child);
                h.put(n,i++);
                pre.add(child);
            }
        }
        return cp;
    }
}
