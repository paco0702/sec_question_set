package Sort;
import java.util.ArrayList;
import java.util.List;

class RedBlackTree{
	public class Node{
		int data;
		boolean isBlack = true;
		boolean isRed = false;
		boolean isDoubleBlack = false;
		Node leftChild;
		Node rightChild;
		Node parent;
		Node uncle;


		Node(int data){
			this.data = data;
			this.isBlack = true;
			this.isRed = false;
			this.isDoubleBlack = false;
		}
		
		Node (int data, boolean isBlack, boolean isRed){
			this.data = data;
			this.isBlack = isBlack;
			this.isRed = isRed;
			this.isDoubleBlack = false;
		}
		
		//it is for create root 
		Node(){
			this.data = 0;
			this.isBlack = true;
			this.isRed = false;
			this.isDoubleBlack = false;
		}
		
		int getData() {
			return this.data;
		}
		
		void setData (int data) {
			this.data  = data;
		}
		
		boolean getBlack () {
			return this.isBlack;
		}
		
		void setBlack() {
			this.isRed = false;
			this.isBlack = true;
			this.isDoubleBlack = false;
		}
		
		boolean getRed() {
			return this.isRed;
		}
		void setRed() {
			this.isRed = true;
			this.isBlack = false;
			this.isDoubleBlack = false;
		}
		
		boolean setDoubleBlack () {
			return this.isDoubleBlack;
		}
		void setDoubleBalck() {
			this.isRed = false;
			this.isBlack = false;
			this.isDoubleBlack = true;
		}
		
		void setLeftChild() {
			this.leftChild = new Node()	;
		}
		
		void setLeftChild(Node node) {
			this.leftChild = node;
		}
		
		Node getLeftChild() {
			return this.leftChild;
		}
		
		void setRightChild() {
			this.rightChild = new Node()	;
		}
		void setRightChild(Node node) {
			this.rightChild = node;
		}
		
		Node getRightChild() {
			return this.rightChild;
		}
		
		boolean hasRightChild() {
			if(this.rightChild.data!=0) {
				return true;
			}else 
				return false;
		}
		
		boolean hasLeftChild() {
			if(this.leftChild.data!=0) {
				return true;
			}else 
				return false;
		}
		
		void setParent(Node parent) {
			this.parent = parent;
		}
		
		void setUncle(Node uncle) {
			Node node = getUncle();
			node = uncle;
		}
		
		void setUncle(Node uncle, Node parentNode) {
			this.uncle = uncle;
			this.uncle.parent = parentNode;
		}
		
		
		Node getParent() {
			try {
				return this.parent;
			}catch(NullPointerException e) {
				System.out.println("this node doesnt have a parent"); 
				return new Node();
			}
		}
		
		Node getUncle() {
			try {
				Node grandFather = this.parent.parent;
				if(grandFather.leftChild.data == this.parent.data) {
					return grandFather.rightChild;
				}else {
					return grandFather.leftChild;
				}
			}catch(NullPointerException e) {
				System.out.println("this node doesnt have a uncle"); 
				return new Node();
			}
		}
	}
	
	int count = 0;
	Node root = new Node();
	
	// interview question
	public boolean hasSamSizeSub() {
		return hasSameSizeSubTree(root);
	}
	
	
	// actually, the idea can be when you insert the tree
	// can already store the number of the sub trees
	// when the data goes on the left side of root 
	// then +1 on the left , same on the right side
	// if the number of node on both side are larger then 
	// 3 then that means they have least a size three node of sub tree 
	//                                             on both side 
	// or can use function to do that 
	private boolean hasSameSizeSubTree(Node root) {
		List <Node> leftSubTree = new ArrayList<Node>();
		List <Node> rightSubTree = new ArrayList<Node>();
		// search left 
		if(root.hasLeftChild() && root.hasRightChild()) {
			leftSubTree = searchLeft(root, leftSubTree, root);
			rightSubTree = searchLeft(root, rightSubTree, root);
			
			if(leftSubTree.size()>=3 && rightSubTree.size()>=3) {
				return true;
			}else {
				return false;
			}
		}else {
			return false;
		}
	}
	
