import java.util.Scanner;

class MainClass
{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Object data = "";
		String side;
		String range = "";
		String choice = "";
		String choice2 = "";
		String choices = "          [2]Add a node\n[3]Delete a node           [4]View all nodes from head to end\n[5]Display a range of node     [6]View all nodes from end to head\n[7]Exit\nChoice: ";
		NodeManager nm = new NodeManager();
		while(!choice.equals("7")) {
			System.out.print(nm.head == null?"[1]Create a head node"+choices:"[1]Edit the head node"+choices);
			choice = sc.nextLine();
			if(choice.matches("[23456]+") && nm.head == null) {
				System.out.println("Please create a head node first!");
			}
			else {
				switch(choice) {
					case "1" :	
						System.out.print("Please enter a data for the head Node: ");
						if (nm.head == null) {
							nm.addHead(sc.nextLine());
						}
						else {
							nm.changeHead(sc.nextLine());
						}
						break;
					case "2" : 
						System.out.print("[1]Head [2]Middle [3]End: ");
						choice2 = sc.nextLine();
						switch (choice2) {
							case "1":
								System.out.print("Please enter a data for the Node: ");
								nm.addBefore(sc.nextLine());
								break;
							case "2":
								if (nm.head.next == null || nm.head.next.data == null) {
									System.out.println("There is only 1 node. Can't add in the middle because there is no middle!");
								}
								else {
									System.out.print("Please enter a data for the Node: ");
									data = sc.nextLine();
									System.out.print("Enter the data of the node to be followed: ");
									side = sc.nextLine();
									nm.addMid(side, data);
								}
								break;
							case "3":
								System.out.print("Please enter a data for the Node: ");
								nm.addAfter(sc.nextLine());
								break;
							default:
								System.out.println("Please choose from 1 to 3");
								break;
						}
						break;
					case "3" :
						if(nm.head.next == null || nm.head.next.data == null)
							System.out.println("You cannot delete a head node, please assign a new one before deleting."); 
						else {
							System.out.print("[1]Head [2]End: ");
							choice2 = sc.nextLine();
							switch (choice2) {
								case "1":
									nm.deleteHead();
									break;
								case "2":
									nm.deleteEnd();
									break;
								default:
									System.out.println("Please choose from 1 and 2.");
									break;
							}
						}	
						break;
					case "4" : 
						nm.viewAll(nm.head);
						break;
					case "5" :
						System.out.print("Please enter the data of the node as limit: ");
						range = sc.nextLine();
						nm.viewRange(nm.head, range);
						break;						
					case "6" : 
						nm.reverseViewAll(nm.end);
						break;
					case "7" : 
						System.out.println("Bye");
						break;
					default : System.out.println("Invalid input, please choose from 1 to 6.");
						break;
				}
			}
		}
	}
}
