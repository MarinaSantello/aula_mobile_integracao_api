package br.senai.sp.jandira.viacep.service

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

// Fábrica de retrofit: fará a conexão com a API
class RetrofitFactory {

    // url base dos end-points
    val url = "https://viacep.com.br/ws/"

    // String de conexão com a API
    val retrofitFactory = Retrofit
        .Builder()
        .baseUrl(url)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun retrofitService(): CepRetrofitService {
        return retrofitFactory.create(CepRetrofitService::class.java) // retorna interface para get
    }
}