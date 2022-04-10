package com.ondodox.ondodoxlibrary.models.services;

import com.ondodox.ondodoxlibrary.dto.EmailData;
import com.ondodox.ondodoxlibrary.models.entities.Buku;
import com.ondodox.ondodoxlibrary.models.repositories.BukuRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.UnsupportedEncodingException;

@Service
public class MailServices {
    @Autowired
    private JavaMailSender sender;
    @Autowired
    private BukuRepo bukuRepo;

    public MailServices(JavaMailSender sender) {
        this.sender = sender;
    }

    public void send(EmailData data) throws MessagingException, UnsupportedEncodingException {
        MimeMessage message = sender.createMimeMessage();

        MimeMessageHelper helper = new MimeMessageHelper(message);
        helper.setFrom(data.getFromEmail(), data.getFromPersonal());
        helper.setTo(data.getTo());
        helper.setSubject(data.getSubject());
        helper.setText(data.getComponent(), true);
        sender.send(message);
    }
}
