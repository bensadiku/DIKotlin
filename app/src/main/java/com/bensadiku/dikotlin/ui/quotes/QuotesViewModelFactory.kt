package com.bensadiku.dikotlin.ui.quotes

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.bensadiku.dikotlin.data.repository.QuoteRepository

@Suppress("UNCHECKED_CAST")
class QuotesViewModelFactory(private  val quoteRepository: QuoteRepository)
    :ViewModelProvider.NewInstanceFactory(){


    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return QuotesViewModel(quoteRepository) as T
    }
}