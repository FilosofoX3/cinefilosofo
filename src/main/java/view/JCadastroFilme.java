package view;

import controller.BilheteriaBiz;
import model.ClassificacaoEntity;
import model.GeneroEntity;
import utils.LtpLib;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.List;

public class JCadastroFilme extends JFrame {

	private JPanel contentPane;
	private JTextField txtTitulo;
	private JComboBox dropGenero; // Dropdown
	private JComboBox dropClassificacao; // Dropdown
	private JTextField txtAnoLancamento;
	private JTextField txtDuracaoMinutos;
	private JTextField txtDuracaoHoras;
	private BilheteriaBiz objBilheteria = new BilheteriaBiz();
	private LtpLib objLib = new LtpLib();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JCadastroFilme frame = new JCadastroFilme();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	@SuppressWarnings({ "unchecked", "static-access" })
	public JCadastroFilme() {
		super("Cadastro filme");

		setBounds(100, 100, 281, 298);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblTitulo = new JLabel("Titulo");
		lblTitulo.setBounds(10, 11, 96, 14);
		panel.add(lblTitulo);
		
		txtTitulo = new JTextField();
		txtTitulo.setBounds(120, 8, 86, 20);
		panel.add(txtTitulo);
		txtTitulo.setColumns(10);
		
		JLabel lblGenero = new JLabel("Gênero");
		lblGenero.setBounds(10, 36, 96, 14);
		panel.add(lblGenero);

		List <GeneroEntity> generos = objBilheteria.listaGenero();
		dropGenero = new JComboBox(generos.toArray());
		dropGenero.setVisible(true);
		dropGenero.setBounds(120, 33, 86, 20);
		panel.add(dropGenero);

		JLabel lblClassificacao = new JLabel("Classificação");
		lblClassificacao.setBounds(10, 70, 96, 14);
		panel.add(lblClassificacao);

		List <ClassificacaoEntity> classificacoes = objBilheteria.listaClassificacao();
		dropClassificacao = new JComboBox(classificacoes.toArray());
		dropClassificacao.setBounds(120, 64, 86, 20);
		panel.add(dropClassificacao);

		JLabel lblDuracaoMinutos = new JLabel("Duração (min)");
		lblDuracaoMinutos.setBounds(10, 105, 106, 14);
		panel.add(lblDuracaoMinutos);
		
		txtDuracaoMinutos = new JTextField();
		txtDuracaoMinutos.setBounds(120, 102, 86, 20);
		panel.add(txtDuracaoMinutos);
		txtDuracaoMinutos.setColumns(10);

		JLabel lblAnoLancamento = new JLabel("Ano" );
		lblAnoLancamento.setBounds(10, 179, 96, 14);
		panel.add(lblAnoLancamento);

		txtAnoLancamento = new JTextField();
		txtAnoLancamento.setBounds(120, 176, 86, 20);
		panel.add(txtAnoLancamento);
		txtAnoLancamento.setColumns(10);

		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			@SuppressWarnings("static-access")
			public void actionPerformed(ActionEvent arg0) {
				Long filmeId = objBilheteria.cadastrarFilme(
						txtTitulo.getText(),
						((ClassificacaoEntity) dropClassificacao.getSelectedItem()).getClassificacaoId(),
						((GeneroEntity) dropGenero.getSelectedItem()).getGeneroId(),
						Integer.parseInt(txtDuracaoMinutos.getText()),
						Integer.parseInt(txtAnoLancamento.getText())
				);

				JOptionPane.showMessageDialog(null, "Cadastrado com sucesso!");
			}
		});
		btnSalvar.setBounds(63, 217, 89, 23);
		panel.add(btnSalvar);
	}
}
