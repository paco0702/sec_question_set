package Tree;

public class MergeBST {
	/*
	 Given two binary search trees
	 print the elements of both bst in sorted form 
	 the expected time complexity is O(m+n) where m is 
	 the number of nodes in the first tree 
	 
	 and n is the number of nodes in the second tree 
	 
	 */
	public static class Node{
		int data;
		Node parent;
		Node leftChild;
		Node rightChild;
		
		Node(int data){
			this.data = data;
			this.parent = new Node();
			this.leftChild = new Node();
			this.rightChild = new Node();
		}
		
		Node (){
			this.data = 0;
		}
		
		public Node getParent() {
			return this.parent;
		}
		
		public void setParent(Node parent) {
			this.parent = parent;
		}
		
		public Node getLeftChild() {
			return this.leftChild;
		}
		
		public void setLeftChild(Node child) {
			this.leftChild= child;
		}
		
		public Node getRightChild() {
			return this.rightChild;
		}
		
		public void setRightChild(Node child) {
			this.rightChild = child;
		}
		
		
	}
	public static class BST{
	
		
	Node root;
	int count = 0 ;
	
	
	public boolean isEmpty() {
		if(count == 0) {
			return true;
		}else {
				return false;
			}
	}
	
	
	public void insert(int data) {
		if(isEmpty()== true) {
			Node newNode = new Node(data);
			root = newNode;
			count++;
		}else {
			insert(root, data);
			count++;
		}
	}
	
	private Node insert(Node node, int data) {
		if(node.data == 0) {
			node = new Node(data);
			return node;
		}
		if(node.data<data) {
			node.rightChild = insert(node.rightChild,data);
		}else if(node.data>data) {
			node.leftChild = insert(node.leftChild, data);
		}else if (node.data==data){
			System.out.println("node is inserted already");
		}

		return node;
	}
	
	public void printTree() {
		printTree(root);
	}
	
	private void printTree(Node node) {
		if(node==null) {
			return;
		}
	
		printTree(node.leftChild);
		if(node.data!=0)
			System.out.printf("%d ", node.data);
		printTree(node.rightChild);
	}
	
	
	}
	public static void main(String [] args) {
		BST t = new BST ();
		t.insert(3);
		t.insert(1);
		t.insert(5);
		t.printTree();
		System.out.println();
		
		BST t2 = new BST ();
		t2.insert(4);
		t2.insert(2);
		t2.insert(6);
		t2.printTree();
		
		System.out.println();
		BST newTree = mergerTree(t, t2);
		newTree.printTree();
	}
	
	public static  BST mergerTree (BST t1, BST t2) {
		t1 = mergerTree(t1, t2.root);
		return t1;
	}
	
	private static BST mergerTree (BST t1, Node t2Node) {
		if(t2Node == null || t2Node.data == 0) {
			return t1;
		}
		t1.insert(t2Node.data);
		mergerTree(t1 , t2Node.leftChild);
		mergerTree(t1, t2Node.rightChild);
		
		return t1;
	}
}
