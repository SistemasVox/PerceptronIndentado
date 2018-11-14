package View;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.UIManager;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class vwAbout extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	static vwAbout frame;

	public vwAbout() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(
				"C:\\workspace\\Perceptron\\img\\icon (1).png"));
		setTitle("Sobre");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(300, 90, 720, 460);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JLabel lblSair = new JLabel("");
		lblSair.setToolTipText("Sair");
		lblSair.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				dispose();
			}
		});
		lblSair.setBounds(65, 11, 512, 107);
		contentPane.add(lblSair);
		JLabel lblFundo = new JLabel("");
		lblFundo.setBackground(UIManager.getColor("Button.background"));
		lblFundo.setBounds(0, 0, 704, 422);
		lblFundo.setIcon(new ImageIcon(
				"C:\\workspace\\Perceptron\\img\\ag1400.png"));
		contentPane.add(lblFundo);
		JTextArea txtpnSoftwareAgendaTelefnica = new JTextArea();
		txtpnSoftwareAgendaTelefnica.setWrapStyleWord(true);
		txtpnSoftwareAgendaTelefnica.setLineWrap(true);
		txtpnSoftwareAgendaTelefnica.setBackground(UIManager
				.getColor("Button.background"));
		txtpnSoftwareAgendaTelefnica.setFont(new Font("Tahoma", Font.BOLD
				| Font.ITALIC, 16));
		txtpnSoftwareAgendaTelefnica.setEditable(false);
		txtpnSoftwareAgendaTelefnica
				.setText("Software Perceptron A.I  Intelig\u00EAncia Artificial. Com 3 entradas! \r\nCriado e desenvolvido por Marcelo Vieira, Marcelo Ferreira, Vladir Orlando, 7\u00BA Per\u00EDodo.\r\n\r\nLink source: https://www.dropbox.com/sh/x9pw6mqbdnvm60u/AAAwn2YM3Nnx0nvj8eJ59Diaa?dl=0\r\n\r\nEsse projeto foi poss\u00EDvel gra\u00E7as ao projeto de c\u00F3digo aberto AgendaTelefonicaVOX\r\ne outros softwares de c\u00F3digo aberto.\r\nCopyright \u00A9 2013-2018 Sistema VOX. Todos os direitos reservados.");
		txtpnSoftwareAgendaTelefnica.setBounds(31, 102, 546, 309);
		contentPane.add(txtpnSoftwareAgendaTelefnica);
		setTitle("Sobre");
	}
}