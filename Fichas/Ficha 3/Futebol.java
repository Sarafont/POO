public class Futebol {
    private int estado; //0-> por iniciar | 1-> a decorrer | 2-> terminado
    private int golosVisitado;
    private int golosVisitante;
    
    public Futebol(){
        this.estado = 0;
        this.golosVisitado = 0;
        this.golosVisitante = 0;
    }

    public Futebol(int est, int gVisitado, int gVisitante){
        this.estado = est;
        this.golosVisitado = gVisitado;
        this.golosVisitante = gVisitante;
    }

    public Futebol(Futebol jogo) {
        this.estado = jogo.getEstado();
        this.golosVisitado = jogo.getGolosEquipaVisitada();
        this.golosVisitante = jogo.getGolosEquipaVisitante();
    }


    //Getters and Setters
    public int getEstado(){
        return this.estado;
    }

    public int getGolosEquipaVisitada(){
        return this.golosVisitado;
    }

    public int getGolosEquipaVisitante(){
        return this.golosVisitante;
    }

    public void setEstado(int est){
        this.estado = est;
    }

    public void setGolosEqVisitada(int gVisitada){
        this.golosVisitado = gVisitada;
    }

    public void setGolosEqVisitante(int gVisitante){
        this.golosVisitante = gVisitante;
    }

    // (a)
    public void startGame(){
        this.setEstado(0);
    }

    // (b)
    public void endGame(){
        this.setEstado(2);
    }

    // (c) Adiciona um golo a esquipa visitada
    public void goloVisitado(){
        this.setGolosEqVisitada(golosVisitado+1);
    }

    // (d)
    public void goloVisitante(){
        this.setGolosEqVisitante(golosVisitante+1);
    }

    // (e)
    public String estadoAtual (){
        return ("Equipa Visitada: " + this.golosVisitado + "\n"
                + "Equipa Visitantes: " + this.golosVisitante);
    }
}
