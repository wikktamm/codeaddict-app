package com.example.codeaddict_app.data

class ApiHeaderProvider {
    companion object {
        private const val ACCEPT = "Accept"
        fun getDefaultHeaders() = mapOf(
            ACCEPT to "application/vnd.github.cloak-preview+json"
        )

        fun getAcceptHeaders(): AcceptHeaders =
            AcceptHeaders().apply {
                putAll(getDefaultHeaders())
            }

    }

    open class ApiMainHeaders : HashMap<String, String>()
    class AcceptHeaders : ApiMainHeaders()
}

