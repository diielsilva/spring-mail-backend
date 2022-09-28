package com.olix.email_service.domain.helper;

import com.olix.email_service.domain.enums.ExceptionCause;
import com.olix.email_service.domain.exception.BusinessException;
import com.olix.email_service.domain.model.Email;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import java.time.OffsetDateTime;

public interface EmailHelper {
    static void sendDate(Email email) {
        email.setSendDate(OffsetDateTime.now());
    }

    static void mountAndSendEmail(String emailSender, String subject, String content, JavaMailSender mailSender) {
        try {
            final String defaultEmailSender = "diielsilvasousa@gmail.com";
            final String defaultEmailTo = "daniel.sousa@olixcorp.com";
            SimpleMailMessage mailMessage = new SimpleMailMessage();
            mailMessage.setFrom(defaultEmailSender);
            mailMessage.setTo(defaultEmailTo);
            mailMessage.setSubject(subject);
            mailMessage.setText(content + "\nEmail enviado por: " + emailSender);
            mailSender.send(mailMessage);
        } catch (MailException exception) {
            throw new BusinessException(ExceptionCause.EMAIL_CANT_BE_SEND);
        }
    }
}
