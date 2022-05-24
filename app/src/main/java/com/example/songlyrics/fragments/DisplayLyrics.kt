package com.example.songlyrics.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.navArgs
import com.example.songlyrics.R
import com.example.songlyrics.databinding.FragmentDisplayLyricsBinding
import com.example.songlyrics.model.Hits
import com.koushikdutta.ion.Ion
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO_PARALLELISM_PROPERTY_NAME
import kotlinx.coroutines.launch
import org.jsoup.Jsoup

class DisplayLyrics : Fragment() {

    lateinit var displayLyricsBinding: FragmentDisplayLyricsBinding
    private val args: DisplayLyricsArgs by navArgs()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        displayLyricsBinding = FragmentDisplayLyricsBinding.inflate(inflater, container, false)
        return displayLyricsBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        displayLyricsBinding.lyricsUrl.apply {
            displayLyricsBinding.progressBar.visibility = View.VISIBLE
            loadUrl(args.lyricsURL)
            settings.javaScriptEnabled = true
            settings.setSupportZoom(true)
            displayLyricsBinding.progressBar.visibility = View.GONE
        }

//        lifecycleScope.launch(Dispatchers.IO) {
//            Ion.with(context)
//                .load(args.lyricsURL)
//                .asString()
//                .setCallback { e, result ->
//                    Log.d("telina", "show lyrics: $e ")
//                    Log.d("telina", "show lyrics: $result ")
//                }
//        }



//        lifecycleScope.launch(Dispatchers.IO) {
//
//            val jsoupStore = Jsoup.connect(args.lyricsURL)
//                .userAgent("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_9_2) AppleWebode some module that change thKit/537.36 (KHTML, like Gecko) Chrome/33.0.1750.152 Safari/537.36")
//                .timeout(10000)
//                .get()
//            val showlyrics = jsoupStore.getElementById("data-lyrics-container")
//            val showlyrics2 = jsoupStore.getElementById("Lyrics__Container-sc-1ynbvzw-6 jYfhrf")
//
//            Log.d("telina", "show lyrics 1: $showlyrics ")
//            Log.d("telina", "show lyrics 1: $showlyrics2")
//        }
    }
}