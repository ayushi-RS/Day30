class Solution {
    public boolean isBalanced(TreeNode root) {
		if(root == null)
					return true;
					
		//Find left and right height of root
        int heightOfLeft = findHeight(root.left);
        int heightOfRight = findHeight(root.right);
        
        //check the difference between left height and right height.
        //if it is left than or equal to one then do recurive call for the left of root and right of root.
        //else return false.
        if(Math.abs(heightOfLeft - heightOfRight) <= 1){
            return true && isBalanced(root.left) && isBalanced(root.right);
        } else {
            return false;
        }
    }
    
    //Finding Height of Tree
    public static int findHeight(TreeNode root){
        if(root == null)
            return 0;
        
        int lh = findHeight(root.left);
        int rh = findHeight(root.right);
        
        return 1+Math.max(lh,rh);
    }
}