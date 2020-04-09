

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SmsMessagePanel extends JPanel {

	private JLabel eventnamelbl;
	private JTextField eventxtfd;

	public SmsMessagePanel() {
		smsMessageLayoutDesign();
	}

	private void smsMessageLayoutDesign() {

		setLayout(new BorderLayout());

		eventnamelbl = new JLabel("");
		eventnamelbl.setVisible(false);

		eventxtfd = new JTextField(15);
		eventxtfd.setText("MESSAGES");
		eventxtfd.setEditable(false);

		JPanel eventPanel = new JPanel();
		eventPanel.setLayout(new GridBagLayout());
		eventPanel.setBorder(BorderFactory.createEtchedBorder());
		eventPanel.setBackground(Color.decode("#DCDCDC"));

		GridBagConstraints gc = new GridBagConstraints();

		gc.gridx = 0;
		gc.gridy = 0;
		gc.ipadx = 15;
		gc.ipady = 15;
		gc.insets = new Insets(2, 2, 2, 2);
		gc.anchor = GridBagConstraints.NORTHWEST;
		eventPanel.add(eventnamelbl, gc);

		gc.gridx = 1;
		gc.gridy = 0;
		gc.ipadx = 15;
		gc.ipady = 15;
		gc.insets = new Insets(10, 10, 10, 10);
		gc.anchor = GridBagConstraints.NORTHWEST;
		eventPanel.add(eventxtfd, gc);

		add(eventPanel, BorderLayout.WEST);
	}
}
