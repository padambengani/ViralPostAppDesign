package in.viralpost.viralpostapp.network;

import android.content.Context;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.Volley;

/**
 * Created by pbengani on 9/30/2015.
 */
public class NetSingleton {

    private static NetSingleton mNetSingleton;
    private RequestQueue mRequestQueue;
    private ImageLoader mImageLoader;
    private LruBitmapCache mLruBitmapCache;

    private static Context mContext;

    private NetSingleton(Context context) {
        mContext = context;
    }

    public static synchronized NetSingleton getInstance(Context context) {
        if (mNetSingleton == null) {
            mNetSingleton = new NetSingleton(context);
        }
        return mNetSingleton;
    }

    public RequestQueue getRequestQueue() {
        if (mRequestQueue == null) {
            mRequestQueue = Volley.newRequestQueue(mContext.getApplicationContext());// getApplicationContext() is key
        }
        return mRequestQueue;
    }

    public ImageLoader getImageLoader() {
        if (mImageLoader == null) {
            mImageLoader = new ImageLoader(getRequestQueue(), getLruBitmapCache());
        }
        return mImageLoader;
    }

    public LruBitmapCache getLruBitmapCache() {
        if (mLruBitmapCache == null) {
            mLruBitmapCache = new LruBitmapCache(mContext.getApplicationContext());// getApplicationContext() is key
        }
        return mLruBitmapCache;
    }
}
