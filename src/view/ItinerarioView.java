package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import controller.ItinerarioController;
import model.Itinerario;
import model.ItinerarioDAO;
import model.Passagem;

/**
 * A classe ItinerarioView representa a tela de escolha do itinerario para a nova passagem cadastrada.
 * Nesta tela, o usuario pode realizar uma busca de itinerarios com base na origem, destino e data informados.
 * E possivel prosseguir para a tela final apos selecionar um itinerario.
 */
public class ItinerarioView implements ActionListener {

    private JFrame f = new JFrame();
    private JScrollPane scroll = new JScrollPane();
    private JButton btnBuscar = new JButton("Buscar itinerário");
    private JTextField origemTextField = new JTextField();
    private JTextField destinoTextField = new JTextField();
    private JTextField dataTextField = new JTextField();

    private Passagem dadosNovaPassagem;
    private List<Itinerario> itinerarios;

    /**
     * Construtor da classe ItinerarioView.
     * Cria a tela de escolha do itinerario e exibe os campos de busca e a tabela de itinerarios cadastrados.
     * @param dadosNovaPassagem Dados da nova passagem sendo cadastrada.
     * @param itinerarios Lista de itinerarios cadastrados a serem exibidos na tabela.
     */
    public ItinerarioView(Passagem dadosNovaPassagem, ArrayList<Itinerario> itinerarios) {
        this.dadosNovaPassagem = dadosNovaPassagem;
        this.itinerarios = itinerarios;

        f.setTitle("Escolha o itinerário");

        // Definindo os tamanhos
        f.setSize(800, 600);
        f.setLocationRelativeTo(null);
        f.setLayout(null);

        JLabel origemLabel = new JLabel("Origem:");
        origemLabel.setBounds(30, 30, 80, 30);
        origemTextField.setBounds(120, 30, 200, 30);

        JLabel destinoLabel = new JLabel("Destino:");
        destinoLabel.setBounds(350, 30, 80, 30);
        destinoTextField.setBounds(440, 30, 200, 30);

        JLabel dataLabel = new JLabel("Data (dd/MM/aaaa):");
        dataLabel.setBounds(30, 80, 150, 30);
        dataTextField.setBounds(180, 80, 200, 30);

        scroll.setViewportView(new JTable(ItinerarioController.genItinerarioTable(itinerarios, false)));
        scroll.setBounds(30, 150, 700, 300);
        btnBuscar.setBounds(300, 500, 150, 40);
        btnBuscar.addActionListener(this);

        f.add(origemLabel);
        f.add(origemTextField);
        f.add(destinoLabel);
        f.add(destinoTextField);
        f.add(dataLabel);
        f.add(dataTextField);
        f.add(scroll);
        f.add(btnBuscar);
        f.setVisible(true);
    }

    /**
     * Metodo que trata as acoes dos botoes da tela.
     * Realiza a busca de itinerarios com base nos dados informados pelo usuario e atualiza a tabela de resultados.
     * Permite prosseguir para a tela final apos selecionar um itinerario.
     * @param e Evento de acao ocorrido.
     */
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnBuscar) {
            String origemText = origemTextField.getText();
            String destinoText = destinoTextField.getText();
            String dataText = dataTextField.getText();

            if (origemText.isEmpty() || destinoText.isEmpty() || dataText.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Preencha todos os campos", "Erro", JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (itinerarioJaCadastrado(origemText, destinoText, dataText)) {
                JOptionPane.showMessageDialog(null, "Itinerário já cadastrado.\nVerifique na tabela.", "Aviso",
                        JOptionPane.WARNING_MESSAGE);
            } else {
                List<Itinerario> itinerariosEncontrados = new ItinerarioDAO().buscarItinerarios(origemText, destinoText,
                        dataText);

                if (itinerariosEncontrados.isEmpty()) {
                    JOptionPane.showMessageDialog(null,
                            "Nenhum itinerário encontrado\nRetorne à página principal e cadastre ou busque por um já existente.",
                            "Erro", JOptionPane.ERROR_MESSAGE);
                } else {
                    itinerarios = itinerariosEncontrados; // Atualiza a lista de itinerários
                    scroll.setViewportView(new JTable(ItinerarioController.genItinerarioTable(itinerarios, false)));
                }
            }
        }
    }

    /**
     * Metodo para verificar se um itinerario ja esta cadastrado na tabela de resultados.
     * @param origem Origem do itinerario.
     * @param destino Destino do itinerario.
     * @param dataText Data do itinerario.
     * @return true se o itinerário ja estiver cadastrado, false caso contrário.
     */
    private boolean itinerarioJaCadastrado(String origem, String destino, String dataText) {
        DefaultTableModel tableModel = (DefaultTableModel) ((JTable) scroll.getViewport().getView()).getModel();
        int rowCount = tableModel.getRowCount();

        for (int i = 0; i < rowCount; i++) {
            String tableOrigem = tableModel.getValueAt(i, 1).toString();
            String tableDestino = tableModel.getValueAt(i, 2).toString();
            String tableData = tableModel.getValueAt(i, 3).toString();

            if (origem.equalsIgnoreCase(tableOrigem) &&
                    destino.equalsIgnoreCase(tableDestino) &&
                    dataText.equals(tableData)) {
                return true; // Itinerario ja esta cadastrado na tabela
            }
        }

        return false; // Itinerario nao esta cadastrado na tabela
    }
}