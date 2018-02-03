package com.intelligent.action;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.enterprise.inject.New;
import javax.servlet.http.HttpServletRequest;
import javax.swing.filechooser.FileSystemView;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.struts2.ServletActionContext;

import com.intelligent.pojo.Cost;
import com.intelligent.pojo.Device;
import com.intelligent.pojo.Employee;
import com.intelligent.pojo.EmployeeDelete;
import com.intelligent.pojo.Industry;
import com.intelligent.pojo.Machine;
import com.intelligent.pojo.Pcb;
import com.intelligent.pojo.Project;
import com.intelligent.pojo.Soft;
import com.intelligent.pojo.Support;
import com.intelligent.service.CostService;
import com.intelligent.service.DeviceService;
import com.intelligent.service.EmployeeDeleteService;
import com.intelligent.service.EmployeeService;
import com.intelligent.service.IndustryService;
import com.intelligent.service.MachineService;
import com.intelligent.service.PcbService;
import com.intelligent.service.ProjectService;
import com.intelligent.service.ReportService;
import com.intelligent.service.SoftService;
import com.intelligent.service.SupportService;
import com.intelligent.utils.Utils;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("all")
public class ReportAction extends ActionSupport {
	private ReportService reportService;
	private ProjectService projectService;
	private PcbService pcbService;
	private MachineService machineService;
	private SoftService softService;
	private EmployeeService employeeService;
	private EmployeeDeleteService employeeDeleteService;
	private IndustryService industryService;
	private CostService costService;
	private DeviceService deviceService;
	private SupportService supportService;
	private static List<Project> projects = new ArrayList<Project>();
	private static List<Pcb> pcbInfos = new ArrayList<Pcb>();
	private static List<Machine> machineInfos = new ArrayList<Machine>();
	private static List<Soft> softInfos = new ArrayList<Soft>();
	private static List<Employee> employees = new ArrayList<Employee>();
	private static List<EmployeeDelete> employeeDeletes = new ArrayList<EmployeeDelete>();
	private static List<Industry> industries = new ArrayList<Industry>();
	private static List<Cost> costs = new ArrayList<Cost>();
	private static List<Device> devices = new ArrayList<Device>();
	private static List<Support> supports = new ArrayList<Support>();
	private String formatTime = "yyyy-MM-dd HH:mm:ss";
	private String formatT = "yyyy-MM-dd";
	private URL urlfile = null;
	private HttpURLConnection httpUrl = null;
	private BufferedInputStream bis = null;
	private BufferedOutputStream bos = null;
	private HttpServletRequest request = ServletActionContext.getRequest();
	private Utils utils = new Utils();

	public void setSupportService(SupportService supportService) {
		this.supportService = supportService;
	}

	public void setDeviceService(DeviceService deviceService) {
		this.deviceService = deviceService;
	}

	public void setCostService(CostService costService) {
		this.costService = costService;
	}

	public void setIndustryService(IndustryService industryService) {
		this.industryService = industryService;
	}

	public void setEmployeeDeleteService(
			EmployeeDeleteService employeeDeleteService) {
		this.employeeDeleteService = employeeDeleteService;
	}

