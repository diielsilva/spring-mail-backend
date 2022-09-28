package com.olix.email_service.domain.service.impl;

import com.olix.email_service.common.mapper.EmailMapper;
import com.olix.email_service.common.representation.ShowEmail;
import com.olix.email_service.common.representation.StoreEmail;
import com.olix.email_service.domain.helper.EmailHelper;
import com.olix.email_service.domain.model.Email;
import com.olix.email_service.domain.repository.EmailRepository;
import com.olix.email_service.domain.service.EmailService;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl implements EmailService {
    private final EmailRepository repository;
    private final JavaMailSender mailSender;


    public EmailServiceImpl(EmailRepository repository, JavaMailSender mailSender) {
        this.repository = repository;
        this.mailSender = mailSender;
    }

    @Override
    public ShowEmail sendEmail(StoreEmail storeEmail) {
        Email email = EmailMapper.convertFromStoreEmailToEmail(storeEmail);
        EmailHelper.sendDate(email);
        EmailHelper.mountAndSendEmail(email.getSenderEmail(), email.getEmailSubject(), email.getEmailContent(),
                this.mailSender);
        this.repository.save(email);
        return EmailMapper.convertFromEmailToShowEmail(email);
    }
}
