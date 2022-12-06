package com.greaper.domain.usecase.user

import com.greaper.domain.model.User
import com.greaper.domain.repository.UserRepository
import kotlinx.coroutines.flow.map
import java.util.*

class UserGetCurrencyUseCase(private val userRepository: UserRepository) {

    operator fun invoke() = userRepository.getCacheUser()
        .map {
            val locale = Locale("", it.countryCode)
            try {
                return@map Currency.getInstance(locale).currencyCode
            } catch (e: IllegalArgumentException) {
                // locale or currency not found
                return@map ""
            }
        }
}