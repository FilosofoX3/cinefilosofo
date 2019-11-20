package view;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JOptionPane;

import controller.*;
import model.*;
import utils.*;

/**
 * 
 * @author Vin�cius Santos classe IterfaceUsuario, faz o link com a classe
 *         BilheteriaBiz date 14/10/17 email viniciussantosx3@gmail.com
 * 
 */
public class InterfaceUsuario {

	// Inicializar o objeto na view referente ao controller
	static BilheteriaBiz objBiz = new BilheteriaBiz();
	static Boolean inicioSessao = false;

	public static void main(String[] args) {
		menu();
		System.out.println("Fim da aplica��o");
	}

	// Cria��o do menu
	public static void menu() {
		int opcao = 0;
		do {
			System.out.println("************ Sistema CineGourmet  ***********");
			System.out.println("1 - Cadastrar Sess�es.");
			System.out.println("2 - Listar Sess�es Cadastradas.");
			System.out.println("3 - Vender bilhete.");
			System.out.println("4 - Gerar relat�rio financeiro.");
			System.out.println("5 - consultar Sess�es.");
			System.out.println("6 - Remover Sess�es. ");
			System.out.println("7 - Consultar Bilhetes. ");
			System.out.println("8 - Deletar Bilhete. ");
			System.out.println("9 - Iniciar jornada de trabalho. ");
			System.out.println("10 - Finalizar Jornada de trabalho.  ");
			System.out.println("11 - Cadastrar Funcionarios. ");
			System.out.println("0 � Sair.");
			opcao = Console.readInt("Digite a op��o que deseja executar");
			switch (opcao) {

			case 0:
				System.out.println("Sair. ");
				break;
			case 1:
				cadastrarSessao();
				break;
			case 2:
				listarSessoesCadastradas();
				break;

			case 3:
				vendaBilhete();
				break;

			case 4:
				gerarRelatorio();
				break;

			case 5:
				consultaSessao();
				break;

			case 6:
				removeSessao();
				break;

			case 7:
				consultarBilhete();
				break;
			case 8:
				deletarBilhete();
				break;
			case 9:
				iniciarJornada();
				break;
			case 10:
				FinalizaJornada();
				break;
			case 11:
				cadastrarFuncionario();
				break;
			default:
				break;
			}

		} while (opcao != 0 && inicioSessao == true);

	}

	private static void FinalizaJornada() {
		inicioSessao = false;
		System.out.println("A sess�o foi encerrada. ");
	}

	private static void cadastrarFuncionario() {
		System.out.println(" 1 � Cadastrar Gerente");
		System.out.println(" 2 � Cadastrar vendedor");
		int opcao = Console.readInt("Op��o: ");

		if (opcao == 1) {
			// atributos de funcionario
			System.out.println("Cadastrar Gerente");
			String nome = Console.readLine("Digite o nome do gerente. ");
			String telefone = Console.readLine("Digite do telefone do gerente. ");
			String email = Console.readLine("Digite do e-mail do gerente. ");
			Date data = new Date();

			// atributos especificos de gerente
			String usuario = Console.readLine("Digite o usuario do gerente. ");
			String senha = Console.readLine("Digite a senha do gerente. ");

			// Criando obj de gerente
			Gerente objGerente = new Gerente(nome, telefone, email, data, usuario, senha);

			// setando atributos de Funcionario
			objGerente.setNome(nome);
			objGerente.setTelefones(telefone);
			objGerente.setEmail(email);
			objGerente.setDataCad(data);

			// setando atributos de gerente
			objGerente.setUsuario(usuario);
			objGerente.setSenha(senha);
			/*Boolean valida = objBiz.cadastrarFuncionario(objGerente);
			if (valida) {
				System.out.println("Gerente cadastrado com sucesso. ");
			} else
				System.out.println("Erro ao cadastrar gerente. ");
			 */
		} else if (opcao == 2) {
			// atributos de funcionario
			System.out.println("Cadastrar vendedor");
			String nome = Console.readLine("Digite o nome do vendedor. ");
			String telefone = Console.readLine("Digite o telefone do vendedor. ");
			String email = Console.readLine("Digite o e-mail do vendedor. ");
			Date data = new Date();

			// atributos especificos de gerente
			String idUsuario = Console.readLine("Digite o Id do vendedor. ");

			// Criando obj de vendedor
			Vendedor objVendedor = new Vendedor(nome, telefone, email, data, idUsuario);

			/*Boolean valida = objBiz.cadastrarFuncionario(objVendedor);
			if (valida) {
				System.out.println("Gerente vendedor com sucesso. ");
			} else
				System.out.println("Erro ao vendedor gerente. ");
			 */

		}
		System.out.println("Deseja iniciar jornada? ");
		int flags = Console.readInt("1 - Para sim. \n2 - Para n�o. ");
		if(flags == 1) {
			iniciarJornada();
		}
	}

