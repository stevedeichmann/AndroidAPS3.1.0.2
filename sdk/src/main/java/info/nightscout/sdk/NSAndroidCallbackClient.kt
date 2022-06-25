package info.nightscout.sdk

import android.content.Context
import info.nightscout.sdk.localmodel.Status
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch

public interface NSAndroidCallbackClient {

    public fun getStatus(callback: NSCallback<Status>): NSCancellable

    public companion object { // TODO: test if callable from Java. If not, use named Object
        @JvmStatic
        @JvmOverloads
        public fun create(
            baseUrl: String,
            accessToken: String,
            context: Context,
            logging: Boolean = false
        ): NSAndroidCallbackClient = NSAndroidCallbackClientImpl(
            NSAndroidClient(
                baseUrl = baseUrl,
                accessToken = accessToken,
                context = context,
                logging = logging
            )
        )
    }
}

private class NSAndroidCallbackClientImpl(private val client: NSAndroidClient) :
    NSAndroidCallbackClient {

    private val scope = CoroutineScope(Dispatchers.IO + SupervisorJob())

    @Suppress("TooGenericExceptionCaught")
    override fun getStatus(callback: NSCallback<Status>): NSCancellable =
        NSJobCancellable(
            scope.launch {
                try {
                    callback.onSuccess(client.getStatus())
                } catch (e: Exception) {
                    callback.onFailure(e)
                }
            }
        )
}

public interface NSCallback<T> {
    public fun onSuccess(value: T)
    public fun onFailure(exception: Exception)
}

public interface NSCancellable {
    public fun cancel()
}

private class NSJobCancellable(val job: Job) : NSCancellable {
    override fun cancel() = job.cancel()
}
