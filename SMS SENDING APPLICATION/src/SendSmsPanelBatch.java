

import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.teknikindustries.bulksms.SMS;

public class SendSmsPanelBatch extends JPanel {

	private JLabel msglbl;
	private JLabel recipientlbl;
	private JLabel urllbl;
	private JLabel maxcharslbl;

	public JTextField msgtxfd;
	public JTextArea phonenumtxtArea;
	private JComboBox urlcbo;
	private JComboBox countryCbo;

	private JButton sendbtn;
	private JButton clearbtn;
	private JButton loadbtn;

	public String userName = "";
	public String password = "";

	private JFileChooser filechooser;
	
	public SendSmsPanelBatch() {
		SendSmsPanelLayoutDesign();
	}

	private void SendSmsPanelLayoutDesign() {
		setLayout(new GridBagLayout());

		filechooser = new JFileChooser();
		
		msglbl = new JLabel("Message");
		recipientlbl = new JLabel("Recipients:");
		urllbl = new JLabel("URL");
		maxcharslbl = new JLabel("(maximum: 160 characters)");

		msgtxfd = new JTextField(30);
		phonenumtxtArea = new JTextArea(4, 20);

		urlcbo = new JComboBox();
		DefaultComboBoxModel urlModel = new DefaultComboBoxModel();
		urlModel.addElement("https://bulksms.vsms.net/eapi/submission/send_sms/2/2.0");
		urlcbo.setModel(urlModel);
		urlcbo.setEditable(true);	
			
		String[] countryCode = 	{ "+93", "+355", "+213", "+684", "+376", "+244", "+809", "+268", "+54", "+374", "+297",
				"+247", "+61", "+672", "+43", "+994", "+242", "+246", "+973", "+880", "+375", "+32", "+501", "+229",
				"+809", "+975", "+284", "+591", "+387", "+267", "+55", "+284", "+673", "+359", "+226", "+257", "+855",
				"+237", "+1", "+238", "+345", "+238", "+236", "+235", "+56", "+86", "+886", "+57", "+269", "+242",
				"+682", "+506", "+385", "+53", "+357", "+420", "+45", "+246", "+767", "+809", "+253", "+593", "+20",
				"+503", "+240", "+291", "+372", "+251", "+500", "+298", "+679", "+358", "+33", "+596", "+594", "+241",
				"+220", "+995", "+49", "+233", "+350", "+30", "+299", "+473", "+67", "+502", "+224", "+245", "+592",
				"+509", "+504", "+852", "+36", "+354", "+91", "+62", "+98", "+964", "+353", "+972", "+39", "+225",
				"+876", "+81", "+962", "+7", "+254", "+855", "+686", "+82", "+850", "+965", "+996", "+371", "+856",
				"+961", "+266", " + 231", " + 370", " + 218 ", "+ 423", " + 352", " + 853", " + 389", " + 261",
				" + 265", " + 60 ", "+ 960", " + 223", " + 356", " + 692", " + 596", "+ 222", " + 230", " + 269",
				" + 52", " + 691", " + 373", " + 33", " + 976", " + 473", " + 212", " + 258", " + 95", " + 264",
				" + 674", " + 977", " + 31", "+ 599 ", "+ 869", " + 687", " + 64", " + 505", " + 227", " + 234 ",
				"+ 683 ", "+ 850 ", "+ 1670 ", "+ 47 ", "+ 968 ", "+ 92 ", "+ 680 ", "+ 507 ", "+ 675", "+ 595 ",
				"+ 51 ", "+ 63 ", "+ 48 ", "+ 351 ", "+ 1787 ", "+ 974 ", "+ 262 ", "+ 40 ", "+ 7 ", "+ 250", " + 670",
				" + 378", " + 239", " + 966 ", "+ 221", " + 381", "+ 248", " + 232", " + 65", " + 421", " + 386",
				" + 677", " + 252", " + 27 ", "+ 34", " + 94", " + 290", " + 869", " + 508", " + 249", " + 597",
				" + 268", " + 46", "+ 41", " + 963 ", "+ 689 ", "+ 886", " + 7", " + 255 ", "+ 66", " + 228", " + 690 ",
				"+ 676 ", "+ 1868 ", "+ 216", " + 90 ", "+ 993 ", "+ 688 ", "+ 256", "+ 380 ", "+ 971 ", "+ 44 ",
				"+ 598 ", "+ 1 ", "+ 7 ", "+ 678 ", "+ 39 ", "+ 58 ", "+ 84 ", "+ 1340 ", "+ 681 ", "+ 685 ", "+ 381 ",
				"+ 967 ", "+ 381 ", "+ 243", "+260", "+26" };
		
		countryCbo = new JComboBox(countryCode);
		countryCbo.setEditable(true);
		

		sendbtn = new JButton("Send");
		clearbtn = new JButton("Clear");
		loadbtn = new JButton("Load Contacts");

		JPanel savePanel = new JPanel();
		savePanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
		savePanel.setBorder(BorderFactory.createEtchedBorder());
		savePanel.add(loadbtn);
		savePanel.add(sendbtn);
		savePanel.add(clearbtn);

		// -----------------------------------------------------------------
		JPanel recipientPanel = new JPanel();
		recipientPanel.setLayout(new GridBagLayout());

		GridBagConstraints rgc = new GridBagConstraints();

		rgc.gridx = 0;
		rgc.gridy = 0;
		rgc.ipadx = 12;
		rgc.ipady = 12;
		rgc.insets = new Insets(2, 2, 2, 2);
		rgc.anchor = GridBagConstraints.NORTHWEST;
		recipientPanel.add(countryCbo, rgc);

		rgc.gridx = 1;
		rgc.gridy = 0;
		rgc.anchor = GridBagConstraints.NORTHWEST;
		recipientPanel.add(new JScrollPane(phonenumtxtArea), rgc);

		// -------------------------------------------------------------------

		JPanel allgcPanel = new JPanel();
		allgcPanel.setLayout(new GridBagLayout());
		allgcPanel.setBorder(BorderFactory.createTitledBorder("Send SMS"));

		GridBagConstraints gc = new GridBagConstraints();

		gc.gridx = 0;
		gc.gridy = 0;
		gc.ipadx = 12;
		gc.ipady = 12;
		gc.insets = new Insets(15, 15, 15, 15);
		allgcPanel.add(msglbl, gc);

		gc.gridx = 1;
		gc.gridy = 0;
		allgcPanel.add(msgtxfd, gc);

		gc.gridx = 2;
		gc.gridy = 0;
		allgcPanel.add(maxcharslbl, gc);

		gc.gridx = 0;
		gc.gridy = 1;
		allgcPanel.add(recipientlbl, gc);

		gc.gridx = 1;
		gc.gridy = 1;
		gc.anchor = GridBagConstraints.NORTHWEST;
		allgcPanel.add(recipientPanel, gc);

		gc.gridx = 0;
		gc.gridy = 2;
		allgcPanel.add(urllbl, gc);

		gc.gridx = 1;
		gc.gridy = 2;
		gc.anchor = GridBagConstraints.NORTHWEST;
		allgcPanel.add(urlcbo, gc);

		gc.gridx = 1;
		gc.gridy = 3;
		gc.anchor = GridBagConstraints.NORTHEAST;
		allgcPanel.add(savePanel, gc);

		// -----------------------------------------------------------

		GridBagConstraints gcmain = new GridBagConstraints();

		gcmain.gridx = 0;
		gcmain.gridy = 0;
		add(allgcPanel, gcmain);

		// --------------------SMS CODES----------------------------
		SMS smsSample = new SMS();
		// ---------------------------------------------------------

		sendbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String message = msgtxfd.getText();

				String url = (String) urlcbo.getSelectedItem();

				String phonenumcode = (String) countryCbo.getSelectedItem();

				String phonenum = phonenumtxtArea.getText();

				List<String> tokens = Tokenizer.wordsToList(phonenum);

				List<String> totalcount = new ArrayList<String>();
				for (String token : tokens)
					totalcount.add(phonenumcode + token);

				System.out.println(totalcount.toString());

				smsSample.SendSMS(userName, password, message, totalcount.toString(), url);
			}
		});

		clearbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				msgtxfd.setText("");
				phonenumtxtArea.setText("");
			}
		});
		
		loadbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FileFilter ffilter_one = new FileNameExtensionFilter("Text Files", "txt");
				FileFilter ffilter_two = new FileNameExtensionFilter("XML Files", "xml");

				filechooser.addChoosableFileFilter(ffilter_one);
				filechooser.addChoosableFileFilter(ffilter_two);

				int returnValue = filechooser.showOpenDialog(SendSmsPanelBatch.this);

				if (returnValue == javax.swing.JFileChooser.APPROVE_OPTION) {
					java.io.File file = filechooser.getSelectedFile();

					String file_name = file.toString();

					try {
						ReadFile file_to_read = new ReadFile(file_name);

						String[] txtfileLength = file_to_read.openFile();

						int i;
						String theText = "";
						for (i = 0; i < txtfileLength.length; i++) {
							theText = theText + txtfileLength[i] + "/" + "\n";
						}
						phonenumtxtArea.setText(theText);
					} catch (Exception e1) {

					}
					JOptionPane.showMessageDialog(SendSmsPanelBatch.this, "Contacts List Loaded Successfully!");
				}
			}
		});

	}
}
