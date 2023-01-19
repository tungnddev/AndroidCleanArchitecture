package com.greaper.data.local.pref

import android.content.Context
import android.content.SharedPreferences
import androidx.core.content.edit
import com.google.gson.Gson
import com.greaper.data.model.entity.TokenEntity
import com.greaper.data.model.entity.UserEntity
import javax.inject.Inject

class AppPrefs @Inject constructor(
    mContext: Context,
) : PrefHelper {

    private val gson = Gson()

    private val sharedPreferences: SharedPreferences =
        mContext.getSharedPreferences(mContext.packageName, Context.MODE_PRIVATE)

    override fun getCurrentUser(): UserEntity? {
        return sharedPreferences.getString(CURRENT_USER, null)
            ?.let { gson.fromJson(it, UserEntity::class.java) }
    }

    override fun setCurrentUser(user: UserEntity) {
        sharedPreferences.edit { putString(CURRENT_USER, gson.toJson(user)) }
    }

    override fun getToken(): TokenEntity? {
        return sharedPreferences.getString(TOKEN, null)
            ?.let { gson.fromJson(it, TokenEntity::class.java) }
    }

    override fun setToken(token: TokenEntity) {
        sharedPreferences.edit { putString(TOKEN, gson.toJson(token)) }
    }

    override fun setFirstRun(boolean: Boolean) {
        sharedPreferences.edit { putBoolean(FIRST_RUN, boolean) }
    }

    override fun isFirstRun(): Boolean {
        return sharedPreferences.getBoolean(FIRST_RUN, true)
    }

    companion object {
        private const val FIRST_RUN = "first_run"
        private const val TOKEN = "token"
        private const val CURRENT_USER = "current_user"
    }
}