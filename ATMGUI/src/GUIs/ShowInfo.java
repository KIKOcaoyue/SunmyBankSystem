package GUIs;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class ShowInfo {
	
	static long nowid;
	public static String nametext;
	public static double balancetext;
	public static String acctype;
	public ShowInfo(long id,String name,double balances,String acc){
		nowid = id;
		acctype = acc;
		balancetext = balances;
		nametext = name;
	}
	
	protected Shell ShowInfo;
	private Text idtext;
	private Text nameText;
	private Text acctypeText;
	private Text balanceText;
	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			ShowInfo window = new ShowInfo(nowid,nametext,balancetext,acctype);
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
		ShowInfo.open();
		ShowInfo.layout();
		while (!ShowInfo.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		ShowInfo = new Shell();
		ShowInfo.setSize(450, 300);
		ShowInfo.setText("SWT Application");
		
		Label lblSunmyBank = new Label(ShowInfo, SWT.NONE);
		lblSunmyBank.setBounds(158, 10, 95, 20);
		lblSunmyBank.setText("Sunmy Bank");
		
		Label label = new Label(ShowInfo, SWT.NONE);
		label.setBounds(42, 41, 53, 20);
		label.setText("\u8D26\u53F7\uFF1A");
		
		idtext = new Text(ShowInfo, SWT.BORDER);
		idtext.setBounds(108, 38, 201, 26);
		idtext.setText(String.valueOf(nowid));
		
		Label label_2 = new Label(ShowInfo, SWT.NONE);
		label_2.setText("\u59D3\u540D\uFF1A");
		label_2.setBounds(42, 84, 48, 20);
		
		nameText = new Text(ShowInfo, SWT.BORDER);
		nameText.setBounds(108, 81, 201, 26);
		nameText.setText(nametext);
		
		Label label_3 = new Label(ShowInfo, SWT.NONE);
		label_3.setText("\u8D26\u6237\u7C7B\u578B\uFF1A");
		label_3.setBounds(28, 127, 70, 20);
		
		acctypeText = new Text(ShowInfo, SWT.BORDER);
		acctypeText.setBounds(108, 127, 201, 26);
		acctypeText.setText(acctype);
		
		Label label_4 = new Label(ShowInfo, SWT.NONE);
		label_4.setText("\u4F59\u989D\uFF1A");
		label_4.setBounds(42, 171, 48, 20);
		
		balanceText = new Text(ShowInfo, SWT.BORDER);
		balanceText.setBounds(108, 168, 201, 26);
		balanceText.setText(String.valueOf(balancetext));
		
		Button button = new Button(ShowInfo, SWT.NONE);
		button.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				ShowInfo.close();
			}
		});
		button.setBounds(158, 200, 90, 30);
		button.setText("\u786E\u5B9A");

	}

}
