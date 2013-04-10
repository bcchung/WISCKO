package com.wiscko.wisckoUniv.web;

import java.util.List;
import java.util.Map;

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
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.wiscko.wisckoUniv.service.WisckoUnivDefaultVO;
import com.wiscko.wisckoUniv.service.WisckoUnivService;
import com.wiscko.wisckoUniv.service.WisckoUnivVO;

import egovframework.com.cmm.EgovMessageSource;
import egovframework.com.cmm.LoginVO;
import egovframework.com.cmm.TokenMngUtil;
import egovframework.com.cmm.service.EgovFileMngService;
import egovframework.com.cmm.service.EgovFileMngUtil;
import egovframework.com.cmm.service.FileVO;
import egovframework.com.cmm.util.EgovUserDetailsHelper;
import egovframework.rte.fdl.property.EgovPropertyService;
import egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;

/**
 * @Class Name : WisckoUnivController.java
 * @Description : WisckoUniv Controller class
 * @Modification Information
 * 
 * @author bcchung
 * @since 2013-04-08
 * @version 1.0
 * @see Copyright (C) All right reserved.
 */

@Controller
@SessionAttributes(types = WisckoUnivVO.class)
public class WisckoUnivController {

	@Resource(name = "wisckoUnivService")
	private WisckoUnivService		wisckoUnivService;

	/** EgovPropertyService */
	@Resource(name = "propertiesService")
	protected EgovPropertyService	propertiesService;

	@Resource(name = "egovMessageSource")
	EgovMessageSource				egovMessageSource;

	@Resource(name = "EgovFileMngService")
	private EgovFileMngService		fileMngService;

	@Resource(name = "EgovFileMngUtil")
	private EgovFileMngUtil			fileUtil;

	private String					storePath;

	/**
	 * wiscko_univ List (pageing)
	 * 
	 * @param searchVO
	 *            - Inquired Infomation WisckoUnivDefaultVO
	 * @return "/wiscko/wisckoUniv/WisckoUnivList"
	 * @exception Exception
	 */
	@RequestMapping(value = "/wiscko/wisckoUniv/WisckoUnivList.do")
	public String selectWisckoUnivList(@ModelAttribute("searchVO") WisckoUnivDefaultVO searchVO, ModelMap model)
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

		List wisckoUnivList = wisckoUnivService.selectWisckoUnivList(searchVO);
		model.addAttribute("resultList", wisckoUnivList);

		int totCnt = wisckoUnivService.selectWisckoUnivListTotCnt(searchVO);
		paginationInfo.setTotalRecordCount(totCnt);
		model.addAttribute("paginationInfo", paginationInfo);

