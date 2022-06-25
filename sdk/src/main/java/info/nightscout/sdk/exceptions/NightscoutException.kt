package info.nightscout.sdk.exceptions

import java.io.IOException

public abstract class NightscoutException : IOException {
    public constructor() : super()
    public constructor(message: String) : super(message)
    public constructor(message: String, cause: Throwable) : super(message, cause)
    public constructor(cause: Throwable?) : super(cause)
}
