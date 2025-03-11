package com.der.repository;

import com.der.model.entity.PhotovoltaicPanel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhotovoltaicPanelRepository extends JpaRepository<PhotovoltaicPanel, Long> {
}
