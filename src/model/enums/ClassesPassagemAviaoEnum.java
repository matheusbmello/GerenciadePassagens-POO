/**
 * Esta classe enum define os diferentes tipos de classes de passagem de aviao disponiveis.
 * Cada tipo e representado por um valor constante que contem o nome da classe.
 */
package model.enums;

public enum ClassesPassagemAviaoEnum {
    ECONOMICA("Economica"),
    EXECUTIVA("Executiva"),
    PRIMEIRA_CLASSE("Primeira Classe");

    private String classe;

    /**
     * Construtor da classe enum.
     * 
     * @param classe O nome da classe de passagem.
     */
    ClassesPassagemAviaoEnum(String classe) {
        this.classe = classe;
    }

    public String getValue() {
        return classe;
    }

    /**
     * Converte as classes de passagem para um array de strings.
     * 
     * @return Um array de strings contendo os nomes das classes de passagem.
     */
    public static String[] toArray() {
        String[] array = new String[ClassesPassagemAviaoEnum.values().length];
        for (int i = 0; i < ClassesPassagemAviaoEnum.values().length; i++) {
            array[i] = ClassesPassagemAviaoEnum.values()[i].getValue();
        }
        return array;
    }

    public static ClassesPassagemAviaoEnum getEnum(String value) {
        for (ClassesPassagemAviaoEnum classe : ClassesPassagemAviaoEnum.values()) {
            if (classe.getValue().equals(value)) {
                return classe;
            }
        }
        return null;
    }

}
