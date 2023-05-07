package com.example.team007.repo;

import com.example.team007.models.Deptor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeptorRepo extends JpaRepository<Deptor,Long> {

}
