

public class NodeQ {
	private Client aclient;
	private NodeQ previous;
	private NodeQ next;

	public NodeQ(){
		aclient= null; previous = null; next = null;	}
	public NodeQ(Client data) {
		aclient = data;
		previous = null;
		next=null;
	}
	public Client getAclient() {
		return aclient;
	}
	public void setAclient(Client aclient) {
		this.aclient = aclient;
	}
	public NodeQ getPrevious() {
		return previous;}
	public void setPrevious(NodeQ previous) {
		this.previous = previous;
	}
	public NodeQ getNext() {
		return next;
	}
	public void setNext(NodeQ next) {
		this.next = next;
	}
}
