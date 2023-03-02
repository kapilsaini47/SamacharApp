package com.androiddevs.mvvmnewsapp.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.webkit.WebViewClient
import androidx.navigation.fragment.navArgs
import com.androiddevs.mvvmnewsapp.R
import com.androiddevs.mvvmnewsapp.adapter.NewsAdapter
import com.androiddevs.mvvmnewsapp.ui.NewsActivity
import com.androiddevs.mvvmnewsapp.ui.NewsViewModel
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.fragment_article.*

class ArticleFragment : Fragment(R.layout.fragment_article) {

    val args:ArticleFragmentArgs by navArgs()
    lateinit var viewModel: NewsViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = (activity as NewsActivity).viewModel

        val article = args.article
        showProgressBar()
        webView.apply {
            hideProgressBar()
            webViewClient = WebViewClient()
            article.url?.let { loadUrl(it) }
        }

        fab.setOnClickListener{
            viewModel.savedArticle(article)
            Snackbar.make(view, "Article saved successfully",Snackbar.LENGTH_SHORT).show()
        }

    }

    private fun showProgressBar(){
        art_progressBar.visibility = View.VISIBLE
    }

    private fun hideProgressBar(){
        art_progressBar.visibility = View.INVISIBLE
    }
}