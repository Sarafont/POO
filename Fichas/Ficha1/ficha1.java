package Ficha1;

public class ficha1{
    // Ex. 1
    public double celsiusParaFarenheit (double graus){
        double f = (graus * 9 / 5) + 32;
        return f;
    }

    // Ex. 2
    public int maximoNumeros(int a, int b){
        int max = Math.max(a,b);
        return max;
    }

    // Ex. 3
    public String criaDescricaoConta (String nome, double saldo){
        return ("Nome: " + nome + " Saldo: " + saldo);
    }
    
    // Ex. 4
    public double eurosParaLibras (double valor, double taxaConversao){
        double libras = valor * taxaConversao;
        return libras;
    }

    // Ex. 5
    // Feito no main

    // Ex. 6
    public long factorial (int num){
        if (num == 1){
            return 1;
        } else {
            return (num * factorial(num - 1));
        }
     }
}
