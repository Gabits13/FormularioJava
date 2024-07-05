import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class frmMostrar extends JFrame {
    private JLabel lblNome, lblMatric, lblRest, lblPerio, lblCurso, lblSerie;
    private JButton btnVoltar, btnSair;

    public frmMostrar(String nome, String matr, String rest, String period, String curso, String serie) {
        super("Dados Apresentados");

        Container tela = getContentPane();
        tela.setLayout(null);

        JLabel tituloLabel = new JLabel("Dados Apresentados do Aluno");
        tituloLabel.setFont(new Font("Arial", Font.BOLD, 16));
        tituloLabel.setBounds(80, 10, 300, 20);

        lblNome = new JLabel("Nome: " + nome);
        lblNome.setBounds(20, 40, 300, 20);

        lblMatric = new JLabel("Matrícula: " + matr);
        lblMatric.setBounds(20, 70, 300, 20);

        lblRest = new JLabel("Restrições Médicas: " + rest);
        lblRest.setBounds(20, 100, 300, 20);

        lblPerio = new JLabel("Período: " + period);
        lblPerio.setBounds(20, 130, 300, 20);

        lblCurso = new JLabel("Curso: " + curso);
        lblCurso.setBounds(20, 160, 300, 20);

        lblSerie = new JLabel("Série: " + serie);
        lblSerie.setBounds(20, 190, 300, 20);

        btnVoltar = new JButton("Voltar");
        btnVoltar.setBounds(20, 230, 100, 30);
        btnVoltar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Formulario().setVisible(true);
                dispose();
            }
        });

        btnSair = new JButton("Sair");
        btnSair.setBounds(250, 230, 100, 30);
        btnSair.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        tela.add(tituloLabel);
        tela.add(lblNome);
        tela.add(lblMatric);
        tela.add(lblRest);
        tela.add(lblPerio);
        tela.add(lblCurso);
        tela.add(lblSerie);
        tela.add(btnVoltar);
        tela.add(btnSair);

         // Define um ícone para a janela
        
            ImageIcon icon = new ImageIcon("src/form.png");
            setIconImage(icon.getImage());
            
        setSize(400, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
    }

    public static void main(String[] args) {
        // Exemplo de uso
        new frmMostrar("Gabriel Santos", "24177", "Tenho algumas alergias", "Matutino", "Etim", "2ª série");
    }
}
