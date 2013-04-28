package com.wiscko.wisckoCntn.service;

import java.io.Serializable;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.springframework.context.i18n.LocaleContextHolder;

import egovframework.rte.fdl.string.EgovStringUtil;

/**
 * @Class Name : WisckoCntnDefaultVO.java
 * @Description : WisckoCntn Default VO class
 * @Modification Information
 *
 * @author bcchung
 * @since 2013-04-28
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class WisckoCntnDefaultVO implements Serializable {
	
    private String searchCondition = "";
    
    private String searchKeyword = "";
    
    private String searchUseYn = "";
    
    /** Recent Page */
    private int pageIndex = 1;
    
    /** Page Count */
    private int pageUnit = 10;
    
    /** Page Size */
    private int pageSize = 10;

    /** firstIndex */
    private int firstIndex = 1;

    /** lastIndex */
    private int lastIndex = 1;

    /** recordCountPerPage */
    private int recordCountPerPage = 10;
    
    /** CNTN_ID */
    private java.lang.String cntnId;
    
    private String searchLocale;
    
        
	public int getFirstIndex() {
		return firstIndex;
	}

	public void setFirstIndex(int firstIndex) {
		this.firstIndex = firstIndex;
	}

	public int getLastIndex() {
		return lastIndex;
	}

	public void setLastIndex(int lastIndex) {
		this.lastIndex = lastIndex;
	}

	public int getRecordCountPerPage() {
		return recordCountPerPage;
	}

	public void setRecordCountPerPage(int recordCountPerPage) {
		this.recordCountPerPage = recordCountPerPage;
	}

	public String getSearchCondition() {
        return searchCondition;
    }

    public void setSearchCondition(String searchCondition) {
        this.searchCondition = searchCondition;
    }

    public String getSearchKeyword() {
        return searchKeyword;
    }

    public void setSearchKeyword(String searchKeyword) {
        this.searchKeyword = searchKeyword;
    }

    public String getSearchUseYn() {
        return searchUseYn;
    }

    public void setSearchUseYn(String searchUseYn) {
        this.searchUseYn = searchUseYn;
    }

    public int getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(int pageIndex) {
        this.pageIndex = pageIndex;
    }

    public int getPageUnit() {
        return pageUnit;
    }

    public void setPageUnit(int pageUnit) {
        this.pageUnit = pageUnit;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

	public java.lang.String getCntnId() {
		return cntnId;
	}

	public void setCntnId(java.lang.String cntnId) {
		this.cntnId = cntnId;
	}

	public String getSearchLocale() {
		if(EgovStringUtil.isNull(searchLocale)) {
			searchLocale = LocaleContextHolder.getLocale().getLanguage().toUpperCase();
		}
		return searchLocale;
	}

	public void setSearchLocale(String searchLocale) {
		this.searchLocale = searchLocale;
	}

}
