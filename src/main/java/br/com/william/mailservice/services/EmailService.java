package br.com.william.mailservice.services;

import br.com.william.mailservice.dtos.EmailDTO;

public interface EmailService {
    EmailDTO send(EmailDTO emailDTO);
}
