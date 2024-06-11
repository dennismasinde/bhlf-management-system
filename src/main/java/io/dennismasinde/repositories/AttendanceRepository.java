package io.dennismasinde.repositories;

import io.dennismasinde.entities.Attendance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface AttendanceRepository extends JpaRepository<Attendance, Long> {

    // Track attendance of a member
    List<Attendance> findByMemberMemberId(Long memberId);

    // Generate attendance report
    @Query("SELECT a FROM Attendance a WHERE a.dateAttended BETWEEN :startDate AND :endDate")
    List<Attendance> findAttendancesBetweenDates(@Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate);
}
