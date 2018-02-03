package com.intelligent.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.intelligent.dao.NoticeDao;
import com.intelligent.pojo.Notice;
import com.intelligent.pojo.PageBean;

@Transactional
public class NoticeService {
	private NoticeDao noticeDao;

	public void setNoticeDao(NoticeDao noticeDao) {
		this.noticeDao = noticeDao;
	}

	public void add(Notice notice) {
		noticeDao.add(notice);
	}

	public List<Notice> list() {
		return noticeDao.list();
	}

	public Notice findByNid(int parseInt) {
		return noticeDao.findByNid(parseInt);
	}

	public void deleteByNid(Notice notice) {
		noticeDao.deleteByNid(notice);
	}

	public PageBean all(Integer currentPage) {
		PageBean pageBean = new PageBean();
		//当前页数
		pageBean.setCurrentPage(currentPage);
		//总记录数
		int totalCount = noticeDao.findCount();
		pageBean.setTotalCount(totalCount);
		//页记录数
		int pageSize = 20;
		pageBean.setPageSize(pageSize);
		//总页数
		int totalPage = 0;
		if(totalCount%pageSize==0){
			totalPage = totalCount/pageSize;
		}else{
			totalPage = totalCount/pageSize+1;
		}
		pageBean.setTotalPage(totalPage);
		//页开始记录数
		int begin = (currentPage-1)*pageSize;
		pageBean.setBegin(begin);
		List<Notice> list = noticeDao.findListPage(begin,pageSize);
		pageBean.setListNotices(list);
		return pageBean;
	}

}
