package Ficha6;

import java.time.LocalDate;

public class Atividade {
    private String codigo;
    private String descricao;
    private LocalDate dataRealizacao;
    private int duracao; //em minutos

    public Atividade(){
        this.codigo = "";
        this.descricao = "";
        this.dataRealizacao = LocalDate.now();
        this.duracao = 0;
    }

    public Atividade(String codigo, String descricao, LocalDate data, int duracao) {
        this.codigo = codigo;
        this.descricao = descricao;
        this.dataRealizacao = data;
        this.duracao = duracao;
    }

    public Atividade (Atividade a){
        this(a.codigo, a.descricao, a.dataRealizacao, a.duracao);
    }

    public boolean equals (Object o){
        if(this == o) {return true;}
        if((o==null) || this.getClass() != o.getClass()){return false;}
        Atividade a = (Atividade) o;
        return(this.codigo.equals(a.codigo) && 
               this.descricao.equals(a.descricao) &&
               this.dataRealizacao.equals(a.dataRealizacao) &&
               this.duracao == a.duracao);
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Codigo: ");
        sb.append(codigo);
        sb.append("\nDescrição: ");
        sb.append(descricao);
        sb.append("\nData de realização: ");
        sb.append(dataRealizacao);
        sb.append("\nDuração em minutos: ");
        sb.append(duracao);
        return sb.toString();
    }


    public Atividade clone(){
        return new Atividade(this);
    }

    //Getters and Setters
    public String getCodigo() {
        return codigo;
    }
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public LocalDate getDataRealizacao() {
        return dataRealizacao;
    }
    public void setDataRealizacao(LocalDate dataRealizacao) {
        this.dataRealizacao = dataRealizacao;
    }
    public int getDuracao() {
        return duracao;
    }
    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }
}
