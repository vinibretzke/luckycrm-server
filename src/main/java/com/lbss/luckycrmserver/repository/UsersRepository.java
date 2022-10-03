package com.lbss.luckycrmserver.repository;

import com.lbss.luckycrmserver.model.UsersModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends CrudRepository<UsersModel, Long> {
}

