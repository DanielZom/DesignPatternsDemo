package com.example.designpatternsdemo.adapter

interface IAndroidAuthData {
    fun validateAuthData(data: String): Boolean
}

class AuthDataValidator(private val authDataAdapter: AuthDataAdapter): IAndroidAuthData {

    override fun validateAuthData(data: String): Boolean {
        return authDataAdapter.convertAndValidateData(data)
    }
}