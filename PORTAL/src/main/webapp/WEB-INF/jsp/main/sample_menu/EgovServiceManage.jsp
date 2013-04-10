<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
</head>
<body>

<!--  타이틀 이미지 시작 -->
<div id="title_img_div"><img src="<c:url value='/'/>images/title_image/img_title02.gif" alt="" /></div>
<!--  //타이틀 이미지 끝 -->
<!-- 현재위치 네비게이션 시작 -->
<div id="cur_loc">
        <div id="cur_loc_align">
            <ul>
                <li>HOME</li>
                <li>&gt;</li>
                <li>민원광장</li>
                <li>&gt;</li>
                <li><strong>민원신청내역</strong></li>
            </ul>
        </div>
</div>
<div id="content_field">
    <div><h2>민원신청내역</h2></div>
    <p>※7일 이전의 신청내용은 검색기간을 입력한 후 확인하시기 바랍니다.</p>
    <div class="search_service">
        <div class="search_area">                   
            <form action="" name="" id="SubTopSearch" method="post">
                <span class="search_txt">기간별 검색</span>
                <select id="subsearch" name="subsearch" style="width:70px;">
                <option value="">2011</option>
                </select>
                <select id="subsearch" name="subsearch" style="width:50px;">
                <option value="">08</option>
                </select>
                <select id="subsearch" name="subsearch" style="width:50px;">
                <option value="">21</option>
                </select>
                <span class="search_txt">부터~</span>
                <select id="subsearch" name="subsearch">
                <option value="">2011</option>
                </select>
                <select id="subsearch" name="subsearch">
                <option value="">08</option>
                </select>
                <select id="subsearch" name="subsearch">
                <option value="">21</option>
                </select><span class="search_txt">까지</span>
                <button class="btnSearch" title="검색" type="submit"></button>                
            </form>                     
        </div>              
    </div>
</div>
<div class="search_result_div">
<table summary="" cellpadding="0" cellspacing="0">
        <caption></caption>
        <colgroup>
        <col width="160" /> 
        <col width="200" />  
        <col width="60" />
        <col width="" />
        <col width="" />
        <col width="100" />
        <col width="70" />
        </colgroup>
        <thead>
        <tr>
            <th>민원접수번호[신청일]</th>
            <th>민원사무명</th>
            <th>부수</th>
            <th>처리상태</th>
            <th>교부기관</th>
            <th>연락처</th>
            <th>추가신청</th>
        </tr>
        </thead>
        <tbody>                 
        <!-- loop 시작 -->                                
        <tr>
            <td>2011-08-11</td>
            <td>표준프레임워크 인증서 발급</td>
            <td>300</td>
            <td>발급대기</td>
            <td>행정안전부</td>
            <td>1544-5555</td>
            <td>신청</td>
        </tbody>
        </table>    
</div>
<!-- 페이지 네비게이션 시작 -->
<div id="paging_div">
    <ul class="paging_align">
        <li class="first"><img src="<c:url value='/'/>images/btn_prev.gif" alt="prev" /></li>
        <li><a href="#">1</a></li>
        <li>2</li>
        <li>3</li>
        <li>4</li>
        <li>5</li>
        <li class="first"><img src="<c:url value='/'/>images/btn_next.gif" alt="next" /></li>
    </ul>
</div>  
<!-- //페이지 네비게이션 끝 -->
</body>
</html>