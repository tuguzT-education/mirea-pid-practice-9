package io.github.tuguzt.recyclerviewexample.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Person(
    val sex: Sex,

    val name: String,

    @SerialName("phone_number")
    val phoneNumber: Long,
)
