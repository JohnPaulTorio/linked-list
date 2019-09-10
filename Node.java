class Node extends Object
{
	Object data;
	Node next;
	Node prev;

	public Node(Object data) {
		this.data = data;
	}

	public Node setNext(Node next) {
		this.next = next;
		return this;
	}

	public Node setPrev(Node prev) {
		this.prev = prev;
		return this;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public String getData() {
		return data.toString();
	}
}
