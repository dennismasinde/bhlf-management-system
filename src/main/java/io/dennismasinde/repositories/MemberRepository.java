package io.dennismasinde.repositories;

import io.dennismasinde.entities.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
    // Find all members
    List<Member> findAll();

    // Search members by name
    @Query("SELECT m FROM Member m WHERE m.firstName LIKE %:name% OR m.lastName LIKE %:name%")
    List<Member> findByName(@Param("name") String name);

    // Delete members who have not attended any activities in the last year so that the member list remains current
    @Modifying
    @Query("DELETE FROM Member m WHERE m.memberId NOT IN (SELECT a.member.memberId FROM Attendance a WHERE a.dateAttended > :oneYearAgo)")
    void deleteInactiveMembers(@Param("oneYearAgo") LocalDate oneYearAgo);
}
