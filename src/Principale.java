import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.BoxLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.ButtonGroup;

public class Principale extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField txt1;
	private JTextField txt2;
	private JTextField txtres;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JLabel lblop;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principale frame = new Principale();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Principale() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 424, 246);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		JPanel panel_2 = new JPanel();
		contentPane.add(panel_2, BorderLayout.SOUTH);

		JButton btnNewButton = new JButton("Remise a blanc");
		panel_2.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Quitter");
		panel_2.add(btnNewButton_1);

		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setBounds(10, 11, 243, 147);
		panel.add(panel_1);
		panel_1.setLayout(null);

		JLabel lblNewLabel = new JLabel("Nombre 1 :");
		lblNewLabel.setBounds(10, 11, 68, 14);
		panel_1.add(lblNewLabel);

		txt1 = new JTextField();
		txt1.setBounds(88, 8, 145, 20);
		txt1.setDocument(new DoubleValidate());
		panel_1.add(txt1);
		txt1.setColumns(10);

		txt2 = new JTextField();
		txt2.setColumns(10);
		txt2.setDocument(new DoubleValidate());
		txt2.setBounds(88, 82, 145, 20);
		panel_1.add(txt2);

		JLabel lblNombre = new JLabel("Nombre 2 :");
		lblNombre.setBounds(10, 85, 68, 14);
		panel_1.add(lblNombre);

		txtres = new JTextField();
		txtres.setEditable(false);
		txtres.setColumns(10);
		txtres.setBounds(88, 113, 145, 20);
		panel_1.add(txtres);

		JLabel lblNewLabel_1_1 = new JLabel("Resultat :");
		lblNewLabel_1_1.setBounds(10, 116, 68, 14);
		panel_1.add(lblNewLabel_1_1);

		lblop = new JLabel("");
		lblop.setBorder(new LineBorder(new Color(0, 128, 0)));
		lblop.setHorizontalAlignment(SwingConstants.CENTER);
		lblop.setBounds(127, 52, 46, 14);
		panel_1.add(lblop);

		JPanel panel_1_1 = new JPanel();
		panel_1_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		FlowLayout flowLayout = (FlowLayout) panel_1_1.getLayout();
		flowLayout.setAlignment(FlowLayout.LEADING);
		panel_1_1.setBounds(263, 11, 125, 147);
		panel.add(panel_1_1);

		JRadioButton rd1 = new JRadioButton("Addition");
		rd1.addActionListener(this);
		buttonGroup.add(rd1);
		panel_1_1.add(rd1);

		JRadioButton rd2 = new JRadioButton("Soustraction");
		buttonGroup.add(rd2);
		rd2.addActionListener(this);
		panel_1_1.add(rd2);

		JRadioButton rd3 = new JRadioButton("Produit");
		buttonGroup.add(rd3);
		rd3.addActionListener(this);
		panel_1_1.add(rd3);

		JRadioButton rd4 = new JRadioButton("Division");
		buttonGroup.add(rd4);
		rd4.addActionListener(this);
		panel_1_1.add(rd4);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JRadioButton rd = (JRadioButton) e.getSource();

		double nombre1 = Double.parseDouble(txt1.getText().isEmpty() ? "0":txt1.getText());
		double nombre2 = Double.parseDouble(txt2.getText().isEmpty() ? "0":txt2.getText());
		double res = 0;

		switch (rd.getText().toLowerCase()) {
		case "addition":
			res = nombre1 + nombre2;
			lblop.setText("+");
			break;
		case "soustraction":
			res = nombre1 - nombre2;
			lblop.setText("-");
			break;
		case "produit":
			res = nombre1 * nombre2;
			lblop.setText("*");
			break;
		case "division":
			res = nombre1 / nombre2;
			lblop.setText("/");
			break;
		}

		txtres.setText(String.format("%.2f", res));

	}
}
