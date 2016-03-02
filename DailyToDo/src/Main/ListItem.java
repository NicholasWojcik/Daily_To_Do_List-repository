package Main;

public class ListItem {
	String name = "";
	String date = "";
	
	public ListItem(String init){
		name = init;
	}
	
	public void setName(String newName){
		name = newName;
	}
	public void setDate(String newDate){
		date = newDate;
	}
	public String getName(){
		return name;
	}
	public String getDate(){
		return date;
	}

}
