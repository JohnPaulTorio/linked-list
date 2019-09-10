class NodeManager
{
	static Node head;
	static Node end;
	Node findNode;

	public void addHead(Object o) {
		head = new Node(o);
		end = getEndNode(head);
		System.out.println("Successfully created a new head node.");
	}

	public void changeHead(Object o) {
		head.setData(o);
		if (head.next == null) {
			end = getEndNode(head);
		}
		System.out.println("Successfully changed the head node.");
	}

	private Node getEndNode(Node n) {
		if(n.next == null || n.next.data == null) {
			return n;
		}
		n.next.setPrev(n);
		return getEndNode(n.next);
	}

	private Node getHeadNode(Node n) {
		if(n.prev == null || n.prev.data == null) {
			return n;
		}
		return getHeadNode(n.prev);
	}

	public void addBefore(Object o) {
		head = new Node(o).setNext(head);
		end = getEndNode(head);
		System.out.println("Successfully created a node before head.");
	}

	public void addAfter(Object o) {
		getEndNode(head).next = new Node(o).setPrev(getEndNode(head));
		end = getEndNode(head);
		System.out.println("Successfully created a new end node.");
	}

	public void deleteHead() {
		head = head.next.setNext(head.next.next);
		head.prev = null;
		System.out.println("Successfully deleted head node. New head node assigned.");
	}

	public void deleteEnd() {
		end.data = null;
		end = null;
		end = getEndNode(head);
		System.out.println("Successfully deleted end node.");
	}

	public void viewAll(Node n) {
		if(n.next == null || n.next.data == null) {
			System.out.println(n.data);
		}
		else {
			System.out.print(n.data + " -> ");
			viewAll(n.next);
		}
	}

	public void viewRange(Node n, String s) {
		if(n.getData().equals(s)) {
			System.out.println(n.data);
		}
		else {
			System.out.print(n.data + " -> ");
			viewRange(n.next, s);
		}
	}

	public void reverseViewAll(Node n) {
		if (n.prev == null) {
			System.out.println(n.data);
		}
		else {
			System.out.print(n.data + " <- ");
			reverseViewAll(n.prev);
		}
	}

	public Node findNode(Node n, String s) {
		if (n.data.equals(s)) {
			return n;
		}
		return findNode(n.next, s);
	}

	public void addMid(String s, Object o) {
		findNode = findNode(head, s);
		findNode.setNext(new Node(o).setNext(findNode.next).setPrev(findNode));
		findNode.next.next.setPrev(findNode.next);
		System.out.println("Successfully added the new node beside " + s + ".");
	}
}
