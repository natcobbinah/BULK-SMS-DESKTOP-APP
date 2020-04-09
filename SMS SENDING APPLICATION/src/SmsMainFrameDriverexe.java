import javax.swing.SwingUtilities;

public class SmsMainFrameDriverexe {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new SmsMainFrame();
			}
		});
	}

}
