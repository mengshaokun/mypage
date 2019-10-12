package com.mypage.service.serviceimpl;

import com.mypage.common.CommonContent;
import com.mypage.common.Response;
import com.mypage.dao.ArticleDao;
import com.mypage.entity.Article;
import com.mypage.entity.User;
import com.mypage.service.ArticleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * Created by mengsk on 2019/10/12.
 */
@Service
@Slf4j
public class ArticleServiceImpl implements ArticleService {

    @Resource
    private ArticleDao articleDao;

    @Override
    public Response addArticle(Article article, User user) {
        try {
            article.setAuthor(user.getId());
            article.setInsertTime(new Date());
            articleDao.insertArticle(article);
        } catch (Exception e) {
            log.error("文章添加失败：{}", e.getMessage());
            e.printStackTrace();
            return Response.FAIL(CommonContent.ARTICLE_ADD_ERROR);
        }
        return Response.SUCCESS(CommonContent.ARTICLE_ADD_SUCCESS);

    }

    @Override
    public List<Article> getArticleList(Integer userId) {
        List<Article> articleList = articleDao.selectArtilceList(userId);
        return articleList;
    }

    @Override
    public void removeArticle(Integer id) {
        articleDao.deleteArticle(id);
    }

    @Override
    public Article getArticleById(Integer articleId) {
        Article article = articleDao.selectArticleById(articleId);
        return article;
    }
}
