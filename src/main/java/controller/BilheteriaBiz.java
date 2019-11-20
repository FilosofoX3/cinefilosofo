package controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import model.*;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.hibernate.Session;
import utils.SessionFactoryHelper;

public class BilheteriaBiz {

// Criando listas
	private ArrayList<Bilhete> bilhetesVendidos = new ArrayList<Bilhete>();
	public ArrayList<Bilhete> getBilhetesVendidos() {
		return bilhetesVendidos;
	}


	private ArrayList<Sessao> sessoesCadastradas = new ArrayList<Sessao>();
	private ArrayList<Sessao> filmeEncontrado = new ArrayList<Sessao>();
	private ArrayList<Sessao> sesDisp = new ArrayList<Sessao>();
	private ArrayList<Gerente> listaGerente = new ArrayList<Gerente>();
	private ArrayList<Vendedor> listaVendedor = new ArrayList<Vendedor>();
	private ArrayList<Funcionarios> listaFuncionario = new ArrayList<Funcionarios>();

	// Criando uma lista auxiliar
	private ArrayList<Sessao> SessaoDisponiveis = new ArrayList<Sessao>();

//Inicializando salas de cinemas
	private SalaCinema sala1;
	private SalaCinema sala2;
	private SalaCinema sala3;
	private SalaCinema sala4;

	// Sessao de conexao com bd
	private Session session;

	//Construtor
	public BilheteriaBiz() {

		sessoesCadastradas = new ArrayList<Sessao>();
		setFilmeEncontrado(new ArrayList<Sessao>());
		bilhetesVendidos = new ArrayList<Bilhete>();
		setSesDisp(new ArrayList<Sessao>());

		sala1 = new SalaCinema(1, 90, false);// 3D
		sala2 = new SalaCinema(2, 2, false);// 3D
		sala3 = new SalaCinema(3, 90, true);// 4D
		sala4 = new SalaCinema(4, 5, true);// 4D

		SessionFactoryHelper sh = new SessionFactoryHelper();
		session = sh.getSessionFactory().getCurrentSession();
		try{
			session.beginTransaction();

		}catch (java.lang.IllegalStateException error){
			;
		}
	}

	private Long save(Object obj) {
		if(!session.getTransaction().isActive())
			session.getTransaction().begin();

		Long id = (Long) session.save(obj);

		session.getTransaction().commit();

		SessionFactoryHelper sh = new SessionFactoryHelper();
		session = sh.getSessionFactory().getCurrentSession();

		return id;
	}

	public void setBilhetesVendidos(ArrayList<Bilhete> bilhetesVendidos) {
		this.bilhetesVendidos = bilhetesVendidos;
	}

	public ArrayList<Sessao> getSessaoDisponiveis() {
		return SessaoDisponiveis;
	}

	public void setSessaoDisponiveis(ArrayList<Sessao> sessaoDisponiveis) {
		SessaoDisponiveis = sessaoDisponiveis;
	}

	public SalaCinema getSala1() {
		return sala1;
	}

	public void setSala1(SalaCinema sala1) {
		this.sala1 = sala1;
	}

	public SalaCinema getSala2() {
		return sala2;
	}

	public void setSala2(SalaCinema sala2) {
		this.sala2 = sala2;
	}

	public SalaCinema getSala3() {
		return sala3;
	}

	public void setSala3(SalaCinema sala3) {
		this.sala3 = sala3;
	}

	public SalaCinema getSala4() {
		return sala4;
	}

	public void setSala4(SalaCinema sala4) {
		this.sala4 = sala4;
	}

	public void setSessoesCadastradas(ArrayList<Sessao> sessoesCadastradas) {
		this.sessoesCadastradas = sessoesCadastradas;
	}
	public ArrayList<Sessao> getSessoesCadastradas() {
		return sessoesCadastradas;
	}

	public ArrayList<Sessao> getFilmeEncontrado() {
		return filmeEncontrado;
	}

	public void setFilmeEncontrado(ArrayList<Sessao> filmeEncontrado) {
		this.filmeEncontrado = filmeEncontrado;
	}

	public ArrayList<Sessao> getSesDisp() {
		return sesDisp;
	}

	public void setSesDisp(ArrayList<Sessao> sesDisp) {
		this.sesDisp = sesDisp;
	}

	public ArrayList<Funcionarios> getListaFuncionario() {
		return listaFuncionario;
	}

	public void setListaFuncionario(ArrayList<Funcionarios> listaFuncionario) {
		this.listaFuncionario = listaFuncionario;
	}

	/**
	 * 
	 * @param titulo
	 * @return true se for igual, esse método compara dois nomes e retorna zero se
	 *         forem iguais
	 */

