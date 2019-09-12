package TestDemo;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import javax.swing.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;


public class TestDemo {
	
	private JFrame mainFrame;
	private JTabbedPane tabFrame;
	private JPanel registerPanel, examPanel, markPanel;
	private JPanel studentPanel, teacherPanel; 
	private JPanel controlPanel1, controlPanel2, controlPanel3, controlPanel4;
	private JPanel controlPanel5, controlPanel6, controlPanel7, controlPanel8;
	private JPanel controlPanel9, controlPanel10, controlPanel11, controlPanel12;
	private JRadioButton radioButton1, radioButton2, radioButton3, radioButton4;
	private ImageIcon imgIcon1, imgIcon2;
	
	private String[] strProblem = new String[100];
	
	private String strStudentName, strStudentSex, strProblemTitle;
	private String strLabel, strReport;
	private int nProblemNumber, nPageNumber;
	private int nProblemCount, nAnswerCount, nStudentMark;
	private boolean bRadio1, bRadio2, bRadio3, bRadio4;
		
	// ---------- Problem Data ------------
	private String[] strTextArea = new String[10];
	private String[] strText1 = new String[10];
	private String[] strText2 = new String[10];
	private String[] strText3 = new String[10];
	private String[] strText4 = new String[10];
	private int[] nCorrectNumber = new int[10];
		
	// =======================================================
	public static void main(String[] srgs) throws IOException {
		
		TestDemo testDemo = new TestDemo();
		
		testDemo.ReadFileName();
		testDemo.showStudentDemo(0);
		testDemo.showTeacherDemo();		
		
	}
		
	// -----------------------------------------------
	private void ReadFileName() {
		try {
			
			File myFile = new File("Data/fileName.txt");
			Scanner myReader = new Scanner(myFile);
			nProblemNumber = Integer.valueOf(myReader.next());
			for (int i = 0; i < nProblemNumber; i++)
				strProblem[i] = myReader.next();
			
			myReader.close();
				
			
		} catch (FileNotFoundException e) {
			System.out.println("File read error occurred.");
			e.printStackTrace();
		}
		
			
	}
	
	
	// -----------------------------------------------
	public TestDemo() throws IOException {
		// Crate and set up the window
		nPageNumber = 0;
		nProblemCount = 0;
		nAnswerCount = 0;
		nStudentMark = 0;

		BufferedImage img1 = ImageIO.read(new File("1.png"));
		BufferedImage img2 = ImageIO.read(new File("2.png"));
		
		imgIcon1 = new ImageIcon(img1);
		imgIcon2 = new ImageIcon(img2);

		prepareMainGUI();
		prepareComponentGUI();
		
	}
	
	// ------------------------------------------------
	private void prepareMainGUI() {

		mainFrame = new JFrame("Computer Test Demo");
		// Display the window
		mainFrame.setSize(600, 480);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setLayout(new GridLayout(1, 1));
		
		studentPanel = new JPanel();
		studentPanel.setLayout(new GridLayout(1, 1));
		teacherPanel = new JPanel();
		teacherPanel.setLayout(new GridLayout(4, 1));
		
		
		tabFrame = new JTabbedPane(JTabbedPane.TOP);
		tabFrame.addTab("Student", null, studentPanel, "Test student");
		tabFrame.addTab("Teacher", null, teacherPanel, "Submit problem");
	
	}
	
