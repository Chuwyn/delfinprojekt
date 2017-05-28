import java.util.ArrayList;

public class Leaderboard {
	private ArrayList<Member> members; // Should be sorted so the first swimmer is the best etc.
	private String discipline;
	
	// Constructor
	public Leaderboard(){
		members = new ArrayList<Member>();
		discipline = "100 m";
	}
	
	// Methods
	public void calculateLeaderboard(Club club, String discipline){
		this.discipline = discipline;
		members = findTop5Members(club);
	}
	
	
	// Getters n Setters
	public ArrayList<Member> getMembers(){
		return members;
	}


	public void print() {
		System.out.println("Discipline: " + discipline);
		for(int i = 0; i < 5; i++){
			System.out.println((i+1) + ". " + members.get(i).getName() + " Time: " + members.get(i).getSwimTime(discipline).getTime() + " seconds");
		}
	}
	
	@SuppressWarnings("unchecked")
	private ArrayList<Member> findTop5Members(Club club){
		ArrayList<Member> temp = new ArrayList<Member>();
		ArrayList<Member> team = (ArrayList<Member>) club.getMembers().clone();
		for(int i = 0; i<5; i++){
			Member goodMem = team.get(0);
			for(Member m : team){
				goodMem = (goodMem.getSwimTime(discipline).getTime() < m.getSwimTime(discipline).getTime()) ? goodMem : m;
			}
			temp.add(goodMem);
			team.remove(goodMem);
			
		}
		return temp;
	}
}
