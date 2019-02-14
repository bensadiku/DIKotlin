package com.bensadiku.dikotlin.data.repository

import androidx.lifecycle.LiveData
import com.bensadiku.dikotlin.data.model.Quote

interface QuoteRepository {
    fun addQuote(quote: Quote)
    fun getQuote(): LiveData<List<Quote>>
}