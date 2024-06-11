package io.dennismasinde.services;

import io.dennismasinde.entities.Attendance;
import io.dennismasinde.repositories.AttendanceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AttendanceService {

    private final AttendanceRepository attendanceRepository;

    public List<Attendance> getAttendanceByMemberId(Long memberId) {
        return attendanceRepository.findByMemberMemberId(memberId);
    }

    public List<Attendance> getAttendanceBetweenDates(LocalDate startDate, LocalDate endDate) {
        return attendanceRepository.findAttendancesBetweenDates(startDate, endDate);
    }
}
