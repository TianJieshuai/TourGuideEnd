package com.silent.fiveghost.guide.utils;

import android.util.Log;

import com.silent.fiveghost.guide.BuildConfig;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by shuaiJie on 2018/1/8.
 */

/**
 * 多线程下载dome
 */
public class SpeedDownload extends Thread {
    public static final String TAG = "TAGThread";

    private final String name;
    private final ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(5, 64, 10000, TimeUnit.DAYS, new SynchronousQueue<java.lang.Runnable>());
    private final String url;
    private final File path;
    private Long fileLength;
    private final Long DOWNLOAD_LENGTH = Long.valueOf(String.valueOf((1 * 1024 * 1024)));
    private Long next_startPosition = 0L;
    private Long length = 0L;

    public SpeedDownload(String url, String name, File path) {
        this.url = url;
        this.name = name;
        this.path = path;
    }

    @Override
    public void run() {
        try {
            HttpURLConnection urlConnection = (HttpURLConnection) new URL(url).openConnection();
            urlConnection.setRequestMethod("HEAD");
            fileLength = Long.valueOf(urlConnection.getHeaderField("content-length"));
            while (next_startPosition < fileLength) {
                if (next_startPosition < fileLength && next_startPosition + DOWNLOAD_LENGTH < fileLength) {
                    Runnable runnable = new Runnable(url, name, path, next_startPosition, (next_startPosition += DOWNLOAD_LENGTH), fileLength);
                    poolExecutor.execute(runnable);
                } else {
                    Runnable runnable = new Runnable(url, name, path, next_startPosition, fileLength, fileLength);
                    poolExecutor.execute(runnable);
                    break;
                }
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void update(Long len) {
        length = length + len;
        if (BuildConfig.DEBUG) Log.d(TAG, "length:" + length);
    }

    private class Runnable implements java.lang.Runnable {
        private final String url;
        private volatile RandomAccessFile file;
        private volatile Long endPosition;
        private volatile Long startPosition;
        private volatile int len;
        private volatile long downloads;

        public String getUrl() {
            return url;
        }

        public RandomAccessFile getFile() {
            return file;
        }

        public Long getEndPosition() {
            return endPosition;
        }

        public Long getStartPosition() {
            return startPosition;
        }

        public int getLen() {
            return len;
        }

        public long getDownloads() {
            return downloads;
        }

        Runnable(String url, String name, File path, Long startPosition, Long endPosition, Long fileLength) {
            this.url = url;
            this.startPosition = startPosition;
            this.endPosition = endPosition;
            try {
                if (path.exists()) path.mkdirs();
                this.file = new RandomAccessFile(new File(path, "/" + name), "rwd");
                file.setLength(fileLength);
            } catch (IOException e) {
                if (BuildConfig.DEBUG) Log.d(TAG, e.toString());
            }
        }

        @Override
        public void run() {
            try {
                HttpURLConnection urlConnection = (HttpURLConnection) new URL(url).openConnection();
                urlConnection.setRequestMethod("GET");
                urlConnection.setRequestProperty("Range", "bytes=" + startPosition + "-" + endPosition);
                int responseCode = urlConnection.getResponseCode();
                if (responseCode == 206) {
                    file.seek(startPosition);
                    BufferedInputStream red = new BufferedInputStream(urlConnection.getInputStream());
                    byte[] bytes = new byte[1024];
                    while ((len = red.read(bytes)) != -1) {
                        file.write(bytes, 0, len);
                        downloads += len;
                        update(Long.valueOf(len));
                    }
                    red.close();
                }
            } catch (IOException e) {
                if (BuildConfig.DEBUG) Log.d(TAG, e.toString());
            }
            if (BuildConfig.DEBUG) Log.d(TAG, "wan");
        }
    }
}
