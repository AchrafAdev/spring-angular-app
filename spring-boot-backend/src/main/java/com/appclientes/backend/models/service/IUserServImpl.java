package com.appclientes.backend.models.service;

import com.appclientes.backend.models.dao.IUserAPIDao;
import com.appclientes.backend.models.entity.Cliente;
import com.appclientes.backend.models.entity.UserAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class IUserServImpl implements IUserServ{

    @Autowired
    IUserAPIDao userDao;

    @Override
    @Transactional
    public UserAPI save(UserAPI user) {

        return userDao.save(user);
    }
}
