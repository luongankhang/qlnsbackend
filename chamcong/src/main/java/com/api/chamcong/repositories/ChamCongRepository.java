package com.api.chamcong.repositories;

import com.api.chamcong.models.ChamCong;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ChamCongRepository extends JpaRepository<ChamCong, UUID> {
}
