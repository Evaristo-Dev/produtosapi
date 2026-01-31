package com.dev.produtosapi.repository;

import com.dev.produtosapi.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
}
