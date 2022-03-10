package de.darthkali.kmm_bike_share.util

actual class Logger actual constructor(
    private val className: String
) {

    actual fun log(msg: String) {
        println("$className: $msg")
    }
}
