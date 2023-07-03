/**
 * PassagemController e uma classe que contem metodos para verificar a validade de valores inseridos pelo usuario.
 * Esses metodos podem ser utilizados para limitar o usuario a escrever apenas letras em um campo de nome e apenas
 * numeros em um campo de telefone.
 */
package controller;

import javax.swing.JOptionPane;

public class PassagemController {
    /**
     * Verifica se o valor inserido contem apenas letras e espaços.
     * 
     * @param valor O valor a ser verificado (por exemplo, um nome).
     * @return true se o valor contém apenas letras e espaços, false caso contrário.
     */
    public static boolean checkNome(String valor) {
        if (valor.matches("[a-zA-Z ]+")) {
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "Digite um nome válido (apenas letras).", "Erro",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    /**
     * Verifica se o valor inserido contem apenas numeros.
     * 
     * @param valor O valor a ser verificado (por exemplo, um telefone).
     * @return true se o valor contem apenas numeros, false caso contrario.
     */
    public static boolean checkTel(String valor) {
        if (valor.matches("[0-9]+")) {
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "Digite um telefone válido (apenas números).", "Erro",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }
}
