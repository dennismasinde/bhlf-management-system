package io.dennismasinde.repositories;

import io.dennismasinde.entities.Lead;
import io.dennismasinde.entities.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LeadRepository extends JpaRepository<Lead, Long> {

    // Convert a lead to a member
    @Modifying
    @Query("UPDATE Lead l SET l.converted = :member WHERE l.leadId = :leadId")
    void convertLeadToMember(@Param("leadId") Long leadId, @Param("member") Member member);

    // View leads assigned to a user
    List<Lead> findByUserUserId(Long userId);
}
