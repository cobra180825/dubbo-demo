package org.cobra.service;

import org.cobra.entity.User;

import java.util.List;

public interface UserService {
    List<User> findAll();

    void deleteById(int id);

    String saySomething(String msg);
}
