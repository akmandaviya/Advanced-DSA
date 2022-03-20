package Trees;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class Node {
	
	public int data;
	public Node left;
	public Node right;
	
	public Node(int data) {
		this.data = data;
	}
 
}

public class TreeIntro {
	public static void main(String[] args) {
		Node root = getTree();
		
		System.out.println("Printing pre-order using recursion");
		preOrder(root);
		System.out.println(" ");
		
		System.out.println("Printing pre-order using iteration");
		preOrderIterative(root);
		System.out.println(" ");
		
		System.out.println("Printing in-order using recursion");
		inOrder(root);
		System.out.println(" ");
		
		System.out.println("Printing in-order using iteration");
		inOrderIterative(root);
		System.out.println(" ");
		
		System.out.println("Printing post-order using recursion");
		postOrder(root);
		System.out.println(" ");
		
		System.out.println("Printing post-order using iteration");
		postOrderIterative1(root);
		System.out.println(" ");
		
		System.out.println("Printing post-order using iteration");
		postOrderTraversal2(root);
		System.out.println(" ");
		
		System.out.println("Printing level-order1 using recursion");
		levelOrder1(root);
		System.out.println(" ");
		
		System.out.println("Printing level-order2 using recursion");
		levelOrder2(root);
		System.out.println(" ");
		
		System.out.println("Height of the tree is: " +getHeight(root) );
	
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
	//Recursive Traversal 
	
	private static void preOrder(Node root) { 
		if(root == null) { 
			return;
		}
		System.out.print(root.data + " ");//N
		preOrder(root.left);//L
		preOrder(root.right);//R
	}
	
	private static void inOrder(Node root) { 
		if(root == null) { 
			return;
		}
		inOrder(root.left);//L
		System.out.print(root.data + " ");//N
        inOrder(root.right);//R
	}
	
	private static void postOrder(Node root) { 
		if(root == null) { 
			return;
		}
		postOrder(root.left);//L
		postOrder(root.right);//R
		System.out.print(root.data + " ");//N

	}
	
	
	//Iterative traversal
	
	private static void preOrderIterative(Node root) { 
		if(root == null) { 
			return;
		}
		
		Stack<Node> st = new Stack<>();
	    st.push(root);
		
		while(!st.isEmpty()) {
			Node n = st.pop();
			System.out.print(n.data + " ");//N
			
			if(n.right != null) {
				st.push(n.right);
			}
			if(n.left != null) {
				st.push(n.left);
			}
		}
	}
	
	private static void inOrderIterative(Node root) { 
		if(root == null) { 
			return;
		}
		Stack<Node>st = new Stack<>();
		Node curr = root;//push root in stack
		
		while(curr!=null || st.size() >0) { //L
			
			while(curr != null) { 
				st.push(curr);
				curr = curr.left;
			}
			
			curr = st.pop();
			System.out.print(curr.data + " ");//N
			
			curr= curr.right;//R
		} 
	}
	//using two stack T.C = O(n) + O(n) = o(n)
	private static void postOrderIterative1(Node root) { //with 1 stack
		if(root == null) {
			return;
		}
		Stack<Node> s1 = new Stack<>();
		Stack<Node> s2 = new Stack<>();
		
		s1.push(root);//push root in stack 1
		while(!s1.isEmpty()) {
			root = s1.pop();//pop from stack1
			s2.push(root);// push in stack 2
			
			if(root.left != null) {
				s1.push(root.left);// push left in s1
			}
			if(root.right != null) {
				s1.push(root.right);//push right in s2
        	}
		}
		
		while(!s2.isEmpty()) { 
			root = s2.pop();
			System.out.print(root.data + " ");	
		}
	}
	
	//using one stack T.C O(N)
	private static void postOrderTraversal2(Node root) { 
		if(root == null)  { 
			return;
		}
		
		Node curr = root;
		Stack<Node> st = new Stack<>();
		
		while(curr != null || !st.isEmpty()){
			if(curr != null) {
				st.push(curr);//initially push root in stack
				curr = curr.left;// left of curr
			}else { 
				Node temp = st.peek().right;//right of peek
				  if(temp == null) { 
					  temp = st.pop();
					  System.out.print(temp.data + " " );
					  
					  while(!st.isEmpty() && temp == st.peek().right) { 
						 temp = st.pop(); 
						 System.out.print(temp.data + " ");
					  }
				  }else { 
					  curr = temp;
				  }
				}
		}
	}
	
	
	public static void levelOrder1(Node root) { 
		if(root == null) {
			return;
		}
		
		Queue<Node> q = new ArrayDeque<>();
		q.add(root);//add root
		
		
		while(!q.isEmpty()) { 
			Node n = q.remove();
			System.out.print(n.data + " ");
			if(n.left != null) {
				q.add(n.left);
			}
			if(n.right != null) {
				q.add(n.right);
			}
		}
   }
	
	public static void levelOrder2(Node root) { 
		if(root == null) {
			return;
		}
		
		Queue<Node> q = new LinkedList<>();
		q.add(root);//add root
		q.add(null);//add dummy data 
		
		
		while(!q.isEmpty()) { 
			Node n = q.remove();
			
			if(n == null) { // n = dummy data
				System.out.println(""); // add new line
				
				if (!q.isEmpty()) {
					q.add(null);//again add dummy data	
				}
				continue;
			}
			System.out.print(n.data + " ");
			
			if(n.left != null) {
				q.add(n.left);
			}
			if(n.right != null) {
				q.add(n.right);
			}
		}
   }
	
	private static int getHeight(Node root) { 
		if(root == null){
            return 0;// if no root, height 0
        }
	   // it follows a post order traversal as we visit>> left->right->node
		int leftHeight = getHeight(root.left);
		int rightHeight = getHeight(root.right);
		return Math.max(leftHeight, rightHeight) + 1;//left child height + right child height + 1		
	}
	
	
}




