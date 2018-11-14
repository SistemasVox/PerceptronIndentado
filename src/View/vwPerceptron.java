package View;

import java.awt.Component;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import Model.Linha;
import Model.Perceptron;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Toolkit;

public class vwPerceptron extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table = new JTable();
	private JTextField txtAlfa;
	private JTextField txtTeta;
	private JScrollPane scrollPane = new JScrollPane();
	private static DefaultTableModel model;
	private JTextField txtW1;
	private JTextField txtW2;
	private JTextField txtW3;
	private JTextField txtB;
	int cont = 0;
	static vwPerceptron vwPer = new vwPerceptron();

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					vwPer.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public vwPerceptron() {
		
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\workspace\\Perceptron\\img\\a.png"));
		setTitle("A.I. - Intelig\u00EAncia Artificial Perceptron");
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 742, 477);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		scrollPane.setBounds(10, 97, 706, 331);
		contentPane.add(scrollPane);
		
		table.setToolTipText("Tabela de \u00C9pocas");
		table.setColumnSelectionAllowed(true);
		table.setCellSelectionEnabled(true);
		table.setSurrendersFocusOnKeystroke(true);
		table.setFont(new Font("Tahoma", Font.PLAIN, 13));
		scrollPane.setViewportView(table);
		scrollPane.setVisible(false);
		
		JLabel lblSistemasVox = new JLabel("Sistema VOX");
		lblSistemasVox.setToolTipText("Ver mais informa\u00E7\u00F5es do Software");
		lblSistemasVox.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				vwAbout ab = new vwAbout();
				ab.setVisible(true);
			}
		});
		lblSistemasVox
				.setFont(new Font("Vivaldi", Font.BOLD | Font.ITALIC, 39));
		lblSistemasVox.setHorizontalAlignment(SwingConstants.CENTER);
		lblSistemasVox.setBounds(282, 0, 338, 98);
		contentPane.add(lblSistemasVox);
		
		JLabel lblTeta = new JLabel("\u03B8 =");
		lblTeta.setToolTipText("Valor de Teta: θήτα, thḗta. [Limiar]");
		lblTeta.setEnabled(false);
		lblTeta.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTeta.setBounds(10, 64, 38, 22);
		contentPane.add(lblTeta);
		JLabel lblAlfa = new JLabel("~ =");
		lblAlfa.setToolTipText("Valor de Alfa άλφα");
		lblAlfa.setEnabled(false);
		lblAlfa.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblAlfa.setBounds(10, 42, 38, 22);
		contentPane.add(lblAlfa);
		txtAlfa = new JTextField();
		txtAlfa.setToolTipText("Valor de Alfa άλφα");
		txtAlfa.setText("1");
		txtAlfa.setHorizontalAlignment(SwingConstants.CENTER);
		txtAlfa.setFont(new Font("Tahoma", Font.BOLD, 13));
		txtAlfa.setBounds(43, 45, 38, 20);
		contentPane.add(txtAlfa);
		txtAlfa.setColumns(10);
		txtTeta = new JTextField();
		txtTeta.setToolTipText("Valor de Teta: θήτα, thḗta. [Limiar]");
		txtTeta.setText("0.2");
		txtTeta.setHorizontalAlignment(SwingConstants.CENTER);
		txtTeta.setFont(new Font("Tahoma", Font.BOLD, 13));
		txtTeta.setColumns(10);
		txtTeta.setBounds(43, 66, 38, 20);
		contentPane.add(txtTeta);
		JButton btnCalcular = new JButton("Calcular");
		btnCalcular.setToolTipText("Calcular épocas.");
		btnCalcular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (cont > 0) {
					restart_Perceptron();
				} else {
					populaTabela();
					cont++;
					scrollPane.setVisible(true);
					txtAlfa.setEditable(false);
					txtTeta.setEditable(false);
					btnCalcular.setText("Reiniciar");
					btnCalcular.setToolTipText("Reiniciar Perceptron?");
				}
			}
		});
		btnCalcular.setBounds(627, 66, 89, 23);
		contentPane.add(btnCalcular);
		JLabel lblW_1 = new JLabel("W\u00B9 = ");
		lblW_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblW_1.setEnabled(false);
		lblW_1.setBounds(91, 42, 49, 22);
		contentPane.add(lblW_1);
		txtW1 = new JTextField();
		txtW1.setToolTipText("Valor de Peso 1");
		txtW1.setText("?");
		txtW1.setHorizontalAlignment(SwingConstants.CENTER);
		txtW1.setFont(new Font("Tahoma", Font.BOLD, 13));
		txtW1.setEditable(false);
		txtW1.setColumns(10);
		txtW1.setBounds(138, 42, 38, 20);
		contentPane.add(txtW1);
		JLabel lblW_2 = new JLabel("W\u00B2 =");
		lblW_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblW_2.setEnabled(false);
		lblW_2.setBounds(91, 64, 49, 22);
		contentPane.add(lblW_2);
		txtW2 = new JTextField();
		txtW2.setToolTipText("Peso 2");
		txtW2.setText("?");
		txtW2.setHorizontalAlignment(SwingConstants.CENTER);
		txtW2.setFont(new Font("Tahoma", Font.BOLD, 13));
		txtW2.setEditable(false);
		txtW2.setColumns(10);
		txtW2.setBounds(138, 63, 38, 20);
		contentPane.add(txtW2);
		JLabel lblW_3 = new JLabel("W\u00B3 =");
		lblW_3.setHorizontalAlignment(SwingConstants.LEFT);
		lblW_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblW_3.setEnabled(false);
		lblW_3.setBounds(186, 42, 49, 22);
		contentPane.add(lblW_3);
		txtW3 = new JTextField();
		txtW3.setToolTipText("Valor de Peso 3");
		txtW3.setText("?");
		txtW3.setHorizontalAlignment(SwingConstants.CENTER);
		txtW3.setFont(new Font("Tahoma", Font.BOLD, 13));
		txtW3.setEditable(false);
		txtW3.setColumns(10);
		txtW3.setBounds(234, 44, 38, 20);
		contentPane.add(txtW3);
		JLabel lblB = new JLabel("b =");
		lblB.setHorizontalAlignment(SwingConstants.CENTER);
		lblB.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblB.setEnabled(false);
		lblB.setBounds(186, 61, 49, 22);
		contentPane.add(lblB);
		txtB = new JTextField();
		txtB.setToolTipText("Valor de Beta");
		txtB.setText("?");
		txtB.setHorizontalAlignment(SwingConstants.CENTER);
		txtB.setFont(new Font("Tahoma", Font.BOLD, 13));
		txtB.setEditable(false);
		txtB.setColumns(10);
		txtB.setBounds(234, 66, 38, 20);
		contentPane.add(txtB);
		JLabel lblV = new JLabel("V: 2.3");
		lblV.setToolTipText("Versão do Software");
		;
		lblV.setEnabled(false);
		lblV.setHorizontalAlignment(SwingConstants.RIGHT);
		lblV.setBounds(670, 11, 46, 14);
		contentPane.add(lblV);
		contentPane.add(lblB);
	}

	protected void restart_Perceptron() {
		vwPer.dispose();
		vwPer = new vwPerceptron();
		vwPer.setVisible(true);
		cont = 0;
	}

	private void populaTabela() {
		table.setModel(model = new DefaultTableModel(new Object[][] {},
				new String[] { "X1", "X2 ", "X3 ", "1", "T",
						"Yent = (X1*W1) + (X2*W2) + (X3*W3) + b", "Y", "W1",
						"W2", "W3", "b", "\u0394W1", "\u0394W2", "\u0394W3",
						"\u0394b" }));
		Perceptron per = new Perceptron(Double.parseDouble(txtTeta.getText()
				.replaceAll(",", ".")), Integer.parseInt(txtAlfa.getText()
				.replaceAll(",", ".")));
		ArrayList<Linha> linhas = per.getLinhas();
		int epocas = 1;
		model.addRow(new Object[] { " ", " ", " ", " ", " ",
				"By: Marcelo Vieira", " ", " ", " ", " ", " ", " ", " ", " " });
		model.addRow(new Object[] { "---", "---", "---", "---", "---",
				epocas + "º Época", "---", "---", "---", "---", "---", "---",
				"---", "---", "---" });
		for (int i = 0; i < linhas.size(); i++) {
			if (i > 0 && i % 8 == 0) {
				epocas++;
				model.addRow(new Object[] { " ", " ", " ", " ", " ", " ", " ",
						" ", " ", " ", " ", " ", " ", " " });
				model.addRow(new Object[] { "---", "---", "---", "---", "---",
						epocas + "º Época", "---", "---", "---", "---", "---",
						"---", "---", "---", "---" });
			}
			model.addRow(new Object[] { linhas.get(i).getX1(),
					linhas.get(i).getX2(), linhas.get(i).getX3(),
					linhas.get(i).getUm(), linhas.get(i).getT(),
					linhas.get(i).getYent(), linhas.get(i).getY(),
					linhas.get(i).getW1(), linhas.get(i).getW2(),
					linhas.get(i).getW3(), linhas.get(i).getB(),
					linhas.get(i).getVw1(), linhas.get(i).getVw2(),
					linhas.get(i).getVw3(), linhas.get(i).getVb() });
		}
		txtB.setText(String.valueOf(linhas.get(linhas.size() - 1).getB()));
		txtW1.setText(String.valueOf(linhas.get(linhas.size() - 1).getW1()));
		txtW2.setText(String.valueOf(linhas.get(linhas.size() - 1).getW2()));
		txtW3.setText(String.valueOf(linhas.get(linhas.size() - 1).getW3()));
		table.getColumnModel().getColumn(5).setPreferredWidth(250);
		table.getColumnModel().getColumn(5).setMinWidth(250);
		table.setDefaultRenderer(Object.class, new CellRenderer());
	}
}

class CellRenderer extends DefaultTableCellRenderer {
	private static final long serialVersionUID = 1L;

	public CellRenderer() {
		super();
	}

	public Component getTableCellRendererComponent(JTable table, Object value,
			boolean isSelected, boolean hasFocus, int row, int column) {
		this.setHorizontalAlignment(CENTER);
		return super.getTableCellRendererComponent(table, value, isSelected,
				hasFocus, row, column);
	}
}