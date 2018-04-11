package io.lynna.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by lynna on 2017/12/3.
 */
public class BstSwap {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public TreeNode[] forCompare = new TreeNode[2];
    public TreeNode[] markedWrong = new TreeNode[2];

    public void recoverTree(TreeNode root) {
        middleOrderVisitNode(root);
        if(markedWrong[1]!= null) {
            int tmp = markedWrong[0].val;
            markedWrong[0].val = markedWrong[1].val;
            markedWrong[1].val = tmp;

        }
    }


    public void middleOrderVisitNode(TreeNode node){
        if(node != null) {
            middleOrderVisitNode(node.left);
            addToList(forCompare, node);
            if(forCompare[1] != null){
                if(forCompare[0].val > forCompare[1].val)
                {
                    if(markedWrong[1] != null)
                        markedWrong[1] = forCompare[1];
                    else
                    {
                        markedWrong[0] = forCompare[0];
                        markedWrong[1] = forCompare[1];
                    }
                }
            }
            middleOrderVisitNode(node.right);

        }

    }

    public void addToList(TreeNode[] target, TreeNode element){
        if(target[0] != null && target[1] != null){
            target[0]=target[1];
            target[1]=element;
        }
        else if(target[0] == null )
            target[0] = element;
        else {
            target[1] = element;
        }
    }

    public static void main(String args[]) {
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.right = new TreeNode(3);

        BstSwap bst = new BstSwap();
        bst.recoverTree(node);
        System.out.println(node.left.val);
        System.out.println(node.val);
        System.out.println(node.right.val);
    }


}
