package accounts;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.border.TitledBorder;

import accounts.LogIn;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.Color;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;

public class WithdrawDepo {

	static public  JFrame frame3;
	private JTextField idTF = new JTextField();
	private JTextField nameTF = new JTextField();
	private JTextField addTF = new JTextField();
	private JTextField genderTF = new JTextField();
	private JTextField noTF = new JTextField();
	private JTextField walletTF = new JTextField();
	JTextField money = new JTextField();
	JTextField xID = new JTextField();
	ButtonGroup bg = new ButtonGroup();
	JRadioButton male1= new JRadioButton("Male");
	JRadioButton female1 = new JRadioButton("Female");
	JTextField xId = new JTextField();
	JTextField newEdit = new JTextField();
	JPasswordField newPass = new JPasswordField();
	Date date = new Date();
	String fmt = "yy-MM-dd HH:mm:ss";
	SimpleDateFormat sdf = new SimpleDateFormat(fmt);

	Connection conn =  null;
	Statement stmt;
	PreparedStatement pst;
	static ResultSet rs;
	File ff = new File("C:\\Users\\user\\Desktop\\Christian & Judel\\CPE121-Object Oriented Programming\\Database\\A\\Accounts.csv"); 
    FileWriter ww = new FileWriter(ff,true) ; 
	String id,accountPass,name,otherName,gender,no,add,wallet;
	String depo = "Deposit", with = "Withdraw";
	int i,userID;
	static String[] idRec = new String[20];
	double currentMoney;
	;
	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WithdrawDepo window = new WithdrawDepo();
					window.frame3.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @throws SQLException 
	 */
		
