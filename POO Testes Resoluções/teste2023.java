// GRUPO II

/* Considere as seguintes definições de classes de uma aplicação que implementa um sistema de gestão de trabalhos práticos de uma unidade curricular. A classe GestaoTrabalhos possui a informação dos alunos nela registados e dos grupos de alunos. Cada grupo conhece as entregas que são feitas na unidade curricular. Cada entrega de uma fase do trabalho prático é avaliada pela equipa docente, mas também por um outro aluno inscrito na unidade curricular, sendo que deverá ser necessário que este aluno não pertença ao grupo que efetua a entrega. Deverá também existir em GestaoTrabalhos uma data limite para determinar se uma entrega pode, ou não, ser efetuada. Para poder alterar essa data a classe GestaoTrabalhos deverá possuir um método public void setDataLimite(LocalDate dataLimite). Numa perspectiva mais operacional este sistema funciona como uma unidade curricular dos nossos cursos. Inicialmente os alunos não estão alocados a um grupo e posteriormente existe uma fase de inscrições e só nessa altura é que a informação em que se diz a que grupo pertence cada aluno é que é atualizada. Considere os seguintes excertos de código: */

import java.time.LocalDate;
import java.util.List;

public class Aluno implements Comparable<Aluno>, Serializable {
	private String codAluno;
	private String nomeAluno;
	private Grupo meuGrupo;
	private int notaTeorica;
	private int notaPratica;

	public void regista(Grupo g) {...}
	public int calculaNotaFinal() {...} // calcula a nota final de um aluno
}

public class Grupo implements Comparable<Grupo>, Serializable {
	private String codGrupo;
	private List<Entrega> entregas;
	public Grupo(String codGrupo) {...}

	public void addEntrega(Entrega e) {...}
	public int calculaNotaGrupo() {...}
}

public class Entrega implements Comparable<Entrega>, Serializable {
	private LocalDate data;
	private int nota_docente;
	private Aluno avaliador;
	private int nota_avaliador;
	private String comentarios;

	public int calculaNotaEntrega() {...} //método que calcula a nota desta entrega
}

/* Assuma, para as perguntas seguintes, que os métodos usuais (get, set, equals, clone, hashcode, ...) estão disponíveis, a menos que sejam solicitados, e responda às questões: */


// PERGUNTA 6
/* Efetue a declaração das variáveis de instância de GestaoTrabalhos, sabendo que esta deverá ter acesso aos alunos e aos grupos e justifique a escolha das estruturas de dados que faz. Considere que a estratégia de associação entre a GestaoTrabalhos e os alunos e grupos é de composição e entre Aluno e Grupo é de agregação (partilha o apontador) conforme está patente no código da classe Aluno. Codifique também o método public void adicionaAluno(Aluno a) throws ... , da classe GestaoTrabalhos, que adiciona um aluno, verificando que o mesmo não exista (não necessita de fazer o código da classe de excepção). */
public class GestaoTrabalhos{
	List<Aluno> alunos;
	List<Grupo> grupos;
	LocalDate dataLimite; //pedida no enunciado principal

	public void setDataLimite (LocalDate dataLimite){
		this.dataLimite = dataLimite;
	}

	public void adicionaAluno(Aluno a) throws AlunoInexistenteEception{
		for (Aluno a : this.alunos){
			if(this.alunos.contains(a)){
				this.alunos.add(a);
			} else {throw new AlunoInexistenteEception(); }
		} 
	}
}
//A lista permite a adição e remoção dinâmica de alunos, além de possibilitar a iteração sobre eles quando necessário.


