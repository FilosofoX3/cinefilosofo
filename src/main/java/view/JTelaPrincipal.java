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
import java.awt.Cursor;

public class JTelaPrincipal extends JFrame {
	private JButton Cadastro;
	private JTextField txtGerenciamentoCinema;
	private JTextField txtCadastrarFuncionrio;
	private JTextField txtCadastrarSesses;
	private JTextField txtVenderBilhete;
	
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
		setBackground(new Color(102, 51, 0));
		setLocationRelativeTo(null);
		setResizable(false);
		setBounds(100, 100, 1056, 569);
		
		JPanel panel = new JPanel();
		panel.setVerifyInputWhenFocusTarget(false);
		panel.setRequestFocusEnabled(false);
		panel.setMaximumSize(new Dimension(2500, 120));
		panel.setLayout(null);
		panel.setBorder(new LineBorder(Color.LIGHT_GRAY));
		panel.setBackground(new Color(102, 102, 102));
		setContentPane(panel);
		setLocationRelativeTo(null);

		
		JLabel label = new JLabel("");
		label.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label.setIcon(new ImageIcon(JTelaPrincipal.class.getResource("/imagens/TelaPrincipal.jpg")));
		label.setBounds(0, 193, 932, 364);
		panel.add(label);
		
		txtGerenciamentoCinema = new JTextField();
		txtGerenciamentoCinema.setBackground(new Color(51, 51, 51));
		txtGerenciamentoCinema.setForeground(new Color(255, 51, 0));
		txtGerenciamentoCinema.setCaretColor(new Color(255, 51, 0));
		txtGerenciamentoCinema.setFont(new Font("Verdana", Font.BOLD, 21));
		txtGerenciamentoCinema.setSelectedTextColor(new Color(153, 51, 0));
		txtGerenciamentoCinema.setSelectionColor(new Color(51, 102, 153));
		txtGerenciamentoCinema.setBounds(0, 0, 1050, 59);
		panel.add(txtGerenciamentoCinema);
		txtGerenciamentoCinema.setText("\t\t Gerenciamento  Cinema");
		txtGerenciamentoCinema.setColumns(10);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jCadastroFuncionario cadFunc = new jCadastroFuncionario();
				cadFunc.setVisible(true);
			}
		});
		btnNewButton.setIcon(new ImageIcon(getClass().getResource("/imagens/Funcionario.jpg")));
		btnNewButton.setBounds(76, 70, 90, 70);
		panel.add(btnNewButton);
		
		txtCadastrarFuncionrio = new JTextField();
		txtCadastrarFuncionrio.setBackground(new Color(204, 255, 255));
		txtCadastrarFuncionrio.setForeground(new Color(0, 0, 153));
		txtCadastrarFuncionrio.setFont(new Font("Yu Gothic", Font.BOLD, 13));
		txtCadastrarFuncionrio.setText("\t Cadastrar Funcionários");
		txtCadastrarFuncionrio.setBounds(50, 148, 154, 20);
		panel.add(txtCadastrarFuncionrio);
		txtCadastrarFuncionrio.setColumns(10);
		
		JButton btnCadSessao = new JButton("");
		btnCadSessao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JCadastraSessao cadSes = new JCadastraSessao();
				cadSes.setVisible(true);
				}
		});
		btnCadSessao.setIcon(new ImageIcon(getClass().getResource("/imagens/videocamera.png")));
		btnCadSessao.setBounds(250, 70, 81, 70);
		panel.add(btnCadSessao);
		
		txtCadastrarSesses = new JTextField();
		txtCadastrarSesses.setText("   Cadastrar Sessões");
		txtCadastrarSesses.setForeground(new Color(0, 0, 153));
		txtCadastrarSesses.setFont(new Font("Yu Gothic", Font.BOLD, 13));
		txtCadastrarSesses.setColumns(10);
		txtCadastrarSesses.setBackground(new Color(204, 255, 255));
		txtCadastrarSesses.setBounds(214, 148, 146, 20);
		panel.add(txtCadastrarSesses);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JVendaBilhete cadBil = new JVendaBilhete();
				cadBil.setVisible(true);
				
			}
		});
		btnNewButton_1.setIcon(new ImageIcon(getClass().getResource("/imagens/videocamera.png")));
		btnNewButton_1.setBounds(403, 81, 81, 59);
		panel.add(btnNewButton_1);
		
		txtVenderBilhete = new JTextField();
		txtVenderBilhete.setText("   Vender Bilhete");
		txtVenderBilhete.setForeground(new Color(0, 0, 153));
		txtVenderBilhete.setFont(new Font("Yu Gothic", Font.BOLD, 13));
		txtVenderBilhete.setColumns(10);
		txtVenderBilhete.setBackground(new Color(204, 255, 255));
		txtVenderBilhete.setBounds(380, 148, 126, 20);
		panel.add(txtVenderBilhete);

	}
}
