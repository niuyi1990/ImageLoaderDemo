package com.example.niuyi.imageloaderdemo.loader;

import android.content.Context;
import android.widget.ImageView;

import com.example.niuyi.imageloaderdemo.loader.listener.ImageSaveListener;
import com.example.niuyi.imageloaderdemo.loader.listener.ProgressLoadListener;
import com.example.niuyi.imageloaderdemo.loader.listener.SourceReadyListener;

/**
 * User: niuyi(牛毅)
 * Date: 2017-02-13
 * Time: 12:43
 * Desc:
 */
public interface ImageLoaderInterface {

    //无占位图
    void loadImage(String url, ImageView imageView);

    //这里的context指定为ApplicationContext
    void loadImageWithAppCxt(String url, ImageView imageView);

    void loadImage(String url, int placeholder, ImageView imageView);

    void loadImage(Context context, String url, int placeholder, ImageView imageView);

    void loadGifImage(String url, int placeholder, ImageView imageView);

    void loadImageWithProgress(String url, ImageView imageView, ProgressLoadListener listener);

    void loadGifWithPrepareCall(String url, ImageView imageView, SourceReadyListener listener);

    //清除硬盘缓存
    void clearImageDiskCache(final Context context);

    //清除内存缓存
    void clearImageMemoryCache(Context context);

    //根据不同的内存状态，来响应不同的内存释放策略
    void trimMemory(Context context, int level);

    //获取缓存大小
    String getCacheSize(Context context);

    void saveImage(Context context, String url, String savePath, String saveFileName, ImageSaveListener listener);

}