// PERGUNTA 7
/* Codifique o método public Entrega melhorEntrega(), que determina a Entrega com melhor nota de todas as existentes no sistema. Caso exista mais do que uma entrega com a mesma nota deverá ser devolvida aquela cujo código de grupo seja alfabeticamente menor.*/
//Normal
public Entrega melhorEntrega(){
	Entrega melhor = new Entrega();

	for(Grupo g: this.grupos){
		for(Entrega e: g.getEntregas()){
			if(e.calculaNotaEntrega() > melhor.calculaNotaEntrega() || melhor == null){
					melhor = e.clone();
			} else if (e.calculaNotaEntrega() == melhor.calculaNotaEntrega()){
				//escolher a que seja alfabeticamente menor!
				if (g.getCodGrupo().compareTo(melhorEntrega.getGrupo().getCodGrupo()) < 0) {
	        melhor = e.clone();
				}
			}
		}
	}
	return melhor;
}


//Com iterador interno -> DIFICIL!
public Entrega melhorEntrega() {
	return this.grupos.stream()
										//transformar cada grupo num fluxo de entregas:
										.flatMap(grupo -> grupo.getEntregas().stream())
										//primeiro compara as notas, depois compara os códigos dos grupos alfabeticamente
										.max(Comparator.comparingInt(Entrega::calculaNotaEntrega)
		                .thenComparing(entrega -> entrega.getGrupo().getCodGrupo()))
										//para retornar null caso não haja entregas no sistema
										.orElse(null);
}



// PERGUNTA 8
/* Codifique o método `public void adicionaEntrega(String codGrupo, Entrega e) throws ...`, da classe `GestaoTrabalhos`, que deverá inserir uma entrega nas entregas de um grupo. Esta operação só deverá ser possível caso o aluno que aparece como avaliador na entrega **não pertença ao grupo indicado** como parâmetro e a **data limite** que está definida não tenha sido ultrapassada. */
public void adicionaEntrega(String codGrupo, Entrega e) 
									throws AvaliadorNoGrupo, DataUltrapassada{
	for(Grupo g: this.grupos){
		if(g.getCodigoGrupo().equals(codGrupo)){
			if(e.getAvaliador().getCodGrupo().equals(codGrupo)){ 
				throws new AvaliadorNoGrupo(); 
			} else {
				if(this.dataLimite > e.data){
					g.addEntrega(e);
				} else {throw new DalaUltrapassada();}
			}
		}
	}

}



// PERGUNTA 9 → Dúvida!
/*Para a classe `GestaoTrabalhos` codifique o seu construtor, `public GestaoTrabalhos (Collection<Aluno> alunos, Map<String,String> alunosGrupo, LocalDate dataLimite)`, que recebe uma série de instâncias de Aluno e um `Map<String,String>` que contém uma relação Numero Aluno -> Código do seu grupo e cria uma instância válida de `GestaoTrabalhos`, com todos os alunos e grupos, respeitando a associação entre alunos e grupos expressa no `Map`. Note que os grupos terão de ser criados neste construtor.*/
public GestaoTrabalhos (Collection<Aluno> alunos, Map<String, String> alunosGrupo,
												LocalDate dataLimite){
	this.alunos = new ArrayList<>(alunos); //copiamos os alunos da Collection para inicializar a lista
	this.grupos = criaGrupos(alunosGrupo);
	this.dataLimite = dataLimite;
	atualizarGruposAlunos(); //not sure
	//atualizar os grupos de acordo com as informações do mapa
}

public List<Grupo> criaGrupos(Map<String, String> alunosGrupo){
	List<Grupo> grupos = new ArrayList<>();

  //Criar grupos com base no mapa de relação alunosGrupo
  for (String codGrupo : new HashSet<>(alunosGrupo.values())) {
      this.grupos.add(new Grupo(codGrupo));
  }
  return this.grupos;
}

private void atualizarGruposAlunos() {
  for (Aluno aluno: this.alunos) {
      String codGrupo = alunosGrupo.get(aluno.getCodAluno());
      Grupo grupo = buscarGrupoPorCodigo(codGrupo);

      if (grupo != null) {
          aluno.regista(grupo);
      }
  }
}