	public void setEmployeeService(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	public void setProjectService(ProjectService projectService) {
		this.projectService = projectService;
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

	public void setReportService(ReportService reportService) {
		this.reportService = reportService;
	}

	public String addProject() {
		try {
			String pnumber = ServletActionContext.getRequest().getParameter(
					"pnumber");
			List<String> strings = new ArrayList<String>();
			for (Project project : projects) {
				strings.add(project.getPnumber());
			}
			if (!strings.contains(pnumber)) {
				Project projectInfo = projectService.findByPnumber(pnumber);
				if (!projects.contains(projectInfo)) {
					projects.add(projectInfo);
					List<Pcb> pInfos = pcbService.findByPnumber(pnumber);
					for (Pcb pcbInfo : pInfos) {
						pcbInfos.add(pcbInfo);
					}
					List<Machine> mInfos = machineService
							.findByPnumber(pnumber);
					for (Machine machineInfo : mInfos) {
						machineInfos.add(machineInfo);
					}
					List<Soft> sInfos = softService.findByPnumber(pnumber);
					for (Soft softInfo : sInfos) {
						softInfos.add(softInfo);
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		return "addProject";
	}

	public String projectList() {
		try {
			projects = projectService.all();
			pcbInfos = pcbService.list();
			machineInfos = machineService.list();
			softInfos = softService.list();
			reportProjectExcel();
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		return "projectList";
	}

	public String removeProject() {
		try {
			String pnumber = ServletActionContext.getRequest().getParameter(
					"pnumber");
			pnumber = new String(pnumber.getBytes("ISO-8859-1"), "utf-8");
			Project projectInfo = projectService.findByPnumber(pnumber);
			projects.remove(projectInfo);
			List<Pcb> pInfos = pcbService.findByPnumber(pnumber);
			for (Pcb pcbInfo : pInfos) {
				if (pcbInfos.contains(pcbInfo)) {
					pcbInfos.remove(pcbInfo);
				}
			}
			List<Machine> mInfos = machineService.findByPnumber(pnumber);
			for (Machine machineInfo : mInfos) {
				if (machineInfos.contains(machineInfo)) {
					machineInfos.remove(machineInfo);
				}
			}
			List<Soft> sInfos = softService.findByPnumber(pnumber);
			for (Soft softInfo : sInfos) {
				if (softInfos.contains(softInfo)) {
					softInfos.remove(softInfo);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		return "removeProject";
	}

	public String reportProjectExcel() {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat(formatTime);
			SimpleDateFormat sdfT = new SimpleDateFormat(formatT);
			String date = sdf.format(new Date());
			date = date.replace(":", "-");
			File desktopDir = FileSystemView.getFileSystemView()
					.getHomeDirectory();
			String desktopPath = desktopDir.getAbsolutePath();
			File file = new File(desktopPath + "/项目报表");
			if (!file.exists() && !file.isDirectory()) {
				file.mkdir();
			}
			XSSFWorkbook xssfWorkbook;
			xssfWorkbook = new XSSFWorkbook();
			XSSFSheet sheet1 = xssfWorkbook.createSheet("项目信息");
			XSSFSheet sheet2 = xssfWorkbook.createSheet("PCB");
			XSSFSheet sheet3 = xssfWorkbook.createSheet("机械");
			XSSFSheet sheet4 = xssfWorkbook.createSheet("软件");
			XSSFRow firstSheet1Row = sheet1.createRow(0);
			XSSFRow firstSheet2Row = sheet2.createRow(0);
			XSSFRow firstSheet3Row = sheet3.createRow(0);
			XSSFRow firstSheet4Row = sheet4.createRow(0);
			XSSFRow row;
			XSSFCell cell;
			XSSFCellStyle close = xssfWorkbook.createCellStyle();
			close.setFillForegroundColor(IndexedColors.GREEN.getIndex());
			close.setFillPattern(CellStyle.SOLID_FOREGROUND);
			XSSFCellStyle ongoing = xssfWorkbook.createCellStyle();
			ongoing.setFillForegroundColor(IndexedColors.YELLOW.getIndex());
			ongoing.setFillPattern(CellStyle.SOLID_FOREGROUND);
			List<String> strings = new ArrayList<String>();
			List<String> stringsPCB = new ArrayList<String>();
			List<String> stringsMachine = new ArrayList<String>();
			List<String> stringsSoft = new ArrayList<String>();
			strings.add("日期");
			strings.add("项目编号");
			strings.add("项目名称");
			strings.add("图纸号");
			strings.add("负责人");
			strings.add("ME");
			strings.add("EE");
			strings.add("SW");
			strings.add("状态");
			strings.add("录入人工号");
			strings.add("备注");
			strings.add("产品类别");
			strings.add("成品编码");
			strings.add("项目内部简称");
			strings.add("出货地点");
			strings.add("出货时间");
			strings.add("数量");
			strings.add("PO#");
			strings.add("阶段");
			strings.add("APN");
			strings.add("出货SN");
			strings.add("铭牌刻字");
			stringsPCB.add("PCB料号");
			stringsPCB.add("PCB名称");
			stringsPCB.add("PCB版本");
			stringsPCB.add("项目编号");
			stringsPCB.add("项目名称");
			stringsPCB.add("PCB备注");
			stringsMachine.add("机械编号");
			stringsMachine.add("机械版本");
			stringsMachine.add("项目编号");
			stringsMachine.add("项目名称");
			stringsMachine.add("机械备注");
			stringsSoft.add("软件编号");
			stringsSoft.add("软件版本");
			stringsSoft.add("项目编号");
			stringsSoft.add("项目名称");
			stringsSoft.add("软件备注");
			for (int i = 0; i < strings.size(); i++) {
				cell = firstSheet1Row.createCell(i);
				cell.setCellValue(strings.get(i));
			}
			for (int i = 0; i < stringsPCB.size(); i++) {
				cell = firstSheet2Row.createCell(i);
				cell.setCellValue(stringsPCB.get(i));
			}
			for (int i = 0; i < stringsMachine.size(); i++) {
				cell = firstSheet3Row.createCell(i);
				cell.setCellValue(stringsMachine.get(i));
			}
			for (int i = 0; i < stringsSoft.size(); i++) {
				cell = firstSheet4Row.createCell(i);
				cell.setCellValue(stringsSoft.get(i));
			}
			if (projects != null) {
				List<Project> newList = new ArrayList<Project>();
				Set<Project> set = new HashSet<Project>();
				for (Project cd : projects) {
					if (!newList.contains(cd)) {
						newList.add(cd);
					}
				}
				for (int i = 0; i < newList.size(); i++) {
					row = sheet1.createRow(i + 1);
					for (int j = 0; j < strings.size(); j++) {
						cell = row.createCell(j);
						if (j == 0) {
							cell.setCellValue(sdf.format(newList.get(i)
									.getPtime()));
						} else if (j == 1) {
							cell.setCellValue(newList.get(i).getPnumber());
						} else if (j == 2) {
							cell.setCellValue(newList.get(i).getPname());
						} else if (j == 3) {
							cell.setCellValue(newList.get(i).getPmapnumber());
						} else if (j == 4) {
							cell.setCellValue(newList.get(i).getPdutyname());
						} else if (j == 5) {
							cell.setCellValue(newList.get(i).getpME());
						} else if (j == 6) {
							cell.setCellValue(newList.get(i).getpEE());
						} else if (j == 7) {
							cell.setCellValue(newList.get(i).getpSW());
						} else if (j == 8) {
							cell.setCellValue(newList.get(i).getPstatus());
							if (newList.get(i).getPstatus().contains("close")) {
								cell.setCellStyle(close);
							} else {
								cell.setCellStyle(ongoing);
							}
						} else if (j == 9) {
							cell.setCellValue(newList.get(i).getUser()
									.getUnumber());
						} else if (j == 10) {
							cell.setCellValue(newList.get(i).getPremark());
						} else if (j == 11) {
							cell.setCellValue(newList.get(i).getProducekind());
						} else if (j == 12) {
							cell.setCellValue(newList.get(i).getPmothercode());
						} else if (j == 13) {
							cell.setCellValue(newList.get(i).getPshortname());
						} else if (j == 14) {
							cell.setCellValue(newList.get(i).getPlace());
						} else if (j == 15) {
							if (newList.get(i).getPfinishtime() != null) {
								cell.setCellValue(sdfT.format(newList.get(i)
										.getPfinishtime()));
							}
						} else if (j == 16) {
							cell.setCellValue(newList.get(i).getPnum());
						} else if (j == 17) {
							cell.setCellValue(newList.get(i).getPo());
						} else if (j == 18) {
							cell.setCellValue(newList.get(i).getPeriod());
						} else if (j == 19) {
							cell.setCellValue(newList.get(i).getPapn());
						} else if (j == 20) {
							cell.setCellValue(newList.get(i).getPsn());
						} else {
							cell.setCellValue(newList.get(i).getPwords());
						}
					}
				}
				newList.clear();
				projects.clear();
			}
			if (pcbInfos != null) {
				List<Pcb> newList = new ArrayList<Pcb>();
				Set<Pcb> set = new HashSet<Pcb>();
				for (Pcb cd : pcbInfos) {
					if (set.add(cd)) {
						newList.add(cd);
					}
				}
				for (int i = 0; i < newList.size(); i++) {
					row = sheet2.createRow(i + 1);
					for (int j = 0; j < stringsPCB.size(); j++) {
						cell = row.createCell(j);
						if (j == 0) {
							cell.setCellValue(newList.get(i).getPcbnumber());
						} else if (j == 1) {
							cell.setCellValue(newList.get(i).getPcbname());
						} else if (j == 2) {
							cell.setCellValue(newList.get(i).getPcbversion());
						} else if (j == 3) {
							cell.setCellValue(newList.get(i).getProject()
									.getPnumber());
						} else if (j == 4) {
							cell.setCellValue(newList.get(i).getProject()
									.getPname());
						} else {
							cell.setCellValue(newList.get(i).getPcbremark());
						}
					}
				}
				newList.clear();
				pcbInfos.clear();
			}
			if (machineInfos != null) {
				List<Machine> newList = new ArrayList<Machine>();
				Set<Machine> set = new HashSet<Machine>();
				for (Machine cd : machineInfos) {
					if (set.add(cd)) {
						newList.add(cd);
					}
				}
				for (int i = 0; i < newList.size(); i++) {
					row = sheet3.createRow(i + 1);
					for (int j = 0; j < stringsMachine.size(); j++) {
						cell = row.createCell(j);
						if (j == 0) {
							cell.setCellValue(newList.get(i).getMnumber());
						} else if (j == 1) {
							cell.setCellValue(newList.get(i).getMversion());
						} else if (j == 2) {
							cell.setCellValue(newList.get(i).getProject()
									.getPnumber());
						} else if (j == 3) {
							cell.setCellValue(newList.get(i).getProject()
									.getPname());
						} else {
							cell.setCellValue(newList.get(i).getMremark());
						}
					}
				}
				newList.clear();
				machineInfos.clear();
			}
			if (softInfos != null) {
				List<Soft> newList = new ArrayList<Soft>();
				Set<Soft> set = new HashSet<Soft>();
				for (Soft cd : softInfos) {
					if (set.add(cd)) {
						newList.add(cd);
					}
				}
				for (int i = 0; i < newList.size(); i++) {
					row = sheet4.createRow(i + 1);
					for (int j = 0; j < stringsSoft.size(); j++) {
						cell = row.createCell(j);
						if (j == 0) {
							cell.setCellValue(newList.get(i).getSnumber());
						} else if (j == 1) {
							cell.setCellValue(newList.get(i).getSversion());
						} else if (j == 2) {
							cell.setCellValue(newList.get(i).getProject()
									.getPnumber());
						} else if (j == 3) {
							cell.setCellValue(newList.get(i).getProject()
									.getPname());
						} else {
							cell.setCellValue(newList.get(i).getSremark());
						}
					}
				}
				newList.clear();
				softInfos.clear();
			}
			for (int i = 0; i < xssfWorkbook.getNumberOfSheets(); i++) {
				XSSFSheet sheet = xssfWorkbook.getSheetAt(i);
				for (int j = 0; j < sheet.getPhysicalNumberOfRows(); j++) {
					row = sheet.getRow(j);
					if (row != null) {
						int columnNumbers = row.getPhysicalNumberOfCells();
						for (int k = 0; k < columnNumbers; k++) {
							if ((cell = row.getCell(k)) != null) {
								sheet.autoSizeColumn((short) k);
							}
						}
					}
				}
			}
			FileOutputStream fos = new FileOutputStream(new File(
					file.getAbsoluteFile() + "/项目信息" + date + ".xlsx"));
			xssfWorkbook.write(fos);
			fos.close();
			utils.download(new File(file.getAbsoluteFile() + "/项目信息" + date
					+ ".xlsx"));
			new File(file.getAbsoluteFile() + "/项目信息" + date + ".xlsx")
					.delete();
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		return "reportProjectExcel";
	}

	public String addEmployee() {
		try {
			String enumber = ServletActionContext.getRequest().getParameter(
					"enumber");
			List<String> strings = new ArrayList<String>();
			for (Employee employee : employees) {
				strings.add(employee.getEnumber());
			}
			if (!strings.contains(enumber)) {
				employees.add(employeeService.findByEnumber(enumber));
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		return "addEmployee";
	}

	public String removeEmployee() {
		try {
			String enumber = ServletActionContext.getRequest().getParameter(
					"enumber");
			Employee employee = employeeService.findByEnumber(enumber);
			if (employees.contains(employee)) {
				employees.remove(employee);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		return "removeEmployee";
	}

	public String reportEmployeeExcel() {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat(formatTime);
			SimpleDateFormat sdfT = new SimpleDateFormat(formatT);
			String date = sdf.format(new Date());
			date = date.replace(":", "-");
			File desktopDir = FileSystemView.getFileSystemView()
					.getHomeDirectory();
			String desktopPath = desktopDir.getAbsolutePath();
			File file = new File(desktopPath + "/项目报表");
			if (!file.exists() && !file.isDirectory()) {
				file.mkdir();
			}
			XSSFWorkbook xssfWorkbook;
			xssfWorkbook = new XSSFWorkbook();
			XSSFSheet sheet = xssfWorkbook.createSheet("通讯录");
			List<String> strings = new ArrayList<String>();
			strings.add("工号");
			strings.add("姓名");
			strings.add("性别");
			strings.add("电话1");
			strings.add("电话2");
			strings.add("职位");
			strings.add("组别");
			strings.add("管培生");
			strings.add("工作地点");
			strings.add("邮箱");
			strings.add("备注");
			strings.add("入职日期");
			strings.add("院校");
			strings.add("学历");
			strings.add("身份证");
			XSSFRow row = sheet.createRow(0);
			XSSFCell cell;
			for (int i = 0; i < strings.size(); i++) {
				cell = row.createCell(i);
				cell.setCellValue(strings.get(i));
			}
			if (employees != null) {
				List<Employee> newList = new ArrayList<Employee>();
				Set<Employee> set = new HashSet<Employee>();
				for (Employee cd : employees) {
					if (set.add(cd)) {
						newList.add(cd);
					}
				}
				for (int i = 0; i < newList.size(); i++) {
					row = sheet.createRow(i + 1);
					for (int j = 0; j < strings.size(); j++) {
						cell = row.createCell(j);
						if (j == 0) {
							cell.setCellValue(newList.get(i).getEnumber());
						} else if (j == 1) {
							cell.setCellValue(newList.get(i).getEname());
						} else if (j == 2) {
							cell.setCellValue(newList.get(i).getEsex());
						} else if (j == 3) {
							cell.setCellValue(newList.get(i).getEphone1());
						} else if (j == 4) {
							cell.setCellValue(newList.get(i).getEphone2());
						} else if (j == 5) {
							cell.setCellValue(newList.get(i).getEposition());
						} else if (j == 6) {
							cell.setCellValue(newList.get(i).getGroup()
									.getGname());
						} else if (j == 7) {
							cell.setCellValue(newList.get(i).getEmana());
						} else if (j == 8) {
							cell.setCellValue(newList.get(i).getEworkplace());
						} else if (j == 9) {
							cell.setCellValue(newList.get(i).getEmail());
						} else if (j == 10){
							cell.setCellValue(newList.get(i).getEremark());
						} else if (j == 11){
							cell.setCellValue(sdfT.format(newList.get(i).getEdate()));
						} else if (j == 12){
							cell.setCellValue(newList.get(i).getEschool());
						} else if (j == 13){
							cell.setCellValue(newList.get(i).getEduc());
						} else{
							cell.setCellValue(newList.get(i).getEids());
						}
					}
				}
				for (int i = 0; i < sheet.getPhysicalNumberOfRows(); i++) {
					row = sheet.getRow(i);
					if (row != null) {
						int columnNumbers = row.getPhysicalNumberOfCells();
						for (int j = 0; j < columnNumbers; j++) {
							sheet.autoSizeColumn((short) j);
						}
					}
				}
				newList.clear();
				employees.clear();
				FileOutputStream fos = new FileOutputStream(new File(
						file.getAbsolutePath() + "/在职通讯录" + date + ".xlsx"));
				xssfWorkbook.write(fos);
				fos.close();
				utils.download(new File(file.getAbsoluteFile() + "/在职通讯录"
						+ date + ".xlsx"));
				new File(file.getAbsoluteFile() + "/在职通讯录" + date + ".xlsx")
						.delete();
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		return "reportEmployeeExcel";
	}

	public String employeeList() {
		try {
			employees = employeeService.all();
			reportEmployeeExcel();
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		return "employeeList";
	}

	public String addEmployeeDelete() {
		try {
			String ednumber = ServletActionContext.getRequest().getParameter(
					"ednumber");
			List<String> strings = new ArrayList<String>();
			for (EmployeeDelete employeeDelete : employeeDeletes) {
				strings.add(employeeDelete.getEdnumber());
			}
			if (!strings.contains(ednumber)) {
				employeeDeletes.add(employeeDeleteService
						.findByEdnumber(ednumber));
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		return "addEmployeeDelete";
	}

	public String removeEmployeeDelete() {
		try {
			String ednumber = ServletActionContext.getRequest().getParameter(
					"ednumber");
			EmployeeDelete employeeDelete = employeeDeleteService
					.findByEdnumber(ednumber);
			if (employeeDeletes.contains(employeeDelete)) {
				employeeDeletes.remove(employeeDelete);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		return "removeEmployeeDelete";
	}

	public String reportEmployeeDeleteExcel() {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat(formatTime);
			SimpleDateFormat sdfT = new SimpleDateFormat(formatT);		
			String date = sdf.format(new Date());
			date = date.replace(":", "-");
			File desktopDir = FileSystemView.getFileSystemView()
					.getHomeDirectory();
			String desktopPath = desktopDir.getAbsolutePath();
			File file = new File(desktopPath + "/项目报表");
			if (!file.exists() && !file.isDirectory()) {
				file.mkdir();
			}
			XSSFWorkbook xssfWorkbook;
			xssfWorkbook = new XSSFWorkbook();
			XSSFSheet sheet = xssfWorkbook.createSheet("已删除通讯录");
			List<String> strings = new ArrayList<String>();
			strings.add("工号");
			strings.add("姓名");
			strings.add("性别");
			strings.add("电话1");
			strings.add("电话2");
			strings.add("职位");
			strings.add("组别");
			strings.add("部门");
			strings.add("工作地点");
			strings.add("邮箱");
			strings.add("备注");
			strings.add("入职日期");
			strings.add("院校");
			strings.add("学历");
			strings.add("身份证");
			XSSFRow row = sheet.createRow(0);
			XSSFCell cell;
			for (int i = 0; i < strings.size(); i++) {
				cell = row.createCell(i);
				cell.setCellValue(strings.get(i));
			}
			if (employeeDeletes != null) {
				List<EmployeeDelete> newList = new ArrayList<EmployeeDelete>();
				Set<EmployeeDelete> set = new HashSet<EmployeeDelete>();
				for (EmployeeDelete cd : employeeDeletes) {
					if (set.add(cd)) {
						newList.add(cd);
					}
				}
				for (int i = 0; i < newList.size(); i++) {
					row = sheet.createRow(i + 1);
					for (int j = 0; j < strings.size(); j++) {
						cell = row.createCell(j);
						if (j == 0) {
							cell.setCellValue(newList.get(i).getEdnumber());
						} else if (j == 1) {
							cell.setCellValue(newList.get(i).getEdname());
						} else if (j == 2) {
							cell.setCellValue(newList.get(i).getEdsex());
						} else if (j == 3) {
							cell.setCellValue(newList.get(i).getEdphone1());
						} else if (j == 4) {
							cell.setCellValue(newList.get(i).getEdphone2());
						} else if (j == 5) {
							cell.setCellValue(newList.get(i).getEdposition());
						} else if (j == 6) {
							cell.setCellValue(newList.get(i).getGroup()
									.getGname());
						} else if (j == 7) {
							cell.setCellValue(newList.get(i).getEdmana());
						} else if (j == 8) {
							cell.setCellValue(newList.get(i).getEdworkplace());
						} else if (j == 9) {
							cell.setCellValue(newList.get(i).getEdmail());
						} else if (j == 10){
							cell.setCellValue(newList.get(i).getEdremark());
						} else if (j == 11){
							cell.setCellValue(sdfT.format(newList.get(i).getEddate()));
						} else if (j == 12){
							cell.setCellValue(newList.get(i).getEdschool());
						} else if (j == 13){
							cell.setCellValue(newList.get(i).getEdduc());
						} else{
							cell.setCellValue(newList.get(i).getEdids());
						}
					}
				}
				for (int i = 0; i < sheet.getPhysicalNumberOfRows(); i++) {
					row = sheet.getRow(i);
					if (row != null) {
						int columnNumbers = row.getPhysicalNumberOfCells();
						for (int j = 0; j < columnNumbers; j++) {
							sheet.autoSizeColumn((short) j);
						}
					}
				}
				newList.clear();
				employeeDeletes.clear();
				FileOutputStream fos = new FileOutputStream(new File(
						file.getAbsolutePath() + "/已删除通讯录" + date + ".xlsx"));
				xssfWorkbook.write(fos);
				fos.close();
				utils.download(new File(file.getAbsoluteFile() + "/已删除通讯录"
						+ date + ".xlsx"));
				new File(file.getAbsoluteFile() + "/已删除通讯录" + date + ".xlsx")
						.delete();
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		return "reportEmployeeDeleteExcel";
	}

	public String employeeDeleteList() {
		try {
			employeeDeletes = employeeDeleteService.all();
			reportEmployeeDeleteExcel();
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		return "employeeDeleteList";
	}

	public String addIndustry() {
		try {
			HttpServletRequest request = ServletActionContext.getRequest();
			String id = request.getParameter("id");
			List<String> strings = new ArrayList<String>();
			for (Industry industry : industries) {
				strings.add(String.valueOf(industry.getId()));
			}
			if (!strings.contains(id)) {
				Industry industry = industryService.findById(Integer
						.parseInt(id));
				if (industry != null) {
					industries.add(industry);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		return "addIndustry";
	}

	public String removeIndustry() {
		try {
			HttpServletRequest request = ServletActionContext.getRequest();
			String id = request.getParameter("id");
			Industry industry = industryService.findById(Integer.parseInt(id));
			if (industry != null && industries.contains(industry)) {
				industries.remove(industry);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		return "removeIndustry";
	}

	public String reportIndustryExcel() {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat(formatTime);
			SimpleDateFormat sdfT = new SimpleDateFormat(formatT);
			String date = sdf.format(new Date());
			date = date.replace(":", "-");
			File desktopDir = FileSystemView.getFileSystemView()
					.getHomeDirectory();
			String desktopPath = desktopDir.getAbsolutePath();
			File file = new File(desktopPath + "/项目报表");
			if (!file.exists() && !file.isDirectory()) {
				file.mkdir();
			}
			XSSFWorkbook xssfWorkbook;
			xssfWorkbook = new XSSFWorkbook();
			XSSFSheet sheet = xssfWorkbook.createSheet("工业信息");
			List<String> strings = new ArrayList<String>();
			strings.add("发起时间");
			strings.add("完成时间");
			strings.add("需求部门");
			strings.add("需求人");
			strings.add("项目编码");
			strings.add("项目名称");
			strings.add("PI设计特殊要求");
			strings.add("设计人员");
			strings.add("设计类别");
			strings.add("支援工时");
			strings.add("测量权分");
			strings.add("状态");
			strings.add("备注");
			XSSFRow row = sheet.createRow(0);
			XSSFCell cell;
			for (int i = 0; i < strings.size(); i++) {
				cell = row.createCell(i);
				cell.setCellValue(strings.get(i));
			}
			if (industries != null) {
				List<Industry> newList = new ArrayList<Industry>();
				Set<Industry> set = new HashSet<Industry>();
				for (Industry cd : industries) {
					if (set.add(cd)) {
						newList.add(cd);
					}
				}
				XSSFCellStyle close = xssfWorkbook.createCellStyle();
				close.setFillForegroundColor(IndexedColors.GREEN.getIndex());
				close.setFillPattern(CellStyle.SOLID_FOREGROUND);
				XSSFCellStyle ongoing = xssfWorkbook.createCellStyle();
				ongoing.setFillForegroundColor(IndexedColors.YELLOW.getIndex());
				ongoing.setFillPattern(CellStyle.SOLID_FOREGROUND);
				for (int i = 0; i < newList.size(); i++) {
					row = sheet.createRow(i + 1);
					for (int j = 0; j < strings.size(); j++) {
						cell = row.createCell(j);
						if (j == 0) {
							cell.setCellValue(newList.get(i).getIstime());
						} else if (j == 1) {
							if (newList.get(i).getIetime() != null) {
								cell.setCellValue(sdfT.format(newList.get(i)
										.getIetime()));
							}
						} else if (j == 2) {
							cell.setCellValue(newList.get(i).getIdname());
						} else if (j == 3) {
							cell.setCellValue(newList.get(i).getIreqname());
						} else if (j == 4) {
							cell.setCellValue(newList.get(i).getIpnumber());
						} else if (j == 5) {
							cell.setCellValue(newList.get(i).getIpname());
						} else if (j == 6) {
							cell.setCellValue(newList.get(i).getIask());
						} else if (j == 7) {
							cell.setCellValue(newList.get(i).getIresname());
						} else if (j == 8) {
							cell.setCellValue(newList.get(i).getIkind());
						} else if (j == 9) {
							cell.setCellValue(newList.get(i).getItime());
						} else if (j == 10) {
							cell.setCellValue(newList.get(i).getImark());
						} else if (j == 11) {
							cell.setCellValue(newList.get(i).getIstatus());
							if (newList.get(i).getIstatus().equals("closed")) {
								cell.setCellStyle(close);
							} else {
								cell.setCellStyle(ongoing);
							}
						} else {
							cell.setCellValue(newList.get(i).getIremark());
						}
					}
				}
				for (int i = 0; i < sheet.getPhysicalNumberOfRows(); i++) {
					row = sheet.getRow(i);
					if (row != null) {
						int columnNumbers = row.getPhysicalNumberOfCells();
						for (int j = 0; j < columnNumbers; j++) {
							sheet.autoSizeColumn((short) j);
						}
					}
				}
				newList.clear();
				industries.clear();
				FileOutputStream fos = new FileOutputStream(new File(
						file.getAbsolutePath() + "/工业设计" + date + ".xlsx"));
				xssfWorkbook.write(fos);
				fos.close();
				utils.download(new File(file.getAbsoluteFile() + "/工业设计" + date
						+ ".xlsx"));
				new File(file.getAbsoluteFile() + "/工业设计" + date + ".xlsx")
						.delete();
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		return "reportIndustryExcel";
	}

	public String listExcel() {
		try {
			industries = industryService.all();
			if (industries.size() > 0) {
				reportIndustryExcel();
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		return "listExcel";
	}

	public String addCost() {
		try {
			HttpServletRequest request = ServletActionContext.getRequest();
			String cid = request.getParameter("cid");
			List<String> strings = new ArrayList<String>();
			for (Cost cost : costs) {
				strings.add(String.valueOf(cost.getCid()));
			}
			if (!strings.contains(cid)) {
				Cost cost = costService.findByCid(Integer.parseInt(cid));
				if (cost != null) {
					costs.add(cost);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		return "addCost";
	}

	public String removeCost() {
		try {
			HttpServletRequest request = ServletActionContext.getRequest();
			String cid = request.getParameter("cid");
			Cost cost = costService.findByCid(Integer.parseInt(cid));
			if (cost != null && costs.contains(cost)) {
				costs.add(cost);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		return "removeCost";
	}

	public String reportCostExcel() {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat(formatTime);
			SimpleDateFormat sdfT = new SimpleDateFormat(formatT);
			String date = sdf.format(new Date());
			date = date.replace(":", "-");
			File desktopDir = FileSystemView.getFileSystemView()
					.getHomeDirectory();
			String desktopPath = desktopDir.getAbsolutePath();
			File file = new File(desktopPath + "/项目报表");
			if (!file.exists() && !file.isDirectory()) {
				file.mkdir();
			}
			XSSFWorkbook xssfWorkbook;
			xssfWorkbook = new XSSFWorkbook();
			XSSFSheet sheet = xssfWorkbook.createSheet("费用信息");
			List<String> strings = new ArrayList<String>();
			strings.add("报销日期");
			strings.add("谁给的");
			strings.add("月份");
			strings.add("报销人");
			strings.add("报销单位");
			strings.add("项目编号");
			strings.add("银行卡号");
			strings.add("餐费");
			strings.add("过节费");
			strings.add("厂房租金");
			strings.add("水电费");
			strings.add("外租宿舍费");
			strings.add("招聘费");
			strings.add("培训费");
			strings.add("人事维修费");
			strings.add("报关费");
			strings.add("运输费");
			strings.add("采购费");
			strings.add("打印机");
			strings.add("租赁电脑");
			strings.add("通信费");
			strings.add("办公维修费");
			strings.add("团建费");
			strings.add("业务招待费");
			strings.add("咨询顾问费");
			strings.add("材料费");
			strings.add("签证费");
			strings.add("机票费");
			strings.add("请车费");
			strings.add("油费");
			strings.add("过路费");
			strings.add("停车洗车费");
			strings.add("交通费");
			strings.add("出差补助费");
			strings.add("住宿费");
			strings.add("其他费用");
			strings.add("合计");
			strings.add("开始时间");
			strings.add("结束时间");
			strings.add("报销事由");
			strings.add("备注");
			XSSFRow row = sheet.createRow(0);
			XSSFCell cell;
			for (int i = 0; i < strings.size(); i++) {
				cell = row.createCell(i);
				cell.setCellValue(strings.get(i));
			}
			if (costs != null) {
				List<Cost> newList = new ArrayList<Cost>();
				Set<Cost> set = new HashSet<Cost>();
				for (Cost cd : costs) {
					if (set.add(cd)) {
						newList.add(cd);
					}
				}
				for (int i = 0; i < newList.size(); i++) {
					row = sheet.createRow(i + 1);
					for (int j = 0; j < strings.size(); j++) {
						cell = row.createCell(j);
						if (j == 0) {
							cell.setCellValue(newList.get(i).getCtime());
						} else if (j == 1) {
							cell.setCellValue(newList.get(i).getCgive());
						} else if (j == 2) {
							cell.setCellValue(newList.get(i).getCmonth());
						} else if (j == 3) {
							cell.setCellValue(newList.get(i).getCname());
						} else if (j == 4) {
							cell.setCellValue(newList.get(i).getCdname());
						} else if (j == 5) {
							cell.setCellValue(newList.get(i).getCpnumber());
						} else if (j == 6) {
							cell.setCellValue(newList.get(i).getCbank());
						} else if (j == 7) {
							cell.setCellValue(newList.get(i).getCfood());
						} else if (j == 8) {
							cell.setCellValue(newList.get(i).getCfes());
						} else if (j == 9) {
							cell.setCellValue(newList.get(i).getChouse());
						} else if (j == 10) {
							cell.setCellValue(newList.get(i).getCwaelc());
						} else if (j == 11) {
							cell.setCellValue(newList.get(i).getCdorm());
						} else if (j == 12) {
							cell.setCellValue(newList.get(i).getCrecruit());
						} else if (j == 13) {
							cell.setCellValue(newList.get(i).getCtrain());
						} else if (j == 14) {
							cell.setCellValue(newList.get(i).getCrepair1());
						} else if (j == 15) {
							cell.setCellValue(newList.get(i).getCdec());
						} else if (j == 16) {
							cell.setCellValue(newList.get(i).getCtravel());
						} else if (j == 17) {
							cell.setCellValue(newList.get(i).getCbuy());
						} else if (j == 18) {
							cell.setCellValue(newList.get(i).getCprint());
						} else if (j == 19) {
							cell.setCellValue(newList.get(i).getCrent());
						} else if (j == 20) {
							cell.setCellValue(newList.get(i).getCommunic());
						} else if (j == 21) {
							cell.setCellValue(newList.get(i).getCrepair2());
						} else if (j == 22) {
							cell.setCellValue(newList.get(i).getCbuild());
						} else if (j == 23) {
							cell.setCellValue(newList.get(i).getCserve());
						} else if (j == 24) {
							cell.setCellValue(newList.get(i).getCseek());
						} else if (j == 25) {
							cell.setCellValue(newList.get(i).getCstuff());
						} else if (j == 26) {
							cell.setCellValue(newList.get(i).getCvise());
						} else if (j == 27) {
							cell.setCellValue(newList.get(i).getCair());
						} else if (j == 28) {
							cell.setCellValue(newList.get(i).getCpcar());
						} else if (j == 29) {
							cell.setCellValue(newList.get(i).getCoil());
						} else if (j == 30) {
							cell.setCellValue(newList.get(i).getCroad());
						} else if (j == 31) {
							cell.setCellValue(newList.get(i).getCstwacar());
						} else if (j == 32) {
							cell.setCellValue(newList.get(i).getCtraffic());
						} else if (j == 33) {
							cell.setCellValue(newList.get(i).getCoutwork());
						} else if (j == 34) {
							cell.setCellValue(newList.get(i).getCstay());
						} else if (j == 35) {
							cell.setCellValue(newList.get(i).getCothers());
						} else if (j == 36) {
							cell.setCellValue(newList.get(i).getCtotal());
						} else if (j == 37) {
							if (newList.get(i).getCstime() != null) {
								cell.setCellValue(sdfT.format(newList.get(i)
										.getCstime()));
							}
						} else if (j == 38) {
							if (newList.get(i).getCetime() != null) {
								cell.setCellValue(sdfT.format(newList.get(i)
										.getCetime()));
							}
						} else if (j == 39) {
							cell.setCellValue(newList.get(i).getCreason());
						} else {
							cell.setCellValue(newList.get(i).getCremark());
						}
					}
				}
				for (int i = 0; i < sheet.getPhysicalNumberOfRows(); i++) {
					row = sheet.getRow(i);
					if (row != null) {
						int columnNumbers = row.getPhysicalNumberOfCells();
						for (int j = 0; j < columnNumbers; j++) {
							sheet.autoSizeColumn((short) j);
						}
					}
				}
				newList.clear();
				costs.clear();
				FileOutputStream fos = new FileOutputStream(new File(
						file.getAbsolutePath() + "/费用明细" + date + ".xlsx"));
				xssfWorkbook.write(fos);
				fos.close();
				utils.download(new File(file.getAbsoluteFile() + "/费用明细" + date
						+ ".xlsx"));
				new File(file.getAbsolutePath() + "/费用明细" + date + ".xlsx")
						.delete();
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		return "reportCostExcel";
	}

	public String listCostExcel() {
		try {
			costs = costService.all();
			if (costs.size() > 0) {
				reportCostExcel();
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		return "listCostExcel";
	}

	public String addDevice() {
		try {
			HttpServletRequest request = ServletActionContext.getRequest();
			String did = request.getParameter("did");
			List<String> strings = new ArrayList<String>();
			for (Device device : devices) {
				strings.add(String.valueOf(device.getDid()));
			}
			if (!strings.contains(did)) {
				Device device = deviceService.findByDid(Integer.parseInt(did));
				if (device != null) {
					devices.add(device);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		return "addDevice";
	}

	public String removeDevice() {
		try {
			HttpServletRequest request = ServletActionContext.getRequest();
			int did = Integer.parseInt((request.getParameter("did")));
			Device device = deviceService.findByDid(did);
			if (device != null && devices.contains(device)) {
				devices.remove(device);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		return "removeDevice";
	}

	public String reportDeviceExcel() {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat(formatTime);
			SimpleDateFormat sdfT = new SimpleDateFormat(formatT);
			String date = sdf.format(new Date());
			date = date.replace(":", "-");
			File desktopDir = FileSystemView.getFileSystemView()
					.getHomeDirectory();
			String desktopPath = desktopDir.getAbsolutePath();
			File file = new File(desktopPath + "/项目报表");
			if (!file.exists() && !file.isDirectory()) {
				file.mkdir();
			}
			XSSFWorkbook xssfWorkbook;
			xssfWorkbook = new XSSFWorkbook();
			XSSFSheet sheet = xssfWorkbook.createSheet("设备");
			XSSFCellStyle color = xssfWorkbook.createCellStyle();
			color.setFillForegroundColor(IndexedColors.RED.getIndex());
			color.setFillPattern(CellStyle.SOLID_FOREGROUND);
			List<String> strings = new ArrayList<String>();
			strings.add("财务编号");
			strings.add("实验室编号");
			strings.add("资产名称");
			strings.add("资产品牌");
			strings.add("规格型号");
			strings.add("购进时间");
			strings.add("存放位置");
			strings.add("使用者");
			strings.add("资产状态");
			strings.add("条形编码");
			strings.add("借用时间");
			strings.add("归还时间");
			strings.add("借用部门");
			strings.add("借用人");
			strings.add("备注");
			strings.add("旧编号");
			XSSFRow row = sheet.createRow(0);
			XSSFCell cell;
			for (int i = 0; i < strings.size(); i++) {
				cell = row.createCell(i);
				cell.setCellValue(strings.get(i));
			}
			if (devices != null) {
				List<Device> newList = new ArrayList<Device>();
				Set<Device> set = new HashSet<Device>();
				for (Device cd : devices) {
					if (set.add(cd)) {
						newList.add(cd);
					}
				}
				for (int i = 0; i < newList.size(); i++) {
					row = sheet.createRow(i + 1);
					for (int j = 0; j < strings.size(); j++) {
						cell = row.createCell(j);
						if (j == 0) {
							cell.setCellValue(newList.get(i).getDmoney());
						} else if (j == 1) {
							cell.setCellValue(newList.get(i).getDlab());
						} else if (j == 2) {
							cell.setCellValue(newList.get(i).getDname1());
						} else if (j == 3) {
							cell.setCellValue(newList.get(i).getDname2());
						} else if (j == 4) {
							cell.setCellValue(newList.get(i).getDversion());
						} else if (j == 5) {
							cell.setCellValue(sdfT.format(newList.get(i)
									.getDbuytime()));
						} else if (j == 6) {
							cell.setCellValue(newList.get(i).getDposition());
						} else if (j == 7) {
							cell.setCellValue(newList.get(i).getDuser());
						} else if (j == 8) {
							cell.setCellValue(newList.get(i).getDstatus());
						} else if (j == 9) {
							cell.setCellValue(newList.get(i).getDcode());
						} else if (j == 10) {
							if (newList.get(i).getDborrow() != null) {
								cell.setCellValue(sdfT.format(newList.get(i)
										.getDborrow()));
							}
						} else if (j == 11) {
							if (newList.get(i).getDback() != null) {
								cell.setCellValue(sdfT.format(newList.get(i)
										.getDback()));
								long back = newList.get(i).getDback().getTime();
								long now = new Date().getTime();
								if ((back - now) <= 259200000 && (back >= now)) {
									cell.setCellStyle(color);
								}
							}
						} else if (j == 12) {
							cell.setCellValue(newList.get(i).getDdname());
						} else if (j == 13) {
							cell.setCellValue(newList.get(i).getDborrowname());
						} else if (j == 14){
							cell.setCellValue(newList.get(i).getDremark());
						} else {
							cell.setCellValue(newList.get(i).getDoldnumber());
						}
					}
				}
				for (int i = 0; i < sheet.getPhysicalNumberOfRows(); i++) {
					row = sheet.getRow(i);
					if (row != null) {
						int columnNumbers = row.getPhysicalNumberOfCells();
						for (int j = 0; j < columnNumbers; j++) {
							sheet.autoSizeColumn((short) j);
						}
					}
				}
				newList.clear();
				devices.clear();
				FileOutputStream fos = new FileOutputStream(new File(
						file.getAbsolutePath() + "/设备信息" + date + ".xlsx"));
				xssfWorkbook.write(fos);
				fos.close();
				utils.download(new File(file.getAbsoluteFile() + "/设备信息" + date
						+ ".xlsx"));
				new File(file.getAbsolutePath() + "/设备信息" + date + ".xlsx")
						.delete();
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		return "reportDeviceExcel";
	}

	public String listDeviceExcel() {
		try {
			devices = deviceService.all();
			if (devices.size() > 0) {
				reportDeviceExcel();
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		return "listDeviceExcel";
	}

	public String listSupportExcel() {
		try {
			supports = supportService.all();
			SimpleDateFormat sdf = new SimpleDateFormat(formatTime);
			SimpleDateFormat sdfT = new SimpleDateFormat(formatT);
			String date = sdf.format(new Date());
			date = date.replace(":", "-");
			File desktopDir = FileSystemView.getFileSystemView()
					.getHomeDirectory();
			String desktopPath = desktopDir.getAbsolutePath();
			File file = new File(desktopPath + "/项目报表");
			if (!file.exists() && !file.isDirectory()) {
				file.mkdir();
			}
			XSSFWorkbook xssfWorkbook;
			xssfWorkbook = new XSSFWorkbook();
			XSSFSheet sheet = xssfWorkbook.createSheet("支援信息");
			XSSFCellStyle color1 = xssfWorkbook.createCellStyle();
			color1.setFillForegroundColor(IndexedColors.YELLOW.getIndex());
			color1.setFillPattern(CellStyle.SOLID_FOREGROUND);
			XSSFCellStyle color2 = xssfWorkbook.createCellStyle();
			color2.setFillForegroundColor(IndexedColors.GREEN.getIndex());
			color2.setFillPattern(CellStyle.SOLID_FOREGROUND);
			List<String> strings = new ArrayList<String>();
			strings.add("发起时间");
			strings.add("结束时间");
			strings.add("需求部门");
			strings.add("需求人");
			strings.add("项目编码");
			strings.add("项目名称");
			strings.add("支援类型");
			strings.add("问题");
			strings.add("解决问题");
			strings.add("周期精力投入");
			strings.add("支援工时");
			strings.add("状态");
			strings.add("支援时间说明");
			strings.add("标准收费");
			strings.add("实际收费");
			strings.add("超时标准收费");
			strings.add("实际超时收费");
			strings.add("费用是否结算");
			XSSFRow row = sheet.createRow(0);
			XSSFCell cell;
			for (int i = 0; i < strings.size(); i++) {
				cell = row.createCell(i);
				cell.setCellValue(strings.get(i));
				if (i >= 15) {
					cell.setCellStyle(color1);
				}
			}
			for (int i = 0; i < supports.size(); i++) {
				row = sheet.createRow(i + 1);
				for (int j = 0; j < strings.size(); j++) {
					cell = row.createCell(j);
					if (j == 0) {
						cell.setCellValue(sdfT.format(supports.get(i)
								.getSstime()));
					} else if (j == 1) {
						if (supports.get(i).getSetime() != null) {
							cell.setCellValue(sdfT.format(supports.get(i)
									.getSetime()));
						}
					} else if (j == 2) {
						cell.setCellValue(supports.get(i).getSdepartmentname());
					} else if (j == 3) {
						cell.setCellValue(supports.get(i).getSreqname());
					} else if (j == 4) {
						cell.setCellValue(supports.get(i).getSprojectname());
					} else if (j == 5) {
						cell.setCellValue(supports.get(i).getSprojectname());
					} else if (j == 6) {
						cell.setCellValue(supports.get(i).getSkind());
					} else if (j == 7) {
						cell.setCellValue(supports.get(i).getSquestion());
					} else if (j == 8) {
						cell.setCellValue(supports.get(i).getSresolve());
					} else if (j == 9) {
						cell.setCellValue(supports.get(i).getSenergy());
					} else if (j == 10) {
						cell.setCellValue(supports.get(i).getStime());
					} else if (j == 11) {
						cell.setCellValue(supports.get(i).getStatus());
						if (supports.get(i).getStatus().contains("closed")) {
							cell.setCellStyle(color2);
						} else {
							cell.setCellStyle(color1);
						}
					} else if (j == 12) {
						cell.setCellValue(supports.get(i).getSremark());
					} else if (j == 13) {
						cell.setCellValue(supports.get(i).getStandardcharge());
					} else if (j == 14) {
						cell.setCellValue(supports.get(i).getSrealitycharge());
					} else if (j == 15) {
						cell.setCellStyle(color1);
						cell.setCellValue(supports.get(i)
								.getSoverstandardcharge());
					} else if (j == 16) {
						cell.setCellStyle(color1);
						cell.setCellValue(supports.get(i)
								.getSrealityovercharge());
					} else {
						cell.setCellValue(supports.get(i).getSisclosecharge());
					}
				}
			}
			for (int i = 0; i < sheet.getPhysicalNumberOfRows(); i++) {
				row = sheet.getRow(i);
				if (row != null) {
					int columnNumbers = row.getPhysicalNumberOfCells();
					for (int j = 0; j < columnNumbers; j++) {
						sheet.autoSizeColumn((short) j);
					}
				}
			}
			supports.clear();
			FileOutputStream fos = new FileOutputStream(new File(
					file.getAbsolutePath() + "/支援信息" + date + ".xlsx"));
			xssfWorkbook.write(fos);
			fos.close();
			utils.download(new File(file.getAbsoluteFile() + "/支援信息" + date
					+ ".xlsx"));
			new File(file.getAbsoluteFile() + "/支援信息" + date + ".xlsx")
					.delete();
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		return "listSupportExcel";
	}

}
