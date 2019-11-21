package controller;

import java.math.BigDecimal;
import java.sql.Time;
import java.util.ArrayList;
import java.sql.Date;
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
	 * @return true se for igual, esse m�todo compara dois nomes e retorna zero se
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
	 * Retorna String Gera o relat�rio de quantidade de vendas de filmes em 3D e 4D
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
	 * M�todo busca o filme dentro do arrayList de filme e retorna o filme se
	 * encontra,e null caso n�o
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
	 * M�todo que cadastra novo filme
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
	 * Lista todos os g�neros
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
	 * Lista todas as classifica��es
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
	 * M�todo que consulta as sess�es entre determinadas datas
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
						retorno = "\nFilme dispon�vel na sess�o das: " + sessao.getHora() + "horas" + "\nCont�m "
								+ poltronasDisponiveis + " poltronas dispon�veis" + "\nA sess�o e 4D: "
								+ sessao.getSalaCinema().getQuatroD();
						return retorno;
					} else
						return "Sala cheia.";
			}

			else
				return "Sessao n�o encontrada";
		}
		return retorno;
	}

	/**
	 * M�todo que faz a venda do bilhete de entrada do cinema
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
				sessao.incrementaOcupacao();// incrementa pois est� vendendo mais um bilhete
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
			if ((data.getDay() == 1) || (meiaEntrada)) { // estou usando o m�todo depreciado pois quero utilizar a
				if (data.getDay() == 1)
					System.out.println("Opa!! Esse dia � bravo, logo todo mundo paga meia entrada. o/ "); // classe Date
																											// para
																											// fazer a
																											// valida��o
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
	 * m�todo valida o vendedor com base no nome e no id
	 * 
	 * @param idUsuario
	 * @param nome
	 * @return true se o id for validador, e false caso n�o.
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
	 * esse m�todo � para iniciar a sessao do vendedor ou do gerente
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
	 * Busca filme, por titulo
	 *
	 * @param titulo
	 * @return
	 */
	public List<FilmeEntity> procuraFilme(String titulo) {

		Query query = session.createQuery("from FilmeEntity where titulo like :titulo");
		List<FilmeEntity> filmes;
		try {
			filmes = query.setParameter("titulo", "%" + titulo + "%").list();
		} catch( javax.persistence.NoResultException err) {
			filmes = null;
		}

		return filmes;
	}

	/**
	 * m�todo que cadastra sessao
	 *
	 * @param salaId
	 * @param filmeId
	 * @param tecnologiaId
	 * @param dataInicio
	 * @param dataFim
	 * @param hora
	 * @param valor
	 * @param legendado
	 * @return
	 */
	public Long cadastrarSessao(Long salaId, Long filmeId, Long tecnologiaId, Date dataInicio, Date dataFim, Time hora, BigDecimal valor, Boolean legendado) {
		SessaoEntity sessao = new SessaoEntity();
		sessao.setSalaId(salaId);
		sessao.setFilmeId(filmeId);
		sessao.setTecnologiaId(tecnologiaId);
		sessao.setDataInicio(dataInicio);
		sessao.setDataFim(dataFim);
		sessao.setHora(hora);
		sessao.setValor(valor);
		sessao.setLegendado(legendado);

		return save(sessao);
	}

	/**
	 * Lista salas de cinema
	 *
	 * @return
	 */
	public List<SalaEntity> listaSala(Boolean apenas4D) {
		Query query;
		if (apenas4D) {
			query = session.createQuery("from SalaEntity where quatroD = 1");
		}
		else
			query = session.createQuery("from SalaEntity");
		List<SalaEntity> salas;
		try {
			salas = query.list();
		} catch( javax.persistence.NoResultException err) {
			salas = null;
		}

		return salas;
	}

	/**
	 * Lista tecnologias
	 *
	 * @return
	 */
	public List<TecnologiaEntity> listaTecnologia() {

		Query query = session.createQuery("from TecnologiaEntity");
		List<TecnologiaEntity> tecnologias;
		try {
			tecnologias = query.list();
		} catch( javax.persistence.NoResultException err) {
			tecnologias = null;
		}

		return tecnologias;
	}

	/**
	 * Busca por funcion�rios, por nome
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
	 * Busca por funcion�rios, por nome
	 *
	 * @return Funcionarios
	 */
	public String getPessoaNome(Long funcionarioId) {

		Query query = session.createQuery("" +
				"SELECT P.nome FROM PessoaEntity P " +
				"INNER JOIN FuncionarioEntity F " +
				"ON P.pessoaId = F.pessoaId " +
				"WHERE F.funcionarioId = :funcionarioId");

		String pessoaNome;
		try {
			pessoaNome = query.setParameter("funcionarioId", funcionarioId).getSingleResult().toString();
		} catch( javax.persistence.NoResultException err) {
			pessoaNome = null;
		}

		return pessoaNome;
	}

	/**
	 * Busca por funcion�rios, por nome
	 *
	 * @return Funcionarios
	 */
	public List<GerenteEntity> listaGerente() {

		Query query = session.createQuery("from GerenteEntity");
		List<GerenteEntity> gerentes;
		try {
			gerentes = query.list();
		} catch( javax.persistence.NoResultException err) {
			gerentes = null;
		}

		return gerentes;
	}

	/**
	 * m�todo que cadastra pessoa
	 *
	 * @param cpf
	 * @param nome
	 * @param email
	 * @param dataNascimento
	 * @param dataCadastro
	 * @return
	 */
	public Long cadastrarPessoa(String cpf, String nome, String email, Date dataNascimento, Date dataCadastro) {
		PessoaEntity pessoa = new PessoaEntity();
		pessoa.setCpf(cpf);
		pessoa.setNome(nome);
		pessoa.setEmail(email);
		pessoa.setDataNascimento(dataNascimento);
		pessoa.setDataCadastro(dataCadastro);

		return save(pessoa);
	}

	/**
	 * m�todo que cadastra funcion�rio
	 * 
	 * @param pessoaId
	 * @param usuario
	 * @param senha
	 * @return
	 */
	public Long cadastrarFuncionario(Long pessoaId, String usuario, String senha) {
		FuncionarioEntity funcionario = new FuncionarioEntity();
		funcionario.setPessoaId(pessoaId);
		funcionario.setUsuario(usuario);
		funcionario.setSenha(senha);

		return save(funcionario);
	}

	/**
	 * m�todo que cadastra telefone de funcion�rio
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
     * m�todo que cadastra vendedor
     *
     * @param funcionarioId
     * @param gerenteId
	 * @param metaVendas
	 * @return
     */
    public Long cadastrarVendedor(Long funcionarioId, Long gerenteId, int metaVendas) {
        VendedorEntity vendedor = new VendedorEntity();
        vendedor.setFuncionarioId(funcionarioId);
        vendedor.setGerenteId(gerenteId);
		vendedor.setMetaVendas(metaVendas);

		return save(vendedor);
    }

	/**
	 * m�todo que cadastra gerente
	 *
	 * @param funcionarioId
	 * @return
	 */
	public Long cadastrarGerente(Long funcionarioId) {
		GerenteEntity gerente = new GerenteEntity();
		gerente.setFuncionarioId(funcionarioId);

		return save(gerente);
	}

	/**
	 * Verifica se h� alguma sess�o cadastrada valida
	 * 
	 * @return true caso haja, false caso n�o
	 */
	public boolean existeSessao() {
		return !sessoesCadastradas.isEmpty();
	}

}
