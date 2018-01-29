package com.silent.fiveghost.guide.db.factor;

import android.content.Context;

import com.silent.fiveghost.guide.db.product.IOpenHelper;
import com.silent.fiveghost.guide.http.httprequest.HttpRequest;

/**
 * @author 农民伯伯
 * @version 2017/12/26
 */

public interface DatabaseCreat {
    <T extends HttpRequest> IOpenHelper conCreate(Context context, Class<T> clz);
}
