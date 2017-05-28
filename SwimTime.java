public class SwimTime {
	private int time;
	private String discipline;
	
	// Constructor
	public SwimTime(int time, String discipline){
		this.time = time;
		this.discipline = discipline;
	}
	
	// Methods
	
	public boolean equals(Object o){
		boolean same = false;
		
		if(o != null && o instanceof SwimTime){
			same = this.discipline.equals(((SwimTime) o).getDiscipline());
		}
		return same;
	}
	// Getters n Setters
	public int getTime(){
		return time;
	}
	
	public String getDiscipline(){
		return discipline;
	}
	
	
}
