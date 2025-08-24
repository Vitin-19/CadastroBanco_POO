package src.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

public class CadastroBanco extends JFrame{
    private void centralizar(){
        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension janela = getSize();

        if (janela.height > screen.height) setSize(janela.width, screen.height);

        if(janela.width > screen.width) setSize(screen.width, janela.height);

        setLocation((screen.width - janela.width) / 2, (screen.height - janela.height) / 2);
    }

    public CadastroBanco(){
        super("Java Swing - Desenvolvimento de Sistemas");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(400,255);
        setLocationRelativeTo(null);
        setResizable(false);
        getContentPane().setLayout(null);


        // Instanciando os componentes
        JLabel jlAgencia = new JLabel("Código da agência");
        jlAgencia.setFont(new Font("Arial", Font.ITALIC, 12));
        jlAgencia.setBounds(10,10,110,18);
        getContentPane().add(jlAgencia);

        JTextField jtfAgencia = new JTextField();
        jtfAgencia.setBounds(125, 10, 50, 20);
        getContentPane().add(jtfAgencia);

        JLabel jlConta = new JLabel("Número da conta");
        jlConta.setFont(new Font("Arial", Font.ITALIC, 12));
        jlConta.setBounds(205,10,105,18);
        getContentPane().add(jlConta);

        JTextField jtfConta = new JTextField();
        jtfConta.setBounds(315, 10, 60, 20);
        getContentPane().add(jtfConta);
        

        JSeparator jSeparator01 = new JSeparator();
        jSeparator01.setBounds(10, 40, 365, 10);
        getContentPane().add(jSeparator01);


        JLabel jlNome = new JLabel("Nome:");
        jlNome.setBounds(10, 50, 60, 18);
        jlNome.setHorizontalAlignment(SwingConstants.RIGHT);
        getContentPane().add(jlNome);
    
        JTextField jtfNome = new JTextField();
        jtfNome.setBounds(75, 50, 300, 20);
        getContentPane().add(jtfNome);

        JLabel jlEndereco = new JLabel("Endereço: ");
        jlEndereco.setFont(new Font("Arial", Font.ITALIC, 12));
        jlEndereco.setBounds(10, 75, 60, 18);
        jlEndereco.setHorizontalAlignment(SwingConstants.RIGHT);
        getContentPane().add(jlEndereco);

        JTextField jtfEndereco = new JTextField();
        jtfEndereco.setBounds(75, 75, 300, 20);
        getContentPane().add(jtfEndereco);

        JLabel jlTelefone = new JLabel("Telefone: ");
        jlTelefone.setFont(new Font("Arial", Font.ITALIC, 12));
        jlTelefone.setBounds(10, 100, 60, 18);
        jlTelefone.setHorizontalAlignment(SwingConstants.RIGHT);
        getContentPane().add(jlTelefone);

        JTextField jtfTelefone = new JTextField();
        jtfTelefone.setBounds(75, 100, 300, 20);
        getContentPane().add(jtfTelefone);

        JLabel jlCPF = new JLabel("CPF: ");
        jlCPF.setFont(new Font("Arial", Font.ITALIC, 12));
        jlCPF.setBounds(10, 125, 60, 18);
        jlCPF.setHorizontalAlignment(SwingConstants.RIGHT);
        getContentPane().add(jlCPF);

        JTextField jtfCPF = new JTextField();
        jtfCPF.setBounds(75, 125, 300, 20);
        getContentPane().add(jtfCPF);

        JRadioButton jrbCorrente = new JRadioButton("Conta Corrente");
        jrbCorrente.setBounds(100, 150, 111, 20);
        jrbCorrente.setSelected(true);
        jrbCorrente.setMnemonic(KeyEvent.VK_C);
        getContentPane().add(jrbCorrente);

        JRadioButton jrbPoupanca = new JRadioButton("Conta Poupança");
        jrbPoupanca.setBounds(225, 150, 118, 20);
        jrbPoupanca.setMnemonic(KeyEvent.VK_P);
        getContentPane().add(jrbPoupanca);

        ButtonGroup bgContas = new ButtonGroup();
        bgContas.add(jrbCorrente);
        bgContas.add(jrbPoupanca);


        JSeparator jSeparator02 = new JSeparator();
        jSeparator02.setBounds(10, 180, 365, 10);
        getContentPane().add(jSeparator02);
        

        JButton jbConsultar = new JButton("Consultar");
        jbConsultar.setBounds(35, 190, 100, 23);
        jbConsultar.setMnemonic(KeyEvent.VK_S);
        getContentPane().add(jbConsultar);

        JButton jbAtualizar = new JButton("Atualizar");
        jbAtualizar.setBounds(145, 190, 100, 23);
        jbAtualizar.setMnemonic(KeyEvent.VK_A);
        jbAtualizar.setEnabled(false);
        getContentPane().add(jbAtualizar);

        JButton jbFechar = new JButton("Fechar");
        jbFechar.setBounds(255, 190, 100, 23);
        jbFechar.setMnemonic(KeyEvent.VK_F);
        getContentPane().add(jbFechar);

    }
}