	// ------------------------------------------------
	private void prepareComponentGUI() {
	
		registerPanel = new JPanel();
		registerPanel.setLayout(new GridLayout(5, 1));
		examPanel = new JPanel();
		examPanel.setLayout(new GridLayout(4, 1));
		markPanel = new JPanel();
		markPanel.setLayout(new GridLayout(4,1));
		
		controlPanel1 = new JPanel();
		controlPanel1.setLayout(new FlowLayout());
		controlPanel2 = new JPanel();
		controlPanel2.setLayout(new FlowLayout());
		controlPanel3 = new JPanel();
		controlPanel3.setLayout(new FlowLayout());
		controlPanel4 = new JPanel();
		controlPanel4.setLayout(new FlowLayout());

		controlPanel5 = new JPanel();
		controlPanel5.setLayout(new FlowLayout());
		controlPanel6 = new JPanel();
		controlPanel6.setLayout(new FlowLayout());
		controlPanel7 = new JPanel();
		controlPanel7.setLayout(new FlowLayout());
		controlPanel8 = new JPanel();
		controlPanel8.setLayout(new FlowLayout());

		controlPanel9= new JPanel();
		controlPanel9.setLayout(new GridLayout(3,1));
		controlPanel10= new JPanel();
		controlPanel10.setLayout(new GridLayout(5,1));
		controlPanel11= new JPanel();
		controlPanel11.setLayout(new GridLayout(5,1));
		controlPanel12= new JPanel();
		controlPanel12.setLayout(new GridLayout(3,1));
		
		radioButton1 = new JRadioButton("A -", true);
		radioButton2 = new JRadioButton("B -");
		radioButton3 = new JRadioButton("C -");
		radioButton4 = new JRadioButton("D -");
		
		radioButton1.setMnemonic(KeyEvent.VK_A);
		radioButton2.setMnemonic(KeyEvent.VK_B);
		radioButton3.setMnemonic(KeyEvent.VK_C);
		radioButton4.setMnemonic(KeyEvent.VK_D);
		
			
		mainFrame.getContentPane().add(tabFrame);
		mainFrame.setVisible(true);				

	}
	
	private void showStudentDemo(int nSelect) {
		
		switch (nSelect) {
		case 0:
			showRegisterDemo();
			break;
		case 1:
			showExamDemo();
			break;
		case 2:
			showMarkDemo();
			break;
		}
				
		
	}
	
