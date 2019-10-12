package com.mypage.service;

import com.mypage.common.Response;
import com.mypage.entity.Article;
import com.mypage.entity.User;

import java.util.List;

/**
 * Created by mengsk on 2019/10/12.
 */
public interface ArticleService {

    Response addArticle(Article article, User user);

    List<Article> getArticleList(Integer userId);

    void removeArticle(Integer id);

    Article getArticleById(Integer articleId);

}
