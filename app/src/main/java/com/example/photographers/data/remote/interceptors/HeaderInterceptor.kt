package com.example.photographers.data.remote.interceptors
import okhttp3.Credentials
import okhttp3.Interceptor

class HeaderInterceptor(username: String, password: String): Interceptor {
    private var credentials: String = Credentials.basic(username, password)

    override fun intercept(chain: Interceptor.Chain): okhttp3.Response {
        var request = chain.request()
        request = request.newBuilder()
            .addHeader("Authorization", credentials) //basic auth header
            //.addHeader("Accept:", "application/json") //accepts types header TODO not works with this
            .build()
        return chain.proceed(request)
    }
}