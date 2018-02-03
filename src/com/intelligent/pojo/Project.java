package com.intelligent.pojo;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Project {
	private String pname;
	private Date ptime;
	private String pnumber;
	private String pmapnumber;
	private String pdutyname;
	private String pME;
	private String pEE;
	private String pSW;
	private String premark;
	private String pstatus;
	private String producekind;
	private String pmothercode;
	private String pshortname;
	private String place;
	private String pnum;
	private String po;
	private String period;
	private Date pfinishtime;
	private String papn;
	private String psn;
	private String pwords;
	private User   user;
	private Set<Pcb> setPcbs = new HashSet<Pcb>();
	private Set<Machine> setMachines = new HashSet<Machine>();
	private Set<Soft> setSofts = new HashSet<Soft>();
	public Date getPtime() {
		return ptime;
	}
	public void setPtime(Date ptime) {
		this.ptime = ptime;
	}
	public Date getPfinishtime() {
		return pfinishtime;
	}
	public void setPfinishtime(Date pfinishtime) {
		this.pfinishtime = pfinishtime;
	}
	public Set<Pcb> getSetPcbs() {
		return setPcbs;
	}
	public void setSetPcbs(Set<Pcb> setPcbs) {
		this.setPcbs = setPcbs;
	}
	public Set<Machine> getSetMachines() {
		return setMachines;
	}
	public void setSetMachines(Set<Machine> setMachines) {
		this.setMachines = setMachines;
	}
	public Set<Soft> getSetSofts() {
		return setSofts;
	}
	public void setSetSofts(Set<Soft> setSofts) {
		this.setSofts = setSofts;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public String getPnumber() {
		return pnumber;
	}
	public void setPnumber(String pnumber) {
		this.pnumber = pnumber;
	}
	public String getPmapnumber() {
		return pmapnumber;
	}
	public void setPmapnumber(String pmapnumber) {
		this.pmapnumber = pmapnumber;
	}
	public String getPdutyname() {
		return pdutyname;
	}
	public void setPdutyname(String pdutyname) {
		this.pdutyname = pdutyname;
	}
	public String getpME() {
		return pME;
	}
	public void setpME(String pME) {
		this.pME = pME;
	}
	public String getpEE() {
		return pEE;
	}
	public void setpEE(String pEE) {
		this.pEE = pEE;
	}
	public String getpSW() {
		return pSW;
	}
	public void setpSW(String pSW) {
		this.pSW = pSW;
	}
	public String getPremark() {
		return premark;
	}
	public void setPremark(String premark) {
		this.premark = premark;
	}
	public String getPstatus() {
		return pstatus;
	}
	public void setPstatus(String pstatus) {
		this.pstatus = pstatus;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getProducekind() {
		return producekind;
	}
	public void setProducekind(String producekind) {
		this.producekind = producekind;
	}
	public String getPmothercode() {
		return pmothercode;
	}
	public void setPmothercode(String pmothercode) {
		this.pmothercode = pmothercode;
	}
	public String getPshortname() {
		return pshortname;
	}
	public void setPshortname(String pshortname) {
		this.pshortname = pshortname;
	}
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	public String getPnum() {
		return pnum;
	}
	public void setPnum(String pnum) {
		this.pnum = pnum;
	}
	public String getPo() {
		return po;
	}
	public void setPo(String po) {
		this.po = po;
	}
	public String getPeriod() {
		return period;
	}
	public void setPeriod(String period) {
		this.period = period;
	}
	public String getPapn() {
		return papn;
	}
	public void setPapn(String papn) {
		this.papn = papn;
	}
	public String getPsn() {
		return psn;
	}
	public void setPsn(String psn) {
		this.psn = psn;
	}
	public String getPwords() {
		return pwords;
	}
	public void setPwords(String pwords) {
		this.pwords = pwords;
	} 

}
