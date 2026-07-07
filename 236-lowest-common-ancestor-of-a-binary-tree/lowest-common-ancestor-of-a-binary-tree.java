/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null){
            return root;
        }

        if(root == p || root == q){
            return root;
        }

        TreeNode leftLca = lowestCommonAncestor(root.left,p,q);
        TreeNode rightLca = lowestCommonAncestor(root.right,p,q);

        // left = valid , right->null
        if(leftLca == null){
            return rightLca;
        }

        // right = valid , left -> null
        if(rightLca == null){
            return leftLca;
        }

        return root;
    }
}