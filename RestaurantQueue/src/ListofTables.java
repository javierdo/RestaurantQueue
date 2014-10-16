
public class ListofTables {

	private NodeTable first;
	private NodeTable last;
	private int count;

	public ListofTables() {
		first = null;
		last = null;
		count = 0;
	}

	public class NodeTable {
		private Table atable;
		private NodeTable previous;
		private NodeTable next;

		public NodeTable() {
			atable = null;
			previous = null;
			next = null;
		}

		public NodeTable(Table data) {
			atable = data;
			previous = null;
			next = null;
		}

		public Table getAtable() {
			return atable;
		}

		public void setAtable(Table atable) {
			this.atable = atable;
		}

		public NodeTable getPrevious() {
			return previous;
		}

		public void setPrevious(NodeTable previous) {
			this.previous = previous;
		}

		public NodeTable getNext() {
			return next;
		}

		public void setNext(NodeTable next) {
			this.next = next;
		}
	}

	public void print() {
		/*
		 * This method prints out a line for each person who is in the queue
		 */
		// if (isEmpty()) {
		// System.out.println("Restaurant Empty");
		// } else {
		
		
		NodeTable tmpnode = first;
		while (tmpnode != null) {
			Table data = tmpnode.getAtable();
			System.out.println("Table " + data); // let's see if this works
			tmpnode = tmpnode.getNext();
		}
	}

	private boolean isEmpty() {
		//
		return (this.count == 0);
	}

	public int getNumberTables() {
		return count;
	}

	public void insertTablerear(Table atable) {
		NodeTable newnode = new NodeTable(atable);
		if (isEmpty()) {// first table
			first = newnode;
			last = newnode;
		} else {
			last.next = newnode;
			newnode.previous = last;
			last = newnode;
		}
		count = count + 1;
		System.out.println("      Number of tables now: " + getNumberTables());
	}

	public ListofTables organizeTablesSimple(CustomerQueue aqueue, int seats) {

		CustomerQueue clientqueue = aqueue;
		ListofTables tables = new ListofTables();
		NodeQ anotherclient = clientqueue.getFirst();
		NodeTable travtables;

		while (anotherclient != null) {
			int thetshirt = anotherclient.getAclient().getTshirt();
			System.out.println("New customer to be seated --> " + thetshirt);
			boolean friendplaced = true;
			Table currtable = new Table(seats);
			boolean tableisfull =false;
			travtables = tables.first;  //  
			while ((travtables != null) && (friendplaced || tableisfull)) { // 
				currtable = travtables.getAtable();
				friendplaced = currtable.isGroupseated(thetshirt);
				tableisfull = currtable.isFull();
				if ((friendplaced) || (tableisfull)) { //  
					travtables = travtables.getNext();
					if (travtables != null) {
						currtable = travtables.getAtable();
						friendplaced = currtable.isGroupseated(thetshirt);
						tableisfull = currtable.isFull();
					}				
				}
			}
			
			if (travtables == null) { // this should be the last table free
				Table newtable = new Table(seats);
				newtable.seatClient(thetshirt);
				tables.insertTablerear(newtable);
			} else {
				currtable.seatClient(thetshirt);
			}			
			// advance one node
			anotherclient = anotherclient.getNext();
		}
		return tables;
	}
}