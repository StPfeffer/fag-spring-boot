package com.fag.infra.mocky.repository;

import com.fag.domain.dtos.NotificationDTO;
import com.fag.domain.dtos.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class MockyNotification {

    @Autowired
    private RestTemplate restTemplate;

    /**
     * Envia uma notificação para o usuário.
     */
    public ResponseEntity<String> sendNotification(UserDTO user, String message) {
        String email = user.getEmail();
        NotificationDTO notificationRequest = new NotificationDTO(email, message);

        return restTemplate.postForEntity("https://run.mocky.io/v3/54dc2cf1-3add-45b5-b5a9-6bf7e7f1f4a6", notificationRequest, String.class);
    }

}
