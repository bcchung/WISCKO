package com.wiscko.wisckoCntn.service;

import java.util.ArrayList;
import java.util.List;

import com.wiscko.wisckoUniv.service.WisckoArrayVO;

/**
 * @Class Name : WisckoCntnVO.java
 * @Description : WisckoCntn VO class
 * @Modification Information
 *
 * @author bcchung
 * @since 2013-04-28
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class WisckoCntnVO extends WisckoCntnDefaultVO{
    private static final long serialVersionUID = 1L;
    
    private List<WisckoArrayVO> localeArray = new ArrayList<WisckoArrayVO>();
    
    /** FRST_REGIST_PNTTM */
    private java.util.Date frstRegistPnttm;
    
    /** FRST_REGISTER_ID */
    private java.lang.String frstRegisterId;
    
    /** LAST_UPDT_PNTTM */
    private java.util.Date lastUpdtPnttm;
    
    /** LAST_UPDUSR_ID */
    private java.lang.String lastUpdusrId;
    
    /** NTT_SJ */
    private java.lang.String nttSj;
    
    private String cntnMenuNm;
    
    private String forwardUrl;
    
    public java.util.Date getFrstRegistPnttm() {
        return this.frstRegistPnttm;
    }
    
    public void setFrstRegistPnttm(java.util.Date frstRegistPnttm) {
        this.frstRegistPnttm = frstRegistPnttm;
    }
    
    public java.lang.String getFrstRegisterId() {
        return this.frstRegisterId;
    }
    
    public void setFrstRegisterId(java.lang.String frstRegisterId) {
        this.frstRegisterId = frstRegisterId;
    }
    
    public java.util.Date getLastUpdtPnttm() {
        return this.lastUpdtPnttm;
    }
    
    public void setLastUpdtPnttm(java.util.Date lastUpdtPnttm) {
        this.lastUpdtPnttm = lastUpdtPnttm;
    }
    
    public java.lang.String getLastUpdusrId() {
        return this.lastUpdusrId;
    }
    
    public void setLastUpdusrId(java.lang.String lastUpdusrId) {
        this.lastUpdusrId = lastUpdusrId;
    }
    
    public java.lang.String getNttSj() {
        return this.nttSj;
    }
    
    public void setNttSj(java.lang.String nttSj) {
        this.nttSj = nttSj;
    }

	public List<WisckoArrayVO> getLocaleArray() {
		return localeArray;
	}

	public void setLocaleArray(List<WisckoArrayVO> localeArray) {
		this.localeArray = localeArray;
	}

	public String getForwardUrl() {
		return forwardUrl;
	}

	public void setForwardUrl(String forwardUrl) {
		this.forwardUrl = forwardUrl;
	}

	public String getCntnMenuNm() {
		return cntnMenuNm;
	}

	public void setCntnMenuNm(String cntnMenuNm) {
		this.cntnMenuNm = cntnMenuNm;
	}
    
}
