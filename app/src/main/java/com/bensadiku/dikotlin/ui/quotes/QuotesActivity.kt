package com.bensadiku.dikotlin.ui.quotes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.bensadiku.dikotlin.R
import com.bensadiku.dikotlin.data.model.Quote
import kotlinx.android.synthetic.main.activity_main.*
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.closestKodein
import org.kodein.di.generic.instance
import java.lang.StringBuilder

class QuotesActivity : AppCompatActivity(),KodeinAware {

    override val kodein by closestKodein()

    private val viewModelFactory:QuotesViewModelFactory by instance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initializeUi()
    }

    private fun initializeUi(){
        val viewModel = ViewModelProviders.of(this, viewModelFactory)
            .get(QuotesViewModel::class.java)


        viewModel.getQuotes().observe(this, Observer { quotes ->
            val stringBuilder = StringBuilder()

            quotes.forEach { quote ->
                stringBuilder.append("$quote\n\n")
            }
            textView_quotes.text = stringBuilder.toString()
        })

        button_add_quote.setOnClickListener {
            val quote = Quote(editText_quote.text.toString(),editText_author.text.toString())
            viewModel.addQuote(quote)
            editText_author.setText("")
            editText_quote.setText("")
        }
    }
}
