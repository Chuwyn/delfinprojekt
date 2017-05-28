import java.util.Scanner;

public class Coach {
	private String name;
	private Scanner scan;
	private Club club;
	private Leaderboard leaderboard;
	
	
	// Constructor
	public Coach(String name, Club club){
		this.name = name;
		scan = new Scanner(System.in);
		this.club = club;
		leaderboard = new Leaderboard();
	}
	
	// Methods
	public void LeaderboardMenu(){
		System.out.println("Welcome Coach");
		System.out.println("1. See leaderboard");
		System.out.println("2. Force update of leaderboard");
		System.out.println("3. Add Swim time to member");
		System.out.println("4. Exit");
		int choice = scan.nextInt();
		scan.nextLine();
		switch(choice){
		case 1:
			leaderboard.print();
			System.out.print("Exit? (y/n): ");
			String ans = scan.next();
			if(ans.equals("y")){
				System.exit(1);
			} else if(ans.equals("n")){
				LeaderboardMenu();
			} else {
				System.out.println("Invalid Choice... System shutting down...");
				System.exit(1);
			}
			break;
		case 2:
			System.out.println("Enter the discipline to calculate leaderboard: ");
			String discipline = scan.nextLine();
			leaderboard.calculateLeaderboard(club, discipline);
			LeaderboardMenu();
			break;
		case 3:
			searchForMemberMenu();
			break;
		case 4:
			System.exit(1);
		default:
			System.out.println("Invalid Choice...");
			LeaderboardMenu();
		}
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
				addTimeMenu(mem);
				break;
			default:
				System.out.println("Invalid Choice...");
				searchForMemberMenu();
			}
		}
	}
	
	private void addTimeMenu(Member mem){
		System.out.print("Enter time: ");
		int time = scan.nextInt();
		scan.nextLine();
		System.out.print("Enter discipline: ");
		String discipline = scan.nextLine();
		mem.addSwimtime(new SwimTime(time, discipline));
		LeaderboardMenu();
	}
	
	// Getters n Setters
	public String getName(){
		return name;
	}
	
	public void setName(String val){
		this.name = val;
	}
	
}
