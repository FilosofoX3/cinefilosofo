package view;

		import javax.swing.*;
		import java.awt.*;
		import java.math.BigDecimal;
		import java.sql.Date;
		import java.text.ParseException;

		import controller.BilheteriaBiz;
		import model.*;
		import utils.DateUtils;
		import utils.RegExFieldVerifier;

		import java.awt.event.ActionListener;
		import java.awt.event.ActionEvent;
		import java.util.List;
		import java.util.regex.Matcher;
		import java.util.regex.Pattern;
		import javax.swing.border.TitledBorder;
		import javax.swing.text.MaskFormatter;

public class JVendaBilhete extends JFrame{
	private BilheteriaBiz objBilheteria = new BilheteriaBiz();
	private JLabel txtVendaBilhete;
	private JTextField txtTitulo;
	private JTextField cpTitulo;
	private JTextField txtData;
	private JFormattedTextField cpData;
	private JButton btnSalvar;
	private JButton btnPesquisaSessao;
	private JButton btnPesquisaCliente;
	private JTextField txtTecnologia;
	private JLabel lblDadosCliente;
	private JLabel lblExtras;
	private JTextField txtNomeCpf;
	private JTextField cpNomeCpf;
	private JRadioButton rbP4d;
	private JRadioButton rbPNormal;
	private JRadioButton rdPol;
	private JRadioButton rdNormal;
	private JComboBox dropTecnologias;
	private JComboBox dropVendedores;
	private JTextField txtCliente;
	private Font tituloFonte = new Font("Yu Gothic", Font.BOLD, 16);
	private Font regularFonte = new Font("Yu Gothic", Font.BOLD, 13);
	private List<TecnologiaEntity> tecnologias;
	private List<VendedorEntity> vendedores;
	private JTextField txtSessao;
	private JList listaSessoes = new JList();
	private JList listaClientes = new JList();
	private JCheckBox chkMeiaEntrada;
	private JCheckBox chkOculosPolarizado;
	private JCheckBox chkPoltronaInteligente;

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

		txtVendaBilhete = new JLabel();
		txtVendaBilhete.setOpaque(true);
		txtVendaBilhete.setHorizontalAlignment(SwingConstants.CENTER);
		txtVendaBilhete.setVerticalAlignment(SwingConstants.CENTER);
		txtVendaBilhete.setForeground(new Color(244, 164, 96));
		txtVendaBilhete.setBackground(new Color(70, 130, 180));
		txtVendaBilhete.setFont(tituloFonte);
		txtVendaBilhete.setText("Venda Bilhete");
		txtVendaBilhete.setBounds(0, 0, 434, 56);
		getContentPane().add(txtVendaBilhete);

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
		cpData.setInputVerifier(new RegExFieldVerifier("([0-2][0-9]|3[0-1])/(0[1-9]|1[0-2])/(19|20)\\d{2}"));
		cpData.setBounds(119, 110, 142, 20);
		getContentPane().add(cpData);

		try {
			MaskFormatter dataMask = new MaskFormatter("##/##/####");
			dataMask.install(cpData);
		} catch (ParseException err) {}

		txtTecnologia = new JTextField();
		txtTecnologia.setSelectionColor(new Color(32, 178, 170));
		txtTecnologia.setText("Tecnologia");
		txtTecnologia.setForeground(new Color(244, 164, 96));
		txtTecnologia.setFont(tituloFonte);
		txtTecnologia.setColumns(10);
		txtTecnologia.setBackground(new Color(105, 105, 105));
		txtTecnologia.setBounds(268, 67, 166, 20);
		getContentPane().add(txtTecnologia);

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

		dropTecnologias.addActionListener (new ActionListener () {
			public void actionPerformed(ActionEvent e) {
			    TecnologiaEntity tecnologiaSelecionada = (TecnologiaEntity) dropTecnologias.getSelectedItem();

				if (tecnologiaSelecionada.getTecnologiaId() == -1 || tecnologiaSelecionada.getNome().equals("4D")) {
				    chkPoltronaInteligente.setVisible(true);
					chkOculosPolarizado.setVisible(true);
				}
				else if (tecnologiaSelecionada.getNome().equals("Tradicional")) {
					chkOculosPolarizado.setVisible(false);
				}
				else {
					chkPoltronaInteligente.setVisible(false);
				}
			}
		});

