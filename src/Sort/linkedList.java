package Sort;

public class linkedList {
	class Node{
		double data;
		Node next;
		Node prev;
		Node(){
			data = 0;
			next = null;
			prev = null;
		}
		
		Node (double data){
			this.data = data;
			next = prev = null;
		}
	}
	Node head = new Node();
	int count = 0;
	public boolean isEmpty() {
		if(count == 0) {
			return true;
		}else 
			return false;
	}
	
	public void insert(double data) {
		if(isEmpty()) {
			Node newNode = new Node(data);
		    newNode.next = head.next;
			head.next = newNode;
			newNode.prev = head;
			count++;
		}
		else {
			Node headNode = head;
			
			while (headNode.next!=null) {
				headNode = headNode.next;
				if(headNode.data > data) {
					break;
				}
			}
			
			// try the insertion sort 
			Node newNode = new Node(data);
			if(headNode.next == null) {
				newNode.next = headNode.next;
				headNode.next =newNode;
				newNode.prev = headNode;
				count++;
			}else {
				// the list is not the end
				
				Node preNode = headNode.prev;
				newNode.next = preNode.next;
				preNode.next = newNode;
				newNode.prev = headNode.prev;
				headNode.prev = newNode;
				count++;
				
			}
			
		}
	}
	
	public void printList() {
		Node node = head.next;
		while(node!=null) {
			System.out.println(node.data);
			node = node.next;
		}
	}

}
