package GUIs;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;

import java.sql.SQLException;

import javax.swing.JOptionPane;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;

import works.Bank;

import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class PayloanGUI {

	static long nowid;
	private static double loanmoney;
	public PayloanGUI(long id){
		nowid = id;
	}
	public void getAcc(long id){
		try {
			loanmoney = Bank.mysql.queryloanmoney(nowid);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	protected Shell PayloanGUI;
	private Text payloanmoneyText;
	private Text nowloanText;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			PayloanGUI window = new PayloanGUI(nowid);
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
		PayloanGUI.open();
		PayloanGUI.layout();
		while (!PayloanGUI.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		
		
		PayloanGUI = new Shell();
		PayloanGUI.setSize(450, 300);
		PayloanGUI.setText("SWT Application");
		
		Label lblSunmyBank = new Label(PayloanGUI, SWT.NONE);
		lblSunmyBank.setBounds(152, 10, 94, 20);
		lblSunmyBank.setText("Sunmy Bank");
		
		Label label = new Label(PayloanGUI, SWT.NONE);
		label.setBounds(39, 95, 94, 20);
		label.setText("\u8FD8\u8D37\u6B3E\u91D1\u989D\uFF1A");
		
		payloanmoneyText = new Text(PayloanGUI, SWT.BORDER);
		payloanmoneyText.setBounds(144, 92, 151, 26);
		
		Button button = new Button(PayloanGUI, SWT.NONE);
		button.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				Bank bank = new Bank();
				//bank.readData();
				try{
					bank.withdraw(nowid, Double.valueOf(payloanmoneyText.getText()));
					bank.payloan(nowid, Double.valueOf(payloanmoneyText.getText()));
					//bank.upDate();
					JOptionPane.showMessageDialog(null, "还款成功", "提示消息", JOptionPane.ERROR_MESSAGE);
					PayloanGUI.close();
				}catch(Exception e1){
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null, "操作错误", "提示消息", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		button.setBounds(152, 155, 90, 30);
		button.setText("\u8FD8\u6B3E");
		
		Button button_1 = new Button(PayloanGUI, SWT.NONE);
		button_1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				PayloanGUI.close();
			}
		});
		button_1.setBounds(152, 201, 90, 30);
		button_1.setText("\u9000\u51FA");
		
		Label label_1 = new Label(PayloanGUI, SWT.NONE);
		label_1.setBounds(39, 47, 94, 20);
		label_1.setText("\u5DF2\u8D37\u6B3E\u91D1\u989D\uFF1A");
		
		nowloanText = new Text(PayloanGUI, SWT.BORDER);
		nowloanText.setBounds(144, 41, 151, 26);
		nowloanText.setText(String.valueOf(loanmoney));

	}

}
