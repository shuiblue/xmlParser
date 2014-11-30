package Main;

import java.awt.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import javax.xml.parsers.DocumentBuilder;  
import javax.xml.parsers.DocumentBuilderFactory;  

import org.w3c.dom.Document;  
import org.w3c.dom.Element;  
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;  

public class XmlDemo {

	
public static void main(String[] args)throws Exception {  
		        
		        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();  
		        
		        DocumentBuilder dbBuilder = dbFactory.newDocumentBuilder();  
		       
		        Document doc = null;  
		        doc = dbBuilder.parse("file:///Users/shuruiz/Documents/SPL/Symake/samples/paper/runpaper.xml");  
				       
		       
		        NodeList rule_list = doc.getElementsByTagName("RULE");

		        HashMap map = new HashMap();
		        
		    //get rule
		        for(int i = 0; i< rule_list.getLength() ; i ++){
		        //get target
		            Node targetNode = rule_list.item(i);
		            NodeList son = targetNode.getChildNodes();
		            
	            	String targrtVal = "";
	            	ArrayList preq = new ArrayList();
	            	
		            for(int j=0; j<son.getLength(); j++) {
		            	Node sonNode = son.item(j);

		            	if (sonNode.getNodeName().trim().equals("target-models")) {
		            		ArrayList target = findvalue(sonNode);
		            		if (target.isEmpty()) {
		            			continue;
		            		}
		            		targrtVal = (String)target.get(0);
		            	} else if (sonNode.getNodeName().trim().equals("PREQS")) {
		            		ArrayList preqVal = findvalue(sonNode);
		            		preq.addAll(preqVal);
		            	} else if(sonNode.getNodeName().trim().equals("RCPs")){ //recipe
		            		ArrayList rcpVal = findvalue(sonNode);
		            		preq.addAll(rcpVal);
		            	}
		            }
		            map.put(targrtVal, preq);
		        }        
		        for (Iterator key = map.keySet().iterator(); key.hasNext();) {
		        	   String target = (String) key.next();
		        	   ArrayList value = (ArrayList)map.get(target);
		        	   System.out.println("target: "+ target);
		        	   System.out.println("values:");
		        	   for(Iterator vi = value.iterator(); vi.hasNext();) {
		        		   String v = (String) vi.next();
		        		   System.out.print(v+" ");
		        	   }
		        	   System.out.println(" ");
		        	   System.out.println("-----------------");
		        }
		    } 
	
	static ArrayList findvalue(Node node){
		ArrayList ar = new ArrayList();
		if(node.getNodeName().equals("value")){
			String value = node.getTextContent().trim();
			if(!value.equals("")){
				ar.add(value);
			}
			return ar;
		} else if(node.hasChildNodes()){
			for(int j=0;j<node.getChildNodes().getLength();j++ ){
				ar.addAll(findvalue(node.getChildNodes().item(j)));
			}
			return ar;
		}
		return ar;
	}
	
	static String TAG_CONCAT = "concat";
	static String TAG_LEFT = "left";
	static String TAG_RIGHT = "right";
	public String  concatName(Node node) {
		if (node.getNodeName().trim().equals(TAG_CONCAT)) {
			String left = "";
			String right = "";
			for(int j=0;j<node.getChildNodes().getLength();j++ ){
				if (node.getChildNodes().item(j).getNodeName().trim().equals(TAG_LEFT)){
					left = getTargetName(node.getChildNodes().item(j));
				} else if (node.getChildNodes().item(j).getNodeName().trim().equals(TAG_RIGHT)){
					right = getTargetName(node.getChildNodes().item(j));
				}
			}
			return left + " " + right;
		} else {
			Node son = node.getChildNodes().item(0);
			if (son.getNodeName().trim().equals(TAG_CONCAT)) {
				return getTargetName(son);
			}
			return son.getTextContent().trim();
		}
	}
}


get ruleList
for (ruleList as ruleItem) {
//	do to
//	遍历ruleItem
//	找出ruleName -> depent
//	找出rulename target中	
	for (ruleItem.getChildNodes() as sonOfRuleItem) {
		//findTarget
		if (sonOfRuleItem.getNodeName().trim().equals(TAG_CONCAT)) {
			targetName = concatName(sonOfRuleItem.getChiledNode().item(0));
		}else if(sonOfRuleItem.getNodeName().trim().equals(TAG_PREQS)) {
			depence = map();
			for(sonOfRuleItem.getChildNodes() as pItem) {
				for(pItem.getChildNodes() as sonOfP) {
					if (sonOfP.getNodeName().trim().equals(TAG_CONCAT)) {
						depence.add(new TreeNode(concatName(sonOfP)));
					} else if(sonOfP.getNodeName().trim().equals(TAG_SELECT)){
						//找到cr 取出condition
						//找到TAG_TRUE,取出concat
//						trueName = concatName(trueNode);
//						falseName = concatName(falseNode);
//						depence.push(TAG_TRUE, concatName(trueName));
//						depence.push(TAG_FALSE, concatName(falseName));
						String condition;
						CondtionTreeNode trueNode;
						CondtionTreeNode falseNode;
						for (sonOfP.getChildNodes() as x) {
							if (x.getNodeName()trim().equals(TAG_TRUE)) {
								trueNode = new CondtionTreeNode("" , "true", concatName(x));
							} else if (x.getNodeName()trim().equals(TAG_FALSE)) {
								falseNode = new CondtionTreeNode("" , "false", concatName(x));
							}else if (x.getNodeName()trim().equals(TAG_SELECT)) {
								condition = x.getCondition();
							}
						}
						if (!empty(trueNode)) {
							trueNode.setCondition(condition);
							depence.add(trueNode);
						}
						if (!empty(falseNode)) {
							falseNode.setCondition(condition);
						}
					}
				}
			}
		}
	}	
	mapRes.add(new TreeNode(targetName, depence));
}

class TreeNode {
	String name;
	TreeNode parent;
	ArrayList children;
	public TreeNode(String name) {
		this.name = name;
	}
	public TreeNode(String name, ArrayList children) {
		this.name = name;
		this.children = children;
	}
}

class CondtionTreeNode extends TreeNode {
	public CondtionTreeNode(java.lang.String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}
	String condition;
	String value;
	public  (String condition, String value, String name){
		this.condition = condition;
		this.value = value;
		this.name = name;
	}
	public void setCondition(String condition) {
		// TODO Auto-generated method stub
		this.condition = condition;
	}
	
}



