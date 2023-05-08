package br.com.william.mailservice.services;

import br.com.william.mailservice.dtos.EmailDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class GoogleEmailService implements EmailService {

    @Autowired
    private JavaMailSender emailSender;

    @Override
    public EmailDTO send(EmailDTO emailDTO){
        log.debug("Sending emailDTO: {}",emailDTO);
        try{
            SimpleMailMessage email = new SimpleMailMessage();
            email.setFrom(emailDTO.getFrom());
            email.setTo(emailDTO.getTo());
            email.setSubject(emailDTO.getSubject());
            email.setText(emailDTO.getText());
            emailSender.send(email);
            emailDTO.setSuccess(true);
        } catch (MailException e){
            emailDTO.setSuccess(false);
            log.error(e.getMessage());
        }
        return emailDTO;
    }
}
