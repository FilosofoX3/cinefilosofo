package view;

import controller.BilheteriaBiz;
import model.VendedorEntity;
import utils.RegExFieldVerifier;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.text.MaskFormatter;
import java.awt.*;
import java.math.BigDecimal;
import java.sql.Date;
import java.text.ParseException;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class JRelatorio extends JFrame {

	private JPanel contentPane;
	private JComboBox dropVendedor;
	private JFormattedTextField txtDataInicio;
	private JFormattedTextField txtDataFim;
	private JLabel lblVendedor;
	private JLabel lblDataInicio;
	private JLabel lblDataFim;

	private BilheteriaBiz objBilheteria = new BilheteriaBiz();


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JRelatorio frame = new JRelatorio();
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
	public JRelatorio() {
		super("Busca filme");

		setBounds(100, 100, 480, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		final JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		lblVendedor = new JLabel("Vendedor");
		lblVendedor.setBounds(25, 21, 245, 20);
		panel.add(lblVendedor);

		List<VendedorEntity> vendedores = objBilheteria.listaVendedor();
		dropVendedor = new JComboBox(vendedores.toArray());
		dropVendedor.setBounds(206, 21, 213, 20);
		panel.add(dropVendedor);

		lblDataInicio = new JLabel("Data início");
		lblDataInicio.setBounds(25, 61, 245, 20);
		panel.add(lblDataInicio);

		txtDataInicio = new JFormattedTextField();
		txtDataInicio.setInputVerifier(new RegExFieldVerifier("([0-2][0-9]|3[0-1])/(0[1-9]|1[0-2])/(19|20)\\d{2}"));
		txtDataInicio.setBounds(206, 61, 213, 20);
		panel.add(txtDataInicio);
		txtDataInicio.setColumns(10);

		try {
			MaskFormatter dataMask = new MaskFormatter("##/##/####");
			dataMask.install(txtDataInicio);
		} catch (ParseException err) {}

		lblDataFim = new JLabel("DataFim");
		lblDataFim.setBounds(25, 101, 245, 20);
		panel.add(lblDataFim);

		txtDataFim = new JFormattedTextField();
		txtDataFim.setInputVerifier(new RegExFieldVerifier("([0-2][0-9]|3[0-1])/(0[1-9]|1[0-2])/(19|20)\\d{2}"));
		txtDataFim.setBounds(206,101, 213, 20);
		panel.add(txtDataFim);
		txtDataFim.setColumns(10);

		try {
			MaskFormatter dataMask = new MaskFormatter("##/##/####");
			dataMask.install(txtDataFim);
		} catch (ParseException err) {}

		JTextField lblResultado = new JTextField();
		lblResultado.setForeground(new Color(255, 140, 0));
		lblResultado.setFont(new Font("Yu Gothic", Font.BOLD, 14));
		lblResultado.setColumns(10);
		lblResultado.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Valor (R$)", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		lblResultado.setBounds(206, 135, 215, 20);
		panel.add(lblResultado);

		JLabel resultado = new JLabel();
		resultado.setBounds(206, 161, 215, 20);
		resultado.setOpaque(true);
		resultado.setBackground(Color.WHITE);
		panel.add(resultado);

		JButton btnPesquisa = new JButton("Pesquisa");
		btnPesquisa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Pattern patternData = Pattern.compile("([0-2][0-9]|3[0-1])/(0[0-9]|1[0-2])/(\\d{4})");

				Matcher matchDataInicio = patternData.matcher(txtDataInicio.getText());
				matchDataInicio.find();
				Date dataInicio = Date.valueOf(matchDataInicio.group(3) + "-" + matchDataInicio.group(2) + "-" + matchDataInicio.group(1));

				Matcher matchDataFim = patternData.matcher(txtDataFim.getText());
				matchDataFim.find();
				System.out.println(matchDataFim.group(3));
				System.out.println(matchDataFim.group(2));
				System.out.println(matchDataFim.group(1));
				Date dataFim = Date.valueOf(matchDataFim.group(3) + "-" + matchDataFim.group(2) + "-" + matchDataFim.group(1));


				BigDecimal valorVendido = objBilheteria.getTotalVendido(
						((VendedorEntity) dropVendedor.getSelectedItem()).getVendedorId(),
						dataInicio,
						dataFim
				);

				if (valorVendido != null)
					 resultado.setText(valorVendido.toString());
				else
					 resultado.setText("0.00");
			}
		});

		btnPesquisa.setBounds(206, 202, 213, 23);
		panel.add(btnPesquisa);
	}
}
