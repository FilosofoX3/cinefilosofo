package view;

import controller.BilheteriaBiz;
import model.FilmeEntity;
import model.GerenteEntity;
import model.SalaEntity;
import model.TecnologiaEntity;
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
import java.util.List;
import java.util.Random;
import java.util.Vector;

public class JCadastroSessao extends JFrame {

	private JPanel contentPane;
	private JButton btnTitulo;
	private JTextField txtTitulo;
	private JComboBox dropSalas;
	private JComboBox dropTecnologias;
	private JTextField txtEmail;
	private JTextField txtTelefones;
	private JTextField txtUsuario;
	private JTextField txtMetaVendas;
	private JFormattedTextField txtDataNascimento;
	private JPasswordField txtSenha;
	private JComboBox dropGerentes;
	private JList listaFilmes = new JList();
	private Random numeroRandomico = new Random();
	private BilheteriaBiz objBilheteria = new BilheteriaBiz();
	private LtpLib objLib = new LtpLib();
	private List<SalaEntity> salas;
	private List<TecnologiaEntity> tecnologias;

	/**
	 * Create the frame.
	 */
	@SuppressWarnings({ "unchecked", "static-access" })
	public JCadastroSessao(){
		super("Cadastro Sessão");

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 581, 368);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		final JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		JLabel lblNome = new JLabel("Filme");
		lblNome.setBounds(10, 11, 146, 14);
		panel.add(lblNome);

		txtTitulo = new JTextField();
		txtTitulo.setBounds(166, 8, 213, 20);
		panel.add(txtTitulo);
		txtTitulo.setColumns(10);

		listaFilmes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(166, 36, 310, 90);
		scrollPane.setViewportView(listaFilmes);
		panel.add(scrollPane);

		JButton btnPesquisa = new JButton("Pesquisa");
		btnPesquisa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				List<FilmeEntity> filmes =  objBilheteria.procuraFilme(txtTitulo.getText());

				System.out.println(filmes.toString());

				if(!filmes.isEmpty()) {
					listaFilmes.setListData(filmes.toArray());
				}
				else {
					listaFilmes.setListData(new Vector());
				}
			}
		});
		btnPesquisa.setBounds(386, 8, 89, 23);
		panel.add(btnPesquisa);

		JLabel lblEmail = new JLabel("Tecnologias");
		lblEmail.setBounds(10, 136, 146, 14);
		panel.add(lblEmail);

		tecnologias = objBilheteria.listaTecnologia();
		salas = objBilheteria.listaSala(false);

		dropTecnologias = new JComboBox(tecnologias.toArray());
		dropTecnologias.setBounds(166, 133, 86, 20);
		panel.add(dropTecnologias);

		// Filtra as salas de acordo com a tecnologia selecionada
		dropTecnologias.addActionListener (new ActionListener () {
			public void actionPerformed(ActionEvent e) {
				if (((TecnologiaEntity) dropTecnologias.getSelectedItem()).getNome().equals("4D")) {
					salas = objBilheteria.listaSala(true);
					dropSalas.setModel(new DefaultComboBoxModel(salas.toArray()));
				}
				else {
					salas = objBilheteria.listaSala(false);
					dropSalas.setModel(new DefaultComboBoxModel(salas.toArray()));
				}
			}
		});


		JLabel lblCpf = new JLabel("Sala");
		lblCpf.setBounds(10, 166, 146, 14);
		panel.add(lblCpf);

		dropSalas = new JComboBox(salas.toArray());
		dropSalas.setBounds(166, 163, 86, 20);
		panel.add(dropSalas);

		JLabel lblTelefones = new JLabel("Data início");
		lblTelefones.setBounds(10, 205, 146, 14);
		panel.add(lblTelefones);

		txtTelefones = new JTextField();
		txtTelefones.setBounds(166, 202, 86, 20);
		panel.add(txtTelefones);
		txtTelefones.setColumns(10);

		JLabel lblUsuario = new JLabel("Data fim");
		lblUsuario.setBounds(10, 239, 146, 14);
		panel.add(lblUsuario);

		txtUsuario = new JTextField();
		txtUsuario.setBounds(166, 236, 86, 20);
		panel.add(txtUsuario);
		txtUsuario.setColumns(10);

		JLabel lblSenha = new JLabel("Horário");
		lblSenha.setBounds(10, 275, 146, 14);
		panel.add(lblSenha);

		txtSenha = new JPasswordField();
		txtSenha.setBounds(166, 270, 86, 20);
		panel.add(txtSenha);
		txtSenha.setColumns(30);

		JLabel lblClassificacao = new JLabel("Valor (R$)");
		lblClassificacao.setBounds(10, 300, 146, 14);
		panel.add(lblClassificacao);

		List<GerenteEntity> gerentes = objBilheteria.listaGerente();
		dropGerentes = new JComboBox(gerentes.toArray());
		dropGerentes.setBounds(166, 300, 86, 20);
		panel.add(dropGerentes);

		JLabel lblMetaVendas = new JLabel("Checkbox");
		lblMetaVendas.setBounds(10, 330, 146, 14);
		panel.add(lblMetaVendas);

		txtMetaVendas = new JTextField("10");
		txtMetaVendas.setBounds(166, 330, 86, 20);
		panel.add(txtMetaVendas);
		txtMetaVendas.setColumns(10);

		JLabel lblDataNascimento = new JLabel("Data de nascimento");
		lblDataNascimento.setBounds(10, 360, 146, 14);
		panel.add(lblDataNascimento);

		JLabel lblDataNascimentoFormat = new JLabel("   (yyyy-mm-dd)");
		lblDataNascimentoFormat.setBounds(10, 374, 146, 14);
		panel.add(lblDataNascimentoFormat);


		txtDataNascimento = new JFormattedTextField();
		txtDataNascimento.setBounds(166, 360, 76, 20);
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
						txtEmail.getText(),
						txtEmail.getText(),
						txtEmail.getText(),
						new Date(Calendar.getInstance().getTime().getTime()),
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
		btnSalvar.setBounds(63, 390, 89, 23);
		panel.add(btnSalvar);
	}
}
