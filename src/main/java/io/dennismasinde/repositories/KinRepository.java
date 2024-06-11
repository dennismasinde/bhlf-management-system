package io.dennismasinde.repositories;

import io.dennismasinde.entities.Kin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface KinRepository extends JpaRepository<Kin, Long> {
    // View next of kin for a member
    List<Kin> findByMemberMemberId(Long memberId);
}
