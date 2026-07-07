package ar.edu.utn.frba.ddsi.climalert.adapter;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component
public class MailAdapter {

  private final JavaMailSender mailSender;
  private static final Logger logger = LoggerFactory.getLogger(MailAdapter.class);


  public MailAdapter(JavaMailSender mailSender){

    this.mailSender = mailSender;

  }

  public void enviar(String destinatario, String asunto, String contenido){

    SimpleMailMessage mensaje = new SimpleMailMessage();

    mensaje.setTo(destinatario);

    mensaje.setSubject(asunto);

    mensaje.setText(contenido);

    mailSender.send(mensaje);

    logger.info("Correo enviado correctamente a {}", destinatario);

  }

}