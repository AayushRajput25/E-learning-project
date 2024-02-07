package com.app.dao;


import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.Content;

import java.util.Optional;

public interface ContentDao extends JpaRepository<Content,Integer> {
    Optional<Content> findByName(String fileName);
}
