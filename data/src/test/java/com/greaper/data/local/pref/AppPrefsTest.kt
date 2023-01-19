package com.greaper.data.local.pref

import android.content.Context
import androidx.test.core.app.ApplicationProvider
import org.junit.Assert.*

import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner

@RunWith(RobolectricTestRunner::class)
class AppPrefsTest {

    private lateinit var prefHelper: PrefHelper

    @Before
    fun setUp() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        prefHelper = AppPrefs(context)
    }

    @Test
    fun firstRun_InitValue() {
        val initValue = prefHelper.isFirstRun()
        assertEquals(initValue, true)
    }

    @Test
    fun firstRun_TrueValue() {
        val trueValue = true
        prefHelper.setFirstRun(trueValue)
        val result = prefHelper.isFirstRun()
        assertEquals(trueValue, result)

    }

    @Test
    fun firstRun_FalseValue() {
        val falseValue = false
        prefHelper.setFirstRun(falseValue)
        val result = prefHelper.isFirstRun()
        assertEquals(falseValue, result)
    }

    @Test
    fun currentUser_InitValue() {
        val initValue = prefHelper.getCurrentUser()
        assertEquals(initValue, null)
    }

}