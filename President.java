import java.util.Scanner;

public class President {
	private String name;
	private Club club;
	private Scanner scan;
	
	// Constructor
	public President(String name, Club club){
		this.name = name;
		this.club = club;
		scan = new Scanner(System.in);
	}
	
	// Methods
	public void CRUDMemberMenu(){
		System.out.println("Welcome " + name);
		System.out.println("1. Add a member");
		System.out.println("2. Find/Edit a member");
		System.out.println("3. Exit");
		int choice = scan.nextInt();
		switch(choice){
		case 1:
			addMemberMenu();
			break;
		case 2:
			searchForMemberMenu();
			break;
		case 3:
			System.exit(1);
		default:
			System.out.println("Invalid Choice");
			CRUDMemberMenu();
		}
	}
	
	private void addMemberMenu(){
		String name;
		int age;
		String membership;
		scan.nextLine();
		System.out.print("Input member name: ");
		name = scan.nextLine();
		System.out.print("Input member age: ");
		age = scan.nextInt();
		scan.nextLine();
		System.out.print("Input membership Type: ");
		membership = scan.nextLine();
		club.addMember(new Member(name, age, membership));
		CRUDMemberMenu();
	}
	
	private void searchForMemberMenu(){
		scan.nextLine();
		System.out.println("Enter member name: ");
		String name = scan.nextLine();
		if(club.searchForMember(name) == null) {
			System.out.println("No member found");
			searchForMemberMenu();
		} else {
			Member mem = club.searchForMember(name);
			System.out.println("Member found...");
			mem.printInfo();
			System.out.print("Search again? (y/n) ");
			String choice = scan.nextLine();
			switch(choice.toLowerCase()){
			case "y":
				searchForMemberMenu();
				break;
			case "n":
				editMemberMenu(mem);
				break;
			default:
				System.out.println("Invalid Choice...");
				searchForMemberMenu();
			}
		}
	}
	
	
	
	private void editMemberMenu(Member mem) {
		System.out.println("1. Edit name");
		System.out.println("2. Edit age");
		System.out.println("3. Edit membership Type");
		System.out.println("4. See best training times");
		int choice = scan.nextInt();
		scan.nextLine();
		switch(choice){
		case 1:
			System.out.print("Enter new name: ");
			String newName = scan.nextLine();
			mem.setName(newName);
			break;
		case 2:
			System.out.println("Enter new age: ");
			int age = scan.nextInt();
			mem.setAge(age);
			break;
		case 3:
			System.out.println("Enter new membership type");
			String type = scan.nextLine();
			mem.setMembershipType(type);
			break;
		case 4:
			mem.printBestSwimTimes();
			break;
		default:
			System.out.println("Invalid Choice....");
			editMemberMenu(mem);
		}
	}

	// Getters n Setters
	public String getName(){
		return name;
	}
}
