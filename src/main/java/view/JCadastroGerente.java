package view;

import controller.BilheteriaBiz;
import utils.LtpLib;
import utils.RegExFieldVerifier;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JCadastroGerente extends JFrame {

	private JPanel contentPane;
	private JTextField txtNome;
	private JFormattedTextField txtCpf;
	private JTextField txtEmail;
	private JTextField txtTelefones;
	private JTextField txtUsuario;
	private JPasswordField txtSenha;
	private JFormattedTextField txtDataNascimento;
	private BilheteriaBiz objBilheteria = new BilheteriaBiz();
	private LtpLib objLib = new LtpLib();

	/**
	 * Create the frame.
	 */
	@SuppressWarnings({ "unchecked", "static-access" })
	public JCadastroGerente() {
		super("Cadastro Gerente");
		
		setBounds(100, 100, 281, 360);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(10, 11, 120, 14);
		panel.add(lblNome);
		
		txtNome = new JTextField();
		txtNome.setBounds(136, 8, 86, 20);
		panel.add(txtNome);
		txtNome.setColumns(10);
		
		JLabel lblCpf = new JLabel("CPF");
		lblCpf.setBounds(10, 36, 120, 14);
		panel.add(lblCpf);
		
		txtCpf = new JFormattedTextField();
		txtCpf.setBounds(136, 33, 86, 20);
		panel.add(txtCpf);
		txtCpf.setColumns(10);

		try {
			MaskFormatter cpfMask = new MaskFormatter("###.###.###-##");
			cpfMask.install(txtCpf);
		} catch (ParseException err) {}

		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(10, 70, 120, 14);
		panel.add(lblEmail);
		
		txtEmail = new JTextField();
		txtEmail.setBounds(136, 64, 86, 20);
		panel.add(txtEmail);
		txtEmail.setColumns(10);
		
		JLabel lblTelefones = new JLabel("Telefones");
		lblTelefones.setBounds(10, 105, 120, 14);
		panel.add(lblTelefones);
		
		txtTelefones = new JTextField();
		txtTelefones.setBounds(136, 102, 86, 20);
		panel.add(txtTelefones);
		txtTelefones.setColumns(10);
		
		JLabel lblUsuario = new JLabel("Usuário");
		lblUsuario.setBounds(10, 139, 120, 14);
		panel.add(lblUsuario);
		
		txtUsuario = new JTextField();
		txtUsuario.setBounds(136, 136, 86, 20);
		panel.add(txtUsuario);
		txtUsuario.setColumns(10);


		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setBounds(10, 175, 120, 14);
		panel.add(lblSenha);

		txtSenha = new JPasswordField();
		txtSenha.setBounds(136, 170, 86, 20);
		panel.add(txtSenha);
		txtSenha.setColumns(30);

		JLabel lblDataNascimento = new JLabel("Data de nascimento");
		lblDataNascimento.setBounds(10, 200,120, 14);
		panel.add(lblDataNascimento);

		txtDataNascimento = new JFormattedTextField();
		txtDataNascimento.setBounds(136, 200,76, 20);
		txtDataNascimento.setInputVerifier(new RegExFieldVerifier("([0-2][0-9]|3[0-1])/(0[1-9]|1[0-2])/(19|20)\\d{2}"));
		panel.add(txtDataNascimento);
		txtDataNascimento.setColumns(10);

		try {
			MaskFormatter dataMask = new MaskFormatter("##/##/####");
			dataMask.install(txtDataNascimento);
		} catch (ParseException err) {}

		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			@SuppressWarnings("static-access")
			public void actionPerformed(ActionEvent arg0) {
				Pattern patternData = Pattern.compile("([0-2][0-9]|3[0-1])/(0[0-9]|1[0-2])/(\\d{4})");

				Matcher matchDataNascimento = patternData.matcher(txtDataNascimento.getText());
				matchDataNascimento.find();
				Date dataNascimento = Date.valueOf(matchDataNascimento.group(3) + "-" + matchDataNascimento.group(2) + "-" + matchDataNascimento.group(1));

				Long pessoaId = objBilheteria.cadastrarPessoa(
						txtCpf.getText(),
						txtNome.getText(),
						txtEmail.getText(),
						new java.sql.Date(Calendar.getInstance().getTime().getTime()),
						dataNascimento
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
		btnSalvar.setBounds(63, 257, 89, 23);
		panel.add(btnSalvar);
	}
}
