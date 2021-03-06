package egovframework.let.uss.olp.qim.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import egovframework.com.cmm.ComDefaultVO;
import egovframework.let.uss.olp.qim.service.EgovQustnrItemManageService;
import egovframework.let.uss.olp.qim.service.QustnrItemManageVO;
import egovframework.rte.fdl.cmmn.AbstractServiceImpl;
import egovframework.rte.fdl.idgnr.EgovIdGnrService;
/**
 * 설문항목관리를 처리하는 ServiceImpl Class 구현
 * @author 공통서비스 장동한
 * @since 2009.03.20
 * @version 1.0
 * @see
 *
 * <pre>
 * << 개정이력(Modification Information) >>
 *   
 *   수정일      수정자           수정내용
 *  -------    --------    ---------------------------
 *   2009.03.20  장동한          최초 생성
 *   2011.08.31  JJY            경량환경 템플릿 커스터마이징버전 생성
 *
 * </pre>
 */
@Service("egovQustnrItemManageService")
public class EgovQustnrItemManageServiceImpl extends AbstractServiceImpl implements EgovQustnrItemManageService{

	@Resource(name="qustnrItemManageDao")
	private QustnrItemManageDao dao;
	
	@Resource(name="egovQustnrItemManageIdGnrService")
	private EgovIdGnrService idgenService;
	
    /**
	 * 설문템플릿(을)를  목록을 조회한다. 
	 * @param qustnrItemManageVO - 설문항목 정보 담김 VO
	 * @return List
	 * @throws Exception
	 */	
	@SuppressWarnings("unchecked")
	public List selectQustnrTmplatManageList(QustnrItemManageVO qustnrItemManageVO) throws Exception{
		return (List)dao.selectQustnrTmplatManageList(qustnrItemManageVO);
	}
	
	
    /**
	 * 설문항목 목록을 조회한다. 
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return List
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public List selectQustnrItemManageList(ComDefaultVO searchVO) throws Exception{
		return (List)dao.selectQustnrItemManageList(searchVO);
	}
	
    /**
	 * 설문항목를(을) 상세조회 한다.
	 * @param QustnrItemManage - 회정정보가 담김 VO
	 * @return List
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public List selectQustnrItemManageDetail(QustnrItemManageVO qustnrItemManageVO) throws Exception{
		return (List)dao.selectQustnrItemManageDetail(qustnrItemManageVO);
	}
	
    /**
	 * 설문항목를(을) 목록 전체 건수를(을) 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return int
	 * @throws Exception
	 */
	public int selectQustnrItemManageListCnt(ComDefaultVO searchVO) throws Exception{
		return (Integer)dao.selectQustnrItemManageListCnt(searchVO);
	}

    /**
	 * 설문항목를(을) 등록한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @throws Exception
	 */
	public void insertQustnrItemManage(QustnrItemManageVO qustnrItemManageVO) throws Exception {
		String sMakeId = idgenService.getNextStringId();
		
		qustnrItemManageVO.setQustnrIemId(sMakeId); 

		dao.insertQustnrItemManage(qustnrItemManageVO);
	}
	
    /**
	 * 설문항목를(을) 수정한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @throws Exception
	 */
	public void updateQustnrItemManage(QustnrItemManageVO qustnrItemManageVO) throws Exception{
		dao.updateQustnrItemManage(qustnrItemManageVO);
	}
	
    /**
	 * 설문항목를(을) 삭제한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @throws Exception
	 */
	public void deleteQustnrItemManage(QustnrItemManageVO qustnrItemManageVO) throws Exception{
		dao.deleteQustnrItemManage(qustnrItemManageVO);
	}
}
