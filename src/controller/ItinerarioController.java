/**
 * ItinerarioController e uma classe que fornece metodos para manipulacao de itinerarios.
 * Essa classe contem metodos para verificar a validade do destino de um itinerario e
 * para gerar um modelo de tabela a partir de uma lista de itinerarios.
 */
package controller;

import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import model.Itinerario;

public class ItinerarioController {
    /**
     * Verifica se o destino e diferente da origem de um itinerario.
     * 
     * @param origem  A origem do itinerario.
     * @param destino O destino do itinerario.
     * @return true se o destino for diferente da origem, false caso contrario.
     */
    public static boolean checkDestino(String origem, String destino) {
        if (origem.equals(destino)) {
            JOptionPane.showMessageDialog(null, "Escolha um destino diferente de sua origem", "Erro",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }

    /**
     * Gera um modelo de tabela contendo informacoes de itinerarios.
     * 
     * @param itinerarios A lista de itinerarios a ser exibida na tabela.
     * @param isEditable  Indica se a tabela pode ser editada (true) ou nao (false).
     * @return Um DefaultTableModel contendo os dados dos itinerarios para ser utilizado em uma tabela.
     */
    public static DefaultTableModel genItinerarioTable(List<Itinerario> itinerarios,
            Boolean isEditable) {
        DefaultTableModel tableModel;
        String header[] = { " ", "Origem", "Destino", "Data"};

        if (isEditable) {
            tableModel = new DefaultTableModel(header, 0);
        } else {
            tableModel = new DefaultTableModel(header, 0) {
                @Override
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
            };
        }

        for (int i = 0; i < itinerarios.size(); i++) {
            Object[] data = { i + 1, itinerarios.get(i).getOrigem(), itinerarios.get(i).getDestino(),
                    itinerarios.get(i).getData()};
            tableModel.addRow(data);
        }

        return tableModel;
    }
}
