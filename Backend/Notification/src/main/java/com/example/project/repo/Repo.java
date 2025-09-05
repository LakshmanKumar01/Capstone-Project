package com.example.project.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.project.entity.Notification;


public interface Repo extends JpaRepository<Notification, Long>{

}
