package Trees;

public class Questions {
	
	public static void main(String[] args) {
		Node root = getTree();
		
		System.out.println("Count of the leaf node in a tree is: " + countLeafNodes(root) );
        System.out.println(" ");
      
	}
	
	private static Node getTree() { 
		
		Node root = new Node(1);
		Node node1 = new Node(2);
		Node node2 = new Node(3);
		Node node3 = new Node(4);
		Node node4 = new Node(5);
		Node node5 = new Node(6);
		Node node6 = new Node(7);
		Node node7 = new Node(8);
		Node node8 = new Node(9);
		
		root.left = node1;
		root.right = node2;
		
		node1.left = node3;
		node1.right = node4;
		
		node2.left = node5;
		node2.right = node6;
		
		node3.left = node7;
		node3.right = node8;
		return root; //main node of the tree	

  }
 
 //count leaf nodes
 private static int countLeafNodes(Node root) {
		if(root == null){//tree empty
            return 0;
	    }
		
		if(root.left == null && root.right == null) { //check root is a leaf node
			return 1;
		}
		
		int leafNodeOnLeft = countLeafNodes(root.left);
		int leafNodeOnRight = countLeafNodes(root.right);
		return leafNodeOnLeft + leafNodeOnRight;
 }	
	
}
