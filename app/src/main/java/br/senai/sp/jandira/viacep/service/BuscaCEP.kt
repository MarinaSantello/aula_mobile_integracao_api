package br.senai.sp.jandira.viacep.service

import br.senai.sp.jandira.viacep.model.Cep
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

fun burcarCEP(cep: String, onComplete: (String, Int) -> Unit) {

    var logradouro = ""

    val call = RetrofitFactory()
        .retrofitService()
        .getCEP(cep)

    call.enqueue(object: Callback<Cep> {
        override fun onResponse(
            call: Call<Cep>,
            response: Response<Cep>
        ) { // será executada quando a requisição tem sucesso e reponde
            logradouro = response.body()!!.logradouro ?: "Cep não encontrado"
            onComplete.invoke(logradouro, 182) // envocacao do onComplete para passar o retorno da função (logradouro)
        }

        override fun onFailure(
            call: Call<Cep>,
            t: Throwable
        ) { // será executada quando a conexão falha

        }
    })
}