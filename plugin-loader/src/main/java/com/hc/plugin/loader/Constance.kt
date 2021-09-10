package com.hc.plugin.loader

/**
 * Creator: yc
 * Date: 2021/6/21 10:43
 * UseDes:
 */
object Constance {
    /**
     * //TODO 分包时需修改
     * 宿主清单里注册provider的android:authorities（格式：${宿主的applicationId}.contentprovider.authority.dynamic）
     */
    const val HOST_MANIFEST_PROVIDER_AUTHORITIES = "com.hc.wisdombuilding.contentprovider.authority.dynamic"//TODO 分包注意：此处需要宿主AndroidManifest.xml里一致

    /**
     * 宿主清单里注册provider的android:authorities
     */
    const val HOST_MANIFEST_PROVIDER_NAME = "com.tencent.shadow.core.runtime.container.PluginContainerContentProvider"//TODO 分包注意：此处需要宿主AndroidManifest.xml里一致

    /**
     * 需在宿主AndroidManifest.xml注册，下方类在plugin-runtime里
     */
    const val DEFAULT_ACTIVITY = "com.hc.plugin.runtime.PluginDefaultProxyActivity"//TODO 分包注意：此处需要宿主AndroidManifest.xml里一致

    /**
     * 需在宿主AndroidManifest.xml注册，下方类在plugin-runtime里
     */
    const val SINGLE_INSTANCE_ACTIVITY = "com.hc.plugin.runtime.PluginSingleInstance1ProxyActivity"

    /**
     * 需在宿主AndroidManifest.xml注册，下方类在plugin-runtime里
     */
    const val SINGLE_TASK_ACTIVITY = "com.hc.plugin.runtime.PluginSingleTask1ProxyActivity"


}