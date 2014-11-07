package multiPane02;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JToolBar;
import javax.swing.ListModel;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;

public class InitGUI extends JFrame {

	private JPanel contentPane;
	private Component frame;
	private String hierbaDir = "Images/hierba-footer.png";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InitGUI frame = new InitGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	{
		for (LookAndFeelInfo info : javax.swing.UIManager
				.getInstalledLookAndFeels()) {
			try {
				javax.swing.UIManager
						.setLookAndFeel("com.sun.java.swing.plaf.gtk.GTKLookAndFeel");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * Create the frame.
	 */
	public InitGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 390, 400);
		setTitle("Garden care");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(4, 1, 0, 0));

		JToolBar toolBar = new JToolBar();
		toolBar.setAlignmentX(Component.LEFT_ALIGNMENT);
		toolBar.setAlignmentY(Component.CENTER_ALIGNMENT);
		toolBar.setToolTipText("Choose weather conditions");
		toolBar.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		contentPane.add(toolBar);

		JLabel lblNewLabel_2 = new JLabel("Perfect sun");
		lblNewLabel_2.setIconTextGap(3);
		lblNewLabel_2.setCursor(Cursor
				.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		lblNewLabel_2.setIcon(new ImageIcon(InitGUI.class
				.getResource("/Images/Sunshine@Low.png")));
		toolBar.add(lblNewLabel_2);
		// toolBar.add(new JSeparator (SwingConstants.VERTICAL));
		toolBar.addSeparator();

		JLabel lblNewLabel = new JLabel("Cloudy");
		lblNewLabel.setIconTextGap(3);
		lblNewLabel.setIcon(new ImageIcon(InitGUI.class
				.getResource("/Images/Cloudy@Low.png")));
		toolBar.add(lblNewLabel);
		// toolBar.add(new JSeparator (SwingConstants.VERTICAL));
		toolBar.addSeparator();

		JLabel lblNewLabel_1 = new JLabel("Rains");
		lblNewLabel_1.setIconTextGap(3);
		lblNewLabel_1.setIcon(new ImageIcon(InitGUI.class
				.getResource("/Images/Cloud-Download@Low.png")));
		toolBar.add(lblNewLabel_1);
		toolBar.addSeparator();

		JLabel lblNewLabel_3 = new JLabel("Windy");
		lblNewLabel_3.setIcon(new ImageIcon(InitGUI.class
				.getResource("/Images/Refresh@Low.png")));
		toolBar.add(lblNewLabel_3);

		JPanel panel_2 = new JPanel();
		contentPane.add(panel_2);
		panel_2.setLayout(new BoxLayout(panel_2, BoxLayout.X_AXIS));

		JPanel panel_3 = new JPanel();
		panel_2.add(panel_3);
		panel_3.setLayout(new GridLayout(1, 0, 0, 0));

		/**
		 * Defining JList and its model for supplying content
		 */
		
		ListModel jList1Model = new DefaultComboBoxModel(new String[] {
				"Water", "Petrol", "Milk" });
		JList list = new JList();
		panel_3.add(list);
		list.setFont(new Font("Courier New", Font.PLAIN, 14));
		list.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null,
				null));
		list.setBackground(new Color(238, 238, 238));
		list.setModel(jList1Model);

		/**
		 * customized square button
		 */

		JButton btnOpenDialog = new JButton("");
		btnOpenDialog.setToolTipText("Go?");
		btnOpenDialog.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnOpenDialog.setIcon(new ImageIcon(InitGUI.class
				.getResource("/Images/Water-Drop.png")));
		btnOpenDialog.setMnemonic('W');
		btnOpenDialog.setMargin(new Insets(0, 0, 0, 0));
		panel_2.add(btnOpenDialog);

		/**
		 * shows an optiopane with a dialog asking for confirmation
		 */
		btnOpenDialog.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Dialoging
				String message = "Are you 100% sure?";
				int answer = JOptionPane.showConfirmDialog(frame, message);
				if (answer == JOptionPane.YES_OPTION) {
					// User clicked YES.
				} else if (answer == JOptionPane.NO_OPTION) {
					// User clicked NO.
				}
			}
		});

		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1);
		panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.X_AXIS));

		JSlider slider = new JSlider();
		slider.setValue(25);
		panel_1.add(slider);

		/**
		 * calls our drawing panel
		 */
		JPanel panel = new ImgPanel(hierbaDir);
		contentPane.add(panel);
	}
}
