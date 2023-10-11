package com.macro4evoria.listenersreaders_class.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class User(
    val username: String,
    val password: String,
) : Parcelable