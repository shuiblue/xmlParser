package Main;

import java.util.ArrayList;

public class TreeNode {
	TreeNode pParent;
	ArrayList<TreeNode> pChildren;
	public TreeNode getpParent() {
		return pParent;
	}
	public void setpParent(TreeNode pParent) {
		this.pParent = pParent;
	}
	public ArrayList<TreeNode> getpChildren() {
		return pChildren;
	}
	public void setpChildren(ArrayList<TreeNode> pChildren) {
		this.pChildren = pChildren;
	}
	public TreeNode(TreeNode pParent, ArrayList<TreeNode> pChildren) {
		super();
		this.pParent = pParent;
		this.pChildren = pChildren;
	}
}
