package Ficha2;

public class Turma {
    private int[][] notasTurma;
    private int numAlunos; 
    private int ucs; 

    public Turma(int numA, int ucs){
        notasTurma = new int[numAlunos][ucs];
        this.numAlunos = numA;
        this.ucs = ucs;
    }

    public void setNota (int aluno, int uc, int nova_nota){
        this.notasTurma[aluno][uc] = nova_nota;
    }

    public int getNota(int aluno, int uc){
        return this.notasTurma[aluno][uc];
    }


    // Ex. 2
    // (a)
    public void atualizaPauta (int aluno, int uc, int nota){
        setNota(aluno,uc,nota);
    }

    // (b)
    public int somaNotasUC (int uc){
        int soma = 0, i;
        //percorremos o array da uc
        for(i=0; i<this.ucs; i++){
            soma += getNota(i, uc);
        }
        return soma;
    }

    // (c)
    public float mediaAluno (int aluno){
        float media = 0, soma=0;
        int i;
        //percorremos as UCs
        for(i=0; i<this.ucs; i++){
            soma += this.notasTurma[aluno][i];
        }
        media = soma/this.ucs;
        return media;
    }

    // (d)
    public float mediaNotasUC (int ucIndex){
        int soma=0, media =0;
        int i;
        
        for(i=0; i<this.numAlunos; i++){
            soma += this.notasTurma[i][ucIndex];
        }

        media = soma/this.numAlunos;

        return media;
    }

    // (e)
    public int notaMaisALta(){
        int maisAlta = notasTurma[0][0];
        int i, j;

        for(i=0; i<this.numAlunos; i++){
            for(j=0; j<this.ucs; j++){
                if(notasTurma[i][j] > maisAlta){
                    maisAlta = notasTurma[i][j];
                }
            }
        }
        
        return maisAlta;
    }

    // (f)
    public int notaMaisBaixa(){
        int maisBaixa = notasTurma[0][0];
        int i, j;

        for(i=0; i<this.numAlunos; i++){
            for(j=0; j<this.ucs; j++){
                if(notasTurma[i][j] < maisBaixa){
                    maisBaixa = notasTurma[i][j];
                }
            }
        }
        
        return maisBaixa;
    }

    // (g)
    public int[] acimaDe (int valor){
        int[] res = new int[this.numAlunos*this.ucs];
        int i=0;

        //iterar sobre os arrays de notas de cada aluno
        for(int[] aluno: this.notasTurma){
            //itera sobre as notas de cada aluno
            for(int nota: aluno){
                if(nota > valor){
                    res[i++] = nota; //acrescenta a nota ao array
                }
            }
        }

        int[] result = new int[i]; //array com tamanho da qt de notas maiores do que o valor
        //copiar para result as notas inseridas no res
        System.arraycopy(res, 0, result, 0, i);
        return result;
    }

    // (h)
    public String todasNotas(){
        String notas = "Notas dos Alunos: \n";

        int i,j;
        for(i=0; i<this.numAlunos; i++){
            notas = notas.concat("Aluno " + i + ":\n");
            for(j=0; j<this.ucs; j++){
                notas = notas.concat("UC " + j + ": " + this.notasTurma[i][j] + "\n");
            }
        }

        return notas;
    }

    // (i) Devolve o ÍNDICE!!
    public int maiorMediaUC (){
        double media, maxMedia = this.mediaNotasUC(0);
        int max=0, i;

        for(i=0; i<this.ucs; i++){
            media = this.mediaNotasUC(i);
            if(media > maxMedia){
                maxMedia = media;
                max = i;
            }
        }

        return max;
    }

}
