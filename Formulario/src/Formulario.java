import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;

public class Formulario extends JFrame {
    private JTextField nomeField, matriculaField;
    private JRadioButton etimButton, mtecButton, tecnicoButton;
    private JRadioButton primeiraSerieButton, segundaSerieButton, terceiraSerieButton;
    private JComboBox<String> periodoComboBox;
    private JTextArea restricoesTextArea;
    private JButton apresentarButton, limparButton, sairButton;

    // Definição dos grupos de botões
    private ButtonGroup cursoGroup = new ButtonGroup();
    private ButtonGroup serieGroup = new ButtonGroup();

    public Formulario() {
        super("Dados Cadastrais do Aluno");

        Container tela = getContentPane();
        tela.setLayout(null);

        // Definição dos componentes
        JLabel tituloLabel = new JLabel("Dados Cadastrais do Aluno");
        tituloLabel.setFont(new Font("Arial", Font.BOLD, 16));
        tituloLabel.setBounds(110, 10, 300, 20);

        JLabel nomeLabel = new JLabel("Nome:");
        nomeLabel.setBounds(20, 40, 100, 20);
        nomeField = new JTextField();
        nomeField.setBounds(120, 40, 250, 20);
        nomeField.setText("Insira aqui seu nome");
        nomeField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (nomeField.getText().equals("Insira aqui seu nome")) {
                    nomeField.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (nomeField.getText().isEmpty()) {
                    nomeField.setText("Insira aqui seu nome");
                }
            }
        });

        JLabel matriculaLabel = new JLabel("Matrícula:");
        matriculaLabel.setBounds(20, 70, 100, 20);
        matriculaField = new JTextField();
        matriculaField.setBounds(120, 70, 250, 20);
        matriculaField.setText("Insira aqui sua matricula");
        matriculaField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (matriculaField.getText().equals("Insira aqui sua matricula")) {
                    matriculaField.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (matriculaField.getText().isEmpty()) {
                    matriculaField.setText("Insira aqui sua matricula");
                }
            }
        });

        JLabel cursoLabel = new JLabel("Informe os dados do seu curso:");
        cursoLabel.setBounds(20, 100, 300, 20);

        etimButton = new JRadioButton("Etim");
        etimButton.setBounds(20, 130, 100, 20);
        mtecButton = new JRadioButton("Mtec");
        mtecButton.setBounds(20, 160, 100, 20);
        tecnicoButton = new JRadioButton("Técnico");
        tecnicoButton.setBounds(20, 190, 100, 20);

        // Adiciona botões ao grupo
        cursoGroup.add(etimButton);
        cursoGroup.add(mtecButton);
        cursoGroup.add(tecnicoButton);

        primeiraSerieButton = new JRadioButton("1ª série");
        primeiraSerieButton.setBounds(150, 130, 100, 20);
        segundaSerieButton = new JRadioButton("2ª série");
        segundaSerieButton.setBounds(150, 160, 100, 20);
        terceiraSerieButton = new JRadioButton("3ª série");
        terceiraSerieButton.setBounds(150, 190, 100, 20);

        // Adiciona botões ao grupo
        serieGroup.add(primeiraSerieButton);
        serieGroup.add(segundaSerieButton);
        serieGroup.add(terceiraSerieButton);

        String[] periodos = {"Matutino", "Vespertino", "Noturno"};
        periodoComboBox = new JComboBox<>(periodos);
        periodoComboBox.setBounds(280, 130, 100, 20);

        JLabel restricoesLabel = new JLabel("Restrições Médicas:");
        restricoesLabel.setBounds(20, 220, 150, 20);
        restricoesTextArea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(restricoesTextArea);
        scrollPane.setBounds(20, 250, 360, 50);

        apresentarButton = new JButton("Apresentar Dados");
        apresentarButton.setBounds(20, 320, 150, 30);
        apresentarButton.setMnemonic(KeyEvent.VK_A);
        apresentarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (verificarCamposObrigatorios()) {
                    String curso = "", serie = "";

                    String nomee = nomeField.getText();
                    String matrice = matriculaField.getText();
                    String restre = restricoesTextArea.getText();
                    String periode = periodoComboBox.getSelectedItem().toString(); // pegar texto do Jcombobox

                    // pegar texto do botão de opção
                    if (primeiraSerieButton.isSelected()) {
                        serie = primeiraSerieButton.getText();
                    } else if (segundaSerieButton.isSelected()) {
                        serie = segundaSerieButton.getText();
                    } else {
                        serie = terceiraSerieButton.getText();
                    }

                    // pegar texto do rádio
                    if (etimButton.isSelected()) {
                        curso = etimButton.getText();
                    } else if (mtecButton.isSelected()) {
                        curso = mtecButton.getText();
                    } else {
                        curso = tecnicoButton.getText();
                    }

                    frmMostrar mostra = new frmMostrar(nomee, matrice, restre, periode, curso, serie);
                    mostra.setVisible(true);
                    dispose();
                }
            }
        });

        limparButton = new JButton("Limpar");
        limparButton.setBounds(180, 320, 100, 30);
        limparButton.setMnemonic(KeyEvent.VK_L);
        limparButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                limparFormulario();
            }
        });

        sairButton = new JButton("Sair");
        sairButton.setBounds(290, 320, 100, 30);
        sairButton.setMnemonic(KeyEvent.VK_S);
        sairButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        // Adiciona os componentes à tela
        tela.add(tituloLabel);
        tela.add(nomeLabel);
        tela.add(nomeField);
        tela.add(matriculaLabel);
        tela.add(matriculaField);
        tela.add(cursoLabel);
        tela.add(etimButton);
        tela.add(mtecButton);
        tela.add(tecnicoButton);
        tela.add(primeiraSerieButton);
        tela.add(segundaSerieButton);
        tela.add(terceiraSerieButton);
        tela.add(periodoComboBox);
        tela.add(restricoesLabel);
        tela.add(scrollPane);
        tela.add(apresentarButton);
        tela.add(limparButton);
        tela.add(sairButton);

        // Configurações da janela
        setSize(450, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
        
        // Define um ícone para a janela
        
            ImageIcon icon = new ImageIcon("src/form.png");
            setIconImage(icon.getImage());
    }

    private void limparFormulario() {
        nomeField.setText("");
        matriculaField.setText("");
        cursoGroup.clearSelection();
        serieGroup.clearSelection();
        periodoComboBox.setSelectedIndex(0);
        restricoesTextArea.setText("");
    }

    private boolean verificarCamposObrigatorios() {
        if (nomeField.getText().isEmpty() || nomeField.getText().equals("Insira aqui seu nome")) {
            JOptionPane.showMessageDialog(this, "Por favor, preencha o campo Nome.", "Campo Obrigatório", JOptionPane.WARNING_MESSAGE);
            nomeField.requestFocus();
            return false;
        }
        if (matriculaField.getText().isEmpty() || matriculaField.getText().equals("Insira aqui sua matricula")) {
            JOptionPane.showMessageDialog(this, "Por favor, preencha o campo Matrícula.", "Campo Obrigatório", JOptionPane.WARNING_MESSAGE);
            matriculaField.requestFocus();
            return false;
        }
        if (!etimButton.isSelected() && !mtecButton.isSelected() && !tecnicoButton.isSelected()) {
            JOptionPane.showMessageDialog(this, "Por favor, selecione um curso.", "Campo Obrigatório", JOptionPane.WARNING_MESSAGE);
            etimButton.requestFocus();
            return false;
        }
        if (!primeiraSerieButton.isSelected() && !segundaSerieButton.isSelected() && !terceiraSerieButton.isSelected()) {
            JOptionPane.showMessageDialog(this, "Por favor, selecione uma série.", "Campo Obrigatório", JOptionPane.WARNING_MESSAGE);
            primeiraSerieButton.requestFocus();
            return false;
        }
        if (restricoesTextArea.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, preencha o campo Restrições Médicas. Se não tiver nenhuma, escreva: Nenhuma", "Campo Obrigatório", JOptionPane.WARNING_MESSAGE);
            restricoesTextArea.requestFocus();
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        new Formulario();
    }
}
