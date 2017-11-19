package com.agdroid.dagger2demo.data;

import android.content.Context;
import android.content.res.Resources;

import com.agdroid.dagger2demo.data.model.User;
import com.agdroid.dagger2demo.di.ApplicationContext;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by andre on 19.11.2017.
 */

@Singleton
public class DataManager {

    private Context mContext;
    private DbHelper mDbHelper;
    private SharedPrefsHelper mSharedPrefsHelper;

    @Inject
    public DataManager(@ApplicationContext Context mContext,
                       DbHelper mDbHelper,
                       SharedPrefsHelper mSharedPrefsHelper) {
        this.mContext = mContext;
        this.mDbHelper = mDbHelper;
        this.mSharedPrefsHelper = mSharedPrefsHelper;
    }

    public void saveAccessToken(String accessToken) {
        mSharedPrefsHelper.put(SharedPrefsHelper.PREF_KEY_ACCESS_TOKEN, accessToken);
    }

    public String getAccessToken(){
        return mSharedPrefsHelper.get(SharedPrefsHelper.PREF_KEY_ACCESS_TOKEN, null);
    }

    public Long createUser(User user) throws Exception {
        return mDbHelper.insertUser(user);
    }

    public User getUser(Long userId) throws Resources.NotFoundException, NullPointerException {
        return mDbHelper.getUser(userId);
    }
}
