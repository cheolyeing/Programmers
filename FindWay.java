import java.util.*;
class Solution {
    public int[][] solution(int[][] nodeinfo) {
        int len = nodeinfo.length;
		BTree tree = new BTree();
		
		int[][] input = new int[len][3];
		
		for(int i=0; i<len; i++) {
			input[i][0] = nodeinfo[i][0];
			input[i][1] = nodeinfo[i][1];
			input[i][2] = i+1;
		}
		
		Arrays.sort(input, new Comparator<int[]>() {
			public int compare(int[] o1, int[]o2) {
				return o2[1]-o1[1];
			}
		});
		
		for(int i=0; i<len; i++) {
			tree.insertBST(input[i][2], input[i][0]);
		}
		
		
        int[][] answer = new int[2][len];
        
        tree.printPRE(answer[0]);
        tree.printPOST(answer[1]);
        
        return answer;
    }
}

class BTree {
	public TreeNode root;
	public int printIdx = 0; 
	
	public TreeNode insertKey(TreeNode root, int label, int x) {
		TreeNode p = root;
		TreeNode newNode = new TreeNode(label, x);
		
		if(p==null) return newNode;
		else if(p.data>newNode.data) {
			p.left = insertKey(p.left, label, x);
			return p;
		} else if(p.data<newNode.data) {
			p.right = insertKey(p.right, label, x);
			return p;
		} else return p;
	}
	
	public void insertBST(int label, int x) {
		root = insertKey(root, label, x);
	}
	
	public void preorder(TreeNode root, int[] ans) {
		if(root!=null) {
			ans[printIdx++] = root.label;
			preorder(root.left, ans);
			preorder(root.right, ans);
		}
	}
	
	public void printPRE (int[] ans) {
		printIdx = 0;
		preorder(root, ans);
	}
	
	public void postorder(TreeNode start, int[] ans) {
		
		if(start.left!=null) postorder(start.left, ans);
		if(start.right!=null) postorder(start.right, ans);
		ans[printIdx++] = start.label;
	}
	
	public void printPOST(int[] ans) {
		printIdx = 0;
		postorder(root, ans);
	}
}

class TreeNode {
	int label;
	int data;
	boolean printed;
	TreeNode left, right;
	
	public TreeNode() {
		this.left = null;
		this.right = null;
		this.printed = false;
	}
	
	public TreeNode(int label, int data) {
		this.label = label;
		this.data = data;
		this.left = null;
		this.right = null;
		this.printed = false;
	}
	
	public int getData() {
		return data;
	}
}
