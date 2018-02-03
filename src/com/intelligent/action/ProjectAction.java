package com.intelligent.action;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.intelligent.pojo.Machine;
import com.intelligent.pojo.PageBean;
import com.intelligent.pojo.Pcb;
import com.intelligent.pojo.Project;
import com.intelligent.pojo.Soft;
import com.intelligent.pojo.User;
import com.intelligent.service.MachineService;
import com.intelligent.service.PcbService;
import com.intelligent.service.ProjectService;
import com.intelligent.service.SoftService;
import com.intelligent.service.UserService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@SuppressWarnings("all")
public class ProjectAction extends ActionSupport implements
		ModelDriven<Project> {
	private Project project = new Project();
	private ProjectService projectService;
	private UserService userService;
	private PcbService pcbService;
	private MachineService machineService;
	private SoftService softService;
	private Integer currentPage;
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");// 设置日期格式

	public Integer getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public void setPcbService(PcbService pcbService) {
		this.pcbService = pcbService;
	}

	public void setMachineService(MachineService machineService) {
		this.machineService = machineService;
	}

	public void setSoftService(SoftService softService) {
		this.softService = softService;
	}

	public void setProjectService(ProjectService projectService) {
		this.projectService = projectService;
	}

	@Override
	public Project getModel() {
		return project;
	}

	public String toAddPage() {
		return "toAddPage";
	}

	public String add() {
		try {
			String pname = ServletActionContext.getRequest().getParameter(
					"pname");
			pname = new String(pname.getBytes("ISO-8859-1"), "utf-8");
			String ptime = ServletActionContext.getRequest().getParameter(
					"ptime");
			String premark = ServletActionContext.getRequest().getParameter(
					"premark");
			premark = new String(premark.getBytes("ISO-8859-1"), "utf-8");
			String pmapnumber = ServletActionContext.getRequest().getParameter(
					"pmapnumber");
			pmapnumber = new String(pmapnumber.getBytes("ISO-8859-1"), "utf-8");
			String pdutyname = ServletActionContext.getRequest().getParameter(
					"pdutyname");
			pdutyname = new String(pdutyname.getBytes("ISO-8859-1"), "utf-8");
			String pME = ServletActionContext.getRequest().getParameter("pME");
			pME = new String(pME.getBytes("ISO-8859-1"), "utf-8");
			String pEE = ServletActionContext.getRequest().getParameter("pEE");
			pEE = new String(pEE.getBytes("ISO-8859-1"), "utf-8");
			String pSW = ServletActionContext.getRequest().getParameter("pSW");
			pSW = new String(pSW.getBytes("ISO-8859-1"), "utf-8");
			String unumber = ServletActionContext.getRequest().getParameter(
					"unumber");
			unumber = new String(unumber.getBytes("ISO-8859-1"), "utf-8");
			String pstatus = ServletActionContext.getRequest().getParameter(
					"pstatus");
			pstatus = new String(pstatus.getBytes("ISO-8859-1"), "utf-8");
			String producekind = ServletActionContext.getRequest()
					.getParameter("producekind");
			producekind = new String(producekind.getBytes("ISO-8859-1"),
					"utf-8");
			String pmothercode = ServletActionContext.getRequest()
					.getParameter("pmothercode");
			pmothercode = new String(pmothercode.getBytes("ISO-8859-1"),
					"utf-8");
			String pshortname = ServletActionContext.getRequest().getParameter(
					"pshortname");
			pshortname = new String(pshortname.getBytes("ISO-8859-1"), "utf-8");
			String place = ServletActionContext.getRequest().getParameter(
					"place");
			place = new String(place.getBytes("ISO-8859-1"), "utf-8");
			String pnum = ServletActionContext.getRequest()
					.getParameter("pnum");
			pnum = new String(pnum.getBytes("ISO-8859-1"), "utf-8");
			String po = ServletActionContext.getRequest().getParameter("po");
			po = new String(po.getBytes("ISO-8859-1"), "utf-8");
			String period = ServletActionContext.getRequest().getParameter(
					"period");
			period = new String(period.getBytes("ISO-8859-1"), "utf-8");
			String pfinishtime = ServletActionContext.getRequest()
					.getParameter("pfinishtime");
			pfinishtime = new String(pfinishtime.getBytes("ISO-8859-1"),
					"utf-8");
			String papn = ServletActionContext.getRequest()
					.getParameter("papn");
			papn = new String(papn.getBytes("ISO-8859-1"), "utf-8");
			String psn = ServletActionContext.getRequest().getParameter("psn");
			psn = new String(psn.getBytes("ISO-8859-1"), "utf-8");
			String pwords = ServletActionContext.getRequest().getParameter(
					"pwords");
			pwords = new String(pwords.getBytes("ISO-8859-1"), "utf-8");
			String pcbnumber = ServletActionContext.getRequest().getParameter(
					"pcbnumber");
			pcbnumber = new String(pcbnumber.getBytes("ISO-8859-1"), "utf-8");
			String pcbname = ServletActionContext.getRequest().getParameter(
					"pcbname");
			pcbname = new String(pcbname.getBytes("ISO-8859-1"), "utf-8");
			String pcbversion = ServletActionContext.getRequest().getParameter(
					"pcbversion");
			pcbversion = new String(pcbversion.getBytes("ISO-8859-1"), "utf-8");
			String pcbremark = ServletActionContext.getRequest().getParameter(
					"pcbremark");
			pcbremark = new String(pcbremark.getBytes("ISO-8859-1"), "utf-8");
			String mnumber = ServletActionContext.getRequest().getParameter(
					"mnumber");
			mnumber = new String(mnumber.getBytes("ISO-8859-1"), "utf-8");
			String mversion = ServletActionContext.getRequest().getParameter(
					"mversion");
			mversion = new String(mversion.getBytes("ISO-8859-1"), "utf-8");
			String mremark = ServletActionContext.getRequest().getParameter(
					"mremark");
			mremark = new String(mremark.getBytes("ISO-8859-1"), "utf-8");
			String snumber = ServletActionContext.getRequest().getParameter(
					"snumber");
			snumber = new String(snumber.getBytes("ISO-8859-1"), "utf-8");
			String sversion = ServletActionContext.getRequest().getParameter(
					"sversion");
			sversion = new String(sversion.getBytes("ISO-8859-1"), "utf-8");
			String sremark = ServletActionContext.getRequest().getParameter(
					"sremark");
			sremark = new String(sremark.getBytes("ISO-8859-1"), "utf-8");
			project.setPname(pname);
			project.setPdutyname(pdutyname);
			project.setPremark(premark);
			project.setPmapnumber(pmapnumber);
			project.setpME(pME);
			project.setpEE(pEE);
			project.setpSW(pSW);
			project.setPstatus(pstatus);
			project.setProducekind(producekind);
			project.setPmothercode(pmothercode);
			project.setPeriod(period);
			project.setPapn(papn);
			if (pfinishtime.length() > 0) {
				project.setPfinishtime(sdf.parse(pfinishtime));
			}
			project.setPtime(sdf.parse(ptime));
			project.setPo(po);
			project.setPlace(place);
			project.setPshortname(pshortname);
			project.setPsn(psn);
			project.setPwords(pwords);
			project.setPnum(pnum);
			Calendar calendar = Calendar.getInstance();
			String year = String.valueOf(calendar.get(Calendar.YEAR));
			String month = "";
			year = year.substring(2);
			if (calendar.get(Calendar.MONTH) < 9) {
				month = String.valueOf(calendar.get(Calendar.MONTH) + 1);
			} else if (calendar.get(Calendar.MONTH) == 9) {
				month = "O";
			} else if (calendar.get(Calendar.MONTH) == 10) {
				month = "N";
			} else {
				month = "D";
			}
			List<Project> list = projectService.projectList();
			String count = "";
			int listSize = list.size();
			if (listSize < 10) {
				listSize += 1;
				count = "00".concat(String.valueOf(listSize));
			} else if (listSize < 100) {
				count = "0".concat(String.valueOf(listSize));
			} else {
				count = String.valueOf(listSize);
			}
			project.setPnumber("PCF2L" + year + month + count);
			User user = userService.findByUnumber(unumber);
			if (user != null) {
				project.setUser(user);
			}
			projectService.add(project);
			if (pcbnumber.length() > 0) {
				Pcb pcb = new Pcb();
				pcb.setPcbnumber(pcbnumber);
				pcb.setPcbname(pcbname);
				pcb.setPcbremark(pcbremark);
				pcb.setPcbversion(pcbversion);
				pcb.setProject(project);
				pcbService.add(pcb);
			}
			if (snumber.length() > 0) {
				Soft soft = new Soft();
				soft.setSnumber(snumber);
				soft.setSremark(sremark);
				soft.setSversion(sversion);
				soft.setProject(project);
				softService.add(soft);
			}
			if (mnumber.length() > 0) {
				Machine machine = new Machine();
				machine.setMnumber(mnumber);
				machine.setMremark(mremark);
				machine.setMversion(mversion);
				machine.setProject(project);
				machineService.add(machine);
			}
			return "add";
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}

	public String listByUnumber() {
		try {
			PageBean pageBean = projectService.list(currentPage);
			ServletActionContext.getRequest()
					.setAttribute("pageBean", pageBean);
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		return "listByUnumber";
	}

	public String viewByPnumber() {
		try {
			String pnumber = ServletActionContext.getRequest().getParameter(
					"pnumber");
			project = projectService.findByPnumber(pnumber);
			if (project != null) {
				ServletActionContext.getRequest().setAttribute("project",
						project);
				List<Pcb> pcbs = pcbService.findByPnumber(pnumber);
				List<Machine> machines = machineService.findByPnumber(pnumber);
				List<Soft> softs = softService.findByPnumber(pnumber);
				ServletActionContext.getRequest().setAttribute("pcbs", pcbs);
				ServletActionContext.getRequest().setAttribute("machines",
						machines);
				ServletActionContext.getRequest().setAttribute("softs", softs);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		return "viewByPnumber";
	}

	public String update() {
		try {
			String pstatus = ServletActionContext.getRequest().getParameter(
					"pstatus");
			pstatus = new String(pstatus.getBytes("ISO-8859-1"), "utf-8");
			String ptime = ServletActionContext.getRequest().getParameter(
					"ptime");
			String pnumber = ServletActionContext.getRequest().getParameter(
					"pnumber");
			pnumber = new String(pnumber.getBytes("ISO-8859-1"), "utf-8");
			String pname = ServletActionContext.getRequest().getParameter(
					"pname");
			pname = new String(pname.getBytes("ISO-8859-1"), "utf-8");
			String premark = ServletActionContext.getRequest().getParameter(
					"premark");
			premark = new String(premark.getBytes("ISO-8859-1"), "utf-8");
			String pmapnumber = ServletActionContext.getRequest().getParameter(
					"pmapnumber");
			pmapnumber = new String(pmapnumber.getBytes("ISO-8859-1"), "utf-8");
			String pdutyname = ServletActionContext.getRequest().getParameter(
					"pdutyname");
			pdutyname = new String(pdutyname.getBytes("ISO-8859-1"), "utf-8");
			String pME = ServletActionContext.getRequest().getParameter("pME");
			pME = new String(pME.getBytes("ISO-8859-1"), "utf-8");
			String pEE = ServletActionContext.getRequest().getParameter("pEE");
			pEE = new String(pEE.getBytes("ISO-8859-1"), "utf-8");
			String pSW = ServletActionContext.getRequest().getParameter("pSW");
			pSW = new String(pSW.getBytes("ISO-8859-1"), "utf-8");
			String unumber = ServletActionContext.getRequest().getParameter(
					"unumber");
			unumber = new String(unumber.getBytes("ISO-8859-1"), "utf-8");
			String producekind = ServletActionContext.getRequest()
					.getParameter("producekind");
			producekind = new String(producekind.getBytes("ISO-8859-1"),
					"utf-8");
			String pmothercode = ServletActionContext.getRequest()
					.getParameter("pmothercode");
			pmothercode = new String(pmothercode.getBytes("ISO-8859-1"),
					"utf-8");
			String pshortname = ServletActionContext.getRequest().getParameter(
					"pshortname");
			pshortname = new String(pshortname.getBytes("ISO-8859-1"), "utf-8");
			String place = ServletActionContext.getRequest().getParameter(
					"place");
			place = new String(place.getBytes("ISO-8859-1"), "utf-8");
			String pnum = ServletActionContext.getRequest()
					.getParameter("pnum");
			pnum = new String(pnum.getBytes("ISO-8859-1"), "utf-8");
			String po = ServletActionContext.getRequest().getParameter("po");
			po = new String(po.getBytes("ISO-8859-1"), "utf-8");
			String period = ServletActionContext.getRequest().getParameter(
					"period");
			period = new String(period.getBytes("ISO-8859-1"), "utf-8");
			String pfinishtime = ServletActionContext.getRequest()
					.getParameter("pfinishtime");
			String papn = ServletActionContext.getRequest()
					.getParameter("papn");
			papn = new String(papn.getBytes("ISO-8859-1"), "utf-8");
			String psn = ServletActionContext.getRequest().getParameter("psn");
			psn = new String(psn.getBytes("ISO-8859-1"), "utf-8");
			String pwords = ServletActionContext.getRequest().getParameter(
					"pwords");
			pwords = new String(pwords.getBytes("ISO-8859-1"), "utf-8");
			project.setPnumber(pnumber);
			project.setPstatus(pstatus);
			project.setPname(pname);
			project.setPdutyname(pdutyname);
			project.setPremark(premark);
			project.setPmapnumber(pmapnumber);
			project.setpME(pME);
			project.setpEE(pEE);
			project.setpSW(pSW);
			project.setProducekind(producekind);
			project.setPmothercode(pmothercode);
			project.setPeriod(period);
			project.setPapn(papn);
			if (pfinishtime.length() > 0) {
				project.setPfinishtime(sdf.parse(pfinishtime));
			}
			project.setPo(po);
			project.setPlace(place);
			project.setPshortname(pshortname);
			project.setPsn(psn);
			project.setPwords(pwords);
			project.setPnum(pnum);
			project.setPtime(sdf.parse(ptime));
			User user = userService.findByUnumber(unumber);
			if (user != null) {
				project.setUser(user);
			}
			projectService.update(project);
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		return "update";
	}

	public String deleteByPnumber() {
		try {
			String pnumber = ServletActionContext.getRequest().getParameter(
					"pnumber");
			project = projectService.findByPnumber(pnumber);
			if (project != null) {
				project.setUser(null);
				projectService.deleteByPnumber(project);
				List<Pcb> pcbs = pcbService.list();
				pcbService.delete(pcbs);
				List<Machine> machines = machineService.list();
				machineService.delete(machines);
				List<Soft> softs = softService.list();
				softService.delete(softs);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		return "deleteByPnumber";
	}

	public String delete() {
		try {
			List<Project> projects = projectService.projectList();
			for (Project project : projects) {
				project.setUser(null);
			}
			projectService.delete(projects);
			pcbService.delete(pcbService.list());
			softService.delete(softService.list());
			machineService.delete(machineService.list());
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		return "delete";
	}

	public String list() {
		try {
			PageBean pageBean = projectService.list(currentPage);
			ServletActionContext.getRequest()
					.setAttribute("pageBean", pageBean);
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		return "list";
	}

	public String viewByPnumberByEmployee() {
		try {
			String pnumber = ServletActionContext.getRequest().getParameter(
					"pnumber");
			project = projectService.findByPnumber(pnumber);
			if (project != null) {
				ServletActionContext.getRequest().setAttribute("project",
						project);
				List<Pcb> pcbs = pcbService.findByPnumber(pnumber);
				List<Machine> machines = machineService.findByPnumber(pnumber);
				List<Soft> softs = softService.findByPnumber(pnumber);
				ServletActionContext.getRequest().setAttribute("pcbs", pcbs);
				ServletActionContext.getRequest().setAttribute("machines",
						machines);
				ServletActionContext.getRequest().setAttribute("softs", softs);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		return "viewByPnumberByEmployee";
	}
}
