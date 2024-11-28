package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/mail")
@RequiredArgsConstructor
public class MailController {

    private final MailService mailService;

    @PostMapping("/send")
    public ResponseEntity<String> sendEmail(
            @RequestParam String to) {
        try {
            mailService.sendMail(to);
            return ResponseEntity.ok("Email sent successfully to: " + to);
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error sending email: " + e.getMessage());
        }
    }
}

