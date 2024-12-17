package org.example.daedongyeojido_be.domain.announcement.repository;

import org.example.daedongyeojido_be.domain.announcement.domain.Announcement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnnouncementRepository extends JpaRepository<AnnouncementRepository, Long> {
    List<Announcement> findAllBy();
}
