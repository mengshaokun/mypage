package com.mypage.controller;

import com.baidu.ueditor.ActionEnter;
import org.springframework.stereotype.Controller;
import org.springframework.util.ClassUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by mengsk on 2019/10/10.
 */
@Controller
public class UEditorController {

    @RequestMapping("/config")
    public void config(HttpServletRequest request, HttpServletResponse response, MultipartFile multipartFile) {
        response.setContentType("application/json");
        String rootPath = ClassUtils.getDefaultClassLoader().getResource("").getPath() + "static/ueditor/jsp";
//        System.out.println("===================="+rootPath);
        String action = request.getParameter("action");
        System.out.println("===================="+action);
//        if ("uploadimage".equals(action)) {
//            System.out.println("===================="+multipartFile.getName());
//        }
        try {
            response.setCharacterEncoding("UTF-8");
            String exec = new ActionEnter(request, rootPath).exec();
            System.out.println(exec);
            PrintWriter writer = response.getWriter();
            writer.write(new ActionEnter(request, rootPath).exec());
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
