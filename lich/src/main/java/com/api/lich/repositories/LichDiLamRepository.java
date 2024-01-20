package com.api.lich.repositories;

import com.api.lich.models.LichDiLam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface LichDiLamRepository extends JpaRepository<LichDiLam, UUID> {
}
