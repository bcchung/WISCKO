package com.wiscko.wisckoCntn.service.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;
import com.wiscko.wisckoCntn.service.WisckoCntnVO;
import com.wiscko.wisckoCntn.service.WisckoCntnDefaultVO;
import com.wiscko.wisckoUniv.service.WisckoArrayVO;

/**
 * @Class Name : WisckoCntnDAO.java
 * @Description : WisckoCntn DAO Class
 * @Modification Information
 *
 * @author bcchung
 * @since 2013-04-28
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("wisckoCntnDAO")
public class WisckoCntnDAO extends EgovAbstractDAO {

	/**
	 * wiscko_cntn Register
	 * @param vo - Register WisckoCntnVO
	 * @return Register Result
	 * @exception Exception
	 */
    public String insertWisckoCntn(WisckoCntnVO vo) throws Exception {
        return (String)insert("wisckoCntnDAO.insertWisckoCntn_S", vo);
    }

    /**
	 * wiscko_cntn Update
	 * @param vo - Update WisckoCntnVO
	 * @return void
	 * @exception Exception
	 */
    public void updateWisckoCntn(WisckoCntnVO vo) throws Exception {
        update("wisckoCntnDAO.updateWisckoCntn_S", vo);
    }

    /**
	 * wiscko_cntn Delete
	 * @param vo - Delete WisckoCntnVO
	 * @return void 
	 * @exception Exception
	 */
    public void deleteWisckoCntn(WisckoCntnVO vo) throws Exception {
        delete("wisckoCntnDAO.deleteWisckoCntn_S", vo);
    }

    /**
	 * wiscko_cntn Inquire
	 * @param vo - Inquire WisckoCntnVO
	 * @return Inquire wiscko_cntn
	 * @exception Exception
	 */
    public WisckoCntnVO selectWisckoCntn(WisckoCntnDefaultVO searchVO) throws Exception {
        return (WisckoCntnVO) selectByPk("wisckoCntnDAO.selectWisckoCntn_S", searchVO);
    }

    /**
	 * wiscko_cntn List
	 * @param searchMap - List Map
	 * @return wiscko_cntn List
	 * @exception Exception
	 */
    public List selectWisckoCntnList(WisckoCntnDefaultVO searchVO) throws Exception {
        return list("wisckoCntnDAO.selectWisckoCntnList_D", searchVO);
    }

    /**
	 * wiscko_cntn List Count
	 * @param searchMap - List Map
	 * @return wiscko_cntn Total Count
	 * @exception
	 */
    public int selectWisckoCntnListTotCnt(WisckoCntnDefaultVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("wisckoCntnDAO.selectWisckoCntnListTotCnt_S", searchVO);
    }

	public void mergeWisckoCntnLocale(WisckoArrayVO arrayVO) {
		update("wisckoCntnDAO.updateWisckoCntnLocale", arrayVO);
	}

	public List<WisckoArrayVO> selectWisckoCntnLocaleList(WisckoCntnVO vo) {
		return (List<WisckoArrayVO>)list("wisckoCntnDAO.selectWisckoCntnLocaleList", vo);
	}

	public WisckoArrayVO selectWisckoCntnLocaleView(WisckoCntnDefaultVO searchVO) {
		return (WisckoArrayVO) selectByPk("wisckoCntnDAO.selectWisckoCntnLocaleView", searchVO);
	}

	public void updateWisckoMenuCntnId(WisckoCntnVO vo) {
		update("wisckoCntnDAO.updateWisckoMenuCntnId", vo);
	}

}
