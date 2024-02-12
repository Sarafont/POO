import java.time.LocalDate;
import java.util.ArrayList;

public class YouTube {
    private String nomeVideo;
    private String conteudo;
    private LocalDate dataCarregamento;
    private int resolucaoVideo;
    private int duracaoMin;
    private int duracaoSec;
    private ArrayList<String> comentarios;
    private int likes;
    private int dislikes;

    // (a)
    public YouTube() {
        this.nomeVideo = "";
        this.conteudo = "";
        this.dataCarregamento = LocalDate.now();
        this.resolucaoVideo = 0;
        this.duracaoMin = 0;
        this.duracaoSec = 0;
        this.comentarios = new ArrayList<>();
        this.likes = 0;
        this.dislikes = 0;
    }

    public YouTube(String name, String content, LocalDate date, int resolution, int durationMin, int durationSec, ArrayList<String> coments, int likes, int dislikes) {
        this.nomeVideo = name;
        this.conteudo = content;
        this.dataCarregamento = date;
        this.resolucaoVideo = resolution;
        this.duracaoMin = durationMin;
        this.duracaoSec = durationSec;
        this.comentarios = coments;
        this.likes = likes;
        this.dislikes = dislikes;
    }

    public YouTube(YouTube video) {
        this.nomeVideo = video.getNomeVideo();
        this.conteudo = video.getConteudo();
        this.dataCarregamento = video.getData();
        this.resolucaoVideo = video.getResolucao();
        this.duracaoMin = video.getDuracaoMin();
        this.duracaoSec = video.getDuracaoSec();
        this.comentarios = video.getComentarios();
        this.likes = video.getLikes();
        this.dislikes = video.getDislikes();
    }

    public String getNomeVideo() {
        return this.nomeVideo;
    }

    public String getConteudo() {
        return this.conteudo;
    }

    public LocalDate getData() {
        return dataCarregamento;
    }

    public int getResolucao() {
        return this.resolucaoVideo;
    }

    public int getDuracaoMin() {
        return this.duracaoMin;
    }

    public int getDuracaoSec() {
        return this.duracaoMin;
    }

    public ArrayList<String> getComentarios() {
        return this.comentarios;
    }

    public int getLikes() {
        return this.likes;
    }

    public int getDislikes() {
        return this.dislikes;
    }

    public void setName(String nome) {
        this.nomeVideo = nome;
    }

    public void setContent(String content) {
        this.conteudo = content;
    }

    public void setUploadDate(LocalDate data) {
        this.dataCarregamento = data;
    }

    public void setResolution(int resolucao) {
        this.resolucaoVideo = resolucao;
    }

    public void setDurationMin(int durationMin) {
        this.duracaoMin = durationMin;
    }

    public void setDurationSec(int durationSec) {
        this.duracaoSec = durationSec;
    }

    public void setComents(ArrayList<String> coments) {
        this.comentarios = coments;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public void setDislikes(int dislikes) {
        this.dislikes = dislikes;
    }

    /**
     * Método que representa o objeto em formato de texto
     * @return
     */
    public String toString() {
        return ("Nome: " + getNomeVideo() + "\n" +
                "Conteúdo: " + getConteudo() + "\n" +
                "Data de Upload: " + getData() + "\n" +
                "Resolução: " + getResolucao() + "\n" +
                "Tempo em minutos: " + getDuracaoMin() + "\n" +
                "Tempo em segundos: " + getDuracaoSec() + "\n" +
                "Comentários: " + getComentarios() + "\n" +
                "Likes: " + getLikes() + "\n" +
                "Dislikes: " + getDislikes() + "\n");
    }

    public boolean equals(Object obj) {
        if(obj == this)
            return true;

        if((obj == null) || (this.getClass() != obj.getClass()))
            return false;

        YouTube video = (YouTube) obj;
        return (this.nomeVideo == video.getNomeVideo() &&
                this.conteudo.equals(video.getConteudo()) &&
                this.dataCarregamento.equals(video.getData()) &&
                this.resolucaoVideo == video.getResolucao() &&
                this.duracaoMin == video.getDuracaoMin() &&
                this.duracaoSec == video.getDuracaoSec() &&
                this.comentarios == video.getComentarios() &&
                this.likes == video.getLikes() &&
                this.dislikes == video.getDislikes());
    }

    public YouTube clone() {
        return new YouTube(this);
    }


    // (b)
    public void insereComentario(String comentario){
        this.comentarios.add(comentario);
    }

    // (c)
    public long qtsDiasDepois(){
        long hoje = LocalDate.now().getDayOfYear();
        long totalDias = hoje - dataCarregamento.getDayOfYear();
        return totalDias;
    }

    // (d)
    public void thumbsUp(){
        this.setLikes(this.likes + 1);
    }

    // (e)
    public String processa(){
        return this.conteudo;
    }
}
