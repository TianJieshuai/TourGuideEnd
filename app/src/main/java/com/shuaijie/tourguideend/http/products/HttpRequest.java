package com.shuaijie.tourguideend.http.products;

import android.content.Context;
import android.net.Uri;

import com.shuaijie.tourguideend.http.HttpCallback;

import java.io.File;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

/**
 * @author 农民伯伯
 * @version 2017/12/22
 *          抽象工厂中的 抽象产品
 */

public interface HttpRequest<T> {
    void doGet(Context context, String path, final Type type, final HttpCallback<T> callback);

    void doPost(Context context, String url, final Type type, Map<String, String> mParams, final HttpCallback<T> callback);

    void uploadFile(Uri fileUri, HttpCallback<T> callback);

    void upLoadFiles(List<File> mFiles, HttpCallback<T> callback);

    void downloadFileWithDynamicUrlSync(String fileUrl, HttpCallback<T> callback);
}
