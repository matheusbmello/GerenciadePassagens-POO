package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * A classe TelaInicialView permite ao usuario escolher entre quatro opcoes: 
 * cadastrar passagem, cadastrar itinerario, listar itinerarios e listar passagens.
 */
public class TelaInicialView implements ActionListener {
    private static JFrame f;
    private static JLabel texto;
    private static JButton cadastrarPassagem, listPassagem, listItinerario, cadastrarItinerario;

    /**
     * Construtor da classe TelaInicialView.
     * Cria a janela principal e os botoes de opção.
     * Configura os listeners para os botões.
     */
    public TelaInicialView() {
        f = new JFrame("Seja bem-vindo à Tripper!");
        texto = new JLabel("Bem-vindo, por favor, escolha a opção que deseja: ");
        cadastrarPassagem = new JButton("Cadastrar Passagem");
        cadastrarItinerario = new JButton("Cadastrar Itinerário");
        listItinerario = new JButton("Lista de itinerários");
        listPassagem = new JButton("Lista de passagens");

        f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        f.setSize(800, 600);

        // Posicionamento dos botoes na tela
        texto.setBounds(200, 30, 800, 30);
        cadastrarPassagem.setBounds(100, 200, 200, 30);
        cadastrarItinerario.setBounds(400, 200, 200, 30);
        listItinerario.setBounds(100, 300, 200, 30);
        listPassagem.setBounds(400, 300, 200, 30);

        // Adiciona os botoes ao Frame
        f.setLayout(null);
        f.add(texto);
        f.add(cadastrarPassagem);
        f.add(listItinerario);
        f.add(listPassagem);
        f.add(cadastrarItinerario);
        f.setLocationRelativeTo(null);
        f.setVisible(true);

        // Adiciona listeners para os botoes
        cadastrarPassagem.addActionListener(this);
        listItinerario.addActionListener(this);
        listPassagem.addActionListener(this);
        cadastrarItinerario.addActionListener(this);
    }

    /**
     * Metodo actionPerformed da interface ActionListener.
     * Executado quando um botao e clicado.
     * Abre diferentes telas de acordo com a opcao selecionada pelo usuário.
     * @param e Evento gerado pelo botao clicado.
     */
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == cadastrarPassagem) {
            new CadastroView(); // Abre a tela de cadastro de passagem.
        } else if (e.getSource() == listPassagem) {
            new ListPassagemView(null); // Abre a tela de listagem de passagens.
        } else if (e.getSource() == listItinerario) {
            new ListSelectItinerarioView(); // Abre a tela de listagem de itinerarios.
        } else if (e.getSource() == cadastrarItinerario) {
            new CadastroItinerarioView(); // Abre a tela de cadastro de itinerario.
        }
    }
}
