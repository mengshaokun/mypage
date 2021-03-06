package com.mypage.controller;

import com.alibaba.excel.EasyExcel;
import com.github.pagehelper.PageInfo;
import com.mypage.common.Response;
import com.mypage.entity.CodeLibrary;
import com.mypage.entity.LinkCategory;
import com.mypage.entity.LinkInfoExport;
import com.mypage.entity.User;
import com.mypage.model.request.LinkInfoReq;
import com.mypage.model.request.ModifyLinkInfoReq;
import com.mypage.model.response.UserLinkInfoResp;
import com.mypage.service.LinkInfoService;
import com.mypage.service.UtilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;

/**
 * Created by mengsk on 2019/6/14.
 *
 * 链接信息相关
 */
@Controller
@RequestMapping("/personal/linkInfo")
public class LinkInfoController {

    @Autowired
    private LinkInfoService linkInfoService;
    @Autowired
    private UtilService utilService;

    @Value("${user.session.key}")
    private String userSessionKey;


    @RequestMapping(value = "/toLinkInfo")
    public String toLinkInfo(@RequestParam(name = "pageNum", defaultValue = "1")Integer pageNum, Model model, HttpSession session) {
        //根据userid获取用户所有的链接信息
        User user = (User) session.getAttribute(userSessionKey);
        List<UserLinkInfoResp> userLinkInfo = linkInfoService.getUserLinkInfo(user.getId(), pageNum);
        PageInfo<UserLinkInfoResp> page = new PageInfo<>(userLinkInfo);
        //获取所有的链接分类信息
        List<LinkCategory> linkCategoryList = utilService.getLinkCategoryList();
        //获取状态信息
        List<CodeLibrary> codeLibraryList = utilService.getCodeLibraryByCodeNo("status");

        model.addAttribute("userLinkInfo", userLinkInfo);
        model.addAttribute("linkCategoryList", linkCategoryList);
        model.addAttribute("codeLibraryList", codeLibraryList);
        model.addAttribute("page", page);
        return "linkInfo";
    }

    @RequestMapping(value = "/removeLinkInfo/{id}", method = RequestMethod.GET)
    public String removeLinkInfo(@PathVariable("id") Integer id) {
        linkInfoService.removeLinkUrl(id);
        return "redirect:/personal/linkInfo/toLinkInfo";
    }

    @RequestMapping(value = "/addLinkInfo", method = RequestMethod.POST)
    public String addLinkInfo(@Validated LinkInfoReq linkInfoReq, BindingResult bindingResult) {
        linkInfoService.addLinkInfo(linkInfoReq);
        return "redirect:/personal/linkInfo/toLinkInfo";
    }

    @RequestMapping(value = "/modifyLinkInfo", method = RequestMethod.POST)
    @ResponseBody
    public Response modifyLinkInfo(@Validated ModifyLinkInfoReq modifyLinkInfoReq, BindingResult bindingResult, HttpSession session) {
        if (bindingResult.hasErrors()) {
            return Response.FAIL(bindingResult.getAllErrors().get(0).getDefaultMessage());
        }
        User user = (User) session.getAttribute(userSessionKey);
        return linkInfoService.modifyLinkInfo(user, modifyLinkInfoReq);
    }

    @RequestMapping(value = "/exportLinkInfo")
    public void exportLinkInfo(HttpServletRequest request, HttpServletResponse response) throws Exception {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute(userSessionKey);
        List<LinkInfoExport> linkInfoExports = linkInfoService.exportLinkInfo(user.getId());

        response.setContentType("application/vnd.ms-excel");
        response.setCharacterEncoding("utf-8");
        String fileName = URLEncoder.encode("链接信息", "UTF-8");
        response.setHeader("Content-disposition", "attachment;filename=" + fileName + ".xlsx");
        EasyExcel.write(response.getOutputStream(), LinkInfoExport.class).sheet("链接信息").doWrite(linkInfoExports);
    }



}
