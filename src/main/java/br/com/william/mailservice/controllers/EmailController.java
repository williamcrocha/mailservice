package br.com.william.mailservice.controllers;

import br.com.william.mailservice.dtos.EmailDTO;
import br.com.william.mailservice.services.EmailService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmailController {

    @Autowired
    EmailService emailService;

    @PostMapping("/send")
    public ResponseEntity<EmailDTO> send(@RequestBody @Valid EmailDTO emailDTO){
        emailDTO = emailService.send(emailDTO);
        return new ResponseEntity<>(emailDTO, HttpStatus.OK);
    }
}
