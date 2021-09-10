/*
 * Tencent is pleased to support the open source community by making Tencent Shadow available.
 * Copyright (C) 2019 THL A29 Limited, a Tencent company.  All rights reserved.
 *
 * Licensed under the BSD 3-Clause License (the "License"); you may not use
 * this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 *     https://opensource.org/licenses/BSD-3-Clause
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package com.yc.shadowdemo.plugin;

import android.content.Context;

import com.yc.jetpacklib.file.YcFileUtils;
import com.yc.shadowdemo.BuildConfig;
import com.yc.shadowdemo.FileUtils;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import kotlin.jvm.JvmStatic;

public class PluginHelper {

    /**
     * 动态加载的插件管理apk
     */
    public final static String sPluginManagerName = "shadowmanager_v1.0_debug.apk";

    /**
     * 动态加载的插件包，里面包含以下几个部分，插件apk，插件框架apk（loader apk和runtime apk）, apk信息配置关系json文件
     */
    public final static String sPluginZip = BuildConfig.DEBUG ? "plugin-debug.zip" : "plugin-release.zip";

    public File pluginManagerFile;

    public File pluginZipFile;

    public ExecutorService singlePool = Executors.newSingleThreadExecutor();

    private Context mContext;

    private static PluginHelper sInstance = new PluginHelper();

    public static PluginHelper getInstance() {
        return sInstance;
    }

    private PluginHelper() {
    }

    public void init(Context context) {
        pluginManagerFile = new File(context.getFilesDir(), sPluginManagerName);
        pluginZipFile = new File(context.getFilesDir(), sPluginZip);

        mContext = context.getApplicationContext();

        singlePool.execute(new Runnable() {
            @Override
            public void run() {
                preparePlugin();
            }
        });

    }

    private void preparePlugin() {
        //            InputStream is = mContext.getAssets().open(sPluginManagerName);
//            FileUtils.copyInputStreamToFile(is, pluginManagerFile);
        String path = mContext.getFilesDir().getPath() + File.separator;
        pluginManagerFile = FileUtils.copyFile(mContext, sPluginManagerName, path + sPluginManagerName);
//            InputStream zip = mContext.getAssets().open(sPluginZip);
//            FileUtils.copyInputStreamToFile(zip, pluginZipFile);
        pluginZipFile = FileUtils.copyFile(mContext, sPluginZip, path + sPluginZip);
    }

}
