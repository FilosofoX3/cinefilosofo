package view;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Dimension;
import javax.swing.JTextField;
import javax.swing.DropMode;
import java.awt.Component;

public class JTelaPrincipal extends JFrame {
	private JButton Cadastro;
	private JTextField textField;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JTelaPrincipal frame = new JTelaPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public JTelaPrincipal() {
		super("CINEMA");
		setResizable(false);
		setBounds(100, 100, 1056, 569);
		
		JPanel panel = new JPanel();
		panel.setVerifyInputWhenFocusTarget(false);
		panel.setRequestFocusEnabled(false);
		panel.setMaximumSize(new Dimension(2500, 120));
		panel.setLayout(null);
		panel.setBorder(new LineBorder(Color.LIGHT_GRAY));
		panel.setBackground(new Color(255, 255, 255, 250));
		setContentPane(panel);
		setLocationRelativeTo(null);

		
		JLabel label = new JLabel("");
		label.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label.setIcon(new ImageIcon(JTelaPrincipal.class.getResource("/imagens/TelaPrincipal.jpg")));
		label.setBounds(0, 193, 800, 364);
		panel.add(label);
		
		//Botão de cadastro gerente
		JButton btnCadastroGerente = new JButton();
		btnCadastroGerente.setBounds(33, 43, 106, 65);
		panel.add(btnCadastroGerente);
		btnCadastroGerente.setForeground(Color.PINK);
		btnCadastroGerente.setBackground(Color.WHITE);
		btnCadastroGerente.setBorder(new EmptyBorder(0, 0, 0, 0));
		btnCadastroGerente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JCadastrosFuncionarios jCad = new JCadastrosFuncionarios();
				jCad.setVisible(true);
			}
		});
		btnCadastroGerente.setIcon(new ImageIcon(JTelaPrincipal.class.getResource("/imagens/engineer.png")));
		
		//Botão de cadastro gerente
				JButton btnCadastroVendedor = new JButton();
				btnCadastroVendedor.setBounds(194, 43, 106, 65);
				panel.add(btnCadastroVendedor);
				btnCadastroVendedor.setForeground(Color.PINK);
				btnCadastroVendedor.setBackground(Color.WHITE);
				btnCadastroVendedor.setBorder(new EmptyBorder(0, 0, 0, 0));
				btnCadastroVendedor.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						JCadastroVendedor cadV = new JCadastroVendedor();
						cadV.setVisible(true);
						
					}
				});
				btnCadastroVendedor.setIcon(new ImageIcon(JTelaPrincipal.class.getResource("/imagens/vendedor.png")));
		
		JTextField txtCadastroGerente = new JTextField();
		txtCadastroGerente.setAlignmentX(Component.RIGHT_ALIGNMENT);
		txtCadastroGerente.setRequestFocusEnabled(false);
		txtCadastroGerente.setOpaque(false);
		txtCadastroGerente.setEnabled(true);
		txtCadastroGerente.setEditable(true);
		txtCadastroGerente.setForeground(new Color(157, 105, 128));
		txtCadastroGerente.setDropMode(DropMode.INSERT);
		txtCadastroGerente.setFont(new Font("Yu Gothic Light", Font.PLAIN, 12));
		txtCadastroGerente.setBackground(new Color(72, 209, 204));
		txtCadastroGerente.setText("Cadastro Gerente");
		txtCadastroGerente.setBounds(33, 119, 106, 25);
		panel.add(txtCadastroGerente);
		txtCadastroGerente.setColumns(10);
		
		textField = new JTextField();
		textField.setText("Cadastro Vendedor");
		textField.setRequestFocusEnabled(false);
		textField.setOpaque(false);
		textField.setForeground(new Color(128, 0, 128));
		textField.setFont(new Font("Yu Gothic Light", Font.PLAIN, 12));
		textField.setEnabled(true);
		textField.setEditable(true);
		textField.setDropMode(DropMode.INSERT);
		textField.setColumns(10);
		textField.setBackground(new Color(172, 209, 205));
		textField.setAlignmentX(1.0f);
		textField.setBounds(194, 119, 106, 25);
		panel.add(textField);

	}
}
