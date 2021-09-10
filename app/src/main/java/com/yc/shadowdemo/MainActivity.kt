package com.yc.shadowdemo

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import com.yc.jetpacklib.base.YcBaseActivityPlus
import com.yc.sample_constant.Constant
import com.yc.shadowdemo.databinding.ActivityMainBinding
import com.yc.shadowdemo.plugin.PluginLoadActivity

/**
 * Creator: yc
 * Date: 2021/9/6 20:01
 * UseDes:
 */
class MainActivity : YcBaseActivityPlus<ActivityMainBinding>(ActivityMainBinding::inflate) {
    override fun ActivityMainBinding.initView() {
        start11.setOnClickListener {
            val intent = Intent(this@MainActivity, PluginLoadActivity::class.java)
            intent.putExtra(Constant.KEY_PLUGIN_PART_KEY, Constant.PART_KEY_PLUGIN_11)
            intent.putExtra(Constant.KEY_ACTIVITY_CLASSNAME, "com.yc.plugin1.Plugin1Activity")
            startActivity(intent)
        }
        start12.setOnClickListener {
            val intent = Intent(this@MainActivity, PluginLoadActivity::class.java)
            intent.putExtra(Constant.KEY_PLUGIN_PART_KEY, Constant.PART_KEY_PLUGIN_12)
            intent.putExtra(Constant.KEY_ACTIVITY_CLASSNAME, "com.yc.plugin2.Plugin2Activity")
            startActivity(intent)
        }
//        start21.setOnClickListener {
//            val intent = Intent(this@MainActivity, PluginLoadActivity::class.java)
//            intent.putExtra(Constant.KEY_PLUGIN_PART_KEY, Constant.PART_KEY_PLUGIN_21)
//            intent.putExtra(Constant.KEY_ACTIVITY_CLASSNAME, "com.hc.pluginlabour.ui.auth.LoginActivity")
//            startActivity(intent)
//        }
//        start22.setOnClickListener {
//            val intent = Intent(this@MainActivity, PluginLoadActivity::class.java)
//            intent.putExtra(Constant.KEY_PLUGIN_PART_KEY, Constant.PART_KEY_PLUGIN_22)
//            intent.putExtra(Constant.KEY_ACTIVITY_CLASSNAME, "com.hcc.plugindust.ui.auth.LoginActivity")
//            startActivity(intent)
//        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
                requestPermissions(arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE), 1)
            }
        }
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == 1) {
            for (i in permissions.indices) {
                if (permissions[i] == Manifest.permission.WRITE_EXTERNAL_STORAGE) {
                    if (grantResults[i] != PackageManager.PERMISSION_GRANTED) {
                        throw RuntimeException("必须赋予权限.")
                    }
                }
            }
        }
    }
}