package com.silent.fiveghost.guide.beans.upload;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

/**
 * .                       .::::.
 * .                    .::::::::.
 * .                   :::::::::::
 * .                ..:::::::::::'   女
 * .              '::::::::::::'      神
 * .                .:::::::::       保
 * .               '::::::::::..      佑
 * .               .::::::::::::::.  代
 * .              `:::::::::::::::::  码
 * .              ::::``::::::::::'  无   .:::.
 * .             ::::'   ':::::' debug .::::::::.
 * .            .:::'      ::::     .:::::::'.::::.
 * .          .:::'       :::::  .:::::::::'  ':::::.
 * .         .::'        :::::.:::::::::'       ':::::.
 * .        .::'         ::::::::::::::'          ``::::.
 * .    ...:::           ::::::::::::'                ``::.
 * .   ```` ':.          ':::::::::'                    ::::..
 * .                      '.:::::'                     ':'````..
 * .
 * 作    者：shuaiJie
 * 创建时间：2018/2/23 20:55
 * 电子邮箱：510889082@qq.com
 */

public class Upload implements Parcelable {
    private List<FilesBean> files;

    public List<FilesBean> getFiles() {
        return files;
    }

    public void setFiles(List<FilesBean> files) {
        this.files = files;
    }

    @Override
    public String toString() {
        return "Upload{" +
                "files=" + files +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeList(this.files);
    }

    public Upload() {
    }

    protected Upload(Parcel in) {
        this.files = new ArrayList<FilesBean>();
        in.readList(this.files, FilesBean.class.getClassLoader());
    }

    public static final Parcelable.Creator<Upload> CREATOR = new Parcelable.Creator<Upload>() {
        @Override
        public Upload createFromParcel(Parcel source) {
            return new Upload(source);
        }

        @Override
        public Upload[] newArray(int size) {
            return new Upload[size];
        }
    };
}
