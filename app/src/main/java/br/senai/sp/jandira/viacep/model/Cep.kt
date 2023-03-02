package br.senai.sp.jandira.viacep.model

import com.google.gson.annotations.SerializedName


data class Cep(
    var cep: String,
    var logradouro: String,
    var complemento: String,
    var bairro: String,

    @SerializedName("localidade") // indica para o gson qual a chave equivalente desse atributo
    var cidade: String,

    @SerializedName("uf")
    var estado: String
)