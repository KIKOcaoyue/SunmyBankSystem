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

public class TransferGUI {

	private static long nowid;
	
	public TransferGUI(long nowid){
		this.nowid = nowid;
	}
	protected Shell TransferGUI;
	private Text transferText;
	private Text transfermoney;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			TransferGUI window = new TransferGUI(nowid);
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
		TransferGUI.open();
		TransferGUI.layout();
		while (!TransferGUI.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		TransferGUI = new Shell();
		TransferGUI.setSize(450, 300);
		TransferGUI.setText("SWT Application");
		
		Label lblSunmyBank = new Label(TransferGUI, SWT.NONE);
		lblSunmyBank.setBounds(169, 10, 88, 20);
		lblSunmyBank.setText("Sunmy Bank");
		
		Label label = new Label(TransferGUI, SWT.NONE);
		label.setBounds(40, 55, 70, 20);
		label.setText("\u6536\u6B3E\u8D26\u53F7\uFF1A");
		
		transferText = new Text(TransferGUI, SWT.BORDER);
		transferText.setBounds(132, 52, 174, 26);
		
		Button button = new Button(TransferGUI, SWT.NONE);
		button.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				Bank bank = new Bank();
				//bank.readData();
				try{
					bank.transfer(nowid, Long.valueOf(transferText.getText()), Double.valueOf(transfermoney.getText()));
					MainInterface maininterface = new MainInterface(nowid);
					maininterface.getAcc(nowid);
					Successed succ = new Successed();
					succ.open();
					//bank.upDate();
					maininterface.open();
					TransferGUI.close();
				}catch(Exception balancenotenoughexp){
					balancenotenoughexp.printStackTrace();
					
				}
			}
		});
		button.setBounds(169, 172, 90, 30);
		button.setText("\u786E\u5B9A");
		
		Label label_1 = new Label(TransferGUI, SWT.NONE);
		label_1.setBounds(40, 108, 70, 20);
		label_1.setText("\u8F6C\u8D26\u91D1\u989D\uFF1A");
		
		transfermoney = new Text(TransferGUI, SWT.BORDER);
		transfermoney.setBounds(132, 108, 174, 26);
		
		Button btnNewButton = new Button(TransferGUI, SWT.NONE);
		btnNewButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				TransferGUI.close();
			}
		});
		btnNewButton.setBounds(169, 208, 90, 30);
		btnNewButton.setText("\u9000\u51FA");

	}
}
