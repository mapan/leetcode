public class Solution {
    HashMap<Integer, UndirectedGraphNode> map;
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) 
            return null;
        map = new HashMap<Integer, UndirectedGraphNode>();
        return clone(node);
    }
    public UndirectedGraphNode clone(UndirectedGraphNode node) {
        if (map.containsKey(node.label)) 
            return map.get(node.label);
        UndirectedGraphNode c = new UndirectedGraphNode(node.label);
        map.put(node.label, c);
        for (UndirectedGraphNode n: node.neighbors) {
            c.neighbors.add(clone(n));
        }
        return c;
    }
}

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
        h.put(node,i++);  h.put(node,cp);
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

        h.put(node,cp);
        while(!q1.isEmpty()) {
            UndirectedGraphNode n1=q1.remove(),n2=q2.remove();
            for(UndirectedGraphNode n:n1.neighbors) {
                if(h.containsKey(n)) {
                    n2.neighbors.add(h.get(n));
                    continue;
                }
                q1.add(n);
                UndirectedGraphNode child=new UndirectedGraphNode(n.label);
                n2.neighbors.add(child);
                q2.add(child);
                h.put(n,child);
            }
        }
