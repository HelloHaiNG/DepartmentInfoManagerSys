package com.intelligent.service;

import org.springframework.transaction.annotation.Transactional;

import com.intelligent.dao.ReportDao;

@Transactional
public class ReportService {
	private ReportDao reportDao;
	public void setReportDao(ReportDao reportDao) {
		this.reportDao = reportDao;
	}

}