	private void editName() throws SQLException {
		clear();
		int o2;
					
					Object [] mes2 = {
							"Input you New Name:",newEdit
					};
					o2 = JOptionPane.showConfirmDialog(null,mes2,"Updating Account Record",JOptionPane.OK_CANCEL_OPTION);
					String t  = newEdit.getText();
					if(o2==JOptionPane.OK_OPTION) {
						// insert the data
						try {
							stmt = conn.createStatement();
							stmt.executeUpdate("update accounts set Name= '"+t+"'where ID='"+userID+"'");
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

	private void editAdd() throws SQLException {
		clear();
		int o,o2;
	
					
					Object [] mes2 = {
							"Input your new Address :",newEdit
					};
					o2 = JOptionPane.showConfirmDialog(null,mes2,"Updating Account Record",JOptionPane.OK_CANCEL_OPTION);
					String t  = newEdit.getText();
					if(o2==JOptionPane.OK_OPTION) {
						// insert the data
						try {
							String query = ("update accounts set Address= '"+t+"'where ID='"+userID+"'");
							pst = conn.prepareStatement(query);	
							pst.execute();
							pst.close();

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
	
	private void editCont() throws SQLException {
		clear();
		int o,o2;

					Object [] mes2 = {
							"Input your new Contact no. :",newEdit
					};
					o2 = JOptionPane.showConfirmDialog(null,mes2,"Updating Account Record",JOptionPane.OK_CANCEL_OPTION);
					String t  = newEdit.getText();
					if(o2==JOptionPane.OK_OPTION) {
						// insert the data
						try {
							String query = ("update accounts set Contact= '"+t+"'where ID='"+userID+"'");
							pst = conn.prepareStatement(query);	
							pst.execute();
							pst.close();
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
	private void editGender() throws SQLException {
		clear();
		String t;
		int o2;

				do {	
					Object [] mes2 = {
							"Select your new Gender :",male1,female1
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
								String query = ("update accounts set Gender= '"+t+"'where ID='"+userID+"'");
								pst = conn.prepareStatement(query);	
								pst.execute();
								pst.close();

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
		
	
	private void editPass() throws SQLException {
		clear();
		int o2;
	
					Object [] mes2 = {
							"Input your new Password :",newPass
					};
					o2 = JOptionPane.showConfirmDialog(null,mes2,"Updating Account Record",JOptionPane.OK_CANCEL_OPTION);
					String t  = newPass.getText();
					if(o2==JOptionPane.OK_OPTION) {
						// insert the data
						try {
							String query = ("update accounts set Password= '"+t+"'where AccountNumber='"+id+"'");
							pst = conn.prepareStatement(query);	
							pst.execute();
							pst.close();

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
	void clear() {
		money.setText("");
		xId.setText("");
		xID.setText("");
		newEdit.setText("");
		bg.clearSelection();
		money.setText("");
	}	
	
	
	
	
	
	private void loadCurrentMoneyUser() throws SQLException {
		String sql = "select * from accounts where ID='"+userID+"'";
		pst = conn.prepareStatement(sql);
		rs = pst.executeQuery();
		currentMoney = rs.getDouble(7);
	}
	
	
	private void loadCurrentMoney() throws SQLException {
		String sql = "select * from accounts where ID='"+id+"'";
		pst = conn.prepareStatement(sql);
		rs = pst.executeQuery();
		currentMoney = rs.getDouble(7);
		otherName = rs.getString("Name");
	}
	
	
	private int searchId(String ID) throws SQLException {
		
		String sql = "Select Id from accounts";
		stmt = conn.createStatement();
		rs = stmt.executeQuery(sql);
		for ( i=0;rs.next();i++) {
			idRec[i] = rs.getString("ID");
			if(ID.matches(idRec[i])) {
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
	public WithdrawDepo() throws IOException{
		initialize();
		conn = dbConnect();
	}
	public void extractRec(){
		String sql = "select * from accounts where ID ='" +userID+"'";
		try {
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();
			name = rs.getString("Name");
			add = rs.getString("Address");
			no = rs.getString("Contact");
			gender = rs.getString("Gender");
			wallet = rs.getString("Wallet");
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void setInfo() {
		idTF.setText(""+userID);
		nameTF.setText(name);
		addTF.setText(add);
		genderTF.setText(gender);
		noTF.setText(no);
		walletTF.setText(wallet);
	}
	public WithdrawDepo(int ID1) throws SQLException, IOException {
		conn = dbConnect();
		initialize();
		userID=ID1;
		extractRec();
		setInfo();	
	}

	

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize () throws IOException{
		frame3 = new JFrame();
		frame3.setBackground(new Color(154, 205, 50));
		frame3.getContentPane().setBackground(new Color(245, 222, 179));
		frame3.setBounds(100, 100, 523, 354);
		frame3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame3.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(222, 184, 135));
		panel.setBorder(new TitledBorder(null, "Accounts Info", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 40, 482, 198);
		frame3.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblId = new JLabel("ID");
		lblId.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblId.setBounds(28, 31, 46, 14);
		panel.add(lblId);
		
		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblName.setBounds(28, 56, 46, 14);
		panel.add(lblName);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAddress.setBounds(28, 81, 82, 14);
		panel.add(lblAddress);
		
		JLabel lblConta = new JLabel("Gender");
		lblConta.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblConta.setBounds(28, 106, 68, 14);
		panel.add(lblConta);
		
		JLabel lblContactNo = new JLabel("Contact no.");
		lblContactNo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblContactNo.setBounds(28, 131, 82, 14);
		panel.add(lblContactNo);
		
		bg.add(female1);
		bg.add(male1);
		
		idTF.setEditable(false);
		idTF.setBounds(116, 30, 174, 20);
		panel.add(idTF);
		idTF.setColumns(10);
		
		nameTF.setEditable(false);
		nameTF.setColumns(10);
		nameTF.setBounds(116, 55, 174, 20);
		panel.add(nameTF);
		
	
		addTF.setEditable(false);
		addTF.setColumns(10);
		addTF.setBounds(116, 80, 174, 20);
		panel.add(addTF);
		
	
		genderTF.setEditable(false);
		genderTF.setColumns(10);
		genderTF.setBounds(116, 105, 174, 20);
		panel.add(genderTF);
		
		
		noTF.setEditable(false);
		noTF.setColumns(10);
		noTF.setBounds(116, 130, 174, 20);
		panel.add(noTF);

		JLabel lblAvailableInWallet = new JLabel("Available in Wallet");
		lblAvailableInWallet.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAvailableInWallet.setBounds(181, 161, 128, 14);
		panel.add(lblAvailableInWallet);
		
	
		walletTF.setEditable(false);
		walletTF.setColumns(10);
		walletTF.setBounds(319, 160, 153, 20);
		panel.add(walletTF);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("C:\\Users\\user\\Pictures\\aaaa.png"));
		label.setBounds(348, 31, 102, 114);
		panel.add(label);
		
		JButton btnNewButton = new JButton("Deposit in my Account");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try {	
					clear();
					double monT;
				Object[] mes = {
						"Input the amount of money to Deposit",money
				};
				int res = JOptionPane.showConfirmDialog(null,mes,"Depositing in your Account",JOptionPane.OK_CANCEL_OPTION );
				 monT =Double.parseDouble(money.getText());
				loadCurrentMoneyUser();
				double mon = monT+currentMoney;
				
									
						if (res == JOptionPane.OK_OPTION) {
							String query = ("update accounts set Wallet='"+mon+"' where Id="+userID);
							stmt = conn.createStatement();	
							stmt.execute(query);
							JOptionPane.showMessageDialog(null,
									"FAST CASH!!   Your No.1 trusted Online Bank\n"+
											"\nMain Office: 117th FL. Alberto BLDG.,CM Recto Ave. St., Lapasan, Cagayan de Oro City"+
											"\nTIN No. 8791-1545-6661"+
											"\nTelephone no. 887-8079"+
											"\nTransaction Type: Deposit\nDate: "+date.toString()
											+"\n\nAccount ID:     		"+userID
											+"\nName: 					"+name		
											+"\nAmount Deposit: 		"+monT
											+"\nBalance	        		"+mon
											+"\nSuccesfully Deposit "
											+"\n\nTHIS SERVE AS YOUR OFFICIAL RECEIPT","",JOptionPane.PLAIN_MESSAGE);							extractRec();
							setInfo();
							ww.write(depo+","+name+","+name+","+monT+","+date.toString());
							ww.append('\n');
							
						}
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					catch(NumberFormatException er) {
						JOptionPane.showMessageDialog(null, "Wrong Inputs ","",JOptionPane.ERROR_MESSAGE);

					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				
			
			
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton.setBounds(10, 249, 207, 23);
		frame3.getContentPane().add(btnNewButton);
		
		JButton btnDepositIntoOther = new JButton("Deposit into other Account");
		btnDepositIntoOther.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnDepositIntoOther.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				clear();
				depoToOtherAcc() ;
			}
		});
		btnDepositIntoOther.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnDepositIntoOther.setBounds(10, 283, 207, 23);
		frame3.getContentPane().add(btnDepositIntoOther);
		
		JButton btnWithdraw = new JButton("Withdraw");
		btnWithdraw.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnWithdraw.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				withdraw();	
			}
		});
		btnWithdraw.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnWithdraw.setBounds(285, 283, 207, 23);
		frame3.getContentPane().add(btnWithdraw);
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnLogout.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int res = JOptionPane.showConfirmDialog(null, "Are you sure you want to logout?","",JOptionPane.OK_CANCEL_OPTION);
				if(res == JOptionPane.OK_OPTION) {
					try {
					
					LogIn newFrame = new LogIn();
					LogIn.frame.setVisible(true);
						conn.close();
						ww.close();
						frame3.dispose();

					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			
			}
		});
		btnLogout.setBounds(10, 11, 89, 23);
		frame3.getContentPane().add(btnLogout);
		
		JButton btnUpdateAccount = 	new JButton("Update Account");
		btnUpdateAccount.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
			
				try{
					String choice[] = new String[] {
							"Name","Address","Contact","Gender","Password"
					};
					JComboBox<String> ee = new JComboBox<String>(choice);
					
					Object [] mes = {
							"Select the following Column wants to Edit: \n",ee
					};
				int res = JOptionPane.showConfirmDialog(null,mes,"Update Account Record",JOptionPane.OK_CANCEL_OPTION);
				String chc = ee.getItemAt(ee.getSelectedIndex());
				if (res==JOptionPane.OK_OPTION) {
					if(chc.equalsIgnoreCase("Name")) {
						try {
							editName();
							extractRec();
							setInfo();
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					else if(chc.equalsIgnoreCase("Address")) {
						try {
							editAdd();
							extractRec();
							setInfo();
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					
					else if(chc.equalsIgnoreCase("Contact")) {
						try {
							editCont();
							extractRec();
							setInfo();
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					
					else if(chc.equalsIgnoreCase("Gender")) {
						try {
							editGender();
							extractRec();
							setInfo();
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					else if (chc.equalsIgnoreCase("Password")) {
						try {
							editPass();
							extractRec();
							setInfo();
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
		btnUpdateAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnUpdateAccount.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnUpdateAccount.setBounds(285, 249, 207, 23);
		frame3.getContentPane().add(btnUpdateAccount);
	}
	private void depoToOtherAcc() {
		try {
			int conF = 0,y1 = 0;
			double amountDue, cashBack = 0;
			clear();
			do {
				
				do {
					
					clear();			
			
		Object[] mes = {
				"Input the ID no. of the Account:",xID
		};
		int y = JOptionPane.showConfirmDialog(null, mes,"Depositing to the other Account",JOptionPane.OK_CANCEL_OPTION);
		if(y==JOptionPane.OK_OPTION){
			 id = xID.getText();
			
				 y1 = searchId(id);
				if(y1<0){
					JOptionPane.showMessageDialog(null, "Incorrect ID ","",JOptionPane.ERROR_MESSAGE);
				}
				
				else if(y1>0) {
				
					Object[] mes2 = {
							"Input the Amount of Money to Deposit:",money
					};
					int x= JOptionPane.showConfirmDialog(null, mes2,"Depositing to the other Account",JOptionPane.OK_CANCEL_OPTION);
					if(x==JOptionPane.OK_OPTION){
						 loadCurrentMoney();
						double mon = Double.parseDouble(money.getText());
						
						
						Object[] confirmation = {
								
								"Confirmation of your details: \nPress OK to Proceed\nPress CANCEL to Edit\n\n"
								+"Id Number: \t"+id + "\nName: \t"+otherName+"\nMoney to be Deposit: \t"
								+mon
							};
							
							 conF = JOptionPane.showConfirmDialog(null, confirmation,"Your Information",JOptionPane.OK_CANCEL_OPTION);
							
							if (conF == JOptionPane.OK_OPTION) {
								
								amountDue = mon*1.02;
								do {
								
								clear();
								Object[] confirmation1 = {
										"Amount Due: \t"+amountDue+"\nInput Cash Tendered: \t",money
									};
								int conF1 = JOptionPane.showConfirmDialog(null, confirmation1,"Your Information",JOptionPane.OK_CANCEL_OPTION);
								
								if(conF1 == JOptionPane.OK_OPTION) {
									cashBack = Double.parseDouble(money.getText());
								
										
									
									if(cashBack<amountDue) {
										JOptionPane.showMessageDialog(null, "Insufficient Amount for Depositing money","Depositing Into Other Account",JOptionPane.ERROR_MESSAGE);
									}
									else {
										double monToDepo = mon+currentMoney;
										String query = ("update accounts set Wallet ='"+monToDepo+ "'where Id='"+id+"'");
										pst = conn.prepareStatement(query);	
										pst.execute();
										JOptionPane.showMessageDialog(null,
												"FAST CASH!!   Your No.1 trusted Online Bank\n"+
												"\nMain Office: 117th FL. Alberto BLDG.,CM Recto Ave. St., Lapasan, Cagayan de Oro City"+
												"\nTIN No. 8791-1545-6661"+
												"\nTelephone no. 887-8079"+
												"\nTransaction Type: Depositing other Accounts\nDate: "+date.toString()
												+"\n\nAccount ID: 			"+id
												+"\nName: 		    		"+otherName
												+"\nAmount Deposited: 		"+mon
								+"\n\nDeposit by: \nName:   				"+name
												+"\nAccount ID:     		"+userID
												+"\nAmount Deposited: 		"+mon
												+"\nTotal: 					"+amountDue
												+"\nCash Tendered: 			"+cashBack
												+"\nChange: 				"+(cashBack-amountDue)
												+"\nSuccesfully Deposit "
												+"\n\nTHIS SERVE AS YOUR OFFICIAL RECEIPT","",JOptionPane.PLAIN_MESSAGE);
										extractRec();
										setInfo();	
										ww.write(depo+","+name+","+otherName+","+mon+","+date.toString());
										ww.append('\n');
										
										break;
											
									}
								}
								
					
								}while(cashBack<amountDue);
								
								
								
								
							}
							else if(conF==JOptionPane.CLOSED_OPTION) break;
							
							}
					
				}
				
			} 
		
		
		
		else break;
		
		
				}while(y1<0);
		
			}while(conF==JOptionPane.CANCEL_OPTION);
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch(NumberFormatException er) {
			JOptionPane.showMessageDialog(null, "Wrong Inputs ","",JOptionPane.ERROR_MESSAGE);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	
		
		
	}
	
	public void withdraw() {
		try {
			clear();
		loadCurrentMoneyUser();
		double mon=0, amountDue = 0, balance = 0;
; 
		do {
			
		Object[] mes = {
				"Input the amount to be Withdraw",money
		};
		int res = JOptionPane.showConfirmDialog(null,mes,"Withdraw in your Account",JOptionPane.OK_CANCEL_OPTION );
		mon = Double.parseDouble(money.getText());
		
		
								
				if (res == JOptionPane.OK_OPTION) {
					if(currentMoney<mon) {
						JOptionPane.showMessageDialog(null, "Insufficient money to be Withdraw ","",JOptionPane.ERROR_MESSAGE);
					}
					else if(currentMoney==mon) {
						JOptionPane.showMessageDialog(null, "Insufficient money to be Withdraw ","",JOptionPane.ERROR_MESSAGE);
					}
					
					else {

						balance = (currentMoney-mon);
						String query = ("update accounts set Wallet='"+balance+"' where Id="+userID);
						stmt = conn.createStatement();	
						stmt.execute(query);
						JOptionPane.showMessageDialog(null,
								"FAST CASH!!   Your No.1 trusted Online Bank\n"+
										"\nMain Office: 117th FL. Alberto BLDG.,CM Recto Ave. St., Lapasan, Cagayan de Oro City"+
										"\nTIN No. 8791-1545-6661"+
										"\nTelephone no. 887-8079"+
										"\nTransaction Type: Withdrawal\nDate: "+date.toString()
										+"\n\nAccount ID:     		"+userID
										+"\nName: 					"+name		
										+"\nAmount Withdraw: 		"+mon
										+"\nBalance					"+balance
										+"\nSuccesfully Withdraw "
										+"\n\nTHIS SERVE AS YOUR OFFICIAL RECEIPT","",JOptionPane.PLAIN_MESSAGE);
										extractRec();
										setInfo();
										ww.write(with+","+name+","+name+","+mon+","+date.toString());
										ww.append('\n');
					}
			
				}
				else if (res==JOptionPane.CANCEL_OPTION) {
					int res1 = JOptionPane.showConfirmDialog(null,"Are you sure you want to cancel your Withdrawal?","Withdraw in your Account",JOptionPane.OK_CANCEL_OPTION );
						if(res1==JOptionPane.OK_OPTION) {
							break;
						}
					else {
						break;
					}
				}
					
			}while(currentMoney<mon);

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			catch(NumberFormatException er) {
				JOptionPane.showMessageDialog(null, "Wrong Inputs ","",JOptionPane.ERROR_MESSAGE);

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}
	
}
