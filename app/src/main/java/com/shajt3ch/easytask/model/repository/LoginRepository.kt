package com.shajt3ch.easytask.model.repository

import com.shajt3ch.easytask.model.local.AppPreferences
import com.shajt3ch.easytask.model.remote.NetworkService
import com.shajt3ch.easytask.model.remote.request.auth.LoginRequest
import com.shajt3ch.easytask.model.remote.response.auth.LoginResponse

/**
 * Created by Shakil Ahmed Shaj on 14,April,2020.
 * shakilahmedshaj@gmail.com
 */
class LoginRepository(
    private val networkService: NetworkService,
    private val appPreferences: AppPreferences
) {

    suspend fun login(loginRequest: LoginRequest) = networkService.login(loginRequest)

    suspend fun saveUserDetail(loginResponse: LoginResponse): Boolean {

        appPreferences.setAccessToken(loginResponse.accessToken)
        appPreferences.setTokenId(loginResponse.tokenId)
        appPreferences.setUserId(loginResponse.userId)
        appPreferences.setUserName(loginResponse.name)
        appPreferences.setUserEmail(loginResponse.email)

        return true

    }
}