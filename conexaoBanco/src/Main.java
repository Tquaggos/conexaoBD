import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
void main() {

    JFrame tela = new JFrame("Tela de Cadastro");
    tela.setSize(500, 400);
    tela.setLayout(null);



    JLabel labelNome = new JLabel("Nome");
    labelNome.setBounds(20, 50, 150, 40);
    tela.add(labelNome);

    JTextField nome = new JTextField();
    nome.setBounds(20, 80, 250, 40);
    tela.add(nome);


    JLabel labelEmail = new JLabel("E-mail");
    labelEmail.setBounds(20, 110, 150, 40);
    tela.add(labelEmail);

    JTextField email = new JTextField();
    email.setBounds(20, 150, 250, 40);
    tela.add(email);


    JButton enviar = new JButton("Enviar");
    enviar.setBounds(80, 200, 150, 40);
    tela.add(enviar);


    enviar.addActionListener(e -> {
        String sql = "INSERT INTO usuario(nome, email) VALUES(?, ?)";
        String nomeCompleto = nome.getText();
        String emailUsuario = email.getText();

        try {
            // conexão com o banco
            Connection conexao = Conexao.conectar();

            PreparedStatement ps = Conexao.conectar().prepareStatement(sql);
            ps.setString(1 ,nomeCompleto);
            ps.setString(2 ,emailUsuario);
            ps.executeUpdate();

            JOptionPane.showMessageDialog(null,"Usuario salvo com sucesso");
            ps.close();

        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    });

    tela.setVisible(true);
}
