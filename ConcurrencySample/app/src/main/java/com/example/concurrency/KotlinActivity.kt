package com.example.concurrency

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import kotlinx.android.synthetic.main.sample.*
import kotlinx.coroutines.*

class KotlinActivity : AppCompatActivity() {

    var job: Job? = null
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.sample)

        job = GlobalScope.launch(context = Dispatchers.Main) {
            progressBar.visibility = View.VISIBLE
            val solution = solve()
            textView.text = "Answer = " + solution
            progressBar.visibility = View.INVISIBLE
        }
    }

    fun t() {
        run {
            return@run
        }
        print("Wow")
    }

    suspend fun solve() = withContext(Dispatchers.IO) {
        return@withContext TheMostImportantQuestionSolver.solve(5)
    }

    override fun onDestroy() {
        super.onDestroy()
        job?.cancel()
    }
}
