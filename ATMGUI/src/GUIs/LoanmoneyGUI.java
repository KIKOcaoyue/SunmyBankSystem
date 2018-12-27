package GUIs;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;

import javax.swing.JOptionPane;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;

import works.Bank;

import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class LoanmoneyGUI {

	private static long nowid;
	public LoanmoneyGUI(long nowid){
		this.nowid = nowid;
	}
	protected Shell LoanmoneyGUI;
	private Text loanmoneyText;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			LoanmoneyGUI window = new LoanmoneyGUI(nowid);
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
		LoanmoneyGUI.open();
		LoanmoneyGUI.layout();
		while (!LoanmoneyGUI.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		LoanmoneyGUI = new Shell();
		LoanmoneyGUI.setSize(450, 300);
		LoanmoneyGUI.setText("SWT Application");
		
		Label lblSunmyBank = new Label(LoanmoneyGUI, SWT.NONE);
		lblSunmyBank.setBounds(166, 10, 95, 20);
		lblSunmyBank.setText("Sunmy Bank");
		
		Label label = new Label(LoanmoneyGUI, SWT.NONE);
		label.setBounds(61, 65, 70, 20);
		label.setText("\u8D37\u6B3E\u91D1\u989D\uFF1A");
		
		loanmoneyText = new Text(LoanmoneyGUI, SWT.BORDER);
		loanmoneyText.setBounds(154, 65, 140, 26);
		
		Button button = new Button(LoanmoneyGUI, SWT.NONE);
		button.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				Bank bank = new Bank();
				//bank.readData();
				try{
					bank.loanmoney(nowid,Double.valueOf(loanmoneyText.getText()));
					bank.deposit(nowid, Double.valueOf(loanmoneyText.getText()));
					MainInterface maininterface = new MainInterface(nowid);
					maininterface.getAcc(nowid);
					Successed succ = new Successed();
					succ.open();
					//bank.upDate();
					maininterface.open();
					LoanmoneyGUI.close();
				}catch(Exception balancenotenoughexp){
					balancenotenoughexp.printStackTrace();
					JOptionPane.showMessageDialog(null, "操作错误", "提示消息", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		button.setBounds(171, 171, 90, 30);
		button.setText("\u786E\u5B9A");
		
		Button button_1 = new Button(LoanmoneyGUI, SWT.NONE);
		button_1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				LoanmoneyGUI.close();
			}
		});
		button_1.setBounds(171, 207, 90, 30);
		button_1.setText("\u9000\u51FA");

	}

}
