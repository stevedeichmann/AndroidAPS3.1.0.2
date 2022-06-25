package info.nightscout.sdk

import android.content.Context
import info.nightscout.sdk.localmodel.Status
import io.reactivex.Single
import kotlinx.coroutines.rx2.rxSingle

public interface NSAndroidRxClient {

    public fun getVersion(): Single<String>
    public fun getStatus(): Single<Status>

    public companion object { // TODO: test if callable from Java. If not, use named Object
        @JvmStatic
        @JvmOverloads
        public fun create(
            baseUrl: String,
            accessToken: String,
            context: Context,
            logging: Boolean = false
        ): NSAndroidRxClient = NSAndroidRxClientImpl(
            NSAndroidClient(
                baseUrl = baseUrl,
                accessToken = accessToken,
                context = context,
                logging = logging
            )
        )
    }
}

private class NSAndroidRxClientImpl(private val client: NSAndroidClient) :
    NSAndroidRxClient {

    override fun getVersion(): Single<String> = rxSingle {
        client.getVersion()
    }

    override fun getStatus(): Single<Status> = rxSingle {
        client.getStatus()
    }
}
