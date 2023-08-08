package com.example.foodrecipeapp.data.repo.source.remote.fetchjson

import android.os.Handler
import android.os.Looper
import com.example.foodrecipeapp.constant.Constant
import com.example.foodrecipeapp.listener.OnResultListener
import org.json.JSONObject
import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.StringBuilder
import java.net.HttpURLConnection
import java.net.URL
import java.util.concurrent.Executors

class GetJsonFromUrl<T> constructor(
    private val urlString: String,
    private val keyEntity: String,
    private val listener: OnResultListener<T>
) {

    private val executor = Executors.newSingleThreadExecutor()
    private val handler = Handler(Looper.getMainLooper())
    private var exception: Exception? = null
    private var data: T? = null

    init {
        callAPI()
    }

    private fun callAPI() {
        executor.execute {
            val responseJson = getJsonFromUrl(urlString + Constant.BASE_API_KEY)
            data = ParseDataWithJson().parseJsonToData(JSONObject(responseJson), keyEntity) as? T
            handler.post {
                try {
                    data?.let { listener.onSuccess(it) }
                } catch (e: Exception) {
                    listener.onError(exception)
                }
            }
        }
    }

    private fun getJsonFromUrl(urlString: String): String {
        val url = URL(urlString)
        val httpUrlConnection = url.openConnection() as? HttpURLConnection
        httpUrlConnection?.run {
            connectTimeout = TIME_OUT
            readTimeout = TIME_OUT
            requestMethod = METHOD_GET
            doOutput = true
            connect()
        }

        val bufferedReader = BufferedReader(InputStreamReader(url.openStream()))
        val stringBuilder = StringBuilder()
        var line: String?
        while (bufferedReader.readLine().also { line = it } != null) {
            stringBuilder.append(line)
        }
        bufferedReader.close()
        httpUrlConnection?.disconnect()
        return stringBuilder.toString()
    }

    companion object {
        private const val TIME_OUT = 15000
        private const val METHOD_GET = "GET"
    }
}
