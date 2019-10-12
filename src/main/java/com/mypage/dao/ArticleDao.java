package com.mypage.dao;

import com.mypage.entity.Article;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by mengsk on 2019/10/12.
 */
public interface ArticleDao {

    void insertArticle(@Param("article") Article article);

    List<Article> selectArtilceList(@Param("author") Integer author);

    void deleteArticle(@Param("id") Integer id);

    Article selectArticleById(@Param("articleId") Integer articleId);
}
