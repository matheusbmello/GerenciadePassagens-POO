/**
 * Esta classe representa um Data Access Object (DAO) para a entidade Itinerario.
 * O DAO gerencia a colecao de objetos Itinerario e oferece metodos para adicionar
 * e buscar itinerarios com base em criterios especificos.
 */
package model;

import java.util.ArrayList;
import java.util.List;

public class ItinerarioDAO {
    private List<Itinerario> itinerarios;

    /**
     * Construtor padrao da classe ItinerarioDAO.
     * Inicializa a lista de itinerarios.
     */
    public ItinerarioDAO() {
        itinerarios = new ArrayList<>();
    }

    /**
     * Construtor da classe ItinerarioDAO.
     * Inicializa a lista de itinerarios com uma lista pre-existente.
     * 
     * @param itinerarios A lista de itinerarios a ser utilizada pelo DAO.
     */
    public ItinerarioDAO(List<Itinerario> itinerarios) {
        this.itinerarios = itinerarios;
    }

    /**
     * Adiciona um novo itinerario a lista de itinerarios.
     * 
     * @param itinerario O objeto Itinerario a ser adicionado.
     */
    public void adicionarItinerario(Itinerario itinerario) {
        itinerarios.add(itinerario);
    }

    /**
     * Busca itinerarios que correspondem aos criterios fornecidos (origem, destino e data).
     * 
     * @param origem A cidade de origem do itinerario.
     * @param destino A cidade de destino do itinerario.
     * @param dataText A data da viagem no formato de texto.
     * @return Uma lista de itinerarios encontrados que correspondem aos criterios fornecidos.
     */
    public List<Itinerario> buscarItinerarios(String origem, String destino, String dataText) {
        List<Itinerario> itinerariosEncontrados = new ArrayList<>();

        for (Itinerario itinerario : itinerarios) {
            if (itinerario.getOrigem().equalsIgnoreCase(origem)
                    && itinerario.getDestino().equalsIgnoreCase(destino)
                    && itinerario.getData().equals(dataText)) {
                itinerariosEncontrados.add(itinerario);
            }
        }

        return itinerariosEncontrados;
    }
}
