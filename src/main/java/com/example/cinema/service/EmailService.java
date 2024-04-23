package com.example.cinema.service;

import com.example.cinema.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;


@Service
public class EmailService {
    private final  JavaMailSender javaMailSender;
    @Autowired
    public EmailService(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }
    public void sendResetPasswordEmail(User user, String resetToken) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(user.getEmail());
        message.setSubject("Password Reset Request");
        message.setText("Click the following link to reset your password: " + generateResetLink(resetToken));
        javaMailSender.send(message);
    }
    private String generateResetLink(String resetToken) {
        return "\"http://localhost:4200/resetPassword/" + resetToken + "\" Click here to reset your password</a>";
    }
    private String buildEmailBody(String fullName, String resetLink) {
        // Customize the email body
        return "Hello " + fullName + ",\n\n"
                + "We received a request to reset your password. "
                + "Click the following link to reset your password:\n"
                + resetLink + "\n\n"
                + "If you did not request this, please ignore this email."
                + "\n\n"
                + "Best regards,\n"
                + "Your App Team";
    }
}
