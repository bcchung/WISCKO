package com.wiscko.wisckoCntn.service;

import java.util.List;
import com.wiscko.wisckoCntn.service.WisckoCntnDefaultVO;
import com.wiscko.wisckoCntn.service.WisckoCntnVO;
import com.wiscko.wisckoUniv.service.WisckoArrayVO;

/**
 * @Class Name : WisckoCntnService.java
 * @Description : WisckoCntn Business class
 * @Modification Information
 *
 * @author bcchung
 * @since 2013-04-28
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public interface WisckoCntnService {
	
	/**
	 * wiscko_cntn Register
	 * @param vo - Register WisckoCntnVO
	 * @return Register Result
	 * @exception Exception
	 */
    String insertWisckoCntn(WisckoCntnVO vo) throws Exception;
    
    /**
	 * wiscko_cntn Update
	 * @param vo - Update WisckoCntnVO
	 * @return void
	 * @exception Exception
	 */
    void updateWisckoCntn(WisckoCntnVO vo) throws Exception;
    
    /**
	 * wiscko_cntn Delete
	 * @param vo - Delete WisckoCntnVO
	 * @return void 
	 * @exception Exception
	 */
    void deleteWisckoCntn(WisckoCntnVO vo) throws Exception;
    
    /**
	 * wiscko_cntn Inquire
	 * @param vo - Inquire WisckoCntnVO
	 * @return Inquire wiscko_cntn
	 * @exception Exception
	 */
    WisckoCntnVO selectWisckoCntn(WisckoCntnDefaultVO searchVO) throws Exception;
    
    /**
	 * wiscko_cntn List
	 * @param searchVO - List VO
	 * @return wiscko_cntn List
	 * @exception Exception
	 */
    List selectWisckoCntnList(WisckoCntnDefaultVO searchVO) throws Exception;
    
    /**
	 * wiscko_cntn List Count
	 * @param searchVO - List Count VO
	 * @return wiscko_cntn Total Count
	 * @exception
	 */
    int selectWisckoCntnListTotCnt(WisckoCntnDefaultVO searchVO);

    
	WisckoArrayVO selectWisckoCntnLocaleView(WisckoCntnDefaultVO searchVO) throws Exception;
    
}
