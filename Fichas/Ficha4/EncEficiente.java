package Ficha4;

import java.time.LocalDate;
import java.util.ArrayList;

public class EncEficiente{
    private String nome;
    private long NIF;
    private String morada;
    private int numEnc;
    private LocalDate data;
    private ArrayList<LinhaDeEncomenda> linhasEnc;
    
    public EncEficiente() {
        this.nome = "";
        this.NIF = 0;
        this.morada = "";
        this.numEnc = 0;
        this.data = LocalDate.now();
        this.linhasEnc = new ArrayList<>();
    }
    
    public EncEficiente(String nome, long nif, String morada, int numE, LocalDate dt, ArrayList<LinhaDeEncomenda> linhasE){ 
        this.nome = nome;
        this.NIF = nif;
        this.morada = morada;
        this.numEnc = numE;
        this.data = data;
        this.linhasEnc = linhasE;
    }
    
    public EncEficiente(EncEficiente e) {
        this(e.nome, e.NIF, e.morada, e.numEnc, e.data, e.linhasEnc);
    }
    
    
    public String getNome() {
        return this.nome;
    }
    
     public void setNome(String nome) {
        this.nome = nome;
    }

    public long getNIF() {
        return this.NIF;
    }

    public void setNIF(long NIF) {
        this.NIF = NIF;
    }

    public String getMorada() {
        return this.morada;
    }

    public void setMorada(String morada) {
        this.morada = morada;
    }

    public int getNumEnc() {
        return this.numEnc;
    }

    public void setNumEnc(int numEnc) {
        this.numEnc = numEnc;
    }

    public LocalDate getData() {
        return this.data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public ArrayList<LinhaDeEncomenda> getLinhasEncomendas() {
        return this.linhasEnc;
    }

    public void setLinhasEncomendas(ArrayList<LinhaDeEncomenda> le) {
        this.linhasEnc = le;
    }

    public EncEficiente clone() {
        return new EncEficiente(this);
    }
    
    public boolean equals(Object o) {
        if(o==this) 
           return true;
        if(o==null || o.getClass() != this.getClass()) 
           return false;
        EncEficiente enc = (EncEficiente) o;

        return(
              this.nome.equals(enc.nome) && 
              this.NIF == enc.NIF && 
              this.morada.equals(enc.morada) && 
              this.numEnc == enc.numEnc &&
              this.data.equals(enc.data) && 
              this.linhasEnc.equals(enc.linhasEnc)); 
    }
    
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Linha Encomenda:: {");
        sb.append("\nNome do Cliente: ").append(this.nome);
        sb.append("\nNIF do cliente: ").append(this.NIF);
        sb.append("\nMorada do Cliente: ").append(this.morada);
        sb.append("\nNúmero da Encomenda: ").append(this.numEnc);
        sb.append("\nData da Encomenda: ").append(this.data);
        sb.append("\nLinhas de Encomenda").append(this.linhasEnc).append("}");
        return sb.toString();
    }

    // 2)
    // (b) ii - Valor total da encomenda
    public double calculaValorTotal(){
        return this.linhasEnc.stream()
                             .(LinhaDeEncomenda::calculaValorDesconto)
                             .sum();
    }

    // (b) iii
    public double calculaValorDesconto(){
        return this.linhasEnc.stream()
                             .mapToDouble(LinhaDeEncomenda: calculaValorDesconto)
                             .sum();
    }

    // (b) iv
    public int numeroTotalProdutos(){
        return this.linhasEnc.stream().mapToInt(LinhaDeEncomenda::getQuantidade).sum();
    }
    
}
