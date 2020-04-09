

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class PreferencesFormSms extends JDialog {
	
	private JLabel bulkSmsImage;

	private JButton okButton;
	private JButton cancelButton;
	public JTextField userField;
	public JPasswordField passField;

	private PrefsmsListener prefsmslistener;

	public PreferencesFormSms(JFrame parent) {
		super(parent, "Sms Configuration", false);

		okButton = new JButton("OK");
		cancelButton = new JButton("Cancel");

		userField = new JTextField(20);
		passField = new JPasswordField(20);
		passField.setEchoChar('*');

		smsdialogLayoutDesign();

		okButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String user = userField.getText();

				char[] password = passField.getPassword();

				setVisible(false);

				if (prefsmslistener != null) {
					prefsmslistener.preferenceSet(user, new String(password));
				}
			}
		});

		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});

		setSize(500, 300);
		setLocationRelativeTo(parent);

	}

	private void smsdialogLayoutDesign() {

		JPanel controlspanel = new JPanel();
		JPanel buttonspanel = new JPanel();

		setLayout(new BorderLayout());

		controlspanel.setLayout(new GridBagLayout());
		buttonspanel.setLayout(new FlowLayout(FlowLayout.RIGHT));

		Border spaceBorder = BorderFactory.createEmptyBorder(5, 5, 5, 5);
		Border titledBorder = BorderFactory.createTitledBorder("Sms Configuration");

		Border compoundBorder = BorderFactory.createCompoundBorder(spaceBorder, titledBorder);
		controlspanel.setBorder(compoundBorder);

		GridBagConstraints gc = new GridBagConstraints();
		
		bulkSmsImage = new JLabel(Utilities.createIcon("/Images/bulksms2.PNG"));
		//////////////////////////////////////////////
		gc.gridx = 0;
		gc.gridy = 0;
		gc.weightx = 0;
		gc.weighty = 0;
		gc.gridwidth = 2;
		gc.fill = GridBagConstraints.NONE;
		gc.anchor = GridBagConstraints.NORTHWEST;
		controlspanel.add(bulkSmsImage, gc);
		
		gc.gridx = 0;
		gc.gridy = 1;
		gc.weightx = 0;
		gc.weighty = 0;
		gc.ipadx = 10;
		gc.ipady = 10;
		gc.gridwidth = 1;
		gc.insets = new Insets(4,4,4,4);
		gc.fill = GridBagConstraints.NONE;
		gc.anchor = GridBagConstraints.NORTHWEST;
		controlspanel.add(new JLabel("UserName: "), gc);

		gc.gridx = 1;
		gc.gridy = 1;
		gc.weightx = 0;
		gc.weighty = 0;
		gc.gridwidth = 1;
		gc.fill = GridBagConstraints.NONE;
		gc.anchor = GridBagConstraints.NORTHWEST;
		controlspanel.add(userField, gc);

		gc.gridx = 0;
		gc.gridy = 2;
		gc.weightx = 0;
		gc.weighty = 0;
		gc.gridwidth = 1;
		gc.fill = GridBagConstraints.NONE;
		gc.anchor = GridBagConstraints.NORTHWEST;
		controlspanel.add(new JLabel("Password: "), gc);

		gc.gridx = 1;
		gc.gridy = 2;
		gc.weightx = 0;
		gc.weighty = 0;
		gc.gridwidth = 1;
		gc.fill = GridBagConstraints.NONE;
		gc.anchor = GridBagConstraints.NORTHWEST;
		controlspanel.add(passField, gc);

		///////// -----------Next Row----------------///////////

		buttonspanel.add(okButton);
		buttonspanel.add(cancelButton);

		Dimension dim = cancelButton.getPreferredSize();
		okButton.setPreferredSize(dim);

		add(controlspanel, BorderLayout.CENTER);
		add(buttonspanel, BorderLayout.SOUTH);
	}

	public void setDefaults(String user, String password) {
		userField.setText(user);
		passField.setText(password);
	}

	public void setPrefsmsListener(PrefsmsListener prefsmsListener) {
		this.prefsmslistener = prefsmsListener;
	}
}
