package view;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.Font;
import java.io.File;
import java.util.ArrayList;
import java.awt.Color;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controller.BilheteriaBiz;
import utilitarios.LtpLib;

import javax.swing.ListSelectionModel;
import java.awt.ComponentOrientation;
import java.awt.Container;

import javax.swing.border.BevelBorder;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;

public class JVendaBilhete extends JFrame{
	private BilheteriaBiz objBilheteria = new BilheteriaBiz();
	private LtpLib objLib = new LtpLib();
	private JTextField txtVendaBilhete;
	private JTextField txtTtulo;
	private JTextField cpTitulo;
	private JTextField txtData;
	private JTextField cpData;
	private JButton btnSalvar;
	private JComboBox dropCliente;
	private JTextField txtTecnlogia;
	private JTextField txtDesejaFazerA;
	private JRadioButton rdSim;
	private JRadioButton rdNao;
	private JTextField txtDadosCliente;
	private JTextField txtNome;
	private JTextField cpNome;
	private JTextField cpCpf;
	private JTextField txtCpf;
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
	private JTextField txtCliente;
	
	
@SuppressWarnings({ "unchecked", "static-access" })
	public JVendaBilhete() {
		super("Venda Bilhete");
		setBounds(100, 100, 458, 722);

		try {
			if (new File("BilhetesVendidos.obj").exists()) {
				objBilheteria.setListaFuncionario(objLib.lerArquivoObjetos("BilhetesVendidos.obj"));
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		getContentPane().setLayout(null);
		
		txtVendaBilhete = new JTextField();
		txtVendaBilhete.setForeground(new Color(244, 164, 96));
		txtVendaBilhete.setBackground(new Color(70, 130, 180));
		txtVendaBilhete.setFont(new Font("Yu Gothic", Font.BOLD, 16));
		txtVendaBilhete.setText("\t       Venda Bilhete");
		txtVendaBilhete.setBounds(0, 0, 434, 56);
		getContentPane().add(txtVendaBilhete);
		txtVendaBilhete.setColumns(10);
		
		txtTtulo = new JTextField();
		txtTtulo.setForeground(new Color(255, 140, 0));
		txtTtulo.setBackground(new Color(255, 255, 255));
		txtTtulo.setFont(new Font("Yu Gothic", Font.BOLD, 13));
		txtTtulo.setText("T\u00EDtulo");
		txtTtulo.setBounds(10, 66, 53, 20);
		getContentPane().add(txtTtulo);
		txtTtulo.setColumns(10);
		
		cpTitulo = new JTextField();
		cpTitulo.setBounds(119, 66, 142, 20);
		getContentPane().add(cpTitulo);
		cpTitulo.setColumns(10);
		
		txtData = new JTextField();
		txtData.setText("Data da Sess\u00E3o");
		txtData.setForeground(new Color(255, 140, 0));
		txtData.setFont(new Font("Yu Gothic", Font.BOLD, 13));
		txtData.setColumns(10);
		txtData.setBackground(Color.WHITE);
		txtData.setBounds(0, 110, 109, 20);
		getContentPane().add(txtData);
		
		cpData = new JTextField();
		cpData.setColumns(10);
		cpData.setBounds(119, 110, 142, 20);
		getContentPane().add(cpData);
		
		JRadioButton rb4d = new JRadioButton("4D");
		rb4d.setForeground(new Color(0, 102, 0));
		rb4d.setFont(new Font("Yu Gothic", Font.BOLD, 16));
		rb4d.setBounds(384, 92, 46, 23);
		getContentPane().add(rb4d);
		
		JRadioButton rb3d = new JRadioButton("3D");
		rb3d.setForeground(new Color(153, 0, 0));
		rb3d.setFont(new Font("Yu Gothic", Font.BOLD, 16));
		rb3d.setBounds(278, 92, 46, 23);
		getContentPane().add(rb3d);
		
		ButtonGroup buttonGroup2 = new javax.swing.ButtonGroup();
		buttonGroup2.add(rb3d);
		buttonGroup2.add(rb4d); 
		
		rdSim = new JRadioButton("Sim");
		rdSim.setForeground(new Color(153, 0, 0));
		rdSim.setFont(new Font("Yu Gothic", Font.BOLD, 16));
		rdSim.setBounds(66, 265, 62, 23);
		getContentPane().add(rdSim);
		
		rdNao = new JRadioButton("N\u00E3o");
		rdNao.setForeground(new Color(0, 102, 0));
		rdNao.setFont(new Font("Yu Gothic", Font.BOLD, 16));
		rdNao.setBounds(311, 267, 68, 23);
		getContentPane().add(rdNao);
		
		ButtonGroup buttonGroup1 = new javax.swing.ButtonGroup();
		buttonGroup1.add(rdSim);
		buttonGroup1.add(rdNao);

		
		rdPol = new JRadioButton("Polarizado");
		rdPol.setForeground(new Color(0, 102, 0));
		rdPol.setFont(new Font("Yu Gothic", Font.BOLD, 16));
		rdPol.setBounds(289, 618, 120, 23);
		getContentPane().add(rdPol);
		
		rdNormal = new JRadioButton("Normal");
		rdNormal.setForeground(new Color(153, 0, 0));
		rdNormal.setFont(new Font("Yu Gothic", Font.BOLD, 16));
		rdNormal.setBounds(44, 620, 83, 23);
		getContentPane().add(rdNormal);
		
		rbP4d = new JRadioButton("4D Max");
		rbP4d.setForeground(new Color(0, 102, 0));
		rbP4d.setFont(new Font("Yu Gothic", Font.BOLD, 16));
		rbP4d.setBounds(291, 557, 105, 23);
		getContentPane().add(rbP4d);
		
		rbPNormal = new JRadioButton("Normal");
		rbPNormal.setForeground(new Color(153, 0, 0));
		rbPNormal.setFont(new Font("Yu Gothic", Font.BOLD, 16));
		rbPNormal.setBounds(49, 557, 83, 23);
		getContentPane().add(rbPNormal);
		

		
		btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String titulo = cpTitulo.getText();
				String nome = cpNome.getText();
				String cpf = cpCpf.getText();
				boolean tec = false;
				if(rb4d.isSelected()) {
					tec = true;
				}
				else if(rb3d.isSelected()) {
					tec = false;
				}
	
				boolean meia  = false;
				if(rdSim.isSelected()) {
					meia = true;
				}
				else if(rdNao.isSelected()) {
					meia = false;
				}
		
				
				boolean poltrona  = false;
				if(rbP4d.isSelected()) {
					poltrona = true;
				}
				else if(rbPNormal.isSelected()) {
					poltrona = false;
				}

				
				boolean oculos  = false;
				if(rdPol.isSelected()) {
					poltrona = true;
				}
				else if(rbONormal.isSelected()) {
					poltrona = false;
				}
	
				
			//	objBilheteria.vendaBilhete(horaDesejada, meiaEntrada, poltronaInteligente, oculosAtivo, data, nome, cpf)
				
				try {
					objLib.gravarArquivoObjetos("BilhetesVendidos.obj", objBilheteria.getBilhetesVendidos());
					JOptionPane.showMessageDialog(null, "Venda Realizada!!");
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Erro ao vender!");
				}
				
			}
		});
		btnSalvar.setFont(new Font("Yu Gothic", Font.BOLD, 16));
		btnSalvar.setForeground(new Color(210, 105, 30));
		btnSalvar.setBounds(155, 649, 89, 23);
		getContentPane().add(btnSalvar);
		
