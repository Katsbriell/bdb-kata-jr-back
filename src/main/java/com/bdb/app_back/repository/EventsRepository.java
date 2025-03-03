package com.bdb.app_back.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bdb.app_back.model.EventsEntity;

@Repository
public interface EventsRepository extends JpaRepository<EventsEntity, Long> { // Para métodos CRUD

}
