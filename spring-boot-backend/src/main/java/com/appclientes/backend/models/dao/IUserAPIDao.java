package com.appclientes.backend.models.dao;

import com.appclientes.backend.models.entity.UserAPI;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface IUserAPIDao extends CrudRepository<UserAPI, Long> {


	 UserAPI findByUsername(String username);

}
