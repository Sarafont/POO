package Ficha5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Parque {
    private String nomeParque;
    private Map<String, Lugar> lugares; //Matricula -> infos Lugar

    public Parque(){
        this.nomeParque = "";
        this.lugares = new HashMap<>();
    }

    public Parque (String nome, Map<String, Lugar> lug){
        this.nomeParque = nome;
        this.lugares = lug;
    }

    public Parque (Parque p){
        this(p.nomeParque, p.lugares);
    }

    public boolean equals(Object o){
        if(this == o){
            return true;
        }
        if((o==null) || (this.getClass() != o.getClass())){
            return false;
        }
        Parque p = (Parque) o;
        return (this.nomeParque.equals(p.nomeParque) && this.lugares.equals(p.lugares));
    } 

    public Parque clone(){
        return new Parque(this);
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Nome do parque: ");
        sb.append(nomeParque);
        if(this.lugares.isEmpty()){
            sb.append("Parque vazio");
        } else {
            sb.append("\nLugares: ");
            this.lugares.values().forEach(l-> {
                sb.append(l.toString());
                sb.append("\n");
            });
        }
        return sb.toString();
    }

    //Getters and Setters
    public void setNomeParque(String nome) {
        this.nomeParque = nome;
    }
    public void setLugares(Map<String, Lugar> mapa) {
        this.lugares = mapa.values().stream().collect(Collectors.toMap(Lugar::getMatricula, Lugar::clone));
    }
    public String getNomeParque() {
        return this.nomeParque;
    }
    public Map<String, Lugar> getLugares() {
        return this.lugares.values().stream().collect(Collectors.toMap(Lugar::getMatricula, Lugar::clone));
    }


    // (1) devolve todas as matriculas dos lugares ocupados -> CONJUNTOS DE CHAVES
    public Set<String> matriculas(){
        return this.lugares.keySet(); //dá a chaves do map de matriculas-lugar
    }

    // (2) regista uma nova ocupação de lugar
    public void registaLugar(String mat, String nome, int min, boolean perm){
        this.lugares.put(mat, new Lugar(mat, nome, min, perm));
    }

    // (3) remove o lugar de dada matricula
    public void removeLugarM (String matricula){
        this.lugares.remove(matricula);
    }

    // (4) altera o tempo disponível de um lugar, para uma dada matricula
    public void setTempoM (String matricula, int min){
        Lugar l = this.lugares.get(matricula);
        if(l != null){
            l.setMinutos(min);
            this.lugares.replace(matricula, l);
        }
    }

    // (5) devolve a quantidade total de minutos atribuído
    public int totalMinutos(){
        //iterador interno
        return this.lugares.values().stream().mapToInt(Lugar::getMinutos).sum();
        /* Sem ser por iteradores internos podiamos fazer assim:
            int totalMinutos = 0;
            for (Lugar lugar : lugares.values()) {
                totalMinutos += lugar.getMinutos();
            }
            return totalMinutos;
         */
    }

    // (6) verifica existe lugar atribuído a uma dada matrícula
    public boolean verificaLugar (String mat){
        return this.lugares.containsKey(mat);
    }

    // (7) Cria uma lista com as matriculas com tempo atribuído > x, em que o lugar seja permanente
    public List<String> listaMatExt(int x){
        List<String> lista = new ArrayList<>();
        for(Lugar l: lugares.values()){
            if(l.isPermanente() && l.getMinutos()>x){
                String matricula = l.getMatricula(); 
                lista.add(matricula);
            }
        }
        return lista;
    }
    /*
    public List<String> listaMatInt(int x){
        return this.lugares.values().stream().filter(l -> l.isPermanente() && l.getMinutos()>x).map(Lugar::getMatricula).collect(Collectors.toString());
    }
     */

     // (8) devolve uma cópia dos lugares
     public Map<String, Lugar> copiaLugares(){
        return new HashMap<>(lugares);
     }

     // (9) devolve a informação de um lugar para uma dada matricula
     public Lugar infoMatricula (String mat){
        return this.lugares.get(mat).clone();
    }

}