		txtSessao = new JTextField();
		txtSessao.setForeground(new Color(255, 140, 0));
		txtSessao.setFont(regularFonte);
		txtSessao.setColumns(10);
		txtSessao.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Sessões disponíveis", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		txtSessao.setBackground(Color.WHITE);
		txtSessao.setBounds(0, 140, 172, 20);
		getContentPane().add(txtSessao);

		listaSessoes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 164, 420, 56);
		scrollPane.setViewportView(listaSessoes);
		getContentPane().add(scrollPane);

		btnPesquisaSessao = new JButton("Pesquisar");
		btnPesquisaSessao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Pattern patternData = Pattern.compile("([0-2][0-9]|3[0-1])/(0[0-9]|1[0-2])/(\\d{4})");

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
		btnPesquisaSessao.setBounds(115, 230, 189, 23);
		getContentPane().add(btnPesquisaSessao);

		/*****************/
		/* DADOS CLIENTE */
		/*****************/

		lblDadosCliente = new JLabel();
		lblDadosCliente.setText("Dados Cliente");
		lblDadosCliente.setForeground(new Color(244, 164, 96));
		lblDadosCliente.setFont(tituloFonte);
		lblDadosCliente.setOpaque(true);
		lblDadosCliente.setHorizontalAlignment(JLabel.CENTER);
		lblDadosCliente.setVerticalAlignment(JLabel.CENTER);
		lblDadosCliente.setBackground(SystemColor.controlDkShadow);
		lblDadosCliente.setBounds(0, 275, 434, 30);
		getContentPane().add(lblDadosCliente);

		txtNomeCpf = new JTextField();
		txtNomeCpf.setText("Nome/CPF");
		txtNomeCpf.setForeground(new Color(255, 140, 0));
		txtNomeCpf.setFont(regularFonte);
		txtNomeCpf.setColumns(10);
		txtNomeCpf.setBackground(Color.WHITE);
		txtNomeCpf.setBounds(22, 316, 73, 20);
		getContentPane().add(txtNomeCpf);

		cpNomeCpf = new JTextField();
		cpNomeCpf.setColumns(10);
		cpNomeCpf.setBounds(95, 316, 284, 20);
		getContentPane().add(cpNomeCpf);

		txtCliente = new JTextField();
		txtCliente.setForeground(new Color(255, 140, 0));
		txtCliente.setFont(regularFonte);
		txtCliente.setColumns(10);
		txtCliente.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Clientes", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		txtCliente.setBackground(Color.WHITE);
		txtCliente.setBounds(6, 354, 122, 20);
		getContentPane().add(txtCliente);

		listaClientes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		JScrollPane scrollPaneCliente = new JScrollPane();
		scrollPaneCliente.setBounds(10, 384, 420, 56);
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
		btnPesquisaCliente.setBounds(115, 452, 189, 23);
		getContentPane().add(btnPesquisaCliente);

		JButton btnInserirNovoCliente = new JButton("Inserir novo cliente");
		btnInserirNovoCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			    JCadastroCliente clienteCadastro = new JCadastroCliente();
			    clienteCadastro.setVisible(true);
			}
		});

		btnInserirNovoCliente.setForeground(new Color(210, 105, 30));
		btnInserirNovoCliente.setFont(new Font("Yu Gothic", Font.BOLD, 16));
		btnInserirNovoCliente.setBounds(77, 486, 284, 23);
		getContentPane().add(btnInserirNovoCliente);

		/*****************/
		/* EXTRAS */
		/*****************/

		lblExtras = new JLabel();
		lblExtras.setText("Extras");
		lblExtras.setForeground(new Color(244, 164, 96));
		lblExtras.setFont(tituloFonte);
		lblExtras.setOpaque(true);
		lblExtras.setHorizontalAlignment(JTextField.CENTER);
		lblExtras.setVerticalAlignment(JTextField.CENTER);
		lblExtras.setBackground(SystemColor.controlDkShadow);
		lblExtras.setBounds(0, 520, 434, 30);
		getContentPane().add(lblExtras);

		vendedores = objBilheteria.listaVendedor();
		dropVendedores = new JComboBox(vendedores.toArray());
		dropVendedores.setBounds(300, 560, 86, 20);
		getContentPane().add(dropVendedores);

		chkMeiaEntrada = new JCheckBox("Meia entrada?");
		chkMeiaEntrada.setBounds(10, 560, 200, 20);
		chkMeiaEntrada.setFont(regularFonte);
		getContentPane().add(chkMeiaEntrada);

		chkOculosPolarizado = new JCheckBox("Óculos polarizado?");
		chkOculosPolarizado.setBounds(10, 585, 200, 20);
		chkOculosPolarizado.setFont(regularFonte);
		getContentPane().add(chkOculosPolarizado);

		chkPoltronaInteligente = new JCheckBox("Poltrona inteligente?");
		chkPoltronaInteligente.setBounds(10, 610, 200, 20);
		chkPoltronaInteligente.setFont(regularFonte);
		getContentPane().add(chkPoltronaInteligente);

		btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Pattern patternData = Pattern.compile("([0-2][0-9]|3[0-1])/(0[0-9]|1[0-2])/(\\d{4})");

				Matcher matchData= patternData.matcher(cpData.getText());
				matchData.find();
				Date data= Date.valueOf(matchData.group(3) + "-" + matchData.group(2) + "-" + matchData.group(1));

				SessaoEntity sessao = (SessaoEntity) listaSessoes.getSelectedValue();
				if (objBilheteria.getVagas(sessao.getSessaoId()) == 0){
					JOptionPane.showMessageDialog(null, "Poltronas esgotadas para esta sessão!");
					return;
				}
				Long bilheteId = objBilheteria.cadastrarBilhete(
					  ((SessaoEntity) listaSessoes.getSelectedValue()).getSessaoId(),
					  ((VendedorEntity) dropVendedores.getSelectedItem()).getVendedorId(),
					  ((ClienteEntity) listaClientes.getSelectedValue()).getClienteId(),
					  data,
					  chkMeiaEntrada.isSelected()
				);

				BigDecimal valorTotal = new BigDecimal(0);
				BigDecimal valorSessao = chkMeiaEntrada.isSelected() ?
						((SessaoEntity) listaSessoes.getSelectedValue()).getValor().divide(new BigDecimal(2)) :
						((SessaoEntity) listaSessoes.getSelectedValue()).getValor();

				valorTotal = valorTotal.add(valorSessao);

				if (chkOculosPolarizado.isSelected()) {
					ExtraEntity oculosPolarizado = objBilheteria.getExtra("Oculos ativo");
					objBilheteria.cadastrarBilheteExtra(
							oculosPolarizado.getExtraId(),
							bilheteId
					);
					valorTotal = valorTotal.add(oculosPolarizado.getPreco());
				}

				if (chkPoltronaInteligente.isSelected()) {
					ExtraEntity poltronaInteligente = objBilheteria.getExtra("Poltrona inteligente");
					objBilheteria.cadastrarBilheteExtra(
							poltronaInteligente.getExtraId(),
							bilheteId
					);
					valorTotal = valorTotal.add(poltronaInteligente.getPreco());
				}

				objBilheteria.cadastrarBilhetePreco(
						bilheteId,
						valorTotal
				);

				JOptionPane.showMessageDialog(null, "Cadastrado com sucesso!");
			}
		});
		btnSalvar.setFont(tituloFonte);
		btnSalvar.setForeground(new Color(210, 105, 30));
		btnSalvar.setBounds(155, 649, 89, 23);
		getContentPane().add(btnSalvar);
	}

}

