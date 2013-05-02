package com.wiscko.wisckoUniv.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.wiscko.wisckoUniv.service.WisckoArrayVO;
import com.wiscko.wisckoUniv.service.WisckoUnivDefaultVO;
import com.wiscko.wisckoUniv.service.WisckoUnivService;
import com.wiscko.wisckoUniv.service.WisckoUnivVO;

import egovframework.rte.fdl.cmmn.AbstractServiceImpl;
import egovframework.rte.fdl.idgnr.EgovIdGnrService;
import egovframework.rte.fdl.string.EgovObjectUtil;

/**
 * @Class Name : WisckoUnivServiceImpl.java
 * @Description : WisckoUniv Business Implement class
 * @Modification Information
 *
 * @author bcchung
 * @since 2013-04-08
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Service("wisckoUnivService")
public class WisckoUnivServiceImpl extends AbstractServiceImpl implements
        WisckoUnivService {

    @Resource(name="wisckoUnivDAO")
    private WisckoUnivDAO wisckoUnivDAO;
    
    /** ID Generation */
    @Resource(name="egovUnivIdGnrService")    
    private EgovIdGnrService egovIdGnrService;

	/**
	 * wiscko_univ Register
	 * @param vo - Register WisckoUnivVO
	 * @return Register Result
	 * @exception Exception
	 */
    public String insertWisckoUniv(WisckoUnivVO vo) throws Exception {
    	log.debug(vo.toString());
    	
    	/** ID Generation Service */
    	String id = egovIdGnrService.getNextStringId();
    	vo.setUnivId(id);
    	
    	wisckoUnivDAO.insertWisckoUniv(vo);
    	
    	List<WisckoArrayVO> localeArray = vo.getLocaleArray();
    	WisckoArrayVO arrayVO = null;
    	
    	for(int i = 0; i < localeArray.size(); i++) {
    		arrayVO = (WisckoArrayVO) localeArray.get(i);

    		arrayVO.setUnivId(vo.getUnivId());
    		arrayVO.setFrstRegisterId(vo.getFrstRegisterId());
    		arrayVO.setLastUpdusrId(vo.getFrstRegisterId());
    		
    		wisckoUnivDAO.mergeWisckoUnivLocale(arrayVO);
    	}
    	
        return null;
    }

    /**
	 * wiscko_univ Update
	 * @param vo - Update WisckoUnivVO
	 * @return void
	 * @exception Exception
	 */
    public void updateWisckoUniv(WisckoUnivVO vo) throws Exception {
        wisckoUnivDAO.updateWisckoUniv(vo);
        
        List<WisckoArrayVO> localeArray = vo.getLocaleArray();
    	WisckoArrayVO arrayVO = null;
    	
    	for(int i = 0; i < localeArray.size(); i++) {
    		arrayVO = (WisckoArrayVO) localeArray.get(i);

    		arrayVO.setUnivId(vo.getUnivId());
    		arrayVO.setFrstRegisterId(vo.getLastUpdusrId());
    		arrayVO.setLastUpdusrId(vo.getLastUpdusrId());
    		
    		wisckoUnivDAO.mergeWisckoUnivLocale(arrayVO);
    	}
    }

    /**
	 * wiscko_univ Delete
	 * @param vo - Delete WisckoUnivVO
	 * @return void 
	 * @exception Exception
	 */
    public void deleteWisckoUniv(WisckoUnivVO vo) throws Exception {
        wisckoUnivDAO.deleteWisckoUniv(vo);
    }

    /**
	 * wiscko_univ Inquire
	 * @param vo - Inquire WisckoUnivVO
	 * @return wiscko_univ
	 * @exception Exception
	 */
    public WisckoUnivVO selectWisckoUniv(WisckoUnivDefaultVO searchVO) throws Exception {
        WisckoUnivVO resultVO = wisckoUnivDAO.selectWisckoUniv(searchVO);
        if (resultVO == null)
            throw processException("info.nodata.msg");
        
        List<WisckoArrayVO> localeArray = wisckoUnivDAO.selectWisckoUnivLocaleList(searchVO);
        if(!EgovObjectUtil.isNull(localeArray)) {
        	resultVO.setLocaleArray(localeArray);
        }        
        return resultVO;
    }

    /**
	 * wiscko_univ List
	 * @param searchVO - List VO
	 * @return wiscko_univ List
	 * @exception Exception
	 */
    public List selectWisckoUnivList(WisckoUnivDefaultVO searchVO) throws Exception {
        return wisckoUnivDAO.selectWisckoUnivList(searchVO);
    }

    /**
	 * wiscko_univ List Count
	 * @param searchVO - List Count VO
	 * @return wiscko_univ Total Count
	 * @exception
	 */
    public int selectWisckoUnivListTotCnt(WisckoUnivDefaultVO searchVO) {
		return wisckoUnivDAO.selectWisckoUnivListTotCnt(searchVO);
	}

	public WisckoArrayVO selectWisckoUnivLocaleView(WisckoUnivDefaultVO searchVO) throws Exception {
		return wisckoUnivDAO.selectWisckoUnivLocaleView(searchVO);
	}
    
}
