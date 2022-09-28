package com.olix.email_service.domain.service;

import com.olix.email_service.common.representation.ShowEmail;
import com.olix.email_service.common.representation.StoreEmail;

public interface EmailService {
    ShowEmail sendEmail(StoreEmail storeEmail);
}
