package GUIs;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;

import java.sql.SQLException;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;

import works.Bank;

import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class WithdrawGUI {

	public static long nowid;
	
	public WithdrawGUI(long id){
		nowid = id;
	}
	
	protected Shell WithdrawGUI;
	private Text withdrawmoneyText;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			WithdrawGUI window = new WithdrawGUI(nowid);
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
		WithdrawGUI.open();
		WithdrawGUI.layout();
		while (!WithdrawGUI.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		WithdrawGUI = new Shell();
		WithdrawGUI.setSize(450, 300);
		WithdrawGUI.setText("SWT Application");
		
		Label lblSunmyBank = new Label(WithdrawGUI, SWT.NONE);
		lblSunmyBank.setBounds(163, 10, 94, 20);
		lblSunmyBank.setText("Sunmy Bank");
		
		Label label = new Label(WithdrawGUI, SWT.NONE);
		label.setBounds(39, 56, 128, 20);
		label.setText("\u8BF7\u8F93\u5165\u53D6\u6B3E\u91D1\u989D\uFF1A");
		
		withdrawmoneyText = new Text(WithdrawGUI, SWT.BORDER);
		withdrawmoneyText.setBounds(173, 56, 155, 26);
		
		Button button = new Button(WithdrawGUI, SWT.NONE);
		button.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				Bank bank = new Bank();
				System.out.println(withdrawmoneyText.getText());
				System.out.println(nowid);
				Double.valueOf(Double.valueOf(withdrawmoneyText.getText()));
				//bank.readData();
//				try {
//					WithdrawGUI.close();
//					bank.withdraw(nowid,Double.valueOf(withdrawmoneyText.getText()));
//					MainInterface maininterface = new MainInterface(nowid);
//					maininterface.getAcc(nowid);
//					//bank.upDate();
//					maininterface.open();
//				} catch (Exception balancenotenoughexp) {
//					// TODO Auto-generated catch block
//					BalanceError balanceerror = new BalanceError();
//					balanceerror.open();
//					balancenotenoughexp.printStackTrace();
//					MainInterface maininterface = new MainInterface(nowid);
//					maininterface.getAcc(nowid);
//					maininterface.open();
//				}
				//WithdrawGUI.close();
				try {
					try {
						bank.withdraw(nowid,Double.valueOf(withdrawmoneyText.getText()));
					} catch (BalanceNotEnoughException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					MainInterface maininterface = new MainInterface(nowid);
					maininterface.getAcc(nowid);
					maininterface.open();
				} catch (NumberFormatException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					BalanceError balanceerror = new BalanceError();
					balanceerror.open();
					MainInterface maininterface = new MainInterface(nowid);
					maininterface.getAcc(nowid);
					maininterface.open();
				}
				
			}
		});
		button.setBounds(156, 146, 90, 30);
		button.setText("\u786E\u5B9A");
		
		Button button_1 = new Button(WithdrawGUI, SWT.NONE);
		button_1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				//Bank bank = new Bank();
				//bank.upDate();
				WithdrawGUI.close();
			}
		});
		button_1.setBounds(156, 202, 90, 30);
		button_1.setText("\u9000\u51FA");

	}

}
