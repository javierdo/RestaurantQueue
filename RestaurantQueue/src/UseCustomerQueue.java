
public class UseCustomerQueue {

	public static void main(String[] args) {
		CustomerQueue openbuffet = new CustomerQueue();
		CustomerQueue group9 = new CustomerQueue();

		Client client1 = new Client(11, "BFCV", 10);
		Client client2 = new Client(5, "AFCV", 20);
		Client client3 = new Client(5, "ADCV", 30);
		Client client4 = new Client(7, "XFCV", 40);
		Client client5 = new Client(5, "AECV", 50);
		Client client6 = new Client(5, "ABCV", 60);
		Client client7 = new Client(9, "MBCV", 70);
		Client client8 = new Client(8, "TLCV", 80);
		Client client9 = new Client(9, "RBCV", 90);
		Client client10 = new Client(11, "BBCV", 100);
		Client client11 = new Client(8, "TBCV", 110);
		Client client12 = new Client(13, "SBCV", 120);
		Client client13 = new Client(13, "XBCV", 130);
		Client client14 = new Client(13, "ZZCV", 140);

		group9.insertClient(client7);
		group9.insertClient(client9);

		openbuffet.insertClient(client1);
		openbuffet.insertClient(client2);
		openbuffet.insertClient(client10);

		openbuffet.print();
		System.out.println("Print group 9");
		group9.print();
		System.out.println("Add group 9");
		openbuffet.insertGroup(group9);
		openbuffet.print();
		openbuffet.insertClient(client12);
		openbuffet.insertClient(client13);
		openbuffet.insertClient(client14);

		openbuffet.insertClient(client6);
		openbuffet.insertClient(client5);
		openbuffet.insertClient(client4);
		openbuffet.insertClient(client4);
		openbuffet.insertClient(client8);	
		
		System.out.println("Print the list");
		openbuffet.print();
		openbuffet.print(9);

		openbuffet.invoiceGroups();

		ListofTables alistoftables = new ListofTables();
		alistoftables = alistoftables.organizeTablesSimple(openbuffet, 6);
		System.out.println("Number of tables : " + alistoftables.getNumberTables());
		alistoftables.print();
	}
}
