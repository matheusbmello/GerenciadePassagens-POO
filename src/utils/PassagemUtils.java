/**
 * Classe PassagemUtils
 * 
 * Classe de testes unitarios para a classe PassagemController, que e responsavel por
 * realizar algumas verificacoes de validade relacionadas a passagens de aviao e onibus.
 */
package utils;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import controller.PassagemController;

public class PassagemUtils {

    /**
     * Teste para verificar a validade do nome do usuario.
     * 
     * O metodo checkNome da classe PassagemController e responsavel por verificar se o nome
     * do usuario e valido, ou seja, se contem apenas letras e espacos em branco.
     * 
     * O teste verifica se o metodo retorna verdadeiro para um nome valido (contendo apenas letras e espacos)
     * e falso para um nome invalido (contendo numeros).
     */
    @Test
    void testCheckNome() {
        String valorNomeErrado = "M4r14";
        String valorNomeCorreto = "Maria ";
        assertTrue(PassagemController.checkNome(valorNomeCorreto));
        assertFalse(PassagemController.checkNome(valorNomeErrado));
    }

    /**
     * Teste para verificar a validade do telefone do usuario.
     * 
     * O metodo checkTel da classe PassagemController e responsável por verificar se o telefone
     * do usuario e válido, ou seja, se contem apenas numeros e possui o formato correto.
     * 
     * O teste verifica se o metodo retorna verdadeiro para um telefone valido (contendo apenas numeros)
     * e falso para um telefone invalido (com caracteres especiais).
     */
    @Test
    void testCheckTel() {
        String valorTelErrado = "(61)99999-9999";
        String valorTelCorreto = "61999999999";
        assertTrue(PassagemController.checkTel(valorTelCorreto));
        assertFalse(PassagemController.checkTel(valorTelErrado));
    }
}
