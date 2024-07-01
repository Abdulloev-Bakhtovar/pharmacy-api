package ru.bakht.report.service.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.bakht.report.service.enums.ReportType;
import ru.bakht.report.service.service.ReportRequestService;

@RestController
@RequestMapping("/report")
@RequiredArgsConstructor
public class ReportController {

    private final ReportRequestService reportRequestService;

    @PostMapping("/record")
    public void recordReportRequest(@RequestParam("reportName") ReportType reportName) {
        reportRequestService.recordReportRequest(reportName);
    }
}
