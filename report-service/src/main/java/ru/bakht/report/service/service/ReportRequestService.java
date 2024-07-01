package ru.bakht.report.service.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.bakht.report.service.enums.ReportType;
import ru.bakht.report.service.model.ReportRequest;
import ru.bakht.report.service.repository.ReportRequestRepository;

import java.time.LocalDate;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class ReportRequestService {

    private final ReportRequestRepository reportRequestRepository;

    public void recordReportRequest(ReportType reportName) {
        log.info("Запись запроса на отчет: {}", reportName);

        ReportRequest reportRequest = reportRequestRepository.findByReportName(reportName)
                .orElse(ReportRequest.builder()
                        .reportName(reportName)
                        .requestCount(0)
                        .lastRequestTime(LocalDate.now())
                        .build());

        reportRequest.setRequestCount(reportRequest.getRequestCount() + 1);
        reportRequest.setLastRequestTime(LocalDate.now());

        reportRequestRepository.save(reportRequest);

        log.info("Запрос на отчет {} успешно зарегистрирован", reportName);
    }
}
