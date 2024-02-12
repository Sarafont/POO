package Ficha6;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class Utilizador {
    private String email; //chave do utilizador
    private String passord;
    private String nome;
    private String genero;
    private int altura; //em cm
    private float peso;
    private LocalDate dataNascimento;
    private LocalDate dataRegisto;
    private String desportoFav;
    private List<Atividade> atividades; 

    public Utilizador(){
        this.email = "";
        this.passord = "";
        this.nome = "";
        this.genero = "";
        this.altura = 0;
        this.peso = 0;
        this.dataNascimento = LocalDate.now();
        this.dataRegisto = LocalDate.now();
        this.desportoFav = "";
        this.atividades = new ArrayList<>();
    }

    public Utilizador(String email, String pwd, String nome, String gn, int alt, float peso2, LocalDate dataN, LocalDate dataR, String d){
        this.email = email;
        this.passord = pwd;
        this.nome = nome;
        this.genero = gn;
        this.altura = alt;
        this.peso = peso2;
        this.dataNascimento = dataN;
        this.dataRegisto = dataR;
        this.desportoFav = d;
        this.atividades = new ArrayList<>();
    }

    public Utilizador(Utilizador u) {
        this(u.email, u.passord, u.nome, u.genero, u.altura, u.peso, u.dataNascimento, u.dataRegisto, u.desportoFav);
    }


    public boolean equals (Object o){
        if(this == o) {return true;}
        if((o==null) || this.getClass() != o.getClass()){return false;}
        Utilizador u = (Utilizador) o;
        return(this.email.equals(u.email) && 
               this.passord.equals(u.passord) &&
               this.nome.equals(u.nome) &&
               this.genero.equals(u.genero) &&
               this.altura == u.altura &&
               this.peso == u.peso &&
               this.dataNascimento.equals(u.dataNascimento) &&
               this.dataRegisto.equals(u.dataRegisto) &&
               this.desportoFav.equals(u.desportoFav));
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Email: ");
        sb.append(email);
        sb.append("\nPassword: ");
        sb.append(passord);
        sb.append("\nNome: ");
        sb.append(nome);
        sb.append("\nGenero: ");
        sb.append(genero);
        sb.append("\nAltura: ");
        sb.append(altura);
        sb.append("\nPeso: ");
        sb.append(peso);
        sb.append("\nData Nascimento: ");
        sb.append(dataNascimento);
        sb.append("\nData Registo: ");
        sb.append(dataRegisto);
        sb.append("\nDesporto favorito: ");
        sb.append(desportoFav);
        return sb.toString();
    }


    public Utilizador clone(){
        return new Utilizador(this);
    }

    public void adicionaAtividade(Atividade a){
        this.atividades.add(a);
    }

    //Getters and Setters
    public String getEmail() {
        return this.email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPassord() {
        return this.passord;
    }
    public void setPassord(String passord) {
        this.passord = passord;
    }
    public String getNome() {
        return this.nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getGenero() {
        return this.genero;
    }
    public void setGenero(String genero) {
        this.genero = genero;
    }
    public int getAltura() {
        return this.altura;
    }
    public void setAltura(int altura) {
        this.altura = altura;
    }
    public float getPeso() {
        return this.peso;
    }
    public void setPeso(float peso) {
        this.peso = peso;
    }
    public LocalDate getDataNascimento() {
        return this.dataNascimento;
    }
    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
    public LocalDate getDataRegisto() {
        return this.dataRegisto;
    }
    public void setDataRegisto(LocalDate dataRegisto) {
        this.dataRegisto = dataRegisto;
    }
    public String getDesportoFav() {
        return this.desportoFav;
    }
    public void setDesportoFav(String deportoFav) {
        this.desportoFav = deportoFav;
    }
    public List<Atividade> getAtividades() {
        return this.atividades;
    }

    public void setAtividades(List<Atividade> atividades) {
        this.atividades = atividades;
    }
}
