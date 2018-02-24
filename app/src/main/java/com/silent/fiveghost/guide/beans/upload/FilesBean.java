package com.silent.fiveghost.guide.beans.upload;

import android.os.Parcel;
import android.os.Parcelable;

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
 * 创建时间：2018/2/23 20:56
 * 电子邮箱：510889082@qq.com
 */

public class FilesBean implements Parcelable {
    /**
     * id : 10
     * name : PrClhUfNQ4B9V85yfhAdCVY-X7py26sXnckr-yYW.jpg
     * hash : c49a2f669695914fb4beb33cf3a34be1
     * url : http://tourism.com/storage/upload/20180113/xjoXSj9Yk9TYBI7gyaH5ZPNxCn_PDjDz5MX2qbuP.jpg
     * path : 20180113/xjoXSj9Yk9TYBI7gyaH5ZPNxCn_PDjDz5MX2qbuP.jpg
     * extension : jpg
     * type : image/jpeg
     * size : 28323
     */

    private int id;
    private String name;
    private String hash;
    private String url;
    private String path;
    private String extension;
    private String type;
    private int size;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "FilesBean{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", hash='" + hash + '\'' +
                ", url='" + url + '\'' +
                ", path='" + path + '\'' +
                ", extension='" + extension + '\'' +
                ", type='" + type + '\'' +
                ", size=" + size +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.id);
        dest.writeString(this.name);
        dest.writeString(this.hash);
        dest.writeString(this.url);
        dest.writeString(this.path);
        dest.writeString(this.extension);
        dest.writeString(this.type);
        dest.writeInt(this.size);
    }

    public FilesBean() {
    }

    protected FilesBean(Parcel in) {
        this.id = in.readInt();
        this.name = in.readString();
        this.hash = in.readString();
        this.url = in.readString();
        this.path = in.readString();
        this.extension = in.readString();
        this.type = in.readString();
        this.size = in.readInt();
    }

    public static final Parcelable.Creator<FilesBean> CREATOR = new Parcelable.Creator<FilesBean>() {
        @Override
        public FilesBean createFromParcel(Parcel source) {
            return new FilesBean(source);
        }

        @Override
        public FilesBean[] newArray(int size) {
            return new FilesBean[size];
        }
    };
}
