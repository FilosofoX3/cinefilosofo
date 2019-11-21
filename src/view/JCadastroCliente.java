package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.BilheteriaBiz;
import model.Gerente;
import utilitarios.LtpLib;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Date;
import java.util.Random;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class JCadastroCliente extends JFrame {

	private JPanel contentPane;
	private JTextField txtNome;
	private JTextField txtCpf;
	private JTextField txtEmail;
	private JTextField txtTelefones;
	private JTextField txtDataNascimento;
	private JTextField txtDataCadastro;
	
	private Random numeroRandomico = new Random();
	private BilheteriaBiz objBilheteria = new BilheteriaBiz();
	private LtpLib objLib = new LtpLib();

	/**
	 * Create the frame.
	 */
	@SuppressWarnings({ "unchecked", "static-access" })
	public JCadastroCliente() {
		super("Cadastro Cliente");
		
		try {
			if(new File("Funcionarios.obj").exists()) {
				objBilheteria.setListaFuncionario(objLib.lerArquivoObjetos("Funcionarios.obj"));
			}
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
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
		lblNome.setFont(new Font("Yu Gothic", Font.BOLD, 11));
		lblNome.setBounds(10, 11, 46, 14);
		panel.add(lblNome);
		
		txtNome = new JTextField();
		txtNome.setBounds(115, 11, 86, 20);
		panel.add(txtNome);
		txtNome.setColumns(10);
		
		JLabel lblCpf = new JLabel("CPF");
		lblCpf.setFont(new Font("Yu Gothic", Font.BOLD, 11));
		lblCpf.setBounds(10, 36, 46, 14);
		panel.add(lblCpf);
		
		txtCpf = new JTextField();
		txtCpf.setBounds(115, 36, 86, 20);
		panel.add(txtCpf);
		txtCpf.setColumns(10);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Yu Gothic", Font.BOLD, 11));
		lblEmail.setBounds(10, 70, 46, 14);
		panel.add(lblEmail);
		
		txtEmail = new JTextField();
		txtEmail.setBounds(115, 67, 86, 20);
		panel.add(txtEmail);
		txtEmail.setColumns(10);
		
		JLabel lblTelefones = new JLabel("Telefones");
		lblTelefones.setFont(new Font("Yu Gothic", Font.BOLD, 11));
		lblTelefones.setBounds(10, 105, 65, 14);
		panel.add(lblTelefones);
		
		txtTelefones = new JTextField();
		txtTelefones.setBounds(115, 105, 86, 20);
		panel.add(txtTelefones);
		txtTelefones.setColumns(10);
		
		JLabel lblUsuario = new JLabel("Data Nacimento");
		lblUsuario.setFont(new Font("Yu Gothic", Font.BOLD, 11));
		lblUsuario.setBounds(10, 139, 112, 14);
		panel.add(lblUsuario);
		
		txtDataNascimento = new JTextField();
		txtDataNascimento.setBounds(115, 133, 86, 20);
		panel.add(txtDataNascimento);
		txtDataNascimento.setColumns(10);
		
		JLabel lblSenha = new JLabel("Data Cadastro");
		lblSenha.setFont(new Font("Yu Gothic", Font.BOLD, 11));
		lblSenha.setBounds(10, 164, 86, 14);
		panel.add(lblSenha);
		
		txtDataCadastro = new JTextField();
		txtDataCadastro.setBounds(115, 164, 86, 20);
		panel.add(txtDataCadastro);
		txtDataCadastro.setColumns(10);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			@SuppressWarnings("static-access")
			public void actionPerformed(ActionEvent arg0) {
				Gerente gerente  = new Gerente();			
				gerente.setCodigo(numeroRandomico.nextInt(100));
				gerente.setDataCad(new Date());
				gerente.setNome(txtNome.getText());
				gerente.setEmail(txtEmail.getText());
				gerente.setTelefones(txtTelefones.getText());
				gerente.setUsuario(txtDataNascimento.getText());
				gerente.setSenha(txtDataCadastro.getText());
								
				objBilheteria.cadastrarFuncionario(gerente);
					
							
			}
		});
		btnSalvar.setBounds(63, 217, 89, 23);
		panel.add(btnSalvar);
	}
}
