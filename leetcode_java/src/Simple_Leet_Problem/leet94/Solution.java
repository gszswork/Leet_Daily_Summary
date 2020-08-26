package leet94;

import java.util.ArrayList;
import java.util.List;

class Solution {
	
	 // Definition for a binary tree node.
	 public class TreeNode {
	     int val;
	     TreeNode left;
	     TreeNode right;
	     TreeNode() {}
	     TreeNode(int val) { this.val = val; }
	     TreeNode(int val, TreeNode left, TreeNode right) {
	         this.val = val;
	         this.left = left;
	         this.right = right;
	     }
	 }
	 
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        search(root, res);
        return res;
        
    }
    
    public void search(TreeNode root, List<Integer> res) {
    	if(root != null) {
    		while(root.left!=null) {
    			search(root.left, res);
    		}
    		res.add(root.val);
    		while(root.right != null) {
    			search(root.right, res);
    		}
    	}
    }
    
}