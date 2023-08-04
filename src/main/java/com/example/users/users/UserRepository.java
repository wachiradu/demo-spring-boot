package com.example.users.users;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository
        extends JpaRepository<TableUser, Integer> {
    List<TableUser> findAllById(int id);
}
