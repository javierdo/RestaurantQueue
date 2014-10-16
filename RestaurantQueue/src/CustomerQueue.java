

public class CustomerQueue {
	/*
	 * This is a queue of groups of customers
	 */

	private NodeQ first;
	private NodeQ last;
	private int count;

	public CustomerQueue() {
		first = null;
		last = null;
	}

	public NodeQ getFirst() {
		return first;
	}

	public void setFirst(NodeQ first) {
		this.first = first;
	}

	public NodeQ getLast() {
		return last;
	}

	public void setLast(NodeQ last) {
		this.last = last;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public boolean isEmpty() {
		return (first == null);
	} // or count==0 if count is used in the definition

	private boolean containsTin(Client dataclient) {
		boolean found = false;
		NodeQ tmpnode = first;
		while (tmpnode != null && !found) {
			Client data = tmpnode.getAclient();
			if (data.getTin().equals(dataclient.getTin())) {
				found = true;
			}
			tmpnode = tmpnode.getNext();
		}
		return found;
	}

	public void print() {
		/*
		 * This method prints out a line for each person who is in the queue
		 */
		if (isEmpty()) {
			System.out.println("Queue Empty");
		} else {
			NodeQ tmpnode = first;
			while (tmpnode != null) {
				Client data = tmpnode.getAclient();
				System.out.println(data.getTshirt() + " " + data.getBill()
						+ " " + data.getTin());
				tmpnode = tmpnode.getNext();
			}
		}

	}

	public void addClient2front(Client clientdata) {
		NodeQ newnode = new NodeQ(clientdata);
		if (count == 0) {
			last = newnode;
		} else {
			first.setPrevious(newnode);
			newnode.setNext(first);
		}
		first = newnode;
		this.count = this.count + 1;
	}
	
	public void addClient2rear(Client clientdata) {
		/*
		 * This method adds a client to the end of the Queue. This method first
		 * checks that the queue is not empty.
		 */
		NodeQ newnode = new NodeQ(clientdata);
		if (count == 0) {
			first = newnode;
		} else {
			last.setNext(newnode);
			newnode.setPrevious(last);
		}
		last = newnode;
		this.count = this.count + 1;
	}

	public void print(int tshirt) {
		if (this.isEmpty()) {  //preconditions met   (described in the exam)
			System.out.println("Empty queue");
		} else {
			NodeQ traverse;
			Client travclient;
			traverse = first;
			travclient = traverse.getAclient();
			while (travclient.getTshirt()!=tshirt) {  //assume no need to check null
				traverse=traverse.getNext();
				travclient=traverse.getAclient();
			}
			System.out.println("  T-shirt : "+tshirt);
			while ((travclient.getTshirt()==tshirt)&&(traverse!=null)) {
				System.out.println(traverse.getAclient().getTin());
				traverse=traverse.getNext();
				travclient=traverse.getAclient();
				
			}

		}
	}

	public void insertGroup(CustomerQueue groupclients) {
		if (count == 0) {
			first = groupclients.first;
		} else {
			last.setNext(groupclients.first);
		}
		last = groupclients.last;
		this.count = this.count + groupclients.count;
	}

	public void invoiceGroups() {
		// precondition: not empty, otherwise test for empty queue and/or other conditions
		
		NodeQ traverse;
		traverse=first;
		double sum;
		double bill;
		int prevtshirt,travtshirt;
		while (traverse != null) {
			sum =0;
			prevtshirt= travtshirt= traverse.getAclient().getTshirt();		
			while ((traverse!=null)&&(prevtshirt==travtshirt)) {
				bill = traverse.getAclient().getBill();
				sum = sum + bill;
				traverse=traverse.getNext();
				if (traverse!=null) {
					travtshirt=traverse.getAclient().getTshirt();
				}		
			}
			System.out.println("Bill for group "+prevtshirt+ " comes to: " + sum);
		}
		
		
	}

	public void insertClient(Client clientdata) {
		NodeQ previous = null, current;
		int tshirtcurrent, tshirtclient;
		tshirtclient = clientdata.getTshirt();
		NodeQ newnode = new NodeQ(clientdata);

		if (isEmpty()) {  // 
			first = newnode;
			last = newnode;
			count = 1;
		} else {
			// to do find correct place and check if last node.Also check if
			// first node.
			current = first;
			boolean found = false;
			while (!found && (current != null)) {
				tshirtcurrent = current.getAclient().getTshirt();
				found = tshirtcurrent == tshirtclient;
				previous = current;
				current = current.getNext();
			}
			if (found) {
				// set links
				if (current == null) { // we are in the last node
					addClient2rear(clientdata);
				} else if (previous == first) { // we are in the first node
					addClient2front(clientdata);
				}
				else { // insert BEFORE previous, which is the first appearance of the group
					current = previous; // insert at the beginning	of the group 
					newnode.setNext(current);
					newnode.setPrevious(current.getPrevious());
					current.getPrevious().setNext(newnode);
					current.setPrevious(newnode);
					this.count=this.count+1;

				}
			} else { // not found, add client to the end
				addClient2rear(clientdata);
			}
		}
	}

	public double removeGroup(int tshirt) {
		int sum = 0;

		return sum;
	}

	public Client removeFirstinLine() {
		Client client = null;
		if (!isEmpty()) {
			client = first.getAclient();
		}
		this.count=this.count-1;
		return client;
	}
}
