package org.example.daedongyeojido_be.domain.club.repository;

import org.example.daedongyeojido_be.domain.club.domain.Club;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface ClubRepository extends JpaRepository<Club,String> {

    Optional<Club> findByClubName(String clubName);

}
