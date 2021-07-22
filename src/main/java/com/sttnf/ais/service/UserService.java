package com.sttnf.ais.service;

import com.sttnf.ais.dto.UserDto;
import com.sttnf.ais.model.User;

import java.util.List;

public interface UserService {

    UserDto save(UserDto user);
    List<UserDto> findAll();
    User findOne(long id);
    void delete(long id);
}
