package Trees;

public class questionsBST {

	public static void main(String[] args) {
		//	Node root = getTree();
			       
//	        
//	        if(checkIfBst(root)) {
//	        	System.out.println("Is a BST");
//	        }else {
//	        	System.out.println("Not a BST");
//	        }
	        Node root = null;
	        root = insert(root, 10);
	        root = insert(root, 20);
	        root = insert(root, 30);
	        root = insert(root, 40);
	        root = insert(root, 50);
	        root = insert(root, 60);
	        root = insert(root, 70);
	        root = insert(root, 80);
	        root = insert(root, 90);
	        root = insert(root, 99);
	        
	    
	        
	       System.out.print("Inorder of the BST is"+ " "); 
	       inOrder(root);
	       System.out.println(" ");
	       
	       //search(root, 70);
	      // search(root, 95);
	       
	       search(root, 25);
	       delete(root, 25);
	       System.out.print("Inorder of the BST is"+ " "); 
	       inOrder(root);
	       System.out.println(" ");
	       search(root, 50);
	       delete(root, 50);
	       System.out.print("Inorder of the BST is"+ " "); 
	       inOrder(root);
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
	     //delete in BST
		private static Node delete(Node root, int data){
		        if(root == null){
		            System.out.println(data + " is not in the BST");
		            return root;
		        }
		        if(root.data < data){
		            root.right = delete(root.right, data);
		            return root;
		        }else if (root.data > data){
		            root.left = delete(root.left, data);
		            return root;
		        }
		        
		        //check if node is leaf node
		        if(root.left == null && root.right == null){
		            root = null;
		            return null; // or return root. current node as null
		        }else if(root.left == null){//just has right subtree
		            root = root.right;
		            return root;
		        }else if(root.right == null){ //just has left subtree
		            root = root.left;
		            return root;
		        }else{//if has both subtrees

		        	//case 1--> max element in left subtree 
		            Node replacingNode = findMax(root.left);
		            root.data = replacingNode.data;
		            root.left = delete(root.left, replacingNode.data);

		            /** case 2--> min element in right subtree
		            Node replacingNode = findMin(root.right);
		            root.data = replacingNode.data;
		            root.right = delete(root.right, replacingNode.data);
		             **/    
		        }
		        return root;
		    } 
		
	            private static Node findMax(Node root) {
		         	while(root.right != null) {
		        		root = root.right;
		        	}
		        	return root;
		        }
		      
		
		//search in BST
		private static void search(Node root, int data) { 
			if(root == null) { 
				System.out.println(data +" " + "is not present in BST");
				return;
			}
			if(root.data == data) { 
				System.out.println(data +" " +  "is present in BST");
				return;
			}
			if(root.data < data) { 
				search(root.right, data);
			}else {
				search(root.left, data);
			} 
			
		}
		
		
		//insertion in BST
		private static Node insert(Node root, int data){
	        Node newNode = new Node(data);
	        return insert(root, newNode);
	    }
	     private static Node insert(Node root, Node newNode){
	       if(root == null){
	           return newNode;
	       }
	       if(root.data < newNode.data){
	           root.right = insert(root.right, newNode);
	       }else{
	           root.left = insert(root.left, newNode);
	       }
	       return root;
	    }

	         //inorder of BST is always sorted
	        private static void inOrder(Node root) { 
		       if(root == null) { 
		         	return;
		          }
		       inOrder(root.left);//L
		       System.out.print(root.data + " ");//N
	           inOrder(root.right);//R
	          } 
	    
	    
	 //program for Checking tree is BST
	 private static boolean checkIfBst(Node root)  { 
			if(root == null) { 
				return true; //is BST
			}
			return checkIfBst(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
		}
		
		                   //method over ridden
		      private static boolean checkIfBst(Node root, int min, int max) { 
			   if(root == null) { 
			  	return true; // is BST
			   }
			   if(root.data < min  || root.data > max) { 
			   	return false; //not a BST
			  } //checking left child should be less than root and right child should be greater than root
			   return checkIfBst(root.left, min, root.data) && checkIfBst(root.right, root.data, max);
			
		     }
		
}
