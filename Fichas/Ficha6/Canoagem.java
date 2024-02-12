package Ficha6;

import java.time.LocalDate;
import java.time.Period;

public class Canoagem extends Atividade {
    private String embarcacao;
    private double velocidadeVento;
    private String direcaoVento;
    private double distanciaPercorrida;
    private int numVoltasPista;

    public Canoagem() {
        super();
        this.embarcacao = "";
        this.velocidadeVento = 0;
        this.direcaoVento = "";
        this.distanciaPercorrida = 0;
        this.numVoltasPista = 0;
    }

    public Canoagem(String codigo, String descricao, LocalDate data, int duracao, String embarcacao, double velocidadeVento, String direcaoVento, double distanciaPercorrida, int numVoltasPista) {
        super(codigo, descricao, data, duracao);     
        this.embarcacao = embarcacao;
        this.velocidadeVento = velocidadeVento;
        this.direcaoVento = direcaoVento;
        this.distanciaPercorrida = distanciaPercorrida;
        this.numVoltasPista = numVoltasPista;
    }

    public Canoagem (Canoagem c){
        super(c);
        this.embarcacao = c.getEmbarcacao();
        this.velocidadeVento = c.getVelocidadeVento();
        this.direcaoVento = c.getDirecaoVento();
        this.distanciaPercorrida = c.getDistanciaPercorrida();
        this.numVoltasPista = c.getNumVoltasPista();
    }

    public boolean equals (Object o){
        if(this == o) {return true;}
        if((o==null) || this.getClass() != o.getClass()){return false;}
        Canoagem c = (Canoagem) o;
        return(this.embarcacao.equals(c.embarcacao) && 
               this.velocidadeVento == (c.velocidadeVento) &&
               this.direcaoVento.equals(c.direcaoVento) &&
               this.distanciaPercorrida == (c.distanciaPercorrida) &&
               this.numVoltasPista == (c.numVoltasPista));
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Embarcação: ");
        sb.append(embarcacao);
        sb.append("\nVelocidade do Vento: ");
        sb.append(velocidadeVento);
        sb.append("\nDireção do vento: ");
        sb.append(direcaoVento);
        sb.append("\nDistancia percorrida: ");
        sb.append(distanciaPercorrida);
        sb.append("\nNumero de voltas: ");
        sb.append(numVoltasPista);
        return sb.toString();
    }

    public Canoagem clone(){
        return new Canoagem(this);
    }


    //CaloriasCanoagem = distancia ∗ ventocontra ∗ tempo ∗ idade/4
    public double caloriasCanoagem(Utilizador u){
        Period periodo = Period.between(u.getDataNascimento(), LocalDate.now());
        int idade = periodo.getYears();

        return ((this.distanciaPercorrida * this.velocidadeVento * this.getDuracao() * idade) / 4);
    }


    //Getters and Setters
    public String getEmbarcacao() {
        return embarcacao;
    }

    public void setEmbarcacao(String embarcacao) {
        this.embarcacao = embarcacao;
    }

    public double getVelocidadeVento() {
        return velocidadeVento;
    }

    public void setVelocidadeVento(double velocidadeVento) {
        this.velocidadeVento = velocidadeVento;
    }

    public String getDirecaoVento() {
        return direcaoVento;
    }

    public void setDirecaoVento(String direcaoVento) {
        this.direcaoVento = direcaoVento;
    }

    public double getDistanciaPercorrida() {
        return distanciaPercorrida;
    }

    public void setDistanciaPercorrida(double distanciaPercorrida) {
        this.distanciaPercorrida = distanciaPercorrida;
    }

    public int getNumVoltasPista() {
        return numVoltasPista;
    }

    public void setNumVoltasPista(int numVoltasPista) {
        this.numVoltasPista = numVoltasPista;
    }
}
