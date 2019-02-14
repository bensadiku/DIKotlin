package com.bensadiku.dikotlin.data.db

class DatabaseFakeImpl : Database {

    override val quoteDao: QuoteDao = QuoteDaoFakeImpl()


}
