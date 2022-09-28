package com.olix.email_service.common.representation;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class StoreEmail {
    @NotBlank(message = "O nome do remetente não pode ser nulo ou vazio")
    private String senderName;
    @NotBlank(message = "O e-mail do remetente não pode ser nulo ou vazio")
    @Email(message = "Formato de e-mail inválido")
    private String senderEmail;
    @NotBlank(message = "O assunto do e-mail não pode ser nulo ou vazio")
    private String emailSubject;
    @NotBlank(message = "A mensagem do e-mail não pode ser nula ou vazia")
    private String emailContent;

    public String getSenderName() {
        return senderName;
    }

    public void setSenderName(String senderName) {
        this.senderName = senderName;
    }

    public String getSenderEmail() {
        return senderEmail;
    }

    public void setSenderEmail(String senderEmail) {
        this.senderEmail = senderEmail;
    }

    public String getEmailSubject() {
        return emailSubject;
    }

    public void setEmailSubject(String emailSubject) {
        this.emailSubject = emailSubject;
    }

    public String getEmailContent() {
        return emailContent;
    }

    public void setEmailContent(String emailContent) {
        this.emailContent = emailContent;
    }
}
