package Main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JRadioButton;
import javax.swing.JTextField;


public class DailyChecklist {
	public static DailyChecklist program;
	public JButton submitItem;
	public JButton clrItem;
	public JButton print;
	public JButton remove;
	public JTextField entry;
	public JRadioButton todayRB;
	public JRadioButton tomorrowRB;
	public JList<Object> display;
	public DefaultListModel<Object> listModel;
	public static ArrayList<ListItem> items = new ArrayList<ListItem>();

	public static void main(String[] args) {
		program = new DailyChecklist();
	}

	public DailyChecklist(){
		JFrame window = new JFrame("Daily Checklist");
		window.setSize(300, 300);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(false);
		window.setFocusable(true);
		window.setLayout(null);
		
		todayRB = new JRadioButton("today");
		todayRB.setBounds(30, 180, 60, 20);
		todayRB.setSelected(true);
		tomorrowRB = new JRadioButton("tomorrow");
		tomorrowRB.setBounds(90, 180, 100, 20);
		ButtonGroup grp = new ButtonGroup();
		grp.add(todayRB);
		grp.add(tomorrowRB);
		
		submitItem = new JButton("add");
		submitItem.setBounds(10, 240, 125, 20);
		clrItem = new JButton("CLR");
		clrItem.setBounds(140, 240, 69, 20);
		remove = new JButton("remove");
		remove.setBounds(210, 10, 80, 30);
		entry = new JTextField("Enter task...");
		entry.setBounds(10, 210, 200, 25);
		print = new JButton("print");
		print.setBounds(215, 210, 75, 50);
		listModel = new DefaultListModel<Object>();
		display = new JList<Object>(listModel);
		display.setBounds(10, 10, 195, 160);
		
		submitItem.addActionListener(new SubmitListener());
		clrItem.addActionListener(new ClearListener());
		entry.addFocusListener(new EntryListener());
		remove.addActionListener(new removeListener());
		print.addActionListener(new printListener());
		
		window.getContentPane().add(tomorrowRB);
		window.getContentPane().add(todayRB);
		window.getContentPane().add(submitItem);
		window.getContentPane().add(clrItem);
		window.getContentPane().add(entry);
		window.getContentPane().add(print);
		window.getContentPane().add(display);
		window.getContentPane().add(remove);
		window.setVisible(true);
	}
	
	public void addItem(String item){
		ListItem toAdd = new ListItem(item);
		items.add(toAdd);
	}
	public void removeItem(){
		if(display.getSelectedValue() != null){
			items.remove(display.getSelectedIndex());
			listModel.remove(display.getSelectedIndex());
		}	
	}
	public void populateList(){
		for(int i = 0; i < items.size(); i++){
			ListItem tempItem = (ListItem)items.get(i);
			listModel.addElement(tempItem.getName());
		}
	}

	class SubmitListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			program.addItem(entry.getText());
			entry.setText("");
			listModel.clear();
			populateList();
		}
	}
	class ClearListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			entry.setText("");
		}
	}
	class EntryListener implements FocusListener{
		public void focusGained(FocusEvent arg0) {
			entry.setText("");
		}
		public void focusLost(FocusEvent arg0) {
		}
	}
	class removeListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			removeItem();
		}
		
	}
	class printListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			Writer go = new Writer();
		}
		
	}
}