	List searchLeft(Node node, List storeLeft, Node root){
		if(node.hasLeftChild()) {
			storeLeft.add(node.leftChild);
			searchLeft(node.leftChild, storeLeft, root);
		}
		if(node.hasRightChild()) {
			if(node.rightChild.data<root.data) {
				storeLeft.add(node.rightChild);
				searchLeft(node.rightChild, storeLeft, root);
			}else {
				return storeLeft;
			}
		}
		
		return storeLeft;
	}
	
	List searchRight(Node node, List storeRight, Node root){
		if(node.hasRightChild()) {
			storeRight.add(node.rightChild);
			searchLeft(node.leftChild, storeRight, root);
		}
		if(node.hasLeftChild()) {
			if(node.leftChild.data>root.data) {
				storeRight.add(node.leftChild);
				searchLeft(node.rightChild, storeRight, root);
			}else {
				return storeRight;
			}
		}
		
		return storeRight;
	}
	
	Node getRoot() {
		return this.root;
	}
	
	Node searchElement(int data) {
		return searchElement(root, data);
	}
	
	private Node searchElement(Node node, int data) {
		if(data > node.data	) {
			return searchElement(node.rightChild, data);
		}else if(data < node.data) {
			return searchElement(node.leftChild, data);
		}else if(node.data == data) {
			return node;
		}else {
			return null;
		}
	}
	
	public void insert (int data) {
		Node newNode = new Node(data);
		if(isEmpty()==true) {
			root = newNode;
			root.leftChild = new Node();
			root.leftChild.parent = root;
			root.rightChild = new Node();
			root.rightChild.parent = root;
			count++;
		}else {
			// find the parent node and get to which child should it use
			Node theTargetNode = insert(root, root, data);
			System.out.println(theTargetNode.data);
			theTargetNode.setData(data);
			// always red when just insert
			theTargetNode.setRed();
			theTargetNode.leftChild = new Node();
			theTargetNode.rightChild = new Node();
			balance(theTargetNode);
		}
	}
	
	private Node insert(Node node, Node parentNode, int data) {
		// if the node is not empty, keep looping
		if(node.data == 0) {
			node.setParent(parentNode);
			System.out.println("The parent node of "+data+ " is "+parentNode.data);
			return node;
		}else
		if(node.data<data) {
			return insert(node.rightChild, node, data);
		}else if(node.data>data) {
			return insert(node.leftChild, node, data);
		}else {
			return null;
		}
	}
	
	private void balance(Node node) {
		checkColourAndRotate(node);
	}
	
	private void checkColourAndRotate(Node node) {
		try {
				node.setRed();
				Node uncle = node.getUncle();
				Node parent = node.getParent();
				System.out.println("The uncle node of "+node.data+" is "+uncle.data+", the parent node of it is  "+parent.data);
				if(uncle.getRed()==true) {
					uncle.setBlack();
					parent.setBlack();
					Node grandfather = parent.parent;
					System.out.println("grandfather's node is "+ grandfather.data);
					
					if(grandfather.getParent()!=null) { // if the grandfather 's parent is null, that mean it is root
						checkColourAndRotate(grandfather);
					}
				}else if(uncle.getBlack()==true && parent.getBlack()==false) {
					determineCase(node);
				}
			
			
		}catch(NullPointerException e) {
			
		}
		
	}
	
	private void determineCase(Node node){
		try {
			Node parentNode = node.getParent();
			Node uncleNode = node.getUncle();
			Node grandFatherNode = node.getParent().getParent();
			System.out.println("parent node is "+parentNode.data);
			System.out.println("uncle node is "+uncleNode.data);
			System.out.println("grandFather node is "+ grandFatherNode.data);
			
			if(parentNode.getData()<grandFatherNode.getData()) {
				// left side 
				
				if(node.data<parentNode.getData()) {
					// it is a left left case 
					leftLeftRotation(node );
				}
				
				if(node.data>parentNode.getData()) {
					// it is a left right case 
					leftRightRotation(node);
				}
			}
			
			if(parentNode.getData()>grandFatherNode.getData()) {
				if(node.data<parentNode.getData()) {
					// it is a Right left case 
					rightLeftRotation(node);
				}
				
				if(node.data>parentNode.getData()) {
					// it is a Right Right case 
					rightRightRotation(node);
				}
			}
		
		}catch(NullPointerException e) {
			System.out.println("This node doesnt have a parent or uncle or grandParent"); 
		}
		
	}
	
