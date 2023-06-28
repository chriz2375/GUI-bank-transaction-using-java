package accounts;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import java.awt.Color;
import admin.AdminFrame;
import javax.swing.JPopupMenu;
import java.awt.Component;

public class LogIn {

	public static JFrame frame;
	private JTextField idTF;


	Connection conn =  null;
	Statement stmt;
	PreparedStatement pst;
	static ResultSet rs;
	static String Pass[] = new String[20];
	int i;
	static int idRec[] = new int[20];
	 int line,user;
	 public static int count = 0;
	String pass;
	private JPasswordField passTF;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LogIn window = new LogIn();
					window.frame.setVisible(true);
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
	
	public LogIn() {
		initialize();
		conn = dbConnect();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws SQLException 
	 */
	
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

	private int searchPass(String pass) throws SQLException {
		String sql = "Select Password from accounts";
		stmt = conn.createStatement();
		rs = stmt.executeQuery(sql);
		for(line=0;rs.next();line++) {
			Pass[line] = rs.getString("Password");
			if(Pass[line].matches(pass)){
				return 1;
			}
		}
		return -1;
	}
	
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(245, 222, 179));
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton logBtn = new JButton("Login");
		logBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		logBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
			try {
				int x,y;
				int admin = 1122554;
				user = Integer.parseInt(idTF.getText());
				pass = passTF.getText();
		
				
				if(user==admin &&pass.matches("091254")) {
					AdminFrame newFrame = new AdminFrame();
					AdminFrame.frame1.setVisible(true);
					conn.close();
					frame.dispose();
				}
				
				else {
					
					if(count<3)
					{

						 x = searchId(user);					
						  if(x>0){
						y = searchPass(pass);
						 if (pass.isEmpty()) {
							JOptionPane.showMessageDialog(null, "Please input Password","",JOptionPane.ERROR_MESSAGE);
						 					}
						 else if(y>0){
							WithdrawDepo newFrame = new WithdrawDepo(user);
							 WithdrawDepo.frame3.setVisible(true);
							 conn.close();
							 frame.dispose();
						 			}
						else if(y<0) {
							JOptionPane.showMessageDialog(null, "Incorrect Password","",JOptionPane.ERROR_MESSAGE);
							count++;
									}
						
						else  {
							JOptionPane.showMessageDialog(null, "Incorrect Username","",JOptionPane.ERROR_MESSAGE);
							  }

						 			}
						  else {
								JOptionPane.showMessageDialog(null, "Please Input Username","",JOptionPane.ERROR_MESSAGE);

						  
					}
						  }
					else if(count>=3) {
						JOptionPane.showMessageDialog(null, "Account Block!! Contact Your Admind!  ","",JOptionPane.ERROR_MESSAGE);

					}

					  
					  
					  
				}
			
				

			}
			catch (SQLException e) {
				
			}
			catch(NumberFormatException er) {
				JOptionPane.showMessageDialog(null, "Wrong Inputs ","",JOptionPane.ERROR_MESSAGE);

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}
		});
		logBtn.setBounds(335, 172, 89, 23);
		frame.getContentPane().add(logBtn);
		
		JButton signBtn = new JButton("Sign up");
		signBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				CreateAccount newFrame = new CreateAccount();
				CreateAccount.frame2.setVisible(true);
				frame.dispose();
			}
		});
		signBtn.setBounds(319, 40, 89, 23);
		frame.getContentPane().add(signBtn);
		
		JButton btnCancel = new JButton("Exit");
		btnCancel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				System.exit(0);
			}
		});
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnCancel.setBounds(335, 211, 89, 23);
		frame.getContentPane().add(btnCancel);
		
		JLabel lblUsername = new JLabel("ID Number");
		lblUsername.setBounds(35, 176, 78, 19);
		frame.getContentPane().add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(35, 215, 78, 19);
		frame.getContentPane().add(lblPassword);
		
		idTF = new JTextField();
		idTF.setBounds(104, 175, 150, 20);
		frame.getContentPane().add(idTF);
		idTF.setColumns(10);
		
		JLabel lblNotHaveAccount = new JLabel("Not have account yet? ");
		lblNotHaveAccount.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNotHaveAccount.setBounds(252, 11, 156, 28);
		frame.getContentPane().add(lblNotHaveAccount);
		
		passTF = new JPasswordField();
		passTF.setBounds(104, 212, 150, 20);
		frame.getContentPane().add(passTF);
	}
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}
