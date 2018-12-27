package GUIs;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class BalanceError {

	protected Shell BalanceError;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			BalanceError window = new BalanceError();
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
		BalanceError.open();
		BalanceError.layout();
		while (!BalanceError.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		BalanceError = new Shell();
		BalanceError.setSize(450, 300);
		BalanceError.setText("SWT Application");
		
		Label lblSunmyBank = new Label(BalanceError, SWT.NONE);
		lblSunmyBank.setBounds(169, 10, 95, 20);
		lblSunmyBank.setText("Sunmy Bank");
		
		Button button = new Button(BalanceError, SWT.NONE);
		button.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				BalanceError.close();
			}
		});
		button.setBounds(169, 147, 90, 30);
		button.setText("\u786E\u5B9A");
		
		Label label = new Label(BalanceError, SWT.NONE);
		label.setBounds(132, 79, 160, 20);
		label.setText("\u62B1\u6B49\uFF0C\u60A8\u7684\u64CD\u4F5C\u6709\u8BEF");

	}

}
