package Trees;


public class practice1 { 
	
	Node root1,root2;

private boolean checkIdentical(Node root1, Node root2) {
		if(root1 == null && root2 == null) {
			return true;
		}
		if(root1 == null || root2 == null) {
			return false;
		}
		
		return (root1.data == root2.data && checkIdentical(root1.left, root2.left) && 
				checkIdentical(root1.right, root2.right));
}

private boolean checkIsSubtree(Node a, Node b) {
	if(b == null) {
		return true;
	}
	if(a == null ) {
		return false;
	}
	
	if(checkIdentical(a, b)) {
		return true;
	}
	
	return checkIsSubtree(a.left, b) ||checkIsSubtree(a.right, b);
}


public static void main(String[] args) {
	practice1 tree = new practice1();
	
	//for tree 1
	tree.root1 = new Node(1);
	tree.root1.left = new Node(2);
	tree.root1.right = new Node(3);
	tree.root1.left.left = new Node(4);
	tree.root1.right.right = new Node(5);
	
	//for tree 2
	tree.root2 = new Node(2);
	tree.root2.left = new Node(4);
	
	if(tree.checkIsSubtree(tree.root1,tree.root2)) {
		System.out.println("Tree 2 is a subtree of tree 1");
	} 
	else {
		System.out.println("Not a subtree");
	}
	
	}
}
