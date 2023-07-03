package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import controller.ItinerarioController;
import model.Itinerario;

/**
 * A classe ListItinerarioView representa a tela de listagem de itinerarios.
 * Nesta tela, o usuario pode visualizar os itinerarios cadastrados para determinado tipo (aviao ou onibus).
 * O usuario tem a opcao de editar ou excluir um itinerario selecionado na lista.
 */
public class ListItinerarioView implements ActionListener {
    private static JFrame f;
    private static JButton editar, excluir;
    private static JScrollPane scroll = new JScrollPane();

    private ArrayList<Itinerario> itinerarios;
    private int tipoItinerario; // 0 = aviao, 1 = onibus

    /**
     * Construtor da classe ListItinerarioView.
     * Cria a janela de listagem de itinerarios e exibe os botoes "Editar itinerario" e "Excluir itinerario".
     * @param itinerarios Lista de itinerarios cadastrados a serem exibidos na tela.
     * @param tipoItinerario Tipo de itinerario a ser listado (0 para aviao, 1 para onibus).
     */
    public ListItinerarioView(ArrayList<Itinerario> itinerarios, int tipoItinerario) {
        this.itinerarios = itinerarios;
        this.tipoItinerario = tipoItinerario;

        f = new JFrame("Itinerários");

        editar = new JButton("Editar itinerário");
        excluir = new JButton("Excluir itinerário");

        scroll.setViewportView(new JTable(ItinerarioController.genItinerarioTable(itinerarios, false)));

        f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        // Dimensionar na Tela
        f.setSize(800, 600);
        editar.setBounds(135, 430, 200, 30);
        excluir.setBounds(405, 430, 200, 30);
        scroll.setBounds(30, 30, 700, 400);

        // Adicionar os componentes ao Frame
        f.setLayout(null);

        f.add(editar);
        f.add(excluir);
        f.add(scroll);

        f.setLocationRelativeTo(null);
        f.setVisible(true);
        editar.addActionListener(this);
        excluir.addActionListener(this);
    }

    /**
     * Metodo actionPerformed da interface ActionListener.
     * Executado quando um dos botoes e clicado.
     * Abre a tela de cadastro de itinerario para edicao ou exclui o itinerario selecionado da lista.
     * @param e Evento gerado pelo clique em um dos botoes.
     */
    public void actionPerformed(ActionEvent e) {
        int selectedIndex = ((JTable) scroll.getViewport().getView()).getSelectedRow();

        if (selectedIndex == -1) {
            JOptionPane.showMessageDialog(null, "Selecione um itinerário", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (e.getSource() == editar) {
            new CadastroItinerarioView(itinerarios, this.itinerarios.get(selectedIndex), tipoItinerario);
            f.dispose();
        } else if (e.getSource() == excluir) {
            this.itinerarios.remove(selectedIndex);
            JOptionPane.showMessageDialog(null, "Itinerário excluído com sucesso", "Sucesso",
                    JOptionPane.INFORMATION_MESSAGE);
            f.dispose();
            new ListItinerarioView(itinerarios, tipoItinerario);
        }
    }
}
