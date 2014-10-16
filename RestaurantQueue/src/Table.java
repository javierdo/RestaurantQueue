

class Table {
	private int[] seats;
	private boolean filled; // the table is full
	int inf = (int) (Double.POSITIVE_INFINITY); // type casting to int

	public Table(int seatsintable) {
		this.seats = new int[seatsintable];
		for (int i = 0; i < seatsintable; i++) {
			seats[i] = inf;
		}
		filled = false;
	}

	public boolean isFull() {
		return filled;
	}

	public boolean isGroupseated(int tshirt) {
		boolean seated = false;
		for (int i = 0; i < seats.length; i++) {
			if (seats[i] == tshirt) {
				seated = true;
				break;
			}
		}
		System.out.println(" --- checking Table for :" + tshirt + " if is in the table  "
				+ this.toString());
		return seated;
	}

	public void seatClient(int tshirt) {
		int i = 0;
		if (!filled) {
			for (i = 0; i < seats.length; i++) {
				if (seats[i] == inf) {
					seats[i] = tshirt;
					break;
				}
			}
		} else {// TODO throw exception
		}
		if (i == (seats.length-1)) {
			filled = true;
		}
		System.out.println("        seated in table -->" + this.toString());
	}

	public int[] getSeats() {
		return seats;
	}

	public String toString() {
		String result = "";
		int scan = 0;
		while (scan < seats.length) {
			if (seats[scan] != inf) {
				result += seats[scan] + "  ";
			}
			scan++;
		}
		return result;
	}
}