		txtTecnlogia = new JTextField();
		txtTecnlogia.setSelectionColor(new Color(32, 178, 170));
		txtTecnlogia.setText("Tecnologia");
		txtTecnlogia.setForeground(new Color(244, 164, 96));
		txtTecnlogia.setFont(new Font("Yu Gothic", Font.BOLD, 16));
		txtTecnlogia.setColumns(10);
		txtTecnlogia.setBackground(new Color(105, 105, 105));
		txtTecnlogia.setBounds(268, 67, 166, 20);
		getContentPane().add(txtTecnlogia);
		
		txtDesejaFazerA = new JTextField();
		txtDesejaFazerA.setText("\tDeseja fazer a venda?");
		txtDesejaFazerA.setSelectionColor(new Color(32, 178, 170));
		txtDesejaFazerA.setForeground(new Color(244, 164, 96));
		txtDesejaFazerA.setFont(new Font("Yu Gothic", Font.BOLD, 16));
		txtDesejaFazerA.setColumns(10);
		txtDesejaFazerA.setBackground(SystemColor.controlDkShadow);
		txtDesejaFazerA.setBounds(0, 231, 434, 20);
		getContentPane().add(txtDesejaFazerA);

		txtDadosCliente = new JTextField();
		txtDadosCliente.setText("\t        Dados Cliente");
		txtDadosCliente.setSelectionColor(new Color(32, 178, 170));
		txtDadosCliente.setForeground(new Color(244, 164, 96));
		txtDadosCliente.setFont(new Font("Yu Gothic", Font.BOLD, 16));
		txtDadosCliente.setColumns(10);
		txtDadosCliente.setBackground(SystemColor.controlDkShadow);
		txtDadosCliente.setBounds(0, 295, 434, 20);
		getContentPane().add(txtDadosCliente);
		
		txtNome = new JTextField();
		txtNome.setText("Nome");
		txtNome.setForeground(new Color(255, 140, 0));
		txtNome.setFont(new Font("Yu Gothic", Font.BOLD, 13));
		txtNome.setColumns(10);
		txtNome.setBackground(Color.WHITE);
		txtNome.setBounds(22, 326, 53, 20);
		getContentPane().add(txtNome);
		
		cpNome = new JTextField();
		cpNome.setColumns(10);
		cpNome.setBounds(95, 326, 284, 20);
		getContentPane().add(cpNome);
		
