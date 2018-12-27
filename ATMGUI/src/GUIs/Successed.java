package GUIs;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class Successed {

	protected Shell SuccessedGUI;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Successed window = new Successed();
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
		SuccessedGUI.open();
		SuccessedGUI.layout();
		while (!SuccessedGUI.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		SuccessedGUI = new Shell();
		SuccessedGUI.setSize(450, 300);
		SuccessedGUI.setText("SWT Application");
		
		Label lblSunmyBank = new Label(SuccessedGUI, SWT.NONE);
		lblSunmyBank.setBounds(161, 10, 100, 20);
		lblSunmyBank.setText("Sunmy Bank");
		
		Label label = new Label(SuccessedGUI, SWT.NONE);
		label.setBounds(168, 90, 70, 20);
		label.setText("\u64CD\u4F5C\u6210\u529F");
		
		Button button = new Button(SuccessedGUI, SWT.NONE);
		button.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				SuccessedGUI.close();
			}
		});
		button.setBounds(161, 162, 90, 30);
		button.setText("\u786E\u5B9A");

	}

}
