package view;

        import java.awt.*;

        import javax.swing.*;
        import javax.swing.border.EmptyBorder;
        import javax.swing.border.TitledBorder;
        import javax.swing.text.MaskFormatter;

        import controller.BilheteriaBiz;
        import model.*;
        import utils.LtpLib;
        import utils.RegExFieldVerifier;

        import java.awt.event.ActionListener;
        import java.io.File;
        import java.sql.Date;
        import java.text.ParseException;
        import java.util.Calendar;
        import java.util.List;
        import java.util.Random;
        import java.awt.event.ActionEvent;
        import java.util.regex.Matcher;
        import java.util.regex.Pattern;

public class JCadastroCliente extends JFrame {

    private JPanel contentPane;
    private JTextField txtNome;
    private JTextField txtCpf;
    private JTextField txtEmail;
    private JTextField txtTelefones;
    private JFormattedTextField txtDataNascimento;
    private JFormattedTextField txtDataCadastro;
    private JTextField txtGenero;
    private JList listaGeneros = new JList();

    private Random numeroRandomico = new Random();
    private BilheteriaBiz objBilheteria = new BilheteriaBiz();
    private LtpLib objLib = new LtpLib();

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    JCadastroCliente frame = new JCadastroCliente();
                    frame.setResizable(false);
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
    public JCadastroCliente() {
        super("Cadastro Cliente");

        setBounds(100, 100, 310, 420);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);

        JPanel panel = new JPanel();
        contentPane.add(panel, BorderLayout.CENTER);
        panel.setLayout(null);

        JLabel lblNome = new JLabel("Nome");
        lblNome.setFont(new Font("Yu Gothic", Font.BOLD, 11));
        lblNome.setBounds(10, 11, 46, 14);
        panel.add(lblNome);

        txtNome = new JTextField();
        txtNome.setBounds(115, 11, 86, 20);
        panel.add(txtNome);
        txtNome.setColumns(10);

        JLabel lblCpf = new JLabel("CPF");
        lblCpf.setFont(new Font("Yu Gothic", Font.BOLD, 11));
        lblCpf.setBounds(10, 36, 46, 14);
        panel.add(lblCpf);

        txtCpf = new JTextField();
        txtCpf.setBounds(115, 36, 86, 20);
        panel.add(txtCpf);
        txtCpf.setColumns(10);

        JLabel lblEmail = new JLabel("Email");
        lblEmail.setFont(new Font("Yu Gothic", Font.BOLD, 11));
        lblEmail.setBounds(10, 70, 46, 14);
        panel.add(lblEmail);

        txtEmail = new JTextField();
        txtEmail.setBounds(115, 67, 86, 20);
        panel.add(txtEmail);
        txtEmail.setColumns(10);

        JLabel lblUsuario = new JLabel("Data Nascimento");
        lblUsuario.setFont(new Font("Yu Gothic", Font.BOLD, 11));
        lblUsuario.setBounds(10, 139, 112, 14);
        panel.add(lblUsuario);

        txtDataNascimento = new JFormattedTextField();
        txtDataNascimento.setInputVerifier(new RegExFieldVerifier("([0-2][0-9]|3[0-1])/(0[1-9]|1[0-2])/(19|20)\\d{2}"));

        txtDataNascimento.setBounds(115, 133, 86, 20);
        panel.add(txtDataNascimento);
        txtDataNascimento.setColumns(10);

        try {
            MaskFormatter dataMask = new MaskFormatter("##/##/####");
            dataMask.install(txtDataNascimento);
        } catch (ParseException err) {}

        txtGenero = new JTextField();
        txtGenero.setForeground(new Color(255, 140, 0));
        txtGenero.setColumns(10);
        txtGenero.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Sessões disponíveis", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
        txtGenero.setBackground(Color.WHITE);
        txtGenero.setBounds(0, 194, 172, 20);
        panel.add(txtGenero);

        List<GeneroEntity> generos = objBilheteria.listaGenero();
        listaGeneros.setListData(generos.toArray());
        listaGeneros.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 224, 270, 56);
        scrollPane.setViewportView(listaGeneros);
        panel.add(scrollPane);

        JButton btnSalvar = new JButton("Salvar");
        btnSalvar.addActionListener(new ActionListener() {
            @SuppressWarnings("static-access")
            public void actionPerformed(ActionEvent arg0) {
                Pattern patternData = Pattern.compile("([0-2][0-9]|3[0-1])/(0[0-9]|1[0-2])/(\\d{4})");

                Matcher matchDataNascimento = patternData.matcher(txtDataNascimento.getText());
                matchDataNascimento.find();
                Date dataNascimento = Date.valueOf(matchDataNascimento.group(3) + "-" + matchDataNascimento.group(2) + "-" + matchDataNascimento.group(1));

                Long pessoaId = objBilheteria.cadastrarPessoa(
                        txtCpf.getText(),
                        txtNome.getText(),
                        txtEmail.getText(),
                        dataNascimento,
                        new java.sql.Date(Calendar.getInstance().getTime().getTime())
                );

                if (pessoaId == null) {
                    JOptionPane.showMessageDialog(null, "ERRO! CPF e/ou email já existe!");
                }
                else {
                    Long clienteId = objBilheteria.cadastrarCliente(pessoaId);

                    if (clienteId != null) {
                        List generosSelecionados = listaGeneros.getSelectedValuesList();

                        for (Object genero : generosSelecionados) {
                            objBilheteria.cadastrarClienteInteresse(clienteId, ((GeneroEntity) genero).getGeneroId());
                        }

                        JOptionPane.showMessageDialog(null, "Cadastrado com sucesso!");
                    }
                }
            }
        });
        btnSalvar.setBounds(63, 290, 89, 23);
        panel.add(btnSalvar);
    }
}
