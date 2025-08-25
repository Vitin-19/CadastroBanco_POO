package src.view;

import javax.swing.*;

import src.controller.ContaController;

import java.awt.*;
import java.awt.event.*;

public class Transacoes extends JPanel{
    private final ContaController contaController = new ContaController();

    public Transacoes(){
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


        JLabel jlValor = new JLabel("Valor:");
        jlValor.setBounds(0, 50, 60, 18);
        jlValor.setHorizontalAlignment(SwingConstants.RIGHT);
        add(jlValor);
    
        JTextField jtfValor = new JTextField();
        jtfValor.setBounds(75, 50, 50, 20);
        add(jtfValor);

        JRadioButton jrbCorrente = new JRadioButton("Conta Corrente");
        jrbCorrente.setBounds(70, 70, 111, 20);
        jrbCorrente.setSelected(true);
        jrbCorrente.setMnemonic(KeyEvent.VK_C);
        add(jrbCorrente);

        JRadioButton jrbPoupanca = new JRadioButton("Conta Poupança");
        jrbPoupanca.setBounds(181, 70, 118, 20);
        jrbPoupanca.setMnemonic(KeyEvent.VK_P);
        add(jrbPoupanca);

        ButtonGroup bgContas = new ButtonGroup();
        bgContas.add(jrbCorrente);
        bgContas.add(jrbPoupanca);

        JLabel resultado = new JLabel();
        resultado.setBounds(181, 110, 118, 20);
        add(resultado);


        JSeparator jSeparator02 = new JSeparator();
        jSeparator02.setBounds(10, 180, 365, 10);
        add(jSeparator02);

        JButton jbSacar = new JButton("Sacar");
        jbSacar.setBounds(35, 190, 100, 23);
        jbSacar.setMnemonic(KeyEvent.VK_C);
        jbSacar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event){
                try{
                    int agencia = Integer.parseInt(jtfAgencia.getText());
                    int numero = Integer.parseInt(jtfConta.getText());
                    double valor = Math.abs(Double.parseDouble(jtfValor.getText()));

                    contaController.botaoSacar(agencia, numero, valor);
                }catch(Exception e){
                    JOptionPane.showMessageDialog(null, "Dados inválidos", "Falha na transação", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        add(jbSacar);

        JButton jbDepositar = new JButton("Depositar");
        jbDepositar.setBounds(255, 190, 100, 23);
        jbDepositar.setMnemonic(KeyEvent.VK_F);
        jbDepositar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event){
                try{
                    int agencia = Integer.parseInt(jtfAgencia.getText());
                    int numero = Integer.parseInt(jtfConta.getText());
                    double valor = Math.abs(Double.parseDouble(jtfValor.getText()));

                    contaController.botaoDepositar(agencia, numero, valor);
                }catch(Exception e){
                    JOptionPane.showMessageDialog(null, "Dados inválidos", "Falha na transação", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        add(jbDepositar);
    }
}
