/**
 * Esta classe armazena listas de objetos relacionados a passagens, voos e translados.
 * As listas contem objetos do tipo Passagem, Itinerario (voos) e Itinerario (translados).
 * Os dados podem ser acessados atraves dos metodos estaticos que retornam as listas.
 */
package model;

import java.util.ArrayList;

public class Dados {
    private static final ArrayList<Passagem> passagens = new ArrayList<Passagem>();
    private static final ArrayList<Itinerario> voos = new ArrayList<Itinerario>();
    private static final ArrayList<Itinerario> translados = new ArrayList<Itinerario>();

    private Dados() {
    }

    public static ArrayList<Passagem> getPassagens() {
        return passagens;
    }

    public static ArrayList<Itinerario> getVoos() {
        return voos;
    }

    public static ArrayList<Itinerario> getTranslados() {
        return translados;
    }
}