		return "/wiscko/wisckoUniv/WisckoUnivList";
	}

	@RequestMapping("/wiscko/wisckoUniv/addWisckoUnivView.do")
	public String addWisckoUnivView(HttpServletRequest request,
			@ModelAttribute("searchVO") WisckoUnivDefaultVO searchVO, Model model) throws Exception {
		model.addAttribute("wisckoUnivVO", new WisckoUnivVO());

		/* 중복방지 Token 생성 */
		TokenMngUtil.saveToken(request);

		return "/wiscko/wisckoUniv/WisckoUnivRegister";
	}

	@RequestMapping("/wiscko/wisckoUniv/addWisckoUniv.do")
	public String addWisckoUniv(final MultipartHttpServletRequest multiRequest, HttpServletRequest request,
			WisckoUnivVO wisckoUnivVO, @ModelAttribute("searchVO") WisckoUnivDefaultVO searchVO, SessionStatus status,
			ModelMap model) throws Exception {

		/* 중복방지 Token 체크 */
		if (!TokenMngUtil.isTokenValid(request)) {
			model.addAttribute("message", egovMessageSource.getMessage("errors.reflesh.notPermit"));
			return "forward:/wiscko/wisckoUniv/WisckoUnivList.do";
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
		
		
		//저장경로 지정
		storePath = propertiesService.getString("Globals.thumnailfileStorePath") + "/UNIV/";

		final Map<String, MultipartFile> files = multiRequest.getFileMap();
		String atchFileId = "";

		if (!files.isEmpty()) {
			List<FileVO> result = fileUtil.parseFileInf(files, "UNIV_", 0, "", storePath);
			atchFileId = fileMngService.insertFileInfs(result);
		}

		wisckoUnivVO.setUnivLogo(atchFileId);
		wisckoUnivVO.setFrstRegisterId(user.getUniqId());
		wisckoUnivService.insertWisckoUniv(wisckoUnivVO);
		status.setComplete();

		/* 중복방지 Token 초기화 */
		TokenMngUtil.resetToken(request);

		return "forward:/wiscko/wisckoUniv/WisckoUnivList.do";
	}

	@RequestMapping("/wiscko/wisckoUniv/updateWisckoUnivView.do")
	public String updateWisckoUnivView(HttpServletRequest request, @RequestParam("univId") String univId,
			@ModelAttribute("searchVO") WisckoUnivDefaultVO searchVO, Model model) throws Exception {

		/* 중복방지 Token 생성 */
		TokenMngUtil.saveToken(request);

		WisckoUnivVO wisckoUnivVO = new WisckoUnivVO();
		wisckoUnivVO.setUnivId(univId);
		model.addAttribute(selectWisckoUniv(wisckoUnivVO, searchVO));
		return "/wiscko/wisckoUniv/WisckoUnivRegister";
	}

	@RequestMapping("/wiscko/wisckoUniv/updateWisckoUniv.do")
	public String updateWisckoUniv(HttpServletRequest request, final MultipartHttpServletRequest multiRequest,
			WisckoUnivVO wisckoUnivVO, @ModelAttribute("searchVO") WisckoUnivDefaultVO searchVO, SessionStatus status,
			ModelMap model) throws Exception {

		/* 중복방지 Token 체크 */
		if (!TokenMngUtil.isTokenValid(request)) {
			model.addAttribute("message", egovMessageSource.getMessage("errors.reflesh.notPermit"));
			return "forward:/wiscko/wisckoUniv/WisckoUnivList.do";
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
		
		
		//저장경로 지정
		storePath = propertiesService.getString("Globals.thumnailfileStorePath") + "/UNIV/";

		String atchFileId = wisckoUnivVO.getUnivLogo();

		final Map<String, MultipartFile> files = multiRequest.getFileMap();
		if (!files.isEmpty()) {
			if ("".equals(atchFileId)) {
				List<FileVO> result = fileUtil.parseFileInf(files, "UNIV_", 0, atchFileId, storePath);
				atchFileId = fileMngService.insertFileInfs(result);
				wisckoUnivVO.setUnivLogo(atchFileId);
			} else {
				FileVO fvo = new FileVO();
				fvo.setAtchFileId(atchFileId);
				int cnt = fileMngService.getMaxFileSN(fvo);
				List<FileVO> _result = fileUtil.parseFileInf(files, "UNIV_", cnt, atchFileId, storePath);
				fileMngService.updateFileInfs(_result);
			}
		}

		wisckoUnivVO.setLastUpdusrId(user.getUniqId());
		wisckoUnivService.updateWisckoUniv(wisckoUnivVO);
		// status.setComplete();

		/* 중복방지 Token 초기화 */
		TokenMngUtil.resetToken(request);

		return "forward:/wiscko/wisckoUniv/WisckoUnivList.do";
	}

	@RequestMapping("/wiscko/wisckoUniv/selectWisckoUniv.do")
	public @ModelAttribute("wisckoUnivVO")
	WisckoUnivVO selectWisckoUniv(WisckoUnivVO wisckoUnivVO, @ModelAttribute("searchVO") WisckoUnivDefaultVO searchVO)
			throws Exception {
		return wisckoUnivService.selectWisckoUniv(wisckoUnivVO);
	}

	@RequestMapping("/wiscko/wisckoUniv/deleteWisckoUniv.do")
	public String deleteWisckoUniv(WisckoUnivVO wisckoUnivVO, @ModelAttribute("searchVO") WisckoUnivDefaultVO searchVO,
			SessionStatus status) throws Exception {
		wisckoUnivService.deleteWisckoUniv(wisckoUnivVO);
		status.setComplete();
		return "redirect:/wiscko/wisckoUniv/WisckoUnivList.do";
	}

}