package com.greaper.domain.usecase.user

import com.greaper.domain.repository.UserRepository
import java.util.*

class UserGetCurrencyUseCase(private val userRepository: UserRepository) {

    operator fun invoke() : String {
        val cacheUser = userRepository.getCacheUser() ?: return ""
        val locale = Locale("", cacheUser.countryCode)
        return try {
            Currency.getInstance(locale).currencyCode
        } catch (e: IllegalArgumentException) {
            // locale or currency not found
            ""
        }
    }
}