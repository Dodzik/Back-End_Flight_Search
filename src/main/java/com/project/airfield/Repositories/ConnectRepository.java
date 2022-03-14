package com.project.airfield.Repositories;

import com.project.airfield.Entities.Connection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ConnectRepository extends JpaRepository<Connection,Long> {

    List<Connection> findByPlace1Is(String name);

    List<Connection> findByPlace2Is(String name);

}
