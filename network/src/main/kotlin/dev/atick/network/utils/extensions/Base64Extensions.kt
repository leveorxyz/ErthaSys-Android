package dev.atick.network.utils.extensions

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.util.Base64
import com.orhanobut.logger.Logger
import java.io.ByteArrayOutputStream

fun Bitmap.toBase64(): String {
    val byteArrayOutputStream = ByteArrayOutputStream()
    this.compress(
        Bitmap.CompressFormat.JPEG,
        70,
        byteArrayOutputStream
    )
    val byteArray = byteArrayOutputStream.toByteArray()
    return "data:image/jpeg;base64," + Base64.encodeToString(byteArray, Base64.DEFAULT)
}

fun String.toBitmap(): Bitmap? {
    return try {
        val decodedString = Base64.decode(this.split(",")[1], Base64.DEFAULT)
        BitmapFactory.decodeByteArray(decodedString, 0, decodedString.size)
    } catch (e: Exception) {
        Logger.e(e.toString())
        null
    }
}