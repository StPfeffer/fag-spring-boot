package com.fag.domain.interfaces;

import com.fag.domain.dtos.UserDTO;

public interface INotification {

    void sendNotification(UserDTO user, String message);

}
