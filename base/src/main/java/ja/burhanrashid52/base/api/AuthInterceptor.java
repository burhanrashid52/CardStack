package ja.burhanrashid52.base.api;

import android.support.annotation.NonNull;
import android.util.Log;

import java.io.IOException;

import ja.burhanrashid52.base.util.PrefUtils;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * This class has two tasks:
 * 1) sign requests with the auth token, when available
 * 2) try to refresh a new token
 */
public class AuthInterceptor implements Interceptor {
    // these two static variables serve for the pattern to refresh a token
    //private final static ConditionVariable LOCK = new ConditionVariable(true);
    // private static final AtomicBoolean mIsRefreshing = new AtomicBoolean(false);
    // private static final long REFRESH_WAIT_TIMEOUT = 2 * 1000;
    // private static String REFRESH_TOKEN = "";

    public AuthInterceptor() {
    }

    @Override
    public Response intercept(@NonNull Chain chain) throws IOException {
        // Request customization: add request headers
        Request request = chain.request();

        Request request1 = request;
        if (request.header("Add-Auth") != null) {
            String AUTH_TOKEN = PrefUtils.getString(PrefUtils.TOKEN, "");
            Log.e("AuthInterceptor", AUTH_TOKEN);
            request1 = request.newBuilder()
                    .addHeader("Authorization", "Bearer " + AUTH_TOKEN)
                    .removeHeader("Add-Auth")
                    .build();
        }
        // 2. proceed with the request
        return chain.proceed(request1);
    }
}