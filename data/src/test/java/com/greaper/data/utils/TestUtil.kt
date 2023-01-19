package com.greaper.data.utils

object TestUtil {

    fun getJson(fileName: String): String {
        val inputStream = javaClass.classLoader?.getResourceAsStream("api-response/$fileName")

        val out = StringBuilder()
        inputStream?.bufferedReader()?.useLines { lines ->
            lines.forEach { line ->
                out.append(line)
            }
        }

        return out.toString()
    }

    const val LOREM_STRING = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Morbi dapibus vel lorem eu fringilla. Quisque accumsan porta faucibus. Sed volutpat tincidunt dui, eget mattis arcu vestibulum a. Nulla nisl elit, varius id elementum ac, pulvinar eget odio."
    const val ACCESS_TOKEN = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiIxMjM0NTY3ODkwIiwibmFtZSI6IkpvaG4gRG9lIiwiaWF0IjoxNTE2MjM5MDIyfQ"
    const val REFRESH_TOKEN = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiIxMjM0NTY3ODkwIiwibmFtZSI6IkpvaG4gRG9lIiwiaWF0IjoxNTE2MjM5MDIyfQ123"
}