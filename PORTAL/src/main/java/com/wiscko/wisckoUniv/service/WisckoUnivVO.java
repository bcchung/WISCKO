package com.wiscko.wisckoUniv.service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Class Name : WisckoUnivVO.java
 * @Description : WisckoUniv VO class
 * @Modification Information
 *
 * @author bcchung
 * @since 2013-04-08
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class WisckoUnivVO extends WisckoUnivDefaultVO {
    private static final long serialVersionUID = 1L;
    
    private List<WisckoArrayVO> localeArray = new ArrayList<WisckoArrayVO>();
    
    /** SORT_ORDR */
    private long sortOrdr = 0L;
    
    /** USE_AT */
    private String useAt;
    
    /** FRST_REGIST_PNTTM */
    private String frstRegistPnttm;
    
    /** FRST_REGISTER_ID */
    private String frstRegisterId;
    
    /** LAST_UPDT_PNTTM */
    private String lastUpdtPnttm;
    
    /** LAST_UPDUSR_ID */
    private String lastUpdusrId;
    
    /** CTPRVN_CD */
    private String ctprvnCd;
    
    /** SIGNGU_CD */
    private String signguCd;
    
    /** UNIV_LOGO */
    private String univLogo;
    
    /** UNIV_NM */
    private String univNm;
    
    private long nttNo = 0L;
    
    private String[] locale;
    
	public long getSortOrdr() {
		return sortOrdr;
	}

	public void setSortOrdr(long sortOrdr) {
		this.sortOrdr = sortOrdr;
	}

	public String getUseAt() {
		return useAt;
	}

	public void setUseAt(String useAt) {
		this.useAt = useAt;
	}

	public String getFrstRegistPnttm() {
		return frstRegistPnttm;
	}

	public void setFrstRegistPnttm(String frstRegistPnttm) {
		this.frstRegistPnttm = frstRegistPnttm;
	}

	public String getFrstRegisterId() {
		return frstRegisterId;
	}

	public void setFrstRegisterId(String frstRegisterId) {
		this.frstRegisterId = frstRegisterId;
	}

	public String getLastUpdtPnttm() {
		return lastUpdtPnttm;
	}

	public void setLastUpdtPnttm(String lastUpdtPnttm) {
		this.lastUpdtPnttm = lastUpdtPnttm;
	}

	public String getLastUpdusrId() {
		return lastUpdusrId;
	}

	public void setLastUpdusrId(String lastUpdusrId) {
		this.lastUpdusrId = lastUpdusrId;
	}

	public String getCtprvnCd() {
		return ctprvnCd;
	}

	public void setCtprvnCd(String ctprvnCd) {
		this.ctprvnCd = ctprvnCd;
	}

	public String getSignguCd() {
		return signguCd;
	}

	public void setSignguCd(String signguCd) {
		this.signguCd = signguCd;
	}

	public String getUnivLogo() {
		return univLogo;
	}

	public void setUnivLogo(String univLogo) {
		this.univLogo = univLogo;
	}

	public String getUnivNm() {
		return univNm;
	}

	public void setUnivNm(String univNm) {
		this.univNm = univNm;
	}

	public long getNttNo() {
		return nttNo;
	}

	public void setNttNo(long nttNo) {
		this.nttNo = nttNo;
	}

	public String[] getLocale() {
		return locale;
	}

	public void setLocale(String[] locale) {
		this.locale = locale;
	}

	public List<WisckoArrayVO> getLocaleArray() {
		return localeArray;
	}

	public void setLocaleArray(List<WisckoArrayVO> localeArray) {
		this.localeArray = localeArray;
	}

}
