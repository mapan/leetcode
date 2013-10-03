public class Solution {
    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if(root==null) return result;
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);
        ArrayList<Integer> singleLevel(Nodes);
        int nodesNum = 1; 
        while(!q.isEmpty()) {
            int j = nodesNum; 
            nodesNum = 0;
            singleLevel = new ArrayList<Integer>();
            for(int i=0;i<j;i++) {
                TreeNode n = q.poll();
                singleLevel.add(n.val);
                if(n.left!=null) {
                    q.add(n.left);
                    nodesNum++;
                }
                if(n.right!=null) {
                    q.add(n.right);
                    nodesNum++;
                }
            }
            result.add(singleLevel);
        }
        return result;
		//############## bottom up #########
		Collections.reverse(result);
    }
}

public class Solution {
    ArrayList<ArrayList<Integer>> r;
    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        r=new ArrayList<ArrayList<Integer>>();
        if(root==null) return r;
        dfs(root,0);
        return r;
    }
    public void dfs(TreeNode root,int level) {
        if(root==null) return;
        if(level==r.size()) r.add(new ArrayList<Integer>());
        r.get(level).add(root.val);
        dfs(root.left,level+1);
        dfs(root.right,level+1);
    }
}

int nodesNum = 0; 
        int j = 1;
        while(!q.isEmpty()) {
            TreeNode n = q.poll();
            j--;                
            singleLevel.add(n.val);
           
            if(n.left!=null) {
                q.add(n.left);
                nodesNum++;
            }
            if(n.right!=null) {
                q.add(n.right);
                nodesNum++;
            }
             if(j==0) {
                result.add(singleLevel);
                singleLevel = new ArrayList<Integer>();
                j=nodesNum;
                nodesNum=0;
            }
        }

vector<vector<int> > levelOrderBottom(TreeNode *root) {
    // Start typing your C/C++ solution below
    // DO NOT write int main() function
    vector<vector<int>> result;
    traverse(root, 1, result);
    std::reverse(result.begin(), result.end());
    return result;
}

void traverse(TreeNode *root, int level, vector<vector<int>> &result) {

    if (!root)
        return;

    if (level > result.size()) {
        vector<int> temp;
        result.push_back(temp);
    }
    result[level-1].push_back(root->val);
    traverse(root->left, level+1, result);
    traverse(root->right, level+1, result);
}

public class Solution {
    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if(root==null) return result;
        Stack<TreeNode> s1 = new Stack<TreeNode>();
        s1.add(root);
        Stack<TreeNode> s2 = new Stack<TreeNode>();
        ArrayList<Integer> singleLevel;
        while(!s1.isEmpty()) //|| !s2.isEmpty()) {
            singleLevel = new ArrayList<Integer>();
            while(!s1.isEmpty()) {
                TreeNode node = s1.pop();
                singleLevel.add(node.val);
                if(node.left!=null) s2.add(node.left);
                if(node.right!=null) s2.add(node.right);
            }
            if(!singleLevel.isEmpty())
                result.add(singleLevel);
                
            singleLevel = new ArrayList<Integer>();
            while(!s2.isEmpty()) {
                TreeNode node = s2.pop();
                singleLevel.add(node.val);
                if(node.right!=null) s1.add(node.right);
                if(node.left!=null) s1.add(node.left);
            }
            if(!singleLevel.isEmpty())
                result.add(singleLevel);
        }
        return result;
    }
}
