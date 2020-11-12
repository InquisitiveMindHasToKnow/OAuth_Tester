package org.ohmstheresistance.oauth_tester

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import org.ohmstheresistance.oauth_tester.data.GithubData
import org.ohmstheresistance.oauth_tester.network.GithubDataService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Path

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        getInfo()
    }

    private fun getInfo() {

        val service = Retrofit.Builder()
            .baseUrl("https://api.github.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(GithubDataService::class.java)

        service.retrieveGithubInfo("InquisitiveMindHasToKnow")
            .enqueue(object : Callback<List<GithubData>> {
                override fun onResponse(
                    call: Call<List<GithubData>>,
                    response: Response<List<GithubData>>
                ) {

                    val githubDataList = ArrayList<GithubData>()
                    response.body()?.forEach { println("REPOS: ${it.url}") }
                    response.body()?.let { githubDataList.addAll(it) }

                }

                override fun onFailure(call: Call<List<GithubData>>, t: Throwable) =
                    t.printStackTrace()
            })
    }

    private fun authorizeAccess(){

        val service = Retrofit.Builder()
            .baseUrl("https://github.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(GithubDataService::class.java)

        service.retrieveGithubInfo("InquisitiveMindHasToKnow")
            .enqueue(object : Callback<List<GithubData>> {
                override fun onResponse(
                    call: Call<List<GithubData>>,
                    response: Response<List<GithubData>>
                ) {

                    val githubDataList = ArrayList<GithubData>()
                    response.body()?.forEach { println("REPOS: ${it.url}") }
                    response.body()?.let { githubDataList.addAll(it) }

                }

                override fun onFailure(call: Call<List<GithubData>>, t: Throwable) =
                    t.printStackTrace()
            })
    }
}