		cpCpf = new JTextField();
		cpCpf.setColumns(10);
		cpCpf.setBounds(95, 366, 284, 20);
		getContentPane().add(cpCpf);
		
		txtCpf = new JTextField();
		txtCpf.setText("Cpf");
		txtCpf.setForeground(new Color(255, 140, 0));
		txtCpf.setFont(new Font("Yu Gothic", Font.BOLD, 13));
		txtCpf.setColumns(10);
		txtCpf.setBackground(Color.WHITE);
		txtCpf.setBounds(22, 366, 53, 20);
		getContentPane().add(txtCpf);
		

		
		ButtonGroup buttonGroup3 = new javax.swing.ButtonGroup();
		buttonGroup3.add(rbP4d);
		buttonGroup3.add(rbPNormal);
		
		rbONormal = new JRadioButton("Normal");
		rbONormal.setForeground(new Color(153, 0, 0));
		rbONormal.setFont(new Font("Yu Gothic", Font.BOLD, 16));
		rbONormal.setBounds(70, 482, 83, 23);
		
		

		
		txtPoltrona = new JTextField();
		txtPoltrona.setText("\t               Poltrona");
		txtPoltrona.setSelectionColor(new Color(32, 178, 170));
		txtPoltrona.setForeground(new Color(244, 164, 96));
		txtPoltrona.setFont(new Font("Yu Gothic", Font.BOLD, 16));
		txtPoltrona.setColumns(10);
		txtPoltrona.setBackground(SystemColor.controlDkShadow);
		txtPoltrona.setBounds(0, 530, 434, 20);
		getContentPane().add(txtPoltrona);
		
		txtculos = new JTextField();
		txtculos.setText("\t             \u00D3culos");
		txtculos.setSelectionColor(new Color(32, 178, 170));
		txtculos.setForeground(new Color(244, 164, 96));
		txtculos.setFont(new Font("Yu Gothic", Font.BOLD, 16));
		txtculos.setColumns(10);
		txtculos.setBackground(SystemColor.controlDkShadow);
		txtculos.setBounds(0, 591, 434, 20);
		getContentPane().add(txtculos);
	
		ButtonGroup buttonGroup4 = new javax.swing.ButtonGroup();
		buttonGroup3.add(rdNormal);
		buttonGroup3.add(rdPol);
		
		//ComboBox de sessao
		ArrayList sessao = null; // somente para nao da erro, aqui vem a tabela cliente do banco de dados
		JComboBox dropSessao = new JComboBox(sessao.toArray());
		dropSessao.setBounds(10, 164, 420, 56);
		getContentPane().add(dropSessao);
		
		textField = new JTextField();
		textField.setBorder(new TitledBorder(null, "Sess\u00F5es Dispon\u00EDveis", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		textField.setText("Data da Sess\u00E3o");
		textField.setForeground(new Color(255, 140, 0));
		textField.setFont(new Font("Yu Gothic", Font.BOLD, 13));
		textField.setColumns(10);
		textField.setBackground(Color.WHITE);
		textField.setBounds(0, 145, 122, 20);
		getContentPane().add(textField);
		
		JButton btnInserirNovoCliente = new JButton("Inserir novo cliente");
		btnInserirNovoCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JCadastroCliente cadCliente = new JCadastroCliente();
				cadCliente.setVisible(true);
		
			}
		});
		btnInserirNovoCliente.setForeground(new Color(210, 105, 30));
		btnInserirNovoCliente.setFont(new Font("Yu Gothic", Font.BOLD, 16));
		btnInserirNovoCliente.setBounds(77, 506, 284, 23);
		getContentPane().add(btnInserirNovoCliente);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.setForeground(new Color(210, 105, 30));
		btnBuscar.setFont(new Font("Yu Gothic", Font.BOLD, 16));
		btnBuscar.setBounds(155, 472, 89, 23);
		getContentPane().add(btnBuscar);
		
		comboBox = new JComboBox(new Object[]{});
		comboBox.setBounds(14, 405, 420, 56);
		getContentPane().add(comboBox);
		
		txtCliente = new JTextField();
		txtCliente.setText("Cliente");
		txtCliente.setForeground(new Color(255, 140, 0));
		txtCliente.setFont(new Font("Yu Gothic", Font.BOLD, 13));
		txtCliente.setColumns(10);
		txtCliente.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Cliente", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		txtCliente.setBackground(Color.WHITE);
		txtCliente.setBounds(6, 388, 122, 20);
		getContentPane().add(txtCliente);


		
	}

	public void LoadTable() {
		DefaultTableModel modelo = new DefaultTableModel(new Object[] {"Nome Filme", "Sala", "Ocupação"},0);
		for (int i=0;i<objBilheteria.getBilhetesVendidos().size();i++) {
			modelo.addRow(new Object[] {});// não terminado, não sei como acessa os dados do obj
		}

	}
}
