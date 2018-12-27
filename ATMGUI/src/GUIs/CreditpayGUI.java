package GUIs;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;

import java.sql.SQLException;

//import javax.swing.JOptionPane;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;

import works.Bank;

import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class CreditpayGUI {

	static long nowid;
	private static double creditmoney;
	private static double leftcreditmoney;
	public CreditpayGUI(long id){
		nowid = id;
	}
	public void getCreditInfo(){
		try {
			creditmoney = Bank.mysql.creditquerycreditamount(nowid);
			leftcreditmoney = Bank.mysql.creditquerytotalcreditamount(nowid);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	protected Shell CreditpayGUI;
	private Text nowcreditmoneyText;
	private Text leftcreditmoneyText;
	private Text paycreditText;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			CreditpayGUI window = new CreditpayGUI(nowid);
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
		CreditpayGUI.open();
		CreditpayGUI.layout();
		while (!CreditpayGUI.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		CreditpayGUI = new Shell();
		CreditpayGUI.setSize(450, 300);
		CreditpayGUI.setText("SWT Application");
		
		Label lblSunmyBank = new Label(CreditpayGUI, SWT.NONE);
		lblSunmyBank.setBounds(165, 10, 99, 20);
		lblSunmyBank.setText("Sunmy Bank");
		
		Label label = new Label(CreditpayGUI, SWT.NONE);
		label.setBounds(36, 52, 99, 20);
		label.setText("\u5F53\u524D\u5DF2\u900F\u652F\uFF1A");
		
		nowcreditmoneyText = new Text(CreditpayGUI, SWT.BORDER);
		nowcreditmoneyText.setBounds(135, 49, 166, 26);
		nowcreditmoneyText.setText(String.valueOf(creditmoney));
		
		Label label_1 = new Label(CreditpayGUI, SWT.NONE);
		label_1.setBounds(36, 94, 99, 20);
		label_1.setText("\u53EF\u900F\u652F\u989D\u5EA6\uFF1A");
		
		leftcreditmoneyText = new Text(CreditpayGUI, SWT.BORDER);
		leftcreditmoneyText.setBounds(135, 91, 166, 26);
		leftcreditmoneyText.setText(String.valueOf(leftcreditmoney));
		
		Label label_2 = new Label(CreditpayGUI, SWT.NONE);
		label_2.setBounds(51, 145, 70, 20);
		label_2.setText("\u8FD8\u6B3E\u989D\uFF1A");
		
		paycreditText = new Text(CreditpayGUI, SWT.BORDER);
		paycreditText.setBounds(135, 145, 166, 26);
		
		Button button = new Button(CreditpayGUI, SWT.NONE);
		button.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				Bank bank = new Bank();
				try{
					try {
						bank.withdraw(nowid, Double.valueOf(paycreditText.getText()));
					} catch (BalanceNotEnoughException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					bank.paycredit(nowid,Double.valueOf(paycreditText.getText()));
				}catch (NumberFormatException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		button.setBounds(165, 177, 90, 30);
		button.setText("\u8FD8\u6B3E");
		
		Button button_1 = new Button(CreditpayGUI, SWT.NONE);
		button_1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				CreditpayGUI.close();
			}
		});
		button_1.setBounds(165, 214, 90, 30);
		button_1.setText("\u9000\u51FA");

	}

}
