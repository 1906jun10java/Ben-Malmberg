
public class NodeMethods {

	Node queue;
	public Node[] nodeQ;

	public NodeMethods() {
		
		Node N=new Node();
		
		nodeQ= {N};
		this.queue= new Node();

		

	}

	

	public void put() {
		Node node = this.nodeQ[0];

		while (node.next != null) {
			node = node.next;
		}
		node.next = new Node();
	}

	public int peek(Node[] nodeQ) {
		Node node = nodeQ[0];
		return node.id;
	}

	public Node[] pop() {

		peek(nodeQ);
		Node node = nodeQ[0];

		nodeQ[0] = nodeQ[0].next;

		return nodeQ;
	}

}