	private void leftLeftRotation(Node node){
		System.out.println("Do left left rotation");
		try {
			int parentData = node.getParent().getData();
			int uncleData = node.getUncle().getData();
			int grandParentData = node.getParent().getParent().getData();
			int nodeData = node.getData();
			
			//node.setUncle(new Node(grandParentData), node.getParent().getParent());
		    
			// set Parent node to be grandparent 
			node.getParent().getParent().setData(parentData);
			node.getParent().getParent().setBlack();
			
			// set inserted node 
			node.getParent().setData(nodeData);
			node.getParent().setRed();
			
			// delete the original position of the inserted node
			node.getParent().setLeftChild(new Node());
			
			// set uncle node (with grandParent data) 
			node.getParent().getParent().setRightChild(new Node(grandParentData));
			
			Node uncleNode = node.getParent().getParent().getRightChild();
			uncleNode.setRed();
			if(uncleData == 0) { // that means the original is 0 , set its child
				uncleNode.leftChild = new Node();
				uncleNode.rightChild = new Node();
			}else { // otherwise, push the original uncle to the right child
				uncleNode.rightChild = new Node(uncleData);
				uncleNode.rightChild.setBlack();
			}
			
			
			// after the rotate , need to check the colour again 
			
			
		}catch(NullPointerException e) {
			System.out.println("This node doesnt have a parent or uncle or grandParent"); 
		}
		
	}
	
	private void leftRightRotation(Node node) {
		System.out.println("Do left right rotation");
		try {
			int parentData = node.getParent().getData();
			int uncleData = node.getUncle().getData();
			int grandParentData = node.getParent().getParent().getData();
			int nodeData = node.getData();
			
			
			
			//change the parent node to become its value 
			node.getParent().setData(nodeData);
			node.getParent().setRed();
			
			//change the parent node.left child to parent value 
			node.getParent().getLeftChild().setData(parentData);
			node.getParent().getLeftChild().setRed();
			// the above four line just show the process, doesnt really affect the operation, didnt change the parent node
			
			// right rotate 
			node.getParent().getParent().setData(nodeData);
			node.getParent().getParent().setBlack();
			
			node.getParent().setData(parentData);
			node.getParent().setRed();
			
			//set the uncle node 
			node.getParent().getParent().getRightChild().setData(grandParentData);
			node.getParent().getParent().getRightChild().setRed();
			
			// check if the uncle node's right child is empty or not 
			if(node.getParent().getParent().getRightChild().getRightChild().getData()==0) {
				node.getParent().getParent().getRightChild().getRightChild().setData(uncleData);
				node.getParent().getParent().getRightChild().getRightChild().setBlack();
			}else {
				Node uncleRightChild = node.getParent().getParent().getRightChild().getRightChild();
				int uncleRightChildData = node.getParent().getParent().getRightChild().getRightChild().getData();

				while(uncleRightChild.getData()!=0) {
					uncleRightChild.setData(uncleData);
					uncleData = uncleRightChildData;
					uncleRightChild.setBlack();
					uncleRightChild = uncleRightChild.getRightChild();
				}
				
			}
			node.setData(0);
			node.getParent().getLeftChild().setData(0);
			
		}catch(NullPointerException e) {
			System.out.println("This node doesnt have a parent or uncle or grandParent"); 
		}
	}
	
