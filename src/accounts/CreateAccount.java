package accounts;

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
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.JPasswordField;
import java.awt.Color;
import javax.swing.SwingConstants;

public class CreateAccount {

	public static JFrame frame2;
	private JTextField nameTF;
	private JTextField addTF;
	private JTextField contactTF;
	ButtonGroup bg = new ButtonGroup();
	

	Connection conn =  null;
	Statement stmt;
	PreparedStatement pst;
	static int idRec[] = new int[20];
	static ResultSet rs;
	private JPasswordField passTF;
	int i;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CreateAccount window = new CreateAccount();
					CreateAccount.frame2.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	
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
	
	public CreateAccount() {
		initialize();
		conn = dbConnect();
	}

	/**
	 * Initialize the contents of the frame.
	 * 
	 */
	
	private void initialize() {
		frame2 = new JFrame();
		frame2.getContentPane().setBackground(new Color(255, 228, 181));
		frame2.setBounds(100, 100, 454, 411);
		frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame2.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(204, 153, 51));
		panel.setBorder(new TitledBorder(null, "Accounts Info", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 25, 318, 263);
		frame2.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblName.setBounds(10, 28, 54, 21);
		panel.add(lblName);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAddress.setBounds(10, 60, 65, 21);
		panel.add(lblAddress);
		
		JLabel lblGender = new JLabel("Gender");
		lblGender.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblGender.setBounds(10, 92, 54, 21);
		panel.add(lblGender);
		
		JLabel lblContactNo = new JLabel("Contact No.");
		lblContactNo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblContactNo.setBounds(10, 124, 74, 21);
		panel.add(lblContactNo);
		
		JRadioButton male = new JRadioButton("Male");
		male.setBounds(104, 93, 80, 23);
		panel.add(male);
		
		JRadioButton female = new JRadioButton("Female");
		female.setBounds(207, 93, 80, 23);
		panel.add(female);
		bg.add(male);
		bg.add(female);
		
		JButton btnCreate = new JButton("Save");
		btnCreate.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try {
					
				
				String name,no,add,gender,pass = null;
				int id = 0;
				String sql1 = "Select ID from accounts";
				stmt = conn.createStatement();
				rs = stmt.executeQuery(sql1);
				for(i=0;rs.next();i++) {
					idRec[i] = rs.getInt(1);
					if (idRec[0]==0) {
						break;
						}
					else
					id = idRec[i];
					
				}
				
				name = nameTF.getText();
				add = addTF.getText();
				pass = passTF.getText();
				gender = (male.isSelected())? male.getLabel(): female.getLabel();
				no = contactTF.getText();
				if(!name.isEmpty()&&!add.isEmpty()&&!gender.isEmpty()&&!no.isEmpty()&&!pass.isEmpty()) {
					Object[] confirmation = {
							
						"Confirmation of your details: \nPress OK to Proceed\nPress CANCEL to Edit\n\nName: \t"+name+"\nAddress: \t"+add+
						"\nGender: \t"+gender+"\nContact no.: \t"+no+"\nPassword: \t"+pass	
					};
					
					int conF = JOptionPane.showConfirmDialog(null, confirmation,"Your Information",JOptionPane.OK_CANCEL_OPTION);
					
					if (conF == JOptionPane.OK_OPTION) {
						String sql = "insert into accounts (ID,Name,Address,Contact,Gender,Password,Wallet) values (?,?,?,?,?,?,?)";
						pst = conn.prepareStatement(sql);
						if(id==0) {
							id=2019001;
							pst.setInt(1,  2019001);

						}
						else if (id>0) {
							id++;
							pst.setInt(1,  (id));

						}
						
						pst.setString(2, name);
						pst.setString(3, add);
						pst.setString(4, no);
						pst.setString(5, gender);
						pst.setString(6, pass);
						pst.setDouble(7, 0.0);
						pst.execute();
						JOptionPane.showMessageDialog(null, " Welcome to FAST CASH!!   Your No.1 trusted Online Bank \nHello "+name+"!!\nYour ID Number is: "+id+ "\nSuccesfully Created Account! :-) ","",JOptionPane.INFORMATION_MESSAGE);
							LogIn newFrame = new LogIn();
							LogIn.frame.setVisible(true);
							frame2.dispose();
					}
					
					
			
				}
				else {
					JOptionPane.showMessageDialog(null, "Lacking Data Entry","",JOptionPane.ERROR_MESSAGE);
				}
				}
				
				catch(NumberFormatException e) {
					JOptionPane.showMessageDialog(null, "Wrong Inputs! "+e,"",JOptionPane.ERROR_MESSAGE);
				}
				catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
			}
		});
		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnCreate.setBounds(41, 217, 89, 23);
		panel.add(btnCreate);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				LogIn newFrame = new LogIn();
				LogIn.frame.setVisible(true);
				frame2.dispose();
			}
		});
		btnCancel.setBounds(179, 217, 89, 23);
		panel.add(btnCancel);
		
		nameTF = new JTextField();
		nameTF.setBounds(104, 30, 204, 20);
		panel.add(nameTF);
		nameTF.setColumns(10);
		
		addTF = new JTextField();
		addTF.setColumns(10);
		addTF.setBounds(104, 62, 204, 20);
		panel.add(addTF);
		
	
		contactTF = new JTextField();
		contactTF.setColumns(10);
		contactTF.setBounds(104, 126, 204, 20);
		panel.add(contactTF);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPassword.setBounds(10, 156, 80, 21);
		panel.add(lblPassword);
		
		passTF = new JPasswordField();
		passTF.setBounds(104, 157, 204, 20);
		panel.add(passTF);
		
		JLabel lblNewLabel = new JLabel("N");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel.setBounds(338, 6, 20, 37);
		frame2.getContentPane().add(lblNewLabel);
		
		JLabel lblE = new JLabel("E");
		lblE.setVerticalAlignment(SwingConstants.TOP);
		lblE.setHorizontalAlignment(SwingConstants.LEFT);
		lblE.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblE.setBounds(368, 6, 20, 37);
		frame2.getContentPane().add(lblE);
		
		JLabel lblW = new JLabel("W");
		lblW.setVerticalAlignment(SwingConstants.TOP);
		lblW.setHorizontalAlignment(SwingConstants.LEFT);
		lblW.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblW.setBounds(398, 6, 30, 37);
		frame2.getContentPane().add(lblW);
		
		JLabel lblA = new JLabel("A");
		lblA.setVerticalAlignment(SwingConstants.TOP);
		lblA.setHorizontalAlignment(SwingConstants.LEFT);
		lblA.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblA.setBounds(368, 54, 20, 37);
		frame2.getContentPane().add(lblA);
		
		JLabel lblC = new JLabel("c");
		lblC.setVerticalAlignment(SwingConstants.TOP);
		lblC.setHorizontalAlignment(SwingConstants.LEFT);
		lblC.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblC.setBounds(368, 94, 20, 37);
		frame2.getContentPane().add(lblC);
		
		JLabel lblC_1 = new JLabel("c");
		lblC_1.setVerticalAlignment(SwingConstants.TOP);
		lblC_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblC_1.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblC_1.setBounds(368, 142, 20, 37);
		frame2.getContentPane().add(lblC_1);
		
		JLabel lblO = new JLabel("u");
		lblO.setVerticalAlignment(SwingConstants.TOP);
		lblO.setHorizontalAlignment(SwingConstants.LEFT);
		lblO.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblO.setBounds(368, 225, 20, 52);
		frame2.getContentPane().add(lblO);
		
		JLabel lblO_1 = new JLabel("o");
		lblO_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblO_1.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblO_1.setBounds(368, 188, 20, 37);
		frame2.getContentPane().add(lblO_1);
		
		JLabel lblN = new JLabel("n");
		lblN.setVerticalAlignment(SwingConstants.TOP);
		lblN.setHorizontalAlignment(SwingConstants.LEFT);
		lblN.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblN.setBounds(368, 260, 20, 37);
		frame2.getContentPane().add(lblN);
		
		JLabel lblY = new JLabel("t");
		lblY.setVerticalAlignment(SwingConstants.TOP);
		lblY.setHorizontalAlignment(SwingConstants.LEFT);
		lblY.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblY.setBounds(368, 308, 20, 37);
		frame2.getContentPane().add(lblY);
	}
}
