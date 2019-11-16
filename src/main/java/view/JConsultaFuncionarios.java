package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.BilheteriaBiz;
import model.FuncionarioEntity;
import model.Funcionarios;
import utils.LtpLib;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Random;
import java.awt.event.ActionEvent;

public class JConsultaFuncionarios extends JFrame {

	private JPanel contentPane;
	private JTextField txtNome;

	private Random numeroRandomico = new Random();
	private BilheteriaBiz objBilheteria = new BilheteriaBiz();
	private LtpLib objLib = new LtpLib();

	private JLabel lblNomeFuncionario;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JConsultaFuncionarios frame = new JConsultaFuncionarios();
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
	public JConsultaFuncionarios() {
		super("Cadastro Gerente");
		try {
			if(new File("Funcionarios.obj").exists()) {
				objBilheteria.setListaFuncionario(objLib.lerArquivoObjetos("Funcionarios.obj"));
			}
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblDigiteONome = new JLabel("Digite o nome do funcionario:");
		lblDigiteONome.setBounds(25, 24, 145, 14);
		panel.add(lblDigiteONome);
		
		txtNome = new JTextField();
		txtNome.setBounds(176, 21, 213, 20);
		panel.add(txtNome);
		txtNome.setColumns(10);
		
		lblNomeFuncionario = new JLabel("");
		lblNomeFuncionario.setBounds(29, 96, 360, 144);
		panel.add(lblNomeFuncionario);
		
		JButton btnPesquisa = new JButton("Pesquisa");
		btnPesquisa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				FuncionarioEntity func =  objBilheteria.procuraFuncionario(txtNome.getText());

				if(func != null) {
					lblNomeFuncionario.setText(func.getNome());
				}
				else {
					lblNomeFuncionario.setText("Nenhum resultado encontrado!");
				}


			}
		});
		btnPesquisa.setBounds(126, 52, 89, 23);
		panel.add(btnPesquisa);
	}

}
