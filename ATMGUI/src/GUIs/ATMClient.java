package GUIs;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
public class ATMClient {

	protected Shell FirstGUI;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {    //connect to mysql
		try {
			ATMClient window = new ATMClient();
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
		FirstGUI.open();
		FirstGUI.layout();
		while (!FirstGUI.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		FirstGUI = new Shell();
		FirstGUI.setSize(450, 300);
		FirstGUI.setText("SWT Application");
		
		Label lblSunmyBank = new Label(FirstGUI, SWT.NONE);
		lblSunmyBank.setBounds(160, 10, 90, 20);
		lblSunmyBank.setText("Sunmy Bank");
		
		Button loginbtn = new Button(FirstGUI, SWT.NONE);
		loginbtn.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				try{
					//bank.readData();
					//bank.upDate();
					FirstGUI.close();
					LoginGUI login = new LoginGUI();
					login.open();
				}
				catch(Exception filenotfound){
					System.out.println("文件没找到");
					filenotfound.printStackTrace();
				}
				
			}
		});
		loginbtn.setBounds(160, 84, 90, 30);
		loginbtn.setText("\u767B\u9646");
		
		Button registerbtn = new Button(FirstGUI, SWT.NONE);
		registerbtn.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				try{
					FirstGUI.close();
					RegisterGUI register = new RegisterGUI();
					register.open();
				}catch(Exception filenotfound){
					System.out.println("文件没找到");
					filenotfound.printStackTrace();
				}
				
			}
		});
		registerbtn.setBounds(160, 141, 90, 30);
		registerbtn.setText("\u6CE8\u518C");
		
		Button quitbtn = new Button(FirstGUI, SWT.NONE);
		quitbtn.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				//Bank bank = new Bank();
				//bank.upDate();
				FirstGUI.close();
			}
		});
		quitbtn.setBounds(160, 200, 90, 30);
		quitbtn.setText("\u9000\u51FA");
		
		Label lblWelcome = new Label(FirstGUI, SWT.NONE);
		lblWelcome.setBounds(168, 47, 70, 20);
		lblWelcome.setText("welcome!");

	}
}
