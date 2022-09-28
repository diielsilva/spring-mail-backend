package com.olix.email_service.common.mapper;

import com.olix.email_service.common.representation.ShowEmail;
import com.olix.email_service.common.representation.StoreEmail;
import com.olix.email_service.domain.model.Email;

public interface EmailMapper {
    static Email convertFromStoreEmailToEmail(StoreEmail storeEmail) {
        Email email = new Email();
        email.setSenderName(storeEmail.getSenderName());
        email.setSenderEmail(storeEmail.getSenderEmail());
        email.setEmailSubject(storeEmail.getEmailSubject());
        email.setEmailContent(storeEmail.getEmailContent());
        return email;
    }

    static ShowEmail convertFromEmailToShowEmail(Email email) {
        ShowEmail showEmail = new ShowEmail();
        showEmail.setId(email.getId());
        showEmail.setSenderName(email.getSenderName());
        showEmail.setSenderEmail(email.getSenderEmail());
        showEmail.setEmailSubject(email.getEmailSubject());
        showEmail.setEmailContent(email.getEmailContent());
        showEmail.setSendDate(email.getSendDate());
        return showEmail;
    }
}
