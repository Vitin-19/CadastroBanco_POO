package src.view;

import javax.swing.*;

import src.controller.BotaoFechar;
import src.controller.ClienteController;
import src.controller.ContaController;
import src.model.Cliente;
import src.model.Conta;
import src.model.ContaCorrente;
import src.model.ContaPoupanca;

import java.awt.*;
import java.awt.event.*;

public class CadastroBanco extends JPanel{
    private final ContaController contaController = new ContaController();
    private final ClienteController clienteController = new ClienteController();

    private void centralizar(){
        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension janela = getSize();

        if (janela.height > screen.height) setSize(janela.width, screen.height);

        if(janela.width > screen.width) setSize(screen.width, janela.height);

        setLocation((screen.width - janela.width) / 2, (screen.height - janela.height) / 2);
    }

    public boolean haSomenteNumeros(String txt){
        return txt != null && txt.matches("\\d+");
    }

    public CadastroBanco(){
        setLayout(null);

        // Instanciando os componentes
        JLabel jlAgencia = new JLabel("Código da agência");
        jlAgencia.setFont(new Font("Arial", Font.ITALIC, 12));
        jlAgencia.setBounds(10,10,110,18);
        add(jlAgencia);

        JTextField jtfAgencia = new JTextField();
        jtfAgencia.setBounds(125, 10, 50, 20);
        add(jtfAgencia);

        JLabel jlConta = new JLabel("Número da conta");
        jlConta.setFont(new Font("Arial", Font.ITALIC, 12));
        jlConta.setBounds(205,10,105,18);
        add(jlConta);

        JTextField jtfConta = new JTextField();
        jtfConta.setBounds(315, 10, 60, 20);
        add(jtfConta);
        

        JSeparator jSeparator01 = new JSeparator();
        jSeparator01.setBounds(10, 40, 365, 10);
        add(jSeparator01);


        JLabel jlNome = new JLabel("Nome:");
        jlNome.setBounds(10, 50, 60, 18);
        jlNome.setHorizontalAlignment(SwingConstants.RIGHT);
        add(jlNome);
    
        JTextField jtfNome = new JTextField();
        jtfNome.setBounds(75, 50, 300, 20);
        add(jtfNome);

        JLabel jlEndereco = new JLabel("Endereço: ");
        jlEndereco.setFont(new Font("Arial", Font.ITALIC, 12));
        jlEndereco.setBounds(10, 75, 60, 18);
        jlEndereco.setHorizontalAlignment(SwingConstants.RIGHT);
        add(jlEndereco);

        JTextField jtfEndereco = new JTextField();
        jtfEndereco.setBounds(75, 75, 300, 20);
        add(jtfEndereco);

        JLabel jlTelefone = new JLabel("Telefone: ");
        jlTelefone.setFont(new Font("Arial", Font.ITALIC, 12));
        jlTelefone.setBounds(10, 100, 60, 18);
        jlTelefone.setHorizontalAlignment(SwingConstants.RIGHT);
        add(jlTelefone);

        JTextField jtfTelefone = new JTextField();
        jtfTelefone.setBounds(75, 100, 300, 20);
        add(jtfTelefone);

        JLabel jlCPF = new JLabel("CPF: ");
        jlCPF.setFont(new Font("Arial", Font.ITALIC, 12));
        jlCPF.setBounds(10, 125, 60, 18);
        jlCPF.setHorizontalAlignment(SwingConstants.RIGHT);
        add(jlCPF);

        JTextField jtfCPF = new JTextField();
        jtfCPF.setBounds(75, 125, 300, 20);
        add(jtfCPF);

        JRadioButton jrbCorrente = new JRadioButton("Conta Corrente");
        jrbCorrente.setBounds(100, 150, 111, 20);
        jrbCorrente.setSelected(true);
        jrbCorrente.setMnemonic(KeyEvent.VK_C);
        jrbCorrente.setActionCommand("Conta Corrente");
        add(jrbCorrente);

        JRadioButton jrbPoupanca = new JRadioButton("Conta Poupança");
        jrbPoupanca.setBounds(225, 150, 118, 20);
        jrbPoupanca.setMnemonic(KeyEvent.VK_P);
        jrbPoupanca.setActionCommand("Conta Poupança");
        add(jrbPoupanca);

        ButtonGroup bgContas = new ButtonGroup();
        bgContas.add(jrbCorrente);
        bgContas.add(jrbPoupanca);


        JSeparator jSeparator02 = new JSeparator();
        jSeparator02.setBounds(10, 180, 365, 10);
        add(jSeparator02);
        

        JButton jbConsultar = new JButton("Consultar");
        jbConsultar.setBounds(35, 190, 100, 23);
        jbConsultar.setMnemonic(KeyEvent.VK_S);
        jbConsultar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event){
                Conta conta = null;

                switch(bgContas.getSelection().getActionCommand()){
                    case "Conta Corrente":
                        try{
                            int Agencia = Integer.parseInt(jtfAgencia.getText());
                            int numero = Integer.parseInt(jtfConta.getText());
                            conta = new ContaCorrente(Agencia, numero, 0);
                        }catch(Exception e){
                            JOptionPane.showMessageDialog(null, "Dados inválidos", "Falha na consulta", JOptionPane.ERROR_MESSAGE);
                            return;
                        }
                        break;
                    case "Conta Poupança":
                        try{
                            int Agencia = Integer.parseInt(jtfAgencia.getText());
                            int numero = Integer.parseInt(jtfConta.getText());
                            conta = new ContaPoupanca(Agencia, numero, 0);
                        }catch(Exception e){
                            JOptionPane.showMessageDialog(null, "Dados inválidos", "Falha na consulta", JOptionPane.ERROR_MESSAGE);
                            return;
                        }
                        break;
                }
                String nome = jtfNome.getText().toUpperCase();
                String endereco = jtfEndereco.getText().toLowerCase();
                String telefone = jtfTelefone.getText();
                String cpf = jtfCPF.getText();

                contaController.botaoConsultar(conta, new Cliente(nome, endereco, telefone, cpf));
            }
        });
        add(jbConsultar);

        JButton jbAtualizar = new JButton("Atualizar cliente");
        jbAtualizar.setBounds(145, 190, 100, 23);
        jbAtualizar.setMnemonic(KeyEvent.VK_A);
        add(jbAtualizar);
        jbAtualizar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event){
                String nome = jtfNome.getText().toUpperCase();
                String endereco = jtfEndereco.getText().toLowerCase();
                String telefone = jtfTelefone.getText();
                String cpf = jtfCPF.getText();

                if(telefone.length() != 11 || cpf.length() != 11 || !haSomenteNumeros(cpf) ||!haSomenteNumeros(telefone)){
                    JOptionPane.showMessageDialog(null, "Telefone e cpf devem possuir apenas 11 valors numéricos", "Falha na consulta", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                
                clienteController.botaoAtualizar(new Cliente(nome, endereco, telefone, cpf));
            }
        });

        JButton jbFechar = new JButton("Fechar");
        jbFechar.setBounds(255, 190, 100, 23);
        jbFechar.setMnemonic(KeyEvent.VK_F);
        jbFechar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event){
                BotaoFechar botaoFechar = new BotaoFechar();
                botaoFechar.fechar();
            }
        });
        
        add(jbFechar);

    }
}