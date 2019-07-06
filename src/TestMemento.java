

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class TestMemento extends JFrame{
	
	private JButton saveBut, undoBut, redoBut;
	private JTextArea theArticle= new JTextArea(40,60);
	Caretaker caretaker =new Caretaker();
	Originator originator=new Originator();
	int saveFiles=0, currentArticle=0;

	public TestMemento() {
		this.setSize(750,780);
		this.setTitle("Memento Design Pattern");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel1=new JPanel();
		panel1.add(new JLabel("Article"));
		panel1.add(theArticle);
		
		ButtonListener save=new ButtonListener();
		ButtonListener undo=new ButtonListener();
		ButtonListener redo=new ButtonListener();
		
		saveBut=new JButton("Save");
		saveBut.addActionListener(save);
		
		undoBut=new JButton("Undo");
		undoBut.addActionListener(undo);
		
		redoBut=new JButton("Redo");
		redoBut.addActionListener(redo);
		
		panel1.add(saveBut);
		panel1.add(undoBut);
		panel1.add(redoBut);
		
		this.add(panel1);
		this.setVisible(true);
		
	}
	
	public static void main(String[] args) {
		new TestMemento();
	}
	
	class ButtonListener implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			
			if(e.getSource()==saveBut){
				String text=theArticle.getText();
				originator.set(text);
				caretaker.addMemento(originator.storeInMemento());
				saveFiles++;
				currentArticle++;
				
				System.out.println("Saved Files: "+saveFiles);
				
				undoBut.setEnabled(true);
			}
			else if(e.getSource()==undoBut){
				if(currentArticle>=1){
				currentArticle--;
				String text=originator.restoreFromMemento(caretaker.getMemento(currentArticle));
				theArticle.setText(text);
				redoBut.setEnabled(true);
				}
				else{
					undoBut.setEnabled(false);
				}
			}
			else if (e.getSource()==redoBut){
				if((saveFiles-1)>currentArticle){
					currentArticle++;
					String text=originator.restoreFromMemento(caretaker.getMemento(currentArticle));
					theArticle.setText(text);
					undoBut.setEnabled(true);
				}
				else{
					redoBut.setEnabled(false);
				}
					
		}
		
		}
	}

}
