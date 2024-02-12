package Ficha6;

import java.time.LocalDate;
import java.time.Period;

public class Corrida extends Atividade{
    private double distancia;
    private double altimetriaGanha;
    private String percurso;

    public Corrida(){
        super(null);
        this.distancia = 0;
        this.altimetriaGanha = 0;
        this.percurso = "";
    }

    public Corrida(String codigo, String descricao, LocalDate data, int duracao, double distancia, double altimetriaGanha, String percurso) {
        super(codigo, descricao, data, duracao);
        this.distancia = distancia;
        this.altimetriaGanha = altimetriaGanha;
        this.percurso = percurso;
    }

    public Corrida (Corrida c){
        super(c);
        this.distancia = c.getDistancia();
        this.altimetriaGanha = c.getAltimetriaGanha();
        this.percurso = c.getPercurso();
    }

    public boolean equals (Object o){
        if(this == o) {return true;}
        if((o==null) || this.getClass() != o.getClass()){return false;}
        Corrida c = (Corrida) o;
        return(this.distancia == (c.distancia) && 
               this.altimetriaGanha == (c.altimetriaGanha) &&
               this.percurso.equals(c.percurso));
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Distancia: ");
        sb.append(distancia);
        sb.append("\nAltimetria Ganha: ");
        sb.append(altimetriaGanha);
        sb.append("\nPercurso: ");
        sb.append(percurso);
        return sb.toString();
    }

    public Corrida clone(){
        return new Corrida(this);
    }

    //CaloriasCorrida = distancia ∗ pesoutilizador ∗ tempo ∗ idade/50
    public double caloriasCorrida(Utilizador u){
        //obter a idade
        Period periodo = Period.between(u.getDataNascimento(), LocalDate.now());
        int idade = periodo.getYears();

        return ((this.distancia * idade * this.getDuracao() * u.getPeso()) / 50);
    }


    //Getters and setters
    public double getDistancia() {
        return distancia;
    }

    public void setDistancia(double distancia) {
        this.distancia = distancia;
    }

    public double getAltimetriaGanha() {
        return altimetriaGanha;
    }

    public void setAltimetriaGanha(double altimetriaGanha) {
        this.altimetriaGanha = altimetriaGanha;
    }

    public String getPercurso() {
        return percurso;
    }

    public void setPercurso(String percurso) {
        this.percurso = percurso;
    }
}
