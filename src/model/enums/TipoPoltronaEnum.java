/**
 * Esta classe enum define os diferentes tipos de poltronas disponíveis em um onibus ou aviao.
 * Cada tipo e representado por um valor constante que contem a descricao da poltrona.
 */
package model.enums;

public enum TipoPoltronaEnum {
    CAMA_LEITO("Cama Leito"),
    SEMI_LEITO("Semi Leito"),
    EXECUTIVA("Executiva"),
    CONVENCIONAL("Convencional");

    private String descricao;

    /**
     * Construtor da classe enum.
     * 
     * @param descricao A descricao da poltrona.
     */
    TipoPoltronaEnum(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    /**
     * Converte os tipos de poltrona para um array de strings.
     * 
     * @return Um array de strings contendo as descrições dos tipos de poltrona.
     */
    public static String[] toArray() {
        String[] array = new String[TipoPoltronaEnum.values().length];
        for (int i = 0; i < TipoPoltronaEnum.values().length; i++) {
            array[i] = TipoPoltronaEnum.values()[i].getDescricao();
        }
        return array;
    }

    public static TipoPoltronaEnum getEnum(String value) {
        for (TipoPoltronaEnum tipoPoltrona : TipoPoltronaEnum.values()) {
            if (tipoPoltrona.getDescricao().equals(value)) {
                return tipoPoltrona;
            }
        }
        return null;
    }
}
