package com.mypage.controller;

import com.mypage.common.Response;
import com.mypage.model.request.LinkInfoReq;
import com.mypage.service.LinkInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by mengsk on 2019/6/14.
 *
 * 链接信息相关
 */
@Controller
@RequestMapping("/linkInfo")
public class LinkInfoController {

    @Autowired
    private LinkInfoService linkInfoService;

    /**
     * 添加链接信息
     * @param linkInfoReq
     * @param bindingResult
     * @return
     */
    @RequestMapping(value = "/addLinkInfo", method = RequestMethod.POST)
    @ResponseBody
    public Response addLinkInfo(@Validated LinkInfoReq linkInfoReq, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return Response.FAIL(bindingResult.getAllErrors().get(0).getDefaultMessage());
        }
        return linkInfoService.addLinkInfo(linkInfoReq);
    }

    /**
     * 修改链接信息
     * @param linkInfoReq
     * @param bindingResult
     * @return
     */
    @RequestMapping(value = "/modifyLinkInfo", method = RequestMethod.POST)
    @ResponseBody
    public Response modifyLinkInfo(@Validated LinkInfoReq linkInfoReq, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return Response.FAIL(bindingResult.getAllErrors().get(0).getDefaultMessage());
        }
        return linkInfoService.modifyLinkInfo(linkInfoReq);
    }
}
