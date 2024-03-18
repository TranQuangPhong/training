package com.jpa.repo;

import com.jpa.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepoAddress extends JpaRepository<Address, Long> {
}
