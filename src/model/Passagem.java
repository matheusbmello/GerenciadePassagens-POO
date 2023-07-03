/**
 * Classe abstrata que representa uma Passagem para um Itinerario.
 * A Passagem possui informações do passageiro, seu telefone e o itinerário associado.
 */

package model;

public abstract class Passagem {
    private String nomePassageiro;
    private String telefone;
    private Itinerario itinerario;

    /**
     * Construtor da classe Passagem.
     * 
     * @param nomePassageiro O nome do passageiro da passagem.
     * @param telefone O telefone de contato do passageiro.
     * @param itinerario O itinerário associado à passagem.
     */
    public Passagem(String nomePassageiro, String telefone, Itinerario itinerario) {
        this.nomePassageiro = nomePassageiro;
        this.telefone = telefone;
        this.itinerario = itinerario;
    }
    /**
    * Construtor padrão da classe Passagem.
    */
    public Passagem() {
    }

    public String getNomePassageiro() {
        return nomePassageiro;
    }

    public void setNomePassageiro(String nomePassageiro) {
        this.nomePassageiro = nomePassageiro;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Itinerario getItinerario() {
        return itinerario;
    }

    public void setItinerario(Itinerario itinerario) {
        this.itinerario = itinerario;
    }

    public String getOrigem() {
        return null;
    }
}
