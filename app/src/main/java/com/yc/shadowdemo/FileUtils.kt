package com.yc.shadowdemo

import android.content.Context
import com.yc.jetpacklib.file.YcFileUtils
import java.io.File
import java.io.FileOutputStream
import java.io.IOException

/**
 * Creator: yc
 * Date: 2021/9/6 20:14
 * UseDes:
 */
object FileUtils {
    @JvmStatic
    fun copyFile(context: Context, assetsFilePath: String?, path: String): File? {
        val file = YcFileUtils.createFile(path)
        try {
            val inputStream = context.assets.open(assetsFilePath!!)
            val fileOutputStream = FileOutputStream(file)
            val buffer = ByteArray(1024)
            var byteRead: Int
            while (-1 != inputStream.read(buffer).also { byteRead = it }) {
                fileOutputStream.write(buffer, 0, byteRead)
            }
            inputStream.close()
            fileOutputStream.flush()
            fileOutputStream.close()
        } catch (e: IOException) {
            e.printStackTrace()
            return null
        }
        return file
    }
}