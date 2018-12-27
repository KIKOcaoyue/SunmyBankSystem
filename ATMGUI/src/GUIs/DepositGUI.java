package GUIs;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;

import works.Bank;

import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class DepositGUI {

	private static long nowid;
	public DepositGUI(long id){
		nowid = id;
	}
	protected Shell DepositGUI;
	private Text depositText;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			DepositGUI window = new DepositGUI(nowid);
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
		DepositGUI.open();
		DepositGUI.layout();
		while (!DepositGUI.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		DepositGUI = new Shell();
		DepositGUI.setSize(450, 300);
		DepositGUI.setText("SWT Application");
		
		Label lblSunmyBank = new Label(DepositGUI, SWT.NONE);
		lblSunmyBank.setBounds(166, 10, 88, 20);
		lblSunmyBank.setText("Sunmy Bank");
		
		Label label = new Label(DepositGUI, SWT.NONE);
		label.setBounds(56, 64, 70, 20);
		label.setText("\u5B58\u6B3E\u91D1\u989D\uFF1A");
		
		depositText = new Text(DepositGUI, SWT.BORDER);
		depositText.setBounds(146, 64, 174, 26);
		
		Button depositbtn = new Button(DepositGUI, SWT.NONE);
		depositbtn.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				Bank bank = new Bank();
				//bank.readData();
				try{
					bank.deposit(nowid,Double.valueOf(depositText.getText()));
					MainInterface maininterface = new MainInterface(nowid);
					maininterface.getAcc(nowid);
					//bank.upDate();
					maininterface.open();
				}catch (Exception balancenotenoughexp) {
					// TODO Auto-generated catch block
					BalanceError balanceerror = new BalanceError();
					balanceerror.open();
					balancenotenoughexp.printStackTrace();
					MainInterface maininterface = new MainInterface(nowid);
					maininterface.getAcc(nowid);
					maininterface.open();
				}
			}
		});
		depositbtn.setBounds(166, 150, 90, 30);
		depositbtn.setText("\u786E\u5B9A");
		
		Button button = new Button(DepositGUI, SWT.NONE);
		button.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				//Bank bank = new Bank();
				//bank.upDate();
				DepositGUI.close();
			}
		});
		button.setBounds(166, 202, 90, 30);
		button.setText("\u9000\u51FA");

	}

}
