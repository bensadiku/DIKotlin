package com.bensadiku.dikotlin.data.repository

import androidx.lifecycle.LiveData
import com.bensadiku.dikotlin.data.db.QuoteDao
import com.bensadiku.dikotlin.data.model.Quote

class QuoteRepositoryImpl(private val quoteDao: QuoteDao)
    :QuoteRepository {

    override fun addQuote(quote: Quote) {
        quoteDao.addQuote(quote)
    }

    override fun getQuote() = quoteDao.getQuote()

}