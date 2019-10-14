package com.mypage.controller;

import com.mypage.annotation.ArticleReSubmit;
import com.mypage.common.Response;
import com.mypage.entity.Article;
import com.mypage.entity.User;
import com.mypage.service.ArticleService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by mengsk on 2019/10/10.
 */
@Controller
@RequestMapping("/article")
public class ArticleController {

    @Value("${user.session.key}")
    private String userSessionKey;

    @Resource
    private ArticleService articleService;

    /**
     *
     * @return
     */
    @RequestMapping("/toAddArticle")
    public String toAddArticle() {
        return "article/addArticle";
    }

    @RequestMapping("/addArticle")
    @ResponseBody
    @ArticleReSubmit
    public Response addArticle(Article article, HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute(userSessionKey);
        return articleService.addArticle(article, user);
    }

    @RequestMapping("/articleList")
    public String articleList(Model model, HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute(userSessionKey);
        List<Article> articleList = articleService.getArticleList(user.getId());
        model.addAttribute("articleList", articleList);
        return "article/articleList";
    }

    @RequestMapping("/removeArticle/{id}")
    public String removeArticle(@PathVariable("id") Integer id) {
        articleService.removeArticle(id);
        return "redirect:/article/articleList";
    }

    @RequestMapping("/showArticle/{id}")
    public String showArticle(@PathVariable("id") Integer articleId, Model model) {
        Article article = articleService.getArticleById(articleId);
        model.addAttribute("article", article);
        return "article/articleDetail";
    }
















}
