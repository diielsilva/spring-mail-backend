package com.olix.email_service.domain.enums;

public enum ExceptionCause {
    EMAIL_CANT_BE_SEND("Não foi possível enviar o e-mail, verifique se seu e-mail está correto ou tente novamente " +
            "mais" +
            " tarde", 500),
    INVALID_FIELDS_RECEIVED("Os campos recebidos estão inválidos", 400);

    public final String value;
    public final Integer status;

    ExceptionCause(String value, Integer status) {
        this.value = value;
        this.status = status;
    }
}
