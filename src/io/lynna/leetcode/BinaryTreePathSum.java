package io.lynna.leetcode;

/**
 * Created by lynna on 2017/12/2.
 */
public class BinaryTreePathSum {
     //Definition for a binary tree node.
     public static class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
     }

    static class Solution {
        public int maxPathSum(TreeNode root) {
            Path MaxPath = oneNodeCalculate(root);
            return MaxPath.MaxInTree;

        }

        public Path oneNodeCalculate(TreeNode node){
            Path result = new Path();
            if(node==null){
                result.NodeIsNull = true;
                return result;
            }

            Path leftPath = oneNodeCalculate(node.left);
            Path rightPath = oneNodeCalculate(node.right);

            int leftByPass = leftPath.byPass >0?leftPath.byPass :0;
            int rightByPass = rightPath.byPass>0?rightPath.byPass:0;

            result.byPass = Math.max(leftByPass, rightByPass) + node.val;
            if(leftPath.NodeIsNull && rightPath.NodeIsNull)
                result.MaxInTree = node.val;
            else if(leftPath.NodeIsNull)
                result.MaxInTree=Math.max(leftByPass+rightByPass+node.val, rightPath.MaxInTree);
            else if(rightPath.NodeIsNull)
                result.MaxInTree=Math.max(leftByPass+rightByPass+node.val, leftPath.MaxInTree);
            else {
                int max = Math.max(leftPath.MaxInTree, rightPath.MaxInTree );
                result.MaxInTree = Math.max(leftByPass + rightByPass + node.val, max);
            }

            return result;

        }

        class Path {
            boolean NodeIsNull = false;
            int byPass;
            int MaxInTree;
        }

    }

    public static void main(String args[]) {
        TreeNode node = new TreeNode(5);
        node.left = new TreeNode(-3);
        node.right = new TreeNode(1);

        Solution s = new Solution();
        System.out.println(s.maxPathSum(node));
    }
}
