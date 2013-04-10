package com.wiscko.wisckoUniv.service;

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
public class WisckoUnivVO extends WisckoUnivDefaultVO{
    private static final long serialVersionUID = 1L;
    
    /** UNIV_ID */
    private String univId;
    
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
    
    public String getUnivId() {
        return this.univId;
    }
    
    public void setUnivId(String univId) {
        this.univId = univId;
    }
    
    public long getSortOrdr() {
        return this.sortOrdr;
    }
    
    public void setSortOrdr(long sortOrdr) {
        this.sortOrdr = sortOrdr;
    }
    
    public String getUseAt() {
        return this.useAt;
    }
    
    public void setUseAt(String useAt) {
        this.useAt = useAt;
    }
    
    public String getFrstRegistPnttm() {
        return this.frstRegistPnttm;
    }
    
    public void setFrstRegistPnttm(String frstRegistPnttm) {
        this.frstRegistPnttm = frstRegistPnttm;
    }
    
    public String getFrstRegisterId() {
        return this.frstRegisterId;
    }
    
    public void setFrstRegisterId(String frstRegisterId) {
        this.frstRegisterId = frstRegisterId;
    }
    
    public String getLastUpdtPnttm() {
        return this.lastUpdtPnttm;
    }
    
    public void setLastUpdtPnttm(String lastUpdtPnttm) {
        this.lastUpdtPnttm = lastUpdtPnttm;
    }
    
    public String getLastUpdusrId() {
        return this.lastUpdusrId;
    }
    
    public void setLastUpdusrId(String lastUpdusrId) {
        this.lastUpdusrId = lastUpdusrId;
    }
    
    public String getCtprvnCd() {
        return this.ctprvnCd;
    }
    
    public void setCtprvnCd(String ctprvnCd) {
        this.ctprvnCd = ctprvnCd;
    }
    
    public String getSignguCd() {
        return this.signguCd;
    }
    
    public void setSignguCd(String signguCd) {
        this.signguCd = signguCd;
    }
    
    public String getUnivLogo() {
        return this.univLogo;
    }
    
    public void setUnivLogo(String univLogo) {
        this.univLogo = univLogo;
    }
    
    public String getUnivNm() {
        return this.univNm;
    }
    
    public void setUnivNm(String univNm) {
        this.univNm = univNm;
    }
    
}
