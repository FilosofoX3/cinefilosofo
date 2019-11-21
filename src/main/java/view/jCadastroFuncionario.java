package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class jCadastroFuncionario extends JFrame{
	private JTextField txtCadastroVendedor;
	private JTextField txtVoltar;
	private JTextField txtCadastroGerente;
	public jCadastroFuncionario() {
		super("Cadastro de Funcion?rios");
		setBounds(100, 100, 406, 298);
		getContentPane().setLayout(null);
		
		//Cadastro de Gerente
		JButton btnGerente = new JButton("");
		btnGerente.setFocusCycleRoot(true);
		btnGerente.setIcon(new ImageIcon(getClass().getResource("/imagens/engineer.png")));
		btnGerente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JCadastroGerente cadGer = new JCadastroGerente();
				cadGer.setVisible(true);
			}
		});
		btnGerente.setBounds(236, 35, 76, 67);
		getContentPane().add(btnGerente);
		
		
		//Cadastro de Vendedor
		JButton btnVendedor = new JButton("");
		btnVendedor.setFocusCycleRoot(true);
		btnVendedor.setIcon(new ImageIcon(getClass().getResource("/imagens/vendedor.png")));
		btnVendedor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JCadastroVendedor cadVend = new JCadastroVendedor();
				cadVend.setVisible(true);
			}
		});
		btnVendedor.setBounds(84, 35, 76, 67);
		getContentPane().add(btnVendedor);
		
		txtCadastroVendedor = new JTextField();
		txtCadastroVendedor.setForeground(new Color(0, 102, 102));
		txtCadastroVendedor.setBackground(new Color(255, 255, 255));
		txtCadastroVendedor.setFont(new Font("Yu Gothic", Font.BOLD, 11));
		txtCadastroVendedor.setText("  Cadastro Vendedor");
		txtCadastroVendedor.setBounds(65, 113, 115, 20);
		getContentPane().add(txtCadastroVendedor);
		txtCadastroVendedor.setColumns(10);
		
		JButton btnVoltar = new JButton("");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JTelaPrincipal telPrinc = new JTelaPrincipal();
				telPrinc.setVisible(true);
			}
		});
		btnVoltar.setIcon(new ImageIcon("C:\\Users\\Vin\u00EDcius Santos\\Ufla\\2019-2\\Tabalho Final\\Imagens\\back.png"));
		btnVoltar.setBounds(167, 161, 76, 58);
		getContentPane().add(btnVoltar);
		
		txtVoltar = new JTextField();
		txtVoltar.setBackground(new Color(204, 204, 204));
		txtVoltar.setForeground(new Color(255, 102, 102));
		txtVoltar.setFont(new Font("Yu Gothic", Font.BOLD, 13));
		txtVoltar.setText("Voltar ");
		txtVoltar.setBounds(177, 228, 54, 20);
		getContentPane().add(txtVoltar);
		txtVoltar.setColumns(10);
		
		txtCadastroGerente = new JTextField();
		txtCadastroGerente.setText("  Cadastro Gerente");
		txtCadastroGerente.setForeground(new Color(0, 102, 102));
		txtCadastroGerente.setFont(new Font("Yu Gothic", Font.BOLD, 11));
		txtCadastroGerente.setColumns(10);
		txtCadastroGerente.setBackground(Color.WHITE);
		txtCadastroGerente.setBounds(221, 113, 115, 20);
		getContentPane().add(txtCadastroGerente);
	
	}
}
