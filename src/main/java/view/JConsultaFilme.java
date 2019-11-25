package view;

import controller.BilheteriaBiz;
import model.FilmeEntity;
import model.FuncionarioEntity;
import utils.LtpLib;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Vector;

public class JConsultaFilme extends JFrame {

	private JPanel contentPane;
	private JTextField txtTitulo;
	private JList listaFilmes = new JList();

	private BilheteriaBiz objBilheteria = new BilheteriaBiz();

	private JLabel lblNomeFuncionario;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JConsultaFilme frame = new JConsultaFilme();
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
	public JConsultaFilme() {
		super("Busca filme");

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 480, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		final JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblDigiteONome = new JLabel("Digite o título:");
		lblDigiteONome.setBounds(25, 21, 245, 20);
		panel.add(lblDigiteONome);
		
		txtTitulo = new JTextField();
		txtTitulo.setBounds(206, 21, 213, 20);
		panel.add(txtTitulo);
		txtTitulo.setColumns(10);
		
		JButton btnPesquisa = new JButton("Pesquisa");
		btnPesquisa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				List<FilmeEntity> filmes =  objBilheteria.procuraFilme(txtTitulo.getText());

				System.out.println(filmes.toString());

				if(!filmes.isEmpty()) {
				    // TODO: listar filmes com botão para escolha do buscado (que leva para tela anterior)
                    listaFilmes.setListData(filmes.toArray());
                    listaFilmes.setBounds(29, 106, 260, 100);
                    panel.add(listaFilmes);
				}
				else {
					listaFilmes.setListData(new Vector());
					panel.add(listaFilmes);
				}
			}
		});
		btnPesquisa.setBounds(126, 52, 89, 23);
		panel.add(btnPesquisa);
	}
}
