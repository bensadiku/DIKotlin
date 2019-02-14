package com.bensadiku.dikotlin

import android.app.Application
import com.bensadiku.dikotlin.data.db.Database
import com.bensadiku.dikotlin.data.db.DatabaseFakeImpl
import com.bensadiku.dikotlin.data.db.QuoteDao
import com.bensadiku.dikotlin.data.repository.QuoteRepository
import com.bensadiku.dikotlin.data.repository.QuoteRepositoryImpl
import com.bensadiku.dikotlin.ui.quotes.QuotesViewModelFactory
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider
import org.kodein.di.generic.singleton

class QuotesApplication : Application(), KodeinAware {
    override val kodein = Kodein.lazy {

        bind<Database>() with singleton { DatabaseFakeImpl() }
        bind<QuoteDao>() with singleton { instance<Database>().quoteDao }
        bind<QuoteRepository> ()with singleton { QuoteRepositoryImpl(instance())}
        bind() from provider { QuotesViewModelFactory(instance()) }
    }
}