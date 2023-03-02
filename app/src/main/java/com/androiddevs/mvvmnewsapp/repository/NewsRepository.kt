package com.androiddevs.mvvmnewsapp.repository

import com.androiddevs.mvvmnewsapp.api.RetrofitInstance
import com.androiddevs.mvvmnewsapp.db.ArticleDatabase
import com.androiddevs.mvvmnewsapp.models.Article
import retrofit2.Retrofit

class NewsRepository(
    val articleDatabase: ArticleDatabase
) {
    //using coroutines for network calls
    suspend fun getBreakingNews(countryCode:String, pageNumber:Int)=
        RetrofitInstance.api.getBreakingNews(countryCode,pageNumber)

    suspend fun searchNews(searchQuery:String, pageNumber: Int) =
        RetrofitInstance.api.searchForNews(searchQuery, pageNumber)

    suspend fun saveArticle(article: Article) =
        articleDatabase.getArticleDao().upsert(article)

    fun getAllArticle() =
        articleDatabase.getArticleDao().getAllArticles()

    suspend fun deleteArticle(article: Article) =
        articleDatabase.getArticleDao().deleteArticle(article)


}