package com.shuaijie.tourguideend.http.products;

import android.content.Context;
import android.net.Uri;
import android.util.Log;

import com.shuaijie.tourguideend.http.HttpCallback;
import com.shuaijie.tourguideend.http.httptoos.RetrofitTools;
import com.shuaijie.tourguideend.service.RetrofitService;
import com.shuaijie.tourguideend.utils.Gson;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * @author 农民伯伯
 * @version 2017/12/22
 *          抽象工厂中的具体产品
 */

public class RetrofitRequest<T> implements HttpRequest<T> {
    private String TAG = "RetrofitRequest";

    @Override
    public void doGet(Context context, String path, final Type type, final HttpCallback<T> callback) {
        RetrofitService api = RetrofitTools.getInstance().create(RetrofitService.class);

        Observable<ResponseBody> doGet = api.doGet(path);
        doGet.subscribeOn(Schedulers.io()).unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ResponseBody>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull ResponseBody responseBody) {
                        try {
                            String string = responseBody.string();
                            Log.e("TAG", string);

                            com.google.gson.Gson gson = new com.google.gson.Gson();
                            T t = gson.fromJson(string, type);
                            callback.success(t);

                        } catch (IOException e) {
                            e.printStackTrace();
                            callback.failure(e);
                        }
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        callback.failure(e);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    public void doPost(Context context, String url, final Type type, Map<String, String> mParams, final HttpCallback<T> callback) {
        RetrofitService api = RetrofitTools.getInstance().create(RetrofitService.class);
        Observable<ResponseBody> post = api.doPost(url, mParams);
        post.subscribeOn(Schedulers.io()).unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ResponseBody>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull ResponseBody responseBody) {

                        try {
                            String string = responseBody.string();
                            Log.e("TAG", string);
                            //TODO 注意这个地方：
                            T t = Gson.fromJson(string, type);

                            callback.success(t);
                        } catch (IOException e) {
                            e.printStackTrace();
                            callback.failure(e);
                        }
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        callback.failure(e);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    public void uploadFile(Uri fileUri, final HttpCallback<T> callback) {
        // create upload service client
        // https://github.com/iPaulPro/aFileChooser/blob/master/aFileChooser/src/com/ipaulpro/afilechooser/utils/FileUtils.java
        // use the FileUtils to get the actual file by uri
        File file = new File(String.valueOf(fileUri));

        /* create RequestBody instance from file
        创建上传文件的requestBody
         */
        RequestBody requestFile =
                RequestBody.create(MediaType.parse("multipart/form-data"), file);

        // MultipartBody.Part is used to send also the actual file name
        MultipartBody.Part body =
                MultipartBody.Part.createFormData("picture", file.getName(), requestFile);

        // add another part within the multipart request
        String descriptionString = "hello, this is description speaking";
        RequestBody description =
                RequestBody.create(
                        MediaType.parse("multipart/form-data"), descriptionString);

        // finally, execute the request
        Call<ResponseBody> upload = RetrofitTools.getInstance().create(RetrofitService.class).upload(description, body);
        upload.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call,
                                   Response<ResponseBody> response) {
                callback.success((T) new String("成功"));
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                callback.failure(t);
            }
        });
    }

    @Override
    public void upLoadFiles(List<File> mFiles, final HttpCallback<T> callback) {
        Map<String, RequestBody> paramsMap = new HashMap<>();
        for (int i = 0; i < mFiles.size(); i++) {
            File file = mFiles.get(i);
            RequestBody fileBody = RequestBody.create(MediaType.parse("image/png"), mFiles.get(i));
            paramsMap.put(file.getName(), fileBody);
        }
        Observable<String> upLoad = RetrofitTools.getInstance().create(RetrofitService.class).upLoad(paramsMap);
        upLoad.subscribeOn(Schedulers.io()).unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<String>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(String s) {
                        callback.success((T) s);
                    }

                    @Override
                    public void onError(Throwable e) {
                        callback.failure(e);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }


    @Override
    public void downloadFileWithDynamicUrlSync(String fileUrl, final HttpCallback<T> callback) {

        Call<ResponseBody> call = RetrofitTools.getInstance().create(RetrofitService.class).downloadFileWithDynamicUrlSync(fileUrl);

        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if (response != null) {

                    boolean writtenToDisk = writeResponseBodyToDisk(response.body());
                    callback.success((T) new String("server contacted and has file"));
                } else {
                    callback.failure(new Exception("server contact failed"));
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Log.e(TAG, "error");
            }
        });
    }

    /**
     * 文件保存
     *
     * @param body
     * @return
     */
    private boolean writeResponseBodyToDisk(ResponseBody body) {
        try {
            // todo change the file location/name according to your needs
            File futureStudioIconFile = new File("");

            InputStream inputStream = null;
            OutputStream outputStream = null;

            try {
                byte[] fileReader = new byte[4096];

                long fileSize = body.contentLength();
                long fileSizeDownloaded = 0;

                inputStream = body.byteStream();
                outputStream = new FileOutputStream(futureStudioIconFile);

                while (true) {
                    int read = inputStream.read(fileReader);

                    if (read == -1) {
                        break;
                    }

                    outputStream.write(fileReader, 0, read);

                    fileSizeDownloaded += read;

                    Log.d(TAG, "file download: " + fileSizeDownloaded + " of " + fileSize);
                }

                outputStream.flush();

                return true;
            } catch (IOException e) {
                return false;
            } finally {
                if (inputStream != null) {
                    inputStream.close();
                }

                if (outputStream != null) {
                    outputStream.close();
                }
            }
        } catch (IOException e) {
            return false;
        }
    }

}
