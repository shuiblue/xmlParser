package Main;

import java.util.ArrayList;

public class ConditionTreeNode extends XMLTreeNode {
	String condition;
	String value;
	
	public ConditionTreeNode(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}
	ConditionTreeNode(ConditionTreeNode node) {
		this(node.getCondition(), node.getValue(), node.getTarget(), node.getPrerequisite(), node.getRcp());
	}
	ConditionTreeNode(XMLTreeNode node) {
		super(node.getTarget(), node.getPrerequisite(), node.getRcp());
	}


	ConditionTreeNode(String condition, String value, String name) {
		super(name);
		this.condition = condition;
		this.value = value;
	}

	ConditionTreeNode(String condition, String value, String name, ArrayList<XMLTreeNode> prerequisite,
			ArrayList<XMLTreeNode> rcp) {
		super(name, prerequisite, rcp);
		this.condition = condition;
		this.value = value;
	}
	
	public void setCondition(String condition) {
		// TODO Auto-generated method stub
		this.condition = condition;
	}

	@Override
	public void print(String tab) {
		System.out.println(tab+">>>>>>>>start>>>>>>>>"+ target);
		System.out.println(tab+"target:" + target);
	    System.out.println(tab+"if "+condition+" is : "+value);
		if (prerequisite != null) {
			for (XMLTreeNode i : prerequisite) {
				System.out.println(tab+"prerequisite:");
				i.print(tab+"\t");
			}
		}
		if (rcp != null) {
			for (XMLTreeNode i : rcp) {
				System.out.println(tab+"rcp:" );
				i.print(tab+"\t");
			}
		}
		
		
		System.out.println(tab+"<<<<<<<<<<end<<<<<<<<<<" + target);
		System.out.println();

	}



	public String getValue() {
		return value;
	}



	public void setValue(String value) {
		this.value = value;
	}



	public String getCondition() {
		return condition;
	}

}
