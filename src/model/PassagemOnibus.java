/**
 * Classe que representa uma Passagem de Onibus, que herda da classe Passagem.
 * A Passagem de Onibus possui informacoes adicionais, como o tipo de poltrona.
 */
package model;

import model.enums.TipoPoltronaEnum;

public class PassagemOnibus extends Passagem {
    private TipoPoltronaEnum tipoPoltrona;

    /**
     * Construtor da classe PassagemOnibus.
     * 
     * @param nomePassageiro O nome do passageiro da passagem de onibus.
     * @param telefone O telefone de contato do passageiro da passagem de onibus.
     * @param itinerario O itinerario associado a passagem de onibus.
     * @param tipoPoltrona O tipo de poltrona da passagem de onibus.
     */
    public PassagemOnibus(String nomePassageiro, String telefone, Itinerario itinerario, String assento,
            TipoPoltronaEnum tipoPoltrona) {
        super(nomePassageiro, telefone, itinerario);
        this.tipoPoltrona = tipoPoltrona;
    }

    /**
     * Construtor padrao da classe PassagemOnibus.
     */
    public PassagemOnibus() {
    }

    public TipoPoltronaEnum getTipoPoltrona() {
        return tipoPoltrona;
    }

    public void setTipoPoltrona(TipoPoltronaEnum tipoPoltrona) {
        this.tipoPoltrona = tipoPoltrona;
    }
}
