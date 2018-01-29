package com.silent.fiveghost.guide.beans.login;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by shuaiJie on 2018/1/28.
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
 * 创建时间：2018/1/28 11:16
 * 电子邮箱：510889082@qq.com
 */

public class UserBean implements Parcelable {
    /**
     * id : 23
     * username :
     * email :
     * access_token : u-n-6Ep8_iaKNbQDVqJWjX9CcuF23Z5r
     * expired_at : 1547441129
     * avatar : http://tourism.com/api/assets/e93d372d/avatar_200x200.png
     * category : 2
     * login_at : null
     */

    private int id;
    private String username;
    private String email;
    private String access_token;
    private int expired_at;
    private String avatar;
    private int category;
    private String login_at;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public int getExpired_at() {
        return expired_at;
    }

    public void setExpired_at(int expired_at) {
        this.expired_at = expired_at;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    public String getLogin_at() {
        return login_at;
    }

    public void setLogin_at(String login_at) {
        this.login_at = login_at;
    }

    @Override
    public String toString() {
        return "UserBean{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", access_token='" + access_token + '\'' +
                ", expired_at=" + expired_at +
                ", avatar='" + avatar + '\'' +
                ", category=" + category +
                ", login_at=" + login_at +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.id);
        dest.writeString(this.username);
        dest.writeString(this.email);
        dest.writeString(this.access_token);
        dest.writeInt(this.expired_at);
        dest.writeString(this.avatar);
        dest.writeInt(this.category);
        dest.writeString(this.login_at);
    }

    public UserBean() {
    }

    protected UserBean(Parcel in) {
        this.id = in.readInt();
        this.username = in.readString();
        this.email = in.readString();
        this.access_token = in.readString();
        this.expired_at = in.readInt();
        this.avatar = in.readString();
        this.category = in.readInt();
        this.login_at = in.readParcelable(Object.class.getClassLoader());
    }

    public static final Parcelable.Creator<UserBean> CREATOR = new Parcelable.Creator<UserBean>() {
        @Override
        public UserBean createFromParcel(Parcel source) {
            return new UserBean(source);
        }

        @Override
        public UserBean[] newArray(int size) {
            return new UserBean[size];
        }
    };
}
