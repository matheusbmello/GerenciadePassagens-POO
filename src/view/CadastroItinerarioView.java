package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import model.Dados;
import model.Itinerario;

/**
 * A classe `CadastroItinerarioView` representa uma interface grafica de usuario para cadastrar um novo itinerario.
 * Ela permite ao usuario inserir informacoes sobre a origem, destino e data do itinerario.
 * O usuario tambem pode selecionar o tipo de itinerario, que pode ser "Aviao" ou "Onibus".
 * Quando o usuario clica em "Cadastrar", o itinerario e adicionado aos dados (classe `Dados`) e uma mensagem de sucesso e exibida.
 * A classe implementa a interface ActionListener para tratar eventos de clique nos botoes.
 */
public class CadastroItinerarioView extends JFrame implements ActionListener {
    private static JButton btnCadastrar;
    private static JButton btnVoltar;

    private static JLabel lblOrigem;
    private static JLabel lblDestino;
    private static JLabel lblData;

    private static JTextField txtOrigem;
    private static JTextField txtDestino;
    private static JTextField txtData;

    private static JList<String> tipoItinerario;

    private ArrayList<Itinerario> itinerarios;
    private Itinerario itinerario;
    private Boolean isEdit = false;

    /**
     * Constroi uma nova instancia da classe `CadastroItinerarioView` para cadastrar um novo itinerario.
     * Exibe a janela de cadastro com campos para origem, destino, data e tipo de itinerario.
     */
    public CadastroItinerarioView() {
        // Configurações da janela
        this.setSize(800, 600);

        btnCadastrar = new JButton("Cadastrar");
        btnVoltar = new JButton("Voltar");

        txtOrigem = new JTextField();
        txtDestino = new JTextField();
        txtData = new JFormattedTextField();
        lblOrigem = new JLabel("Origem");
        lblDestino = new JLabel("Destino");
        lblData = new JLabel("Data");

        String[] tipos = { "Avião", "Ônibus" };
        tipoItinerario = new JList<String>(tipos);

        // Posicionamento dos componentes
        lblOrigem.setBounds(30, 30, 100, 30);
        lblDestino.setBounds(30, 65, 120, 30);
        lblData.setBounds(30, 100, 170, 30);
        txtOrigem.setBounds(130, 30, 200, 30);
        txtDestino.setBounds(145, 65, 200, 30);
        txtData.setBounds(200, 100, 150, 30);
        btnCadastrar.setBounds(360, 300, 150, 40);
        btnVoltar.setBounds(200, 300, 150, 40);
        tipoItinerario.setBounds(200, 150, 120, 60);

        // Adicionando ouvintes de acao aos botoes
        btnCadastrar.addActionListener(this);
        btnVoltar.addActionListener(this);

        // Configuracoes da janela
        this.setLayout(null);
        this.setLocationRelativeTo(null);
        this.add(txtOrigem);
        this.add(txtDestino);
        this.add(txtData);
        this.add(btnCadastrar);
        this.add(btnVoltar);
        this.add(lblOrigem);
        this.add(lblDestino);
        this.add(lblData);
        this.add(tipoItinerario);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setVisible(true);
    }