	private static Boolean iniciarJornada() {
		System.out.println(" 1 � Iniciar jornado de  Gerente");
		System.out.println(" 2 � Iniciar jornado de  vendedor");
		int opcao = Console.readInt("Op��o: ");

		if (opcao == 1) {
			System.out.println("Iniciar jornado de  Gerente");
			String idUsuario = "";
			String nome = Console.readLine("Digite o nome do gerente. ");
			String usuario = Console.readLine("Digite o usuario do gerente. ");
			String senha = Console.readLine("Digite  a senha do gerente. ");
			inicioSessao = objBiz.iniciaSessao(nome, idUsuario, usuario, senha);
			if (inicioSessao) {
				System.out.println("Sess�o Iniciada com sucesso. ");
				return true;
			} else
				System.out.println("Falha ao iniciar sess�o. ");

		} else if (opcao == 2) {
			System.out.println("Iniciar jornado de  Vendedor");
			String idUsuario = Console.readLine("Digite o nome Id do vendedor. ");
			String nome = Console.readLine("Digite o nome do vendedor. ");
			String usuario = "";
			String senha = "";
			inicioSessao = objBiz.iniciaSessao(nome, idUsuario, usuario, senha);
			if (inicioSessao) {
				System.out.println("Sess�o Iniciada com sucesso. ");
				return true;
			} else
				System.out.println("Falha ao iniciar sess�o. ");
		}

		return false;
	}

	private static void deletarBilhete() {
		String cpf = Console.readLine("Digite o cpf que deseja consultar o bilhete. ");
		Boolean deletado = objBiz.deletarBilhete( cpf);
		if (deletado) {
			System.out.println("Deletado com sucesso. ");
		}
		else {
			System.out.println("Erro ao deletar.");
		}


	}

	private static void consultarBilhete() {
		String cpf = Console.readLine("Digite o cpf que deseja consultar o bilhete. ");
		Bilhete objBilhete = objBiz.consultarBilhete(cpf);
		if (objBilhete!= null) {
			System.out.println(objBilhete.toString());
		}
		else System.out.println("Bilhete n�o encontrado. ");

	}

	private static void removeSessao() {
		System.out.println("Gerar Relat�rio financeiro\n. ");
		String nome = Console.readLine("Digite o nome do gerente\n. ");
		String usuario = Console.readLine("Digite o usu�rio  do gerente\n. ");
		String senha = Console.readLine("Digite a senha\n. ");
		String titulo = Console.readLine("Digite o t�tulo do filme que deseja excluir \n. ");
		int hora = Console.readInt("Digite a hora da sess�o que deseja excluir. ");
		int tecnologia = Console.readInt("Digite 3 para filme 3D.\nDigite 4 para filmes 4D. ");
		Boolean valida = objBiz.removeSessao(titulo, hora, usuario, senha, nome, tecnologia);
		if (valida) {
			System.out.println("Sess�o removida com sucesso. ");
		}
		else {
			System.out.println("Erro ao deletar sess�o. ");
		}
	}