	public Boolean compara(String titulo) {
		for (Bilhete bilhete : bilhetesVendidos) {
			if (bilhete.getSessao().getFilme().getTitulo().compareTo(titulo) == 0) {
				return true;
			}
		}
		return false;
	}

	/**
	 * cadastra nova sessao dentro da lista de sessao
	 * 
	 * @return true or false // se conseguir cadastrar retorna true
	 * 
	 */
	public Boolean cadastrarSessao(int horario, Date dataInicio, Date dataFim, boolean tipoQuatroD, String titulo,
			int duracao, int anoLancamento, int clasInd, String genero, boolean oculosAtivo,
			boolean poltronaInteligente) {

		Boolean valida = compara(titulo);
		if (valida == false) {
			Sessao objSessao;
			if (tipoQuatroD == false) {
				Filme objFilme = new FilmeTresD(titulo, duracao, anoLancamento, clasInd, genero, oculosAtivo);
				if (oculosAtivo == false) {
					objSessao = new Sessao(horario, sala1, objFilme, dataInicio, dataFim);
				} else {
					objSessao = new Sessao(horario, sala2, objFilme, dataInicio, dataFim);
				}
				sessoesCadastradas.add(objSessao);
			}

			else if (tipoQuatroD == true) {
				Filme objFilme = new FilmeQuatroD(titulo, duracao, anoLancamento, clasInd, genero, poltronaInteligente);
				if (poltronaInteligente == false) {
					objSessao = new Sessao(horario, sala3, objFilme, dataInicio, dataFim);
				} else {
					objSessao = new Sessao(horario, sala4, objFilme, dataInicio, dataFim);
				}
				sessoesCadastradas.add(objSessao);
			}
			return true;
		}
		return null;

	}

	/**
	 * Retorna String Gera o relatório de quantidade de vendas de filmes em 3D e 4D
	 * separadamente, e juntos
	 * 
	 * @return string
	 */
	public String gerarRelatorio(String usuario, String senha, String nome) {
		if (validaGerente(usuario, senha, nome)) {
			Double total_tresD = new Double(0);
			Double total_quatroD = new Double(0);
			Double totalFinal = new Double(0);
			for (Bilhete bilhete : bilhetesVendidos) {
				if ((!bilhetesVendidos.isEmpty()) && (bilhete.getSessao().getFilme() instanceof FilmeQuatroD)) {
					total_quatroD = total_quatroD + bilhete.getValor();
				} else if (!bilhetesVendidos.isEmpty() && bilhete.getSessao().getFilme() instanceof FilmeTresD) {
					total_tresD = total_tresD + bilhete.getValor();
				} else
					return null;
			}
			totalFinal = total_tresD + total_quatroD;
			return "Total de bilhetes 4D em R$" + total_quatroD.toString() + "\nTotal de bilhetes 3D em R$"
					+ total_tresD.toString() + "\n Totalizando um valor de " + totalFinal.toString();

		} else
			return null;
	}

	/**
	 * Método busca o filme dentro do arrayList de filme e retorna o filme se
	 * encontra,e null caso não
	 * 
	 * @param titulo
	 * @return
	 */
	public Filme buscaFilme(String titulo, boolean quatroD) {
		for (Sessao sessao : sessoesCadastradas) {
			if ((!sessoesCadastradas.isEmpty()) && (sessao.getFilme().getTitulo().equals(titulo)) && quatroD == sessao.getSalaCinema().isQuatroD()) {
				System.out.println("casdastrou..." + sessao.getFilme().getTitulo());
				filmeEncontrado.add(sessao);
				return sessao.getFilme();
			}
		}
		return null;
	}

	/**
	 * Método que cadastra novo filme
	 *
	 * @param titulo
	 * @param classificacaoId
	 * @param generoId
	 * @param duracaoMinutos
	 * @param duracaoHoras
	 * @param anoLancamento
	 * @return
	 */
	public Long cadastrarFilme(
			String titulo,
			Long classificacaoId,
			Long generoId,
			int duracaoMinutos,
			int duracaoHoras,
			int anoLancamento
	) {
		FilmeEntity filme = new FilmeEntity();
		filme.setTitulo(titulo);
		filme.setClassificacaoId(classificacaoId);
		filme.setGeneroId(generoId);
		filme.setDuracaoMinutos(duracaoMinutos);
		filme.setDuracaoHoras(duracaoHoras);
		filme.setAnoLancamento(anoLancamento);

		return save(filme);
	}

	/**
	 * Lista todos os gêneros
	 *
	 * @return
	 */
	public List<GeneroEntity> listaGenero(
	) {
		Query query = session.createQuery("from GeneroEntity");
		List<GeneroEntity> generos;
		try {
			generos = query.list();
		} catch( javax.persistence.NoResultException err) {
			generos = null;
		}

		return generos;
	}

