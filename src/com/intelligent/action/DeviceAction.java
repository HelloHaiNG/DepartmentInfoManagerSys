package com.intelligent.action;

import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.intelligent.pojo.Department;
import com.intelligent.pojo.Device;
import com.intelligent.pojo.PageBean;
import com.intelligent.service.DepartmentService;
import com.intelligent.service.DeviceService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@SuppressWarnings("all")
public class DeviceAction extends ActionSupport implements ModelDriven<Device> {
	private Device device = new Device();
	private DeviceService deviceService;
	private DepartmentService departmentService;
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	private HttpServletRequest request = ServletActionContext.getRequest();
	private Integer currentPage;

	public Integer getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}

	public void setDepartmentService(DepartmentService departmentService) {
		this.departmentService = departmentService;
	}

	public void setDeviceService(DeviceService deviceService) {
		this.deviceService = deviceService;
	}

	@Override
	public Device getModel() {
		return device;
	}

	public String toAddPage() {
		List<Department> departments = departmentService.list();
		ServletActionContext.getRequest().setAttribute("department",
				departments);
		return "toAddPage";
	}

	public String add() {
		try {
			String dmoney = request.getParameter("dmoney");
			String dname1 = request.getParameter("dname1");
			dname1 = new String(dname1.getBytes("ISO-8859-1"), "utf-8");
			String dname2 = request.getParameter("dname2");
			dname2 = new String(dname2.getBytes("ISO-8859-1"), "utf-8");
			String dversion = request.getParameter("dversion");
			dversion = new String(dversion.getBytes("ISO-8859-1"), "utf-8");
			String dbuytime = request.getParameter("dbuytime");
			dbuytime = new String(dbuytime.getBytes("ISO-8859-1"), "utf-8");
			String dposition = request.getParameter("dposition");
			dposition = new String(dposition.getBytes("ISO-8859-1"), "utf-8");
			String duser = request.getParameter("duser");
			duser = new String(duser.getBytes("ISO-8859-1"), "utf-8");
			String dstatus = request.getParameter("dstatus");
			dstatus = new String(dstatus.getBytes("ISO-8859-1"), "utf-8");
			String dcode = request.getParameter("dcode");
			dcode = new String(dcode.getBytes("ISO-8859-1"), "utf-8");
			String dborrow = request.getParameter("dborrow");
			dborrow = new String(dborrow.getBytes("ISO-8859-1"), "utf-8");
			String dback = request.getParameter("dback");
			dback = new String(dback.getBytes("ISO-8859-1"), "utf-8");
			String ddname = request.getParameter("ddname");
			ddname = new String(ddname.getBytes("ISO-8859-1"), "utf-8");
			String dborrowname = request.getParameter("dborrowname");
			dborrowname = new String(dborrowname.getBytes("ISO-8859-1"),
					"utf-8");
			String dremark = request.getParameter("dremark");
			dremark = new String(dremark.getBytes("ISO-8859-1"), "utf-8");
			String doldnumber = request.getParameter("doldnumber");
			doldnumber = new String(doldnumber.getBytes("ISO-8859-1"), "utf-8");
			int id = deviceService.findCount();
			int did = id + 1;
			String dlab = "SY-YQ";
			if (id < 10) {
				dlab = dlab.concat("0000" + String.valueOf(did));
			} else if (id < 100) {
				dlab = dlab.concat("000" + String.valueOf(did));
			} else if (id < 1000) {
				dlab = dlab.concat("00" + String.valueOf(did));
			} else if (id < 10000) {
				dlab = dlab.concat("0" + String.valueOf(did));
			} else {
				dlab = dlab.concat(String.valueOf(did));
			}
			if (dback.length() > 0) {
				device.setDback(sdf.parse(dback));
			}
			if (dborrow.length() > 0) {
				device.setDborrow(sdf.parse(dborrow));
			}
			device.setDoldnumber(doldnumber);
			device.setDborrowname(dborrowname);
			device.setDbuytime(sdf.parse(dbuytime));
			device.setDcode(dcode);
			device.setDdname(ddname);
			device.setDlab(dlab);
			device.setDmoney(dmoney);
			device.setDname1(dname1);
			device.setDname2(dname2);
			device.setDposition(dposition);
			device.setDremark(dremark);
			device.setDstatus(dstatus);
			device.setDuser(duser);
			device.setDversion(dversion);
			deviceService.add(device);
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		return "add";
	}

	public String list() {
		try {
			PageBean pageBean = deviceService.list(currentPage);
			ServletActionContext.getRequest()
					.setAttribute("pageBean", pageBean);
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		return "list";
	}

	public String listByOthers() {
		try {
			PageBean pageBean = deviceService.list(currentPage);
			ServletActionContext.getRequest()
					.setAttribute("pageBean", pageBean);
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		return "listByOthers";
	}

	public String viewByDid() {
		try {
			String did = request.getParameter("did");
			device = deviceService.findByDid(Integer.parseInt(did));
			request.setAttribute("device", device);
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		return "viewByDid";
	}

	public String viewByDidByOthers() {
		try {
			String did = request.getParameter("did");
			device = deviceService.findByDid(Integer.parseInt(did));
			request.setAttribute("device", device);
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		return "viewByDidByOthers";
	}

	public String update() {
		try {
			String did = request.getParameter("did");
			String dmoney = request.getParameter("dmoney");
			String dname1 = request.getParameter("dname1");
			dname1 = new String(dname1.getBytes("ISO-8859-1"), "utf-8");
			String dname2 = request.getParameter("dname2");
			dname2 = new String(dname2.getBytes("ISO-8859-1"), "utf-8");
			String dversion = request.getParameter("dversion");
			dversion = new String(dversion.getBytes("ISO-8859-1"), "utf-8");
			String dbuytime = request.getParameter("dbuytime");
			dbuytime = new String(dbuytime.getBytes("ISO-8859-1"), "utf-8");
			String dposition = request.getParameter("dposition");
			dposition = new String(dposition.getBytes("ISO-8859-1"), "utf-8");
			String duser = request.getParameter("duser");
			duser = new String(duser.getBytes("ISO-8859-1"), "utf-8");
			String dstatus = request.getParameter("dstatus");
			dstatus = new String(dstatus.getBytes("ISO-8859-1"), "utf-8");
			String dcode = request.getParameter("dcode");
			dcode = new String(dcode.getBytes("ISO-8859-1"), "utf-8");
			String dborrow = request.getParameter("dborrow");
			dborrow = new String(dborrow.getBytes("ISO-8859-1"), "utf-8");
			String dback = request.getParameter("dback");
			dback = new String(dback.getBytes("ISO-8859-1"), "utf-8");
			String ddname = request.getParameter("ddname");
			ddname = new String(ddname.getBytes("ISO-8859-1"), "utf-8");
			String dborrowname = request.getParameter("dborrowname");
			dborrowname = new String(dborrowname.getBytes("ISO-8859-1"),
					"utf-8");
			String dremark = request.getParameter("dremark");
			dremark = new String(dremark.getBytes("ISO-8859-1"), "utf-8");
			String dlab = request.getParameter("dlab");
			dlab = new String(dlab.getBytes("ISO-8859-1"), "utf-8");
			String doldnumber = request.getParameter("doldnumber");
			doldnumber = new String(doldnumber.getBytes("ISO-8859-1"), "utf-8");
			if (dback.length() > 0) {
				device.setDback(sdf.parse(dback));
			}
			if (dborrow.length() > 0) {
				device.setDborrow(sdf.parse(dborrow));
			}
			device.setDoldnumber(doldnumber);
			device.setDid(Integer.parseInt(did));
			device.setDborrowname(dborrowname);
			device.setDbuytime(sdf.parse(dbuytime));
			device.setDcode(dcode);
			device.setDdname(ddname);
			device.setDlab(dlab);
			device.setDmoney(dmoney);
			device.setDname1(dname1);
			device.setDname2(dname2);
			device.setDposition(dposition);
			device.setDremark(dremark);
			device.setDstatus(dstatus);
			device.setDuser(duser);
			device.setDversion(dversion);
			deviceService.update(device);
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		return "update";
	}

	public String deleteByDid() {
		try {
			String did = request.getParameter("did");
			device = deviceService.findByDid(Integer.parseInt(did));
			if (device != null) {
				deviceService.delete(device);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		return "deleteByDid";
	}

	public String delete() {
		try {
			List<Device> devices = deviceService.all();
			for (Device device : devices) {
				deviceService.delete(device);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		return "delete";
	}
}
