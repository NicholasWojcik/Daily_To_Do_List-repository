package Main;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.StringTokenizer;

public class Writer {
	String day;
	String month;
	String year;
	String complete;
	String delim = "/";
	
	public Writer() {
		try {
			BufferedWriter writing = new BufferedWriter(new FileWriter("items_list"));
			DateFormat DF = new SimpleDateFormat("dd/MM/yyyy");
			Date date = new Date();
			complete = DF.format(date);
			setDate();
			writing.write(day + " ");
			writing.write(month + " ");
			writing.write(year);
			
			writing.newLine();
			writing.newLine();
			
			for(ListItem i:DailyChecklist.items){
				System.out.println(i.getName());
				writing.write(i.getName());
				writing.newLine();
			}
			writing.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void setDate(){
		StringTokenizer st = new StringTokenizer(complete, delim);
		int i = 0;
		while(st.hasMoreTokens()){
			if(i == 0){
				day = st.nextToken();
				//needs work, problems will occur at the changing of months //
				if(DailyChecklist.program.tomorrowRB.isSelected()){         //
					day = Integer.toString(((Integer.parseInt(day)) + 1));  //
				}                                                           //
				//----------------------------------------------------------//
				System.out.println(day);
			}
			else if(i == 1){
				switch(Integer.parseInt(st.nextToken())){
					case 1: month = "January";
					break;
					case 2: month = "February";
					break;
					case 3: month = "March";
					break;
					case 4: month = "April";
					break;
					case 5: month = "May";
					break;
					case 6: month = "June";
					break;
					case 7: month = "July";
					break;
					case 8: month = "August";
					break;
					case 9: month = "September";
					break;
					case 10: month = "October";
					break;
					case 11: month = "November";
					break;
					case 12: month = "December";
					break;
					default: month = "failure";
					break;
				}
				System.out.println(month);
			}
			else if(i == 2){
				year = st.nextToken();
				System.out.println(year);
			}
			i++;
		}
	}
	
}
