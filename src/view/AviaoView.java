package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import model.Dados;
import model.PassagemAviao;
import model.enums.ClassesPassagemAviaoEnum;

/**
 * Classe AviaoView
 * 
 * Representa uma janela de interacao com o usuario para selecao de opcoes de passagem de aviao.
 * Permite ao usuario digitar seu nome, telefone e escolher uma classe de passagem de aviao.
 * Ao clicar no botao "Continuar", sao realizadas verificacoes de validade dos dados inseridos
 * e, caso os dados sejam validos, o usuario e redirecionado para a tela de selecao de itinerarios.
 * Implementa a interface ActionListener para responder aos eventos de acao do botao "Continuar".
 */
public class AviaoView implements ActionListener {

    // Componentes visuais da janela
    private JFrame f;
    private JLabel nome, telefone, laClasse, mensagemErroNome, mensagemErroTelefone;
    private JTextField tfNome, tfTelefone;
    private JList<String> listaClasses;
    private JButton continuar;

    /**
     * Construtor da classe AviaoView.
     * Inicializa a janela e os componentes visuais.
     * Define o posicionamento dos componentes na janela e adiciona um ouvinte de acao ao botao "Continuar".
     */
    public AviaoView() {
        f = new JFrame("Avião");
        nome = new JLabel("Digite seu nome: ");
        telefone = new JLabel("Digite seu telefone: ");
        laClasse = new JLabel("Escolha a classe: ");
        tfNome = new JTextField(50);
        tfTelefone = new JTextField(12);

        // Cria um vetor com as possibilidades de classes de passagem de aviao
        String classes[] = ClassesPassagemAviaoEnum.toArray();
        listaClasses = new JList<String>(classes);
        continuar = new JButton("Continuar");
        f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        f.setSize(800, 600);

        // Definicao do posicionamento dos componentes na janela
        f.setSize(800, 600);
        nome.setBounds(30, 30, 180, 30);
        telefone.setBounds(30, 65, 180, 30);
        laClasse.setBounds(30, 100, 180, 30);
        tfNome.setBounds(210, 30, 200, 30);
        tfTelefone.setBounds(210, 65, 100, 30);
        listaClasses.setBounds(210, 100, 120, 80);
        continuar.setBounds(30, 200, 120, 20);

        // Adiciona os componentes ao Frame
        f.setLayout(null);
        f.setLocationRelativeTo(null);
        f.add(nome);
        f.add(telefone);
        f.add(laClasse);
        f.add(tfNome);
        f.add(tfTelefone);
        f.add(listaClasses);
        f.add(continuar);

        mensagemErroNome = new JLabel("");
        mensagemErroNome.setBounds(30, 150, 300, 30);
        f.add(mensagemErroNome);

        mensagemErroTelefone = new JLabel("");
        mensagemErroTelefone.setBounds(30, 185, 300, 30);
        f.add(mensagemErroTelefone);

        // Torna a janela visivel
        f.setVisible(true);
        continuar.addActionListener(this);
    }

    /**
     * Metodo actionPerformed
     * 
     * Metodo acionado quando o botao "Continuar" e clicado.
     * Obtem os dados inseridos pelo usuario, realiza as verificacoes de validade
     * e, caso os dados sejam validos, redireciona para a tela de selecao de itinerarios.
     * 
     * @param e Objeto ActionEvent representando o evento de acao (clicar no botao "Continuar").
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        String nome = tfNome.getText();
        String telefone = tfTelefone.getText();
        String classeSelecionada = listaClasses.getSelectedValue();

        boolean nomeValido = controller.PassagemController.checkNome(nome);
        boolean telefoneValido = controller.PassagemController.checkTel(telefone);
        boolean classeSelecionadaValida = classeSelecionada != null;

        if (!classeSelecionadaValida) {
            JOptionPane.showMessageDialog(f, "Selecione uma classe.", "Erro", JOptionPane.ERROR_MESSAGE);
        }

        if (nomeValido && telefoneValido && classeSelecionadaValida) {
            ClassesPassagemAviaoEnum classe = ClassesPassagemAviaoEnum.getEnum(classeSelecionada);
            PassagemAviao dadosNovaPassagem = new PassagemAviao();
            dadosNovaPassagem.setNomePassageiro(nome);
            dadosNovaPassagem.setTelefone(telefone);
            dadosNovaPassagem.setClasse(classe);

            // Redirecionamento para a tela "Itinerario"
            new ItinerarioView(dadosNovaPassagem, Dados.getVoos());
            f.dispose();
        }
    }
}
