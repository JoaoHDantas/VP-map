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
        setSize(750, 550); // Tamanho ajustado para mais espaço
        setLocationRelativeTo(null);

        // Container principal com gradiente de fundo suave e vetores
        JPanel mainPanel = new JPanel(new BorderLayout()) {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                // Criar gradiente suave para o fundo
                Graphics2D g2d = (Graphics2D) g;
                Color startColor = new Color(30, 30, 30); // Escuro para dar um contraste com os elementos
                Color endColor = new Color(45, 45, 45); // Um cinza mais claro
                GradientPaint gradient = new GradientPaint(0, 0, startColor, 0, getHeight(), endColor);
                g2d.setPaint(gradient);
                g2d.fillRect(0, 0, getWidth(), getHeight());

                // Adicionando formas vetoriais no fundo
                g.setColor(new Color(255, 120, 0, 30)); // Cor suave de laranja
                g.fillPolygon(new int[]{0, 100, 50}, new int[]{100, 150, 200}, 3); // Triângulo simples

                g.setColor(new Color(255, 0, 0, 30)); // Cor vermelha suave
                g.fillOval(200, 300, 100, 100); // Círculo leve no fundo
            }
        };
        mainPanel.setBorder(new EmptyBorder(20, 20, 20, 20));
        mainPanel.setOpaque(true); // Garantir que o painel principal é opaco, permitindo o fundo ser visível

        // Painel de entrada
        JPanel inputPanel = new JPanel(new GridLayout(8, 2, 15, 15)); // Aumentando o espaçamento entre os campos
        inputPanel.setBackground(new Color(45, 45, 45)); // Fundo mais escuro para o painel de entrada
        inputPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color(200, 200, 200), 2), "Criar Pixel", 0, 0, new Font("Arial", Font.BOLD, 16), new Color(200, 200, 200)));

        // Campos de entrada
        inputPanel.add(createLabel("Nome do Pixel:"));
        nomeField = createTextField();
        inputPanel.add(nomeField);

        inputPanel.add(createLabel("Descrição:"));
        descricaoField = createTextField();
        inputPanel.add(descricaoField);

        inputPanel.add(createLabel("Agente:"));
        agenteField = createTextField();
        inputPanel.add(agenteField);

        inputPanel.add(createLabel("Habilidade:"));
        habilidadeField = createTextField();
        inputPanel.add(habilidadeField);

        // Botões
        JButton adicionarButton = createButton("Adicionar Pixel", "add.png");
        inputPanel.add(adicionarButton);

        JButton listarButton = createButton("Listar Pixels", "list.png");
        inputPanel.add(listarButton);

        JButton removerButton = createButton("Remover Pixel", "remove.png");
        inputPanel.add(removerButton);

        JButton verPixelButton = createButton("Ver Pixel", "view.png");
        inputPanel.add(verPixelButton);

        mainPanel.add(inputPanel, BorderLayout.NORTH);

        // Lista de pixels
        pixelListModel = new DefaultListModel<>();
        JList<String> pixelList = new JList<>(pixelListModel);
        pixelList.setBackground(new Color(60, 60, 60)); // Cor de fundo para a lista de pixels
        pixelList.setForeground(Color.WHITE); // Cor do texto
        pixelList.setFont(new Font("Arial", Font.PLAIN, 14)); // Font mais limpa
        pixelList.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.WHITE), "Pixels Criados", 0, 0, new Font("Arial", Font.BOLD, 16), Color.WHITE));
        mainPanel.add(new JScrollPane(pixelList), BorderLayout.CENTER);

        // Estilizar botões
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

        removerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                removerPixel(pixelList.getSelectedValue());
            }
        });

        verPixelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                visualizarPixel(pixelList.getSelectedValue());
            }
        });

        // Adicionar ao frame
        add(mainPanel);
    }

    private JLabel createLabel(String text) {
        JLabel label = new JLabel(text);
        label.setForeground(new Color(230, 230, 230)); // Texto mais suave
        label.setFont(new Font("Arial", Font.BOLD, 14)); // Font com mais peso
        return label;
    }

    private JTextField createTextField() {
        JTextField textField = new JTextField();
        textField.setBackground(new Color(50, 50, 50)); // Cor de fundo mais escura para os campos
        textField.setForeground(new Color(230, 230, 230)); // Texto em branco suave
        textField.setBorder(BorderFactory.createLineBorder(new Color(90, 90, 90))); // Borda sutil
        textField.setFont(new Font("Arial", Font.PLAIN, 14)); // Font limpa
        textField.setCaretColor(Color.WHITE); // Cor do cursor
        textField.setBorder(BorderFactory.createLineBorder(new Color(90, 90, 90), 2, true)); // Borda arredondada
        return textField;
    }

    private JButton createButton(String text, String iconPath) {
        JButton button = new JButton(text);
        button.setBackground(new Color(60, 120, 180)); // Cor de botão suave
        button.setForeground(Color.WHITE);
        button.setFont(new Font("Arial", Font.BOLD, 14)); // Fonte em negrito
        button.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20)); // Borda limpa

        // Usando getClass().getClassLoader().getResource() para garantir que o caminho do ícone seja encontrado
        button.setBorder(BorderFactory.createLineBorder(new Color(255, 100, 0), 2, true)); // Borda arredondada
        button.setFocusPainted(false); // Remove o foco quando clica
        button.setCursor(new Cursor(Cursor.HAND_CURSOR)); // Cursor de mão
        button.setRolloverEnabled(true); // Habilitar efeito de hover

        button.setPreferredSize(new Dimension(160, 40)); // Tamanho ajustado do botão

        button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                button.setBackground(new Color(80, 160, 220)); // Mudança de cor ao passar o mouse
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                button.setBackground(new Color(60, 120, 180)); // Cor original
            }
        });

        // Adicionando um ícone simples (caso não haja ícones, usei o texto para representar)
        button.setText(text);

        return button;
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

    private void removerPixel(String selectedPixel) {
        if (selectedPixel != null) {
            try {
                // Extrair o ID do pixel da lista (por exemplo, "1: Pixel X")
                int id = Integer.parseInt(selectedPixel.split(":")[0]);
                pixelFacade.removerPixel(id);
                listarPixels(); // Atualiza a lista após a remoção
                JOptionPane.showMessageDialog(this, "Pixel removido com sucesso!");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Erro ao remover pixel: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Selecione um pixel para remover.");
        }
    }

    private void visualizarPixel(String selectedPixel) {
        if (selectedPixel != null) {
            try {
                // Extrair o ID do pixel da lista (por exemplo, "1: Pixel X")
                int id = Integer.parseInt(selectedPixel.split(":")[0]);
                String detalhes = pixelFacade.verPixel(id);
                JOptionPane.showMessageDialog(this, detalhes, "Detalhes do Pixel", JOptionPane.INFORMATION_MESSAGE);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Erro ao visualizar pixel: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Selecione um pixel para visualizar.");
        }
    }
}