	private static void consultaSessao() {//Date dataInicio, boolean quatroD
		Boolean validaData = false;
		String dataInicio;

		do {
			dataInicio = Console.readLine("Digite a data para consultar as sess�es: ");
			validaData = LtpLib.validarData(dataInicio);
		} while (validaData != true);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyy");
		Date dtInicio = null;
		Date dtFim = null;
		try {
			dtInicio = sdf.parse(dataInicio);

		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Boolean tipoVendaQuatroD = false;
		int flags = Console.readInt("Digite 3 para filme 3D.\nDigite 4 para filmes 4D. ");
		if (flags == 4) {
			tipoVendaQuatroD = true;
		}
		//String objSessao = objBiz.consultaSessao(dtInicio, tipoVendaQuatroD);
		//System.out.println(objSessao);

	}

	private static void gerarRelatorio() {
		System.out.println("Gerar Relat�rio financeiro. ");
		String nome = Console.readLine("Digite o nome do gerente. ");
		String usuario = Console.readLine("Digite o usu�rio  do gerente. ");
		String senha = Console.readLine("Digite a senhae. ");
		String valor = objBiz.gerarRelatorio(usuario,senha,nome);
		if (valor == null) {
			System.out.println("Erro ao gerar relat�rio. ");
		}
		System.out.println(valor);

	}

	private static void vendaBilhete() {
		if (objBiz.existeSessao()) {
			System.out.println("Entre com o nome do Filme: ");
			String nomeFilme = Console.readLine("Digite o nome do filme que deseja vender o bilhete. ");
			int flags = Console.readInt("Digite 3 para filme 3D.\nDigite 4 para filmes 4D. ");
			boolean tipoVendaQuatroD = false; // por default o filme � 3D
			if (flags == 4) {
				tipoVendaQuatroD = true;
			}
			Filme objFilme = objBiz.buscaFilme(nomeFilme,tipoVendaQuatroD);
			if (objFilme != null) {
				System.out.println("Filme encontrado.\n");
				System.out.println(objFilme.toString());
				System.out.println("Qual tipo de filme voc� deseja comprar? ");
		
				Boolean validaData = false;
				String dataInicio;

				do {
					dataInicio = Console.readLine("Digite a data para compra do filme: ");
					validaData = LtpLib.validarData(dataInicio);
				} while (validaData != true);
				SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyy");
				Date dtInicio = null;
				Date dtFim = null;
				try {
					dtInicio = sdf.parse(dataInicio);

				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				/*String objSessao = objBiz.consultaSessao(dtInicio, tipoVendaQuatroD);
				System.out.println("Jaeeeee");
				System.out.println(objSessao);
				if (objSessao != "Sala cheia." && objSessao != "Sessao n�o encontrada") {
					int comprar = Console.readInt("Digite 1 para vender o filme.\nDigite 2 para n�o vender filmes. ");
					if (comprar == 1) {
						String nome = Console.readLine("Digite o nome do cliente. ");
						String cpf;
						Boolean validaCpf = false;
						do {
							cpf = Console.readLine("Digite o novo cpf do cliente");
							validaCpf = LtpLib.validarCPF(cpf);
						} while (validaCpf != true);

						int horarioCompra = Console.readInt("Escolha o hor�rio de uma sess�o. ");
						System.out.println("O usu�rio se qualifica para meia entrada? ");
						int meiaEntrada = Console.readInt("Digite 1 para sim.\nDigite 2 para n�o. ");
						boolean meia = false; // por default n�o � meia entrada
						if (meiaEntrada == 1) {
							meia = true;
						}
						int oculos = Console
								.readInt("Deseja comprar �culos polarizado? \nDigite 1 para sim.\nDigite 2 para n�o. ");
						int poltrona = Console
								.readInt("Deseja comprar poltrona 3D max? \nDigite 1 para sim.\nDigite 2 para n�o. ");
						String bilheteVendido = objBiz.vendaBilhete(horarioCompra, meia, poltrona, oculos, dtInicio,
								nome, cpf);
						System.out.println("Este � o seu bilhete\n" + "\nFilme: " + objFilme.getTitulo() + bilheteVendido);

					} else {
						System.out.println("Fim da aplica��o. Obrigado! o/ ");
					}
					
				}
				else {
				System.out.println("Impossivei venda. ");	
				}

				 */
			} else {
				System.out.println("Filme n�o encontrado. ");
			}
		}

	}

	private static void listarSessoesCadastradas() {
		ArrayList<Sessao> listaSessao = objBiz.getSessoesCadastradas();
		for (Sessao sessao : listaSessao) {
			System.out.println(sessao.toString());
		}
	}

	private static void cadastrarSessao() {
		boolean tipoFilme = false; // por default o filme j� est� em 3D
		boolean tipoPoltrona = false;// por default a poltrona � simples
		boolean tipoOculos = false;// por default o oculos � simples
		int valorFilme = 0;
		System.out.println("Cadastrar Sess�o. ");
		String titulo = Console.readLine("Digite o t�tulo do filme. ");
		int duracao = Console.readInt("Digite a dura��o do filme em minutos. ");
		int anoLancamento = Console.readInt("Digite o ano de lan�amento do filme. ");
		int clasIndicativa = Console.readInt("Digite a classifica��o indicativa do filme. ");
		// boolean quatroD = Boolean.valueOf( JOptionPane.showInputDialog("0- Tenologia
		// 3D. \n 1- Tecnologia 4D. \n "));)
		String genero = Console.readLine("Digite o g�nero  do filme. ");
		int horario = Console.readInt("Digite o horario da sess�o. ");
		System.out.println("Qual tipo de filme voc� deseja cadastrar? ");
		valorFilme = Console.readInt("Digite 3 para filme 3D.\nDigite 4 para filmes 4D. ");
		if (valorFilme == 4) {
			tipoFilme = true;
			System.out.println("Qual tipo de poltrona");
			int valorPoltrona = Console
					.readInt("Digite 1 para poltrona normal.\nDigite 2 para poltrona com tecnologia 3D max. ");
			if (valorPoltrona == 2) {
				tipoPoltrona = true;
			}

		} else if (valorFilme == 3) {
			int valorOculos = Console
					.readInt("Digite 1 para �culos  normal.\nDigite 2 para �culos com tecnologia 3D max.");
			if (valorOculos == 2) {
				tipoOculos = true;
			}
		} else {
			System.out.println("Valor errado. ");
		}
		Boolean validaData = false;
		Boolean validaFim = false;
		String dataInicio;
		String dataFim;

		do {
			dataInicio = Console.readLine("Digite a data inicio para o inicio da sess�o: ");
			validaData = LtpLib.validarData(dataInicio);
		} while (validaData != true);
		do {
			dataFim = Console.readLine("Digite a data para o fim da sess�o:");
			validaFim = LtpLib.validarData(dataFim);
		} while (validaFim != true);

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyy");
		Date dtInicio = null;
		Date dtFim = null;
		try {
			dtInicio = sdf.parse(dataInicio);
			dtFim = sdf.parse(dataFim);

		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/*Boolean cadastrou = objBiz.cadastrarSessao(horario, dtInicio, dtFim, tipoFilme, titulo, duracao, anoLancamento,
				clasIndicativa, genero, tipoOculos, tipoPoltrona);
		if (cadastrou) {
			System.out.println("\n\nSess�o cadastrada com sucesso. :) \n\n");
		} else {
			System.out.println("Erro ao cadastrar Sess�o. :( ");
		}

		 */

	}
}
