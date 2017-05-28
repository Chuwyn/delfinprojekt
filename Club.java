import java.util.ArrayList;
import java.util.Scanner;

public class Club {
	private String name;
	private President president;
	private Coach coach;
	private ArrayList<Member> members;
	private Scanner scan;
	
	// Constructor
	public Club(String name){
		this.name = name;
		president = new President("Delfin Pressi", this);
		coach = new Coach("Delfin imba Coach", this);
		members = new ArrayList<Member>();
		// Test Data
		members.add(new Member("Bob One", 20, "Active Senior Competetive"));
		members.add(new Member("Bob Two", 24, "Active Senior Competetive"));
		members.add(new Member("Bob Three", 28, "Active Senior Competetive"));
		members.add(new Member("Bob Four", 32, "Active Senior Competetive"));
		members.add(new Member("Bob Five", 36, "Active Senior Competetive"));
		members.add(new Member("Bob Six", 40, "Active Senior Competetive"));
		int count = 1;
		for(Member m : members){
			m.addDiscipline("100 m");
			count++;
			m.addSwimtime(new SwimTime((200 + count), "100 m"));
			System.out.println(count);
		}
		
		
		scan = new Scanner(System.in);
		
		firstMenu();
	}
	
	// Methods
	
	private void firstMenu(){
		System.out.println("Welcome to " + name);
		System.out.println("How do you wanna continue:");
		System.out.println("1. As President");
		System.out.println("2. As Coach");
		System.out.println("3. As Cashier");
		int choice = scan.nextInt();
		switch(choice){
		case 1:
			president.CRUDMemberMenu();
			break;
		case 2:
			coach.LeaderboardMenu();
			break;
		case 3:
			System.out.println("Cashier not yet to be implemented");
			firstMenu();
			break;
		default:
			System.out.println("Invalid choice");
			firstMenu();
		}
	}
	
	public Member searchForMember(String name) {
		Member temp = null;
		for(Member m : members){
			if(m.getName().equals(name)){
				temp = m;
			}
		}
		return temp;
	}
	
	
	// Getters n Setters
	public String getName(){
		return name;
	}
	
	public void setName(String val){
		name = val;
	}
	
	public President getPresident(){
		return president;
	}
	
	public void setPresident(President val){
		president = val;
	}
	
	public Coach getCoach(){
		return coach;
	}
	
	public void setCoach(Coach val){
		coach = val;
	}
	
	public ArrayList<Member> getMembers(){
		return members;
	}
	
	public void addMember(Member member){
		if(!members.contains(member)){
			members.add(member);
		}
	}

	
	
	
	
}
