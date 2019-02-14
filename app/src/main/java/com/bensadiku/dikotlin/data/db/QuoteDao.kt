package com.bensadiku.dikotlin.data.db

import androidx.lifecycle.LiveData
import com.bensadiku.dikotlin.data.model.Quote

interface QuoteDao {

    fun addQuote(quote: Quote)

    fun getQuote(): LiveData<List<Quote>>
}