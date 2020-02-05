package com.epam.izh.rd.online.service;

import com.epam.izh.rd.online.exception.NotCorrectPasswordException;
import com.epam.izh.rd.online.exception.UserNotFoundException;
import com.epam.izh.rd.online.entity.User;

public interface IAuthenticationService {
    User login(User user) throws UserNotFoundException, NotCorrectPasswordException;

    void logout();
}
