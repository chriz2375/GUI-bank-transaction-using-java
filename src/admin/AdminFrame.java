package admin;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import accounts.LogIn;

public class AdminFrame {

	static public JFrame frame1;
	private JTextField nameTF;
	private JTextField addTF;
	private JTable table;
	
	JTextField xId = new JTextField();
	JTextField newEdit = new JTextField();
	JPasswordField newPass = new JPasswordField();
	JLabel total = new JLabel("");
	ButtonGroup bg = new ButtonGroup();
	JRadioButton male1= new JRadioButton("Male");
	JRadioButton female1 = new JRadioButton("Female");
	

	DefaultTableModel model;
	Connection conn =  null;
	Statement stmt;
	PreparedStatement pst;
	static ResultSet rs;
	int i;
	static int idRec[] = new int[20];
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminFrame window = new AdminFrame();
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
	void clear() {
		xId.setText("");
		newEdit.setText("");
		bg.clearSelection();
	}
	
	private void editName() throws SQLException {
		clear();
		int studId;
		int o,o2;
		Object [] mes1 = {
				"Input the Account ID NO. desires to edit: ",xId
		};
			o =JOptionPane.showConfirmDialog(null,mes1,"Updating Account Record",JOptionPane.OK_CANCEL_OPTION);
			
			if(o==(JOptionPane.OK_OPTION)) {

			studId = Integer.parseInt(xId.getText());
			int u = searchId(studId);
			if (u>0) {
					
					Object [] mes2 = {
							"Input the new Name of Account "+studId+ ":",newEdit
					};
					o2 = JOptionPane.showConfirmDialog(null,mes2,"Updating Account Record",JOptionPane.OK_CANCEL_OPTION);
					String t  = newEdit.getText();
					if(o2==JOptionPane.OK_OPTION) {
						// insert the data
						try {
							String query = ("update accounts set Name= '"+t+"'where ID='"+studId+"'");
							pst = conn.prepareStatement(query);	
							pst.execute();
							JOptionPane.showMessageDialog(null, "Succesfully Updated Records!","",JOptionPane.INFORMATION_MESSAGE);
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
								}
													
					}
					else if(o2==JOptionPane.CANCEL_OPTION||o2==JOptionPane.CLOSED_OPTION) {
						JOptionPane.showMessageDialog(null, "Edit Cancel!","",JOptionPane.INFORMATION_MESSAGE);

					}
			}
			
			else if(studId==0) {
				JOptionPane.showMessageDialog(null, "Please input the Account ID! ","",JOptionPane.ERROR_MESSAGE);	
			}
			else if (u<0) {
				JOptionPane.showMessageDialog(null, "Incorrect ID! ","",JOptionPane.ERROR_MESSAGE);	

				}
				
			}
	}
	private void editAdd() throws SQLException {
		clear();
		int studId;
		int o,o2;
		Object [] mes1 = {
				"Input the Account ID NO. desires to edit: ",xId
		};
			o =JOptionPane.showConfirmDialog(null,mes1,"Updating Account Record",JOptionPane.OK_CANCEL_OPTION);
			
			if(o==(JOptionPane.OK_OPTION)) {

			studId = Integer.parseInt(xId.getText());
			int u = searchId(studId);
			if (u>0) {
					
					Object [] mes2 = {
							"Input the new Address of Account "+studId+ ":",newEdit
					};
					o2 = JOptionPane.showConfirmDialog(null,mes2,"Updating Account Record",JOptionPane.OK_CANCEL_OPTION);
					String t  = newEdit.getText();
					if(o2==JOptionPane.OK_OPTION) {
						// insert the data
						try {
							String query = ("update accounts set Address= '"+t+"'where ID='"+studId+"'");
							pst = conn.prepareStatement(query);	
							pst.execute();
							JOptionPane.showMessageDialog(null, "Succesfully Updated Records!","",JOptionPane.INFORMATION_MESSAGE);
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
								}
													
					}
					else if(o2==JOptionPane.CANCEL_OPTION||o2==JOptionPane.CLOSED_OPTION) {
						JOptionPane.showMessageDialog(null, "Edit Cancel!","",JOptionPane.INFORMATION_MESSAGE);

					}
			}
			
			else if(studId==0) {
				JOptionPane.showMessageDialog(null, "Please input the Account ID! ","",JOptionPane.ERROR_MESSAGE);	
			}
			else if (u<0) {
				JOptionPane.showMessageDialog(null, "Incorrect ID! ","",JOptionPane.ERROR_MESSAGE);	

				}
				
			}
	}
	private void editCont() throws SQLException {
		clear();
		int studId;
		int o,o2;
		Object [] mes1 = {
				"Input the Account ID NO. desires to edit: ",xId
		};
			o =JOptionPane.showConfirmDialog(null,mes1,"Updating Account Record",JOptionPane.OK_CANCEL_OPTION);
			
			if(o==(JOptionPane.OK_OPTION)) {

			studId = Integer.parseInt(xId.getText());
			int u = searchId(studId);
			if (u>0) {
					
					Object [] mes2 = {
							"Input the new Contact no. of Account "+studId+ ":",newEdit
					};
					o2 = JOptionPane.showConfirmDialog(null,mes2,"Updating Account Record",JOptionPane.OK_CANCEL_OPTION);
					String t  = newEdit.getText();
					if(o2==JOptionPane.OK_OPTION) {
						// insert the data
						try {
							String query = ("update accounts set Contact= '"+t+"'where ID='"+studId+"'");
							pst = conn.prepareStatement(query);	
							pst.execute();
							JOptionPane.showMessageDialog(null, "Succesfully Updated Records!","",JOptionPane.INFORMATION_MESSAGE);
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
								}
													
					}
					else if(o2==JOptionPane.CANCEL_OPTION||o2==JOptionPane.CLOSED_OPTION) {
						JOptionPane.showMessageDialog(null, "Edit Cancel!","",JOptionPane.INFORMATION_MESSAGE);

					}
			}
			
			else if(studId==0) {
				JOptionPane.showMessageDialog(null, "Please input the Account ID! ","",JOptionPane.ERROR_MESSAGE);	
			}
			else if (u<0) {
				JOptionPane.showMessageDialog(null, "Incorrect ID! ","",JOptionPane.ERROR_MESSAGE);	

				}
				
			}
	}
	private void editGender() throws SQLException {
		clear();
		String t;
		int studId;
		int o,o2;
		Object [] mes1 = {
				"Input the Account ID NO. desires to edit: ",xId
		};
			o =JOptionPane.showConfirmDialog(null,mes1,"Updating Account Record",JOptionPane.OK_CANCEL_OPTION);
			
			if(o==(JOptionPane.OK_OPTION)) {

			studId = Integer.parseInt(xId.getText());
			int u = searchId(studId);
			if (u>0) {
				do {	
					Object [] mes2 = {
							"Select the new Gender of Account "+studId+ ":",male1,female1
					};
					o2 = JOptionPane.showConfirmDialog(null,mes2,"Updating Account Record",JOptionPane.OK_CANCEL_OPTION);
					 t  = (male1.isSelected())? male1.getLabel() : female1.getLabel();
				
					if(o2==JOptionPane.OK_OPTION) {
						// insert the data
						if (t.isEmpty()) {
							JOptionPane.showMessageDialog(null, "Please Select what Gender! ","",JOptionPane.ERROR_MESSAGE);	

						}
						else {
							try {
								String query = ("update accounts set Gender= '"+t+"'where ID='"+studId+"'");
								pst = conn.prepareStatement(query);	
								pst.execute();
								JOptionPane.showMessageDialog(null, "Succesfully Updated Records!","",JOptionPane.INFORMATION_MESSAGE);
							} catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
									}
						}
												
					}
					else if(o2==JOptionPane.CANCEL_OPTION||o2==JOptionPane.CLOSED_OPTION) {
						JOptionPane.showMessageDialog(null, "Edit Cancel!","",JOptionPane.INFORMATION_MESSAGE);

					}
			}while (t.isEmpty());
			}
			
			else if(studId==0) {
				JOptionPane.showMessageDialog(null, "Please input the Account ID! ","",JOptionPane.ERROR_MESSAGE);	
			}
			else if (u<0) {
				JOptionPane.showMessageDialog(null, "Incorrect ID! ","",JOptionPane.ERROR_MESSAGE);	

				}
				
			}
		
	}
	
	private void editPass() throws SQLException {

		
		clear();
		int studId;
		int o,o2;
		Object [] mes1 = {
				"Input the Account ID NO. desires to edit: ",xId
		};
			o =JOptionPane.showConfirmDialog(null,mes1,"Updating Account Record",JOptionPane.OK_CANCEL_OPTION);
			
			if(o==(JOptionPane.OK_OPTION)) {

			studId = Integer.parseInt(xId.getText());
			int u = searchId(studId);
			if (u>0) {
					
					Object [] mes2 = {
							"Input the new Password of Account "+studId+ ":",newPass
					};
					o2 = JOptionPane.showConfirmDialog(null,mes2,"Updating Account Record",JOptionPane.OK_CANCEL_OPTION);
					String t  = newPass.getText();
					if(o2==JOptionPane.OK_OPTION) {
						// insert the data
						try {
							String query = ("update accounts set Password= '"+t+"'where ID='"+studId+"'");
							pst = conn.prepareStatement(query);	
							pst.execute();
							JOptionPane.showMessageDialog(null, "Succesfully Updated Records!","",JOptionPane.INFORMATION_MESSAGE);
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
								}
													
					}
					else if(o2==JOptionPane.CANCEL_OPTION||o2==JOptionPane.CLOSED_OPTION) {
						JOptionPane.showMessageDialog(null, "Edit Cancel!","",JOptionPane.INFORMATION_MESSAGE);

					}
			}
			
			else if(studId==0) {
				JOptionPane.showMessageDialog(null, "Please input the Account ID! ","",JOptionPane.ERROR_MESSAGE);	
			}
			else if (u<0) {
				JOptionPane.showMessageDialog(null, "Incorrect ID! ","",JOptionPane.ERROR_MESSAGE);	

				}
				
			}
	}
	
	
	
	private int searchId(int ID) throws SQLException {
		
		String sql = "Select Id from accounts";
		stmt = conn.createStatement();
		rs = stmt.executeQuery(sql);
		for ( i=0;rs.next();i++) {
			idRec[i] = rs.getInt(1);
			if(idRec[i]==ID) {
				return 1;
			}
			

		}
		return -1;

		
	}
	
	
	private Connection dbConnect() { // Step 1 - Get a connection to SQLite database	
		try 
		{   // Step 1.1 - load Java's JDBC SQLite Driver
			Class.forName("org.sqlite.JDBC");			
			// Step 1.2 - get a DB Connection
			conn = DriverManager.getConnection("JDBC:sqlite:C:\\Users\\user\\Desktop\\Christian & Judel\\CPE121-Object Oriented Programming\\Database\\accounts.sqlite"); // created using SQLite Manager (SQLiteManager_4.6.6_1430708940)
			// prompt user if connection attempt is successful
			return conn;
		}
		catch (Exception err)
		{
			JOptionPane.showMessageDialog(null, "Connection unsuccessful. Exception -> "+err);
			return null;
		}
	}
	
	private void resultSetToTableModel(ResultSet rs)
	{
		model.setRowCount(0);
		int count=0;		
		try {
			while (rs.next()) {
				Object[] row = {rs.getString("ID"), rs.getString("Name"),rs.getString("Address"),rs.getString("Contact"),
						rs.getString("Gender"),rs.getString("Password"),rs.getString("Wallet")
						};
				
				model.addRow(row);
				count++;
				total.setText("Total: "+count);
			}
			
		} catch (Exception err) {
			
			err.printStackTrace();
		}
		
	}
	public AdminFrame() {
		initialize();
		conn = dbConnect();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame1 = new JFrame();
		frame1.getContentPane().setBackground(new Color(0, 128, 0));
		frame1.setBounds(100, 100, 772, 499);
		frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame1.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 38, 360, 173);
		frame1.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblName.setBounds(10, 62, 46, 14);
		panel.add(lblName);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAddress.setBounds(10, 96, 76, 14);
		panel.add(lblAddress);
		
		JLabel lblGender = new JLabel("Gender");
		lblGender.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblGender.setBounds(10, 130, 46, 14);
		panel.add(lblGender);
		
		JLabel lblFilters = new JLabel("FILTERS");
		lblFilters.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblFilters.setBounds(10, 11, 109, 23);
		panel.add(lblFilters);
		
		nameTF = new JTextField();
		nameTF.setBounds(86, 61, 186, 20);
		panel.add(nameTF);
		nameTF.setColumns(10);
		
		addTF = new JTextField();
		addTF.setColumns(10);
		addTF.setBounds(86, 95, 186, 20);
		panel.add(addTF);
		
		JRadioButton male = new JRadioButton("Male");
		male.setBounds(86, 128, 76, 23);
		panel.add(male);
		bg.add(male);
		JRadioButton female = new JRadioButton("Female");
		female.setBounds(196, 128, 76, 23);
		panel.add(female);
		bg.add(female);
		bg.add(female1);
		bg.add(male1);
		
		JButton btnQue = new JButton("QUE>>");
		btnQue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnQue.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				String name = nameTF.getText();
				try
				{
					String query = "select * from accounts where Name='"+name+"'"; // select all columns from the student (SQLite DB) where Course is as specified
					pst = conn.prepareStatement(query);					
					rs = pst.executeQuery();
					
					//Step 4 - Convert ResultSet to TableModel
					resultSetToTableModel(rs);

				}
				catch(Exception err)
				{
					err.printStackTrace();
				}
			}
		});
		btnQue.setBounds(276, 60, 74, 23);
		panel.add(btnQue);
		
		JButton button = new JButton("QUE>>");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				String add = addTF.getText();
				try
				{
					String query = "select * from accounts where Address='"+add+"'"; // select all columns from the student (SQLite DB) where Course is as specified
					pst = conn.prepareStatement(query);					
					rs = pst.executeQuery();
					
					//Step 4 - Convert ResultSet to TableModel
					resultSetToTableModel(rs);

				}
				catch(Exception err)
				{
					err.printStackTrace();
				}
			}
		});
		button.setBounds(276, 94, 74, 23);
		panel.add(button);
		
		JButton button_1 = new JButton("QUE>>");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		button_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
		
				if(male.isSelected()) {
					String query = "select * from accounts where Gender='Male'"; // select all columns from the student (SQLite DB) where Course is as specified
					try {
						pst = conn.prepareStatement(query);
						rs = pst.executeQuery();
						resultSetToTableModel(rs);


					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}					
					
					//Step 4 - Convert ResultSet to TableModel
				}
				else if(female.isSelected()) {
					String query = "select * from accounts where Gender='Female'"; // select all columns from the student (SQLite DB) where Course is as specified
					try {
						pst = conn.prepareStatement(query);
						rs = pst.executeQuery();
						resultSetToTableModel(rs);


					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}	
				}

				
			}
		});
		button_1.setBounds(276, 128, 74, 23);
		panel.add(button_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(380, 38, 366, 173);
		frame1.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnLoad = new JButton("Load Database to Table");
		btnLoad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnLoad.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				String query = "select * from accounts";
				try {
					pst = conn.prepareStatement(query);
					rs = pst.executeQuery();
					resultSetToTableModel(rs);

				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}	

							
			}
		});
		btnLoad.setBounds(184, 29, 172, 33);
		panel_1.add(btnLoad);
		
		JButton btnDeleteRecords = new JButton("Delete Records");
		btnDeleteRecords.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnDeleteRecords.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Object [] mes = {
						"Input the Student ID NO.",xId
				};
			int res = JOptionPane.showConfirmDialog(null,mes,"Deleting Account Record",JOptionPane.OK_CANCEL_OPTION);
			try
					{		
				if(res == JOptionPane.OK_OPTION) {
					int id = Integer.parseInt(xId.getText());

						int y =searchId(id);
					
							 if(y>0) {
								stmt.executeUpdate("delete from accounts where Id='"+id+"'");
								JOptionPane.showMessageDialog(null, "Succesfully Deleted Records!","",JOptionPane.INFORMATION_MESSAGE);	
							}	
							 else if(id==0) {
									JOptionPane.showMessageDialog(null, "Please input the Account ID! ","",JOptionPane.ERROR_MESSAGE);	
							 }
							else if(y<0) {
										JOptionPane.showMessageDialog(null, "Incorrect ID!!","",JOptionPane.ERROR_MESSAGE);	
							}
								}
						
												}
					catch( SQLException err)
					{
					}
				catch(NumberFormatException ee)
				{
				JOptionPane.showMessageDialog(null, "Please Input the ID","",JOptionPane.ERROR_MESSAGE);	
				}
			
			}
		});
		btnDeleteRecords.setBounds(16, 29, 158, 33);
		panel_1.add(btnDeleteRecords);
		
		JButton btnUpdateRecords = new JButton("Update Records");
		btnUpdateRecords.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try{
				String choice[] = new String[] {
						"Name","Address","Contact","Gender","Password"
				};
				JComboBox<String> ee = new JComboBox(choice);
				
				Object [] mes = {
						"Select the following Column wants to Edit: \n",ee
				};
			int res = JOptionPane.showConfirmDialog(null,mes,"Update Account Record",JOptionPane.OK_CANCEL_OPTION);
			String chc = ee.getItemAt(ee.getSelectedIndex());
			if (res==JOptionPane.OK_OPTION) {
				if(chc.equalsIgnoreCase("Name")) {
					try {
						editName();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				else if(chc.equalsIgnoreCase("Address")) {
					try {
						editAdd();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
				else if(chc.equalsIgnoreCase("Contact")) {
					try {
						editCont();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
				else if(chc.equalsIgnoreCase("Gender")) {
					try {
						editGender();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				else if (chc.equalsIgnoreCase("Password")) {
					try {
						editPass();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			
				}
				catch(NumberFormatException ee)
				{
				JOptionPane.showMessageDialog(null, "Please Input the ID","",JOptionPane.ERROR_MESSAGE);	
				}
		
			}
		});
		btnUpdateRecords.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnUpdateRecords.setBounds(16, 73, 158, 33);
		panel_1.add(btnUpdateRecords);
		
		JButton btnClear = new JButton("Clear");
		btnClear.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				nameTF.setText("");
				addTF.setText("");
				bg.clearSelection();

			}
		});
		btnClear.setBounds(16, 117, 158, 33);
		panel_1.add(btnClear);
		
		JButton btnUnblockAccounts = new JButton("Unblock Accounts");
		btnUnblockAccounts.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnUnblockAccounts.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				LogIn.count = 0;
				JOptionPane.showMessageDialog(null, "Succesfully Unblock Accounts ","",JOptionPane.INFORMATION_MESSAGE);

			}
		});
		btnUnblockAccounts.setBounds(184, 73, 158, 33);
		panel_1.add(btnUnblockAccounts);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 249, 736, 201);
		frame1.getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Name", "Address", "Contact", "Gender", "Password", "Wallet"
			}

		));
		model = (DefaultTableModel) table.getModel();

		JButton btnExit = new JButton("Logout");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnExit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int res = JOptionPane.showConfirmDialog(null, "Are you sure you want to logout?","",JOptionPane.OK_CANCEL_OPTION);
				if(res == JOptionPane.OK_OPTION) {
					LogIn newFrame = new LogIn();
					LogIn.frame.setVisible(true);
					frame1.dispose();
				}
			}
		});
		btnExit.setBounds(10, 4, 89, 23);
		frame1.getContentPane().add(btnExit);
		
		total.setFont(new Font("Tahoma", Font.PLAIN, 14));
		total.setBounds(20, 213, 98, 23);
		frame1.getContentPane().add(total);
	}
}
