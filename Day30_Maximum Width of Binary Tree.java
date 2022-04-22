class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        // create 2 queues for nodes and indices
        Queue<TreeNode> q = new LinkedList<>();
        Queue<Integer> q_index = new LinkedList<>();
        // add start value; root will start from index 1
        q.add(root);
        q_index.add(1);
        int max = 0;
        
        while (!q.isEmpty()) {
            int size = q.size();
            int start = 0, end = 0;
            
            for (int i = 0; i < size; i++) {
                // take out node as well as its index
                TreeNode node = q.poll();
                int index = q_index.poll();
                
                // if start or end of level, update them to index
                if (i == 0) start = index;
                if (i == size - 1) end = index;
                
                // go to next nevel in both queues
                if (node.left != null) {
                    q.add(node.left);
                    q_index.add(2 * index);
                }
                if (node.right != null) {
                    q.add(node.right);
                    q_index.add(2 * index + 1);
                }
            }
            // after loop end, start end will have val of last level
            // which will give us the max width
            max = Math.max(max, end - start + 1);
        }
        return max;
    }
}
