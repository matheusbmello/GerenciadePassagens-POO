package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

import model.Passagem;

/**
 * A classe ListPassagemView representa a tela de listagem de passagens.
 * Nesta tela, o usuario pode visualizar as informacoes das passagens cadastradas.
 * O usuario tem a opcao de alterar uma passagem de aviao, alterar uma passagem de onibus ou retornar a tela inicial.
 */
public class ListPassagemView implements ActionListener {
    private static JFrame f;
    private static JLabel texto;
    private static JButton retornar, alterarA, alterarO;

    /**
     * Construtor da classe ListPassagemView.
     * Cria a janela de listagem de passagens e exibe os botoes "Alterar passagem de aviao",
     * "Alterar passagem de onibus" e "Retornar a tela inicial".
     * @param passagens Lista de passagens cadastradas a serem exibidas na tela.
     */
    public ListPassagemView(ArrayList<Passagem> passagens) {
        f = new JFrame("Alteração de passagem");
        texto = new JLabel("Confira os dados da passagem!");
        alterarA = new JButton("Alterar passagem de avião");
        alterarO = new JButton("Alterar passagem de ônibus");
        retornar = new JButton("Retornar à tela inicial");

        f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Dimensionar na Tela
        f.setSize(800, 600);
        texto.setBounds(30, 30, 800, 30);
        alterarA.setBounds(135, 200, 200, 30);
        alterarO.setBounds(405, 200, 200, 30);
        retornar.setBounds(275, 300, 200, 30);

        // Adicionar os componentes ao Frame
        f.setLayout(null);
        f.add(texto);
        f.add(alterarA);
        f.add(alterarO);
        f.add(retornar);
        f.setLocationRelativeTo(null);
        f.setVisible(true);
        alterarA.addActionListener(this);
        alterarO.addActionListener(this);
        retornar.addActionListener(this);
    }

    /**
     * Metodo actionPerformed da interface ActionListener.
     * Executado quando um dos botoes e clicado.
     * Abre a tela correspondente a opcao selecionada ou retorna a tela inicial.
     * @param e Evento gerado pelo clique em um dos botoes.
     */
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == alterarA) {
            new AviaoView();
        } else if(e.getSource() == alterarO){
            new OnibusView();
        } else if (e.getSource() == retornar) {
            new TelaInicialView();
        }      
    }
}
