package com.hc.plugin.loader;

import android.content.ComponentName;
import android.content.Context;

import com.tencent.shadow.core.loader.infos.ContainerProviderInfo;
import com.tencent.shadow.core.loader.managers.ComponentManager;

import java.util.ArrayList;
import java.util.List;

public class SampleComponentManager extends ComponentManager {


    private Context context;

    public SampleComponentManager(Context context) {
        this.context = context;
    }


    /**
     * 配置插件Activity 到 壳子Activity的对应关系
     *
     * @param pluginActivity 插件Activity
     * @return 壳子Activity
     */
    @Override
    public ComponentName onBindContainerActivity(ComponentName pluginActivity) {
        switch (pluginActivity.getClassName()) {
            /**
             * 这里配置对应的对应关系
             */
        }
        return new ComponentName(context, Constance.SINGLE_INSTANCE_ACTIVITY);
    }

    /**
     * 配置对应宿主中预注册的壳子contentProvider的信息
     */
    @Override
    public ContainerProviderInfo onBindContainerContentProvider(ComponentName pluginContentProvider) {
        return new ContainerProviderInfo(Constance.HOST_MANIFEST_PROVIDER_NAME, Constance.HOST_MANIFEST_PROVIDER_AUTHORITIES);
    }

    @Override
    public List<BroadcastInfo> getBroadcastInfoList(String partKey) {
        List<BroadcastInfo> broadcastInfos = new ArrayList<>();

        //如果有静态广播需要像下面代码这样注册
//        if (partKey.equals(Constant.PART_KEY_PLUGIN_MAIN_APP)) {
//            broadcastInfos.add(
//                    new ComponentManager.BroadcastInfo(
//                            "com.tencent.shadow.demo.usecases.receiver.MyReceiver",
//                            new String[]{"com.tencent.test.action"}
//                    )
//            );
//        }
        return broadcastInfos;
    }

}
