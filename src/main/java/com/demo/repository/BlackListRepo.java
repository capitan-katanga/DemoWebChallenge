package com.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.model.BlackList;

public interface BlackListRepo extends JpaRepository<BlackList, Integer> {

}
