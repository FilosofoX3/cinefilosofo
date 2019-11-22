package view;

		import javax.swing.*;
		import java.awt.*;
		import java.io.File;
		import java.sql.Date;
		import java.text.ParseException;
		import java.util.ArrayList;
		import javax.swing.table.DefaultTableModel;

		import controller.BilheteriaBiz;
		import model.ClienteEntity;
		import model.FilmeEntity;
		import model.SessaoEntity;
		import model.TecnologiaEntity;
		import utils.DateUtils;
		import utils.LtpLib;
		import utils.RegExFieldVerifier;

		import javax.swing.border.BevelBorder;

		import java.awt.event.ActionListener;
		import java.awt.event.ActionEvent;
		import java.util.Calendar;
		import java.util.List;
		import java.util.regex.Matcher;
		import java.util.regex.Pattern;
		import javax.swing.border.TitledBorder;
		import javax.swing.text.MaskFormatter;

public class JVendaBilhete extends JFrame{
	private BilheteriaBiz objBilheteria = new BilheteriaBiz();
	private LtpLib objLib = new LtpLib();
	private JTextField txtVendaBilhete;
	private JTextField txtTitulo;
	private JTextField cpTitulo;
	private JTextField txtData;
	private JFormattedTextField cpData;
	private JButton btnSalvar;
	private JButton btnPesquisaSessao;
	private JButton btnPesquisaCliente;
	private JButton btnAtualizaCliente;
	private JComboBox dropCliente;
	private JTextField txtTecnologia;
	private JTextField txtDadosCliente;
	private JTextField txtNomeCpf;
	private JTextField cpNomeCpf;
	private JRadioButton rbP4d;
	private JRadioButton rbPNormal;
	private JRadioButton rbONormal;
	private JTextField txtPoltrona;
	private JTextField txtculos;
	private JRadioButton rdPol;
	private JRadioButton rdNormal;
	private Container panel;
	private JTextField textField;
	private JButton btnBuscar;
	private JComboBox comboBox;
	private JComboBox dropTecnologias;
	private JTextField txtCliente;
	private Font tituloFonte = new Font("Yu Gothic", Font.BOLD, 16);
	private Font regularFonte = new Font("Yu Gothic", Font.BOLD, 13);
	private List<TecnologiaEntity> tecnologias;
	private JList listaSessoes = new JList();
	private JList listaClientes = new JList();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JVendaBilhete frame = new JVendaBilhete();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	@SuppressWarnings({ "unchecked", "static-access" })
	public JVendaBilhete() {
		super("Venda Bilhete");
		setBounds(100, 0, 458, 722);

		getContentPane().setLayout(null);

		txtVendaBilhete = new JTextField();
		txtVendaBilhete.setForeground(new Color(244, 164, 96));
		txtVendaBilhete.setBackground(new Color(70, 130, 180));
		txtVendaBilhete.setFont(tituloFonte);
		txtVendaBilhete.setText("\t       Venda Bilhete");
		txtVendaBilhete.setBounds(0, 0, 434, 56);
		getContentPane().add(txtVendaBilhete);
		txtVendaBilhete.setColumns(10);

		txtTitulo = new JTextField();
		txtTitulo.setForeground(new Color(255, 140, 0));
		txtTitulo.setBackground(new Color(255, 255, 255));
		txtTitulo.setFont(regularFonte);
		txtTitulo.setText("T\u00EDtulo");
		txtTitulo.setBounds(10, 66, 53, 20);
		getContentPane().add(txtTitulo);
		txtTitulo.setColumns(10);

		cpTitulo = new JTextField();
		cpTitulo.setBounds(119, 66, 142, 20);
		getContentPane().add(cpTitulo);
		cpTitulo.setColumns(10);

		txtData = new JTextField();
		txtData.setText("Data da Sess\u00E3o");
		txtData.setForeground(new Color(255, 140, 0));
		txtData.setFont(regularFonte);
		txtData.setColumns(10);
		txtData.setBackground(Color.WHITE);
		txtData.setBounds(0, 110, 109, 20);
		getContentPane().add(txtData);

		cpData = new JFormattedTextField(new DateUtils().getToday());
		cpData.setColumns(10);
		cpData.setInputVerifier(new RegExFieldVerifier("\\d{2}/\\d{2}/\\d{4}"));
		cpData.setBounds(119, 110, 142, 20);
		getContentPane().add(cpData);

		try {
			MaskFormatter dataMask = new MaskFormatter("##/##/####");
			dataMask.install(cpData);
		} catch (ParseException err) {}

		// Tecnologia fake que representa todas as tecnologias
		TecnologiaEntity fakeTecnologia = new TecnologiaEntity();
		fakeTecnologia.setTecnologiaId(Long.valueOf(-1));
		fakeTecnologia.setNome("Todas");
		tecnologias = objBilheteria.listaTecnologia();
		tecnologias.add(fakeTecnologia);
		dropTecnologias = new JComboBox(tecnologias.toArray());
		// seleciona "Todas" por padrão
		dropTecnologias.setSelectedItem(tecnologias.get(3));
		dropTecnologias.setBounds(278, 92, 86, 20);
		getContentPane().add(dropTecnologias);

		rdPol = new JRadioButton("Polarizado");
		rdPol.setForeground(new Color(0, 102, 0));
		rdPol.setFont(tituloFonte);
		rdPol.setBounds(289, 618, 120, 23);
		getContentPane().add(rdPol);

		rdNormal = new JRadioButton("Normal");
		rdNormal.setForeground(new Color(153, 0, 0));
		rdNormal.setFont(tituloFonte);
		rdNormal.setBounds(44, 620, 83, 23);
		getContentPane().add(rdNormal);

		rbP4d = new JRadioButton("4D Max");
		rbP4d.setForeground(new Color(0, 102, 0));
		rbP4d.setFont(tituloFonte);
		rbP4d.setBounds(291, 557, 105, 23);
		getContentPane().add(rbP4d);

		rbPNormal = new JRadioButton("Normal");
		rbPNormal.setForeground(new Color(153, 0, 0));
		rbPNormal.setFont(tituloFonte);
		rbPNormal.setBounds(49, 557, 83, 23);
		getContentPane().add(rbPNormal);

		btnPesquisaSessao = new JButton("Pesquisar");
		btnPesquisaSessao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Pattern patternData = Pattern.compile("(\\d{2})/(\\d{2})/(\\d{4})");

				Matcher matchDataInicio = patternData.matcher(cpData.getText());
				matchDataInicio.find();
				Date data= Date.valueOf(matchDataInicio.group(3) + "-" + matchDataInicio.group(2) + "-" + matchDataInicio.group(1));

				List<SessaoEntity> sessoes = objBilheteria.procuraSessao(
						cpTitulo.getText(),
						data,
						((TecnologiaEntity) dropTecnologias.getSelectedItem()).getTecnologiaId());

				listaSessoes.setListData(sessoes.toArray());
			}
		});
		btnPesquisaSessao.setFont(tituloFonte);
		btnPesquisaSessao.setForeground(new Color(210, 105, 30));
		btnPesquisaSessao.setBounds(115, 250, 189, 23);
		getContentPane().add(btnPesquisaSessao);

		btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Pattern patternData = Pattern.compile("(\\d{2})/(\\d{2})/(\\d{4})");

				Matcher matchDataInicio = patternData.matcher(cpData.getText());
				matchDataInicio.find();
				Date data= Date.valueOf(matchDataInicio.group(3) + "-" + matchDataInicio.group(2) + "-" + matchDataInicio.group(1));

				List<SessaoEntity> sessoes = objBilheteria.procuraSessao(
					  cpTitulo.getText(),
					  data,
					  ((TecnologiaEntity) dropTecnologias.getSelectedItem()).getTecnologiaId());


				listaSessoes.setListData(sessoes.toArray());
			}
		});
		btnSalvar.setFont(tituloFonte);
		btnSalvar.setForeground(new Color(210, 105, 30));
		btnSalvar.setBounds(155, 649, 89, 23);
		getContentPane().add(btnSalvar);

		txtTecnologia = new JTextField();
		txtTecnologia.setSelectionColor(new Color(32, 178, 170));
		txtTecnologia.setText("Tecnologia");
		txtTecnologia.setForeground(new Color(244, 164, 96));
		txtTecnologia.setFont(tituloFonte);
		txtTecnologia.setColumns(10);
		txtTecnologia.setBackground(new Color(105, 105, 105));
		txtTecnologia.setBounds(268, 67, 166, 20);
		getContentPane().add(txtTecnologia);

		txtDadosCliente = new JTextField();
		txtDadosCliente.setText("\t        Dados Cliente");
		txtDadosCliente.setSelectionColor(new Color(32, 178, 170));
		txtDadosCliente.setForeground(new Color(244, 164, 96));
		txtDadosCliente.setFont(tituloFonte);
		txtDadosCliente.setColumns(10);
		txtDadosCliente.setBackground(SystemColor.controlDkShadow);
		txtDadosCliente.setBounds(0, 295, 434, 20);
		getContentPane().add(txtDadosCliente);

		txtNomeCpf = new JTextField();
		txtNomeCpf.setText("Nome/CPF");
		txtNomeCpf.setForeground(new Color(255, 140, 0));
		txtNomeCpf.setFont(regularFonte);
		txtNomeCpf.setColumns(10);
		txtNomeCpf.setBackground(Color.WHITE);
		txtNomeCpf.setBounds(22, 326, 73, 20);
		getContentPane().add(txtNomeCpf);

		cpNomeCpf = new JTextField();
		cpNomeCpf.setColumns(10);
		cpNomeCpf.setBounds(95, 326, 284, 20);
		getContentPane().add(cpNomeCpf);

		ButtonGroup buttonGroup3 = new javax.swing.ButtonGroup();
		buttonGroup3.add(rbP4d);
		buttonGroup3.add(rbPNormal);

		rbONormal = new JRadioButton("Normal");
		rbONormal.setForeground(new Color(153, 0, 0));
		rbONormal.setFont(tituloFonte);
		rbONormal.setBounds(70, 482, 83, 23);

		txtPoltrona = new JTextField();
		txtPoltrona.setText("\t               Poltrona");
		txtPoltrona.setSelectionColor(new Color(32, 178, 170));
		txtPoltrona.setForeground(new Color(244, 164, 96));
		txtPoltrona.setFont(tituloFonte);
		txtPoltrona.setColumns(10);
		txtPoltrona.setBackground(SystemColor.controlDkShadow);
		txtPoltrona.setBounds(0, 530, 434, 20);
		getContentPane().add(txtPoltrona);

		txtculos = new JTextField();
		txtculos.setText("\t             Óculos");
		txtculos.setSelectionColor(new Color(32, 178, 170));
		txtculos.setForeground(new Color(244, 164, 96));
		txtculos.setFont(tituloFonte);
		txtculos.setColumns(10);
		txtculos.setBackground(SystemColor.controlDkShadow);
		txtculos.setBounds(0, 591, 434, 20);
		getContentPane().add(txtculos);

		ButtonGroup buttonGroup4 = new javax.swing.ButtonGroup();
		buttonGroup3.add(rdNormal);
		buttonGroup3.add(rdPol);

		listaSessoes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 164, 420, 56);
		scrollPane.setViewportView(listaSessoes);
		getContentPane().add(scrollPane);

		textField = new JTextField();
		textField.setBorder(new TitledBorder(null, "Sess\u00F5es Dispon\u00EDveis", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		textField.setText("Data da Sess\u00E3o");
		textField.setForeground(new Color(255, 140, 0));
		textField.setFont(regularFonte);
		textField.setColumns(10);
		textField.setBackground(Color.WHITE);
		textField.setBounds(0, 145, 122, 20);
		getContentPane().add(textField);

		JButton btnInserirNovoCliente = new JButton("Inserir novo cliente");
		btnInserirNovoCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//JCadastroCliente cadCliente = new JCadastroCliente();
				//cadCliente.setVisible(true);

			}
		});
		btnInserirNovoCliente.setForeground(new Color(210, 105, 30));
		btnInserirNovoCliente.setFont(new Font("Yu Gothic", Font.BOLD, 16));
		btnInserirNovoCliente.setBounds(77, 506, 284, 23);
		getContentPane().add(btnInserirNovoCliente);

		listaClientes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		JScrollPane scrollPaneCliente = new JScrollPane();
		scrollPaneCliente.setBounds(10, 394, 420, 56);
		scrollPaneCliente.setViewportView(listaClientes);
		getContentPane().add(scrollPaneCliente);

		btnPesquisaCliente = new JButton("Pesquisar");
		btnPesquisaCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				List<ClienteEntity> clientes = objBilheteria.procuraCliente(
						cpNomeCpf.getText()
				);

				listaClientes.setListData(clientes.toArray());
			}
		});
		btnPesquisaCliente.setForeground(new Color(210, 105, 30));
		btnPesquisaCliente.setFont(tituloFonte);
		btnPesquisaCliente.setBounds(115, 472, 189, 23);
		getContentPane().add(btnPesquisaCliente);

		txtCliente = new JTextField();
		txtCliente.setForeground(new Color(255, 140, 0));
		txtCliente.setFont(regularFonte);
		txtCliente.setColumns(10);
		txtCliente.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Clientes", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		txtCliente.setBackground(Color.WHITE);
		txtCliente.setBounds(6, 364, 122, 20);
		getContentPane().add(txtCliente);



	}
}

