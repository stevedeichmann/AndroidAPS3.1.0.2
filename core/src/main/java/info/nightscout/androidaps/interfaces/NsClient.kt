package info.nightscout.androidaps.interfaces

import android.text.Spanned
import org.json.JSONObject

interface NsClient : Sync {

    val address: String

    val nsClientService: NSClientService?
    fun pause(newState: Boolean)
    fun resend(reason: String)
    fun textLog(): Spanned
    fun clearLog()

    fun updateLatestDateReceivedIfNewer(latestReceived: Long)

    interface NSClientService {

        fun dbAdd(collection: String, data: JSONObject, originalObject: Any, progress: String)
        fun dbUpdate(collection: String, _id: String?, data: JSONObject?, originalObject: Any, progress: String)
    }
}