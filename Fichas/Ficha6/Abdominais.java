package Ficha6;

import java.time.LocalDate;

public class Abdominais extends Atividade {
    private String tipo;
    private int reps;

    public Abdominais(){
        this.tipo = "";
        this.reps = 0;
    }

    public Abdominais(String codigo, String descricao, LocalDate data, int duracao, String t, int rp) {
        super(codigo, descricao, data, duracao);
        this.tipo = t;
        this.reps = rp;
    }

    public Abdominais (Abdominais a){
        super(a);
        this.tipo = a.getTipo();
        this.reps = a.getReps();
    }

    public boolean equals (Object o){
        if(this == o) {return true;}
        if((o==null) || this.getClass() != o.getClass()){return false;}
        Abdominais a = (Abdominais) o;
        return(this.tipo.equals(a.tipo) && this.reps == a.reps);
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Tipo : ");
        sb.append(tipo);
        sb.append("\nRepetições: ");
        sb.append(reps);
        return sb.toString();
    }

    public Abdominais clone(){
        return new Abdominais(this);
    }


    //CaloriasAbdominais = tempo ∗ repeticoes ∗ 3/5
    public double caloriasCanoagem(Utilizador u){
        return ((this.getDuracao() * this.getReps() * 3) / 5);
    }


    //Getters and setters
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getReps() {
        return reps;
    }

    public void setReps(int reps) {
        this.reps = reps;
    }


}