	private void rightRightRotation(Node node){
		System.out.println("Do right right rotation");
		try {
			int parentData = node.getParent().getData();
			int uncleData = node.getUncle().getData();
			int grandParentData = node.getParent().getParent().getData();
			int nodeData = node.getData();
			
			//node.setUncle(new Node(grandParentData), node.getParent().getParent());
		    
			// set Parent node to be grandparent 
			node.getParent().getParent().setData(parentData);
			node.getParent().getParent().setBlack();
			
			// set inserted node 
			node.getParent().setData(nodeData);
			node.getParent().setRed();
			
			node.getParent().setRightChild(new Node());
			
			// set uncle node 
			node.getParent().getParent().setLeftChild(new Node(grandParentData));
			Node uncleNode = node.getParent().getParent().getLeftChild();
			uncleNode.setRed();
			if(uncleData == 0) {
				uncleNode.leftChild = new Node();
				uncleNode.rightChild = new Node();
			}else {
				uncleNode.leftChild = new Node(uncleData);
				uncleNode.leftChild.setBlack();
			}

		}catch(NullPointerException e) {
			System.out.println("This node doesnt have a parent or uncle or grandParent"); 
		}
		
	}
	
	private void rightLeftRotation(Node node) {
		try {
			int parentData = node.getParent().getData();
			int uncleData = node.getUncle().getData();
			int grandParentData = node.getParent().getParent().getData();
			int nodeData = node.getData();
			
			//change the parent node to become its value 
			node.getParent().setData(nodeData);
			node.getParent().setRed();
			
			//change the parent node.left child to parent value 
			node.getParent().getRightChild().setData(parentData);
			node.getParent().getRightChild().setRed();
			
			// and then left rotate 
			node.getParent().getParent().setData(nodeData);
			node.getParent().getParent().setBlack();
			
			node.getParent().setData(parentData);
			node.getParent().setRed();
			
			node.getParent().getParent().getLeftChild().setData(grandParentData);
			node.getParent().getParent().getLeftChild().setRed();
			
			// check if the uncle node's right child is empty or not 
			if(node.getParent().getParent().getLeftChild().getLeftChild().getData()==0) {
				node.getParent().getParent().getLeftChild().getLeftChild().setData(uncleData);
				node.getParent().getParent().getLeftChild().getLeftChild().setBlack();
			}else {
				Node uncleLeftChild = node.getParent().getParent().getLeftChild().getLeftChild();
				int uncleLeftChildData = node.getParent().getParent().getLeftChild().getLeftChild().getData();

				while(uncleLeftChild .getData()!=0) {
					uncleLeftChild.setData(uncleData);
					uncleData = uncleLeftChildData;
					uncleLeftChild .setBlack();
					uncleLeftChild  = uncleLeftChild.getLeftChild();
				}
							
			}
		    node.setData(0);
			node.getParent().getRightChild().setData(0);
						
		}catch(NullPointerException e) {
			System.out.println("This node doesnt have a parent or uncle or grandParent"); 
		}
		
	}
	
	public boolean isEmpty() {
		if(count == 0) {
			return true;
		}else 
			return false;
	}
	
	public void printTree() {
		printTreeInOrder(root);
	}
	
	private void printTreeInOrder(Node node) {
		System.out.printf("%d ",node.data, node.isRed); 
		if(node.leftChild != null) {
			printTreeInOrder(node.leftChild);
		}
		if(node.rightChild!=null) {
			printTreeInOrder(node.rightChild);
		}
	}
	public static void main(String [] args) {
		RedBlackTree rbt = new RedBlackTree();
		rbt.insert(8);
		rbt.insert(7);
		rbt.insert(9);
//		System.out.println(rbt.hasSamSizeSub());
//		System.out.println();
//		System.out.println(rbt.searchElement(5).getData());
//		System.out.println(rbt.searchElement(4).getData());
//		System.out.println(rbt.searchElement(6).getData());
//		
//		System.out.println(rbt.searchElement(4).getParent().getData());
//		System.out.println(rbt.searchElement(6).getParent().getData());
//		
		// try the left left case 
		rbt.insert(6);
//		System.out.println(rbt.hasSamSizeSub());
		rbt.insert(4);

		System.out.println();

		// try the right right case 
		rbt.insert(10);
		rbt.insert(12);
		
		// try the left right case 
		rbt.insert(5);
		
		rbt.insert(11);
		rbt.printTree();
		
		rbt.getRoot().getData();
		
//		System.out.println(rbt.hasSamSizeSub());
	}
}
