package leet144;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import javax.swing.tree.TreeNode;

class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        if(root == null) {
        	return list;
        }
        stack.push(root);
        while(!stack.isEmpty()) {
        	TreeNode current = stack.pop();
        	list.add(current.val);
        	if(current.right != null) {
        		stack.push(current.right);
        	}
        	if(current.left != null) {
        		stack.push(current.left);
        	}
        }
        
        
        return list;
    }
}