package com.wiscko.wisckoUniv.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

import com.wiscko.wisckoUniv.service.WisckoArrayVO;
import com.wiscko.wisckoUniv.service.WisckoUnivVO;
import com.wiscko.wisckoUniv.service.WisckoUnivDefaultVO;

/**
 * @Class Name : WisckoUnivDAO.java
 * @Description : WisckoUniv DAO Class
 * @Modification Information
 *
 * @author bcchung
 * @since 2013-04-08
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("wisckoUnivDAO")
public class WisckoUnivDAO extends EgovAbstractDAO {

	/**
	 * wiscko_univ Register
	 * @param vo - Register WisckoUnivVO
	 * @return Register Result
	 * @exception Exception
	 */
    public String insertWisckoUniv(WisckoUnivVO vo) throws Exception {
        return (String)insert("wisckoUnivDAO.insertWisckoUniv_S", vo);
    }

    /**
	 * wiscko_univ Update
	 * @param vo - Update WisckoUnivVO
	 * @return void
	 * @exception Exception
	 */
    public void updateWisckoUniv(WisckoUnivVO vo) throws Exception {
        update("wisckoUnivDAO.updateWisckoUniv_S", vo);
    }
    
    /**
     * Locale Merge
     * @param vo
     * @throws Exception
     */
    public void mergeWisckoUnivLocale(WisckoArrayVO vo) throws Exception {
        update("wisckoUnivDAO.updateWisckoUnivLocale", vo);
    }

    /**
	 * wiscko_univ Delete
	 * @param vo - Delete WisckoUnivVO
	 * @return void 
	 * @exception Exception
	 */
    public void deleteWisckoUniv(WisckoUnivVO vo) throws Exception {
        delete("wisckoUnivDAO.deleteWisckoUniv_S", vo);
    }

    /**
	 * wiscko_univ Inquire
	 * @param vo - Inquire WisckoUnivVO
	 * @return Inquire wiscko_univ
	 * @exception Exception
	 */
    public WisckoUnivVO selectWisckoUniv(WisckoUnivVO vo) throws Exception {
        return (WisckoUnivVO) selectByPk("wisckoUnivDAO.selectWisckoUniv_S", vo);
    }

    /**
	 * wiscko_univ List
	 * @param searchMap - List Map
	 * @return wiscko_univ List
	 * @exception Exception
	 */
    public List selectWisckoUnivList(WisckoUnivDefaultVO searchVO) throws Exception {
        return list("wisckoUnivDAO.selectWisckoUnivList_D", searchVO);
    }

    /**
	 * wiscko_univ List Count
	 * @param searchMap - List Map
	 * @return wiscko_univ Total Count
	 * @exception
	 */
    public int selectWisckoUnivListTotCnt(WisckoUnivDefaultVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("wisckoUnivDAO.selectWisckoUnivListTotCnt_S", searchVO);
    }
    
    /**
     * LocaleCntn List 
     * @param vo
     * @return
     */
	@SuppressWarnings("unchecked")
	public List<WisckoArrayVO> selectWisckoUnivLocaleList(WisckoUnivVO vo) {
		return (List<WisckoArrayVO>)list("wisckoUnivDAO.selectWisckoUnivLocaleList", vo);
	}
	
	/**
	 * Locale Univ View
	 * @param searchVO
	 * @return
	 * @throws Exception
	 */
	public WisckoArrayVO selectWisckoUnivLocaleView(WisckoUnivDefaultVO searchVO) throws Exception{
		return (WisckoArrayVO) selectByPk("wisckoUnivDAO.selectWisckoUnivLocaleView", searchVO);
	}

}
