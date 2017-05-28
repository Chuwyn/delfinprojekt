import java.util.ArrayList;

public class Member {
	private String name;
	private int age;
	private String membershipType;
	private ArrayList<String> disciplines;
	private ArrayList<SwimTime> swimTimes;
	
	// Constructor
	public Member(String name, int age, String membershipType){
		this.name = name;
		this.age = age;
		this.membershipType = membershipType;
		disciplines = new ArrayList<String>();
		swimTimes = new ArrayList<SwimTime>();
	}
	
	// Methods
	public void printInfo(){
		System.out.println("Member: " + name + "\nAge: " + age + "\nType: " + membershipType);
		System.out.println("Disciplines: ");
		int count = 1;
		for(String d : disciplines){
			System.out.println(count + ". " + d);
			count++;
		}
	}
	
	
	// This function are made for being used with ArrayList.contains
	public boolean equals(Object o){
		boolean same = false;
		if(o != null && o instanceof Member){
			same = ((Member) o).getName().equals(name);
		}
		return same;
	}
	
	public void addSwimtime(SwimTime time){
		if(swimTimes.contains(time)){
			 int index = swimTimes.indexOf(time);
			 if(time.getTime() < swimTimes.get(index).getTime()){
				 swimTimes.set(index, time);
			 }
		} else {
			swimTimes.add(time);
		}
	}
	
	// Getters n Setters
	public String getName(){
		return name;
	}
	
	public void setName(String val){
		name = val;
	}
	
	public int getAge(){
		return age;
	}
	
	public void setAge(int val){
		age = val;
	}
	
	public String getMembershipType(){
		return membershipType;
	}
	
	public void setMembershipType(String val){
		membershipType = val;
	}
	
	public ArrayList<String> getDisciplines(){
		return disciplines;
	}
	
	public void addDiscipline(String discipline){
		if(!disciplines.contains(discipline)){
			disciplines.add(discipline);
		} else {
			System.out.println("Member allready enrolled in that discipline");
		}
	}
	
	public SwimTime getSwimTime(String discipline){
		for(SwimTime t : swimTimes){
			if(t.getDiscipline().equals(discipline)) return t;
		}
		System.out.println("No Swim Time for that discipline");
		return null;
	}
	
	public void printBestSwimTimes(){
		for(SwimTime s : swimTimes){
			System.out.println("Discipline: " + s.getDiscipline() + " - Time: " + s.getTime());
		}
	}
}
