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
import model.PassagemOnibus;
import model.enums.TipoPoltronaEnum;

/**
 * A classe OnibusView representa a tela de cadastro de passagem de onibus.
 * Nesta tela, o usuario pode inserir seu nome, telefone e escolher a classe do assento.
 */
public class OnibusView implements ActionListener {
    private JFrame f;
    private JLabel nome, telefone, laClasse, mensagemErroNome, mensagemErroTelefone;
    private JTextField tfNome, tfTelefone;
    private JList<String> listaClasses;
    private JButton continuar;

    /**
     * Construtor da classe OnibusView.
     * Cria a janela de cadastro de passagem de onibus e exibe os campos de nome, telefone
     * e uma lista de opcoes de classes de assento para o usuario escolher.
     */
    public OnibusView() {
        f = new JFrame("Ônibus");
        nome = new JLabel("Digite seu nome: ");
        telefone = new JLabel("Digite seu telefone: ");
        laClasse = new JLabel("Escolha a classe: ");
        tfNome = new JTextField(50);
        tfTelefone = new JTextField(12);

        // Cria um vetor com as possibilidades de classes
        String classes[] = TipoPoltronaEnum.toArray();
        listaClasses = new JList<String>(classes);
        continuar = new JButton("Continuar");
        f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Definindo tamanhos e posicoes dos componentes
        f.setSize(800, 600);
        nome.setBounds(30, 30, 180, 30);
        telefone.setBounds(30, 65, 180, 30);
        laClasse.setBounds(30, 100, 180, 30);
        tfNome.setBounds(210, 30, 200, 30);
        tfTelefone.setBounds(210, 65, 100, 30);
        listaClasses.setBounds(210, 100, 120, 80);
        continuar.setBounds(30, 200, 120, 20);

        // Adicionando os componentes ao frame
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

        // Torna a janela visivel e configura o botao para escutar o evento de clique
        f.setVisible(true);
        continuar.addActionListener(this);
    }

    /**
     * Metodo actionPerformed da interface ActionListener.
     * Executado quando o botao Continuar e clicado.
     * Verifica os dados inseridos pelo usuario e, se forem validos, cria um objeto
     * PassagemOnibus e redireciona para a tela "ItinerarioView".
     * Fecha a janela apos a acao ser executada.
     * @param e Evento gerado pelo clique no botao Continuar.
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
            TipoPoltronaEnum classe = TipoPoltronaEnum.getEnum(classeSelecionada);
            PassagemOnibus dadosNovaPassagem = new PassagemOnibus();
            dadosNovaPassagem.setNomePassageiro(nome);
            dadosNovaPassagem.setTelefone(telefone);
            dadosNovaPassagem.setTipoPoltrona(classe);

            // Redirecionamento para a tela "ItinerarioView"
            new ItinerarioView(dadosNovaPassagem, Dados.getTranslados());

            // Fecha a janela de cadastro de passagem de onibus
            f.dispose();
        }
    }
}
