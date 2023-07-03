/**
 * Classe ItinerarioUtils
 * 
 * Classe de testes unitários para a classe ItinerarioController, que é responsável por
 * realizar algumas verificações relacionadas aos itinerários de voos e translados.
 */
package utils;

import org.junit.Test;
import controller.ItinerarioController;
import static org.junit.Assert.*;

public class ItinerarioUtils {

    /**
     * Teste para verificar se origem e destino são iguais.
     * 
     * O metodo checkDestino da classe ItinerarioController e responsavel por verificar
     * se a origem e o destino são diferentes, pois nao e possivel haver um voo com a mesma
     * origem e destino.
     * 
     * O teste verifica se o metodo retorna falso quando a origem e o destino sao iguais.
     */
    @Test
    public void itinerarioErrado() {
        String origem = "Aracaju - SE";
        String destino = "Aracaju - SE";

        assertFalse(ItinerarioController.checkDestino(origem, destino));
    }

    /**
     * Teste para verificar se origem e destino sao diferentes.
     * 
     * O metodo checkDestino da classe ItinerarioController e responsável por verificar
     * se a origem e o destino sao diferentes, pois nao e possível haver um voo com a mesma
     * origem e destino.
     * 
     * O teste verifica se o metodo retorna verdadeiro quando a origem e o destino sao diferentes.
     */
    @Test
    public void itinerarioCerto() {
        String origem = "Aracaju - SE";
        String destino = "São Paulo - SP";

        assertTrue(ItinerarioController.checkDestino(origem, destino));
    }
}
