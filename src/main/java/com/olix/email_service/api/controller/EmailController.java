package com.olix.email_service.api.controller;

import com.olix.email_service.common.representation.ShowEmail;
import com.olix.email_service.common.representation.StoreEmail;
import com.olix.email_service.domain.service.EmailService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin(value = "http://localhost:4200")
@RestController
@RequestMapping(value = "emails")
public class EmailController {
    private final EmailService emailService;

    public EmailController(EmailService emailService) {
        this.emailService = emailService;
    }

    @PostMapping
    public ResponseEntity<ShowEmail> sendEmail(@RequestBody @Valid StoreEmail storeEmail) {
        ShowEmail showEmail = this.emailService.sendEmail(storeEmail);
        return new ResponseEntity<>(showEmail, HttpStatus.CREATED);
    }
}
