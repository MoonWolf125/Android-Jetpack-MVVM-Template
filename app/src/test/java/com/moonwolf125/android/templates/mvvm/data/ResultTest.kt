package com.moonwolf125.android.templates.mvvm.data

import org.junit.Test

import org.junit.Assert.*
import java.lang.Exception

class ResultTest {

    @Test
    fun result_Success_unalteredData() {
        // Given a successful result
        val input = 25
        val success: Result<Int, String> = Result.Success(input)

        // Then the corresponding toString is a success output
        assertEquals(input, (success as Result.Success).data)
    }

    @Test
    fun result_Error_unalteredError() {
        // Given a successful result
        val input = "Testing Unaltered Error"
        val success: Result<Int, String> = Result.Error(input)

        // Then the corresponding toString is a success output
        assertEquals(input, (success as Result.Error).error)
    }

    @Test
    fun result_Exception_unalteredException() {
        // Given a successful result
        val input = Exception("Testing Unaltered Exception")
        val success: Result<Int, String> = Result.Exception(input)

        // Then the corresponding toString is a success output
        assertEquals(input, (success as Result.Exception).exception)
    }

    @Test
    fun result_Success_toString() {
        // Given a successful result
        val input = "Success"
        val success: Result<String, String> = Result.Success(input)

        // Then the corresponding toString is a success output
        assertEquals("Success(data=$input)", success.toString())
    }

    @Test
    fun result_Error_toString() {
        // Given an error result
        val input = "Error"
        val error: Result<String, String> = Result.Error(input)

        // Then the corresponding toString is an error output
        assertEquals("Error(error=$input)", error.toString())
    }

    @Test
    fun result_Exception_toString() {
        // Given an exception result
        val input = Exception()
        val exception: Result<String, String> = Result.Exception(input)

        // Then the corresponding toString is an exception output
        assertEquals("Exception(exception=$input)", exception.toString())
    }
}