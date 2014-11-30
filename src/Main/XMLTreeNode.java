package Main;

import java.util.ArrayList;

public class XMLTreeNode {
	String target;
	XMLTreeNode parent;
	ArrayList<XMLTreeNode> prerequisite;
	ArrayList<XMLTreeNode> rcp;

	public XMLTreeNode(String target) {
		this.target = target;
	}

	public XMLTreeNode(String target, ArrayList<XMLTreeNode> prerequisite,
			ArrayList<XMLTreeNode> rcp) {
		this.target = target;
		this.prerequisite = prerequisite;
		this.rcp = rcp;
	}

	public void print(String tab) {
		System.out.println(tab+">>>>>>>>start>>>>>>>>"+ target);
		System.out.println(tab+"target:" + target);
		if (prerequisite != null) {
			System.out.println(tab+"prerequisite:");
			for (XMLTreeNode i : prerequisite) {
				i.print(tab+"\t");
			}
		}
		if (rcp != null) {
			System.out.println(tab+"rcp:");
			for (XMLTreeNode i : rcp) {
				if (i != null) {
					i.print(tab+"\t");
				}
			}
		}
		System.out.println(tab+"<<<<<<<<<<end<<<<<<<<<<" + target);
	}

	public String getTarget() {
		return target;
	}

	public void setTarget(String target) {
		this.target = target;
	}

	public XMLTreeNode getParent() {
		return parent;
	}

	public void setParent(XMLTreeNode parent) {
		this.parent = parent;
	}

	public ArrayList<XMLTreeNode> getPrerequisite() {
		return prerequisite;
	}

	public void setPrerequisite(ArrayList<XMLTreeNode> prerequisite) {
		this.prerequisite = prerequisite;
	}

	public ArrayList<XMLTreeNode> getRcp() {
		return rcp;
	}

	public void setRcp(ArrayList<XMLTreeNode> rcp) {
		this.rcp = rcp;
	}
}
