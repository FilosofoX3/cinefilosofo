package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import controller.BilheteriaBiz;
import model.*;
import utils.LtpLib;
import utils.RegExFieldVerifier;

import java.awt.event.ActionListener;
import java.io.File;
import java.sql.Date;
import java.text.ParseException;
import java.util.Calendar;
import java.util.List;
import java.util.Random;
import java.awt.event.ActionEvent;

public class JCadastroVendedor extends JFrame {

	private JPanel contentPane;
	private JTextField txtNome;
	private JTextField txtCpf;
	private JTextField txtEmail;
	private JTextField txtTelefones;
	private JTextField txtUsuario;
	private JTextField txtMetaVendas;
	private JFormattedTextField txtDataNascimento;
	private JPasswordField txtSenha;
	private JComboBox dropGerentes;
	private Random numeroRandomico = new Random();
	private BilheteriaBiz objBilheteria = new BilheteriaBiz();
	private LtpLib objLib = new LtpLib();

	/**
	 * Create the frame.
	 */
	@SuppressWarnings({ "unchecked", "static-access" })
	public JCadastroVendedor(){
		super("Cadastro Vendedor");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 281, 368);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(10, 11, 46, 14);
		panel.add(lblNome);
		
		txtNome = new JTextField();
		txtNome.setBounds(66, 8, 86, 20);
		panel.add(txtNome);
		txtNome.setColumns(10);
		
		JLabel lblCpf = new JLabel("CPF");
		lblCpf.setBounds(10, 36, 46, 14);
		panel.add(lblCpf);
		
		txtCpf = new JTextField();
		txtCpf.setBounds(66, 33, 86, 20);
		panel.add(txtCpf);
		txtCpf.setColumns(10);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(10, 70, 46, 14);
		panel.add(lblEmail);
		
		txtEmail = new JTextField();
		txtEmail.setBounds(66, 64, 86, 20);
		panel.add(txtEmail);
		txtEmail.setColumns(10);
		
		JLabel lblTelefones = new JLabel("Telefones");
		lblTelefones.setBounds(10, 105, 65, 14);
		panel.add(lblTelefones);
		
		txtTelefones = new JTextField();
		txtTelefones.setBounds(66, 102, 86, 20);
		panel.add(txtTelefones);
		txtTelefones.setColumns(10);
		
		JLabel lblUsuario = new JLabel("ID Usuário");
		lblUsuario.setBounds(10, 139, 56, 14);
		panel.add(lblUsuario);
		
		txtUsuario = new JTextField();
		txtUsuario.setBounds(66, 136, 86, 20);
		panel.add(txtUsuario);
		txtUsuario.setColumns(10);

		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setBounds(10, 175, 56, 14);
		panel.add(lblSenha);

		txtSenha = new JPasswordField();
		txtSenha.setBounds(66, 170, 86, 20);
		panel.add(txtSenha);
		txtSenha.setColumns(30);

		JLabel lblClassificacao = new JLabel("Gerente");
		lblClassificacao.setBounds(10, 200, 46, 14);
		panel.add(lblClassificacao);

		List<GerenteEntity> gerentes = objBilheteria.listaGerente();
		dropGerentes = new JComboBox(gerentes.toArray());
		dropGerentes.setBounds(66, 200, 86, 20);
		panel.add(dropGerentes);

		JLabel lblMetaVendas = new JLabel("Meta de Vendas");
		lblMetaVendas.setBounds(10, 230, 46, 14);
		panel.add(lblMetaVendas);

		txtMetaVendas = new JTextField("10");
		txtMetaVendas.setBounds(66, 230, 86, 20);
		panel.add(txtMetaVendas);
		txtMetaVendas.setColumns(10);

		JLabel lblDataNascimento = new JLabel("Data de nascimento");
		lblDataNascimento.setBounds(10, 260, 120, 14);
		panel.add(lblDataNascimento);

		JLabel lblDataNascimentoFormat = new JLabel("   (yyyy-mm-dd)");
		lblDataNascimentoFormat.setBounds(10, 274, 120, 14);
		panel.add(lblDataNascimentoFormat);


		txtDataNascimento = new JFormattedTextField();
		txtDataNascimento.setBounds(136, 260, 76, 20);
		txtDataNascimento.setInputVerifier(new RegExFieldVerifier("\\d{4}-\\d{2}-\\d{2}"));
		panel.add(txtDataNascimento);
		txtDataNascimento.setColumns(10);

		try {
			MaskFormatter dataMask = new MaskFormatter("####-##-##");
			dataMask.install(txtDataNascimento);
		} catch (ParseException err) {}

		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			@SuppressWarnings("static-access")
			public void actionPerformed(ActionEvent arg0) {
				Long pessoaId = objBilheteria.cadastrarPessoa(
						txtCpf.getText(),
						txtNome.getText(),
						txtEmail.getText(),
						new java.sql.Date(Calendar.getInstance().getTime().getTime()),
						Date.valueOf(txtDataNascimento.getText())
				);

				Long funcionarioId = objBilheteria.cadastrarFuncionario(
						pessoaId,
						txtUsuario.getText(),
						txtSenha.getPassword().toString()
				);

				objBilheteria.cadastrarFuncionarioTelefone(
						funcionarioId,
						txtTelefones.getText()
				);

                objBilheteria.cadastrarVendedor(
                        funcionarioId,
						((GerenteEntity) dropGerentes.getSelectedItem()).getGerenteId(),
                        Integer.parseInt(txtMetaVendas.getText())

                );

				JOptionPane.showMessageDialog(null, "Cadastrado com sucesso!");
			}
		});
		btnSalvar.setBounds(63, 290, 89, 23);
		panel.add(btnSalvar);
	}
}
