// Solution by Rane Wallin of leetcode challenge Subtree of another tree
// https://leetcode.com/problems/subtree-of-another-tree
// not complete

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        return searchSubtree(t, s);
    }
    
    public boolean searchSubtree(TreeNode s, TreeNode t) {
        
        if (t == null && s != null || t != null && s == null) {
            return false;
        }
        
        // Can't be a subtree if one node has children and the other doesn't
        if ((t.left != null && s.left == null) || (t.right != null && s.right == null)) {
            System.out.println("No children");
            System.out.println(t.val);
            System.out.println(s.val);
            return false;
        }
        
        // if we have matching nodes, search the subtrees of the 
        // matches to see if it is an exact match
        if (t.val == s.val) {
            boolean validLeft = s.left != null && t.left != null;
            boolean validRight = s.right != null && t.right != null;
            
            // values match and neither tree has children
            if (t.right == null && t.left == null && s.right == null && s.left == null) {
                return true;
            }
  
            return (validLeft ? searchSubtree(s.left, t.left) : true) && 
                (validRight ? searchSubtree(s.right, t.right) : true);
        } 
        
        // The current nodes did not match and there are no more children
        // in the tree
        if(t.right == null && t.left == null) {
            return false;
        }
                
        // current nodes don't match, search the left and right children
        // of tree to see if they match with the root of the subtree
        return searchSubtree(s, t.left) || searchSubtree(s, t.right);
        
    }
}