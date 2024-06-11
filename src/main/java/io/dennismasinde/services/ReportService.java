package io.dennismasinde.services;

import io.dennismasinde.entities.Report;
import io.dennismasinde.exceptions.EntityNotFoundException;
import io.dennismasinde.repositories.ReportRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReportService {

    private final ReportRepository reportRepository;

    public List<Report> getReportsByUserId(Long userId) {
        return reportRepository.findByUserUserId(userId);
    }

    public Report getReportById(Long reportId) {
        return reportRepository.findById(reportId).orElseThrow(() ->
                new EntityNotFoundException("Report not found with id " + reportId));
    }
}
