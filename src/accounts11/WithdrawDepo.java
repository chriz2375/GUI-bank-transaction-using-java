package accounts11;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import accounts.LogIn;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.Color;
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
	


	Connection conn =  null;
	Statement stmt;
	PreparedStatement pst;
	static ResultSet rs;
	String accountUser=null,id,accountPass,name,gender,no,add,wallet;
	int i;
	static String[] idRec = new String[20];
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
	 */

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
			conn = DriverManager.getConnection("JDBC:sqlite:C:\\LanSchool Files\\accounts.sqlite"); // created using SQLite Manager (SQLiteManager_4.6.6_1430708940)
			// prompt user if connection attempt is successful
			return conn;
		}
		catch (Exception err)
		{
			JOptionPane.showMessageDialog(null, "Connection unsuccessful. Exception -> "+err);
			return null;
		}
	}
	public WithdrawDepo() {
		initialize();
		conn = dbConnect();
	}
	public void extractRec(){
		String sql = "select * from accounts where Username ='" +accountUser+"'";
		try {
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();
			id = rs.getString("ID");
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
		idTF.setText(""+id);
		nameTF.setText(name);
		addTF.setText(add);
		genderTF.setText(gender);
		noTF.setText(no);
		walletTF.setText(wallet);
	}
	public WithdrawDepo(String user, String pass) throws SQLException {
		
		conn = dbConnect();
		initialize();	
		accountUser = user;
		accountPass = pass;
		extractRec();
		setInfo();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame3 = new JFrame();
		frame3.setBackground(new Color(154, 205, 50));
		frame3.getContentPane().setBackground(new Color(245, 222, 179));
		frame3.setBounds(100, 100, 523, 391);
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
		
		JLabel label = new JLabel("New label");
		label.setIcon(new ImageIcon("C:\\Users\\user\\Pictures\\download.png"));
		label.setBounds(304, 11, 168, 136);
		panel.add(label);
		
		JButton btnNewButton = new JButton("Deposit in my Account");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Object[] mes = {
						"Input the amount of money to Deposit",money
				};
				int res = JOptionPane.showConfirmDialog(null,mes,"Depositing in your Account",JOptionPane.OK_CANCEL_OPTION );
				double mon =Double.parseDouble(money.getText());
				
					try {						
						if (res == JOptionPane.OK_OPTION) {
							String query = ("update accounts set Wallet='"+mon+"' where Id="+id);
							stmt = conn.createStatement();	
							stmt.execute(query);
							JOptionPane.showMessageDialog(null, "Succesfully Deposit","",JOptionPane.INFORMATION_MESSAGE);
						}
					} catch (SQLException e) {
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
				try {
				Object[] mes = {
						"Input the ID no. of the Account:",xID
				};
				int y = JOptionPane.showConfirmDialog(null, mes,"Depositing to the other Account",JOptionPane.OK_CANCEL_OPTION);
				if(y==JOptionPane.OK_OPTION){
					 id = xID.getText();
						int y1 = searchId(id);
						if(y1<0){
							JOptionPane.showMessageDialog(null, "Incorrect ID ","",JOptionPane.ERROR_MESSAGE);
						}
						else if(y1>0) {
							Object[] mes2 = {
									"Input the Amount of Money to Deposit:",money
							};
							int x= JOptionPane.showConfirmDialog(null, mes2,"Depositing to the other Account",JOptionPane.OK_CANCEL_OPTION);
							if(x==JOptionPane.OK_OPTION){
								double mon = Double.parseDouble(money.getText());
								String query = ("update accounts set Wallet ='"+mon+ "'where Id='"+id+"'");
								pst = conn.prepareStatement(query);	
								pst.execute();
								JOptionPane.showMessageDialog(null, "Succesfully Deposit ","",JOptionPane.INFORMATION_MESSAGE);

							}

						}
					} 
				}
				catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnDepositIntoOther.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnDepositIntoOther.setBounds(10, 283, 207, 23);
		frame3.getContentPane().add(btnDepositIntoOther);
		
		JButton btnWithdraw = new JButton("Withdraw");
		btnWithdraw.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnWithdraw.setBounds(10, 317, 207, 23);
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
						frame3.dispose();

					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			
			}
		});
		btnLogout.setBounds(10, 11, 89, 23);
		frame3.getContentPane().add(btnLogout);
		
		JButton btnUpdateAccount = 	new JButton("Update Account");
		btnUpdateAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnUpdateAccount.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnUpdateAccount.setBounds(285, 249, 207, 23);
		frame3.getContentPane().add(btnUpdateAccount);
		
		JButton btnViewInfo = new JButton("View Info");
		btnViewInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				extractRec();
				setInfo();
			}
		});
		btnViewInfo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
			}
		});
		btnViewInfo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnViewInfo.setBounds(285, 283, 207, 23);
		frame3.getContentPane().add(btnViewInfo);
	}
}
