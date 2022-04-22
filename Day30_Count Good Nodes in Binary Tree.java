class Solution {
    int c = 0;
    public void helper(TreeNode root, int max)
    {
        if(root == null)
            return ;
        helper(root.left, Math.max(root.val, max));
        helper(root.right, Math.max(root.val, max));
        if(max <= root.val)
            c++;
    }
    public int goodNodes(TreeNode root) {
        helper(root, Integer.MIN_VALUE);
        return c;
        
    }
}