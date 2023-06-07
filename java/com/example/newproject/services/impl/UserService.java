package com.example.newproject.services.impl;

import com.example.newproject.models.User;

public interface UserService {
    User create(User user);

    User update(User user);

    User delete(String username);

    void makeAdmin(long id);

    void makeBlocked(long id);

    void makeNotAdmin(long id);

    void makeUnblocked(long id);
}
