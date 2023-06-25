package com.society.application.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.society.application.model.SavingsAccountApplication;

public interface SavingsAccountApplicationRepo extends JpaRepository<SavingsAccountApplication, Integer>{

}
