package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import model.Dados;

/**
 * A classe ListSelectItinerarioView representa a tela de selecao de tipo de itinerario.
 * Nesta tela, o usuario pode escolher entre visualizar os itinerarios de aviao ou de onibus.
 */
public class ListSelectItinerarioView implements ActionListener {

    private static JFrame f;
    private static JButton aviao, onibus;
    private static JLabel l;

    /**
     * Construtor da classe ListSelectItinerarioView.
     * Cria a janela de selecao de tipo de itinerario e exibe os botoes "Aviao" e "Onibus".
     */
    public ListSelectItinerarioView() {
        f = new JFrame("Itinerários");
        l = new JLabel("Selecione qual Itinerário deseja visualizar:");
        aviao = new JButton("Avião");
        onibus = new JButton("Ônibus");

        f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        // Dimensionar na Tela
        f.setSize(800, 600);
        aviao.setBounds(135, 200, 200, 30);
        onibus.setBounds(405, 200, 200, 30);
        l.setBounds(200, 150, 320, 30);

        // Adicionar os componentes ao Frame
        f.setLayout(null);
        f.add(aviao);
        f.add(onibus);
        f.add(l);

        f.setLocationRelativeTo(null);
        f.setVisible(true);
        aviao.addActionListener(this);
        onibus.addActionListener(this);
    }

    /**
     * Metodo actionPerformed da interface ActionListener.
     * Executado quando um dos botões "Aviao" ou "Onibus" e clicado.
     * Abre a tela "ListItinerarioView" correspondente ao tipo de itinerario selecionado.
     * Fecha a janela de selecao apos a acao ser executada.
     * @param e Evento gerado pelo clique em um dos botões.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == aviao) {
            new ListItinerarioView(Dados.getVoos(), 0);
        } else if (e.getSource() == onibus) {
            new ListItinerarioView(Dados.getTranslados(), 1);
        }
        // Fecha a janela de selecao de tipo de itinerario
        f.dispose();
    }
}
