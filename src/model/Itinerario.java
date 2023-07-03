package model;

import java.util.ArrayList;
import java.util.List;

public class Itinerario {
    private String origem;
    private String destino;
    private String data;
    private List<Passagem> passagens = new ArrayList<>();
    
    public Itinerario(String origem, String destino, String data) {
        this.origem = origem;
        this.destino = destino;
        this.data = data;
    }

    public String getOrigem() {
        return origem;
    }
    public void setOrigem(String origem) {
        this.origem = origem;
    }
    public String getDestino() {
        return destino;
    }
    public void setDestino(String destino) {
        this.destino = destino;
    }
    public String getData() {
        return data;
    }
    public void setData(String data) {
        this.data = data;
    }
    public List<Passagem> getPassagens() {
        return passagens;
    }
    public void setPassagens(List<Passagem> passagens) {
        this.passagens = passagens;
    }
}