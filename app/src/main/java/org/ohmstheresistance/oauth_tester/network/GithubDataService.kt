package org.ohmstheresistance.oauth_tester.network

import org.ohmstheresistance.oauth_tester.data.GithubData
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface GithubDataService {

    @GET("repos/:{owner}/:repo/events")
    fun retrieveGithubInfo(@Path("owner") owner: String): Call<List<GithubData>>
}