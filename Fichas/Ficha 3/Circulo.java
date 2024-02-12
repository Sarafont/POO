public class Circulo {
    private double x;
    private double y;
    private double raio;

    /*
     * Construtor por omissão
     */
    public Circulo(){
        this.x = 0;
        this.y = 0;
        this.raio = 0;
    }

    /*
     * Construtor parametrizado
     */
    public Circulo(double cx, double cy, double r){
        this.x = cx;
        this.y = cy;
        this.raio = r;
    }

    public Circulo(Circulo c) {
        this();
    }

    /*
     * Construtor de cópia
     */
    public void Circulo(Circulo c){
        this.x = c.getX();
        this.y = c.getY();
        this.raio = c.getRaio();
    }


    /*
     * métodos de instancia
     */


    /*
     * Devolve o valor da coordenada em x
     *  
     * @return valor da coordenada x 
     */
    public double getX(){
        return this.x;
    }

    /*
     * Devolve o valor da coordenada em y
     *  
     * @return valor da coordenada y
     */
    public double getY(){
        return this.y;
    }

    /*
     * Devolve o valor do raio
     *  
     * @return valor do raio
     */
    public double getRaio(){
        return this.raio;
    }

    /*
     * Altera o valor da coordenada em x
     *  
     * @return valor da coordenada x 
     */
    public void setX(double cx){
        this.x = cx;
    }

    /*
     * Altera o valor da coordenada em x
     *  
     * @return valor da coordenada x 
     */
    public void setY(double cy){
        this.y = cy;
    }

    /*
     * Altera o valor da coordenada em x
     *  
     * @return valor da coordenada x 
     */
    public void setRaio(double r){
        this.raio = r;
    }

    /*
     * Método que implementa a igualdade entre dois pontos
     * @param o objecto que é comparado com o receptor da mensagem
     * @return boolean resultado booleano da comparação do parâmetro com o receptor
     * 
     */
    public boolean equals (Object o){
        if(this == o){
            return true;
        }
        if((o == null) || (this.getClass() != o.getClass())){
            return false;
        }
        Circulo c = (Circulo) o ;
        return (this.x == c.getX() && this.y == c.getY() && this.raio == c.getRaio()); 
    }

    /*
     * Devolve a representação do ponto e o valor do raio
     * @return String com as coordenadas x, y e raio
     */
    public String toString(){
        return "Centro = " + this.x + "-" + this.y + "\n"
                + "Raio = " + this.raio + "\n";
    }

    public Circulo clone(){
        return new Circulo(this);
    }

    // 1)
    // (e)
    public void alteraCentro(double x, double y){
        this.setX(x);
        this.setY(y);
    }

    // (f) Area do circulo -> pi * r²
    public double calculaArea(){
        return Math.PI * Math.pow(raio, 2);
    }

    // (g) Perimetro do circulo
    public double calculaPerimetro(){
        return (2 * Math.PI * this.raio);
    }
}
