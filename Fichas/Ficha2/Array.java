package Ficha2;

import java.util.Arrays;
import java.util.Scanner;

public class Array{
    //ler do input
    Scanner scan = new Scanner(System.in);

    // 1) 
    //(a) determina o valor minimo do array
    public int lerDevolveMinimo (int size){
        int[] array = new int[size]; //criamos o array de inteiros
        int i;

        //preencher o array com o número ate size
        for(i=0; i<size; i++){
            System.out.print("Insere um número: ");
            int numero = scan.nextInt();
            array[i] = numero;
        }

        int min = array[0];
        for(i=0; i<size; i++){
            if(array[i] < min){
                min = array[i];
            }
        }

        return min;
    }

    // (b)
    public void devolverEntreIndices (int size){
        int[] array = new int[size];
        int i;

        //preencher o array
        for(i=0; i<size; i++){
            System.out.print("Insira um número: ");
            int numero = scan.nextInt();
            array[i] = numero;
        }

        System.out.println("Índice 1: ");
        int ind1 = scan.nextInt();
        System.out.println("Índice 2: ");
        int ind2 = scan.nextInt();

        //caso os indices estejam fora do limite
        if(ind1 < 0 || ind2 >= size){
            System.out.print("Indices inválidos.");
        }

        int[] entreInd = new int[ind2 - ind1];
        for(i=0; i<ind2-ind1; i+=1){
            entreInd[i] = array[i + ind1];
            System.out.print(entreInd[i]);
        }
    }

    // (c)
    public void Comuns (int size, int[] comuns){
        int[] array1 = new int[size];
        int[] array2 = new int[size];
        int i, j;

        //preencher array1
        for(i=0; i<size; i++){
            System.out.print("Insira um número: ");
            int numero = scan.nextInt();
            array1[i] = numero;
        }

        //preencher array2
        for(i=0; i<size; i++){
            System.out.print("Insira um número: ");
            int numero = scan.nextInt();
            array2[i] = numero;
        }

        for(i=0, j=0; i<size; i+=1){
            if(Arrays.binarySearch(array2, array1[i]) >= 0) {
                comuns[j] = array1[i];
                System.out.print(comuns[j]);
            }
            j += 1;
        }
    }

    //3)
    // (a)
    public void ordenaCrescente (int size){
        int[] array = new int[size];
        int i, j;

        //preencher o array
        for(i=0; i<size; i++){
            System.out.print("Insira um número: ");
            int numero = scan.nextInt();
            array[i] = numero;
        }

        //Array.sort(array);
        //ou
        int menor;
        for(i=0; i<size; i++){
            menor = i;
            for(j=i; j<size; j++){
                if(array[j] < array[menor]){
                    menor = j;
                }
                swap(array,i, menor);
            }
        }
    }

    private static void swap(int[] array, int x, int y) {
        int temp = array[x];
        array[x] = array[y];
        array[y] = temp;
    }

    // (b)
    public int procuraBinaria(int size){
        int[] array = new int[size];
        int i, j;

        //preencher o array
        for(i=0; i<size; i++){
            System.out.print("Insira um número: ");
            int numero = scan.nextInt();
            array[i] = numero;
        }

        System.out.print("Insira o número de procura: ");
        int x = scan.nextInt();

        return Arrays.binarySearch(array, x);
    }

}