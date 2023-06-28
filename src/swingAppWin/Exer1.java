package swingAppWin;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

public class Exer1 {

	private JFrame frame1;
	private JTextField idTextField;
	private JTextField nameTextField;
	private JTextField courseTextField;
	private JTextField scoreTextField;
	private JTextField totalTextField;
	private JTextField gradeTextField;
	private JTextField remTextField;
	private ButtonGroup bg = new ButtonGroup();
		
	/**
	 * Launch the application.
	 */

    File ff = new File("c:\\LanSchool Files\\save.csv"); 
    
    FileWriter ww = new FileWriter(ff,true) ; 
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Exer1 window = new Exer1();
					window.frame1.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Exer1() throws IOException  {
		initialize();
	}

	
	// determines exam grade remark
	private String getRemarks(int grade)
	{  String remarks;
		if (grade>=96) remarks="Excellent";
		else if (grade>=90 && grade<96) remarks="Good";
		else if (grade>=85 && grade<90) remarks="Average";
		else if (grade>=80 && grade<85) remarks="Fair";
		else if (grade>=75 && grade<80) remarks="Poor";
		else remarks="Fail";
		return remarks;
	}	
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() throws IOException {
		frame1 = new JFrame();
		frame1.setBackground(Color.GREEN);
		frame1.getContentPane().setBackground(Color.LIGHT_GRAY);
		frame1.setForeground(Color.DARK_GRAY);
		frame1.setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\2ndSemSY2018-2019\\Windowbuilder-SWT-WIndow App codes (Feb-1-2019)\\images\\images2.jpg"));
		frame1.setTitle("Student Information");
		frame1.setBounds(100, 100, 656, 455);
		frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame1.getContentPane().setLayout(null);
		
		JPanel personalPanel = new JPanel();
		personalPanel.setBackground(Color.GRAY);
		personalPanel.setForeground(Color.DARK_GRAY);
		personalPanel.setBorder(new TitledBorder(null, "Personal Data", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		personalPanel.setBounds(15, 16, 291, 279);
		frame1.getContentPane().add(personalPanel);
		personalPanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Id");
		lblNewLabel.setBounds(15, 47, 69, 20);
		personalPanel.add(lblNewLabel);
		
		idTextField = new JTextField();
		idTextField.setBounds(120, 44, 146, 26);
		personalPanel.add(idTextField);
		idTextField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Name");
		lblNewLabel_1.setBounds(15, 88, 69, 20);
		personalPanel.add(lblNewLabel_1);
		
		nameTextField = new JTextField();
		nameTextField.setBounds(120, 86, 146, 26);
		personalPanel.add(nameTextField);
		nameTextField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Course");
		lblNewLabel_2.setBounds(15, 130, 69, 20);
		personalPanel.add(lblNewLabel_2);
		
		courseTextField = new JTextField();
		courseTextField.setBounds(120, 128, 146, 26);
		personalPanel.add(courseTextField);
		courseTextField.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Year");
		lblNewLabel_3.setBounds(15, 175, 69, 20);
		personalPanel.add(lblNewLabel_3);
		
		JComboBox yearComboBox = new JComboBox();
		yearComboBox.setBounds(120, 172, 146, 26);
		personalPanel.add(yearComboBox);
				
		for (int i=1;i<=5;i++) 		
			yearComboBox.addItem(i);			               
		
		JLabel lblNewLabel_8 = new JLabel("Gender");
		lblNewLabel_8.setBounds(14, 225, 69, 20);
		personalPanel.add(lblNewLabel_8);		
		
		JRadioButton rdbtnFemaleRadioButton = new JRadioButton("Female");
		rdbtnFemaleRadioButton.setSelected(true);
		rdbtnFemaleRadioButton.setBounds(116, 219, 83, 29);
		personalPanel.add(rdbtnFemaleRadioButton);
		
		JRadioButton rdbtnMaleRadioButton = new JRadioButton("Male");
		rdbtnMaleRadioButton.setBounds(207, 219, 73, 29);
		personalPanel.add(rdbtnMaleRadioButton);
		
		bg.add(rdbtnFemaleRadioButton);
		bg.add(rdbtnMaleRadioButton);
		
		JPanel examResultPanel = new JPanel();
		examResultPanel.setBackground(Color.GRAY);
		examResultPanel.setBorder(new TitledBorder(null, "Exam Result", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		examResultPanel.setBounds(319, 16, 301, 279);
		frame1.getContentPane().add(examResultPanel);
		examResultPanel.setLayout(null);
		
		JLabel lblNewLabel_4 = new JLabel("Score");
		lblNewLabel_4.setBounds(15, 50, 39, 20);
		examResultPanel.add(lblNewLabel_4);
		
		scoreTextField = new JTextField();
		scoreTextField.setBounds(140, 43, 146, 26);
		examResultPanel.add(scoreTextField);
		scoreTextField.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Total Points");
		lblNewLabel_5.setBounds(15, 89, 104, 20);
		examResultPanel.add(lblNewLabel_5);
		
		totalTextField = new JTextField();
		totalTextField.setBounds(140, 85, 146, 26);
		examResultPanel.add(totalTextField);
		totalTextField.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Grade");
		lblNewLabel_6.setBounds(15, 134, 69, 20);
		examResultPanel.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Remarks");
		lblNewLabel_7.setBounds(15, 178, 69, 20);
		examResultPanel.add(lblNewLabel_7);
		
		gradeTextField = new JTextField();
		gradeTextField.setEditable(false);
		gradeTextField.setBounds(140, 128, 146, 26);
		examResultPanel.add(gradeTextField);
		gradeTextField.setColumns(10);
		
		remTextField = new JTextField();
		remTextField.setEditable(false);
		remTextField.setBounds(140, 171, 146, 26);
		examResultPanel.add(remTextField);
		remTextField.setColumns(10);
		
		JCheckBox chckbxClearanceCheckBox = new JCheckBox("Clearance");
		chckbxClearanceCheckBox.setBounds(136, 223, 139, 29);
		examResultPanel.add(chckbxClearanceCheckBox);
		
		JLabel lblNewLabel_9 = new JLabel("Requirements");
		lblNewLabel_9.setBounds(15, 227, 104, 20);
		examResultPanel.add(lblNewLabel_9);
		
		JButton btnExitButton = new JButton("Exit");
		btnExitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnExitButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {			
				try {
					ww.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.exit(0);
			}
		});
		btnExitButton.setBounds(504, 333, 115, 29);
		frame1.getContentPane().add(btnExitButton);		
		
		JButton btnSubmitButton = new JButton("Submit");
		btnSubmitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSubmitButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String id, name, course, gender, remarks;
				int year,grade;
				double score, total;
				try {
					score=total=0;
					id=idTextField.getText();
					name=nameTextField.getText();
					course=courseTextField.getText();
					year=(int)yearComboBox.getSelectedItem();				
					gender=(rdbtnFemaleRadioButton.isSelected()) ? rdbtnFemaleRadioButton.getLabel() : rdbtnMaleRadioButton.getLabel();
					score=Double.parseDouble(scoreTextField.getText());
					total=Double.parseDouble(totalTextField.getText());
					

					if (!id.isEmpty() && !name.isEmpty() && !course.isEmpty() && score>0 && total>0) // if no blank entries
					{
						grade=(int)((score/total)*100);
						remarks=getRemarks(grade);
						gradeTextField.setText(""+grade);
						remTextField.setText(remarks);	
						
						// backup display 
						System.out.println("Id:"+id);
						System.out.println("Name:"+name);
						System.out.println("Course:"+course);
						System.out.println("Year:"+year);
						System.out.println("Gender:"+gender);
						System.out.println("Score:"+score);
						System.out.println("Total:"+total);

						System.out.println("Grade:"+grade);
						System.out.println("Remarks:"+remarks);
						System.out.println("Cleared:"+chckbxClearanceCheckBox.isSelected());	
						System.out.println();	
						ww.write(id+","+name+","+course+","+year+","+gender+","+score+","+total+","+grade+","+remarks+","+chckbxClearanceCheckBox.isSelected());
						ww.append('\n');
						ww.close();

					}//if
					else
					{
						JOptionPane.showMessageDialog(null,"Lacking data entry.","Error",JOptionPane.ERROR_MESSAGE);						
					}
				}//try
				catch (Exception err)
				{				
					JOptionPane.showMessageDialog(null,"Lacking data entry.","Error",JOptionPane.ERROR_MESSAGE);	
				}
			}
		});
		btnSubmitButton.setBounds(348, 336, 115, 29);
		frame1.getContentPane().add(btnSubmitButton);
		
		JButton btnNewButton = new JButton("CLEAR");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				idTextField.setText("");
				nameTextField.setText("");
				courseTextField.setText("");
				scoreTextField.setText("");
				totalTextField.setText("");
				gradeTextField.setText("");
				remTextField.setText("");
				bg.clearSelection();
			}
		});
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
	

			}
		});
		btnNewButton.setBounds(10, 336, 103, 29);
		frame1.getContentPane().add(btnNewButton);
		
		JButton btnViewRecords = new JButton("VIEW RECORDS");
		btnViewRecords.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				EXER2_Revised_ newFrame = new EXER2_Revised_();
				EXER2_Revised_.frame1.setVisible(true);
				frame1.dispose();
			}
		});
		btnViewRecords.setBounds(151, 335, 155, 31);
		frame1.getContentPane().add(btnViewRecords);
		
		
	}
}