	private void showRegisterDemo() {
		
		controlPanel1.removeAll();
		controlPanel2.removeAll();
		controlPanel3.removeAll();
		controlPanel4.removeAll();
		
		registerPanel.removeAll();
		studentPanel.removeAll();
		
		strStudentName = "";
		strStudentSex = "";
		strProblemTitle = "";
		

		nProblemCount = 0;  // Question Number - teacher
		nAnswerCount = 0; 	// Answer Number - exam
		nStudentMark = 0;	// Mark
		
		
		JButton startButton = new JButton("START");
		JButton exitButton = new JButton("E X I T");
		JRadioButton radioButton5 = new JRadioButton("Male", true);
		JRadioButton radioButton6 = new JRadioButton("Female");
		JComboBox comboBox = new JComboBox();
		
		for (int i = 0; i < nProblemNumber; i++)
			comboBox.addItem(strProblem[i]);
		
		comboBox.setSelectedIndex(0);
		controlPanel4.add(comboBox);		
	
		JLabel labelWelcome = new JLabel("Welcome!", JLabel.CENTER);
		JLabel labelText = new JLabel("Name");
		JTextField textField = new JTextField(15);
		
		ButtonGroup group = new ButtonGroup();
		group.add(radioButton5);
		group.add(radioButton6);
				
		
		textField.setText("Enter your Name");
		controlPanel1.add(labelText);
		controlPanel1.add(textField);
		
		controlPanel2.setLayout(new FlowLayout());
		controlPanel2.add(radioButton5);
		controlPanel2.add(radioButton6);
		
		controlPanel3.setLayout(new FlowLayout());
		controlPanel3.add(startButton);
		controlPanel3.add(exitButton);
		
		registerPanel.add(labelWelcome);
		registerPanel.add(controlPanel4);
		registerPanel.add(controlPanel1);
		registerPanel.add(controlPanel2);
		registerPanel.add(controlPanel3);
		

		studentPanel.add(registerPanel);
		mainFrame.setVisible(true);	
		
		textField.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				textField.setText("");
			}
		});	
		
		exitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		startButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String str = textField.getText();
				if (!str.equals("") && !str.equals("Enter your Name")) {
				
					strStudentName = textField.getText();
					
					if (radioButton5.isSelected())
						strStudentSex = "Male";
					else 
						strStudentSex = "Female";
					
					strProblemTitle = comboBox.getSelectedItem().toString();
					nStudentMark = 0;
					strReport ="";
					// ---- Read Proble Data ----
					strLabel = "Question 1";
					for (int i = 0; i < 10; i++) {
						strTextArea[i] = "";
						strText1[i] = "";
						strText2[i] = "";
						strText3[i] = "";
						strText4[i] = "";
								
					}
					
					readProblemFile(strProblemTitle);
					
					nPageNumber = 1;
					
					
					showStudentDemo(nPageNumber);
				}
												
			}
		});		
		
	}
	
	private void showExamDemo() {
		controlPanel1.removeAll();
		controlPanel2.removeAll();
		controlPanel3.removeAll();
		controlPanel4.removeAll();
		
		examPanel.removeAll();
		studentPanel.removeAll();
		
		
		JButton nextButton = new JButton("N E X T");
		JButton exitButton = new JButton("E X I T");
		
		ButtonGroup group = new ButtonGroup();
		
		group.add(radioButton1);
		group.add(radioButton2);
		group.add(radioButton3);
		group.add(radioButton4);
				
		
		JLabel labelWelcome = new JLabel("Welcome!", JLabel.CENTER);
		
		JLabel labelText = new JLabel();
		JTextArea textArea = new JTextArea(5, 30);
		JScrollPane scroll = new JScrollPane(textArea);
		textArea.setLineWrap(true);
	    textArea.setWrapStyleWord(true);
	
		
		JTextField textField1 = new JTextField(30);
		JTextField textField2 = new JTextField(30);
		JTextField textField3 = new JTextField(30);
		JTextField textField4 = new JTextField(30);
		
		textField1.setText(strText1[nAnswerCount]);
		textField2.setText(strText2[nAnswerCount]);
		textField3.setText(strText3[nAnswerCount]);
		textField4.setText(strText4[nAnswerCount]);

		
		labelText.setText(strLabel);
		textArea.setText(strTextArea[nAnswerCount]);
		controlPanel1.add(labelText);
		controlPanel1.add(scroll);
		
		controlPanel2.setLayout(new GridLayout(4, 1));
		JPanel subPanel1 = new JPanel();
		controlPanel2.add(subPanel1);
		subPanel1.add(radioButton1);
		subPanel1.add(textField1);
		JPanel subPanel2 = new JPanel();
		controlPanel2.add(subPanel2);
		subPanel2.add(radioButton2);
		subPanel2.add(textField2);
		JPanel subPanel3 = new JPanel();
		controlPanel2.add(subPanel3);
		subPanel3.add(radioButton3);
		subPanel3.add(textField3);
		JPanel subPanel4 = new JPanel();
		controlPanel2.add(subPanel4);
		subPanel4.add(radioButton4);
		subPanel4.add(textField4);
		
		
		controlPanel3.setLayout(new GridLayout(3, 1));
		JPanel subPanel5 = new JPanel();
		controlPanel3.add(subPanel5);
		JPanel subPanel6 = new JPanel();
		controlPanel3.add(subPanel6);
		
		
		subPanel6.add(nextButton);
		subPanel6.add(exitButton);
		
		JPanel subPanel7 = new JPanel();
		controlPanel3.add(subPanel7);
		
	
		examPanel.add(labelWelcome);
		examPanel.add(controlPanel1);
		examPanel.add(controlPanel2);
		examPanel.add(controlPanel3);	
		
		studentPanel.add(examPanel);				
		
		nextButton.setActionCommand("Next");
		nextButton.addActionListener(new ButtonClickListener());
	
		exitButton.setActionCommand("Exit");
		exitButton.addActionListener(new ButtonClickListener());
		
		bRadio1 = false;
		bRadio2 = false;
		bRadio3 = false;
		bRadio4 = false;
		
		bRadio1 = radioButton1.isSelected();
		bRadio2 = radioButton2.isSelected();
		bRadio3 = radioButton3.isSelected();
		bRadio4 = radioButton4.isSelected();
		
		mainFrame.setVisible(true);			
				
		
	}	
	
	private class ButtonClickListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
	        String command = e.getActionCommand(); 
	        if (command.equals("Next")) {
	        	
	        	int nItem;
	        
				if (radioButton1.isSelected())
					nItem = 1;
				else if (radioButton2.isSelected())
					nItem = 2;
				else if (radioButton3.isSelected())
					nItem = 3;
				else 
					nItem = 4;
				
				if (nItem == nCorrectNumber[nAnswerCount])
					nStudentMark++;
	
	        	strReport = strReport + Integer.toString(nCorrectNumber[nAnswerCount]) + Integer.toString(nItem);
	        
	        	
	        	nAnswerCount++;
	        	strLabel = "Question " + Integer.toString(nAnswerCount+1);
	        	
	        	nPageNumber = 1;
	        	
	        	if (nAnswerCount > 9) {
	        		JOptionPane.showMessageDialog(mainFrame, "Your Examination Mark is " + Integer.toString(nStudentMark) + " / 10");
	 
	        		nPageNumber = 2;
	        		
	        	}
	        	
	        } else if (command.equals("Exit")) {
	        	System.exit(0);
	        }
	        

	        showStudentDemo(nPageNumber);
		}
		
		
	}
	
	private void showMarkDemo() {
		controlPanel9.removeAll();
		controlPanel10.removeAll();
		controlPanel11.removeAll();
		controlPanel12.removeAll();
		
		markPanel.removeAll();
		studentPanel.removeAll();

		JPanel subPanel1 = new JPanel();
		JPanel subPanel2 = new JPanel();
		JPanel subPanel3 = new JPanel();
		JPanel subPanel4 = new JPanel();
		JPanel subPanel5 = new JPanel();
		JPanel subPanel6 = new JPanel();
		JPanel subPanel7 = new JPanel();
		JPanel subPanel8 = new JPanel();
		JPanel subPanel9 = new JPanel();
		JPanel subPanel10 = new JPanel();
		JPanel subPanel11 = new JPanel();
		JPanel subPanel12 = new JPanel();
		JPanel subPanel13 = new JPanel();
		JPanel subPanel14 = new JPanel();
		JPanel subPanel15 = new JPanel();
		JPanel subPanel16 = new JPanel();
		
		controlPanel9.add(subPanel1);
		JLabel labelStudent = new JLabel(strStudentName + "  Examination Report ( " + strStudentSex + " )" , JLabel.CENTER);
		subPanel2.add(labelStudent);
		controlPanel9.add(subPanel2);
		
		JLabel labelNumber = new JLabel(" No      ");
		JLabel labelProblem1 = new JLabel("A       ");
		JLabel labelProblem2 = new JLabel("B       ");
		JLabel labelProblem3 = new JLabel("C       ");
		JLabel labelProblem4 = new JLabel("D       ");
		JLabel labelMark = new JLabel(" M  ");
		subPanel3.add(labelNumber);
		subPanel3.add(labelProblem1);
		subPanel3.add(labelProblem2);
		subPanel3.add(labelProblem3);
		subPanel3.add(labelProblem4);
		subPanel3.add(labelMark);
		controlPanel9.add(subPanel3);
		
		//////////////////////////////////////////////////
		// 1
		subPanel4 = makePanel(1, strReport.charAt(0), strReport.charAt(1));
		controlPanel10.add(subPanel4);
		// 2
		subPanel5 = makePanel(2, strReport.charAt(2), strReport.charAt(3));
		controlPanel10.add(subPanel5);
		// 3
		subPanel6 = makePanel(3, strReport.charAt(4), strReport.charAt(5));
		controlPanel10.add(subPanel6);
		// 4
		subPanel7 = makePanel(4, strReport.charAt(6), strReport.charAt(7));
		controlPanel10.add(subPanel7);
		// 5
		subPanel8 = makePanel(5, strReport.charAt(8), strReport.charAt(9));
		controlPanel10.add(subPanel8);
		// 6
		subPanel9 = makePanel(6, strReport.charAt(10), strReport.charAt(11));
		controlPanel11.add(subPanel9);
		// 7
		subPanel10 = makePanel(7, strReport.charAt(12), strReport.charAt(13));
		controlPanel11.add(subPanel10);
		// 8
		subPanel11 = makePanel(8, strReport.charAt(14), strReport.charAt(15));
		controlPanel11.add(subPanel11);
		// 9
		subPanel12 = makePanel(9, strReport.charAt(16), strReport.charAt(17));
		controlPanel11.add(subPanel12);
		// 10
		subPanel13 = makePanel(10, strReport.charAt(18), strReport.charAt(19));
		controlPanel11.add(subPanel13);


		
		JLabel labelTotal = new JLabel();
		
		if (nStudentMark > 8)
			labelTotal.setText("      Very Good!         Total Mark - " + Integer.toString(nStudentMark));
		else if (nStudentMark > 6 )
			labelTotal.setText("           Good!         Total Mark - " + Integer.toString(nStudentMark));
		else if (nStudentMark > 4)
			labelTotal.setText("         Normal!         Total Mark - " + Integer.toString(nStudentMark));
		else if (nStudentMark > 2)
			labelTotal.setText("            Bad!         Total Mark - " + Integer.toString(nStudentMark));
		else
			labelTotal.setText("       Very Bad!         Total Mark - " + Integer.toString(nStudentMark));



		subPanel14.add(labelTotal);
		controlPanel12.add(subPanel14);

		JButton registerButton = new JButton("REGISTER");
		JButton exitButton = new JButton("E X I T");
		subPanel15.add(registerButton);
		subPanel15.add(exitButton);
		controlPanel12.add(subPanel15);
	
		controlPanel12.add(subPanel16);
		
		markPanel.add(controlPanel9);
		markPanel.add(controlPanel10);
		markPanel.add(controlPanel11);
		markPanel.add(controlPanel12);
		
		registerButton.setActionCommand("Register");
		registerButton.addActionListener(new MarkClickListener());
	
		exitButton.setActionCommand("Exit");
		exitButton.addActionListener(new MarkClickListener());

		studentPanel.add(markPanel);
		mainFrame.setVisible(true);		
			
		
	}
	
	private class MarkClickListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
	        String command = e.getActionCommand(); 
	        if (command.equals("Register")) {
	        	
	        	nPageNumber = 0;
	        	
 	        	
	        } else if (command.equals("Exit")) {
	        	System.exit(0);
	        }
 
	        showStudentDemo(nPageNumber);
		}
		
		
	}
	
	
	private void showTeacherDemo() {
		JButton controlButton, exitButton;
		JRadioButton radioButton1, radioButton2, radioButton3, radioButton4;
		JComboBox comboBox;
		
		JLabel labelWelcome = new JLabel("Submit Problem!", JLabel.CENTER);
		JLabel labelText = new JLabel();
		JTextArea textArea = new JTextArea(4, 30);
		JScrollPane scroll = new JScrollPane(textArea);

		JTextField textField1 = new JTextField(20);
		JTextField textField2 = new JTextField(20);
		JTextField textField3 = new JTextField(20);
		JTextField textField4 = new JTextField(20);
		
		
		ButtonGroup group = new ButtonGroup();
		

		controlPanel5.removeAll();
		controlPanel6.removeAll();
		controlPanel7.removeAll();
		controlPanel8.removeAll();
		
		teacherPanel.removeAll();	
		
		// Create Buttons
		radioButton1 = new JRadioButton("A - ", true);
		radioButton2 = new JRadioButton("B - ");
		radioButton3 = new JRadioButton("C - ");
		radioButton4 = new JRadioButton("D - ");
		
		radioButton1.setMnemonic(KeyEvent.VK_A);
		radioButton2.setMnemonic(KeyEvent.VK_B);
		radioButton3.setMnemonic(KeyEvent.VK_C);
		radioButton4.setMnemonic(KeyEvent.VK_D);
		
		group.add(radioButton1);
		group.add(radioButton2);
		group.add(radioButton3);
		group.add(radioButton4);
		
		controlButton = new JButton();
		exitButton = new JButton("E X I T");
		

		// ---------------------------------------
		comboBox = new JComboBox();
		for (int i = 0; i < nProblemNumber; i++)
			comboBox.addItem(strProblem[i]);	
		
		comboBox.addItem("Untitled");
		int nCount = comboBox.getItemCount() - 1;

		comboBox.setSelectedIndex(nCount);
		comboBox.setEditable(true);
		
		controlPanel8.setLayout(new GridLayout(2, 1));
		JPanel subPanel8 = new JPanel();
		controlPanel8.add(subPanel8);
		subPanel8.add(labelWelcome);
		JPanel subPanel9 = new JPanel();
		controlPanel8.add(subPanel9);
		subPanel9.add(comboBox);
		
			
		labelText.setText("");
		textArea.setText("");
		controlPanel5.add(labelText);
		controlPanel5.add(scroll);
		
		controlPanel6.setLayout(new GridLayout(4, 1));
		JPanel subPanel1 = new JPanel();
		controlPanel6.add(subPanel1);
		subPanel1.add(radioButton1);
		subPanel1.add(textField1);
		JPanel subPanel2 = new JPanel();
		controlPanel6.add(subPanel2);
		subPanel2.add(radioButton2);
		subPanel2.add(textField2);
		JPanel subPanel3 = new JPanel();
		controlPanel6.add(subPanel3);
		subPanel3.add(radioButton3);
		subPanel3.add(textField3);
		JPanel subPanel4 = new JPanel();
		controlPanel6.add(subPanel4);
		subPanel4.add(radioButton4);
		subPanel4.add(textField4);
		
		controlPanel7.setLayout(new GridLayout(3, 1));
		JPanel subPanel5 = new JPanel();
		controlPanel7.add(subPanel5);
		JPanel subPanel6 = new JPanel();
		controlPanel7.add(subPanel6);
		
		JPanel subPanel7 = new JPanel();
		controlPanel7.add(subPanel7);
		
		controlButton.setText("START");
		subPanel6.add(controlButton);
		subPanel6.add(exitButton);
		
		exitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		controlButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				if (nProblemCount < 11 && nProblemCount > 0) {
					// Store data
					strTextArea[nProblemCount-1] = textArea.getText();
					strText1[nProblemCount-1] = textField1.getText();
					strText2[nProblemCount-1] = textField2.getText();
					strText3[nProblemCount-1] = textField3.getText();
					strText4[nProblemCount-1] = textField4.getText();
					
					if (radioButton1.isSelected())
						nCorrectNumber[nProblemCount-1] = 1;
					else if (radioButton2.isSelected())
						nCorrectNumber[nProblemCount-1] = 2;
					else if (radioButton3.isSelected())
						nCorrectNumber[nProblemCount-1] = 3;
					else 
						nCorrectNumber[nProblemCount-1] = 4;
					
					textArea.setText("");
					textField1.setText("");
					textField2.setText("");
					textField3.setText("");
					textField4.setText("");
						
				}
				
				nProblemCount++;
					
				strLabel = "Question " + Integer.toString(nProblemCount);
				
				if (nProblemCount < 11) {
					labelText.setText(strLabel);
					controlButton.setText("N E X T");
					
					if (nProblemCount == 10)
						controlButton.setText("S A V E");
				} else {
					controlButton.setText("START");
					labelText.setText("");
					nProblemCount = 0;
					strProblem[nProblemNumber] = comboBox.getSelectedItem().toString();
					nProblemNumber++;
					// Save file
					saveProblemFile(strProblem[nProblemNumber-1]);
					
				}
			
			}
		});
	
		teacherPanel.add(controlPanel8);
		teacherPanel.add(controlPanel5);
		teacherPanel.add(controlPanel6);
		teacherPanel.add(controlPanel7);	
		
		
		
	}
	
	public void readProblemFile(String strFileName) {
		try {
			
			File myFile = new File("Data/" + strFileName + ".txt");
			Scanner myReader = new Scanner(myFile);
			int nFlag = 0;
			int nCount = 0;
			while (myReader.hasNext()) {
				String data = myReader.next();
				
				if (data.equals("%")) {
					nFlag++;
					if (nFlag > 5) {
						nFlag = 0;
						nCount++;
					}
					
					continue;
				}
				
				switch (nFlag) {
				case 0:
					strTextArea[nCount] = strTextArea[nCount] + " " + data;
					break;
				case 1:
					strText1[nCount] = strText1[nCount] + " " + data;
					break;
				case 2:
					strText2[nCount] = strText2[nCount] + " " + data;
					break;
				case 3:
					strText3[nCount] = strText3[nCount] + " " + data;
					break;
				case 4:
					strText4[nCount] = strText4[nCount] + " " + data;
					break;
				case 5:
					nCorrectNumber[nCount] = Integer.valueOf(data);
					break;

				}
				
			}
			
			myReader.close();
				
			
		} catch (FileNotFoundException e) {
			System.out.println("File read error occurred.");
			e.printStackTrace();
		}		
		
	}
	
	
	public void saveProblemFile(String strFileName) {
		try {
			FileWriter myWriter = new FileWriter("Data/fileName.txt");
			myWriter.write(Integer.toString(nProblemNumber) + " \n");
			
			for (int i = 0; i < nProblemNumber; i++)
				myWriter.write(strProblem[i] + " ");
		
			myWriter.close();
					
		} catch (IOException e) {
			System.out.println("File write error occured.");
			e.printStackTrace();
		}
		
		try {
			FileWriter myWriter = new FileWriter("Data/" + strFileName + ".txt");
			for (int i = 0; i < 10; i++) {
				myWriter.write(strTextArea[i] + " % ");
				myWriter.write(strText1[i] + " % ");
				myWriter.write(strText2[i] + " % ");
				myWriter.write(strText3[i] + " % ");
				myWriter.write(strText4[i] + " % ");
				myWriter.write(Integer.toString(nCorrectNumber[i]) + " % ");
				
							
			}
			myWriter.close();
			
		} catch (IOException e) {
			System.out.println("File write error occured.");
			e.printStackTrace();
			
		}
		
		
		
	}
	
	public JPanel makePanel(int nNumber, char ch1, char ch2) {
		JPanel panel = new JPanel();
		
		JLabel labelNumber = new JLabel();
		JLabel labelProblem1 = new JLabel();
		JLabel labelProblem2 = new JLabel();
		JLabel labelProblem3 = new JLabel();
		JLabel labelProblem4 = new JLabel();
		JLabel labelMark = new JLabel();
		
		String strYes = "    ";
		String strNo = "          ";
		
		if (nNumber < 10)
			labelNumber.setText(Integer.toString(nNumber) + "       ");
		else
			labelNumber.setText(Integer.toString(nNumber) + "      ");
		
		switch (ch1) {
		case '1':
			labelProblem1.setText(strYes);
			labelProblem1.setIcon(imgIcon1);
			labelProblem2.setText(strNo);
			labelProblem3.setText(strNo);
			labelProblem4.setText(strNo);
			break;
		case '2':
			labelProblem2.setText(strYes);
			labelProblem2.setIcon(imgIcon1);
			labelProblem1.setText(strNo);
			labelProblem3.setText(strNo);
			labelProblem4.setText(strNo);
			break;
		case '3':
			labelProblem3.setText(strYes);
			labelProblem3.setIcon(imgIcon1);
			labelProblem2.setText(strNo);
			labelProblem1.setText(strNo);
			labelProblem4.setText(strNo);
			break;
		case '4':
			labelProblem4.setText(strYes);
			labelProblem4.setIcon(imgIcon1);
			labelProblem2.setText(strNo);
			labelProblem3.setText(strNo);
			labelProblem1.setText(strNo);
			break;
		}
			
		if (ch1 != ch2) {
			
			switch (ch2) {
			case '1':
				labelProblem1.setText(strYes);
				labelProblem1.setIcon(imgIcon2);
				break;		
			case '2':
				labelProblem2.setText(strYes);
				labelProblem2.setIcon(imgIcon2);
				break;	
			case '3':
				labelProblem3.setText(strYes);
				labelProblem3.setIcon(imgIcon2);
				break;		
			case '4':
				labelProblem4.setText(strYes);
				labelProblem4.setIcon(imgIcon2);
				break;		
			}
			
			labelMark.setText("   0 ");	
		} else {
		 	labelMark.setText("   1 ");	
		}
		
		

		panel.add(labelNumber);
		panel.add(labelProblem1);
		panel.add(labelProblem2);
		panel.add(labelProblem3);
		panel.add(labelProblem4);
		panel.add(labelMark);
			
		return panel;
		
	}
		 	

	
}






