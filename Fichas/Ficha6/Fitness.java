package Ficha6;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Fitness {
    private List<Utilizador> utilizadores;

    public Fitness(){
        this.utilizadores = new ArrayList<>();
    }

    public void adicionaUtilizador (Utilizador u){
        this.utilizadores.add(u);
    }

    //Verificar a existência de um utilizador, dado o seu código
    public boolean existeUtilizador(String email){
        boolean existe = false;
        for (Utilizador u: utilizadores){
            if(u.getEmail() == email){
                existe = true;
            }
        }
        return existe;
        // OU usando iterador interno 
        //return utilizadores.stream().anyMatch(utilizador -> utilizador.getEmail().equals(email));
    }


    //devolver a quantidade de utilizadores existentes na aplicação de fitness
    public int quantosUtil (){
        return this.utilizadores.size();
    }


    //devolver o número total de actividades desportivas, de um dado tipo, efectuadas por um utilizador.
    public int quantos (String actividade, String email){
        int count=0;
        for(Utilizador u: utilizadores){
            if(u.getEmail().equals(email)){
                for(Atividade a: u.getAtividades()){
                    if(a.equals(actividade)){
                        count+=1;
                    }
                }
            }
        }
        return count;
    }
        /* Ou
            long count = utilizadores.stream()
            .filter(u -> u.getEmail().equals(email))
            .flatMap(u -> u.getAtividades().stream())
            .filter(a -> a.getTipo().equalsIgnoreCase(atividade))
            .count();

            return (int) count;
        */
    

    //devolver a informação de um utilizador, dado o seu código
    public Utilizador getUtilizador(String email){
        for(Utilizador u: utilizadores){
            if(u.getEmail().equals(email)){
                return u;
            }
        }
        return null;
        // OU return utilizadores.stream().filter(u -> u.getEmail().equals(email)).findFirst().orElse(null);
    }

    //Adicionar uma atividade ao registo de um utilizador
    public void adiciona(String email, Atividade act){
        for(Utilizador u: utilizadores){
            if(u.getEmail().equals(email)){
                u.adicionaAtividade(act);
            }
        }
    }

    //devolver uma lista contendo a cópia de todos as atividades existentes na aplicação
    public List<Atividade> getAllAtividades(){
        List<Atividade> lista = new ArrayList<>();

        for(Utilizador u: utilizadores){
            List<Atividade> listaAtv = u.getAtividades();
            for(Atividade a: listaAtv){
                lista.add(new Atividade(a));
            }
        }

        return lista;
    }


    // adicionar a informação de um conjunto de actividades de um utilizador e que foram feitas numa outra aplicação 
    //e que passam agora a fazer parte do Fitness.
    public void adiciona(String email, Set<Atividade> activs){
        List<Atividade> ativ = new ArrayList<>(activs);
        for(Utilizador u: utilizadores){
            if(u.getEmail().equals(email)){
                for(Atividade a: ativ){
                    u.adicionaAtividade(a);
                }
            }
        }
    }

    // indicar o número total de minutos que foram dispendidos por um utilizador em actividades de fitness
    public int tempoTotalUtilizador(String email){
        int tempo = 0;
        for(Utilizador u: utilizadores){
            if(u.getEmail().equals(email)){
                for(Atividade a: u.getAtividades()){
                    tempo += a.getDuracao();
                }
            }
        }
        return tempo;
    }


    // devolver a atividade com maior dispêndio de calorias
    public Atividade actividadeMaisExigente(){
        Atividade res = new Atividade();
        double maisCalorias = 0;
        double cal;

        for(Utilizador u: utilizadores){
            for(Atividade a: u.getAtividades()){
                cal = 0;
                if(a instanceof Corrida){
                    cal += ((Corrida) a).caloriasCorrida(u);
                } else if (a instanceof Canoagem){
                    cal += ((Canoagem) a).caloriasCanoagem(u);
                } else if (a instanceof Abdominais){
                    cal += ((Abdominais) a).caloriasCanoagem(u);
                }

                if(cal > maisCalorias){
                    maisCalorias = cal;
                    res = a;
                }
            }
        }

        return res;
    }


    //obter o utilizador com maior dispêndio de calorias
    public Utilizador utilizadorMaisActivo(){
        Utilizador maisAtivo = new Utilizador();
        double maisCalorias = 0;
        double cal;

        for(Utilizador u: utilizadores){
            cal = 0;
            for(Atividade a: u.getAtividades()){
                if(a instanceof Corrida){
                    cal += ((Corrida) a).caloriasCorrida(u);
                } else if (a instanceof Canoagem){
                    cal += ((Canoagem) a).caloriasCanoagem(u);
                } else if (a instanceof Abdominais){
                    cal += ((Abdominais) a).caloriasCanoagem(u);
                }
            }
            if(cal > maisCalorias){
                maisCalorias = cal;
                maisAtivo = u;
            }
        }

        return maisAtivo;
    }


    //Actualizar, para todos os utilizadores, a informação relativa ao seu desporto favorito, fazendo com que seja 
    // verdade que este é o desporto em que registam mais actividades por parte desse utilizador.
    public void actualizaDesportoFav(){
        for(Utilizador u: utilizadores){
            u.setDesportoFav(null);
        }
    }



    //Getters and setters
    public List<Utilizador> getUtilizadores() {
        return utilizadores;
    }

    public void setUtilizadores(List<Utilizador> utilizadores) {
        this.utilizadores = utilizadores;
    }
}
