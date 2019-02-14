package com.bensadiku.dikotlin.ui.quotes

import androidx.lifecycle.ViewModel
import com.bensadiku.dikotlin.data.model.Quote
import com.bensadiku.dikotlin.data.repository.QuoteRepository

class QuotesViewModel(private val quoteRepository: QuoteRepository)
    : ViewModel() {

    fun addQuote(quote:Quote) = quoteRepository.addQuote(quote)

    fun getQuotes() = quoteRepository.getQuote()
}