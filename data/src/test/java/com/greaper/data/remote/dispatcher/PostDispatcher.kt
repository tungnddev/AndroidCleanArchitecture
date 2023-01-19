package com.greaper.data.remote.dispatcher

import okhttp3.mockwebserver.Dispatcher
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.RecordedRequest

class PostDispatcher : Dispatcher() {
    override fun dispatch(request: RecordedRequest): MockResponse {
        print("The request path is \n \n ${request.path} \n\n why is it failing")
        return MockResponse()
            .setResponseCode(200)
    }
}