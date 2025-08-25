package src.view;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;

public class MainPane extends JFrame{
    public MainPane(){
        super("Java Swing - Desenvolvimento de Sistemas");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(400,290);
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(null);

        CadastroBanco cadastroBanco = new CadastroBanco();
        CadastroUsuario cadastroUsuario = new CadastroUsuario();
        Transacoes transacoes = new Transacoes();

        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.setBounds(0,0,400,255);
        tabbedPane.add("Início",cadastroBanco);
        tabbedPane.add("Criar conta",cadastroUsuario);
        tabbedPane.add("Transações",transacoes);
        add(tabbedPane);
    }
}
