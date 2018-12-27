package GUIs;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;

import java.sql.SQLException;

import javax.swing.JOptionPane;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;

import works.Bank;

import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class RegisterGUI {

	static long registerid = -1;
	protected Shell RegisterGUI;
	private Text nameText;
	private Text passwordText;
	private Text confirmpasswordText;
	private Text emailText;
	private Text personidText;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			RegisterGUI window = new RegisterGUI();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		RegisterGUI.open();
		RegisterGUI.layout();
		while (!RegisterGUI.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		RegisterGUI = new Shell();
		RegisterGUI.setSize(450, 345);
		RegisterGUI.setText("SWT Application");
		
		Label lblSunmyBank = new Label(RegisterGUI, SWT.NONE);
		lblSunmyBank.setBounds(166, 10, 98, 20);
		lblSunmyBank.setText("Sunmy Bank");
		
		Label label = new Label(RegisterGUI, SWT.NONE);
		label.setBounds(53, 45, 48, 20);
		label.setText("\u59D3\u540D\uFF1A");
		
		nameText = new Text(RegisterGUI, SWT.BORDER);
		nameText.setBounds(120, 45, 177, 26);
		
		Combo ChooseAccType = new Combo(RegisterGUI, SWT.NONE);
		ChooseAccType.setItems(new String[] {"CreditAccount", "SavingAccount"});
		ChooseAccType.setBounds(120, 77, 177, 28);
		ChooseAccType.select(0);
		
		Label label_1 = new Label(RegisterGUI, SWT.NONE);
		label_1.setBounds(39, 83, 70, 20);
		label_1.setText("\u8D26\u6237\u7C7B\u578B\uFF1A");
		
		Button button = new Button(RegisterGUI, SWT.NONE);
		button.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				Bank bank = new Bank();
				if(passwordText.getText().equals(confirmpasswordText.getText())){
					try {
						bank.register(passwordText.getText(),nameText.getText(),emailText.getText(),personidText.getText(),ChooseAccType.getText());
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					ShowInfo showinfo = null;
					try {
						showinfo = new ShowInfo(Bank.mysql.getlastid(),nameText.getText(),0,ChooseAccType.getText());
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					//bank.upDate();
					showinfo.open();
				}else{
					JOptionPane.showMessageDialog(null, "两次密码不相同", "提示消息", JOptionPane.ERROR_MESSAGE);

				}
			}
		});
		button.setBounds(53, 263, 90, 30);
		button.setText("\u6CE8\u518C");
		
		Button button_1 = new Button(RegisterGUI, SWT.NONE);
		button_1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				RegisterGUI.close();
			}
		});
		button_1.setBounds(311, 263, 90, 30);
		button_1.setText("\u9000\u51FA");
		
		Label label_2 = new Label(RegisterGUI, SWT.NONE);
		label_2.setBounds(53, 186, 48, 20);
		label_2.setText("\u5BC6\u7801\uFF1A");
		
		passwordText = new Text(RegisterGUI, SWT.BORDER);
		passwordText.setBounds(120, 186, 177, 26);
		
		Label label_3 = new Label(RegisterGUI, SWT.NONE);
		label_3.setBounds(39, 221, 70, 20);
		label_3.setText("\u786E\u8BA4\u5BC6\u7801\uFF1A");
		
		confirmpasswordText = new Text(RegisterGUI, SWT.BORDER);
		confirmpasswordText.setBounds(120, 218, 177, 26);
		
		Label label_4 = new Label(RegisterGUI, SWT.NONE);
		label_4.setBounds(39, 114, 70, 20);
		label_4.setText("\u7535\u5B50\u90AE\u7BB1\uFF1A");
		
		emailText = new Text(RegisterGUI, SWT.BORDER);
		emailText.setBounds(120, 111, 177, 26);
		
		Label label_5 = new Label(RegisterGUI, SWT.NONE);
		label_5.setBounds(24, 153, 85, 20);
		label_5.setText("\u8EAB\u4EFD\u8BC1\u53F7\u7801\uFF1A");
		
		personidText = new Text(RegisterGUI, SWT.BORDER);
		personidText.setBounds(120, 153, 177, 26);
		
		Button button_2 = new Button(RegisterGUI, SWT.NONE);
		button_2.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				LoginGUI logingui = new LoginGUI();
				logingui.open();
			}
		});
		button_2.setBounds(174, 263, 90, 30);
		button_2.setText("\u767B\u9646");

	}
}
