import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.prefs.Preferences;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTabbedPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import de.javasoft.plaf.synthetica.SyntheticaBlackStarLookAndFeel;

public class SmsMainFrame extends JFrame {

	private SendSmsPanel singlesmsPanel;
	private SendSmsPanelBatch batchsmsPanel;
	private PreferencesFormSms prefsmsPanel;
	private Preferences prefsms;
	private About about;
	private Manual manual;

	private JLabel side_imageLabel;


	public SmsMainFrame() {

		setTitle("TANK SMS APP");

		try {
			UIManager.setLookAndFeel(new SyntheticaBlackStarLookAndFeel());
		} catch (UnsupportedLookAndFeelException | ParseException e) {
			// TODO Auto-generated catch block
		}

		smslayoutdesign();

		setJMenuBar(createJMenuBar());

		setResizable(false);
		setSize(900, 600);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	private void smslayoutdesign() {

		setLayout(new BorderLayout());

		singlesmsPanel = new SendSmsPanel();
		batchsmsPanel = new SendSmsPanelBatch();
		prefsmsPanel = new PreferencesFormSms(SmsMainFrame.this);

		// ------------------------------------------------------------------------
		prefsms = Preferences.userRoot().node("sms");
		prefsmsPanel.setPrefsmsListener(new PrefsmsListener() {
			public void preferenceSet(String user, String password) {
				prefsms.put("user", user);
				prefsms.put("password", password);
			}
		});

		String smsUser = prefsms.get("user", prefsmsPanel.userField.getText());
		String smsPassword = prefsms.get("password", prefsmsPanel.passField.getText());
		prefsmsPanel.setDefaults(smsUser, smsPassword);

		// sets the bulk sms username and password to the smspage and batch sms page
		singlesmsPanel.userName = smsUser;
		singlesmsPanel.password = smsPassword;
		batchsmsPanel.userName = smsUser;
		batchsmsPanel.password = smsPassword;

		// ------------------------------------------------------------------------

		JTabbedPane messageTab = new JTabbedPane();
		messageTab.addTab("Send Messages(Single)", singlesmsPanel);
		messageTab.addTab("Send Messages(Multiple)", batchsmsPanel);

		side_imageLabel = new JLabel(Utilities.createIcon("/Images/tpat4.jpg"));

		add(side_imageLabel, BorderLayout.WEST);
		add(messageTab, BorderLayout.CENTER);
	}

	private JMenuBar createJMenuBar() {

		JMenuBar menuBar = new JMenuBar();

		JMenu helpMenu = new JMenu("Help");
		JMenuItem aboutMenuItem = new JMenuItem("About");
		JMenuItem manualMenuItem = new JMenuItem("Manual");
		helpMenu.add(aboutMenuItem);
		helpMenu.add(manualMenuItem);

		JMenu settingsMenu = new JMenu("Configurations");
		JMenuItem smsMenuItem = new JMenuItem("BulkSms Settings");
		settingsMenu.add(smsMenuItem);

		smsMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				prefsmsPanel.setVisible(true);
			}
		});

		aboutMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new About();
			}
		});

		manualMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Manual();
			}
		});

		menuBar.add(settingsMenu);
		menuBar.add(helpMenu);

		return menuBar;

	}

}
