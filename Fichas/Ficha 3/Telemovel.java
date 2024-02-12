//incompleto -> so fiz até à c

public class Telemovel {
    private String marca;
    private String modelo;
    private int xDisplay;
    private int yDisplay;

    private int numMens;
    private String[] mensagens;
    private int armzFotosApps;
    private int armzFotos;
    private int armzApps;
    private int espacoOcupado;

    private int numFotosGuardadas;
    private int numAppsInstaladas;
    private String[] appsInstaladas;

    /*
     * Construtor por omissão
     */
    public Telemovel(){
        this.setMarca("");
        this.setModelo("");
        this.setxDisplay(300);
        this.setyDisplay(1024);
        this.setNumeroMensagens(0);
        this.setMensagens(128);
        this.setArmazenamentoFotosApps(512);
        this.setArmazenamentoFotos(128);
        this.setArmazenamentoApps(384);
        this.setEspacoOcupado(0);
        this.setNumFotosGuardadas(0);
        this.setNumAppsInstaladas(0);
        this.setNomeAppsInstaladas(384);
    }

    /*
     * Construtor parametrizado
     */
    public Telemovel(String marca, String modelo, int xDisplay, int yDisplay, int numeroMensagens, int armFotosApps, int armFotos, int armApps){
        this.setMarca(marca);
        this.setModelo(modelo);
        this.setxDisplay(xDisplay);
        this.setyDisplay(yDisplay);
        this.setNumeroMensagens(0);
        this.setMensagens(numeroMensagens);
        this.setArmazenamentoFotosApps(armFotosApps);
        this.setArmazenamentoFotos(armFotos);
        this.setArmazenamentoApps(armApps);
        this.setEspacoOcupado(0);
        this.setNumFotosGuardadas(0);
        this.setNumAppsInstaladas(0);
        this.setNomeAppsInstaladas(armApps);
    }

    public Telemovel(Telemovel t){
        this(t.getMarca(), t.getModelo(), t.getxDisplay(), t.getyDisplay(), t.getNumeroMensagens(), t.getArmazenamentoFotosApps(), t.getArmazenamentoFotos(), t.getArmazenamentoApps());
    }

    public boolean equals(Object umTelemovel){
        if(this == umTelemovel)
            return true;

        if((umTelemovel == null) || (this.getClass() != umTelemovel.getClass()))
            return false;

        Telemovel t = (Telemovel)umTelemovel;

        return (this.getMarca().equals(t.getMarca()) && this.getModelo().equals(t.getModelo())        &&
                this.getxDisplay() == t.getxDisplay() && this.getyDisplay() == t.getyDisplay()        &&
                this.getNumeroMensagens() == t.getNumeroMensagens() && this.getArmazenamentoFotosApps() == t.getArmazenamentoFotosApps() &&
                this.getArmazenamentoFotos() == t.getArmazenamentoFotos() && this.getArmazenamentoApps() == t.getArmazenamentoApps()     &&
                this.getEspacoOcupado() == t.getEspacoOcupado() && this.getNumFotosGuardadas() == t.getNumFotosGuardadas()               &&
                this.getNumAppsInstaladas() == t.getNumAppsInstaladas()
            );
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Marca: ").append(this.getMarca());
        sb.append("\nModelo: ").append(this.getModelo());
        sb.append("\nResolução: ").append(this.getxDisplay()).append("x").append(this.getyDisplay());
        sb.append("\nArmazenamento: ").append(this.getArmazenamentoFotosApps());
        sb.append("\nEspaço ocupado: ").append(this.getEspacoOcupado());
        sb.append("\nNumero de fotos guardadas: ").append(this.getArmazenamentoFotos());
        sb.append("\nNumero de apps instaladas: ").append(this.getArmazenamentoApps());
        return sb.toString();
    }

    public Telemovel clone(){
        return new Telemovel(this);
    }

    // Gets
    public String getMarca(){
        return this.marca;
    }

    public String getModelo(){
        return this.modelo;
    }

    public int getxDisplay(){
        return this.xDisplay;
    }

    public int getyDisplay(){
        return this.yDisplay;
    }

    public int getNumeroMensagens(){
        return this.numMens;
    }

    public int getArmazenamentoFotosApps(){
        return this.armzFotosApps;
    }

    public int getArmazenamentoFotos(){
        return this.armzFotos;
    }

    public int getArmazenamentoApps(){
        return this.armzApps;
    }

    public int getEspacoOcupado(){
        return this.espacoOcupado;
    }

    public int getNumAppsInstaladas(){
        return this.numAppsInstaladas;
    }

    public int getNumFotosGuardadas(){
        return this.numFotosGuardadas;
    }

    public String[] getMensagens(){
        String[] r = new String[this.numMens];

        if(this.numMens > 0){
            System.arraycopy(this.mensagens, 0, r, 0, this.numMens);
        }

        return r;
    }

    public String[] getNomeAppsInstaladas(){
        String[] r = new String[this.getNumAppsInstaladas()];

        if(this.getNumAppsInstaladas() > 0){
            System.arraycopy(this.numAppsInstaladas, 0, r, 0, this.getNumAppsInstaladas());
        }

        return r;
    }

    // Sets
    public void setMarca(String marca){
        this.marca = marca;
    }

    public void setModelo(String modelo){
        this.modelo = modelo;
    }

    public void setxDisplay(int xDisplay){
        this.xDisplay = xDisplay;
    }

    public void setyDisplay(int yDisplay){
        this.yDisplay = yDisplay;
    }

    public void setNumeroMensagens(int numeroMensagens){
        this.numMens = numeroMensagens;
    }

    public void setMensagens(int numeroMensagens){
        this.mensagens = new String[numeroMensagens];
    }

    public void setArmazenamentoFotosApps(int armazenamentoFotosApps){
        this.armzFotosApps = armazenamentoFotosApps;
    }

    public void setArmazenamentoFotos(int armazenamentoFotos){
        this.armzFotos = armazenamentoFotos;
    }

    public void setArmazenamentoApps(int armazenamentoApps){
        this.armzApps = armazenamentoApps;
    }

    public void setEspacoOcupado(int espacoOcupado){
        this.espacoOcupado = espacoOcupado;
    }

    public void setNumFotosGuardadas(int numFotosGuardadas){
        this.numFotosGuardadas = numFotosGuardadas;
    }

    public void setNumAppsInstaladas(int numAppsInstaladas){
        this.numAppsInstaladas = numAppsInstaladas;
    }

    public void setNomeAppsInstaladas(int armApps){
        this.appsInstaladas = new String[armApps];
    }


    // Ex 2
    // (a)
    public boolean existeEspaco(int numeroBytes){
        if(this.espacoOcupado + numeroBytes <= this.getArmazenamentoFotosApps()){
            return true;
        } else {
            return false;
        }
    }

    // (b)
    public void instalaApp (String nome, int tamanho){
        if(existeEspaco(tamanho)){
            this.setArmazenamentoApps(this.getArmazenamentoApps() + tamanho);
            this.appsInstaladas[getNumAppsInstaladas()] = nome;
            this.setNumAppsInstaladas(this.getNumAppsInstaladas() + 1);
            this.setEspacoOcupado(this.getEspacoOcupado() + tamanho);
        } else {
            System.out.println("Espaço insuficiente");
        }
    }

    // (c)
    public void recebeMsg(String msg){
        int n = this.getNumeroMensagens();
        String[] novo = this.getMensagens();
        this.setMensagens(n);
        System.arraycopy(novo, 0, this.mensagens, 0, n-1);
        this.mensagens[n-1] = msg;
        this.setNumeroMensagens(n);
    }
}
