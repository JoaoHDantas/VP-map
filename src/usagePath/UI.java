package usagePath;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UI extends JFrame {



    private JTextField nomeField;
    private JTextField descricaoField;
    private JTextField agenteField;
    private JTextField habilidadeField;
    private DefaultListModel<String> pixelListModel;

    private PixelFacade pixelFacade; // Fachada do sistema

    public UI() {
        pixelFacade = new PixelFacade(); // Inicializa a fachada

        setTitle("Sistema de Pixels");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setLocationRelativeTo(null);

        // Container principal
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBorder(new EmptyBorder(10, 10, 10, 10));

        // Painel de entrada
        JPanel inputPanel = new JPanel(new GridLayout(6, 2, 10, 10));
        inputPanel.setBorder(BorderFactory.createTitledBorder("Criar Pixel"));

        // Campos de entrada
        inputPanel.add(new JLabel("Nome do Pixel:"));
        nomeField = new JTextField();
        inputPanel.add(nomeField);

        inputPanel.add(new JLabel("Descrição:"));
        descricaoField = new JTextField();
        inputPanel.add(descricaoField);

        inputPanel.add(new JLabel("Agente:"));
        agenteField = new JTextField();
        inputPanel.add(agenteField);

        inputPanel.add(new JLabel("Habilidade:"));
        habilidadeField = new JTextField();
        inputPanel.add(habilidadeField);

        // Botões
        JButton adicionarButton = new JButton("Adicionar Pixel");
        inputPanel.add(adicionarButton);

        JButton listarButton = new JButton("Listar Pixels");
        inputPanel.add(listarButton);

        mainPanel.add(inputPanel, BorderLayout.NORTH);

        // Lista de pixels
        pixelListModel = new DefaultListModel<>();
        JList<String> pixelList = new JList<>(pixelListModel);
        pixelList.setBorder(BorderFactory.createTitledBorder("Pixels Criados"));
        mainPanel.add(new JScrollPane(pixelList), BorderLayout.CENTER);

        // Estilizar botões e fonte
        adicionarButton.setFont(new Font("Arial", Font.BOLD, 14));
        adicionarButton.setBackground(new Color(34, 139, 34));
        adicionarButton.setForeground(Color.WHITE);

        listarButton.setFont(new Font("Arial", Font.BOLD, 14));
        listarButton.setBackground(new Color(70, 130, 180));
        listarButton.setForeground(Color.WHITE);

        // Ações dos botões
        adicionarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                adicionarPixel();
            }
        });

        listarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listarPixels();
            }
        });

        // Adicionar ao frame
        add(mainPanel);
    }

    private void adicionarPixel() {
        String nome = nomeField.getText();
        String descricao = descricaoField.getText();
        String agente = agenteField.getText();
        String habilidade = habilidadeField.getText();

        try {
            pixelFacade.criarPixel(nome, descricao, agente, habilidade);

            // Limpar os campos após adicionar
            nomeField.setText("");
            descricaoField.setText("");
            agenteField.setText("");
            habilidadeField.setText("");

        } catch (IllegalArgumentException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void listarPixels() {
        pixelListModel.clear(); // Limpa a lista antes de exibir os pixels
        for (String pixel : pixelFacade.getPixels()) {
            pixelListModel.addElement(pixel);
        }
    }


}
