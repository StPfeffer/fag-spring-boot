package com.fag.infra.mocky.repository;

import com.fag.domain.repositories.ITransaction;
import com.fag.infra.mocky.dto.MockyAuthorizationResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class MockyTransaction implements ITransaction {

    @Autowired
    private RestTemplate restTemplate;

    /**
     * Autoriza uma transação simulada consultando um serviço de mock.
     *
     * @return {@code true} se a transação foi autorizada, caso contrário {@code false}.
     */
    @Override
    public boolean authorizeTransaction() {
        ResponseEntity<MockyAuthorizationResponseDTO> authorizationResponse = restTemplate.getForEntity("https://run.mocky.io/v3/5794d450-d2e2-4412-8131-73d0293ac1cc", MockyAuthorizationResponseDTO.class);

        if (authorizationResponse.getStatusCode() == HttpStatus.OK) {
            if (authorizationResponse.getBody() == null) {
                return false;
            }

            String message = authorizationResponse.getBody().message();

            return "Autorizado".equalsIgnoreCase(message);
        }

        return false;
    }

}
