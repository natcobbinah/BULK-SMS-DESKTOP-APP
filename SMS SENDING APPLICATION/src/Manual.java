import javax.swing.JOptionPane;

public class Manual extends JOptionPane {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Manual() {
		String manual = "In using this application" + "\n" + "(1) Register with BulkSms via (http://bulksms.com)" + "\n"
				+ "(2) Take note of your (username) and (password)" + "\n"
				+ "(3) You are initially given 10 free sms trials or else " + "\n"
				+ "You  purchase any (sms) bundle you prefer via credit card" + "\n" + "or option available."
				+ "\n" + "In this application (click on configurations menu)" + "\n"
				+ "Select (BulkSms Settings) and enter (username) and (password) as created above" + "\n"
				+ "Now send message either (individually) or (in group) by selecting the tabs" + "\n\n"
				+ "With (group or multiple messaging), you can load from a text file of numbers" + "\n"
				+ "or to type it manually, separate each number by a forward slash " + "\n"
				+ "eg: 3356456564/ 24354534534 / 3254352453";
		JOptionPane.showMessageDialog(Manual.this, manual);

	}

}
