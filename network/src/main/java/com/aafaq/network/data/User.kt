package com.aafaq.network.data

sealed class Gender{
    object MALE: Gender()
    object UNSPECIFIED: Gender()

    data class FEMALE(
        var isActive: Boolean? = false,
        var startDate: Long? = null,
        var endDate: Long? = null,
        var freezeDuration: Int? = null
    ): Gender()
}

data class User (
    var dob: Long? = null,
    var name: String? = null,
    var gender: Gender? = null,
    var age: Int? = null,
){

    fun is18Plus(): Boolean{
        return false
    }

    fun isFreezeStart(): Boolean{
        return false
    }

    fun startFreeze(){

    }

    fun endFreeze(){

    }
}