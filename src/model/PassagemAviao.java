/**
 * Classe que representa uma Passagem de Aviao, que herda da classe Passagem.
 * A Passagem de Aviao possui informacoes adicionais, como a classe da passagem.
 */

package model;

import model.enums.ClassesPassagemAviaoEnum;

public class PassagemAviao extends Passagem {
    private ClassesPassagemAviaoEnum classe;

    /**
     * Construtor da classe PassagemAviao.
     * 
     * @param nomePassageiro O nome do passageiro da passagem de aviao.
     * @param telefone O telefone de contato do passageiro da passagem de aviao.
     * @param itinerario O itinerário associado a passagem de aviao.
     * @param classe A classe da passagem de avião.
     */
    public PassagemAviao(String nomePassageiro, String telefone, Itinerario itinerario, String assento,
            ClassesPassagemAviaoEnum classe) {
        super(nomePassageiro, telefone, itinerario);
        this.classe = classe;
    }

    /**
     * Construtor padrao da classe PassagemAviao.
     */
    public PassagemAviao() {
    }

    public ClassesPassagemAviaoEnum getClasse() {
        return classe;
    }

    public void setClasse(ClassesPassagemAviaoEnum classe) {
        this.classe = classe;
    }

}
