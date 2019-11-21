package view;

import controller.BilheteriaBiz;
import model.FilmeEntity;
import model.SalaEntity;
import model.TecnologiaEntity;
import utils.RegExFieldVerifier;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Time;
import java.text.ParseException;
import java.util.*;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JCadastroSessao extends JFrame {

	private JPanel contentPane;
	private JTextField txtTitulo;
	private JComboBox dropSalas;
	private JComboBox dropTecnologias;
	private JFormattedTextField txtDataInicio;
	private JFormattedTextField txtDataFim;
	private JFormattedTextField txtHorario;
	private JTextField txtValor;
	private JList listaFilmes = new JList();
	private JRadioButton radioDublado;
	private JRadioButton radioLegendado;
	private BilheteriaBiz objBilheteria = new BilheteriaBiz();
	private List<SalaEntity> salas;
	private List<TecnologiaEntity> tecnologias;

	/**
	 * Create the frame.
	 */
	@SuppressWarnings({ "unchecked", "static-access" })
	public JCadastroSessao(){
		super("Cadastro Sessão");

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 581, 488);
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

		JLabel lblSala = new JLabel("Sala");
		lblSala.setBounds(10, 166, 146, 14);
		panel.add(lblSala);

		dropSalas = new JComboBox(salas.toArray());
		dropSalas.setBounds(166, 163, 86, 20);
		panel.add(dropSalas);

		JLabel lblDataInicio = new JLabel("Data início");
		lblDataInicio.setBounds(10, 205, 146, 14);
		panel.add(lblDataInicio);

		txtDataInicio = new JFormattedTextField();
		txtDataInicio.setBounds(166, 205, 146, 20);
		txtDataInicio.setInputVerifier(new RegExFieldVerifier("\\d{2}/\\d{2}/\\d{4}"));
		panel.add(txtDataInicio);
		txtDataInicio.setColumns(10);

		try {
			MaskFormatter dataMask = new MaskFormatter("##/##/####");
			dataMask.install(txtDataInicio);
		} catch (ParseException err) {}


		JLabel lblDataFim = new JLabel("Data fim");
		lblDataFim.setBounds(10, 239, 146, 14);
		panel.add(lblDataFim);

		txtDataFim = new JFormattedTextField();
		txtDataFim.setBounds(166, 239, 146, 20);
		txtDataFim.setInputVerifier(new RegExFieldVerifier("\\d{2}/\\d{2}/\\d{4}"));
		panel.add(txtDataFim);
		txtDataFim.setColumns(10);

		try {
			MaskFormatter dataMask = new MaskFormatter("##/##/####");
			dataMask.install(txtDataFim);
		} catch (ParseException err) {}

		JLabel lblHorario = new JLabel("Horário");
		lblHorario.setBounds(10, 275, 146, 14);
		panel.add(lblHorario);

		txtHorario = new JFormattedTextField();
		txtHorario.setBounds(166, 270, 146, 20);
		txtHorario.setInputVerifier(new RegExFieldVerifier("\\d{2}:\\d{2}"));
		panel.add(txtHorario);
		txtHorario.setColumns(10);

		try {
			MaskFormatter dataMask = new MaskFormatter("##:##");
			dataMask.install(txtHorario);
		} catch (ParseException err) {}


		JLabel lblValor = new JLabel("Valor (R$)");
		lblValor.setBounds(10, 300, 146, 14);
		panel.add(lblValor);

		txtValor = new JTextField();
		txtValor.setBounds(166, 300, 146, 20);
		panel.add(txtValor);
		txtValor.setColumns(10);

		radioDublado = new JRadioButton("Dublado", true);
		radioDublado.setBounds(10, 330, 83, 23);
		panel.add(radioDublado);

		radioLegendado = new JRadioButton("Legendado");
		radioLegendado.setBounds(110, 330, 83, 23);
		panel.add(radioLegendado);

		final ButtonGroup radioGroup = new ButtonGroup();
		radioGroup.add(radioDublado);
		radioGroup.add(radioLegendado);

		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			@SuppressWarnings("static-access")
			public void actionPerformed(ActionEvent arg0) {
				Pattern patternData = Pattern.compile("(\\d{2})/(\\d{2})/(\\d{4})");

				Matcher matchDataInicio = patternData.matcher(txtDataInicio.getText());
				matchDataInicio.find();
				Date dataInicio = Date.valueOf(matchDataInicio.group(3) + "-" + matchDataInicio.group(2) + "-" + matchDataInicio.group(1));

				Matcher matchDataFim = patternData.matcher(txtDataFim.getText());
				matchDataFim.find();
				Date dataFim = Date.valueOf(matchDataFim.group(3) + "-" + matchDataFim.group(2) + "-" + matchDataFim.group(1));

				Time hora = Time.valueOf(txtHorario.getText() + ":00");

				objBilheteria.cadastrarSessao(
						((SalaEntity) dropSalas.getSelectedItem()).getSalaId(),
						((FilmeEntity) listaFilmes.getSelectedValue()).getFilmeId(),
						((TecnologiaEntity) dropTecnologias.getSelectedItem()).getTecnologiaId(),
						dataInicio,
						dataFim,
						hora,
						new BigDecimal(txtValor.getText()),
						radioLegendado.isSelected()
				);

				JOptionPane.showMessageDialog(null, "Cadastrado com sucesso!");
			}
		});
		btnSalvar.setBounds(63, 390, 89, 23);
		panel.add(btnSalvar);
	}
}
