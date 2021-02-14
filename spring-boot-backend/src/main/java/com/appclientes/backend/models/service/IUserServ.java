package com.appclientes.backend.models.service;

import com.appclientes.backend.models.entity.Cliente;
import com.appclientes.backend.models.entity.UserAPI;
import org.springframework.transaction.annotation.Transactional;

public interface IUserServ {

    public UserAPI save(UserAPI user);

}