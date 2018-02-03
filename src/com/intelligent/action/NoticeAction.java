package com.intelligent.action;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.intelligent.pojo.Notice;
import com.intelligent.pojo.PageBean;
import com.intelligent.service.NoticeService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@SuppressWarnings("all")
public class NoticeAction extends ActionSupport implements ModelDriven<Notice> {
	private Notice notice = new Notice();
	private NoticeService noticeService;
	private HttpServletRequest request = ServletActionContext.getRequest();
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	private Integer currentPage;

	public Integer getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}

	public void setNoticeService(NoticeService noticeService) {
		this.noticeService = noticeService;
	}

	@Override
	public Notice getModel() {
		return notice;
	}

	public String toAddPage() {
		return "toAddPage";
	}

	public String add() {
		try {
			String ncontent = request.getParameter("ncontent");
			ncontent = new String(ncontent.getBytes("ISO-8859-1"), "utf-8");
			Date ndate = sdf.parse(sdf.format(new Date()));
			notice.setNcontent(ncontent);
			notice.setNdate(ndate);
			noticeService.add(notice);
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		return "add";
	}

	public String list() {
		try {
			List<Notice> notices = noticeService.list();
			if (notices.size() > 0) {
				request.setAttribute("notice", notices);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		return "list";
	}
	
	public String all() {
		try {
			PageBean pageBean = noticeService.all(currentPage);
			ServletActionContext.getRequest()
					.setAttribute("pageBean", pageBean);
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		return "all";
	}

	public String deleteByNid() {
		try {
			String nid = request.getParameter("nid");
			notice = noticeService.findByNid(Integer.parseInt(nid));
			if (notice != null) {
				noticeService.deleteByNid(notice);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		return "deleteByNid";
	}

	public String delete() {
		try {
			List<Notice> notices = noticeService.list();
			for (Notice notice : notices) {
				noticeService.deleteByNid(notice);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		return "delete";
	}

	public String onTime() {
		try {
			List<Notice> notices = noticeService.list();
			StringBuffer buffer = new StringBuffer();
			buffer.append("公告：");
			int i = 1;
			for (Notice notice : notices) {
				buffer.append(String.valueOf(i) + ": ");
				buffer.append(notice.getNcontent());
				buffer.append("   ");
				i++;
			}
			String ncontent = buffer.toString();
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setContentType("text/plain;charset=UTF-8");
			response.getWriter().write(ncontent);
		} catch (Exception e) {
			e.printStackTrace();
			return NONE;
		}
		return NONE;
	}

}
