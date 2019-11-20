package view;

import controller.BilheteriaBiz;
import utils.LtpLib;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.Random;

public class JCadastroGerente extends JFrame {

	private JPanel contentPane;
	private JTextField txtNome;
	private JTextField txtCpf;
	private JTextField txtEmail;
	private JTextField txtTelefones;
	private JTextField txtUsuario;
	private JPasswordField txtSenha;
	private Random numeroRandomico = new Random();
	private BilheteriaBiz objBilheteria = new BilheteriaBiz();
	private LtpLib objLib = new LtpLib();

	/**
	 * Create the frame.
	 */
	@SuppressWarnings({ "unchecked", "static-access" })
	public JCadastroGerente() {
		super("Cadastro Gerente");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 281, 298);
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
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			@SuppressWarnings("static-access")
			public void actionPerformed(ActionEvent arg0) {
				Long pessoaId = objBilheteria.cadastrarPessoa(
						txtCpf.getText(),
						txtNome.getText(),
						txtEmail.getText(),
						new java.sql.Date(Calendar.getInstance().getTime().getTime()),
						// TODO: ADICIONAR CAMPO NO FORM
						new java.sql.Date(Calendar.getInstance().getTime().getTime())
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

                objBilheteria.cadastrarGerente(
                        funcionarioId
                );

				JOptionPane.showMessageDialog(null, "Cadastrado com sucesso!");
			}
		});
		btnSalvar.setBounds(63, 217, 89, 23);
		panel.add(btnSalvar);
	}
}
