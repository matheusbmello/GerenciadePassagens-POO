/**
* Classe App é a classe principal (e interpreta a classe Main).
* @author Julia Takaki Neves
* @author Matheus de Mello Barbosa
* @since 2023
* @version 1.1
*/

import model.Dados;
import model.Itinerario;
import view.TelaInicialView;

public class App {
    /**
     * Cria exemplos dentro da classe ItinerarioView
     */
    public static void main(String[] args) throws Exception {
        Dados.getVoos().add(new Itinerario("São Paulo", "Rio de Janeiro", "15/09/2023"));
        Dados.getTranslados().add(new Itinerario("São Paulo", "Rio de Janeiro", "15/09/2023"));
        new TelaInicialView();
    }
}
