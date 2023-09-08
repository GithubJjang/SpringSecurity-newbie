package com.example.skills.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.skills.Domain.User;

public interface userRepository extends JpaRepository<User, Integer> {

	public User findByname(String name);

}