    /**
     * Constroi uma nova instancia da classe `CadastroItinerarioView` para editar um itinerario existente.
     * Exibe a janela de cadastro com campos preenchidos com os dados do itinerario a ser editado.
     *
     * @param itinerarios A lista de itinerarios existentes.
     * @param itinerario O itinerario a ser editado.
     * @param tipoItinerarioCadastrado O tipo de itinerario (0 para "Aviao" ou 1 para "Onibus") ja cadastrado.
     */
    public CadastroItinerarioView(ArrayList<Itinerario> itinerarios, Itinerario itinerario, int tipoItinerarioCadastrado) {
        this.isEdit = true;
        this.itinerarios = itinerarios;
        this.itinerario = itinerario;
        this.setSize(800, 600);

        btnCadastrar = new JButton("Editar");
        btnVoltar = new JButton("Voltar");

        txtOrigem = new JTextField();
        txtDestino = new JTextField();
        txtData = new JFormattedTextField();
        lblOrigem = new JLabel("Origem");
        lblDestino = new JLabel("Destino");
        lblData = new JLabel("Data");

        String[] tipos = { "Avião", "Ônibus" };
        tipoItinerario = new JList<String>(tipos);
        tipoItinerario.setEnabled(false);
        tipoItinerario.setSelectedIndex(tipoItinerarioCadastrado);

        // Posicionamento dos componentes
        lblOrigem.setBounds(30, 30, 100, 30);
        lblDestino.setBounds(30, 65, 120, 30);
        lblData.setBounds(30, 100, 170, 30);
        txtOrigem.setBounds(130, 30, 200, 30);
        txtDestino.setBounds(145, 65, 200, 30);
        txtData.setBounds(200, 100, 150, 30);
        btnCadastrar.setBounds(360, 300, 150, 40);
        btnVoltar.setBounds(200, 300, 150, 40);
        tipoItinerario.setBounds(200, 150, 120, 60);

        // Adicionando ouvintes de acao aos botoes
        btnCadastrar.addActionListener(this);
        btnVoltar.addActionListener(this);

        // Preenchendo os campos com os dados do itinerario a ser editado
        txtOrigem.setText(itinerario.getOrigem());
        txtDestino.setText(itinerario.getDestino());
        txtData.setText(itinerario.getData());

        // Configuracoes da janela
        this.setLayout(null);
        this.setLocationRelativeTo(null);
        this.add(txtOrigem);
        this.add(txtDestino);
        this.add(txtData);
        this.add(btnCadastrar);
        this.add(btnVoltar);
        this.add(lblOrigem);
        this.add(lblDestino);
        this.add(lblData);
        this.add(tipoItinerario);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnCadastrar) {
            // Verificacao dos campos vazios
            if (txtOrigem.getText().isEmpty() || txtDestino.getText().isEmpty() || txtData.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Preencha todos os campos!");
                return;
            }

            // Edicao do itinerario
            if (isEdit) {
                if (tipoItinerario.getSelectedIndex() == 0) {
                    Dados.getVoos().get(itinerarios.indexOf(itinerario))
                            .setOrigem(txtOrigem.getText());
                    Dados.getVoos().get(itinerarios.indexOf(itinerario)).setDestino(txtDestino.getText());
                    Dados.getVoos().get(itinerarios.indexOf(itinerario)).setData(txtData.getText());
                } else if (tipoItinerario.getSelectedIndex() == 1) {
                    Dados.getTranslados().get(itinerarios.indexOf(itinerario))
                            .setOrigem(txtOrigem.getText());
                    Dados.getTranslados().get(itinerarios.indexOf(itinerario)).setDestino(txtDestino.getText());
                    Dados.getTranslados().get(itinerarios.indexOf(itinerario)).setData(txtData.getText());
                }

                JOptionPane.showMessageDialog(null, "Itinerário editado com sucesso!");
                this.dispose();
                new ListItinerarioView(itinerarios, tipoItinerario.getSelectedIndex());
                return;
            }

            // Cadastro de novo itinerario
            if (tipoItinerario.getSelectedIndex() == 0) {
                Dados.getVoos().add(new Itinerario(txtOrigem.getText(), txtDestino.getText(), txtData.getText()));
            } else if (tipoItinerario.getSelectedIndex() == 1) {
                Dados.getTranslados().add(new Itinerario(txtOrigem.getText(), txtDestino.getText(), txtData.getText()));
            }

            JOptionPane.showMessageDialog(null, "Itinerário cadastrado com sucesso!");
            this.dispose();
        } else if (e.getSource() == btnVoltar) {
            this.dispose();
        }
    }
}
