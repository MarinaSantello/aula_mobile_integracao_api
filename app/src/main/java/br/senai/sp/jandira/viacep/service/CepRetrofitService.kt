package br.senai.sp.jandira.viacep.service

import br.senai.sp.jandira.viacep.model.Cep
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface CepRetrofitService {

    // End-point utilizado: https://viacep.com.br/ws/01001000/json/
    @GET("{cep}/json/")
    fun getCEP(
        @Path("cep") cep: String // valor que será inserido no {cep} do @GET
    ): Call<Cep> // retorno da função - chama a classe do objeto de dados que precisamos

    // End-point utilizado: https://viacep.com.br/ws/SP/Jandira/silva/json/
    @GET("{uf}/{cidade}/{logradouro}/json/")
    fun getCEPs(
        @Path("uf") uf: String,
        @Path("cidade") cidade: String,
        @Path("logradouro") logradouro: String
    ): Call<List<Cep>> // retorno da função - chama uma lista com as classes do objeto de dados que precisamos
}