	/**
	 * Lista todas as classificações
	 *
	 * @return
	 */
	public List<ClassificacaoEntity> listaClassificacao(
	) {
		Query query = session.createQuery("from ClassificacaoEntity ");
		List<ClassificacaoEntity> classificacoes;
		try {
			classificacoes = query.list();
		} catch( javax.persistence.NoResultException err) {
			classificacoes = null;
		}

		return classificacoes;
	}

	/**
	 * Método que consulta as sessões entre determinadas datas
	 * 
	 * @param dataInicio
	 * @param quatroD
	 * @return
	 */
	public String consultaSessao(Date dataInicio, boolean quatroD) {
		String retorno = " ";
		for (Sessao sessao : filmeEncontrado) {
			System.out.println("helaaaaaa");
			if (!filmeEncontrado.isEmpty() && dataInicio.after(sessao.getDataInicio())
					&& dataInicio.before(sessao.getDataFim())) {
				System.out.println("olaaaaaa");
					if (sessao.getOcupacao() < sessao.getSalaCinema().getCapacidade()) {
						// salvar a filme na copia da lista
						SessaoDisponiveis.add(sessao);
						int poltronasDisponiveis = sessao.getSalaCinema().getCapacidade() - sessao.getOcupacao();
						retorno = "\nFilme disponível na sessão das: " + sessao.getHora() + "horas" + "\nContém "
								+ poltronasDisponiveis + " poltronas disponíveis" + "\nA sessão e 4D: "
								+ sessao.getSalaCinema().getQuatroD();
						return retorno;
					} else
						return "Sala cheia.";
			}

			else
				return "Sessao não encontrada";
		}
		return retorno;
	}

	/**
	 * Método que faz a venda do bilhete de entrada do cinema
	 * 
	 * @param horaDesejada
	 * @param meiaEntrada
	 * @param poltronaInteligente
	 * @param data
	 * @param nome
	 * @param cpf
	 * @return qual foi a sessao e o filme vendido
	 */
	@SuppressWarnings("deprecation")
	public String vendaBilhete(int horaDesejada, boolean meiaEntrada, int poltronaInteligente, int oculosAtivo,
			Date data, String nome, String cpf) {
		double valorBilhete = 0;
		for (Sessao sessao : SessaoDisponiveis) {
			if ((!SessaoDisponiveis.isEmpty()) && (sessao.getHora() == horaDesejada)) {
				sessao.incrementaOcupacao();// incrementa pois está vendendo mais um bilhete
				if (sessao.getSalaCinema().isQuatroD() && (poltronaInteligente == 1)) { // poltrona comum para sala em
																						// // 4D
					valorBilhete = FilmeQuatroD.valorPoltrona1;
				} else if (sessao.getSalaCinema().isQuatroD() && (poltronaInteligente == 2)) { // poltrona inteligente
																								// // para sala em 4D
					valorBilhete = FilmeQuatroD.valorPoltrona2;
				} else if (!sessao.getSalaCinema().isQuatroD() && (oculosAtivo == 2)) { // oculos ativo para sala em 3D
					valorBilhete = FilmeTresD.valorOculos2;
				} else { // oculos passivo polarizado
					valorBilhete = FilmeTresD.valorOculos1;
				}
			}
			if ((data.getDay() == 1) || (meiaEntrada)) { // estou usando o método depreciado pois quero utilizar a
				if (data.getDay() == 1)
					System.out.println("Opa!! Esse dia é bravo, logo todo mundo paga meia entrada. o/ "); // classe Date
																											// para
																											// fazer a
																											// validação
																											// de datas.
				valorBilhete = valorBilhete / 2; // toda segunda feira, todo mundo paga meia entrada

			}
			Bilhete objBilhete = new Bilhete(sessao, valorBilhete, nome, cpf);
			bilhetesVendidos.add(objBilhete);
			return objBilhete.toString();

		}
		return null;
	}

	/**
	 * 
	 * @param cpf bilhete pelo cpf
	 * @return o bilhete
	 */
	public Bilhete consultarBilhete(String cpf) {
		for (Bilhete bilhete : bilhetesVendidos) {
			if (!bilhetesVendidos.isEmpty() && bilhete.getCpf().compareToIgnoreCase(cpf) == 0) {
				return bilhete;
			}

		}
		return null;
	}

	/**
	 * deleta o bilhete pelo numero do cpf
	 * 
	 * @param cpf
	 * @return true e deletou, false caso falhou
	 */

	public Boolean deletarBilhete(String cpf) {
		Bilhete objBilhete = consultarBilhete(cpf);
		if (objBilhete != null) {
			return bilhetesVendidos.remove(objBilhete);
		}
		return null;
	}

