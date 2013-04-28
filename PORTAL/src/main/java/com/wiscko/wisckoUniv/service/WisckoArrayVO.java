package com.wiscko.wisckoUniv.service;

import java.io.Serializable;


@SuppressWarnings("serial")
public class WisckoArrayVO implements Serializable {
	
	private String cntnId;
	private String univId;
	private String locale;
    private String localeNm;
    
    private String nttSj;
    private String nttCn;
    private String localeAtchFileId;
    
    /** FRST_REGISTER_ID */
    private String frstRegisterId;
    
    /** LAST_UPDUSR_ID */
    private String lastUpdusrId;
    
	public String getLocale() {
		return locale;
	}
	public void setLocale(String locale) {
		this.locale = locale;
	}
	public String getLocaleNm() {
		return localeNm;
	}
	public void setLocaleNm(String localeNm) {
		this.localeNm = localeNm;
	}
	public String getNttCn() {
		return nttCn;
	}
	public void setNttCn(String nttCn) {
		this.nttCn = nttCn;
	}
	public String getLocaleAtchFileId() {
		return localeAtchFileId;
	}
	public void setLocaleAtchFileId(String localeAtchFileId) {
		this.localeAtchFileId = localeAtchFileId;
	}
	public String getFrstRegisterId() {
		return frstRegisterId;
	}
	public void setFrstRegisterId(String frstRegisterId) {
		this.frstRegisterId = frstRegisterId;
	}
	public String getLastUpdusrId() {
		return lastUpdusrId;
	}
	public void setLastUpdusrId(String lastUpdusrId) {
		this.lastUpdusrId = lastUpdusrId;
	}
	public String getUnivId() {
		return univId;
	}
	public void setUnivId(String univId) {
		this.univId = univId;
	}
	public String getCntnId() {
		return cntnId;
	}
	public void setCntnId(String cntnId) {
		this.cntnId = cntnId;
	}
	public String getNttSj() {
		return nttSj;
	}
	public void setNttSj(String nttSj) {
		this.nttSj = nttSj;
	}
}
