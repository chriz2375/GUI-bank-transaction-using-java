

package swingAppWin;

import java.awt.Color;
import java.awt.*;
import java.awt.image.*;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.StringTokenizer;



import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;



public class EXER2_Revised_ {



	static public JFrame frame1;
	private JTextField idTF;
	private JTextField nameTF;
	private JTextField CourseTF;
	private JTextField yearTF;
	private JTextField genderTF;
	private JTextField scoreTF;
	private JTextField TotalTF;
	private JTextField gradeTextField;
	private JTextField remarkslTF;
	private JTextField clerancelTF;
	private JButton btnPrevButton;
	private JButton btnNextButton;
	private JLabel lblRecordLabel;
	private JLabel lblRankLabel;
	private JLabel lblMedalLabel;
	private JLabel lblStudyHardLabel;

	

	static String StudRec[][] = new String[20][10]; // 2D array of student records

	static int Scount=0,CURREC=0;	

	static int HGI,LGI;

	

	static FileReader FR;        

	static BufferedReader BR;	

	private DefaultTableModel model;
	private JTable table;
	private JScrollPane scrollPane;

	

	/**

	 * Launch the application.

	 */

	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {

			public void run() {				

				try {					

					EXER2_Revised_ window = new EXER2_Revised_();

					window.frame1.setVisible(true);									

				} catch (Exception e) {

					e.printStackTrace();

				}

			}

		});

	}



	// load all student records from csv file for quick navigation

	private void loadAllStudRecords() {

		String line;

		int j,highestGrade,lowestGrade;

		

		try {

			//



			FR = new FileReader("c:\\LanSchool Files\\save.csv"); 

			BR = new BufferedReader(FR); 			

			

			highestGrade=0;lowestGrade=100;

			do 
			{

				line = BR.readLine();

				if (line==null)

				{

					break;

				}

				StringTokenizer st = new StringTokenizer(line,",");

				j=0;

				while (st.hasMoreTokens()) {					

					StudRec[Scount][j]=st.nextToken()+"";

					if (j==7) {

						if (Integer.parseInt(StudRec[Scount][j])>highestGrade) {
							highestGrade=Integer.parseInt(StudRec[Scount][j]);
							HGI=Scount;
							}

						if (Integer.parseInt(StudRec[Scount][j])<lowestGrade) {
							lowestGrade=Integer.parseInt(StudRec[Scount][j]);
							LGI=Scount;
							}

					}
				
					j++;

				}

				

				Object[] row = {StudRec[Scount][0],StudRec[Scount][1],StudRec[Scount][2],StudRec[Scount][3],StudRec[Scount][4],StudRec[Scount][5],

				StudRec[Scount][6],StudRec[Scount][7],StudRec[Scount][8],StudRec[Scount][9]};							

				

			model.addRow(row);



				Scount++;				

			}

			while (true);

			System.out.print("High "+HGI);
			System.out.print("Low "+LGI);	

			if (Scount>0) {						

				CURREC++;

				displayCurrentRecord();				

			}

			else 

				lblRecordLabel.setText("T H E S T U D E N T R E C O R D: "+" 0 of "+Scount);

		}

		catch(Exception err)

		{}

	}	

	

	

	

	

	private void displayCurrentRecord()

	{

		lblRecordLabel.setText("StudentRecord: "+CURREC+" of "+Scount);

		idTF.setText(StudRec[CURREC-1][0]);

		nameTF.setText(StudRec[CURREC-1][1]);

		CourseTF.setText(StudRec[CURREC-1][2]);

		yearTF.setText(StudRec[CURREC-1][3]);

		genderTF.setText(StudRec[CURREC-1][4]);

		scoreTF.setText(StudRec[CURREC-1][5]);

		TotalTF.setText(StudRec[CURREC-1][6]);

		gradeTextField.setText(StudRec[CURREC-1][7]);

		remarkslTF.setText(StudRec[CURREC-1][8]);

		clerancelTF.setText(StudRec[CURREC-1][9]);							

		if (CURREC>1) 

			{btnPrevButton.setEnabled(true);btnPrevButton.enable();}

		else 

			{btnPrevButton.setEnabled(false);btnPrevButton.disable();}

		

		if (CURREC<Scount) 

			{btnNextButton.setEnabled(true);btnNextButton.enable();}

		else

			{btnNextButton.setEnabled(false);btnNextButton.disable();}

	}

	

	/**

	 * Create the application.

	 */

	public EXER2_Revised_() {

		initialize();

	}

	

	

	/**

	 * Initialize the contents of the frame.

	 */

	private void initialize() {

		frame1 = new JFrame();

		frame1.getContentPane().setBackground(Color.WHITE);

		frame1.setResizable(false);

		frame1.setIconImage(Toolkit.getDefaultToolkit().getImage("e:\\medal2.png"));

		frame1.setTitle("Student Information");

		frame1.setBounds(100, 100, 662, 656);

		frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		frame1.getContentPane().setLayout(null);

		

		JPanel personalPanel = new JPanel();

		personalPanel.setBackground(SystemColor.info);

		personalPanel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Personal Data", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 0)));

		personalPanel.setBounds(22, 85, 291, 279);

		frame1.getContentPane().add(personalPanel);

		personalPanel.setLayout(null);

		

		JLabel lblNewLabel = new JLabel("Id");

		lblNewLabel.setBounds(15, 47, 69, 20);

		personalPanel.add(lblNewLabel);

		

		idTF = new JTextField();

		idTF.setEditable(false);

		idTF.setBounds(120, 44, 146, 26);

		personalPanel.add(idTF);

		idTF.setColumns(10);

		

		JLabel lblNewLabel_1 = new JLabel("Name");

		lblNewLabel_1.setBounds(15, 88, 69, 20);

		personalPanel.add(lblNewLabel_1);

		

		nameTF = new JTextField();

		nameTF.setEditable(false);

		nameTF.setBounds(120, 86, 146, 26);

		personalPanel.add(nameTF);

		nameTF.setColumns(10);

		

		JLabel lblNewLabel_2 = new JLabel("Course");

		lblNewLabel_2.setBounds(15, 130, 69, 20);

		personalPanel.add(lblNewLabel_2);

		

		CourseTF = new JTextField();

		CourseTF.setEditable(false);

		CourseTF.setBounds(120, 128, 146, 26);

		personalPanel.add(CourseTF);

		CourseTF.setColumns(10);

		

		JLabel lblNewLabel_3 = new JLabel("Year");

		lblNewLabel_3.setBounds(15, 175, 69, 20);

		personalPanel.add(lblNewLabel_3);

								

		JLabel lblNewLabel_8 = new JLabel("Gender");

		lblNewLabel_8.setBounds(14, 223, 69, 20);

		personalPanel.add(lblNewLabel_8);

		

		yearTF = new JTextField();

		yearTF.setEditable(false);

		yearTF.setBounds(120, 172, 146, 26);

		personalPanel.add(yearTF);

		yearTF.setColumns(10);

		

		genderTF = new JTextField();

		genderTF.setEditable(false);

		genderTF.setBounds(120, 219, 146, 26);

		personalPanel.add(genderTF);

		genderTF.setColumns(10);

		

		JPanel examResultPanel = new JPanel();

		examResultPanel.setBackground(SystemColor.info);

		examResultPanel.setBorder(new TitledBorder(null, "Exam Result", TitledBorder.LEADING, TitledBorder.TOP, null, null));

		examResultPanel.setBounds(326, 85, 311, 279);

		frame1.getContentPane().add(examResultPanel);

		examResultPanel.setLayout(null);

		

		JLabel lblNewLabel_4 = new JLabel("Score");

		lblNewLabel_4.setBounds(15, 50, 39, 20);

		examResultPanel.add(lblNewLabel_4);

		

		scoreTF = new JTextField();

		scoreTF.setEditable(false);

		scoreTF.setBounds(140, 43, 146, 26);

		examResultPanel.add(scoreTF);

		scoreTF.setColumns(10);

		

		JLabel lblNewLabel_5 = new JLabel("Total Points");

		lblNewLabel_5.setBounds(15, 89, 104, 20);

		examResultPanel.add(lblNewLabel_5);

		

		TotalTF = new JTextField();

		TotalTF.setEditable(false);

		TotalTF.setBounds(140, 85, 146, 26);

		examResultPanel.add(TotalTF);

		TotalTF.setColumns(10);

		

		JLabel lblNewLabel_6 = new JLabel("Grade");

		lblNewLabel_6.setBounds(15, 134, 69, 20);

		examResultPanel.add(lblNewLabel_6);

		

		JLabel lblNewLabel_7 = new JLabel("Remark");

		lblNewLabel_7.setBounds(15, 178, 69, 20);

		examResultPanel.add(lblNewLabel_7);

		

		gradeTextField = new JTextField();

		gradeTextField.setEditable(false);

		gradeTextField.setBounds(140, 128, 146, 26);

		examResultPanel.add(gradeTextField);

		gradeTextField.setColumns(10);

		

		remarkslTF = new JTextField();

		remarkslTF.setEditable(false);

		remarkslTF.setBounds(140, 171, 146, 26);

		examResultPanel.add(remarkslTF);

		remarkslTF.setColumns(10);

		

		JLabel lblNewLabel_9 = new JLabel("Clearance");

		lblNewLabel_9.setBounds(15, 224, 104, 20);

		examResultPanel.add(lblNewLabel_9);

		

		clerancelTF = new JTextField();

		clerancelTF.setEditable(false);

		clerancelTF.setBounds(140, 221, 146, 26);

		examResultPanel.add(clerancelTF);

		clerancelTF.setColumns(10);

				

		JButton btnExitButton = new JButton("Exit");

		btnExitButton.addMouseListener(new MouseAdapter() {

			@Override

			public void mouseClicked(MouseEvent arg0) {	

				try {

				FR.close();

				BR.close();

				}

				catch (Exception err)

				{}

				System.exit(0);

			}

		});

		btnExitButton.setBounds(522, 375, 115, 43);

		frame1.getContentPane().add(btnExitButton);				

		
		//loadAllStudRecords();
		btnNextButton = new JButton("N.E.X.T");	

		btnNextButton.addMouseListener(new MouseAdapter() {

			@Override

			public void mouseClicked(MouseEvent e) {

				if (CURREC<Scount) {

					CURREC++;

					lblMedalLabel.setVisible(false);

					lblStudyHardLabel.setVisible(false);

					if (CURREC==(HGI+1)) {
						lblRankLabel.setText("HIGHEST");
						lblMedalLabel.setVisible(true);
						}				

					else if (CURREC==(LGI+1)) {lblRankLabel.setText("LOWEST");lblStudyHardLabel.setVisible(true);}

					else  lblRankLabel.setText("");

					

					displayCurrentRecord();						

				}

			}

		});

		btnNextButton.setBounds(198, 375, 115, 41);

		frame1.getContentPane().add(btnNextButton);

		

		btnPrevButton = new JButton("P.R.E.V");

		btnPrevButton.addMouseListener(new MouseAdapter() {

			@Override

			public void mouseClicked(MouseEvent e) {

				if (CURREC>1) {

					CURREC--;

					lblMedalLabel.setVisible(false);

					lblStudyHardLabel.setVisible(false);

					if (CURREC==(HGI+1)) {lblRankLabel.setText("HIGHEST");lblMedalLabel.setVisible(true);}			

					else if (CURREC==(LGI+1)) {lblRankLabel.setText("LOWEST");lblStudyHardLabel.setVisible(true);}

					else  lblRankLabel.setText("");

					

					displayCurrentRecord();		

				}

			}

		});

		btnPrevButton.setBounds(22, 375, 115, 41);

		frame1.getContentPane().add(btnPrevButton);

		

		lblRecordLabel = new JLabel(" S T U D E N T R E C O R D: ");

		lblRecordLabel.setFont(new Font("Serif", Font.BOLD, 22));

		lblRecordLabel.setBounds(10, 11, 390, 20);

		frame1.getContentPane().add(lblRecordLabel);

		

		lblRankLabel = new JLabel("");
		lblRankLabel.setIcon(new ImageIcon("C:\\LanSchool Files\\images2.jpg"));

		lblRankLabel.setForeground(Color.RED);

		lblRankLabel.setFont(new Font("Tahoma", Font.PLAIN, 22));

		lblRankLabel.setBounds(494, 11, 110, 62);

		frame1.getContentPane().add(lblRankLabel);

		

		lblStudyHardLabel = new JLabel("");

		lblStudyHardLabel.setIcon(new ImageIcon("C:\\LanSchool Files\\studyHard10.png"));

		lblStudyHardLabel.setBounds(494, -8, 99, 82);

		frame1.getContentPane().add(lblStudyHardLabel);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(22, 442, 613, 158);
		frame1.getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Name", "Course", "Year", "Gender", "Score", "Total Score", "Final Grade", "Remark", "Clearance"
			}
		));
		
				model = (DefaultTableModel) table.getModel();
		
				lblMedalLabel = new JLabel("");
				lblMedalLabel.setBounds(494, -12, 88, 105);
				frame1.getContentPane().add(lblMedalLabel);
				
						lblMedalLabel.setIcon(new ImageIcon("C:\\LanSchool Files\\medal6.png"));
						
														
						
								lblMedalLabel.setVisible(false);

		lblStudyHardLabel.setVisible(false);

		

		loadAllStudRecords();

	}
}


