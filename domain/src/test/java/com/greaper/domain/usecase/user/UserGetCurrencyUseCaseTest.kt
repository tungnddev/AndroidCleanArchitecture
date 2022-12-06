package com.greaper.domain.usecase.user

import com.greaper.domain.model.User
import com.greaper.domain.repository.UserRepository
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test
import org.junit.Assert.assertEquals
import org.mockito.Mockito
import org.mockito.Mockito.`when`


// We just test some complicated code
@OptIn(ExperimentalCoroutinesApi::class)
class UserGetCurrencyUseCaseTest {

    private lateinit var userGetCurrencyUseCase: UserGetCurrencyUseCase
    private val userRepository: UserRepository = Mockito.mock(UserRepository::class.java)

    @Before
    fun setup() {
        userGetCurrencyUseCase = UserGetCurrencyUseCase(userRepository)
    }


    @Test
    fun invoke_WithVNCountryCode() = runTest {
        `when`(userRepository.getCacheUser()).thenReturn(flowOf(getUserFromCountryCode("VN")))
        val currency = userGetCurrencyUseCase().first()
        assertEquals("VND", currency)
    }

    @Test
    fun invoke_WithUSCountryCode() = runTest {
        `when`(userRepository.getCacheUser()).thenReturn(flowOf(getUserFromCountryCode("US")))
        val currency = userGetCurrencyUseCase().first()
        assertEquals("USD", currency)
    }

    @Test
    fun invoke_WithNotFoundCountryCode() = runTest {
        `when`(userRepository.getCacheUser()).thenReturn(flowOf(getUserFromCountryCode("ABC")))
        val currency = userGetCurrencyUseCase().first()
        assertEquals("", currency)
    }

    @Test
    fun invoke_WithEmptyCode() = runTest {
        `when`(userRepository.getCacheUser()).thenReturn(flowOf(getUserFromCountryCode("")))
        val currency = userGetCurrencyUseCase().first()
        assertEquals("", currency)
    }

    private fun getUserFromCountryCode(countryCode: String) : User {
        return User("", "", countryCode)
    }
}