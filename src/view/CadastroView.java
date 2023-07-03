package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * A classe `CadastroView` representa a tela de cadastro para o usuario.
 * Ela permite ao usuario escolher entre dois tipos de transporte: "Aviao" e "Onibus".
 * Quando o usuario seleciona uma das opcoes, ele e redirecionado para a tela correspondente para interacao adicional.
 * A classe implementa a interface ActionListener para tratar eventos de clique nos botoes.
 */
public class CadastroView implements ActionListener {
    private static JFrame f;
    private static JButton ba, bo;
    private static JLabel l;

    /**
     * Constroi uma nova instancia da classe `CadastroView`.
     * Cria e exibe a janela principal para o cadastro do usuario, com opcoes para "Aviao" e "Onibus".
     */
    public CadastroView() {
        f = new JFrame("Realize seu cadastro");
        l = new JLabel("Escolha o tipo de transporte: ");
        ba = new JButton("Avião");
        bo = new JButton("Ônibus");

        // Definir propriedades da janela
        f.setSize(800, 600);
        f.setLocationRelativeTo(null);
        l.setBounds(270, 20, 250, 30);
        ba.setBounds(250, 50, 120, 30);
        bo.setBounds(380, 50, 120, 30);
        f.setLayout(null);

        // Adicionar componentes a janela
        f.add(ba);
        f.add(bo);
        f.add(l);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Adicionar o ouvinte de acao aos botoes
        ba.addActionListener(this);
        bo.addActionListener(this);
    }

    /**
     * Metodo executado quando um botao e clicado.
     * Ele redireciona o usuário para a tela "AviaoView" quando "Aviao" e selecionado, ou para a tela "OnibusView" quando "Onibus" e selecionado.
     * Apos o redirecionamento, a janela atual e fechada.
     *
     * @param e O objeto de evento que representa o clique do botao.
     */
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == ba) {
            // Redirecionamento para a tela "AviaoView"
            new AviaoView();
        } else if (e.getSource() == bo) {
            // Redirecionamento para a tela "OnibusView"
            new OnibusView();
        }
        f.dispose(); // Fechar a janela atual apos o redirecionamento
    }
}
