package view;

import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Dimension;
import java.awt.Component;
import java.awt.Cursor;

public class JTelaPrincipal extends JFrame {
	private JButton Cadastro;
	private JLabel txtGerenciamentoCinema;
	private JLabel txtCadastrarFuncionrio;
	private JLabel txtCadastrarSesses;
	private JLabel txtVenderBilhete;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SplashScreen splashScreen = new SplashScreen(10000);
					splashScreen.showSplash();
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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label.setIcon(new ImageIcon(JTelaPrincipal.class.getResource("/imagens/TelaPrincipal.jpg")));
		label.setBounds(0, 193, 1050, 364);
		panel.add(label);
		
		txtGerenciamentoCinema = new JLabel();
		txtGerenciamentoCinema.setOpaque(true);
		txtGerenciamentoCinema.setVerticalAlignment(SwingConstants.CENTER);
		txtGerenciamentoCinema.setHorizontalAlignment(SwingConstants.CENTER);
		txtGerenciamentoCinema.setBackground(new Color(51, 51, 51));
		txtGerenciamentoCinema.setForeground(new Color(255, 51, 0));
		txtGerenciamentoCinema.setFont(new Font("Verdana", Font.BOLD, 21));
		txtGerenciamentoCinema.setBounds(0, 0, 1050, 59);
		panel.add(txtGerenciamentoCinema);
		txtGerenciamentoCinema.setText("\t\t Gerenciamento  Cinema");

		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jCadastroFuncionario cadFunc = new jCadastroFuncionario();
				cadFunc.setVisible(true);
			}
		});
		btnNewButton.setIcon(new ImageIcon(getClass().getResource("/imagens/employeer.png")));
		btnNewButton.setBounds(76, 70, 90, 70);
		panel.add(btnNewButton);
		
		txtCadastrarFuncionrio = new JLabel();
		txtCadastrarFuncionrio.setOpaque(true);
		txtCadastrarFuncionrio.setBackground(new Color(204, 255, 255));
		txtCadastrarFuncionrio.setForeground(new Color(0, 0, 153));
		txtCadastrarFuncionrio.setFont(new Font("Yu Gothic", Font.BOLD, 13));
		txtCadastrarFuncionrio.setText("\t Cadastrar Funcionários");
		txtCadastrarFuncionrio.setBounds(50, 148, 154, 20);
		panel.add(txtCadastrarFuncionrio);

		JButton btnCadSessao = new JButton("");
		btnCadSessao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JCadastroSessao cadSes = new JCadastroSessao();
				cadSes.setVisible(true);
			}
		});
		btnCadSessao.setIcon(new ImageIcon(getClass().getResource("/imagens/sessao.png")));
		btnCadSessao.setBounds(250, 70, 81, 70);
		panel.add(btnCadSessao);
		
		txtCadastrarSesses = new JLabel();
		txtCadastrarSesses.setOpaque(true);
		txtCadastrarSesses.setText("   Cadastrar Sessões");
		txtCadastrarSesses.setForeground(new Color(0, 0, 153));
		txtCadastrarSesses.setFont(new Font("Yu Gothic", Font.BOLD, 13));
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
		btnNewButton_1.setIcon(new ImageIcon(getClass().getResource("/imagens/ticket.png")));
		btnNewButton_1.setBounds(403, 81, 81, 59);
		panel.add(btnNewButton_1);
		
		txtVenderBilhete = new JLabel();
		txtVenderBilhete.setOpaque(true);
		txtVenderBilhete.setText("   Vender Bilhete");
		txtVenderBilhete.setForeground(new Color(0, 0, 153));
		txtVenderBilhete.setFont(new Font("Yu Gothic", Font.BOLD, 13));
		txtVenderBilhete.setBackground(new Color(204, 255, 255));
		txtVenderBilhete.setBounds(380, 148, 126, 20);
		panel.add(txtVenderBilhete);

		JButton btnNovoFilme = new JButton("");
		btnNovoFilme.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JCadastroFilme cadFil = new JCadastroFilme();
				cadFil.setVisible(true);
			}
		});
		btnNovoFilme.setIcon(new ImageIcon(getClass().getResource("/imagens/video.png")));
		btnNovoFilme.setBounds(553, 81, 81, 59);
		panel.add(btnNovoFilme);

		txtVenderBilhete = new JLabel();
		txtVenderBilhete.setOpaque(true);
		txtVenderBilhete.setText("   Cadastro de filme");
		txtVenderBilhete.setForeground(new Color(0, 0, 153));
		txtVenderBilhete.setFont(new Font("Yu Gothic", Font.BOLD, 13));
		txtVenderBilhete.setBackground(new Color(204, 255, 255));
		txtVenderBilhete.setBounds(520, 148, 126, 20);
		panel.add(txtVenderBilhete);

		JButton btnRelatorioVendas = new JButton("");
		btnRelatorioVendas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JRelatorio relatorio = new JRelatorio();
				relatorio.setVisible(true);
			}
		});
		btnRelatorioVendas.setIcon(new ImageIcon(getClass().getResource("/imagens/report.png")));
		btnRelatorioVendas.setBounds(703, 81, 81, 59);
		panel.add(btnRelatorioVendas);

		txtVenderBilhete = new JLabel();
		txtVenderBilhete.setOpaque(true);
		txtVenderBilhete.setText("   Relatorio de vendas");
		txtVenderBilhete.setForeground(new Color(0, 0, 153));
		txtVenderBilhete.setFont(new Font("Yu Gothic", Font.BOLD, 13));
		txtVenderBilhete.setBackground(new Color(204, 255, 255));
		txtVenderBilhete.setBounds(680, 148, 156, 20);
		panel.add(txtVenderBilhete);

	}
}
