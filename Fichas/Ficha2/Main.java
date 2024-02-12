package Ficha2;

import java.util.Scanner;

public class Main {
    public static void main (String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.print("Exercicio: ");
        int ex = sc.nextInt();
        int i, j;

        switch(ex){
            case 1: 
                //Inicializar o array
                Array array = new Array();
                System.out.print("Alinea: ");
                String alinea = sc.next();
                System.out.print("Numero de inteiros que quer introduzir: ");
                int size = sc.nextInt();
                switch(alinea){
                    case "a":
                        int min = array.lerDevolveMinimo(size);
                        System.out.print("min: " + min);
                        break;
                    case "b":
                        array.devolverEntreIndices(size);
                        break;
                    case "c":
                        int[] comuns = new int[size];
                        array.Comuns(size, comuns);
                        break;
                }
                break;

            case 2:
                System.out.print("Exercício por fazer.");
                break;
            
            case 3:
                //Inicializar o array
                Array array_3 = new Array();
                System.out.print("Alinea: ");
                String alinea_3 = sc.next();
                System.out.print("Numero de inteiros que quer introduzir: ");
                int size_3 = sc.nextInt();
                switch(alinea_3){
                    case "a":
                        array_3.ordenaCrescente(size_3);
                        break;
                    case "b":
                        array_3.procuraBinaria(size_3);
                        break;
                }
                break;
            
            case 4: 
                System.out.print("Exercício por fazer.");
                break;
            
            case 5:
                Turma t = new Turma(5, 5);
                System.out.print("Alinea: ");
                String alinea5 = sc.next();
                
                //preencher o array para que possa ser usado em tds alineas
                System.out.print("Vamos preencher a matriz de notas");
                for(i=0; i<5; i++){
                    for(j=0; j<5; j++){
                        System.out.println("Aluno: " + i);
                        System.out.println("UC: " + j);
                        System.out.print("Nota: ");
                        int nota = sc.nextInt();
                        t.atualizaPauta(i, j, nota);
                    }
                }

                switch (alinea5){
                    case "b":
                        System.out.print("Indice da UC: ");
                        int ucInd = sc.nextInt();
                        int soma = t.somaNotasUC(ucInd);
                        System.out.print("A soma de notas da UC é " + soma);
                        break;
                    
                    case "c":
                        System.out.print("Aluno: ");
                        int alunoId = sc.nextInt();
                        float mediaA = t.mediaAluno(alunoId);
                        System.out.print("A média do aluno " + alunoId + "é " + mediaA);
                        break;

                    case "d":
                        System.out.print("Indice da UC: ");
                        int uc = sc.nextInt();
                        float mediaUC = t.mediaNotasUC(uc);
                        System.out.print("A média de notas da UC " + uc + "é " + mediaUC);
                        break;

                    case "e":
                        int maisA = t.notaMaisALta();
                        System.out.print("A nota mais alta de todas as UCs é " + maisA);
                        break;

                    case "f":
                        int maisB = t.notaMaisALta();
                        System.out.print("A nota mais baixa de todas as UCs é " + maisB);
                        break;
                        
                    case "g":
                        out.println("Insira um numero inteiro: ");
                        int valor = sc.nextInt();
                        t.acimaDe(valor);
                        break;
                    
                    case "h":
                        System.out.println("Notas de todos os alunos do curso");
                        t.todasNotas();
                        break;
                    
                    case "i":
                        System.out.println("Indice da Uc com maior media: " + t.maiorMediaUC());
                        break;
                    
                    default:
                        out.println("Alinea inexistente");
                        break;
                
                    }
                break;

        }
    }
}
