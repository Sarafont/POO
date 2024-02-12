// GRUPO II

/* Considere as seguintes definições de classes de uma aplicação que implementa uma loja de livros digitais. A aplicação da LivrosDigitais possui a informação dos utilizadores que nela estão registados e para cada utilizador é guardada a informação respeitante à coleção de livros que adquiriu. A informação dos livros indica as páginas lidas e por ler e consequentemente em qualquer altura sabe-se sempre qual é o sítio do livro que se está a ler. Considere os seguintes excertos de código: */
public class Livro implements Comparable<Livro>, Serializable {
	public String codISBN; //código ISBN do livro
	private String nomeLivro;
	private String autor;
	private String editora;
	private List<Pagina> pagLidas; // páginas já lidas
	private List<Pagina> pagPorLer; //páginas ainda por ler.
	//o primeiro elemento é a página a ser lida no momento
	//....
	/* método que devolve a página com o número indicado */
	public Pagina devolvePag(int numPag) throws PagInexistenteException {
		Pagina res = null;
		int numLidas = this.pagLidas.size(); //número de páginas lidas
		int porLer = this.pagPorLer.size();
		if (numPag > numLidas+porLer)
			throw new PagInexistenteException(numLidas);
		if (numPag <= numLidas )
			res = this.pagLidas.get(numPag - 1);
		else
			res = this.pagPorLer.get(numPag-numLidas -1);
		return res.clone();
	}
}

public class Pagina implements Comparable<Pagina>, Serializable {
	private List<String> texto;
	public Pagina() {
		this.texto = new ArrayList<>();
	}
	//...
	/* método que devolve uma formatação do texto */
	public String reproduzPagina() {...}
}

public class PaginaComAudio extends Pagina implements Comparable<PaginaComAudio>,
Serializable {
	private String narrador;
	private List<Byte> som;
	//...
	public PaginaComAudio(List<String> texto, String narrador, List<Byte> audio) {
		super(texto);
		this.narrador = narrador;
		this.audio = new ArrayList<>(audio);
	}
	/* método que devolve uma formatação do texto e audio */
	public String reproduzPagina() {...}
}

public class Utilizador implements Serializable {
	private String numUser;
	private String nomeUser;
	private LocalDate dataAdesao; // data de adesão do utilizador à aplicação
	//...
}


// PERGUNTA 1
/* Efetue a declaração das variáveis de instância de `LivrosDigitais` e complete a declaração das variáveis de instância de Utilizador. Codifique o construtor parametrizado de Utilizador que recebe uma série de instâncias de Livro e que assume que estamos numa estratégia de **composição**, public Utilizador(String numUser, String nomeUser, Iterator<Livro> livros). */
public class LivrosDigitais{
	private List<Utilizadores> utilizadores;
}


public class Utilizador implements Serializable {
	private String numUser;
	private String nomeUser;
	private LocalDate dataAdesao; // data de adesão do utilizador à aplicação
	private List<Livro> colecaoLivros; 
	
	public Utilizador(String numUser, String nomeUser, Iterator<Livro> livros){
		this.numUser = numUser;
		this.nomeUser = nomeUser;
		this.dataAdesao = LocalDate.now();
		this.colecaoLivros = new ArrayList<>();

		//Por ser um iterador
		while(livros.hasNext()) { this.colecaoLivros.add(livros.next()); }
	}

}