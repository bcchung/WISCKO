package com.wiscko.wisckoUniv.service;

import java.util.List;
import com.wiscko.wisckoUniv.service.WisckoUnivDefaultVO;
import com.wiscko.wisckoUniv.service.WisckoUnivVO;

/**
 * @Class Name : WisckoUnivService.java
 * @Description : WisckoUniv Business class
 * @Modification Information
 *
 * @author bcchung
 * @since 2013-04-08
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public interface WisckoUnivService {
	
	/**
	 * wiscko_univ Register
	 * @param vo - Register WisckoUnivVO
	 * @return Register Result
	 * @exception Exception
	 */
    String insertWisckoUniv(WisckoUnivVO vo) throws Exception;
    
    /**
	 * wiscko_univ Update
	 * @param vo - Update WisckoUnivVO
	 * @return void
	 * @exception Exception
	 */
    void updateWisckoUniv(WisckoUnivVO vo) throws Exception;
    
    /**
	 * wiscko_univ Delete
	 * @param vo - Delete WisckoUnivVO
	 * @return void 
	 * @exception Exception
	 */
    void deleteWisckoUniv(WisckoUnivVO vo) throws Exception;
    
    /**
	 * wiscko_univ Inquire
	 * @param vo - Inquire WisckoUnivVO
	 * @return Inquire wiscko_univ
	 * @exception Exception
	 */
    WisckoUnivVO selectWisckoUniv(WisckoUnivDefaultVO searchVO) throws Exception;
    
    /**
	 * wiscko_univ List
	 * @param searchVO - List VO
	 * @return wiscko_univ List
	 * @exception Exception
	 */
    List selectWisckoUnivList(WisckoUnivDefaultVO searchVO) throws Exception;
    
    /**
	 * wiscko_univ List Count
	 * @param searchVO - List Count VO
	 * @return wiscko_univ Total Count
	 * @exception
	 */
    int selectWisckoUnivListTotCnt(WisckoUnivDefaultVO searchVO);
    
    /**
     * View Locale Univ
     * @param searchVO
     * @return
     * @throws Exception
     */
	WisckoArrayVO selectWisckoUnivLocaleView(WisckoUnivDefaultVO searchVO) throws Exception;
    
}
