package view;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.Font;
import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.Color;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JRadioButton;
import javax.swing.JToggleButton;

import controller.BilheteriaBiz;
import model.Sessao;
import utils.LtpLib;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JCadastraSessao extends JFrame {
	private JTextField txtCadastroSesso;
	private JTextField txtTtulo;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textTitulo;
	private JTextField textDuracao;
	private JTextField textLancamento;
	private JTextField textClasInd;
	private JTextField textGenero;
	private JTextField textHorario;
	private JTextField txtTipoPoltrona;
	private JTextField txtTipoTecnologia;
	private ButtonGroup buttonGroup1;
	private ButtonGroup buttonGroup2;
	
	private BilheteriaBiz objBilheteria = new BilheteriaBiz();
	private LtpLib objLib = new LtpLib();
	private JButton btnSalvar;
	private JTextField txtDataInicio;
	private JTextField textDtInicio;
	private JTextField textDtFim;
	private JTextField txtDataFim;
	private JTextField txtTipoculos;
	private JRadioButton rdONormal;
	private JRadioButton rbO4d;
	
	public JCadastraSessao() {
		getContentPane().setBackground(new Color(153, 153, 102));
		try {
			if(new File("Sessao.obj").exists()) {
				objBilheteria.setSessoesCadastradas(objLib.lerArquivoObjetos("Sessao.obj"));
			}
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		setBounds(100, 100, 503, 605);
		getContentPane().setLayout(null);
		
		txtCadastroSesso = new JTextField();
		txtCadastroSesso.setForeground(new Color(255, 255, 0));
		txtCadastroSesso.setBackground(new Color(0, 0, 0));
		txtCadastroSesso.setSelectedTextColor(new Color(102, 51, 0));
		txtCadastroSesso.setFont(new Font("Yu Gothic", Font.BOLD, 13));
		txtCadastroSesso.setText("\t              \t  Cadastro Sess\u00E3o");
		txtCadastroSesso.setBounds(0, 0, 508, 31);
		getContentPane().add(txtCadastroSesso);
		txtCadastroSesso.setColumns(10);
		
		txtTtulo = new JTextField();
		txtTtulo.setDisabledTextColor(new Color(255, 0, 51));
		txtTtulo.setBackground(new Color(0, 51, 102));
		txtTtulo.setForeground(new Color(255, 255, 255));
		txtTtulo.setFont(new Font("Yu Gothic Light", Font.BOLD, 13));
		txtTtulo.setText("T\u00EDtulo");
		txtTtulo.setBounds(10, 42, 167, 20);
		getContentPane().add(txtTtulo);
		txtTtulo.setColumns(10);
		
		textField = new JTextField();
		textField.setText("Dura��o");
		textField.setForeground(Color.WHITE);
		textField.setFont(new Font("Yu Gothic Light", Font.BOLD, 13));
		textField.setDisabledTextColor(new Color(255, 0, 51));
		textField.setColumns(10);
		textField.setBackground(new Color(0, 51, 102));
		textField.setBounds(10, 73, 167, 20);
		getContentPane().add(textField);
		
		textField_1 = new JTextField();
		textField_1.setText("Ano lan�amento");
		textField_1.setForeground(Color.WHITE);
		textField_1.setFont(new Font("Yu Gothic Light", Font.BOLD, 13));
		textField_1.setDisabledTextColor(new Color(255, 0, 51));
		textField_1.setColumns(10);
		textField_1.setBackground(new Color(0, 51, 102));
		textField_1.setBounds(10, 104, 167, 20);
		getContentPane().add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setText("Classifica��o Indicativa");
		textField_2.setForeground(Color.WHITE);
		textField_2.setFont(new Font("Yu Gothic Light", Font.BOLD, 13));
		textField_2.setDisabledTextColor(new Color(255, 0, 51));
		textField_2.setColumns(10);
		textField_2.setBackground(new Color(0, 51, 102));
		textField_2.setBounds(10, 140, 167, 20);
		getContentPane().add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setText("G�nero");
		textField_3.setForeground(Color.WHITE);
		textField_3.setFont(new Font("Yu Gothic Light", Font.BOLD, 13));
		textField_3.setDisabledTextColor(new Color(255, 0, 51));
		textField_3.setColumns(10);
		textField_3.setBackground(new Color(0, 51, 102));
		textField_3.setBounds(10, 170, 167, 20);
		getContentPane().add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setText("Hor�rio");
		textField_4.setForeground(Color.WHITE);
		textField_4.setFont(new Font("Yu Gothic Light", Font.BOLD, 13));
		textField_4.setDisabledTextColor(new Color(255, 0, 51));
		textField_4.setColumns(10);
		textField_4.setBackground(new Color(0, 51, 102));
		textField_4.setBounds(10, 201, 167, 20);
		getContentPane().add(textField_4);
		
		textTitulo = new JTextField();
		textTitulo.setColumns(10);
		textTitulo.setBounds(196, 42, 154, 20);
		getContentPane().add(textTitulo);
		
		textDuracao = new JTextField();
		textDuracao.setBounds(196, 73, 154, 20);
		getContentPane().add(textDuracao);
		textDuracao.setColumns(10);
		
		textLancamento = new JTextField();
		textLancamento.setColumns(10);
		textLancamento.setBounds(196, 104, 154, 20);
		getContentPane().add(textLancamento);
		
		textClasInd = new JTextField();
		textClasInd.setColumns(10);
		textClasInd.setBounds(196, 140, 154, 20);
		getContentPane().add(textClasInd);
		
		textGenero = new JTextField();
		textGenero.setColumns(10);
		textGenero.setBounds(196, 170, 154, 20);
		getContentPane().add(textGenero);
		
		textHorario = new JTextField();
		textHorario.setColumns(10);
		textHorario.setBounds(196, 201, 154, 20);
		getContentPane().add(textHorario);
		
		txtTipoPoltrona = new JTextField();
		txtTipoPoltrona.setText("\t              \t  Tipo Poltrona ");
		txtTipoPoltrona.setSelectedTextColor(new Color(102, 51, 0));
		txtTipoPoltrona.setForeground(Color.YELLOW);
		txtTipoPoltrona.setFont(new Font("Yu Gothic", Font.BOLD, 13));
		txtTipoPoltrona.setColumns(10);
		txtTipoPoltrona.setBackground(Color.BLACK);
		txtTipoPoltrona.setBounds(0, 384, 487, 31);
		getContentPane().add(txtTipoPoltrona);
		
		txtTipoTecnologia = new JTextField();
		txtTipoTecnologia.setText("\t              \t  Tipo Tecnologia");
		txtTipoTecnologia.setSelectedTextColor(new Color(102, 51, 0));
		txtTipoTecnologia.setForeground(Color.YELLOW);
		txtTipoTecnologia.setFont(new Font("Yu Gothic", Font.BOLD, 13));
		txtTipoTecnologia.setColumns(10);
		txtTipoTecnologia.setBackground(Color.BLACK);
		txtTipoTecnologia.setBounds(0, 316, 487, 31);
		getContentPane().add(txtTipoTecnologia);
		
		JRadioButton rd3d = new JRadioButton("3D");
		rd3d.setFont(new Font("Yu Gothic", Font.BOLD, 16));
		rd3d.setForeground(new Color(153, 0, 0));
		rd3d.setBounds(110, 354, 83, 23);
		getContentPane().add(rd3d);
		
		JRadioButton rd4d = new JRadioButton("4D");
		rd4d.setForeground(new Color(0, 102, 0));
		rd4d.setFont(new Font("Yu Gothic", Font.BOLD, 16));
		rd4d.setBounds(315, 356, 105, 23);
		getContentPane().add(rd4d);
		
		JRadioButton rdMax = new JRadioButton("4D Max");
		rdMax.setForeground(new Color(0, 102, 0));
		rdMax.setFont(new Font("Yu Gothic", Font.BOLD, 16));
		rdMax.setBounds(315, 424, 105, 23);
		getContentPane().add(rdMax);
		
		JRadioButton rdNormal = new JRadioButton("Normal");
		rdNormal.setForeground(new Color(153, 0, 0));
		rdNormal.setFont(new Font("Yu Gothic", Font.BOLD, 16));
		rdNormal.setBounds(110, 422, 83, 23);
		getContentPane().add(rdNormal);
		buttonGroup1 = new javax.swing.ButtonGroup();
		buttonGroup1.add(rd3d);
		buttonGroup1.add(rd4d);
		buttonGroup2 = new javax.swing.ButtonGroup();
		buttonGroup2.add(rdNormal);
		buttonGroup2.add(rdMax);
		
		txtDataInicio = new JTextField();
		txtDataInicio.setText("Data Inicio");
		txtDataInicio.setForeground(new Color(0, 0, 0));
		txtDataInicio.setFont(new Font("Yu Gothic Light", Font.BOLD, 13));
		txtDataInicio.setDisabledTextColor(new Color(255, 0, 51));
		txtDataInicio.setColumns(10);
		txtDataInicio.setBackground(new Color(102, 204, 0));
		txtDataInicio.setBounds(10, 243, 167, 20);
		getContentPane().add(txtDataInicio);
		
		textDtInicio = new JTextField();
		textDtInicio.setColumns(10);
		textDtInicio.setBounds(196, 243, 154, 20);
		getContentPane().add(textDtInicio);
		
		textDtFim = new JTextField();
		textDtFim.setColumns(10);
		textDtFim.setBounds(196, 285, 154, 20);
		getContentPane().add(textDtFim);
		
		txtDataFim = new JTextField();
		txtDataFim.setText("Data Fim");
		txtDataFim.setForeground(new Color(204, 204, 0));
		txtDataFim.setFont(new Font("Yu Gothic Light", Font.BOLD, 13));
		txtDataFim.setDisabledTextColor(new Color(255, 0, 51));
		txtDataFim.setColumns(10);
		txtDataFim.setBackground(new Color(255, 102, 153));
		txtDataFim.setBounds(10, 285, 167, 20);
		getContentPane().add(txtDataFim);
		Boolean validaData = false;
		Boolean validaFim = false;
		String dataInicio;
		String dataFim;
		
		btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String titulo = textTitulo.getText();
				int duracao = Integer.parseInt(textDuracao.getText());
				int anoLancamento = Integer.parseInt(textLancamento.getText());
				int indicativa = Integer.parseInt(textClasInd.getText());
				String genero = textGenero.getText();
				int horario  = Integer.parseInt(textHorario.getText());

				
				try {
					objLib.gravarArquivoObjetos("Sessao.obj", objBilheteria.getSessoesCadastradas());
					JOptionPane.showMessageDialog(null, "Cadastrado com sucesso!");
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "Gerente n�o cadastrado!!");
				}	
			
			}
		});
		btnSalvar.setFont(new Font("Yu Gothic", Font.BOLD, 16));
		btnSalvar.setBounds(210, 532, 89, 23);
		getContentPane().add(btnSalvar);
		
		txtTipoculos = new JTextField();
		txtTipoculos.setText("\t              \t  Tipo \u00F3culos");
		txtTipoculos.setSelectedTextColor(new Color(102, 51, 0));
		txtTipoculos.setForeground(Color.YELLOW);
		txtTipoculos.setFont(new Font("Yu Gothic", Font.BOLD, 13));
		txtTipoculos.setColumns(10);
		txtTipoculos.setBackground(Color.BLACK);
		txtTipoculos.setBounds(0, 458, 487, 31);
		getContentPane().add(txtTipoculos);
		
		rdONormal = new JRadioButton("Normal");
		rdONormal.setForeground(new Color(153, 0, 0));
		rdONormal.setFont(new Font("Yu Gothic", Font.BOLD, 16));
		rdONormal.setBounds(110, 496, 83, 23);
		getContentPane().add(rdONormal);
		
		rbO4d = new JRadioButton("Polarizado");
		rbO4d.setForeground(new Color(0, 102, 0));
		rbO4d.setFont(new Font("Yu Gothic", Font.BOLD, 16));
		rbO4d.setBounds(315, 498, 120, 23);
		getContentPane().add(rbO4d);
		


		
	
	}

}
