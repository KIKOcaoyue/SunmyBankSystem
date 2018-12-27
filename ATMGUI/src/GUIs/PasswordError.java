package GUIs;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class PasswordError {

	protected Shell PasswordError;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			PasswordError window = new PasswordError();
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
		PasswordError.open();
		PasswordError.layout();
		while (!PasswordError.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		PasswordError = new Shell();
		PasswordError.setSize(450, 300);
		PasswordError.setText("SWT Application");
		
		Label lblSunmyBack = new Label(PasswordError, SWT.NONE);
		lblSunmyBack.setBounds(177, 10, 92, 20);
		lblSunmyBack.setText("Sunmy Back");
		
		Label label = new Label(PasswordError, SWT.NONE);
		label.setBounds(147, 107, 134, 20);
		label.setText("\u5BC6\u7801\u9519\u8BEF\uFF0C\u8BF7\u91CD\u8BD5\uFF01");
		
		Button button = new Button(PasswordError, SWT.NONE);
		button.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				PasswordError.close();
			}
		});
		button.setBounds(166, 157, 90, 30);
		button.setText("\u786E\u5B9A");

	}

}