	/**
	 * remove a sessao pelo titulo do filme e a hora
	 * 
	 * @param titulo
	 * @param hora
	 * @return true quando remove, e null quando nao consegue remover
	 */
	public Boolean removeSessao(String titulo, int hora, String usuario, String senha, String nome, int tecnologia) {
		if (validaGerente(usuario, senha, nome)) {
			for (Sessao sessao : sessoesCadastradas) {
				if (titulo.equals(sessao.getFilme().getTitulo()) && hora == sessao.getHora()) {
					if ((tecnologia == 3) && (sessao.getSalaCinema().isQuatroD() == false)) {
						return sessoesCadastradas.remove(sessao);
					} else if ((tecnologia == 4) && (sessao.getSalaCinema().isQuatroD())) {
						return sessoesCadastradas.remove(sessao);
					}
				}

			}
		}
		return null;
	}

	/**
	 * valida o gerente por base do usuario e senha
	 * 
	 * @return boolean
	 * 
	 */
	public boolean validaGerente(String usuario, String senha, String nome) {
		//FuncionarioEntity objFunc = procuraFuncionario(nome);

		/*
		if (objFunc != null && objFunc instanceof Gerente) {
			if (usuario.equalsIgnoreCase(((Gerente) objFunc).getUsuario())
					&& senha.equalsIgnoreCase(((Gerente) objFunc).getSenha()))
				;
			return true;
		}
		*/
		return false;
	}

	/**
	 * método valida o vendedor com base no nome e no id
	 * 
	 * @param idUsuario
	 * @param nome
	 * @return true se o id for validador, e false caso não.
	 */
	public boolean validaVendedor(String idUsuario, String nome) {
		//FuncionarioEntity objFunc = procuraFuncionario(nome);
		/*
		if (objFunc != null && objFunc instanceof Vendedor) {
			if (idUsuario.equalsIgnoreCase(((Vendedor) objFunc).getIdUsuario())) {
				return true;
			}
		}
		*/
		return false;
	}

	/**
	 * esse método é para iniciar a sessao do vendedor ou do gerente
	 * 
	 * @param nome
	 * @param idUsuario
	 * @return
	 */
	public boolean iniciaSessao(String nome, String idUsuario, String usuario, String senha) {
		if (validaVendedor(idUsuario, nome) || validaGerente(usuario, senha, nome)) {
			return true;
		} else
			return false;
	}

	/**
	 * procura o funcionario na lista de funcionarios
	 *
	 * @param nome
	 * @return Funcionarios
	 */
	public List<FuncionarioEntity> procuraFuncionario(String nome) {

		Query query = session.createQuery("from FuncionarioEntity where nome = :nome ");
		List<FuncionarioEntity> funcionarios;
		try {
			funcionarios = query.setParameter("nome", nome).list();
		} catch( javax.persistence.NoResultException err) {
			funcionarios = null;
		}

		return funcionarios;
	}

	/**
	 * método que cadastra funcionário
	 * 
	 * @param nome
	 * @param email
	 * @param dataCadastro
	 * @return
	 */
	public Long cadastrarFuncionario(String nome, String email, java.sql.Date dataCadastro) {
		FuncionarioEntity funcionario = new FuncionarioEntity();
		funcionario.setNome(nome);
		funcionario.setEmail(email);
		funcionario.setDataCadastro(dataCadastro);

		return save(funcionario);
	}

	/**
	 * método que cadastra telefone de funcionário
	 *
	 * @param funcionarioId
	 * @param telefone
	 * @return
	 */
	public Long cadastrarFuncionarioTelefone(Long funcionarioId, String telefone) {
		FuncionarioTelefoneEntity funcionarioTelefone = new FuncionarioTelefoneEntity();
		funcionarioTelefone.setFuncionarioId(funcionarioId);
		funcionarioTelefone.setTelefone(telefone);

		return save(funcionarioTelefone);
	}

    /**
     * método que cadastra vendedor
     *
     * @param funcionarioId
     * @param usuarioId
     * @return
     */
    public Long cadastrarVendedor(Long funcionarioId, String usuarioId) {
        VendedorEntity vendedor = new VendedorEntity();
        vendedor.setFuncionarioId(funcionarioId);
        vendedor.setUsuarioId(usuarioId);

        return save(vendedor);
    }

	/**
	 * método que cadastra gerente
	 *
	 * @param funcionarioId
	 * @param usuario
	 * @param senha
	 * @return
	 */
	public Long cadastrarGerente(Long funcionarioId, String usuario, String senha) {
		GerenteEntity gerente = new GerenteEntity();
		gerente.setFuncionarioId(funcionarioId);
		gerente.setUsuario(usuario);
		gerente.setSenha(senha);

		return save(gerente);
	}

	/**
	 * Verifica se há alguma sessão cadastrada valida
	 * 
	 * @return true caso haja, false caso não
	 */
	public boolean existeSessao() {
		return !sessoesCadastradas.isEmpty();
	}

}
