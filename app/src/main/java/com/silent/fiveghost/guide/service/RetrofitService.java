package com.silent.fiveghost.guide.service;


import java.util.Map;

import io.reactivex.Observable;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.PartMap;
import retrofit2.http.Path;
import retrofit2.http.Url;

/**
 * @author 农民伯伯
 * @version 2017/10/31
 *          Retrofit进行网络请求的接口
 */
public interface RetrofitService {
    @GET
    Observable<ResponseBody> doGet(@Url String url);

    @FormUrlEncoded
    @POST("{path}")
    Observable<ResponseBody> doPost(@Path("path") String path, @FieldMap Map<String, String> mMap);

    /**
     * @param requestBody 就是RequestBody实例中包裹的字符串值 ；
     * @param file        我们使用MultipartBody.Part类，使我们能够发送实际文件 file就是你要往服务器上传的文件。
     * @return
     */
    @Multipart
    @POST("upload")
    Call<ResponseBody> upload(@Part("requestbody") RequestBody requestBody,
                              @Part MultipartBody.Part file);

    @Multipart
    @POST("upload")
    Observable<String> upLoad(@PartMap Map<String, RequestBody> params);

    @GET
    Call<ResponseBody> downloadFileWithDynamicUrlSync(@Url String fileUrl);
}
