import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;

public class SendEmail {
    public static void main(String[] args) {

        String host = "smtp.gmail.com";
        String port = "587";
        String username = "colocar o email que envia @gmail.com";
        String password = "senha do email acima";
        String recipient = "destinatario";

        // Configurações adicionais
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", port);

        // Sessão de e-mail
        Session session = Session.getInstance(props, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {
            // Cria uma mensagem de e-mail
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipient));
            message.setSubject("Assunto do E-mail");
            message.setText("TESTE DE EMAIL AUTOMATICO FEITO PELO RITZ");

            // Envia a mensagem
            Transport.send(message);

            System.out.println("E-mail enviado com sucesso!");

        } catch (MessagingException e) {
            System.out.println("Erro ao enviar o e-mail: " + e.getMessage());
        }
    }
}
