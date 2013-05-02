package com.wiscko.wisckoCntn.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import egovframework.rte.fdl.cmmn.AbstractServiceImpl;
import egovframework.rte.fdl.idgnr.EgovIdGnrService;
import egovframework.rte.fdl.string.EgovObjectUtil;
import egovframework.rte.fdl.string.EgovStringUtil;

import com.wiscko.wisckoCntn.service.WisckoCntnService;
import com.wiscko.wisckoCntn.service.WisckoCntnDefaultVO;
import com.wiscko.wisckoCntn.service.WisckoCntnVO;
import com.wiscko.wisckoCntn.service.impl.WisckoCntnDAO;
import com.wiscko.wisckoUniv.service.WisckoArrayVO;

/**
 * @Class Name : WisckoCntnServiceImpl.java
 * @Description : WisckoCntn Business Implement class
 * @Modification Information
 *
 * @author bcchung
 * @since 2013-04-28
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Service("wisckoCntnService")
public class WisckoCntnServiceImpl extends AbstractServiceImpl implements
        WisckoCntnService {

    @Resource(name="wisckoCntnDAO")
    private WisckoCntnDAO wisckoCntnDAO;
    
    /** ID Generation */
    @Resource(name="egovCntnIdGnrService")    
    private EgovIdGnrService egovIdGnrService;

	/**
	 * wiscko_cntn Register
	 * @param vo - Register WisckoCntnVO
	 * @return Register Result
	 * @exception Exception
	 */
    public String insertWisckoCntn(WisckoCntnVO vo) throws Exception {
    	/** ID Generation Service */
    	String id = egovIdGnrService.getNextStringId();
    	vo.setCntnId(id);
    	
    	wisckoCntnDAO.insertWisckoCntn(vo);
    	
    	List<WisckoArrayVO> localeArray = vo.getLocaleArray();
    	WisckoArrayVO arrayVO = null;
    	
    	for(int i = 0; i < localeArray.size(); i++) {
    		arrayVO = (WisckoArrayVO) localeArray.get(i);

    		arrayVO.setCntnId(vo.getCntnId());
    		arrayVO.setFrstRegisterId(vo.getFrstRegisterId());
    		arrayVO.setLastUpdusrId(vo.getFrstRegisterId());
    		
    		wisckoCntnDAO.mergeWisckoCntnLocale(arrayVO);
    	}
    	
    	wisckoCntnDAO.updateWisckoMenuCntnId(vo);
        return null;
    }

    /**
	 * wiscko_cntn Update
	 * @param vo - Update WisckoCntnVO
	 * @return void
	 * @exception Exception
	 */
    public void updateWisckoCntn(WisckoCntnVO vo) throws Exception {
        wisckoCntnDAO.updateWisckoCntn(vo);
        
        List<WisckoArrayVO> localeArray = vo.getLocaleArray();
    	WisckoArrayVO arrayVO = null;
    	
    	for(int i = 0; i < localeArray.size(); i++) {
    		arrayVO = (WisckoArrayVO) localeArray.get(i);

    		arrayVO.setCntnId(vo.getCntnId());
    		arrayVO.setFrstRegisterId(vo.getLastUpdusrId());
    		arrayVO.setLastUpdusrId(vo.getLastUpdusrId());
    		
    		wisckoCntnDAO.mergeWisckoCntnLocale(arrayVO);
    	}
    	
    	wisckoCntnDAO.updateWisckoMenuCntnId(vo);
    }

    /**
	 * wiscko_cntn Delete
	 * @param vo - Delete WisckoCntnVO
	 * @return void 
	 * @exception Exception
	 */
    public void deleteWisckoCntn(WisckoCntnVO vo) throws Exception {
        wisckoCntnDAO.deleteWisckoCntn(vo);
    }

    /**
	 * wiscko_cntn Inquire
	 * @param vo - Inquire WisckoCntnVO
	 * @return wiscko_cntn
	 * @exception Exception
	 */
    public WisckoCntnVO selectWisckoCntn(WisckoCntnDefaultVO searchVO) throws Exception {
        WisckoCntnVO resultVO = wisckoCntnDAO.selectWisckoCntn(searchVO);
        if (resultVO == null)
            throw processException("info.nodata.msg");
        
        String forwardUrl = null;
        if(!EgovStringUtil.isNull(resultVO.getCntnId())) {
        	forwardUrl = "/wiscko/wisckoCntn/selectWisckoCntnLocaleView.do" + "?cntnId="+resultVO.getCntnId();
        }
        resultVO.setForwardUrl(forwardUrl);
        
        List<WisckoArrayVO> localeArray = wisckoCntnDAO.selectWisckoCntnLocaleList(resultVO);
        if(!EgovObjectUtil.isNull(localeArray)) {
        	resultVO.setLocaleArray(localeArray);
        }
        return resultVO;
    }

    /**
	 * wiscko_cntn List
	 * @param searchVO - List VO
	 * @return wiscko_cntn List
	 * @exception Exception
	 */
    public List selectWisckoCntnList(WisckoCntnDefaultVO searchVO) throws Exception {
        return wisckoCntnDAO.selectWisckoCntnList(searchVO);
    }

    /**
	 * wiscko_cntn List Count
	 * @param searchVO - List Count VO
	 * @return wiscko_cntn Total Count
	 * @exception
	 */
    public int selectWisckoCntnListTotCnt(WisckoCntnDefaultVO searchVO) {
		return wisckoCntnDAO.selectWisckoCntnListTotCnt(searchVO);
	}

	public WisckoArrayVO selectWisckoCntnLocaleView(WisckoCntnDefaultVO searchVO) throws Exception {
		return wisckoCntnDAO.selectWisckoCntnLocaleView(searchVO);
	}
    
}
