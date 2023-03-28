package com.example.designpatternsdemo.adapter

class AuthDataAdapter {

    private val legacyAuthDataValidator = LegacyAuthDataValidator()

    fun convertAndValidateData(data: String): Boolean {
        //Convert
        val formattedData = data.toByteArray()
        //Validate
        return legacyAuthDataValidator.validateData(formattedData)
    }
}