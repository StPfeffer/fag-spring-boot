package com.fag.services;

import com.fag.domain.dtos.UserDTO;
import com.fag.domain.interfaces.INotification;
import com.fag.infra.mocky.repository.MockyNotification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class NotificationService implements INotification {

    @Autowired
    private MockyNotification notification;

    @Override
    public void sendNotification(UserDTO user, String message) {
        if (!(notification.sendNotification(user, message).getStatusCode() == HttpStatus.OK)) {
            throw new RuntimeException("Serviço de notificação está fora");
        }
    }

}
