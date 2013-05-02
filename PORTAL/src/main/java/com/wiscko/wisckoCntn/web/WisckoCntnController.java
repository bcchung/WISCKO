package com.wiscko.wisckoCntn.web;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.wiscko.wisckoCntn.service.WisckoCntnDefaultVO;
import com.wiscko.wisckoCntn.service.WisckoCntnService;
import com.wiscko.wisckoCntn.service.WisckoCntnVO;
import com.wiscko.wisckoUniv.service.WisckoArrayVO;
import com.wiscko.wisckoUniv.service.WisckoUnivDefaultVO;
import com.wiscko.wisckoUniv.service.WisckoUnivVO;

import egovframework.com.cmm.ComDefaultCodeVO;
import egovframework.com.cmm.EgovMessageSource;
import egovframework.com.cmm.LoginVO;
import egovframework.com.cmm.TokenMngUtil;
import egovframework.com.cmm.service.EgovCmmUseService;
import egovframework.com.cmm.util.EgovUserDetailsHelper;
import egovframework.rte.fdl.property.EgovPropertyService;
import egovframework.rte.fdl.string.EgovObjectUtil;
import egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;

/**
 * @Class Name : WisckoCntnController.java
 * @Description : WisckoCntn Controller class
 * @Modification Information
 *
 * @author bcchung
 * @since 2013-04-28
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Controller
@SessionAttributes(types=WisckoCntnVO.class)
public class WisckoCntnController {

    @Resource(name = "wisckoCntnService")
    private WisckoCntnService wisckoCntnService;
    
    /** EgovPropertyService */
    @Resource(name = "propertiesService")
    protected EgovPropertyService propertiesService;

    @Resource(name = "egovMessageSource")
    EgovMessageSource egovMessageSource;
    
    /** cmmUseService */
    @Resource(name="EgovCmmUseService")
    private EgovCmmUseService cmmUseService;
	
    /**
	 * wiscko_cntn List (pageing)
	 * @param searchVO - Inquired Infomation WisckoCntnDefaultVO
	 * @return "/wiscko/wisckoCntn/WisckoCntnList"
	 * @exception Exception
	 */
    @RequestMapping(value="/wiscko/wisckoCntn/WisckoCntnList.do")
    public String selectWisckoCntnList(@ModelAttribute("searchVO") WisckoCntnDefaultVO searchVO, 
    		ModelMap model)
            throws Exception {
    	
    	/** EgovPropertyService.sample */
    	searchVO.setPageUnit(propertiesService.getInt("pageUnit"));
    	searchVO.setPageSize(propertiesService.getInt("pageSize"));
    	
    	/** pageing */
    	PaginationInfo paginationInfo = new PaginationInfo();
		paginationInfo.setCurrentPageNo(searchVO.getPageIndex());
		paginationInfo.setRecordCountPerPage(searchVO.getPageUnit());
		paginationInfo.setPageSize(searchVO.getPageSize());
		
		searchVO.setFirstIndex(paginationInfo.getFirstRecordIndex());
		searchVO.setLastIndex(paginationInfo.getLastRecordIndex());
		searchVO.setRecordCountPerPage(paginationInfo.getRecordCountPerPage());
		
        List wisckoCntnList = wisckoCntnService.selectWisckoCntnList(searchVO);
        model.addAttribute("resultList", wisckoCntnList);
        
        int totCnt = wisckoCntnService.selectWisckoCntnListTotCnt(searchVO);
		paginationInfo.setTotalRecordCount(totCnt);
        model.addAttribute("paginationInfo", paginationInfo);
        
        return "/wiscko/wisckoCntn/WisckoCntnList";
    } 
    
    @RequestMapping("/wiscko/wisckoCntn/addWisckoCntnView.do")
    public String addWisckoCntnView(HttpServletRequest request,
            @ModelAttribute("searchVO") WisckoCntnDefaultVO searchVO, Model model)
            throws Exception {
        model.addAttribute("wisckoCntnVO", new WisckoCntnVO());

        /** 코드 조회 **/
		ComDefaultCodeVO vo = new ComDefaultCodeVO();
        vo.setCodeId("LOCALE_TC");
        model.addAttribute("localeTcList", cmmUseService.selectCmmCodeDetail(vo));
        /** 코드 조회 **/

        /* Double Submit Token Create */
        TokenMngUtil.saveToken(request);
        
        return "/wiscko/wisckoCntn/WisckoCntnRegister";
    }
    
    @RequestMapping("/wiscko/wisckoCntn/addWisckoCntn.do")
    public String addWisckoCntn(HttpServletRequest request,
            WisckoCntnVO wisckoCntnVO,
            @ModelAttribute("searchVO") WisckoCntnDefaultVO searchVO, SessionStatus status, ModelMap model)
            throws Exception {

        /* Double Submit Token Check */
        if(!TokenMngUtil.isTokenValid(request)) {
            model.addAttribute("message", egovMessageSource.getMessage("errors.reflesh.notPermit"));
            return "uat/uia/EgovLoginUsr";
        }
        
        /** 로그인 사용자 정보, 존재하지 않을 경우 anonymous 처리 **/
		LoginVO user;
		if (EgovUserDetailsHelper.isAuthenticated()) {
			user = (LoginVO) EgovUserDetailsHelper.getAuthenticatedUser();
		} else {
			user = new LoginVO();
			user.setUniqId("anonymous");
		}
		/** 로그인 사용자 정보, 존재하지 않을 경우 anonymous 처리 **/
		
		wisckoCntnVO.setFrstRegisterId(user.getUniqId());
        wisckoCntnService.insertWisckoCntn(wisckoCntnVO);
        status.setComplete();

        /* Double Submit Token Init */
        TokenMngUtil.resetToken(request);

        return "forward:/wiscko/wisckoCntn/WisckoCntnList.do";
    }
    
    @RequestMapping("/wiscko/wisckoCntn/updateWisckoCntnView.do")
    public String updateWisckoCntnView(HttpServletRequest request,
            @ModelAttribute("searchVO") WisckoCntnDefaultVO searchVO, Model model)
            throws Exception {
    	
        WisckoCntnVO resultVO = wisckoCntnService.selectWisckoCntn(searchVO);
		model.addAttribute("wisckoCntnVO", resultVO);
		
        /** 코드 조회 **/
		ComDefaultCodeVO vo = new ComDefaultCodeVO();
        
        if(EgovObjectUtil.isNull(resultVO.getLocaleArray())) {
	        vo.setCodeId("LOCALE_TC");
	        model.addAttribute("localeTcList", cmmUseService.selectCmmCodeDetail(vo));
	        model.addAttribute("cntnYn", "N");
        } else {
        	model.addAttribute("localeArray", resultVO.getLocaleArray());
        	model.addAttribute("cntnYn", "Y");
        }
        /** 코드 조회 **/
        
        /* Double Submit Token Create */
        TokenMngUtil.saveToken(request);
        
        return "/wiscko/wisckoCntn/WisckoCntnRegister";
    }

    @RequestMapping("/wiscko/wisckoCntn/updateWisckoCntn.do")
    public String updateWisckoCntn(HttpServletRequest request,
            WisckoCntnVO wisckoCntnVO,
            @ModelAttribute("searchVO") WisckoCntnDefaultVO searchVO, SessionStatus status, ModelMap model)
            throws Exception {

        /* Double Submit Token Check */
        if(!TokenMngUtil.isTokenValid(request)) {
            model.addAttribute("message", egovMessageSource.getMessage("errors.reflesh.notPermit"));
            return "uat/uia/EgovLoginUsr";
        }
        
        /** 로그인 사용자 정보, 존재하지 않을 경우 anonymous 처리 **/
		LoginVO user;
		if (EgovUserDetailsHelper.isAuthenticated()) {
			user = (LoginVO) EgovUserDetailsHelper.getAuthenticatedUser();
		} else {
			user = new LoginVO();
			user.setUniqId("anonymous");
		}
		/** 로그인 사용자 정보, 존재하지 않을 경우 anonymous 처리 **/
		
		wisckoCntnVO.setLastUpdusrId(user.getUniqId());
        wisckoCntnService.updateWisckoCntn(wisckoCntnVO);
        status.setComplete();

        /* Double Submit Token Init */
        TokenMngUtil.resetToken(request);

        return "forward:/wiscko/wisckoCntn/WisckoCntnList.do";
    }
    
    @RequestMapping("/wiscko/wisckoCntn/selectWisckoCntn.do")
    public @ModelAttribute("wisckoCntnVO")
    WisckoCntnVO selectWisckoCntn(
            WisckoCntnVO wisckoCntnVO,
            @ModelAttribute("searchVO") WisckoCntnDefaultVO searchVO) throws Exception {
        return wisckoCntnService.selectWisckoCntn(wisckoCntnVO);
    }
    
	@RequestMapping("/wiscko/wisckoCntn/selectWisckoCntnLocaleView.do")
	public String selectWisckoCntnLocaleView(@RequestParam(value="cntnId", required=false) String cntnId, Model model)
			throws Exception {
		WisckoCntnDefaultVO searchVO = new WisckoCntnDefaultVO();
		searchVO.setCntnId(cntnId);
		
		WisckoArrayVO resultVO = wisckoCntnService.selectWisckoCntnLocaleView(searchVO);
		model.addAttribute("resultVO", resultVO);
		
		return "/wiscko/wisckoCntn/WisckoCntnLocaleView";
	}
    
    @RequestMapping("/wiscko/wisckoCntn/deleteWisckoCntn.do")
    public String deleteWisckoCntn(
            WisckoCntnVO wisckoCntnVO,
            @ModelAttribute("searchVO") WisckoCntnDefaultVO searchVO, SessionStatus status)
            throws Exception {
        wisckoCntnService.deleteWisckoCntn(wisckoCntnVO);
        status.setComplete();
        return "forward:/wiscko/wisckoCntn/WisckoCntnList.do";
    }

}
